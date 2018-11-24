package org.eclipse.rcpl.ui.controls.table;

import org.eclipse.rcpl.IParagraph;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Labeled;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
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

	private boolean DEBUG = true;

	private boolean autoColumnSize = false;

	public boolean equalColumns = false;

	private boolean autoRowSize = false;

	private double width;

	private double height;

	private boolean[][] wrap = new boolean[1000][1000];

	public RcplTable(int rowNumber, int columnNumber) {
		this(true, true, rowNumber, columnNumber);
	}

	public RcplTable() {
		this(true, true);
	}

	public RcplTable(boolean spreadsheet, boolean header) {
		this(spreadsheet, header, 0, 0);
	}

	public RcplTable(boolean spreadsheet, boolean header, int rowNumber, int columnNumber) {
		this.spreadsheet = spreadsheet;
		this.header = header;

		this.DEBUG = false;

		if (rowNumber > 0) {
			rowCount = rowNumber;
		} else {
			if (spreadsheet) {
				rowCount = IRcplTableConstants.DEFAULT_SPREADSHEET_ROW_COUNT;
			} else {
				rowCount = IRcplTableConstants.DEFAULT_ROW_COUNT;
			}

		}

		if (columnNumber > 0) {
			columnCount = columnNumber;
		} else {
			if (spreadsheet) {
				columnCount = IRcplTableConstants.DEFAULT_SPREADSHEET_COLUMN_COUNT;
			} else {
				columnCount = IRcplTableConstants.DEFAULT_COLUMN_COUNT;
			}
		}

		if (spreadsheet) {
			header = true;
		}
		tableView = new RcplTableView(this);
		node = tableView;
		updateCss();

		getNode().widthProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				width = newValue.doubleValue();
				update();
			}
		});

		getNode().heightProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				height = newValue.doubleValue();
			}
		});

	}

	public void showGrid(boolean show) {
		tableView.getCellTable().getGrid().setGridLinesVisible(show);
	}

	public boolean isDEBUG() {
		return DEBUG;
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
//			node.getStylesheets().add(RcplTable.class.getResource("rcpltableview_spreadsheet.css").toExternalForm());
		} else {
			node.getStylesheets().add(RcplTable.class.getResource("rcpltableview.css").toExternalForm());
			tableView.getStyleClass().add("gridStyle_normal");
		}

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
			VBox.setVgrow(n, Priority.ALWAYS);
			backGroundPane.getChildren().add(n);
			backGroundPane.layout();
		}

		double newHeight = 0;
		for (Node n2 : backGroundPane.getChildren()) {
			double h = n2.getLayoutBounds().getHeight();
			if (h == 0) {
				h = ((Pane) n2).getPrefHeight();
			}
			newHeight += h + 2;
		}
		newHeight += n.getLayoutBounds().getHeight();
		backGroundPane.setPrefHeight(newHeight);
	}

	public void addParagraph(IParagraph paragraph, int row, int column) {
		paragraph.getLayoutFigure().setWrap(isWrap(row, column));
		paragraph.getLayoutFigure().setTable(this);
		addNode(paragraph.getLayoutFigure().getNode(), row, column);
	}

	public void setRowHeight(int row, double height) {
		updateRowAndColumnCount(row, -1);
		tableView.getCellTable().getGrid().getRowConstraints().get(row).setPrefHeight(height);
		tableView.getCellTable().getGrid().getRowConstraints().get(row).setMinHeight(height);
		tableView.getCellTable().getGrid().getRowConstraints().get(row).setMaxHeight(height);
		if (tableView.getRowRuler() != null) {
			tableView.getRowRuler().setRowheight(row, height);
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
			st.setUserData(new int[] { row, column });
			st.setAlignment(Pos.TOP_LEFT);
			st.setStyle("-fx-border-color: blue;");
			GridPane.setVgrow(st, Priority.ALWAYS);
			GridPane.setFillHeight(st, true);
			GridPane.setFillWidth(st, true);
			tableView.getCellTable().getGrid().add(st, column, row);
			return st;
		}
		return (VBox) n;
	}

	private VBox getBackgroundPane(int row, int column) {
		try {
			Node n = RcplTableUtil.getNode(row, column, tableView.getCellTable().getGrid());
			return (VBox) n;
		} catch (Exception ex) {
			// ignore
		}
		return null;
	}

	public int getColumnSpan(int row, int column) {
		updateRowAndColumnCount(row, column);
		Node n = createBackgroundPane(row, column);
		if (n != null) {
			return GridPane.getColumnSpan(n);
		}
		return 1;
	}

	public int getRowSpan(int row, int column) {
		updateRowAndColumnCount(row, column);
		Node n = createBackgroundPane(row, column);
		if (n != null) {
			return GridPane.getRowSpan(n);
		}
		return 1;
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
		if (isDEBUG()) {
			return;
		}
		updateRowAndColumnCount(row, column);
		VBox backGroundPane = createBackgroundPane(row, column);
		backGroundPane.setStyle(style);
	}

	public void setWidth(double width) {
		getNode().setPrefWidth(width);
	}

	public void setHeight(double height) {
		getNode().setPrefHeight(height);
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
		} else if (width < columnWidth) {
			VBox st = createBackgroundPane(row, column);
			st.setPrefWidth(width);
//			st.setMinWidth(width);
//			st.setMaxWidth(width);
		}
	}

	public void setCellHeight(int row, int column, double height) {
		updateRowAndColumnCount(row, -1);
		double rowHeight = getRowHeight(row);
		if (height > rowHeight) {
			setRowHeight(row, height);
		} else if (height < rowHeight) {
			VBox st = createBackgroundPane(row, column);
			st.setPrefHeight(rowHeight);
//			st.setMinHeight(rowHeight);
//			st.setMaxHeight(rowHeight);
			st.setLayoutX(0);
			st.setLayoutY(0);
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

	public void clearAll() {
		for (int row = 0; row < rowCount; row++) {
			for (int col = 0; col < columnCount; col++) {
				VBox v = getBackgroundPane(row, col);
				if (v != null) {
					tableView.getCellTable().getGrid().getChildren().remove(v);
				}
			}
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

	public double calculateTotalHeight() {
		return calculateHeight(rowCount - 1);
	}

	public double calculateTotalWidth() {
		return calculateWidth(getColumnCount() - 1);
	}

	public double calculateWidth(int column) {
		double width = 0;
		for (int col = 0; col <= column; col++) {
			width += tableView.getCellTable().getGrid().getColumnConstraints().get(col).getPrefWidth();
		}
		return width;

	}

	private double getWidthOfLastColumn() {
		return getColumnWidth(columnCount - 1);
	}

	public void update() {
		if (spreadsheet) {
			return;
		}
		if (autoColumnSize) {
			double totalWidth = calculateTotalWidth();
			double diff = width - totalWidth;
			double lastW = getWidthOfLastColumn();
			setColumnWidth(columnCount - 1, lastW + diff);
		}

		if (equalColumns) {
			double totalWidth = Math.min(width, calculateTotalWidth());
			double w = totalWidth / columnCount;

			for (int col = 0; col < columnCount; col++) {
				setColumnWidth(col, w);
			}
		}

		for (int row = 0; row < rowCount; row++) {
			for (int col = 0; col < columnCount; col++) {
				VBox v = getBackgroundPane(row, col);
				if (v != null) {
					double h = v.getPrefHeight();
					if (h > getRowHeight(row)) {
						setRowHeight(row, h);
					}
				}
			}
		}
	}

	public void setEqualColumns(boolean equalColumns) {
		this.equalColumns = equalColumns;
		if (equalColumns) {
			update();
		}
	}

	public void setAutoColumnSize(boolean auto) {
		this.autoColumnSize = auto;
		if (auto) {
			update();
		}
	}

	public void setAutoRowSize(boolean auto) {
		this.autoRowSize = auto;
	}

	public boolean isAutoColumnSize() {
		return autoColumnSize;
	}

	public boolean isAutoRowSize() {
		return autoRowSize;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	public void setWrap(int row, int column, boolean wrap) {
		this.wrap[row][column] = wrap;
	}

	public boolean isWrap(int row, int column) {
		return this.wrap[row][column];
	}

}
