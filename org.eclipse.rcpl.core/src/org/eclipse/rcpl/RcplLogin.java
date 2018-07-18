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
package org.eclipse.rcpl;

import java.io.IOException;
import java.net.URL;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @author ramin
 *
 */
public class RcplLogin {

	private BorderPane node;

	private RcplLoginController controller;

	IRcplApplicationProvider applicationProvider;

	public static void start(Stage stage) {
		new RcplLogin(stage);
	}

	public static void start(IRcplApplicationProvider applicationProvider) {
		new RcplLogin(applicationProvider);
	}

	/**
	 * @param stage
	 */
	private RcplLogin(Stage stage) {
		this(null, stage);
	}

	/**
	 * @param applicationProvider
	 */
	public RcplLogin(IRcplApplicationProvider applicationProvider) {
		this(applicationProvider, null);
	}

	/**
	 * @param applicationProvider
	 */
	private RcplLogin(IRcplApplicationProvider applicationProvider, Stage stage) {
		this.applicationProvider = applicationProvider;
		URL location = getClass().getResource("/org/eclipse/rcpl/login.fxml");
		FXMLLoader fxmlLoader = new FXMLLoader(location);
		controller = new RcplLoginController(this);
		fxmlLoader.setController(controller);

		try {
			node = (BorderPane) fxmlLoader.load();
			double height = 300;
			node.setPrefHeight(height);
			node.setMinHeight(height);
			node.setMaxHeight(height);
			controller.init();
			double width = 400;
			node.setPrefWidth(width);
			node.setMinWidth(width);
			node.setMaxWidth(width);
			node.setStyle("-fx-background-color: rgba(100, 100, 100, 0.0); -fx-background-radius: 10;");

			if (applicationProvider != null && applicationProvider.isLoginDebug()) {
				Platform.runLater(new Runnable() {

					@Override
					public void run() {
						controller.handleGuest();
					}
				});
			}

			if (applicationProvider == null && stage.getScene() == null) {
				Scene scene = new Scene(getNode());
				scene.getStylesheets().addAll("/css/msoffice.css", "/css/default.css");
				stage.setScene(scene);
				stage.getScene().setFill(Color.TRANSPARENT);
				try {
					stage.initStyle(StageStyle.TRANSPARENT);
				} catch (Throwable ex) {
					// ignore
				}

				stage.centerOnScreen();
				stage.show();
			}

		} catch (

		IOException e) {
			// cannot happen
		}

	}

	public RcplLoginController getController() {
		return controller;
	}

	public void reset() {
		controller.reset();
	}

	// protected void handleRegister() {
	// JOSession.getDefault().userId = getController().getUserID();
	// new JOSession();
	// JOSession.getDefault().requestRegistration(getController().getPassword());
	// getController().displayMessage(
	// "You will receive shortly an E-mail to verify you account. Meanwile you
	// can login the demo account.");
	// getController().collapse2(false);
	// };

	public void enableButtons() {
		controller.enableButtons();
	}

	public BorderPane getNode() {
		return node;
	}

	public IRcplApplicationProvider getApplicationProvider() {
		return applicationProvider;
	}

}