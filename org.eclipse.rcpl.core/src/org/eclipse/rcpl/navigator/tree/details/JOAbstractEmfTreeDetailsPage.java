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

package org.eclipse.rcpl.navigator.tree.details;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcpl.IRcplUic;
import org.eclipse.rcpl.homepages.AbstractHomePage;
import org.eclipse.rcpl.model_2_0_0.rcpl.HomePage;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * @author ramin
 *
 */
public abstract class JOAbstractEmfTreeDetailsPage extends AbstractHomePage {

	private GridPane detailsPane;

	public JOAbstractEmfTreeDetailsPage(IRcplUic uic, HomePage modelHomePage, Pane pane) {
		super(uic, modelHomePage, pane);
		createDetailsPane();
	}

	@Override
	protected void doCreateContent(StackPane contentPane) {
		detailsPane = new GridPane();
		contentPane.getChildren().add(detailsPane);
	}

	protected abstract void createDetailsPane();

	public abstract EObject getRoot();

}
