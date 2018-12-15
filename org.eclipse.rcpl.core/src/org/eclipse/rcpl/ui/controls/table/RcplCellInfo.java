package org.eclipse.rcpl.ui.controls.table;

import org.eclipse.rcpl.IColor;

/**
 * @author Ramin
 *
 */
public class RcplCellInfo {

	public int x;

	public int y;

	public int spanX;

	public int spanY;

	public boolean wrap;

	public IColor borderColor;

	public double borderWidth;

	public IColor bgColor;

	public IColor borderColorTop;

	public double borderWidthTop;

	public IColor borderColorRight;

	public double borderWidthRight;

	public IColor borderColorBottom;

	public double borderWidthBottom;

	public IColor borderColorLeft;

	public double borderWidthLeft;

	public RcplCellInfo(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public String getStyle() {
		StringBuilder sb = new StringBuilder();
		if (borderColor != null && borderWidth > 0) {
			sb.append("-fx-border-color: " + borderColor.toCss() + ";" + "-fx-border-width: " + borderWidth + ";");
		}

		else

		{

			// ----------- partial borders ------------------

			sb.append("-fx-border-color: ");
			if (borderColorTop != null) {
				sb.append(borderColorTop.toCss());
			} else {
				sb.append("black");
			}
			sb.append(" ");
			if (borderColorRight != null) {
				sb.append(borderColorRight.toCss());
			} else {
				sb.append("black");
			}
			sb.append(" ");
			if (borderColorBottom != null) {
				sb.append(borderColorBottom.toCss());
			} else {
				sb.append("black");
			}
			sb.append(" ");
			if (borderColorLeft != null) {
				sb.append(borderColorLeft.toCss());
			} else {
				sb.append("black");
			}

			sb.append(";");

			// --------- width

			sb.append("-fx-border-width: ");

			sb.append(borderWidthTop);
			sb.append(" ");
			sb.append(borderWidthRight);
			sb.append(" ");
			sb.append(borderWidthBottom);
			sb.append(" ");
			sb.append(borderWidthLeft);
			sb.append(";");

		}

		if (bgColor != null) {
			sb.append("-fx-background-color: " + bgColor.toCss() + ";");
		}

		return sb.toString();
	}
}
