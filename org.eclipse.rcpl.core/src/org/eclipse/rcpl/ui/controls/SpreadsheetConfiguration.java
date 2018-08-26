package org.eclipse.rcpl.ui.controls;

/**
 * @author Ramin
 *
 */
public class SpreadsheetConfiguration {

	private int rowStripes = 0;

	private int initialRows = 50;
	private int initialColumns = 50;

	public int getRowStripes() {
		return rowStripes;
	}

	public void setRowStripes(int rowStripes) {
		this.rowStripes = rowStripes;
	}

	public int getInitialRows() {
		return initialRows;
	}

	public void setInitialRows(int maxRows) {
		this.initialRows = maxRows;
	}

	public int getInitialColumns() {
		return initialColumns;
	}

	public void setInitialColumns(int maxColumns) {
		this.initialColumns = maxColumns;
	}

}
