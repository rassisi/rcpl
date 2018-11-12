package org.eclipse.rcpl.laborytory;

import org.eclipse.rcpl.ICellable;

/**
 * @author Ramin
 *
 */
public class RcplEmptyCell implements ICellable {

	private int column;

	private int row;

	public RcplEmptyCell(int row, int column) {
		this.row = row;
		this.column = column;
	}

	@Override
	public void setColumn(int column) {
		this.column = column;
	}

	@Override
	public int getColumn() {
		return column;
	}

	@Override
	public void setRow(int row) {
		this.row = row;
	}

	@Override
	public int getRow() {
		return row;
	}

}
