package org.eclipse.rcpl.ui.controls.table;

import org.eclipse.rcpl.ICellable;
import org.eclipse.rcpl.IParagraph;

import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * @author Ramin
 *
 */
public abstract class RcplTable {

	public final static double DEFAULT_ROW_HEIGHT = 20;

	private final boolean spreadsheet;

	private RcplTableView tableView;

	private Pane node;

	private RcplTableData data;

	private double width;

	private double height;

	private double[] rowHeight = new double[RcplTableData.MAX_SPREADSHEET_ROWS];

	public RcplTable(boolean spreadsheet) {
		this.spreadsheet = spreadsheet;
		for (int row = 0; row < RcplTableData.MAX_SPREADSHEET_ROWS; row++) {
			rowHeight[row] = DEFAULT_ROW_HEIGHT;
		}
		tableView = new RcplTableView(this);
		if (spreadsheet) {
			setData(new RcplTableData(this));
			tableView.createColumns();
			tableView.getColumns().get(0).setPrefWidth(40);

			StackPane st = new StackPane();
			ScrollPane sp = new ScrollPane();
			st.getChildren().add(sp);
			sp.setFitToHeight(true);
			sp.setFitToWidth(true);
			sp.setContent(tableView);
			node = st;
		} else {
			StackPane sp = new StackPane();
//			sp.setId("redBorder");
			sp.getChildren().add(tableView);
			node = sp;
		}
	}

	public void updateCss(Scene scene) {
		if (spreadsheet) {
			scene.getStylesheets().add(RcplTable.class.getResource("rcpltableview_spreadsheet.css").toExternalForm());
		} else {
			scene.getStylesheets().add(RcplTable.class.getResource("rcpltableview.css").toExternalForm());
		}
	}

	public Pane getNode() {
		return node;
	}

	public void setEditable(boolean editable) {
		tableView.setEditable(editable);
	}

	public void setData(RcplTableData data) {
		this.data = data;
		tableView.setItems(data.getData());
		tableView.createColumns();
		updateHeight();
	}

	public void removeLastColumn() {
		if (!isSpreadsheet()) {
			int size = tableView.getColumns().size();
			tableView.getColumns().remove(size - 1);
		}
	}

	public void setColumnWidth(int col, double width) {
		tableView.getColumns().get(col).setPrefWidth(width);
	}

	public void setRowHeight(int row, double height) {
		ICellable cell = data.getCell(row, 0);
		cell.setHeight(height);
		rowHeight[row] = height;
	}

	public double[] getRowHeightArray() {
		return rowHeight;
	}

	public RcplTableData getData() {
		if (data == null) {
			data = new RcplTableData(this);
		}
		return data;
	}

	public boolean isSpreadsheet() {
		return spreadsheet;
	}

	public void setWidth(double width) {
		this.width = width;
		getNode().setPrefWidth(width);
	}

	public void setHeight(double height) {
		this.height = height;
		getNode().setPrefHeight(height);
		tableView.setMinHeight(height);
		tableView.setPrefHeight(height);
	}

	public double getWidth() {
		return width;
	}

	public double getRowHeight(int row) {
		return rowHeight[row];
	}

	private void updateHeight() {
		if (!isSpreadsheet()) {
			double height = 0;
			for (int row = 0; row < data.getRowCount(); row++) {
				height += getRowHeight(row);
			}

			height += DEFAULT_ROW_HEIGHT + 6; // HEADER
			node.setPrefHeight(height);
			node.setMaxHeight(height);
			tableView.setPrefHeight(height);
			tableView.setMaxHeight(height);
		}
	}

	protected abstract IParagraph createParagraph();

}
