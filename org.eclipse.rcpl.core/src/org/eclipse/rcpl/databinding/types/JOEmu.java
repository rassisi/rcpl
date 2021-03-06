/******************************************************************************
 *
 * Copyright (c) 2009 Ramin Assisi
 * All rights reserved.
 *
 ****************************************************************************/

package org.eclipse.rcpl.databinding.types;

import java.math.BigInteger;

import org.eclipse.rcpl.IEmu;
import org.eclipse.rcpl.util.RcplConversion;

/**
 * @author ramin
 * 
 */
public class JOEmu implements IEmu {

	public BigInteger value = BigInteger.ZERO;

	public JOEmu() {
	}

	public JOEmu(long value) {
		this.value = BigInteger.valueOf(value);
	}

	public JOEmu(double value) {
		this.value = BigInteger.valueOf((long) value);
	}

	public JOEmu(BigInteger value) {
		this.value = value;
	}

	public JOEmu(String value) {
		if (value != null) {
			this.value = RcplConversion.pointsAndInchesAndValuesToEmu(value);
		}
	}

	@Override
	public double toPixel() {
		if (value == null) {
			return 0;
		}
		return RcplConversion.emu2Pixel(value);
	}

	public double toPoints() {
		if (value == null) {
			return 0;
		}
		return RcplConversion.emu2Points(value);
	}

	public double toInch() {
		if (value == null) {
			return 0;
		}
		return RcplConversion.emu2Inch(value.doubleValue());
	}

	public double toCm() {
		if (value == null) {
			return 0;
		}
		return RcplConversion.emu2Centimeter(value.doubleValue());
	}

	public double toMm() {
		if (value == null) {
			return 0;
		}
		return RcplConversion.emu2Millimeter(value.doubleValue());
	}

	public double toEmu() {
		if (value == null) {
			return 0;
		}
		return value.doubleValue();
	}

	public long toLong() {
		if (value == null) {
			return 0;
		}
		return value.longValue();
	}

	public double toDouble() {
		if (value == null) {
			return 0;
		}
		return value.doubleValue();
	}

	public void setPixel(double pixel) {
		value = RcplConversion.Pt2Emu(RcplConversion.pixelToPoints(pixel));
	}

	public void setDouble(double value) {
		this.value = BigInteger.valueOf((long) value);
	}

	public void setLong(long value) {
		this.value = BigInteger.valueOf(value);
	}

	public void increasePixel(double pixel) {
		value = RcplConversion.Pt2Emu(RcplConversion.pixelToPoints(toPixel() + pixel));
	}

	public void decreasePixel(double pixel) {
		value = RcplConversion.Pt2Emu(RcplConversion.pixelToPoints(toPixel() - pixel));
	}

	@Override
	public String toString() {
		return "emu: " + toEmu() + "  points: " + toPoints() + "  pixel: " //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$
				+ toPixel() + " cm: " + toCm() + "  inches: " + toInch(); //$NON-NLS-1$ //$NON-NLS-2$
	}

	public BigInteger getValue() {
		return value;
	}

	public void add(JOEmu emu) {
		value = value.add(emu.getValue());
	}

	public void subtract(JOEmu emu) {
		value = value.subtract(emu.getValue());
	}

}
