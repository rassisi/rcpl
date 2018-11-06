/*******************************************************************************
 * Copyright (c) 2003 - 2014 Ramin Assisi and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     Ramin Assisi - initial implementation
 *******************************************************************************/
package org.eclipse.rcpl.application;

import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.rcpl.IApplicationStarter;
import org.eclipse.rcpl.IApplicationWindow;
import org.eclipse.rcpl.ILogin;
import org.eclipse.rcpl.IMonitor;
import org.eclipse.rcpl.IRcplAddon;
import org.eclipse.rcpl.IRcplApplicationProvider;
import org.eclipse.rcpl.IRcplFactory;
import org.eclipse.rcpl.IServiceFactory;
import org.eclipse.rcpl.IToolFactory;
import org.eclipse.rcpl.Rcpl;
import org.eclipse.rcpl.impl.RcplMonitor;
import org.eclipse.rcpl.internal.services.RcplService;
import org.eclipse.rcpl.model.EnKeyValue;
import org.eclipse.rcpl.model.RcplModel;
import org.eclipse.rcpl.model.client.RcplSession;
import org.eclipse.rcpl.model_2_0_0.rcpl.Addon;
import org.eclipse.rcpl.model_2_0_0.rcpl.RCPL;
import org.eclipse.rcpl.service.RcplAbstractService;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

/**
 * @author ramin
 *
 */
public abstract class AbstractApplicationProvider implements IRcplApplicationProvider {

	private boolean LOGIN_DEBUG = false;

	private RcplApplicationWindow applicationWindow;

	private double loginWindowX = -1;
	private double loginWindowY = -1;

	public static void init(String[] args) {

		// BasicService basicService = null;
		// try {
		// try {
		// basicService = (BasicService)
		// ServiceManager.lookup("javax.jnlp.BasicService");
		// JOSession.LAUNCHED_BY_JNLP = true;
		// } catch (UnavailableServiceException e) {
		// JOSession.LAUNCHED_BY_JNLP = false;
		// }
		//
		// if (basicService != null) {
		// JOSession.codeBase = basicService.getCodeBase().toString();
		//
		// } else {
		// // JO. log("codeBase not determined");
		// }
		// } catch (Exception ex) {
		// // ignore
		// }

	}

	private boolean started = false;

	private Stage primaryStage;

	private StackPane mainStackPane;

	private StackPane mainContent;

	private StackPane progressGroup;

	private HashMap<String, IRcplAddon> rcplAddons = new HashMap<String, IRcplAddon>();

	private AbstractRcplApplication rcplApplication;

	private ILogin joLogin;

	public AbstractApplicationProvider(AbstractRcplApplication rcplApplication) {
		this.rcplApplication = rcplApplication;
		Rcpl.setFactory(createRcplFactory());
		Rcpl.setToolFactory(createToolFactory());
		Rcpl.setServiceFactory(createServiceFactory());
	}

	@Override
	public Application getFxApplication() {
		return rcplApplication;
	}

	@Override
	public void bindAddonsToModel() {
		for (IRcplAddon addon : rcplAddons.values()) {
			try {
				addon.bindToModel();
			} catch (Exception e) {
				Rcpl.progressMessage(e.getMessage());
			}
		}
	}

	@Override
	public StackPane getMainContent() {
		return mainContent;
	}

	@Override
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	private IApplicationStarter getRcplApplicationStarter() {
		return rcplApplication.getApplicationStarter();
	}

	@Override
	public Collection<IRcplAddon> getRcplAddons() {
		return rcplAddons.values();
	}

	@Override
	public void login() {

		loginWindowX = primaryStage.getX();
		loginWindowY = primaryStage.getY();

		joLogin.getNode().setVisible(false);
		if (!Rcpl.isMobile()) {
			primaryStage.hide();
		}
		mainContent.getChildren().remove(joLogin.getNode());
		Rcpl.createProgress(progressGroup);
		Rcpl.startProgress(3.0, true);

		Rcpl.progressMessage("Register Addons");

		final IApplicationStarter applicationsStarter = getRcplApplicationStarter();
		if (applicationsStarter != null) {
			boolean success = applicationsStarter.start(joLogin, primaryStage);
			if (!success) {
				joLogin.getController().setErrorInUserId();
				reStart();
			} else {
				registerAddons();
				Rcpl.progressMessage("Application " + applicationsStarter.getClass().getSimpleName() + "started");
				joLogin.getController().setHeaderText("RCPL is starting.");

			}

		}

	}

