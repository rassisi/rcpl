package org.eclipse.rcpl;

import java.util.List;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;

public interface IParagraph extends ILayoutObject {

	void removeBullet();

	void setBullet();

	void setBulletNumber(int level, int number);

	boolean hasBulletNumber();

	boolean hasBullet();

	boolean isSelected();

	void setIndentation(double pixel);

	void advanceCaretOffset();

	void backCaretOffset();

	int getCaretOffset();

	void setCaretOffset(int offset);

	boolean isLoaded();

	@Override
	IParagraphFigure getLayoutFigure();

	void activate();

	void addStyle(IStyle style);

	void applyBackground(int start, int length, IColor color);

	void applyBold(int start, int length, boolean bold);

	void applyForeground(int start, int length, IColor color);

	void applyHeight(int start, int length, double height);

	void applyItalic(int start, int length, boolean italic);

	void applyUnderline(int start, int length, boolean underline);

	void applyStrikeThrough(int start, int length, boolean strikeThrough);

	void applySubScript(int start, int length, boolean subScript);

	void applySuperScript(int start, int length, boolean superScript);

	void clearRunStyles();

	CTR createRun();

	IStyle findCharacterStyleAtOffset();

	List<IStyle> findCharacterStyleAtOffset(int offset);

	IAlignment getAlignment();

	ICell getCell();

	IStyle[] getCharaterStyles(int fromIndex, int toIndex);

	double getCellMarginBottom();

	double getCellMarginLeft();

	double getCellMarginTop();

	IStyle[] getCharaterStyles();

	int getCharCount();

	List<IDrawing> getDrawings();

	boolean getJustify();

	int getLineAlignment(int line);

	IProperty2 getMarginLeft();

	IParagraph getNextParagraph();

	int getSelectionEnd();

	int getSelectionLength();

	int getSelectionStart();

	IProperty2 getSpacingAfter();

	ITableCell getTableCell();

	IJOProperty getTabs();

	double getTextBoundsHeight();

	StringBuilder getTextBuffer();

	boolean hasCell();

	boolean hasDrawing();

	boolean hasSelection();

	boolean isAllSelected();

	boolean isPageBreakBefore();

	boolean isStartNewSection();

	boolean selectAll();

	void setAlignment(ParagraphAlignment align);

	void setBold(boolean bold);

	void setFontSize(double fontSize);

	void setItalic(boolean bold);

	void setSelectionEnd(int selectionEnd);

	void setSelectionStart(int selectionStart);

	void setStyle(IStyle style);

	void setTableCell(ITableCell cell);

	void setText(String text);

	void setTextBoundsHeight(double textBoundsHeight);

	void setUnderline(boolean underline);

	void clearSelection();

	void updateFromXml(boolean update);

	void applyFontName(int start, int length, String fontName);

	void setFontName(String fontName);
}
