package org.eclipse.rcpl.laborytory;

import org.eclipse.rcpl.ui.controls.table.RcplTableUtil;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.input.MouseEvent;
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

	private ScrollPane node;

	private RcplTable2 table;

	public RcplTableHeader(RcplTable2 table) {
		this.table = table;
		node = new ScrollPane();
		if (table.isSpreadsheet()) {
			node.setPadding(new Insets(0, 16, 0, IRcplTableConstants.DEFAULT_ROW_RULER_WIDTH));
		}
		node.setHbarPolicy(ScrollBarPolicy.NEVER);
		node.setVbarPolicy(ScrollBarPolicy.NEVER);
		grid = new GridPane();
		node.setContent(grid);
		node.setPrefHeight(IRcplTableConstants.DEFAULT_ROW_HEIGHT);
		node.setMinHeight(IRcplTableConstants.DEFAULT_ROW_HEIGHT);
		node.setMaxHeight(IRcplTableConstants.DEFAULT_ROW_HEIGHT);
		createCells();
	}

	private void createCells() {
		for (int column = 0; column < table.getColumnCount(); column++) {
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

			sizer.setStyle("-fx-border-width: 1;-fx-border-color: gray");
			sizer.setPrefWidth(2);
			sizer.setMinWidth(2);
			sizer.setMaxWidth(2);
			hbox.getChildren().add(sizer);
			if (table.isSpreadsheet()) {
				l.setText(RcplTableUtil.calculateColumnName(column));
			}
			grid.add(sp, column, 0);
		}
	}

	public ScrollPane getNode() {
		return node;
	}

}
