package org.eclipse.rcpl.impl;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import org.eclipse.rcpl.IMonitor;

import javafx.stage.Screen;

/**
 * @author ramin
 *
 */
public class RcplMonitor implements IMonitor {

	private Screen screen;
	private int index;

	public RcplMonitor(Screen screen, int index) {
		super();
		this.screen = screen;
		this.index = index;
	}

	@Override
	public double getDpi() {
		double dpi = screen.getDpi();
		if (dpi == 0) {
			dpi = 96; // Screen.getPrimary().getDpi();
		}
		return dpi;
	}

	@Override
	public double getCmpi() {
		return screen.getDpi() / 2.54;
	}

	@Override
	public double getWidth() {
		return screen.getBounds().getWidth();
	}

	@Override
	public double getPixelWidth() {
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[index];
		int width = gd.getDisplayMode().getWidth();
		return width;
	}

	@Override
	public double getHeight() {
		return screen.getBounds().getHeight();
	}

	@Override
	public double getPhysicalWidthInCm() {
		return getWidth() / getCmpi();
	}

	@Override
	public double getPhysicalHeightInCm() {
		return getHeight() / getCmpi();
	}

	@Override
	public double getVisualWidth() {
		return screen.getVisualBounds().getWidth();
	}

	@Override
	public double getVisualHeight() {
		return screen.getVisualBounds().getHeight();
	}

}
