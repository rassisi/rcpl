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

	void activate();

	void addStyle(IStyle style);

	void advanceCaretOffset();

	void applyBackground(IColor color);

	void applyBold(boolean bold);

	void applyFontName(String fontName);

	void applyFontSize(double height);

	void applyForeground(IColor color);

	void applyHighlight(IColor color);

	void applyItalic(boolean italic);

	void applyStrikeThrough(boolean strikeThrough);

	void applySubScript(boolean subScript);

	void applySuperScript(boolean superScript);

	void applyUnderline(boolean underline);

	void backCaretOffset();

	void clearRunStyles();

	void clearSelection();

	void createBorder();

	CTR createRun();

	IStyle findCharacterStyleAtOffset();

	IStyle findCharacterStyleAtOffset(int offset);

	IAlignment getAlignment();

	int getCaretOffset();

	ICell getCell();

	double getCellMarginBottom();

	double getCellMarginLeft();

	double getCellMarginTop();

	List<IStyle> getCharaterStyles();

	List<IStyle> getCharaterStyles(int fromIndex, int toIndex);

	int getCharCount();

	List<IDrawing> getDrawings();

	boolean getJustify();

	@Override
	IParagraphFigure getLayoutFigure();

	int getLineAlignment(int line);

	IProperty2 getMarginLeft();

	IParagraph getNextParagraph();

	int getSelectionEnd();

	int getSelectionLength();

	int getSelectionStart();

	ITableCell getTableCell();

	IJOProperty getTabs();

	String getText();

	double getTextBoundsHeight();

	StringBuilder getTextBuffer();

	boolean hasBullet();

	boolean hasBulletNumber();

	boolean hasCell();

	boolean hasDrawing();

	boolean hasSelection();

	boolean isAllSelected();

	boolean isLoaded();

	@Override
	boolean isPageBreakBefore();

	boolean isSelected();

	@Override
	boolean isStartNewSection();

	void removeBullet();

	boolean selectAll();

	void setAlignment(ParagraphAlignment align);

	void setBold(boolean bold);

	void setBullet();

	void setBulletNumber(int level, int number);

	void setCaretOffset(int offset);

	void setFontName(String fontName);

	void setFontSize(double fontSize);

	void setIndentation(double pixel);

	void setItalic(boolean bold);

	void setSelectionEnd(int selectionEnd);

	void setSelectionStart(int selectionStart);

	void setStyle(IStyle style);

	void setTableCell(ITableCell cell);

	void setText(String text);

	void setTextBoundsHeight(double textBoundsHeight);

	void setUnderline(boolean underline);

	void updateFromXml(boolean update);

}
