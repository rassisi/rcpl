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
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.rcpl.IApplicationStarter;
import org.eclipse.rcpl.IApplicationWindow;
import org.eclipse.rcpl.IMonitor;
import org.eclipse.rcpl.IRcplAddon;
import org.eclipse.rcpl.IRcplApplicationProvider;
import org.eclipse.rcpl.Rcpl;
import org.eclipse.rcpl.RcplAbstractService;
import org.eclipse.rcpl.impl.RcplMonitor;
import org.eclipse.rcpl.internal.services.RcplService;
import org.eclipse.rcpl.login.RcplLogin;
import org.eclipse.rcpl.model.RCPLModel;
import org.eclipse.rcpl.model.cdo.client.RcplSession;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

/**
 * @author ramin
 *
 */
public class RcplApplicationProvider implements IRcplApplicationProvider {

	private static IApplicationStarter rcplApplicationStarter;

	private boolean LOGIN_DEBUG = false;

	private RcplApplicationWindow applicationWindow;

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

		if (RCPLModel.mobileProvider == null) {
			RCPLModel.mobileProvider = new DefaultMobileProvider();
		}

		for (String arg : args) {

			if (arg.startsWith("-cdo")) {
				String[] splits = arg.split("=");
				if (splits.length == 2) {
					RcplSession.getDefault().CDO_SERVER = splits[1].trim();
				}
			} else if (arg.startsWith("-codebase")) {
				String[] splits = arg.split("=");
				if (splits.length == 2) {
					RcplSession.addAdditionalCodebases(splits[1].trim());
				}
			}
		}

	}

	private boolean started = false;

	private Stage primaryStage;

	private StackPane mainStackPane;

	private StackPane mainContent;

	private StackPane progressGroup;

	private List<String> rcplAddonClassNames = new ArrayList<String>();

	private HashMap<String, IRcplAddon> rcplAddons = new HashMap<String, IRcplAddon>();

	private Application fxApplication;

	private RcplLogin joLogin;

	public RcplApplicationProvider(Application fxApplication) {
		this.fxApplication = fxApplication;
	}

	@Override
	public Application getFxApplication() {
		return fxApplication;
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
	public StackPane getMainContentGroup() {
		return mainContent;
	}

	@Override
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	private IApplicationStarter getRcplApplicationStarter() {
		if (rcplApplicationStarter == null) {

			// first scan all custom application rcpl Addons

			for (IRcplAddon addon : rcplAddons.values()) {
				if (addon.isCustomApplication()) {
					IApplicationStarter applicationStarter = addon.createApplicationStarter(this);
					if (applicationStarter != null) {
						rcplApplicationStarter = applicationStarter;
						return rcplApplicationStarter;
					}
				}
			}

			// now find the built-in application rcpl Addon

			// for (IRcplAddon addon : rcplAddons) {
			// if (!addon.isCustomApplication()) {
			// IApplicationStarter applicationStarter =
			// addon.createApplicationStarter(this);
			// if (applicationStarter != null) {
			// rcplApplicationStarter = applicationStarter;
			// return rcplApplicationStarter;
			// }
			// }
			// }

			return new DefaultApplicationStarter(this);

		}
		return rcplApplicationStarter;
	}

	@Override
	public Collection<IRcplAddon> getRcplAddons() {
		return rcplAddons.values();
	}

	@Override
	public void login() {
		joLogin.getNode().setVisible(false);
		if (!Rcpl.isMobile()) {
			primaryStage.hide();
		}
		Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
		mainContent.getChildren().remove(joLogin.getNode());
		Rcpl.createProgress(progressGroup);
		Rcpl.startProgress(3.0, true);

		if (!Rcpl.isMobile()) {
			primaryStage.setWidth(bounds.getWidth() * 0.8);
			primaryStage.setHeight(bounds.getHeight() * 0.8);
			primaryStage.centerOnScreen();
			primaryStage.getScene().getRoot().setClip(null);
			primaryStage.show();
		}
		Rcpl.progressMessage("Register Addons");
		registerAddons();

		final IApplicationStarter applicationsStarter = getRcplApplicationStarter();
		if (applicationsStarter != null) {
			Rcpl.progressMessage("Application Starter found: " + applicationsStarter.getClass().getSimpleName());

			Platform.runLater(new Runnable() {

				@Override
				public void run() {
					boolean success = applicationsStarter.start(joLogin, primaryStage);
					if (!success) {
						joLogin.getController().setErrorInUserId();
						reStart();
					} else {
						Rcpl.progressMessage(
								"Application " + applicationsStarter.getClass().getSimpleName() + "started");
						joLogin.getController().setHeaderText("RCPL is starting.");
					}
				}
			});

//			final Task<Void> task = new Task<Void>() {
//				@Override
//				public Void call() {
//					boolean success = applicationsStarter.start(joLogin, primaryStage);
//					if (!success) {
//						joLogin.getController().setErrorInUserId();
//						reStart();
//					} else {
//						Rcpl.progressMessage(
//								"Application " + applicationsStarter.getClass().getSimpleName() + "started");
//						joLogin.getController().setHeaderText("RCPL is starting.");
//					}
//					return null;
//				}
//			};
//
//			new Thread(task).start();
		}

	}

	private void registerAddons() {
		for (String addonClass : rcplAddonClassNames) {
			IRcplAddon rcplAddon = createRcplAddon(addonClass);
			if (rcplAddon != null) {
				Rcpl.progressMessage("RcplAddon " + rcplAddon.getDisplayName() + " registered.");
			}
		}
	}

	private IRcplAddon createRcplAddon(String rcplAddonClassName) {
		try {
			Class<?> AddonClass = Class.forName(rcplAddonClassName);
			Object addon = AddonClass.newInstance();
			if (addon instanceof IRcplAddon) {
				IRcplAddon rcplAddon = (IRcplAddon) addon;
				rcplAddons.put(rcplAddonClassName, rcplAddon);
				Rcpl.progressMessage("RCPL - Addon registered: " + rcplAddon.getDisplayName());
				return rcplAddon;
			}
		} catch (InstantiationException e) {
			RCPLModel.logError(e);
		} catch (IllegalAccessException e) {
			RCPLModel.logError(e);
		} catch (ClassNotFoundException e) {
			RCPLModel.logError(e);
		}
		return null;
	}

	@Override
	public void registerRcplAddonClass(String rcplAddonClassName) {
		String className = rcplAddonClassName;
		if (rcplAddonClassName.endsWith(".class")) {
			className = rcplAddonClassName.substring(0, rcplAddonClassName.length() - 6);
		}

		try {
			Class.forName(rcplAddonClassName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		rcplAddonClassNames.add(className);
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
		while (!((Pane) primaryStage.getScene().getRoot()).getChildren().isEmpty()) {
			((Pane) primaryStage.getScene().getRoot()).getChildren().remove(0);
		}
		RcplSession.getDefault().close(true, true);
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
		mainStackPane.setPrefSize(5000, 5000);
		mainContent.setPrefSize(5000, 5000);

		progressGroup = new StackPane();
		progressGroup.setPickOnBounds(false);
		mainStackPane.getChildren().addAll(mainContent, progressGroup);
		mainStackPane.setId("loginPage");

		if (!started) {
			this.primaryStage = primaryStage;
			Map<String, String> map = fxApplication.getParameters().getNamed();
			for (String key : map.keySet()) {
				if ("cdo".equals(key)) {
					RcplSession.getDefault().CDO_SERVER = map.get(key);
					// JO.log("CDO Server: " + JOSession.CDO_SERVER);
				}
			}
		}

		joLogin = new RcplLogin(this);
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
		RCPLModel.log(this, "Screen bounds: " + bounds.getWidth() + "/" + bounds.getHeight());
		primaryStage.setScene(new Scene(mainStackPane));
		primaryStage.getScene().getStylesheets().addAll(
				RcplApplicationProvider.class.getResource("/css/default.css").toExternalForm(),
				RcplApplicationProvider.class.getResource("/css/msoffice.css").toExternalForm());

		primaryStage.setWidth(bounds.getWidth());
		primaryStage.setHeight(bounds.getHeight());
		primaryStage.setX(0);
		primaryStage.setY(0);
		mainStackPane.layout();
		primaryStage.show();
	}

	private void startPc() {
		Rcpl.progressMessage("Start Desktop Application");

		applicationWindow = new RcplApplicationWindow(primaryStage, mainStackPane);
		applicationWindow.getStylesheets().addAll("skin/undecorator.css", "/css/msoffice.css", "/css/default.css"); // ,

		Scene scene = new Scene(applicationWindow);
		applicationWindow.installAccelerators(scene);
		applicationWindow.setFadeInTransition();

		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent we) {
				we.consume(); // Do not hide
				applicationWindow.setFadeOutTransition();
			}
		});

//		scene.setFill(Color.TRANSPARENT);
		try {
			primaryStage.initStyle(StageStyle.TRANSPARENT);
		} catch (Throwable ex) {
			// ignore
		}

		primaryStage.setScene(scene);
		setSimpleDialog();

		double loginWidth = joLogin.getNode().getPrefWidth();
		double loginHeight = joLogin.getNode().getPrefHeight();

		primaryStage.setWidth(loginWidth);
		primaryStage.setHeight(loginHeight);
		primaryStage.centerOnScreen();

		applicationWindow.setStyle("-fx-background-color: rgba(100, 100, 100, 0.0); -fx-background-radius: 5;");
		mainStackPane.setStyle("-fx-background-radius: 10;");

		primaryStage.toFront();

	}

	@Override
	public IRcplAddon findRcplAddon(String className) {
		return rcplAddons.get(className);
	}

	@Override
	public IRcplAddon findRcplAddon(Class<? extends IRcplAddon> pl) {
		for (IRcplAddon p : rcplAddons.values()) {

			for (Class<?> inf : p.getClass().getInterfaces()) {
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

}
