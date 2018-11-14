package org.eclipse.rcpl.laborytory;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

public class RcplRowRuler {

	private GridPane grid;

	private final ScrollPane node;

	private RcplTable2 table;

	public RcplRowRuler(RcplTable2 table) {
		this.table = table;

		node = new ScrollPane();
		node.setHbarPolicy(ScrollBarPolicy.NEVER);
		node.setVbarPolicy(ScrollBarPolicy.NEVER);
		node.setPadding(new Insets(0, 0, 16, 0));

		grid = new GridPane();
		grid.setGridLinesVisible(true);
		node.setContent(grid);
		node.setPrefWidth(40);
		node.setMinWidth(40);
		node.setMaxWidth(40);

		node.widthProperty().addListener((observable, oldValue, newValue) -> {
			double h1 = node.getViewportBounds().getHeight();
			double h2 = node.getHeight();
			double w = h2 - h1;
//			node.setPadding(new Insets(0, 0, w, 0));
			System.out.println("w = " + w);
		});

		for (int row = 0; row < table.getRowCount(); row++) {
			StackPane sp = new StackPane();
			sp.setPrefSize(IRcplTableConstants.DEFAULT_ROW_RULER_WIDTH, IRcplTableConstants.DEFAULT_ROW_HEIGHT);
			sp.setMinSize(IRcplTableConstants.DEFAULT_ROW_RULER_WIDTH, IRcplTableConstants.DEFAULT_ROW_HEIGHT);
			sp.setMaxSize(IRcplTableConstants.DEFAULT_ROW_RULER_WIDTH, IRcplTableConstants.DEFAULT_ROW_HEIGHT);
			VBox vbox = new VBox();
			sp.getChildren().add(vbox);
			StackPane.setAlignment(vbox, Pos.BOTTOM_CENTER);
			Label l = new Label();
			l.setTextAlignment(TextAlignment.CENTER);
			l.setAlignment(Pos.CENTER);
			if (table.isSpreadsheet()) {
				l.setText("" + (row + 1));
			}
//			createSizer(vbox);
			vbox.getChildren().add(l);
			grid.add(sp, 0, row);

		}
	}

	private void createSizer(VBox vbox) {
		Pane sizer = new Pane();
		sizer.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				node.setCursor(Cursor.S_RESIZE);
			}
		});

		sizer.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				node.setCursor(Cursor.DEFAULT);
			}
		});

		sizer.setStyle("-fx-border-width: 1;-fx-border-color: gray");
//		sizer.setPrefHeight(2);
//		sizer.setMinHeight(2);
//		sizer.setMaxHeight(2);
		vbox.getChildren().add(sizer);

	}

	public ScrollPane getNode() {
		return node;
	}

}
