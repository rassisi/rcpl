package org.eclipse.rcpl.util;

import java.math.BigInteger;

import org.eclipse.rcpl.EnMeasurementUnits;
import org.eclipse.rcpl.databinding.types.JOEmu;
import org.eclipse.rcpl.databinding.types.JOEmuCentimeter;
import org.eclipse.rcpl.databinding.types.JOEmuInches;
import org.eclipse.rcpl.databinding.types.JOEmuPixel;
import org.eclipse.rcpl.databinding.types.JOEmuPoint;

/**
 * 
 * 1 point = 8.269 inch = 2,54 cm; 16839 Hoehe A4 = / 20 --> 841.95 points
 * 841.95 x 8.269 = 6962.08455 inch 1140 so viel pixel bei 96 dot per inch 96 x
 * 8.269 = 16839 / 20 = 841.95 points bs = 10 zoll hoch
 * 
 * 47.7 cm = 18.78 inch = 1900 pixel -> 1 pixel = 101.17 pixel / inch 72.27
 * points / inch -> 879.27293 points. -> points2 pixel = 2.1608 --- kann nicht
 * sein
 * 
 * 101 points / inch -> 1167.984 points. -> points2 pixel = 1.6267
 * 
 * 
 * @author ramin
 * 
 */
public class RcplConversion {

	private static double transFormFactor = -1;

	// 4K 3480 x 2160
	//

	public static class Emu {
		private BigInteger emu;
		private double points = -1;
		private double pixel = -1;
		private double cm = -1;

		public Emu(BigInteger emu) {
			this.emu = emu;
			this.points = emu2Points(emu);
			this.cm = emu2Centimeter(emu.longValue());
		}

		public Emu(double points) {
			this.points = points;
			this.emu = Pt2Emu(points);
			this.pixel = pointsToPixel(points);
			this.cm = emu2Centimeter(emu.longValue());
		}

		public BigInteger getEmu() {
			return emu;
		}

		public double getPoints() {
			return points;
		}

		public double getPixel() {
			return pixel;
		}

		public double getCm() {
			return cm;
		}

	}

	public static double pointsToPixel(double points) {
		return pointsToPixelDouble(points);
	}

	public static double pointsToPixelDouble(double points) {
		return points * RcplUtil.getPoint2PixelFactor();
	}

	public static double pixelToPoints(double pixel) {
		return pixel / RcplUtil.getPoint2PixelFactor();
	}

	public static double pointsAndInchesToCm(String pointsAndInches) {
		if (pointsAndInches.endsWith("pt")) { //$NON-NLS-1$
			pointsAndInches = pointsAndInches.substring(0, pointsAndInches.length() - 2);
			double points = Double.valueOf(pointsAndInches);
			double cm = new Emu(points).getCm();
			return cm;
		} else if (pointsAndInches.endsWith("in")) { //$NON-NLS-1$
			pointsAndInches = pointsAndInches.substring(0, pointsAndInches.length() - 2);
			Emu emu = new Emu(inch2Emu(Double.valueOf(pointsAndInches)));
			double cm = emu.getCm();
			return cm;
		}
		return 0;
	}

	public static double pointsAndInchesToPixel(String pointsAndInches) {
		if (pointsAndInches.endsWith("pt")) { //$NON-NLS-1$
			pointsAndInches = pointsAndInches.substring(0, pointsAndInches.length() - 2);
			return pointsToPixel(Double.valueOf(pointsAndInches));
		} else if (pointsAndInches.endsWith("in")) { //$NON-NLS-1$
			pointsAndInches = pointsAndInches.substring(0, pointsAndInches.length() - 2);
			return emu2Pixel(inch2Emu(Double.valueOf(pointsAndInches)));
		}
		return 0;
	}

	public static String pixelToPointString(double pixel) {
		return pixel / RcplUtil.getPoint2PixelFactor() + "pt"; //$NON-NLS-1$
	}

