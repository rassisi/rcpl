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
import org.eclipse.rcpl.IRcplUic;
import org.eclipse.rcpl.ITreePart;
import org.eclipse.rcpl.Rcpl;
import org.eclipse.rcpl.model_2_0_0.rcpl.HomePage;

import javafx.scene.control.SplitPane;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;

/**
 * @author ramin
 *
 */
public abstract class AbstractNavigatorHomePage extends AbstractHomePage {

	private StackPane detailsArea;

	private SplitPane splitPane;

	private StackPane treeViewPane;

	/**
	 * @param uic
	 * @param title
	 * @param image
	 */
	public AbstractNavigatorHomePage(IRcplUic uic, HomePage modelHomePage) {
		super(uic, modelHomePage);
	}

	@Override
	protected void doCreateContent(StackPane contentPane) {
		treeViewPane = new StackPane();

		splitPane = new SplitPane();
		getContentPane().getChildren().add(splitPane);
		splitPane.getItems().add(treeViewPane);
		detailsArea = new StackPane();
		splitPane.getItems().add(detailsArea);
		splitPane.setDividerPositions(0.3f);
		uic.getTopToolBar().showPerspective(null);

		if (!Rcpl.get().isMobile())

		{
			showSplash(1);
		}

		refresh();
	}

	public StackPane getDetailsArea() {
		return detailsArea;
	}

	protected abstract EObject getRoot();

	@Override
	public void refresh() {

		super.refresh();
		ITreePart treePart = getTreePart();
		treePart.setContainer(detailsArea);
		TreeView<Object> tv = (TreeView<Object>) treePart.getNode();
		if (tv != null) {
			treeViewPane.getChildren().clear();
			treeViewPane.getChildren().add(tv);
		}
		getTreePart().setRoot(getRoot());
		treePart.getNode().requestFocus();
	}

	protected ITreePart getTreePart() {
		return Rcpl.UIC().getRcplTreepart();
	}

}
