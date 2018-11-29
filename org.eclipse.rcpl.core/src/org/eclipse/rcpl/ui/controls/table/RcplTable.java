package org.eclipse.rcpl.ui.controls.table;

import org.eclipse.rcpl.ILayoutObject;
import org.eclipse.rcpl.IParagraph;
import org.eclipse.rcpl.Rcpl;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Labeled;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
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

	private int initialRows;

	private int initialColumns;

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

		initialRows = Math.max(rowNumber, IRcplTableConstants.DEFAULT_SPREADSHEET_ROW_COUNT);
		initialColumns = Math.max(columnNumber, IRcplTableConstants.DEFAULT_SPREADSHEET_COLUMN_COUNT);

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
//				update();
			}
		});

		getNode().heightProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				height = newValue.doubleValue();
			}
		});

		clearAll();

	}

	public void showGrid(boolean show) {
		tableView.getCellTable().showGridLines(show);
	}

	public boolean isDEBUG() {
		return DEBUG;
	}

	private double getTotalHeight() {
		double totalHeight = 0;
		ObservableList<RowConstraints> rc = tableView.getCellTable().getGrid().getRowConstraints();
		try {
			for (int i = 0; i < rowCount; i++) {
				totalHeight += rc.get(i).getPrefHeight();
			}
		} catch (Exception ex) {
			System.out.println();
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
		addNode(null, n, row, column);
	}

	public void addNode(GridPane grid, Node n, int row, int column) {
		if (grid == null) {
			grid = tableView.getCellTable().getGrid();
		}

		updateRowAndColumnCount(row, column);

		VBox backGroundPane = createBackgroundPane(grid, row, column);

		if (column == 0 && row > 0) {
			for (Node n2 : backGroundPane.getChildren()) {
				Object o = n2.getUserData();

				if (o instanceof DragAnchor) {
					n2.toFront();
					break;
				}

			}
		}

		backGroundPane.setAlignment(Pos.CENTER);
		if (!backGroundPane.getChildren().contains(n)) {
			VBox.setVgrow(n, Priority.ALWAYS);
			if (!spreadsheet && row > 0 && column == 0) {
				int x = backGroundPane.getChildren().size();
				backGroundPane.getChildren().add(x - 1, n);
			} else {
				backGroundPane.getChildren().add(n);
			}
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

	public void addLayoutObject(ILayoutObject layoutObject, int row, int column) {
		layoutObject.getLayoutFigure().setWrap(isWrap(row, column));
		layoutObject.getLayoutFigure().setTable(this);
		addNode(layoutObject.getLayoutFigure().getNode(), row, column);
	}

	public void setRowHeight(int row, double height) {
		updateRowAndColumnCount(row, -1);
		GridPane grid = tableView.getCellTable().getGrid();
		grid.getRowConstraints().get(row).setPrefHeight(height);
		grid.getRowConstraints().get(row).setMinHeight(height);
		grid.getRowConstraints().get(row).setMaxHeight(height);
		if (spreadsheet && tableView.getRowRuler() != null) {
			tableView.getRowRuler().setRowheight(row, height);
		}
	}

	public void setColumnWidth(int column, double width) {
		updateRowAndColumnCount(-1, column);
		tableView.getCellTable().getGrid().getColumnConstraints().get(column).setPrefWidth(width);
		tableView.getCellTable().getGrid().getColumnConstraints().get(column).setMinWidth(width);
		tableView.getCellTable().getGrid().getColumnConstraints().get(column).setMaxWidth(width);
		if (spreadsheet && tableView.getTableHeader() != null) {
			tableView.getTableHeader().setColumnWidth(column, width);
		}
	}

	VBox createBackgroundPane(int row, int column) {
		return createBackgroundPane(row, column, false);
	}

	VBox createBackgroundPane(int row, int column, boolean withRuler) {
		return createBackgroundPane(null, row, column, withRuler);
	}

	VBox createBackgroundPane(GridPane grid, int row, int column) {
		return createBackgroundPane(grid, row, column, false);
	}

	VBox createBackgroundPane(GridPane grid, int row, int column, boolean withRuler) {
		if (grid == null) {
			grid = tableView.getCellTable().getGrid();
		}
		Node n = RcplTableUtil.getNode(row, column, grid);
		if (n == null) {
			VBox vbox = new VBox();
			vbox.setUserData(new int[] { row, column });
			vbox.setAlignment(Pos.BOTTOM_CENTER);
			GridPane.setVgrow(vbox, Priority.ALWAYS);
			GridPane.setFillHeight(vbox, true);
			GridPane.setFillWidth(vbox, true);

			if (!isSpreadsheet()) {

				BorderPane bp = null;

				// ---------- TOP LEFT

				if (column == 0 && row == 0) {
					bp = new BorderPane();
					GridPane.setFillWidth(bp, true);
					GridPane.setFillHeight(bp, true);
					grid.add(bp, column, row);
					if (withRuler) {
						HBox st = new HBox();
						st.setPickOnBounds(false);
						st.setAlignment(Pos.CENTER_RIGHT);
						vbox.setPadding(new Insets(0, -5, -5, 0));
						st.getChildren().add(vbox);
						bp.setCenter(st);
					} else {
						bp.setBottom(vbox);
					}
					return vbox;
				}

				// ---------- FIRST ROW COLUMN RULER -----------

				if (withRuler) {
					HBox hbox = new HBox();
					hbox.setPickOnBounds(false);
					hbox.setAlignment(Pos.CENTER_RIGHT);
					vbox.setPadding(new Insets(0, -5, 0, 0));
					hbox.getChildren().add(vbox);
					GridPane.setFillWidth(hbox, true);
					GridPane.setFillHeight(hbox, true);

					grid.add(hbox, column, row);
					return vbox;
				}

				if (column == 0) {
					vbox.setPadding(new Insets(0, 0, -5, 0));
					grid.add(vbox, column, row);
					return vbox;
				}
			}

			// ----------- NORMAL CELL ---------------------

			grid.add(vbox, column, row);

			return vbox;
		}
		VBox v = getBackgroundPane(grid, row, column);

		return v;
	}

	public VBox getBackgroundPane(int row, int column) {
		return getBackgroundPane(null, row, column);
	}

	VBox getBackgroundPane(GridPane grid, int row, int column) {
		if (grid == null) {
			grid = tableView.getCellTable().getGrid();
		}
		try {
			Node n = RcplTableUtil.getNode(row, column, grid);
			if (n instanceof VBox) {
				return (VBox) n;
			} else if (n instanceof HBox) {
				return (VBox) ((HBox) n).getChildren().get(0);
			} else if (n instanceof BorderPane) {
				HBox hbox = (HBox) ((BorderPane) n).getCenter();
				return (VBox) hbox.getChildren().get(0);
			}
		} catch (Exception ex) {
			Rcpl.get().printErrorln("RcplTable.getBackgroundPane(GridPane grid, int row, int column)", ex);
		}
		return null;
	}

	BorderPane getTopLeftCellPane() {
		GridPane grid = tableView.getCellTable().getGrid();
		try {
			Node n = RcplTableUtil.getNode(0, 0, grid);
			if (n instanceof BorderPane) {
				return (BorderPane) n;
			}
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

		if (backGroundPane.getParent() instanceof BorderPane) {
			backGroundPane.getParent().setStyle(style);
			return;
		}

		if (backGroundPane.getParent() instanceof HBox) {
			backGroundPane.getParent().setStyle(style);
			return;
		}

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
		}
	}

	public void setCellHeight(int row, int column, double height) {
		updateRowAndColumnCount(row, -1);
		double rowHeight = getRowHeight(row);
		if (height > rowHeight) {
			setRowHeight(row, height);
		} else if (height < rowHeight) {
			VBox st = createBackgroundPane(row, column);
			if (st != null) {
				st.setPrefHeight(rowHeight);
				st.setLayoutX(0);
				st.setLayoutY(0);
			} else {
				Rcpl.get().println(
						"RcplTable.setCellheight(row:" + row + ", column:" + column + ", height:" + height + ")");
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

	public void clearAll() {

//		for (int row = 0; row < rowCount; row++) {
//			for (int col = 0; col < columnCount; col++) {
//				VBox v = getBackgroundPane(row, col);
//				if (v != null) {
//					tableView.getCellTable().getGrid().getChildren().remove(v);
//				}
//			}
//		}

		rowCount = 0;
		tableView.getCellTable().getGrid().getRowConstraints().clear();
		columnCount = 0;
		tableView.getCellTable().getGrid().getColumnConstraints().clear();
		getTableView().getCellTable().getGrid().getChildren().clear();

		if (spreadsheet) {

			for (int row = 0; row < initialRows; row++) {
				insertRow();
			}

			for (int column = 0; column < initialColumns; column++) {
				insertColumn();
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
		return calculateHeight(null, row);
	}

	public double calculateHeight(GridPane grid, int row) {
		if (grid == null) {
			grid = tableView.getCellTable().getGrid();
		}

		double height = 0;
		for (int i = 0; i <= row; i++) {
			height += grid.getRowConstraints().get(row).getPrefHeight();
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
		return calculateWidth(null, column);
	}

	public double calculateWidth(GridPane grid, int column) {

		if (grid == null) {
			grid = tableView.getCellTable().getGrid();
		}

		double width = 0;
		for (int col = 0; col <= column; col++) {
			width += grid.getColumnConstraints().get(col).getPrefWidth();
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

	public void hideRow(int row) {
		tableView.getCellTable().getGrid().getRowConstraints().get(row).setMaxHeight(0);
	}

	public void removeRow(int row) {
		for (int col = 0; col < columnCount; col++) {
			VBox vbox = getBackgroundPane(row, col);
			if (vbox != null) {
				tableView.getCellTable().getGrid().getChildren().remove(vbox);
			}
		}
		tableView.getCellTable().getGrid().getRowConstraints().remove(row);
		rowCount--;
	}

	public void removeLastRow() {
		removeRow(getRowCount() - 1);
	}

}
