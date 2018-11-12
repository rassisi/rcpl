package org.eclipse.rcpl.laborytory;

import org.eclipse.rcpl.IParagraph;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author Ramin
 *
 */
public class RcplParagraphRow {

	private final ObservableList<IParagraph> rowData = FXCollections.observableArrayList();

	public RcplParagraphRow(RcplTable table) {

	}

	public void add(IParagraph paragraph) {
		rowData.add(paragraph);
	}

	public ObservableList<IParagraph> getRowData() {
		return rowData;
	}

	public IParagraph get(int column) {
		if (column < rowData.size()) {
			return rowData.get(column);
		}
		return null;
	}

}