	private void registerAddons() {
		RCPL rcpl = RcplSession.getDefault().getRcpl();
		if (rcpl != null) {
			if (rcpl.getAllAddons() != null) {
				for (Addon addon : rcpl.getAllAddons().getChildren()) {
					try {
						if (addon.getClassName() != null) {
							IRcplAddon rcplAddon = createRcplAddon(addon);
							if (rcplAddon != null) {
								Rcpl.progressMessage("RcplAddon " + rcplAddon.getDisplayName() + " registered.");
							}
						}
					} catch (Throwable ex) {
						Rcpl.printErrorln("", ex);
					}
				}
			}
		}
	}

	private IRcplAddon createRcplAddon(Addon model) {
		try {
			Class<?> AddonClass = Class.forName(model.getClassName());
			Object addon = AddonClass.newInstance();
			if (addon instanceof IRcplAddon) {
				IRcplAddon rcplAddon = (IRcplAddon) addon;
				rcplAddon.setModel(model);
				rcplAddons.put(model.getClassName(), rcplAddon);
				Rcpl.progressMessage("RCPL - Addon registered: " + rcplAddon.getDisplayName());
				return rcplAddon;
			}
		} catch (InstantiationException e) {
			RcplModel.logError(e);
		} catch (IllegalAccessException e) {
			RcplModel.logError(e);
		} catch (ClassNotFoundException e) {
			RcplModel.logError(e);
		}
		return null;
	}

	@Override
	public void registerService(Class<? extends RcplService> serviceClass) {
		RcplAbstractService.registerService(serviceClass);
	}

	protected URL resolve(URL url) {
		return url;
	}

	@Override
	public void reStart() {
		RcplSession.getDefault().close(true, true);
		Rcpl.UIC.getTopToolBar().clear();
		Rcpl.UIC.getSideToolBarControl().clear();

		while (!((Pane) primaryStage.getScene().getRoot()).getChildren().isEmpty()) {
			((Pane) primaryStage.getScene().getRoot()).getChildren().remove(0);
		}
		start(primaryStage);
	}

	private void calculateMonitors() {
		int index = 0;
		for (Screen s : Screen.getScreens()) {
			IMonitor m = new RcplMonitor(s, index++);
			Rcpl.monitors.put(s, m);
		}
	}

	@Override
	public void start(final Stage primaryStage) {
		primaryStage.hide();
		this.primaryStage = primaryStage;
		Rcpl.rcplApplicationProvider = this;
		calculateMonitors();
		mainStackPane = new StackPane();
		mainContent = new StackPane();
		StackPane.setMargin(mainContent, new Insets(5, 0, 0, 0));
		progressGroup = new StackPane();
		progressGroup.setPickOnBounds(false);
		mainStackPane.getChildren().addAll(mainContent, progressGroup);
		mainStackPane.setId("loginPage");

		if (!started) {
			this.primaryStage = primaryStage;
			Map<String, String> map = rcplApplication.getParameters().getNamed();
			for (String key : map.keySet()) {
				if ("cdo".equals(key)) {
					RcplSession.getDefault().setCDOServer(map.get(key));
					// JO.log("CDO Server: " + JOSession.CDO_SERVER);
				}
			}
		}

		joLogin = Rcpl.getFactory().createLoginDialog(this);
		if (Rcpl.isMobile()) {
			StackPane.setAlignment(joLogin.getNode(), Pos.TOP_CENTER);
		}
		mainContent.getChildren().add(joLogin.getNode());

		// ---------------------------------------------------------

		if (Rcpl.isMobile()) {
			startMobile();
		}

		else {
			startPc();
		}

		Scene scene = getPrimaryStage().getScene();
		scene.getStylesheets().addAll("/css/theme_login.css");

		getApplicationWindow().fadeIn(0.5);

		double initialStageX = Rcpl.get(EnKeyValue.LOGIN_WINDOW_X, -1.0);
		double initialStageY = Rcpl.get(EnKeyValue.LOGIN_WINDOW_Y, -1.0);

		if (initialStageX > Rcpl.getActualMonitor().getPixelWidth() - 100) {
			initialStageX = Rcpl.getActualMonitor().getPixelWidth() - 101;
		}
		if (initialStageY > Rcpl.getActualMonitor().getHeight() - 100) {
			initialStageY = Rcpl.getActualMonitor().getHeight() - 101;
		}

		if (primaryStage != null) {
			if (initialStageX == -1) {
				primaryStage.centerOnScreen();
			} else {
				primaryStage.setX(initialStageX);
				primaryStage.setY(initialStageY);
			}
		}

		primaryStage.show();
		started = true;
		mainStackPane.layout();
	}

