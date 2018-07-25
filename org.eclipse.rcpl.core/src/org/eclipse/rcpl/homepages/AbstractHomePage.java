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
import org.eclipse.rcpl.Rcpl;
import org.eclipse.rcpl.model_2_0_0.rcpl.HomePage;
import org.eclipse.rcpl.model_2_0_0.rcpl.HomePageType;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Separator;
import javafx.scene.effect.InnerShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.SwipeEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;

/**
 * @author ramin
 * 
 */
public abstract class AbstractHomePage implements IHomePage {

	private VBox vBox;

	protected IRcplUic uic;

	private int row = 0;

	private final HomePage model;

	private StackPane contentPane;

	private static HBox homeButtonsPane;

	private HBox header;

	/**
	 * @param uic
	 * @param modelHomePage
	 */
	public AbstractHomePage(final IRcplUic uic, HomePage modelHomePage) {
		this.uic = uic;
		this.model = modelHomePage;

		vBox = new VBox();

		vBox.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				uic.showErrorPage();
			}
		});

		vBox.setOnSwipeLeft(new EventHandler<SwipeEvent>() {

			@Override
			public void handle(SwipeEvent event) {
				uic.showHomePage(HomePageType.OVERVIEW);
			}
		});

		// if (!Rcpl.isMobile())
		{
			// ---------- header container

			header = new HBox();
			header.setSpacing(20);
			header.setPrefHeight(80);
			header.setAlignment(Pos.CENTER_LEFT);
			int headerHeight = 80;
			header.setPrefHeight(headerHeight);
			header.setMinHeight(headerHeight);
			header.setMaxHeight(headerHeight);

			header.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					Rcpl.UIC.expandAllToolBars();
				}
			});

			// ---------- header image

			String imageName = "error";
			if (modelHomePage.getImage() != null) {
				imageName = modelHomePage.getImage();
			}
			StackPane sp = new StackPane();
			sp.setPrefSize(32, 32);
			sp.setMinSize(32, 32);
			sp.setMaxSize(32, 32);

			Node imageView = Rcpl.resources().getImage(imageName, 32, 32).getNode();
			if (imageView != null) {
				sp.getChildren().add(imageView);
				HBox.setMargin(sp, new Insets(0, 0, 0, 20));
			}
			header.getChildren().add(sp);

			header.setId("homeHeader"); // Style("-fx-background-color: white");

			// ---------- header text

			TextFlow headerText = new TextFlow();
			vBox.setEffect(new InnerShadow());
			InnerShadow is = new InnerShadow();
			is.setOffsetX(2.0f);
			is.setOffsetY(2.0f);
			Text t = new Text(modelHomePage.getName().substring(0, 1).toUpperCase());
			headerText.getChildren().add(t);
			t.setCache(true);
			t.setFont(Font.font(null, FontWeight.NORMAL, 28));
			t.setId("homeHeaderText");
			t.setEffect(is);
			t = new Text(modelHomePage.getName().substring(1).toUpperCase());
			headerText.getChildren().add(t);
			t.setCache(true);
			t.setFont(Font.font(null, FontWeight.NORMAL, 20));
			t.setId("homeHeaderText");
			t.setEffect(is);

			headerText.textAlignmentProperty().setValue(TextAlignment.CENTER);
			headerText.layout();

			headerText.setMaxHeight(28);
			headerText.setMinWidth(300);
			header.getChildren().add(headerText);

			// ---------- header home buttons

			if (homeButtonsPane == null) {
				homeButtonsPane = new HBox();
				homeButtonsPane.setSpacing(20);
				homeButtonsPane.setAlignment(Pos.CENTER_LEFT);
				Rcpl.UIC.createAllHomeButtons(homeButtonsPane);
			}

			vBox.getChildren().add(header);
		}

		// ---------- SEPARATOR --------------------------------------

		Separator separator = new Separator(Orientation.HORIZONTAL);
		vBox.getChildren().add(separator);

		// ---------- CONTENT PANE -----------------------------------

		contentPane = new StackPane();
		contentPane.setId("homePageContentPane");
		vBox.getChildren().add(contentPane);
		VBox.setVgrow(contentPane, Priority.ALWAYS);

		doCreateContent(contentPane);
		vBox.layout();
//		vBox.setId("redBorder");

	}

	@Override
	public Node getNode() {
		vBox.setUserData(this);
		return vBox;
	}

	protected abstract void doCreateContent(StackPane contentPane);

	@Override
	public void showHomeButtons() {
		if (getModel().isShowHomePageButtons()) {
			if (!header.getChildren().contains(homeButtonsPane)) {
				header.getChildren().add(homeButtonsPane);
			} else if (header.getChildren().contains(homeButtonsPane)) {
				header.getChildren().remove(homeButtonsPane);

			}

		}
	}

	@Override
	public StackPane getContentPane() {
		return contentPane;
	}

	@Override
	public int getRow() {
		return row;
	}

	@Override
	public void refresh() {
	}

	@Override
	public void setDetailNode(Node node) {
		getContentPane().getChildren().add(node);
	}

	@Override
	public String toString() {
		return "Home Page: " + getId();
	}

	@Override
	public HomePage getModel() {
		return model;
	}

}
