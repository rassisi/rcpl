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
public class JOEmuInches extends JOEmu {
	public JOEmuInches(double inches) {
		this.value = RcplConversion.inch2Emu(inches);
	}
}
