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

import org.eclipse.rcpl.IHomePage;
import org.eclipse.rcpl.IRcplUic;
import org.eclipse.rcpl.model_2_0_0.rcpl.HomePage;
import org.eclipse.rcpl.model_2_0_0.rcpl.HomePageType;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

/**
 * @author ramin
 * 
 */
public class DefaultAboutHomePage extends AbstractHomePage implements IHomePage {

	public DefaultAboutHomePage(IRcplUic uic, HomePage modelHomePage) {
		super(uic, modelHomePage);
		modelHomePage.setType(HomePageType.ABOUT);
	}

	@Override
	protected void doCreateContent(StackPane contentPane) {
		Label l = new Label("(c) Ramin Assisi 2013-2014, support@raminassisi.com");
		l.setAlignment(Pos.CENTER);
		getContentPane().getChildren().add(l);
	}

}
