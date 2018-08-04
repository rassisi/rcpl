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
import org.eclipse.rcpl.model.RCPLModel;
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
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;

/**
 * @author ramin
 */
public abstract class AbstractHomePage implements IHomePage {

	private VBox vBox;

	protected IRcplUic uic;

	private int row = 0;

	private final HomePage model;

	private StackPane contentPane;

	private static FlowPane homeButtonsPane;

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

			header.setPrefHeight(HOMEPAGE_HEADER_HEIGHT);
			header.setMinHeight(HOMEPAGE_HEADER_HEIGHT);
			header.setMaxHeight(HOMEPAGE_HEADER_HEIGHT);

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

//			header.setId("homeHeader"); 
			header.setStyle("-fx-background-color: white");

			// ---------- header text

			StackPane textContainer = new StackPane();
			textContainer.setEffect(new InnerShadow());
			TextFlow headerText = new TextFlow();
			StackPane.setMargin(headerText, new Insets(3));
			vBox.setEffect(new InnerShadow());
			InnerShadow is = new InnerShadow();
			is.setOffsetX(2.0f);
			is.setOffsetY(2.0f);
			Text t = new Text(modelHomePage.getName().substring(0, 1).toUpperCase());
			headerText.getChildren().add(t);
			t.setCache(true);
			t.setFont(Font.font(null, FontWeight.NORMAL, 24));
			t.setId("homeHeaderText");
			t.setEffect(is);
			t = new Text(modelHomePage.getName().substring(1).toUpperCase());
			headerText.getChildren().add(t);
			t.setCache(true);
			t.setFont(Font.font(null, FontWeight.NORMAL, 18));
			t.setId("homeHeaderText");
			t.setEffect(is);
			headerText.textAlignmentProperty().setValue(TextAlignment.LEFT);
			headerText.layout();
			headerText.setMaxHeight(28);
			headerText.setMinWidth(150);
			textContainer.getChildren().add(headerText);
			header.getChildren().add(textContainer);

			// ---------- header home buttons

			if (homeButtonsPane == null) {
				homeButtonsPane = new FlowPane();
				homeButtonsPane.setVgap(5);
				homeButtonsPane.setAlignment(Pos.CENTER_LEFT);
				Rcpl.UIC.createAllHomeButtons(homeButtonsPane);
				homeButtonsPane.setHgap(5);
				homeButtonsPane.setPrefWrapLength(1000);
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
			}
		} else if (header.getChildren().contains(homeButtonsPane)) {
			if (header.getChildren().contains(homeButtonsPane)) {
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
		showHomeButtons();
	}

	@Override
	public HomePage getModel() {
		return model;
	}

	/**
	 * @param imageIndex
	 */
	protected void showSplash(int imageIndex) {

		if (homeImages == null) {
			return;
		}
		try {
			int randomImageIndex;

			if (imageIndex >= 0) {
				randomImageIndex = imageIndex;
			} else {

				randomImageIndex = (int) (Math.random() * homeImages.length);

			}

			String mediaUrl = homeImages[randomImageIndex];
			if (mediaUrl.indexOf("youtube") != -1) {

				Media media = new Media(mediaUrl);
				javafx.scene.media.MediaPlayer mediaPlayer = new javafx.scene.media.MediaPlayer(media);
				internalMediaPlay.setAutoPlay(true);
				internalMediaView = new MediaView();
				internalMediaView.setMediaPlayer(mediaPlayer);
				internalMediaView.setVisible(true);

				// internalHomeWebView.setVisible(false);
				// // homeWebView.getEngine().load(mediaUrl);
				// internalHomeImageView.setVisible(false);

			} else {
				// homeWebView.setVisible(false);
				// mediaView.setVisible(false);
//				Image image = new Image(mediaUrl);
				// homeImageView.setImage(image);

//				detailPane.setBackground(new Background(new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
//						BackgroundRepeat.NO_REPEAT, new BackgroundPosition(Side.LEFT, 0, false, Side.TOP, 0, false),
//						new BackgroundSize(10, 10, true, true, false, true))));
//				// homeImageView.setFitWidth(homeStackPane.getWidth() -
//				// 100);
//				// homeImageView.setVisible(false);
//
//				if (Rcpl.isMobile()) {
//					detailPane.setOnSwipeLeft(new EventHandler<SwipeEvent>() {
//
//						@Override
//						public void handle(SwipeEvent event) {
//							uic.showErrorPage();
//						}
//					});
//				} else {
//					detailPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
//
//						@Override
//						public void handle(MouseEvent event) {
//							uic.showErrorPage();
//						}
//					});
//				}

			}
		} catch (Exception ex) {
			RCPLModel.logError(ex);
		}
	}

	private MediaPlayer internalMediaPlay;

	protected MediaView internalMediaView;

	String[] homeImages = new String[] {

			"http://apod.nasa.gov/apod/image/1308/skylab_nasa_960.jpg",

			"http://apod.nasa.gov/apod/image/1308/skylab_nasa_960.jpg",

			// //
			// "http://www.youtube.com/watch?v=FG0fTKAqZ5g&feature=player_embedded#t=72",
			//
			// "http://apod.nasa.gov/apod/image/0806/M51HST-GendlerS_800.jpg",
			//
			// //
			// "http://apod.nasa.gov/apod/image/1312/horsehead_chumack_1800.jpg",
			//
			// "http://apod.nasa.gov/apod/image/1401/cubesats_iss038_960.jpg",
			//
			// //
			// "http://apod.nasa.gov/apod/image/1401/iss013e49644clevels.jpg",
			//
			// "http://apod.nasa.gov/apod/image/1312/mandelbox077_leys_960.jpg",
			//
			// "http://apod.nasa.gov/apod/image/1312/p1769716276metsavainio950c.jpg",
			//
			// "http://apod.nasa.gov/apod/image/1310/orionwisps_colombari_960.jpg",
			//
			// "http://apod.nasa.gov/apod/image/1310/carina_fenyes_960.jpg",
			//
			// "http://apod.nasa.gov/apod/image/1308/ngc3370_hst_900.jpg",
			//
			// "http://apod.nasa.gov/apod/image/1307/ngc6384_hst_1265.jpg",
			//
			// "http://apod.nasa.gov/apod/image/1305/richat_aster_960.jpg",
			//
			// "http://apod.nasa.gov/apod/image/1304/NGC1788_davis950.jpg",

	};

}
