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
public class JOEmu20ThPoint extends JOEmu {

	public JOEmu20ThPoint(BigInteger value) {
		this.value = RcplConversion.Pt2Emu(value.doubleValue() / 20.0);
	}

	public JOEmu20ThPoint(long value) {
		this.value = RcplConversion.Pt2Emu((double) value / (double) 20);
	}

	public BigInteger to20ThPoint() {
		BigInteger result = BigInteger.valueOf((long) (toPoints() * 20));
		return result;
	}

}
