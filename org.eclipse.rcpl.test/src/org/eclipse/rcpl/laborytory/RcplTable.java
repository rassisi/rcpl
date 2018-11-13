package org.eclipse.rcpl.laborytory;

import org.eclipse.rcpl.ICellable;

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

	private RcplTableData data;

	public RcplTable(boolean spreadsheet) {
		this.spreadsheet = spreadsheet;
		node = new ScrollPane();
		tableView = new RcplTableView(this, this.spreadsheet);
		node.setFitToHeight(true);
		node.setFitToWidth(true);
		node.setContent(tableView);
		tableView.getColumns().get(0).setPrefWidth(40);
		tableView.setEditable(true);
	}

	public ScrollPane getNode() {
		return node;
	}

	public void setEditable(boolean editable) {
		tableView.setEditable(editable);
	}

	public void setData(RcplTableData data) {
		this.data = data;
		tableView.setItems(data.getData());
	}

	public void setColumnWidth(int col, double width) {
		tableView.getColumns().get(col + 1).setPrefWidth(width);
	}

	public void setRowHeight(int row, double height) {
		ICellable cell = data.getCell(row, 0);
		cell.setHeight(height);
	}

	public RcplTableData getData() {
		return data;
	}

}
