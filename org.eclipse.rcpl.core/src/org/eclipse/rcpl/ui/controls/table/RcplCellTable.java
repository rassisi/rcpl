package org.eclipse.rcpl.ui.controls.table;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
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

		grid.setGridLinesVisible(table.isDEBUG());

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

	public GridPane getGrid() {
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

	public void setOverflow(int row) {
		table.setOverflowTable(new RcplCellTable(table));
		for (int newR = 0, r = row; r < table.getRowCount(); r++, newR++) {
			for (int col = 0; col < table.getColumnCount(); col++) {
				Pane p = table.getBackgroundPane(r, col);
				if (p != null) {
					table.addNode(table.getOverflowTable().getGrid(), p, newR, col);
					if (p != null) {
						p.setStyle("-fx-border-color: red;");
					}
				}
			}
		}

		ObservableList<RowConstraints> rc = table.getTableView().getCellTable().getGrid().getRowConstraints();
		while (rc.size() > row) {
			rc.remove(rc.size() - 1);
			System.out.println();
		}
	}

}
