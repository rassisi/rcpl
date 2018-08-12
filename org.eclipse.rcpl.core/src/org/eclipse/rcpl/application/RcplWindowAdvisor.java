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

import java.util.List;

import org.eclipse.rcpl.IRcplAddon;
import org.eclipse.rcpl.IRcplApplicationProvider;
import org.eclipse.rcpl.IWindowAdvisor;
import org.eclipse.rcpl.Rcpl;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;

/**
 * @author Ramin Assisi
 * 
 */
public class RcplWindowAdvisor implements IWindowAdvisor {

	boolean startMenu;

	double lastMinWidth = 0;
	double lastMaxWidth = 0;

	double maxWidth = 0;

	private double initialStageX;
	private double initialStageY;

	private IRcplApplicationProvider applicationProvider;
	private String cssStyleSheetResource;

	/**
	 * @param rcplApplicationProvider
	 * @param cssStyleSheetResource
	 */
	public RcplWindowAdvisor(IRcplApplicationProvider rcplApplicationProvider, String cssStyleSheetResource) {
		this.applicationProvider = rcplApplicationProvider;
		this.cssStyleSheetResource = cssStyleSheetResource;
	}

	/**
	 * @param stage
	 */
	@Override
	public void start() {

		// ---------- PREFERENCES ------------------------------------

		String xs = "0";
		String ys = "0";

//		try {
//			xs = RcplSession.getDefault().getSystemPreferences().getString(RcplKey.STAGE_X);
//			ys = RcplSession.getDefault().getSystemPreferences().getString(RcplKey.STAGE_Y);
//		} catch (Exception ex) {
//			Rcpl.progressMessage(ex);
//		}
		double maxWidth = 0;

		ObservableList<Screen> screens = Screen.getScreens();
		for (Screen screen : screens) {
			maxWidth += screen.getBounds().getWidth();
		}

		if (xs != null && ys != null) {
			try {
				initialStageX = Double.valueOf(xs);
				initialStageY = Double.valueOf(ys);
				if (initialStageX > (maxWidth - 300)) {
					initialStageX = -1;
				}
			} catch (Exception ex) {
				// ignore
			}
		}

//		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				createMainWindow();
			}
		});

	}

	private void createMainWindow() {
//		applicationProvider.getPrimaryStage().setWidth(1000);
//		applicationProvider.getPrimaryStage().setHeight(800);

		List<Screen> screens = Screen.getScreensForRectangle(100, 100, 100, 100);

		Rectangle2D bounds = screens.get(0).getVisualBounds();

		applicationProvider.getPrimaryStage().setWidth(bounds.getWidth() * 0.75);
		applicationProvider.getPrimaryStage().setHeight(bounds.getHeight() * 0.75);

		applicationProvider.getPrimaryStage().centerOnScreen();
		applicationProvider.getPrimaryStage().show();
		Rcpl.progressMessage("RCPL.createMainWindow()");
		Rcpl.progressMessage("Init Addons");
		for (IRcplAddon uc : applicationProvider.getRcplAddons()) {
			uc.init();
		}
		Rcpl.progressMessage("Configure Top Area");
		Rcpl.UIC.expandTopAra(true);
		StackPane stackPane = applicationProvider.getMainContent();
		stackPane.getChildren().clear();
		Rcpl.UIC.addtoApplicationStack(applicationProvider.getMainContent());
		Rcpl.progressMessage("OfficeRCP.createMainWindow()#2");
		Rcpl.showProgress(false);

	}

	@Override
	public void openMainWindow() {
		applicationProvider.getPrimaryStage().centerOnScreen();
		applicationProvider.getPrimaryStage().setTitle("RCPL");
		if (initialStageX <= 0) {
			applicationProvider.getPrimaryStage().centerOnScreen();
		} else {
			applicationProvider.getPrimaryStage().setX(initialStageX);
			applicationProvider.getPrimaryStage().setY(initialStageY);
		}
		Rcpl.progressMessage("Create Default Theme");
		Rcpl.UIC.handleThemeDefault(null);
		addKeyListener();
		Rcpl.progressMessage("OfficeRCP.createMainWindow()#3");
	}

	private EventHandler<KeyEvent> keyhandler = null;

	private void addKeyListener() {
		if (keyhandler == null) {
			keyhandler = new EventHandler<KeyEvent>() {

				@Override
				public void handle(KeyEvent event) {
//					if (event.isControlDown()) {
//						if (event.getText().equals("x") && event.isShiftDown()) {
//							Rcpl.UIC.showPerspective(RCPLModel.USE_CASE_IT_ID, false);
//							event.consume();
//							return;
//						}
//					}
				}
			};
		}
		applicationProvider.getPrimaryStage().getScene().setOnKeyPressed(keyhandler);
	}

	// private void applyStyle(final Stage stage, final String style) {
	// final Scene scene = stage.getScene();
	// removeAllStyles(stage);
	// scene.getStylesheets().add(style);
	// }

//	private void removeAllStyles(Stage stage) {
//		if (Rcpl.UIC.getStylesRegistry() != null) {
//			for (String style : Rcpl.UIC.getStylesRegistry()) {
//				stage.getScene().getStylesheets().remove(style);
//			}
//		}
//	}

	protected void handleOk() {

	}

	public String getCssStyleSheetResource() {
		return cssStyleSheetResource;
	}

}
