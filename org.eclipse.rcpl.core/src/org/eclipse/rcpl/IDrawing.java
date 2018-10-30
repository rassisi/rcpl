package org.eclipse.rcpl;

/**
 * @author Ramin
 *
 */
public interface IDrawing extends ILayoutObject {

	public void setRotation(double rotation);

	public double getRotation();

	void setStyle(IStyle style);

	long getEmuEffectExtentLeft();

	long getEmuEffectExtentRight();

	long getEmuEffectExtentTop();

	long getEmuEffectExtentBottom();

	void setPage(IPage page);

	ILayoutFigure getLayoutFigure();

}
