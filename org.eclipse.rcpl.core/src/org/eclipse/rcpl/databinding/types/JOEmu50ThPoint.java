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
public class JOEmu50ThPoint extends JOEmu {
	public JOEmu50ThPoint(BigInteger value) {
		this.value = RcplConversion.Pt2Emu(value.doubleValue() / 50.0);
	}
	
	public JOEmu50ThPoint(long value) {
		this.value = RcplConversion.Pt2Emu(value / 50.0);
	}
}
