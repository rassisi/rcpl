package org.eclipse.rcpl.ui.controls.table;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.rcpl.IColor;
import org.eclipse.rcpl.ILayoutObject;
import org.eclipse.rcpl.IParagraph;
import org.eclipse.rcpl.IRcplTableListener;
import org.eclipse.rcpl.Rcpl;
import org.eclipse.rcpl.util.RcplConversion;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Labeled;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
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

	private int initialRows;

	private int initialColumns;

	private boolean allBorders;

	private IColor allBordersColor = IColor.BLACK;

	private double allBordersWidth = 1.0;

	private double minimumColumnWidth;

	private double minimumRowHeight;

	double DEFAULT_ROW_HEIGHT = 22;

	private List<IRcplTableListener> listeners = new ArrayList<IRcplTableListener>();

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
		DEFAULT_ROW_HEIGHT = RcplConversion.pointsToPixelDouble(13);
		this.minimumColumnWidth = IRcplTableConstants.SIZER_WIDTH;
		this.minimumRowHeight = DEFAULT_ROW_HEIGHT;
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
		tableView.getCellTable().showGridLines(true); // show);
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
		updateRowAndColumnCount(row, column);
		VBox pane = getCellContentPane(row, column);
		if (column == 0 && row > 0) {
			for (Node n2 : pane.getChildren()) {
				Object o = n2.getUserData();

				if (o instanceof DragAnchor) {
					n2.toFront();
					break;
				}

			}
		}

		if (!pane.getChildren().contains(n)) {
			VBox.setVgrow(n, Priority.ALWAYS);
			pane.getChildren().add(n);
			pane.layout();
		}

		double newHeight = 0;
		for (Node n2 : pane.getChildren()) {
			double h = n2.getLayoutBounds().getHeight();
			if (h == 0) {
				h = ((Pane) n2).getPrefHeight();
			}
//			newHeight += h + 2;
		}
		newHeight += n.getLayoutBounds().getHeight();
		pane.setMinHeight(newHeight);
		pane.setPrefHeight(newHeight);
	}

	public void addLayoutObject(ILayoutObject layoutObject, int row, int column) {
		layoutObject.getLayoutFigure().setWrap(isWrap(row, column));
		layoutObject.getLayoutFigure().setTable(this);
		addNode(layoutObject.getLayoutFigure().getNode(), row, column);
	}

	public void setRowHeight(int row, double height) {
		updateRowAndColumnCount(row, -1);
		if (height >= getMinimumRowHeight()) {
			GridPane grid = tableView.getCellTable().getGrid();
			grid.getRowConstraints().get(row).setPrefHeight(height);
			grid.getRowConstraints().get(row).setMinHeight(height);
			grid.getRowConstraints().get(row).setMaxHeight(height);
			if (spreadsheet && tableView.getRowRuler() != null) {
				tableView.getRowRuler().setRowheight(row, height);
			}
		}
		for (IRcplTableListener l : listeners) {
			l.rowHeightChanged(row, height);
		}
	}

	public void setColumnWidth(int column, double width) {
		updateRowAndColumnCount(-1, column);
		if (width >= getMinimumColumnWidth()) {
			tableView.getCellTable().getGrid().getColumnConstraints().get(column).setPrefWidth(width);
			tableView.getCellTable().getGrid().getColumnConstraints().get(column).setMinWidth(width);
			tableView.getCellTable().getGrid().getColumnConstraints().get(column).setMaxWidth(width);
			if (spreadsheet && tableView.getTableHeader() != null) {
				tableView.getTableHeader().setColumnWidth(column, width);
			}
		}
		tableView.getCellTable().getGrid().layout();
		for (IRcplTableListener l : listeners) {
			l.columnWidthChanged(column, width);
		}

	}

	StackPane createBackgroundPane(int row, int column) {

		GridPane grid = tableView.getCellTable().getGrid();

		Node n = RcplTableUtil.getNode(row, column, grid);
		if (n == null) {
			StackPane cellStack = new StackPane();
			cellStack.setPickOnBounds(false);
			cellStack.setUserData(new RcplCellInfo(row, column));
			VBox vbox = new VBox();
			vbox.setPickOnBounds(false);
			vbox.setAlignment(Pos.BOTTOM_CENTER);
			GridPane.setVgrow(vbox, Priority.ALWAYS);
			GridPane.setFillHeight(vbox, true);
			GridPane.setFillWidth(vbox, true);
			cellStack.getChildren().add(vbox);
			grid.add(cellStack, column, row);

			if (!isSpreadsheet()) {

				BorderPane bp = null;

				// ---------- TOP LEFT

				if (column == 0 || row == 0) {
					bp = new BorderPane();
					bp.setPickOnBounds(false);
					cellStack.getChildren().add(bp);
					return cellStack;
				}

			}

			return cellStack;
		}
		return (StackPane) n;

	}

	public VBox getCellContentPane(int row, int column) {
		StackPane st = createBackgroundPane(row, column);
		if (st != null) {
			return (VBox) st.getChildren().get(0);
		}
		return null;
	}

	BorderPane getSizerPane(int row, int column) {
		if (row == 0 || column == 0) {
			StackPane st = createBackgroundPane(row, column);
			return (BorderPane) st.getChildren().get(1);
		}
		return null;
	}

	StackPane getBackgroundPane(int row, int column) {
		GridPane grid = tableView.getCellTable().getGrid();
		try {
			Node n = RcplTableUtil.getNode(row, column, grid);
			return (StackPane) n;

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
			Integer span = GridPane.getColumnSpan(n);
			if (span == null) {
				return 1;
			}
			return span.intValue();
		}
		return 1;
	}

	public boolean isColumnSpaned(int row, int column) {

		if (getColumnSpan(row, column) > 1) {
			return false;
		}
		if (column == 0) {
			return false;
		}
		column--;
		for (int count = 2; column >= 0; column--, count++) {
			int span = getColumnSpan(row, column);
			if (span > 1) {
				if (span >= count) {
					return true;
				}
				return false;
			}
		}
		return false;
	}

	public int getRowSpan(int row, int column) {
		updateRowAndColumnCount(row, column);
		Node n = createBackgroundPane(row, column);
		if (n != null) {
			try {
				return GridPane.getRowSpan(n);
			} catch (Exception ex) {
				return 1;
			}
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
		if (width >= getMinimumColumnWidth()) {
			double columnWidth = getColumnWidth(column);
			if (width > columnWidth) {
				setColumnWidth(column, width);
			} else if (width < columnWidth) {
				setColumnWidth(column, width);
				StackPane st = createBackgroundPane(row, column);
//				st.setPrefWidth(width);
			}
		}
	}

	public void setCellHeight(int row, int column, double height) {
		updateRowAndColumnCount(row, -1);
		double rowHeight = getRowHeight(row);
		if (height >= getMinimumRowHeight()) {
			if (height > rowHeight) {
				setRowHeight(row, height);
			} else if (height < rowHeight) {
				StackPane st = createBackgroundPane(row, column);
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
	}

	public double getColumnWidth(int column) {
		return tableView.getCellTable().getGrid().getColumnConstraints().get(column).getPrefWidth();
	}

	public double getRowHeight(int row) {
		return tableView.getCellTable().getGrid().getRowConstraints().get(row).getPrefHeight();
	}

	public void setMarginTop(int row, int column, double margin) {
		updateRowAndColumnCount(row, column);
		VBox vbox = getCellContentPane(row, column);
		Insets ins = StackPane.getMargin(vbox);
		if (ins == null) {
			ins = new Insets(0);
		}
		VBox.setMargin(vbox, new Insets(margin, ins.getRight(), ins.getBottom(), ins.getLeft()));
	}

	public void setMarginBottom(int row, int column, double margin) {
		updateRowAndColumnCount(row, column);
		VBox vbox = getCellContentPane(row, column);
		Insets ins = StackPane.getMargin(vbox);
		if (ins == null) {
			ins = new Insets(0);
		}
		StackPane.setMargin(vbox, new Insets(ins.getTop(), ins.getRight(), margin, ins.getLeft()));
	}

	public void setMarginLeft(int row, int column, double margin) {
		updateRowAndColumnCount(row, column);
		VBox vbox = getCellContentPane(row, column);
		Insets ins = StackPane.getMargin(vbox);
		if (ins == null) {
			ins = new Insets(0);
		}
		StackPane.setMargin(vbox, new Insets(ins.getTop(), ins.getRight(), ins.getBottom(), margin));
	}

	public void setMarginRight(int row, int column, double margin) {
		updateRowAndColumnCount(row, column);
		VBox vbox = getCellContentPane(row, column);
		Insets ins = StackPane.getMargin(vbox);
		if (ins == null) {
			ins = new Insets(0);
		}
		VBox.setMargin(vbox, new Insets(ins.getTop(), margin, ins.getBottom(), ins.getLeft()));
	}

	public void clearAll() {
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

//	private Node getFirstChildInCell(StackPane cellStackPane) {
//		if (cellStackPane.getChildren().size() > 0) {
//			return cellStackPane.getChildren().get(0);
//		}
//		return null;
//	}
//
//	private Node getLastChildInCell(StackPane cellStackPane) {
//		if (cellStackPane.getChildren().size() > 0) {
//			return cellStackPane.getChildren().get(cellStackPane.getChildren().size() - 1);
//		}
//		return null;
//	}

	public double calculateHeight(int row) {
		GridPane grid = tableView.getCellTable().getGrid();
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
		GridPane grid = tableView.getCellTable().getGrid();
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
				StackPane v = getBackgroundPane(row, col);
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
		RcplCellInfo info = getCellInfo(row, column);
		if (info == null) {
			createBackgroundPane(row, column);
			info = getCellInfo(row, column);
		}
		info.wrap = wrap;
	}

	public boolean isWrap(int row, int column) {
		RcplCellInfo info = getCellInfo(row, column);
		if (info == null) {
			return false;
		}
		return info.wrap;
	}

	public void hideRow(int row) {
		tableView.getCellTable().getGrid().getRowConstraints().get(row).setMaxHeight(0);
	}

	public void removeRow(int row) {
		for (int col = 0; col < columnCount; col++) {
			StackPane cellStack = getBackgroundPane(row, col);
			if (cellStack != null) {
				tableView.getCellTable().getGrid().getChildren().remove(cellStack);
			}
		}
		tableView.getCellTable().getGrid().getRowConstraints().remove(row);
		rowCount--;
	}

	public void removeLastRow() {
		removeRow(getRowCount() - 1);
	}

	public void setAllBorders(boolean allBorders) {
		this.allBorders = allBorders;
		setTopCellBorder(0, 0, IColor.BLACK, 0.5);
		setRightCellBorder(0, 0, IColor.BLACK, 0.5);
		setBottomCellBorder(0, 0, IColor.BLACK, 0.5);
		setLeftCellBorder(0, 0, IColor.BLACK, 0.5);

		for (int row = 1; row < rowCount; row++) {
			setRightCellBorder(row, 0, IColor.BLACK, 0.5);
			setBottomCellBorder(row, 0, IColor.BLACK, 0.5);
			setLeftCellBorder(row, 0, IColor.BLACK, 0.5);
		}
		for (int col = 1; col < columnCount; col++) {
			setTopCellBorder(0, col, IColor.BLACK, 0.5);
			setRightCellBorder(0, col, IColor.BLACK, 0.5);
			setBottomCellBorder(0, col, IColor.BLACK, 0.5);
		}
		for (int row = 1; row < rowCount; row++) {
			for (int col = 1; col < columnCount; col++) {
				setRightCellBorder(row, col, IColor.BLACK, 0.5);
				setBottomCellBorder(row, col, IColor.BLACK, 0.5);
			}
		}
	}

	public void setAllBordersColor(IColor allBordersColor) {
		this.allBordersColor = allBordersColor;
	}

	public void setAllBordersWidth(double allBordersWidth) {
		this.allBordersWidth = allBordersWidth;
	}

	public void setCellBg(int row, int col, IColor color) {
		StackPane v = createBackgroundPane(row, col);
		RcplCellInfo info = (RcplCellInfo) v.getUserData();
		info.bgColor = color;
		correctSpanBorder(info, row, col);
		v.setStyle(info.getStyle());
	}

	public void setCellBorder(int row, int col, IColor color, double width) {
		StackPane v = getBackgroundPane(row, col);
		RcplCellInfo info = (RcplCellInfo) v.getUserData();
		info.borderColor = color;
		info.borderWidth = width;
		v.setStyle(info.getStyle());
	}

	public void setTopCellBorder(int row, int col, IColor color, double width) {
		if (row > 0) {
			RcplCellInfo i = getCellInfo(row - 1, col);
			if (i != null && i.borderWidthBottom > 0) {
				return;
			}
		}
		StackPane v = createBackgroundPane(row, col);
		RcplCellInfo info = (RcplCellInfo) v.getUserData();
		info.borderColorTop = color;
		info.borderWidthTop = width;
		correctSpanBorder(info, row, col);
		v.setStyle(info.getStyle());
	}

	public void setRightCellBorder(int row, int col, IColor color, double width) {
		StackPane v = createBackgroundPane(row, col);
		RcplCellInfo info = (RcplCellInfo) v.getUserData();
		info.borderColorRight = color;
		info.borderWidthRight = width;
		correctSpanBorder(info, row, col);
		v.setStyle(info.getStyle());
	}

	private void correctSpanBorder(RcplCellInfo info, int row, int col) {

		if (getColumnSpan(row, col) > 1) {
//			info.borderColorLeft = IColor.RED; // null;
//			info.borderWidthLeft = 3;

		} else if (isColumnSpaned(row, col)) {
			info.borderColorRight = null;
			info.borderWidthRight = 0;
			info.borderColorLeft = null;
			info.borderWidthLeft = 0;
		}
	}

	public void setBottomCellBorder(int row, int col, IColor color, double width) {
		StackPane v = createBackgroundPane(row, col);
		RcplCellInfo info = (RcplCellInfo) v.getUserData();
		info.borderColorBottom = color;
		info.borderWidthBottom = width;
		correctSpanBorder(info, row, col);
		v.setStyle(info.getStyle());
	}

	public void setLeftCellBorder(int row, int col, IColor color, double width) {
		if (col > 0) {
			RcplCellInfo i = getCellInfo(row, col - 1);
			if (i != null && i.borderWidthRight > 0) {
				return;
			}
		}
		StackPane v = createBackgroundPane(row, col);
		RcplCellInfo info = (RcplCellInfo) v.getUserData();
		info.borderColorLeft = color;
		info.borderWidthLeft = width;
		correctSpanBorder(info, row, col);
		v.setStyle(info.getStyle());
	}

	public RcplCellInfo getCellInfo(int row, int col) {
		StackPane v = getBackgroundPane(row, col);
		if (v != null) {
			return (RcplCellInfo) v.getUserData();
		}
		return null;
	}

	public double getMinimumColumnWidth() {
		return minimumColumnWidth;
	}

	public void setMinimumColumnWidth(double minimumColumnWidth) {
		this.minimumColumnWidth = minimumColumnWidth;
	}

	public double getMinimumRowHeight() {
		return minimumRowHeight;
	}

	public void setMinimumRowHeight(double minimumRowHeight) {
		this.minimumRowHeight = minimumRowHeight;
	}

	public void addListener(IRcplTableListener listener) {
		if (!listeners.contains(listener)) {
			listeners.add(listener);
		}
	}
}
