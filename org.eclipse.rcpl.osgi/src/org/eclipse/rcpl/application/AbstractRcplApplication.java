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

import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.fx.osgi.util.AbstractJFXApplication;
import org.eclipse.rcpl.IRcplApplicationProvider;
import org.eclipse.rcpl.IRcplUic;
import org.eclipse.rcpl.Rcpl;
import org.eclipse.rcpl.model.cdo.client.RcplSession;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author ramin
 * 
 */
public abstract class AbstractRcplApplication extends AbstractJFXApplication
		implements IRcplApplicationProvider {

	protected void jfxStart(IApplicationContext applicationContext,
			Application jfxApplication, Stage stage) {

		Rcpl.UIC = createUIC();

		registerRcplPlugins();

//		new RcplWindowAdvisor(this, getClass().getResource("/css/default.css")
//				.toExternalForm()).start(stage);

	}

	protected abstract IRcplUic createUIC();

	protected abstract void registerRcplPlugins();

	@Override
	protected Object jfxStop() {
		try {
			RcplSession.getDefault().close(true, true);
		} catch (Exception ex) {
			// TODO: ignore: Bug Fix CDO
		}
		return super.jfxStop();
	}
}