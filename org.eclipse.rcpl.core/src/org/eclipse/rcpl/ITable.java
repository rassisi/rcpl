package org.eclipse.rcpl;

import org.eclipse.rcpl.internal.tools.IStyle;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHeightRule;

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

	double getRowHeight(int row);

	STHeightRule.Enum getRowHeightRule(int row);

}
