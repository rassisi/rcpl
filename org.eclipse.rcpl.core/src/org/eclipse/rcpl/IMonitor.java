package org.eclipse.rcpl;

/**
 * @author ramin
 *
 */
public interface IMonitor {

	double getDpi();

	double getCmpi();

	double getWidth();

	double getHeight();

	double getVisualWidth();

	double getVisualHeight();

	double getPhysicalWidthInCm();

	double getPhysicalHeightInCm();

	double getPixelWidth();
}
