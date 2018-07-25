/*******************************************************************************
 * Copyright (c) 2003 - 2018 Ramin Assisi and others.
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
import org.eclipse.rcpl.INavigatorAddon;
import org.eclipse.rcpl.IRcplUic;
import org.eclipse.rcpl.Rcpl;
import org.eclipse.rcpl.model_2_0_0.rcpl.HomePage;

import javafx.scene.Node;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.StackPane;

/**
 * @author ramin
 *
 */
public abstract class AbstractNavigatorHomePage extends AbstractHomePage {

	private final StackPane detailsArea;

	private final INavigatorAddon navigatorAddon;

	/**
	 * @param uic
	 * @param title
	 * @param image
	 */
	public AbstractNavigatorHomePage(IRcplUic uic, HomePage modelHomePage) {
		super(uic, modelHomePage);
		SplitPane splitPane = new SplitPane();
		getContentPane().getChildren().add(splitPane);
		detailsArea = new StackPane();

		navigatorAddon = Rcpl.UIC.getNavigator(null);

		if (navigatorAddon != null) {
			Node n = navigatorAddon.createPart(detailsArea, null, false).getNode();
			if (n != null) {
				splitPane.getItems().add(n);
			}
			navigatorAddon.setRoot(getRoot());
		}

		splitPane.getItems().add(detailsArea);
		splitPane.setDividerPositions(0.3f);

		uic.getTopToolBar().showPerspective(null);

		if (!Rcpl.isMobile()) {
			showSplash(1);
		}
	}

	public INavigatorAddon getNavigatorAddon() {
		return navigatorAddon;
	}

	public StackPane getDetailsArea() {
		return detailsArea;
	}

	protected abstract EObject getRoot();
}
