package org.eclipse.rcpl.laborytory;

import org.eclipse.rcpl.ICellable;
import org.eclipse.rcpl.IParagraph;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author Ramin
 *
 */
public class RcplTableData {

	public static int MAX_COLUMNS = 100;

	public static int MAX_ROWS = 100;

	public static int MAX_SPREADSHEET_COLUMNS = 1000;

	public static int MAX_SPREADSHEET_ROWS = 1000;

	private int columnCount;

	private int rowCount;

	private ICellable[][] cellArray = new ICellable[MAX_SPREADSHEET_ROWS][MAX_SPREADSHEET_COLUMNS];

	private RcplTable table;

	private ObservableList<RcplCellRow> data;

	/**
	 * @param table
	 */
	public RcplTableData(RcplTable table) {
		this.table = table;
		for (int row = 0; row < MAX_SPREADSHEET_ROWS; row++) {
			for (int col = 0; col < MAX_SPREADSHEET_COLUMNS; col++) {
				cellArray[row][col] = new RcplEmptyCell(row, col);
			}
		}
	}

	private void initRowAndColumnCount() {
		if (table.isSpreadsheet()) {
			rowCount = MAX_SPREADSHEET_ROWS;
			columnCount = MAX_SPREADSHEET_COLUMNS;
		} else {
			rowCount = MAX_ROWS;
			columnCount = MAX_COLUMNS;
		}
	}

	public ObservableList<RcplCellRow> getData() {
		updateRowAndColumnCount();
		data = FXCollections.observableArrayList();
		for (int row = 0; row < rowCount; row++) {
			RcplCellRow rowData = new RcplCellRow();
			for (int col = 0; col < columnCount; col++) {
				rowData.add(cellArray[row][col]);
			}
			data.add(rowData);
		}
		return data;
	}

	public void setParagraph(IParagraph paragraph, int row, int column) {
		cellArray[row][column] = paragraph;
		paragraph.setRow(row);
		paragraph.setColumn(column);
		table.setData(this);
	}

	public ICellable getCell(int row, int column) {
		return cellArray[row][column];
	}

	private void updateRowAndColumnCount() {
		initRowAndColumnCount();
		if (!table.isSpreadsheet()) {
			for (int row = rowCount - 1; row > 0; row--) {
				ICellable[] rowData = cellArray[row];
				boolean allCellsAreEmpty = true;
				for (ICellable cell : rowData) {
					if (!cell.isEmpty()) {
						allCellsAreEmpty = false;
					}
				}
				if (allCellsAreEmpty) {
					rowCount--;

					System.out.println("rowCount = " + rowCount);

				} else {
					break;
				}
			}

			for (int col = columnCount - 1; col > 0; col--) {
				boolean allCellsAreEmpty = true;
				for (int row = 0; row < rowCount; row++) {
					ICellable cell = cellArray[row][col];
					if (!(cell.isEmpty())) {
						allCellsAreEmpty = false;
						break;
					}
				}
				if (allCellsAreEmpty) {
					columnCount--;
				} else {
					break;
				}
			}
		}

	}

	public int getColumnCount() {
		return columnCount;
	}

	public int getRowCount() {
		return rowCount;
	}

}
