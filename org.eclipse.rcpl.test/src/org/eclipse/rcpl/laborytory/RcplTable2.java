package org.eclipse.rcpl.laborytory;

import org.eclipse.rcpl.IParagraph;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

/**
 * @author Ramin
 *
 */
public class RcplTable2 {

	private int rowCount;

	private int columnCount;

	private final boolean spreadsheet;

	private RcplTableView2 tableView;

	private Pane node;

	private boolean header = false;

	public RcplTable2(boolean spreadsheet, boolean header) {
		this.spreadsheet = spreadsheet;
		this.header = header;
		if (spreadsheet) {
			rowCount = IRcplTableConstants.DEFAULT_SPREADSHEET_ROW_COUNT;
			columnCount = IRcplTableConstants.DEFAULT_SPREADSHEET_COLUMN_COUNT;
		} else {
			rowCount = IRcplTableConstants.DEFAULT_ROW_COUNT;
			columnCount = IRcplTableConstants.DEFAULT_COLUMN_COUNT;
		}

		if (spreadsheet) {
			header = true;
		}
		tableView = new RcplTableView2(this);
		node = tableView;
		updateCss();
	}

	protected IParagraph createParagraph() {
		return null;
	}

	public boolean isSpreadsheet() {
		return spreadsheet;
	}

	public void updateCss() {
		if (spreadsheet) {
			node.getStylesheets().add(RcplTable2.class.getResource("rcpltableview_spreadsheet.css").toExternalForm());
		} else {
			node.getStylesheets().add(RcplTable2.class.getResource("rcpltableview.css").toExternalForm());
		}

		tableView.getStyleClass().add("gridStyle_normal");
	}

	public Pane getNode() {
		return node;
	}

	public boolean hasHeader() {
		return header;
	}

	public int getRowCount() {
		return rowCount;
	}

	public int getColumnCount() {
		return columnCount;
	}

	public RcplTableView2 getTableView() {
		return tableView;
	}

	public void addNode(Node n, int row, int column) {
		tableView.getCellTable().getGrid().add(n, column, row);
	}

	public void addParagraph(IParagraph paragraph, int row, int column) {
		addNode(paragraph.getLayoutFigure().getNode(), row, column);
	}

	public void setRowHeight(int row, double height) {
		tableView.getCellTable().getGrid().getRowConstraints().get(row).setPrefHeight(height);
		tableView.getCellTable().getGrid().getRowConstraints().get(row).setMinHeight(height);
		tableView.getCellTable().getGrid().getRowConstraints().get(row).setMaxHeight(height);

		if (tableView.getRowRuler() != null) {
			tableView.getRowRuler().getGrid().getRowConstraints().get(row).setPrefHeight(height);
			tableView.getRowRuler().getGrid().getRowConstraints().get(row).setMinHeight(height);
			tableView.getRowRuler().getGrid().getRowConstraints().get(row).setMaxHeight(height);
		}
	}

	public void setColumnWidth(int column, double width) {
		tableView.getCellTable().getGrid().getColumnConstraints().get(column).setPrefWidth(width);
		tableView.getCellTable().getGrid().getColumnConstraints().get(column).setMinWidth(width);
		tableView.getCellTable().getGrid().getColumnConstraints().get(column).setMaxWidth(width);

		if (tableView.getTableHeader() != null) {
			tableView.getTableHeader().setColumnWidth(column, width);
		}
	}

}
