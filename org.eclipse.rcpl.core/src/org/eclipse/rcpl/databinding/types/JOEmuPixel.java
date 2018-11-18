/******************************************************************************
 *
 * Copyright (c) 2009 Ramin Assisi
 * All rights reserved.
 *
 ****************************************************************************/

package org.eclipse.rcpl.databinding.types;

import org.eclipse.rcpl.util.RcplConversion;

/**
 * @author ramin
 * 
 */
public class JOEmuPixel extends JOEmu {
	public JOEmuPixel(double value) {
		double points = RcplConversion.pixelToPoints(value);
		this.value = RcplConversion.Pt2Emu(points);
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
