package org.eclipse.rcpl.ui.controls.table2;

import org.eclipse.rcpl.IParagraph;
import org.eclipse.rcpl.ui.controls.table.RcplTableUtil;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Labeled;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

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
		StackPane backGroundPane = createBackgroundPane(row, column);
		backGroundPane.getChildren().clear();
		backGroundPane.getChildren().add(n);
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

	private StackPane createBackgroundPane(int row, int column) {
		Node n = RcplTableUtil.getNode(row, column, tableView.getCellTable().getGrid());
		if (n == null) {
			n = new StackPane();
			n.setStyle("-fx-background-color: white;");
			tableView.getCellTable().getGrid().add(n, column, row);
		}
		return (StackPane) n;
	}

	public void setColumnSpan(int row, int column, int spanX) {
		Node n = createBackgroundPane(row, column);
		GridPane.setColumnSpan(n, spanX);
	}

	public void setRowSpan(int row, int column, int spanY) {
		Node n = createBackgroundPane(row, column);
		GridPane.setRowSpan(n, spanY);
	}

	public void setCellAlignment(int row, int column, Pos pos) {
		Node n = createBackgroundPane(row, column);
		if (n instanceof Labeled) {
			((Labeled) n).setAlignment(pos);
		}
	}

	public void setStyle(int row, int column, String style) {
		StackPane backGroundPane = createBackgroundPane(row, column);
		backGroundPane.setStyle(style);
	}

	public void setWidth(double width) {
		getNode().setPrefWidth(width);
	}

	public void setHeight(double height) {
		getNode().setPrefHeight(height);
	}

}