	/**
	 * @param pointsAndInches
	 * @return
	 */
	public static BigInteger pointsAndInchesAndValuesToEmu(String pointsAndInches) {

		String s = pointsAndInches.replaceAll("width:", "").replaceAll("height:", "");

		try {
			if (s.startsWith("val ")) { //$NON-NLS-1$
				s = s.substring(4, s.length());
				return BigInteger.valueOf(Long.valueOf(s));

			}
			if (s.endsWith("pt")) { //$NON-NLS-1$
				s = s.substring(0, s.length() - 2);
				return Pt2Emu(Double.valueOf(s));
			} else if (s.endsWith("in")) { //$NON-NLS-1$
				s = s.substring(0, s.length() - 2);
				return inch2Emu(Double.valueOf(s));
			}
		} catch (Exception ex) {
			// LOGGER.error("", ex); //$NON-NLS-1$
		}
		return null;
	}

	public static double inch2Cm(double inch) {
		return inch * 2.54;
	}

	/**
	 * @param inch
	 * @return
	 */
	public static BigInteger inch2Emu(double inch) {
		return BigInteger.valueOf((long) (inch * 914400));
	}

	public static double emu2Inch(double emu) {
		return emu / 914400;
	}

	public static double getTransFormFactor() {
		if (transFormFactor == -1) {
			transFormFactor = 1.0 / pointsToPixelDouble(1.0 / 20.0);
		}
		return transFormFactor;
	}

	public static void setTransFormFactor(double transFormFactor) {
		RcplConversion.transFormFactor = transFormFactor;
	}

	public static void setEuropean() {

	}

	public static double emu2Points(BigInteger emu) {
		return emu.doubleValue() / 12700.0;
	}

	public static double emu2Points(long emu) {
		return emu / 12700.0;
	}

	public static double emu2Points(double emu) {
		return emu / 12700.0;
	}

	public static BigInteger Pt2Emu(double points) {
		return BigInteger.valueOf((long) (points * 12700.0));
	}

	public static double emu2Pixel(BigInteger emu) {
		return pointsToPixel(emu2Points(emu));
	}

	public static double emu2Pixel(long emu) {
		return pointsToPixel(emu2Points(emu));
	}

	public static double emu2Pixel(double emu) {
		return pointsToPixel(emu2Points(emu));
	}

	public static double emu2Centimeter(double emu) {
		return emu / 360000.0;
	}

	public static double emu2Millimeter(double emu) {
		return emu / 36000.0;
	}

	public static double millimeterToEmu(double millimeter) {
		return millimeter * 36000.0;
	}

	public static double millimeterToPixel(double millimeter) {
		return emu2Pixel(millimeterToEmu(millimeter));
	}

	public static double ptToEmu() {
		return millimeterToEmu(127.0 * 36000.0);
	}

	public static double pixelToEmu(double pixel) {
		return Pt2Emu(pixelToPoints(pixel)).doubleValue();
	}

	public static double pixelToCm(double pixel) {
		double emu = pixelToEmu(pixel);
		double cm = emu2Centimeter(emu);
		return cm;
	}

	public static double pixelToInch(double pixel) {
		double emu = pixelToEmu(pixel);
		double inch = emu2Inch(emu);
		return inch;
	}

	/**
	 * @param from
	 * @param to
	 * @param value
	 * @return
	 */
	public static double unit2Unit(EnMeasurementUnits from, EnMeasurementUnits to, double value) {
		JOEmu fromEmu = null;
		switch (from) {
		case CM:
			fromEmu = new JOEmuCentimeter(value);
			break;
		case MILLIMETER:
			fromEmu = new JOEmuCentimeter(value / 10);
			break;
		case PICAS:
			fromEmu = new JOEmuPixel(value);
			break;
		case INCHES:
			fromEmu = new JOEmuInches(value);
			break;
		case PIXEL:
			fromEmu = new JOEmuPixel(value);
			break;
		case POINTS:
			fromEmu = new JOEmuPoint(value);
			break;
		}

		if (fromEmu != null) {
			switch (to) {
			case CM:
				return fromEmu.toCm();
			case MILLIMETER:
				return fromEmu.toCm() * 10;
			case PICAS:
				return fromEmu.toPixel();
			case INCHES:
				return fromEmu.toInch();
			case PIXEL:
				return fromEmu.toPixel();
			case POINTS:
				return fromEmu.toPoints();
			}
		}
		return value;

	}

}
