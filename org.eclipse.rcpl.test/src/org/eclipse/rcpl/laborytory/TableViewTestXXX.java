package org.eclipse.rcpl.laborytory;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TableViewTestXXX extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		primaryStage.setTitle("Hello World");
		Scene scene = new Scene(root, 1700, 1200);

		// zoneTopLeft, spans 2 column
		VBox zoneTopLeft = createBaseContainer();
		// zoneTopRight, spans 2 columns
		VBox zoneTopRight = createBaseContainer();
		// zoneBottomLeft, spans 1 columns
		VBox zoneBottomLeft = createBaseContainer();
		// zoneBottomRight,spans 3 columns
		VBox zoneBottomRight = createBaseContainer();

		ColumnConstraints topRight = new ColumnConstraints();
		topRight.setPrefWidth(300);
		ColumnConstraints topLeft = new ColumnConstraints();
		topRight.setPrefWidth(300);
		ColumnConstraints bottomRight = new ColumnConstraints();
		topRight.setPrefWidth(400);
		ColumnConstraints bottomLeft = new ColumnConstraints();
		topRight.setPrefWidth(200);

		GridPane gridPane = new GridPane();

		gridPane.setGridLinesVisible(true);

		gridPane.getColumnConstraints().addAll(topLeft, topRight, bottomLeft, bottomRight);
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.add(zoneTopLeft, 0, 0);
		gridPane.setColumnSpan(zoneTopLeft, 3);

		gridPane.add(zoneTopRight, 1, 0); // 2,0 for spaning
		// page.setColumnSpan(zoneTopRight,2);
		gridPane.add(zoneBottomLeft, 0, 1);
		// page.setColumnSpan(zoneBottomLeft,1);
		gridPane.add(zoneBottomRight, 1, 1);
		// page.setColumnSpan(zoneBottomRight,3);

		root.getChildren().addAll(gridPane);

		primaryStage.setScene(scene);
		primaryStage.show();

	}

	private VBox createBaseContainer() {
		VBox base = new VBox(); // box
		base.setPrefWidth(250);
		base.setPrefHeight(200);
		base.setStyle("-fx-border-width: 1;-fx-border-color: red");
		// base.prefWidthProperty().bind(scene.widthProperty());

		BorderPane top = new BorderPane(); // top area of base
		top.prefWidthProperty().bind(base.prefWidthProperty());
		top.setPrefHeight(33);
		top.setLeft(setBaseTitle());
		top.setRight(setBaseButtons());
		top.setStyle("-fx-border-width: 1;-fx-border-color: blue");

		StackPane bottom = new StackPane(); // bottom are of base, content keeper

		base.getChildren().addAll(top, bottom);
		return base;
	}

	private Node setBaseButtons() {
		return new HBox();
	}

	private Node setBaseTitle() {

		return new Label();
	}

	public static void main(String[] args) {
		launch(args);
	}
}