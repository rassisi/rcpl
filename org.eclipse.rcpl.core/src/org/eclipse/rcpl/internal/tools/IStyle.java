package org.eclipse.rcpl.internal.tools;

import org.eclipse.rcpl.EStyleType;
import org.eclipse.rcpl.EnShading;
import org.eclipse.rcpl.IBoolean;
import org.eclipse.rcpl.IBorder;
import org.eclipse.rcpl.IColor;
import org.eclipse.rcpl.IDrawing;
import org.eclipse.rcpl.IEmuProperty2;
import org.eclipse.rcpl.IFont;
import org.eclipse.rcpl.IJOProperty;
import org.eclipse.rcpl.ILayoutObject;
import org.eclipse.rcpl.ILineSpacingProperty;
import org.eclipse.rcpl.IShadow;
import org.eclipse.rcpl.model.IImage;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;

/**
 * @author ramin
 *
 */
public interface IStyle {

	// ---------- new property2 --- see JOStyle for implementation
	// TODO: change all properties to this concept

	IColor getHighlightColor();

	void setHighlightColor(ILayoutObject layoutObject, CTR ctr);

	void setHighlightColor(IColor color);

	// ---------- This is the new property design pattern

	double getSpacingAfter();

	double getSpacingBefore();

	double getSpacingLine();

	void setSpacingBefore(double spacingBefore);

	void setSpacingAfter(double spacingAfter);

	void setSpacingLine(double spacingLine);

	void setSpacingAfterProperty(IEmuProperty2 spacingAfter);

	void setSpacingLineProperty(ILineSpacingProperty spacingLine);

	void setSpacingBeforeProperty(IEmuProperty2 spacingBefore);

	IEmuProperty2 getSpacingAfterProperty();

	ILineSpacingProperty getSpacingLineProperty();

	IEmuProperty2 getSpacingBeforeProperty();

	// ------------------------------------------------------

	IEmuProperty2 getCellMarginLeft();

	void setCellMarginLeft(IEmuProperty2 cellMarginLeft);;

	void setCellMarginRight(IEmuProperty2 cellMarginRight);

	IEmuProperty2 getCellMarginTop();

	void setCellMarginTop(IEmuProperty2 cellMarginTop);

	IEmuProperty2 getCellMarginBottom();

	void setCellMarginBottom(IEmuProperty2 cellMarginBottom);

	double getCellMarginLeftPixel();

	double getCellMarginRightPixel();

	double getCellMarginTopPixel();

	double getCellMarginBottomPixel();

	IStyle copy();

	void copyAttributesTo(IStyle dest0);

	IColor getBackground();

	IStyle getBasedOnStyle();

	IBorder getBorder();

	CTR getCtr();

	IDrawing getDrawing();

	IFont getFont();

	IColor getForeGround();

	String getHyperText();

	String getId();

	IImage getImage();

	IJOProperty getIndent();

	CTOnOff getKeepNext();

	int getLength();

	String getName();

	IStyle getNextStyle();

	IJOProperty getPageBreakBefore();

	EnShading getShading();

	int getStart();

	Object getTabs();

	IJOProperty getTextAlignment();

	EStyleType getType();

	boolean isBold();

	boolean isItalic();

	boolean isStrikeThrough();

	void setStrikeThrough(IBoolean strikeThrough);

	void setStrikeThrough(boolean strikeThrough);

	void setSubScript(boolean subScript);

	boolean isSubScript();

	void setSuperScript(boolean superScript);

	boolean isSuperScript();

	boolean isUnderline();

	void setBackground(IColor color);

	void setBasedOnStyle(IStyle basedOnStyle);

	void setBold(boolean bold);

	void setBorder(IBorder border);

	void setCtr(CTR ctr);

	void setDrawing(IDrawing drawing);

	void setFont(IFont font);

	void setFonts(CTFonts ctFonts);

	void setForeground(IColor color);

	void setHeight(double height);

	void setHyperText(String hyperText);

	void setId(String id);

	void setImage(IImage image);

	void setImage(IImage image, double width, double height);

	void setIndent(IJOProperty indent);

	void setItalic(boolean italic);

	void setKeepNext(CTOnOff keepNext);

	void setLength(int length);

	void setPageBreakBefore(IJOProperty pageBreakBefore);

	void setShading(EnShading shading);

	void setStart(int start);

	void setTabs(Object tabs);

	void setStyleLess();

	boolean isStyleLess();

	void setTextAlignment(IJOProperty alignment);

	void setUnderline(boolean underline);

	void updateFont();

	double getSpaceLine();

	public IShadow getShadow();

	public void setShadow(IShadow shadow);

	boolean isTemplateStyle();
}
