package org.eclipse.rcpl;

import org.eclipse.rcpl.internal.tools.IStyle;

/**
 * @author ramin
 *
 */
public interface ITable extends ILayoutObject {

	ITableCell[][] getCells();

	@Override
	ITableFigure getLayoutFigure();

	IStyle getTableStyle();

	void setOverflowRow(int row);

	int getOverflowRow();

	boolean isTblLoookAllBorders();

}
