package org.eclipse.rcpl;

import java.util.List;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.eclipse.rcpl.internal.tools.IStyle;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;

/**
 * @author Ramin
 *
 */
public interface IParagraph extends ILayoutObject, ICellable {

	void createBorder();

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

	void applyHighlight(int start, int length, IColor color);

	void applyHeight(int start, int length, double height);

	void applyItalic(int start, int length, boolean italic);

	void applyUnderline(int start, int length, boolean underline);

	void applyStrikeThrough(int start, int length, boolean strikeThrough);

	void applySubScript(int start, int length, boolean subScript);

	void applySuperScript(int start, int length, boolean superScript);

	void clearRunStyles();

	CTR createRun();

	IStyle findCharacterStyleAtOffset();

	IStyle findCharacterStyleAtOffset(int offset);

	IAlignment getAlignment();

	ICell getCell();

	List<IStyle> getCharaterStyles(int fromIndex, int toIndex);

	double getCellMarginBottom();

	double getCellMarginLeft();

	double getCellMarginTop();

	List<IStyle> getCharaterStyles();

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

	@Override
	boolean isPageBreakBefore();

	@Override
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

	String getText();

}
