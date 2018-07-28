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
package org.eclipse.rcpl.homepages;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcpl.IRcplUic;
import org.eclipse.rcpl.model.client.RcplSession;
import org.eclipse.rcpl.model_2_0_0.rcpl.HomePage;
import org.eclipse.rcpl.model_2_0_0.rcpl.HomePageType;

import javafx.scene.layout.StackPane;

/**
 * @author ramin
 *
 */
public class DefaultToolsEditorHomePage extends AbstractNavigatorHomePage {

	/**
	 * @param uic
	 * @param title
	 * @param image
	 */
	public DefaultToolsEditorHomePage(IRcplUic uic, HomePage modelHomePage) {
		super(uic, modelHomePage);
	}

	@Override
	public HomePageType getId() {
		return HomePageType.TOOLS_EDITOR;
	}

	@Override
	protected EObject getRoot() {
		return RcplSession.getDefault().getRcpl().getAllTools(); // getAllPerspectives();
	}

	@Override
	protected void doCreateContent(StackPane contentPane) {
		super.doCreateContent(contentPane);
	}

}
