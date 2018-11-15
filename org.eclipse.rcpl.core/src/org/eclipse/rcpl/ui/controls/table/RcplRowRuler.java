package org.eclipse.rcpl.ui.controls.table;

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
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

public class RcplRowRuler {

	private GridPane grid;

	private final ScrollPane node;

	private RcplTable table;

	public RcplRowRuler(RcplTable table) {
		this.table = table;

		node = new ScrollPane();
		node.setHbarPolicy(ScrollBarPolicy.NEVER);
		node.setVbarPolicy(ScrollBarPolicy.NEVER);
		node.setPadding(new Insets(0, 0, 16, 0));

		grid = new GridPane();
		grid.setGridLinesVisible(true);
		node.setContent(grid);
		node.setPrefWidth(IRcplTableConstants.DEFAULT_ROW_RULER_WIDTH);
		node.setMinWidth(IRcplTableConstants.DEFAULT_ROW_RULER_WIDTH);
		node.setMaxWidth(IRcplTableConstants.DEFAULT_ROW_RULER_WIDTH);

		for (int row = 0; row < this.table.getRowCount(); row++) {
			StackPane sp = new StackPane();
			sp.setPrefSize(IRcplTableConstants.DEFAULT_ROW_RULER_WIDTH, IRcplTableConstants.DEFAULT_ROW_HEIGHT);
			sp.setMinSize(IRcplTableConstants.DEFAULT_ROW_RULER_WIDTH, IRcplTableConstants.DEFAULT_ROW_HEIGHT);
			sp.setMaxSize(IRcplTableConstants.DEFAULT_ROW_RULER_WIDTH, IRcplTableConstants.DEFAULT_ROW_HEIGHT);
			VBox vbox = new VBox();
			sp.getChildren().add(vbox);
			StackPane.setAlignment(vbox, Pos.BOTTOM_CENTER);
			Label l = new Label();
			l.setPrefSize(IRcplTableConstants.DEFAULT_ROW_RULER_WIDTH, IRcplTableConstants.DEFAULT_ROW_HEIGHT);
			l.setMinSize(IRcplTableConstants.DEFAULT_ROW_RULER_WIDTH, IRcplTableConstants.DEFAULT_ROW_HEIGHT);
			l.setMaxSize(IRcplTableConstants.DEFAULT_ROW_RULER_WIDTH, IRcplTableConstants.DEFAULT_ROW_HEIGHT);
			l.setTextAlignment(TextAlignment.CENTER);
			l.setAlignment(Pos.CENTER);
			if (table.isSpreadsheet()) {
				l.setText("" + (row + 1));
			}
			createSizer(vbox);
			vbox.getChildren().add(l);
			grid.add(sp, 0, row);

			RowConstraints rc = new RowConstraints();
			rc.setPrefHeight(IRcplTableConstants.DEFAULT_ROW_HEIGHT);
			rc.setMinHeight(IRcplTableConstants.DEFAULT_ROW_HEIGHT);
			rc.setMaxHeight(IRcplTableConstants.DEFAULT_ROW_HEIGHT);
			grid.getRowConstraints().add(rc);
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

		sizer.setPrefHeight(5);
		sizer.setMinHeight(5);
		sizer.setMaxHeight(5);
		vbox.getChildren().add(sizer);

	}

	ScrollPane getNode() {
		return node;
	}

	GridPane getGrid() {
		return grid;
	}
}
