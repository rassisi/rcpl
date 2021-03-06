package org.eclipse.rcpl.ui.controls.table;

import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

/**
 * @author Ramin
 *
 */
public class RcplTableView extends BorderPane {

	private RcplTable table;

	private GridPane grid;

	private RcplCellTable cellTable;

	private RcplTableHeader tableHeader;

	private RcplRowRuler rowRuler;

	public RcplTableView(RcplTable table) {
		this.table = table;

		cellTable = new RcplCellTable(table);
		BorderPane.setAlignment(cellTable.getNode(), Pos.TOP_LEFT);
		setCenter(cellTable.getNode());

		if (this.table.isSpreadsheet()) {
			cellTable.getGrid().setStyle("-fx-background-color: lightgray;");
			tableHeader = new RcplTableHeader(table);
			tableHeader.getScrollPane().hvalueProperty().bind(cellTable.getScrollPane().hvalueProperty());
			setTop(tableHeader.getNode());
		}

		if (table.isSpreadsheet()) {
			rowRuler = new RcplRowRuler(table);
			rowRuler.getNode().vvalueProperty().bind(cellTable.getScrollPane().vvalueProperty());
			setLeft(rowRuler.getNode());
		}

	}

	GridPane getGrid() {
		return grid;
	}

	RcplCellTable getCellTable() {
		return cellTable;
	}

	RcplTableHeader getTableHeader() {
		return tableHeader;
	}

	RcplRowRuler getRowRuler() {
		return rowRuler;
	}

	void insertColumn() {
		cellTable.insertColumn();
		if (tableHeader != null) {
			tableHeader.insertColumn();
		}
	}

	void insertRow() {
		cellTable.insertRow();
		if (rowRuler != null) {
			rowRuler.insertRow();
		}
	}

	void updateColumnNumber() {

	}
}
