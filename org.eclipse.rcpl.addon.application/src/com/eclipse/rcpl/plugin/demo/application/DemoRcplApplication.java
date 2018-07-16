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
package com.eclipse.rcpl.plugin.demo.application;

import org.eclipse.rcpl.Rcpl;
import org.eclipse.rcpl.application.RcplApplicationProvider;
import org.eclipse.rcpl.model.RCPLModel;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author ramin
 *
 */
public class DemoRcplApplication extends Application {

	public static void main(String[] args) {
		RcplApplicationProvider.init(args);
		launch(args);
	}

	@Override
	public void start(final Stage primaryStage) {

		Rcpl.rcplApplicationProvider = new RcplApplicationProvider(this);
		Rcpl.setMobile(false);
		RCPLModel.modelClass = JOModel.class;
		RCPLModel.XMIName = "demorcpl";
		Rcpl.rcplApplicationProvider.registerRcplAddonClass("com.eclipse.rcpl.plugin.demo.application.DemoPlugin");
		Rcpl.rcplApplicationProvider
				.registerRcplAddonClass("org.eclipse.rcpl.navigator.tree.parts.DefaultNavigatorPlugin");

		Rcpl.rcplApplicationProvider.start(primaryStage);
	}
}
