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

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @web http://zoranpavlovic.blogspot.com/
 */
public class RcplLoginTest extends Application {

	String user = "JavaFX2";
	String pw = "password";
	String checkUser, checkPw;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		RcplLogin.start(primaryStage);
	}
}