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
import javafx.scene.control.SplitPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.MediaView;

/**
 * @author ramin
 *
 */
public class DefaultPreferencesHomePage extends AbstractHomePage {

	private IDocument document = null;

	private StackPane contentPane;

	protected MediaView internalMediaView;

	private BorderPane borderPane;

	/**
	 * @param uic
	 * @param title
	 * @param image
	 */
	public DefaultPreferencesHomePage(IRcplUic uic, HomePage modelHomePage) {
		super(uic, modelHomePage);

	}

	/**
	 * @param detailNode
	 */
	@Override
	public void setDetailNode(Node detailNode) {
		borderPane.setCenter(detailNode);
		borderPane.layout();
	}

	public void hideSplash() {
		borderPane.setBackground(null);
	}

	public IDocument getDocument() {
		return document;
	}

	@Override
	public HomePageType getId() {
		return HomePageType.PREFERENCES;
	}

	@Override
	protected void doCreateContent(StackPane contentPane) {
		// !!! 1
//		EObject root = JOSession.INSTANCE.getUserPreferences().getPreferenceGroup();
//		EEmfTreeTreePart part = new EEmfPreferencesTreePart(null, root, true) {
//			protected void doSelection() {
//				if (getSelectedObject() instanceof Preferences) {
//					Preferences prefs = (Preferences) getSelectedObject();
//					JOPreferencesDetails d = new JOPreferencesDetails(prefs);
//					borderPane.setCenter(d.getNode());
//				}
//			};
//		};
//		((TreeView<?>) part.getNode()).setPrefSize(100, 100);
		SplitPane splitPane = new SplitPane();
//		splitPane.getItems().add(part.getNode());
		borderPane = new BorderPane();
		splitPane.getItems().add(borderPane);
		splitPane.setDividerPositions(0.3f, 0.7f);
		contentPane.getChildren().add(splitPane);
	}

}
