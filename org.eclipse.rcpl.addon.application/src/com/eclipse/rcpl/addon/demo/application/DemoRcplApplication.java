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
package com.eclipse.rcpl.addon.demo.application;

import org.eclipse.rcpl.IRcplApplicationProvider;
import org.eclipse.rcpl.application.RcplApplication;
import org.eclipse.rcpl.application.RcplApplicationProvider;
import org.eclipse.rcpl.model.RCPLModel;

/**
 * @author ramin
 *
 */
public class DemoRcplApplication extends RcplApplication {

	public static void main(String[] args) {
		RcplApplicationProvider.init(args);
		launch(args);
	}

	@Override
	protected IRcplApplicationProvider createApplicationProvider() {
		return new RcplApplicationProvider(this);
	}

	@Override
	protected boolean isMobile() {
		return false;
	}

	@Override
	protected String[] getRcplAddonClassNames() {
		return new String[] { "com.eclipse.rcpl.addon.demo.application.DemoRcplAddon",
				"org.eclipse.rcpl.navigator.tree.parts.DefaultNavigatorAddon" };
	}

	@Override
	protected Class<? extends RCPLModel> getRcplModel() {
		return DemoRcplModel.class;
	}

	@Override
	protected String getXmiName() {
		return "demorcpl";
	}

	@Override
	protected String[] getAdditionalImageCodeBases() {
		return null;
	}
}
