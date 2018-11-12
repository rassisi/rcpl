package org.eclipse.rcpl.laborytory;

import org.eclipse.rcpl.ICellable;
import org.eclipse.rcpl.IParagraph;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author Ramin
 *
 */
public class RcplTableData {

	private ICellable[][] paragraphArray = new ICellable[RcplTable.MAX_ROWS][RcplTable.MAX_COLUMNS];

	public RcplTableData() {
		for (int row = 0; row < RcplTable.MAX_ROWS; row++) {
			for (int col = 0; col < RcplTable.MAX_COLUMNS; col++) {
				paragraphArray[row][col] = new RcplEmptyCell(row, col);
			}
		}
	}

	public ObservableList<RcplCellRow> getData() {
		ObservableList<RcplCellRow> data = FXCollections.observableArrayList();
		for (int row = 0; row < RcplTable.MAX_ROWS; row++) {
			RcplCellRow rowData = getRowData(row);
			data.add(rowData);
		}
		return data;
	}

	private RcplCellRow getRowData(int row) {
		RcplCellRow rowData = new RcplCellRow();
		for (int col = 0; col < RcplTable.MAX_COLUMNS; col++) {
			rowData.add(paragraphArray[row][col]);
		}
		return rowData;
	}

	public void setParagraph(IParagraph paragraph, int row, int column) {
		paragraphArray[row][column] = paragraph;
		paragraph.setRow(row);
		paragraph.setColumn(column);
	}

}
