package org.eclipse.rcpl;

import org.eclipse.rcpl.internal.tools.IStyle;

/**
 * @author Ramin
 *
 */
public interface IDrawing extends ILayoutObject {

	void setStyle(IStyle style);

	long getEmuEffectExtentLeft();

	long getEmuEffectExtentRight();

	long getEmuEffectExtentTop();

	long getEmuEffectExtentBottom();

	void setPage(IPage page);

	ILayoutFigure getLayoutFigure();

}
