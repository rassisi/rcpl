/******************************************************************************
 *
 * Copyright (c) 2009 Ramin Assisi
 * All rights reserved.
 *
 ****************************************************************************/

package org.eclipse.rcpl.databinding.types;

import java.math.BigInteger;

import org.eclipse.rcpl.util.RcplConversion;

/**
 * @author ramin
 * 
 */
public class JOEmu100ThPoint extends JOEmu {
	public JOEmu100ThPoint(BigInteger value) {
		this.value = RcplConversion.Pt2Emu(value.doubleValue() / 100.0);
	}
	
	public JOEmu100ThPoint(long value) {
		this.value = RcplConversion.Pt2Emu(value / 100.0);
	}
}
