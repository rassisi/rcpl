package org.eclipse.rcpl.ui.controls.table;

import org.eclipse.rcpl.IParagraph;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Labeled;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * @author Ramin
 *
 */
public class RcplTable {

	private int rowCount;

	private int columnCount;

	private final boolean spreadsheet;

	private RcplTableView tableView;

	private Pane node;

	private boolean header = false;

	public RcplTable(boolean spreadsheet, boolean header) {
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
		tableView = new RcplTableView(this);
		node = tableView;
		updateCss();
	}

	private double getTotalHeight() {
		double totalHeight = 0;
		for (int i = 0; i < rowCount; i++) {
			totalHeight += tableView.getCellTable().getGrid().getRowConstraints().get(i).getPrefHeight();
		}
		return totalHeight;
	}

	protected IParagraph createParagraph() {
		return new SimpleParagraph("");
	}

	public boolean isSpreadsheet() {
		return spreadsheet;
	}

	public void updateCss() {
		if (spreadsheet) {
			node.getStylesheets().add(RcplTable.class.getResource("rcpltableview_spreadsheet.css").toExternalForm());
		} else {
			node.getStylesheets().add(RcplTable.class.getResource("rcpltableview.css").toExternalForm());
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

	public RcplTableView getTableView() {
		return tableView;
	}

	public void addNode(Node n, int row, int column) {
		updateRowAndColumnCount(row, column);
		VBox backGroundPane = createBackgroundPane(row, column);
		backGroundPane.setAlignment(Pos.CENTER);
		if (!backGroundPane.getChildren().contains(n)) {
			backGroundPane.getChildren().add(n);
		}
	}

	public void addParagraph(IParagraph paragraph, int row, int column) {
		addNode(paragraph.getLayoutFigure().getNode(), row, column);
	}

	public void setRowHeight(int row, double height) {
		updateRowAndColumnCount(row, -1);
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
		updateRowAndColumnCount(-1, column);
		tableView.getCellTable().getGrid().getColumnConstraints().get(column).setPrefWidth(width);
		tableView.getCellTable().getGrid().getColumnConstraints().get(column).setMinWidth(width);
		tableView.getCellTable().getGrid().getColumnConstraints().get(column).setMaxWidth(width);

		if (tableView.getTableHeader() != null) {
			tableView.getTableHeader().setColumnWidth(column, width);
		}
	}

	private VBox createBackgroundPane(int row, int column) {
		updateRowAndColumnCount(row, column);
		Node n = RcplTableUtil.getNode(row, column, tableView.getCellTable().getGrid());
		if (n == null) {
			VBox st = new VBox();
			st.setAlignment(Pos.TOP_LEFT);
			n = st;
//			n.setStyle("-fx-border-color: blue;-fx-border-width: 0.1pt;");
			tableView.getCellTable().getGrid().add(n, column, row);
		}
		return (VBox) n;
	}

	public void setColumnSpan(int row, int column, int spanX) {
		updateRowAndColumnCount(row, column);
		Node n = createBackgroundPane(row, column);
		GridPane.setColumnSpan(n, spanX);
	}

	public void setRowSpan(int row, int column, int spanY) {
		updateRowAndColumnCount(row, column);
		Node n = createBackgroundPane(row, column);
		GridPane.setRowSpan(n, spanY);
	}

	public void setCellAlignment(int row, int column, Pos pos) {
		updateRowAndColumnCount(row, column);
		Node n = createBackgroundPane(row, column);
		if (n instanceof Labeled) {
			((Labeled) n).setAlignment(pos);
		}
	}

	public void setStyle(int row, int column, String style) {
		updateRowAndColumnCount(row, column);
		VBox backGroundPane = createBackgroundPane(row, column);
		backGroundPane.setStyle(style);
	}

	public void setWidth(double width) {
		getNode().setPrefWidth(width);
		getNode().setMinWidth(width);
		getNode().setMaxWidth(width);
	}

	public void setHeight(double height) {
		getNode().setPrefHeight(height);
		getNode().setMinHeight(height);
		getNode().setMaxHeight(height);
	}

	private void updateRowAndColumnCount(int row, int column) {
		if (column != -1 && column >= columnCount) {
			int extraColumns = column - columnCount + 1;
			for (int i = 0; i < extraColumns; i++) {
				insertColumn();
			}
		}
		if (row != -1 && row >= rowCount) {
			int extraRows = row - rowCount + 1;
			for (int i = 0; i < extraRows; i++) {
				insertRow();
			}

			double height = getTotalHeight();
			getNode().setPrefHeight(height);
			getNode().setMinHeight(height);
			getNode().setMaxHeight(height);

		}
	}

	public void insertColumn() {
		columnCount++;
		tableView.insertColumn();
	}

	public void insertRow() {
		rowCount++;
		tableView.insertRow();
	}

	public void setCellWidth(int row, int column, double width) {
		updateRowAndColumnCount(-1, column);
		double columnWidth = getColumnWidth(column);
		if (width > columnWidth) {
			setColumnWidth(column, width);
			VBox st = createBackgroundPane(row, column);
			st.setPrefWidth(width);
			st.setMinWidth(width);
			st.setMaxWidth(width);
		}
	}

	public void setCellHeight(int row, int column, double height) {
		updateRowAndColumnCount(row, -1);
		double rowHeight = getRowHeight(row);
		if (height > rowHeight) {
			setRowHeight(row, height);
			for (int c = 0; c < columnCount; c++) {
				VBox st = createBackgroundPane(row, c);
				st.setPrefHeight(height);
				st.setMinHeight(height);
				st.setMaxHeight(height);
				st.setLayoutX(0);
				st.setLayoutY(0);
			}
		}
	}

	public double getColumnWidth(int column) {
		return tableView.getCellTable().getGrid().getColumnConstraints().get(column).getPrefWidth();
	}

	public double getRowHeight(int row) {
		return tableView.getCellTable().getGrid().getRowConstraints().get(row).getPrefHeight();
	}

	public void setMarginTop(int row, int column, double margin) {
		updateRowAndColumnCount(row, column);
		VBox backGroundPane = createBackgroundPane(row, column);
		Node n = getFirstChildInCell(backGroundPane);
		if (n == null) {
			return;
		}
		Insets ins = VBox.getMargin(n);
		if (ins == null) {
			ins = new Insets(0);
		}
		VBox.setMargin(backGroundPane.getChildren().get(0),
				new Insets(margin, ins.getRight(), ins.getBottom(), ins.getLeft()));
	}

	public void setMarginBottom(int row, int column, double margin) {
		updateRowAndColumnCount(row, column);
		VBox backGroundPane = createBackgroundPane(row, column);
		Node n = getLastChildInCell(backGroundPane);
		if (n == null) {
			return;
		}
		Insets ins = VBox.getMargin(n);
		if (ins == null) {
			ins = new Insets(0);
		}
		VBox.setMargin(n, new Insets(ins.getTop(), ins.getRight(), margin, ins.getLeft()));
	}

	public void setMarginLeft(int row, int column, double margin) {
		updateRowAndColumnCount(row, column);
		VBox backGroundPane = createBackgroundPane(row, column);
		for (Node n : backGroundPane.getChildren()) {
			Insets ins = VBox.getMargin(n);
			if (ins == null) {
				ins = new Insets(0);
			}
			VBox.setMargin(n, new Insets(ins.getTop(), ins.getRight(), ins.getBottom(), margin));
		}
	}

	public void setMarginRight(int row, int column, double margin) {
		updateRowAndColumnCount(row, column);
		VBox backGroundPane = createBackgroundPane(row, column);
		for (Node n : backGroundPane.getChildren()) {
			Insets ins = VBox.getMargin(n);
			if (ins == null) {
				ins = new Insets(0);
			}
			VBox.setMargin(n, new Insets(ins.getTop(), margin, ins.getBottom(), ins.getLeft()));
		}
	}

	private Node getFirstChildInCell(VBox vbox) {
		if (vbox.getChildren().size() > 0) {
			return vbox.getChildren().get(0);
		}
		return null;
	}

	private Node getLastChildInCell(VBox vbox) {
		if (vbox.getChildren().size() > 0) {
			return vbox.getChildren().get(vbox.getChildren().size() - 1);
		}
		return null;
	}

	public double calculateHeight(int row) {
		double height = 0;
		for (int i = 0; i <= row; i++) {
			height += tableView.getCellTable().getGrid().getRowConstraints().get(row).getPrefHeight();
		}
		return height;

	}

}
