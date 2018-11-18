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
public class JOEmuCentimeter extends JOEmu {
	public JOEmuCentimeter(double value) {
		this.value = BigInteger.valueOf((long)RcplConversion.millimeterToEmu(value*10.0));
	}
}