	@Override
	public void setLoginDebug() {
		LOGIN_DEBUG = true;
	}

	@Override
	public boolean isLoginDebug() {
		return LOGIN_DEBUG;
	}

	private void startMobile() {
		Rcpl.progressMessage("Start Mobile Application");
		Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
		RcplModel.log(this, "Screen bounds: " + bounds.getWidth() + "/" + bounds.getHeight());
		primaryStage.setScene(new Scene(mainStackPane));
		primaryStage.setWidth(bounds.getWidth());
		primaryStage.setHeight(bounds.getHeight());
		primaryStage.setX(0);
		primaryStage.setY(0);
		mainStackPane.layout();
		primaryStage.show();
	}

	private void startPc() {
		Rcpl.progressMessage("Start Desktop Application");

		applicationWindow = new RcplApplicationWindow(this, mainStackPane);
		applicationWindow.resetStyles();

		Scene scene = new Scene(applicationWindow);
		applicationWindow.installAccelerators(scene);
		applicationWindow.fadeIn(0.5);

		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent we) {
				we.consume(); // Do not hide
				applicationWindow.fadeOut(3.0);
				if (Rcpl.UIC != null) {
					Rcpl.UIC.closeApplication();
				}
			}
		});

		scene.setFill(Color.TRANSPARENT);
		try {
			primaryStage.initStyle(StageStyle.TRANSPARENT);
		} catch (Throwable ex) {
			// ignore
		}

		primaryStage.setScene(scene);
		setSimpleDialog();

		applicationWindow.setStyle("-fx-background-color: rgba(100, 100, 100, 0.0); -fx-background-radius: 5;");
		mainStackPane.setStyle("-fx-background-radius: 10;");

	}

	@Override
	public IRcplAddon findRcplAddon(String className) {
		return rcplAddons.get(className);
	}

	@Override
	public IRcplAddon findRcplAddon(Class<? extends IRcplAddon> pl) {
		for (IRcplAddon p : rcplAddons.values()) {

			Class<?>[] interfaces = p.getClass().getInterfaces();
			for (Class<?> inf : interfaces) {
				if (inf.getName().equals(pl.getName())) {
					return p;
				}
			}

		}
		return null;
	}

	@Override
	public void setMainStackPane(StackPane mainStackPane) {
		this.mainStackPane = mainStackPane;
	}

	@Override
	public StackPane getMainApplicationStack() {
		return mainStackPane;
	}

	public RcplApplicationWindow getUndecorator() {
		return applicationWindow;
	}

	@Override
	public IApplicationWindow getApplicationWindow() {
		return applicationWindow;
	}

	@Override
	public void setResizable(boolean resizable) {
		primaryStage.setResizable(resizable);
		applicationWindow.setResizable(resizable);
	}

	@Override
	public void setMinimizable(boolean minimizable) {
		applicationWindow.setMinimizable(minimizable);
	}

	@Override
	public void setMaximizable(boolean maximizable) {
		applicationWindow.setMaximizable(maximizable);
	}

	@Override
	public void setFullscreenAble(boolean fullscreenAble) {
		applicationWindow.setFullscreenAble(fullscreenAble);
	}

	@Override
	public void setSimpleDialog() {
		setResizable(false);
		setMinimizable(false);
		setMaximizable(false);
		setFullscreenAble(false);
	}

	@Override
	public void setNormalWindow() {
		setResizable(true);
		setMinimizable(true);
		setMaximizable(true);
		setFullscreenAble(true);
	}

	@Override
	public void setSize(double width, double height) {
		applicationWindow.setPrefSize(width, height);
		primaryStage.setWidth(width + 30);
		primaryStage.setHeight(height + 76);
	}

	@Override
	public void centerWindow() {
		primaryStage.centerOnScreen();
	}

	@Override
	public abstract String getName();

	@Override
	abstract public String getImage();

	protected abstract IToolFactory createToolFactory();

	protected abstract IRcplFactory createRcplFactory();

	protected abstract IServiceFactory createServiceFactory();

	@Override
	public double getLoginWindowX() {
		return loginWindowX;
	}

	@Override
	public double getLoginWindowY() {
		return loginWindowY;
	}

}
