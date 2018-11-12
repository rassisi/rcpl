package org.eclipse.rcpl.laborytory;

import javafx.collections.ObservableList;
import javafx.scene.control.ScrollPane;

/**
 * @author Ramin
 *
 */
public class RcplTable {

	private boolean spreadsheet;

	private RcplTableView tableView;

	private ScrollPane node;

	private int numberOfColumns = 10;

	public RcplTable(boolean spreadsheet) {
		this.spreadsheet = spreadsheet;
		node = new ScrollPane();
		tableView = new RcplTableView(this, this.spreadsheet);
		node.setContent(tableView);
	}

	public ScrollPane getNode() {
		return node;
	}

	public void setEditable(boolean editable) {
		tableView.setEditable(editable);
	}

	void setItems(ObservableList<RcplParagraphRow> items) {
		tableView.setItems(items);
	}

	public int getNumberOfColumns() {
		return numberOfColumns;
	}

	public void setNumberOfColumns(int numberOfColumns) {
		this.numberOfColumns = numberOfColumns;
	}

	public void setColumnWidth(int col, double width) {
		tableView.getColumns().get(col).setPrefWidth(width);
	}

}
