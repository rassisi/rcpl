package org.eclipse.rcpl.ui.controls.table;

import org.eclipse.rcpl.ICellable;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author Ramin
 *
 */
public class RcplCellRow {

	private final ObservableList<ICellable> rowData = FXCollections.observableArrayList();

	public RcplCellRow() {
	}

	public void add(ICellable cell) {
		rowData.add(cell);
	}

	public ObservableList<ICellable> getRowData() {
		return rowData;
	}

	public ICellable get(int column) {
		if (column < rowData.size()) {
			return rowData.get(column);
		}
		return null;
	}

}
