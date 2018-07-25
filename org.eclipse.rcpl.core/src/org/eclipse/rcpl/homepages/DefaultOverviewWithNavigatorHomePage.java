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

import org.eclipse.rcpl.INavigatorAddon;
import org.eclipse.rcpl.IRcplUic;
import org.eclipse.rcpl.Rcpl;
import org.eclipse.rcpl.model_2_0_0.rcpl.HomePage;
import org.eclipse.rcpl.model_2_0_0.rcpl.HomePageType;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * @author ramin
 *
 */
public class DefaultOverviewWithNavigatorHomePage extends DefaultOverviewHomePage {

	private StackPane detailsArea;

	/**
	 * @param uic
	 * @param title
	 * @param image
	 */
	public DefaultOverviewWithNavigatorHomePage(IRcplUic uic, HomePage modelHomePage) {
		super(uic, modelHomePage);
	}

	@Override
	protected void doCreateContent(StackPane contentPane) {
		SplitPane splitPane = new SplitPane();
		getContentPane().getChildren().add(splitPane);

		INavigatorAddon navigatorAddon = Rcpl.UIC.getNavigator(null);

		if (navigatorAddon != null) {
			Node n = navigatorAddon.createPart(detailsArea, null, false).getNode();
			if (n != null) {
				splitPane.getItems().add(n);
			}
		}

		detailsArea = new StackPane();
		splitPane.getItems().add(detailsArea);
		splitPane.setDividerPositions(0.3f);

		uic.getTopToolBar().showPerspective(null);

		if (!Rcpl.isMobile()) {
			showSplash(1);
		}

		if (Rcpl.isMobile()) {
			VBox vBox = new VBox();
			vBox.setSpacing(5);

			vBox.setSpacing(5);
			Button b = new Button("New");
			b.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					uic.showHomePage(HomePageType.NEW);
				}
			});
			b.setPrefWidth(100);
			vBox.getChildren().add(b);

			b = new Button("Samples");
			b.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					uic.showHomePage(HomePageType.SAMPLES);
				}
			});
			b.setPrefWidth(100);
			vBox.getChildren().add(b);

//			setDetailNode(vBox);

		}

	}

}