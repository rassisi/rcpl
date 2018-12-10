package org.eclipse.rcpl;

/**
 * @author Ramin
 *
 */
public interface IPict extends ILayoutObject {

	EnShapeType getShapeType();

	void setShapeType(EnShapeType shapeType);

	boolean isStroked();

	IEmu getLineWidth();

	IColor getSolidFillColor();

	boolean isFilled();

	IColor getLineColor();

	boolean isTextBox();

}
