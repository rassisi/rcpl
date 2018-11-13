package org.eclipse.rcpl;

public interface ICellable {

	void setColumn(int column);

	int getColumn();

	void setRow(int row);

	int getRow();

	void setWidth(double width);

	void setHeight(double height);

	double getHeight();

	double getWidth();

	boolean isEmpty();

}
