package org.eclipse.rcpl.laborytory;

import org.eclipse.rcpl.ICellable;

/**
 * @author Ramin
 *
 */
public class RcplEmptyCell implements ICellable {

	private int column;

	private int row;

	double width;

	double height;

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

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

}
