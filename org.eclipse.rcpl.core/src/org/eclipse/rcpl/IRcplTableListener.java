package org.eclipse.rcpl;

/**
 * @author Ramin
 *
 */
public interface IRcplTableListener {

	void columnWidthChanged(int column, double width);

	void rowHeightChanged(int row, double height);

}
