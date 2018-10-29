package org.eclipse.rcpl;

import org.apache.poi.xwpf.usermodel.Borders;

/**
 * @author Ramin
 *
 */
public interface IBorder {

	void setLineWidth(double width);

	double getLineWidthPixel();

	double getDistanceTop();

	double getDistanceBottom();

	double getDistanceLeft();

	double getDistanceRight();

	double getLineWidthTop();

	double getLineWidthBottom();

	double getLineWidthLeft();

	double getLineWidthRight();

	IColor getBorderColorTop();

	IColor getBorderColorBottom();

	IColor getBorderColorLeft();

	IColor getBorderColorRight();

	void setBorder(Borders type, IColor topColor, double topWidth, IColor rightColor, double rightWidth,
			IColor bottomColor, double bottomWidth, IColor leftColor, double leftWidth);
}
