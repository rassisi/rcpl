package org.eclipse.rcpl.components;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {

		Group root = new Group();
		Group objectLayer = new Group();
		Group selectionLayer = new Group();

		Group bgLayer = new Group();

		root.getChildren().addAll(bgLayer, objectLayer, selectionLayer);

		RcplResizablePane sampleNode2 = new RcplResizablePane(null, bgLayer, selectionLayer);

		sampleNode2.getChildren().add(new Label("I'm a StackPane"));
		sampleNode2.setStyle("-fx-background-color: lightblue");
		sampleNode2.setPrefHeight(100);
		sampleNode2.setPrefWidth(200);
		sampleNode2.relocate(600, 300);

		objectLayer.getChildren().addAll(sampleNode2);

		Scene scene = new Scene(root, 1600, 900);
		scene.setOnMousePressed(mouseEvent -> sampleNode2.clear());

		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}