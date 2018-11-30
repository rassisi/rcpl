package org.eclipse.rcpl;

/**
 * @author ramin
 *
 */
public interface IShape extends ILayoutObject {

	IColor getFillColor();

	IColor getLineColor();

	EnShapeType getType();

}
