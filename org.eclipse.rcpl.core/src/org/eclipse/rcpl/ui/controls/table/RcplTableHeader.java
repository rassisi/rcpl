package org.eclipse.rcpl.ui.controls.table;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.TextAlignment;

/**
 * @author Ramin
 *
 */
public class RcplTableHeader {

	private GridPane grid;

	private Pane node;

	private RcplTable table;

	private ScrollPane scrollPane;

	private StackPane topLeftPane;

	public RcplTableHeader(RcplTable table) {
		this.table = table;
		node = new HBox();
		node.setPrefHeight(IRcplTableConstants.DEFAULT_ROW_HEIGHT);
		node.setMinHeight(IRcplTableConstants.DEFAULT_ROW_HEIGHT);
		node.setMaxHeight(IRcplTableConstants.DEFAULT_ROW_HEIGHT);

		scrollPane = new ScrollPane();
		scrollPane.setPrefHeight(IRcplTableConstants.DEFAULT_ROW_HEIGHT);
		scrollPane.setMinHeight(IRcplTableConstants.DEFAULT_ROW_HEIGHT);
		scrollPane.setMaxHeight(IRcplTableConstants.DEFAULT_ROW_HEIGHT);
		if (table.isSpreadsheet()) {
			node.setPadding(new Insets(0, 16, 0, 0));
		}
		scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
		scrollPane.setVbarPolicy(ScrollBarPolicy.NEVER);
		grid = new GridPane();
		scrollPane.setContent(grid);

		topLeftPane = new StackPane();
		topLeftPane.setMinWidth(IRcplTableConstants.DEFAULT_ROW_RULER_WIDTH);
		topLeftPane.setPrefWidth(IRcplTableConstants.DEFAULT_ROW_RULER_WIDTH);
		topLeftPane.setMaxWidth(IRcplTableConstants.DEFAULT_ROW_RULER_WIDTH);
		topLeftPane.setStyle("-fx-background-color: lightgray");
		node.getChildren().addAll(topLeftPane, scrollPane);

		createCells();
	}

	private void createCells() {
		for (int column = 0; column < table.getColumnCount(); column++) {
			insertColumn(column);
		}
	}

	void insertColumn() {
		insertColumn(table.getColumnCount() - 1);
	}

	void insertColumn(int column) {
		StackPane sp = new StackPane();
		sp.setPrefSize(IRcplTableConstants.DEFAULT_CELL_WIDTH, IRcplTableConstants.DEFAULT_ROW_HEIGHT);
		sp.setMinSize(IRcplTableConstants.DEFAULT_CELL_WIDTH, IRcplTableConstants.DEFAULT_ROW_HEIGHT);
		HBox hbox = new HBox();
		sp.getChildren().add(hbox);
		Label l = new Label();
		l.setTextAlignment(TextAlignment.CENTER);
		l.setAlignment(Pos.CENTER);
		l.setPrefWidth(100);
		hbox.getChildren().add(l);
		Pane sizer = new Pane();
		sizer.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				node.setCursor(Cursor.E_RESIZE);
			}
		});
		sizer.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				node.setCursor(Cursor.DEFAULT);
			}
		});
		sizer.setPrefWidth(5);
		sizer.setMinWidth(5);
		sizer.setMaxWidth(5);
		hbox.getChildren().add(sizer);
		if (table.isSpreadsheet()) {
			l.setText(RcplTableUtil.calculateColumnName(column));
		}
		grid.add(sp, column, 0);

		ColumnConstraints cc = new ColumnConstraints();
		cc.setPrefWidth(IRcplTableConstants.DEFAULT_CELL_WIDTH);
		cc.setPrefWidth(IRcplTableConstants.DEFAULT_CELL_WIDTH);
		cc.setPrefWidth(IRcplTableConstants.DEFAULT_CELL_WIDTH);
		grid.getColumnConstraints().add(cc);
	}

	void setColumnWidth(int column, double width) {
		grid.getColumnConstraints().get(column).setPrefWidth(width);
		grid.getColumnConstraints().get(column).setMinWidth(width);
		grid.getColumnConstraints().get(column).setMaxWidth(width);
	}

	Pane getNode() {
		return node;
	}

	ScrollPane getScrollPane() {
		return scrollPane;
	}

	GridPane getGrid() {
		return grid;
	}

}
