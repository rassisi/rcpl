package org.eclipse.rcpl.ui.controls.table2;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

/**
 * @author Ramin
 *
 */
public class RcplTableView2 extends BorderPane {

	private RcplTable2 table;

	private GridPane grid;

	private RcplCellTable cellTable;

	private RcplTableHeader tableHeader;

	private RcplRowRuler rowRuler;

	public RcplTableView2(RcplTable2 table) {
		this.table = table;

		cellTable = new RcplCellTable(table);
		setCenter(cellTable.getNode());

		if (this.table.isSpreadsheet()) {
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

}
