package org.eclipse.rcpl;

/**
 * @author Ramin
 *
 */
public interface IShadow {

	public boolean isShadow();

	public double getBlurRadius();

	public IColor getColor();

	public double getOpacity();

	public double getDistance();

	public double getDirection();
}
