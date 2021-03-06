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

import org.eclipse.rcpl.IDocument;
import org.eclipse.rcpl.IRcplUic;
import org.eclipse.rcpl.model_2_0_0.rcpl.HomePage;
import org.eclipse.rcpl.model_2_0_0.rcpl.HomePageType;

import javafx.scene.Node;
import javafx.scene.layout.StackPane;

/**
 * @author ramin
 *
 */
public class DefaultOverviewHomePage extends AbstractHomePage {

	private IDocument document = null;

	private StackPane detailsArea;

	/**
	 * @param uic
	 * @param title
	 * @param image
	 */
	public DefaultOverviewHomePage(IRcplUic uic, HomePage modelHomePage) {
		super(uic, modelHomePage);
		modelHomePage.setType(HomePageType.OVERVIEW);
	}

	@Override
	protected void doCreateContent(StackPane contentPane) {

	}

	@Override
	public Node getNode() {
		super.getNode().setUserData(this);
		return super.getNode();
	}

	public IDocument getDocument() {
		return document;
	}

}
