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
import org.eclipse.rcpl.model.EnKeyValue;

import javafx.application.Platform;
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

	/**
	 * @param rcplApplicationProvider
	 * @param cssStyleSheetResource
	 */
	public RcplWindowAdvisor(IRcplApplicationProvider rcplApplicationProvider) {
		this.applicationProvider = rcplApplicationProvider;
	}

	/**
	 * @param stage
	 */
	@Override
	public void start() {

		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				if (Rcpl.get(EnKeyValue.WINDOW_WIDTH) == null) {
					List<Screen> screens = Screen.getScreensForRectangle(100, 100, 100, 100);
					Rectangle2D bounds = screens.get(0).getVisualBounds();
					applicationProvider.getPrimaryStage().setWidth(bounds.getWidth() * 0.75);
					applicationProvider.getPrimaryStage().setHeight(bounds.getHeight() * 0.75);
					applicationProvider.getPrimaryStage().centerOnScreen();
					initialStageX = applicationProvider.getPrimaryStage().getX();
					initialStageY = applicationProvider.getPrimaryStage().getY();
					Rcpl.set(EnKeyValue.WINDOW_X, initialStageX);
					Rcpl.set(EnKeyValue.WINDOW_Y, initialStageY);

				} else {
					applicationProvider.getPrimaryStage().setWidth(Rcpl.get(EnKeyValue.WINDOW_WIDTH, 1000.0));
					applicationProvider.getPrimaryStage().setHeight(Rcpl.get(EnKeyValue.WINDOW_HEIGHT, 800.0));
					initialStageX = Rcpl.get(EnKeyValue.WINDOW_X, -1.0);
					initialStageY = Rcpl.get(EnKeyValue.WINDOW_Y, -1.0);

					if (initialStageX > Rcpl.get().getActualMonitor().getPixelWidth() - 100) {
						initialStageX = Rcpl.get().getActualMonitor().getPixelWidth() - 101;
					}
					if (initialStageY > Rcpl.get().getActualMonitor().getHeight() - 100) {
						initialStageY = Rcpl.get().getActualMonitor().getHeight() - 101;
					}

					applicationProvider.getPrimaryStage().setX(initialStageX);
					applicationProvider.getPrimaryStage().setY(initialStageY);
				}

//				applicationProvider.getApplicationWindow().fadeIn(2.0);
				applicationProvider.getPrimaryStage().show();

				Rcpl.get().progressMessage("Init Addons");
				for (IRcplAddon uc : applicationProvider.getRcplAddons()) {
					uc.init();
				}
				Rcpl.get().progressMessage("Configure Top Area");
				StackPane stackPane = applicationProvider.getMainContent();
				stackPane.getChildren().clear();
				Rcpl.UIC().addtoApplicationStack(applicationProvider.getMainContent());
				Rcpl.get().progressMessage("RcplWindowAdviser.start()#end");
				Rcpl.get().showProgress(false);
			}
		});

		addKeyListener();
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

	protected void handleOk() {

	}

}
