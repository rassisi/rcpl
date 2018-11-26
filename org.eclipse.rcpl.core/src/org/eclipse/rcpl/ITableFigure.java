package org.eclipse.rcpl;

/**
 * @author Ramin
 *
 */
public interface ITableFigure extends ILayoutFigure {

	void loadCells();

	@Override
	void refresh();

}
