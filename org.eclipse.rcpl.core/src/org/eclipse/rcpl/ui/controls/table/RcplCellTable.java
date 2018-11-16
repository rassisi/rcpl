package org.eclipse.rcpl.ui.controls.table;

import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

/**
 * @author Ramin
 *
 */
public class RcplCellTable {

	private RcplTable table;

	private GridPane grid;

	private Node node;

	private ScrollPane scrollPane;

	public RcplCellTable(RcplTable table) {
		this.table = table;
		this.grid = new GridPane();

		grid.setHgap(0);
		grid.setVgap(0);

//		grid.setGridLinesVisible(true);

		if (table.isSpreadsheet()) {
			scrollPane = new ScrollPane();
			scrollPane.setContent(grid);
			node = scrollPane;
		} else {
			node = grid;
		}

		for (int row = 0; row < this.table.getRowCount(); row++) {
			insertRow();
		}

		for (int column = 0; column < table.getColumnCount(); column++) {
			insertColumn();
		}
	}

	void insertRow() {
		RowConstraints rc = new RowConstraints();
		rc.setPrefHeight(IRcplTableConstants.DEFAULT_ROW_HEIGHT);
		rc.setMinHeight(IRcplTableConstants.DEFAULT_ROW_HEIGHT);
		rc.setMaxHeight(IRcplTableConstants.DEFAULT_ROW_HEIGHT);
		grid.getRowConstraints().add(rc);
	}

	void insertColumn() {
		ColumnConstraints rc = new ColumnConstraints();
		rc.setPrefWidth(IRcplTableConstants.DEFAULT_CELL_WIDTH);
		rc.setMinWidth(IRcplTableConstants.DEFAULT_CELL_WIDTH);
		rc.setMaxWidth(IRcplTableConstants.DEFAULT_CELL_WIDTH);
		grid.getColumnConstraints().add(rc);
	}

	Node getNode() {
		return node;
	}

	ScrollPane getScrollPane() {
		if (table.isSpreadsheet()) {
			return (ScrollPane) node;
		}
		return null;
	}

	GridPane getGrid() {
		return grid;
	}

	void setColumnWidth(int column, double width) {
		grid.getColumnConstraints().get(column).setPrefWidth(width);
		grid.getColumnConstraints().get(column).setMinWidth(width);
		grid.getColumnConstraints().get(column).setMaxWidth(width);
	}

	void setRowheight(int row, double height) {
		grid.getRowConstraints().get(row).setPrefHeight(height);
		grid.getRowConstraints().get(row).setMinHeight(height);
		grid.getRowConstraints().get(row).setMaxHeight(height);
	}

}
