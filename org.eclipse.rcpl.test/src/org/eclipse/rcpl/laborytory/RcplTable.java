package org.eclipse.rcpl.laborytory;

import javafx.collections.ObservableList;
import javafx.scene.control.ScrollPane;

/**
 * @author Ramin
 *
 */
public class RcplTable {

	public final static int MAX_COLUMNS = 1000;

	public final static int MAX_ROWS = 1000;

	private boolean spreadsheet;

	private RcplTableView tableView;

	private ScrollPane node;

	public RcplTable(boolean spreadsheet) {
		this.spreadsheet = spreadsheet;
		node = new ScrollPane();
		tableView = new RcplTableView(this, this.spreadsheet);
		node.setFitToHeight(true);
		node.setFitToWidth(true);
		node.setContent(tableView);
	}

	public ScrollPane getNode() {
		return node;
	}

	public void setEditable(boolean editable) {
		tableView.setEditable(editable);
	}

	void setItems(ObservableList<RcplCellRow> items) {
		tableView.setItems(items);
	}

	public void setColumnWidth(int col, double width) {
		tableView.getColumns().get(col).setPrefWidth(width);
	}

}
