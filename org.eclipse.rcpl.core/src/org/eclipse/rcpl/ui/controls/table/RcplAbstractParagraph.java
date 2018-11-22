package org.eclipse.rcpl.ui.controls.table;

import java.util.Iterator;
import java.util.List;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.xmlbeans.XmlObject;
import org.eclipse.rcpl.EnLayoutAlignment;
import org.eclipse.rcpl.EnLayoutReason;
import org.eclipse.rcpl.IAlignment;
import org.eclipse.rcpl.IBorder;
import org.eclipse.rcpl.ICell;
import org.eclipse.rcpl.IColor;
import org.eclipse.rcpl.IColorProperty;
import org.eclipse.rcpl.IDocument;
import org.eclipse.rcpl.IDrawing;
import org.eclipse.rcpl.IEditor;
import org.eclipse.rcpl.IJOProperty;
import org.eclipse.rcpl.ILayoutAnchor;
import org.eclipse.rcpl.ILayoutFigure;
import org.eclipse.rcpl.ILayoutObject;
import org.eclipse.rcpl.IPage;
import org.eclipse.rcpl.IParagraph;
import org.eclipse.rcpl.IParagraphFigure;
import org.eclipse.rcpl.IProperty2;
import org.eclipse.rcpl.ISection;
import org.eclipse.rcpl.ITableCell;
import org.eclipse.rcpl.internal.tools.IStyle;
import org.eclipse.rcpl.model.IImage;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;

import javafx.geometry.Rectangle2D;

/**
 * @author Ramin
 *
 */
public abstract class RcplAbstractParagraph implements IParagraph {

	@Override
	public IColorProperty getLineColorProperty() {

		return null;
	}

	@Override
	public void boundsChanged2(Rectangle2D newBounds) {

	}

	@Override
	public boolean commit() {

		return false;
	}

	@Override
	public ILayoutFigure createLayoutFigure() {

		return null;
	}

	@Override
	public void createOverflowFigure(double remaining) {

	}

	@Override
	public void deActivate() {

	}

	@Override
	public void detachOverflowFigure() {

	}

	@Override
	public boolean dispose() {

		return false;
	}

	@Override
	public IBorder getBorder() {

		return null;
	}

	@Override
	public double getBottomMargin() {

		return 0;
	}

	@Override
	public List<ILayoutObject> getChildList() {

		return null;
	}

	@Override
	public ILayoutObject[] getChildren() {

		return null;
	}

	@Override
	public String getDisplayName() {

		return null;
	}

	@Override
	public IDocument getDocument() {

		return null;
	}

	@Override
	public IEditor getEditor() {

		return null;
	}

	@Override
	public ILayoutAnchor getHAnchor() {

		return null;
	}

	@Override
	public ILayoutObject getHAnchorObject() {

		return null;
	}

	@Override
	public double getHeightOverflow() {

		return 0;
	}

	@Override
	public double getHeightPixel() {

		return 0;
	}

	@Override
	public IImage getImage() {

		return null;
	}

	@Override
	public IJOProperty getIndent() {

		return null;
	}

	@Override
	public int getIndex() {

		return 0;
	}

	@Override
	public IProperty2 getInsets() {

		return null;
	}

	@Override
	public Rectangle2D getLayoutBounds() {

		return null;
	}

	@Override
	public int getLayoutIndex() {

		return 0;
	}

	@Override
	public double getLeftMargin() {

		return 0;
	}

	@Override
	public ILayoutObject getNextRootObject() {

		return null;
	}

	@Override
	public IParagraph getNextRootParagraph() {

		return null;
	}

	@Override
	public ILayoutFigure getOverflowFigure() {

		return null;
	}

	@Override
	public IPage getPage() {

		return null;
	}

	@Override
	public ILayoutObject getParent() {

		return null;
	}

	@Override
	public ILayoutObject getPreviousRootObject() {

		return null;
	}

	@Override
	public IParagraph getPreviousRootParagraph() {

		return null;
	}

	@Override
	public double getRightMargin() {

		return 0;
	}

	@Override
	public int getRootIndex() {

		return 0;
	}

	@Override
	public ILayoutObject getRootObject() {

		return null;
	}

	@Override
	public int getRootObjectIndex() {

		return 0;
	}

	@Override
	public double getRotation() {

		return 0;
	}

	@Override
	public double getSavedZOrder() {

		return 0;
	}

	@Override
	public ISection getSection() {

		return null;
	}

	@Override
	public IProperty2 getSize() {

		return null;
	}

	@Override
	public double getSpacingAfterPixel() {

		return 0;
	}

	@Override
	public double getSpacingBeforePixel() {

		return 0;
	}

	@Override
	public IStyle getStyle() {

		return null;
	}

	@Override
	public double getTopMargin() {

		return 0;
	}

	@Override
	public ILayoutAnchor getVAnchor() {

		return null;
	}

	@Override
	public ILayoutObject getVAnchorObject() {

		return null;
	}

	@Override
	public double getWidthPixel() {

		return 0;
	}

	@Override
	public EnLayoutAlignment getxAlign() {

		return null;
	}

	@Override
	public XmlObject getXmlObject() {

		return null;
	}

	@Override
	public double getXPixel() {

		return 0;
	}

	@Override
	public EnLayoutAlignment getyAlign() {

		return null;
	}

	@Override
	public double getYPixel() {

		return 0;
	}

	@Override
	public double getZOrder() {

		return 0;
	}

	@Override
	public boolean isBehindDoc() {

		return false;
	}

	@Override
	public boolean isDirtyContent() {

		return false;
	}

	@Override
	public boolean isOverflowActive() {

		return false;
	}

	@Override
	public boolean isPageBreakAfter() {

		return false;
	}

	@Override
	public boolean isRealPageBreakAfterAndNoSectionBreak() {

		return false;
	}

	@Override
	public boolean isRootObject() {

		return false;
	}

	@Override
	public boolean isTestLayout() {

		return false;
	}

	@Override
	public Iterator<ILayoutObject> iterator() {

		return null;
	}

	@Override
	public void layout(EnLayoutReason reason) {

	}

	@Override
	public void remove(ILayoutObject lo) {

	}

	@Override
	public void removeChildren() {

	}

	@Override
	public void setBorderColor(IColor color) {

	}

	@Override
	public void setDirtyContent(boolean dirty) {

	}

	@Override
	public void setHAnchorObject(ILayoutObject anchorObject) {

	}

	@Override
	public void setHeightOverflow(double heightOverflow) {

	}

	@Override
	public void setHeightPixel(double height) {

	}

	@Override
	public void setLayoutBounds(Rectangle2D layoutBounds) {

	}

	@Override
	public void setLayoutFigure(ILayoutFigure f) {

	}

	@Override
	public void setOverflowActive(boolean overflowActive) {

	}

	@Override
	public void setPage(IPage page) {

	}

	@Override
	public void setPageBreakBefore(boolean breakBefore) {

	}

	@Override
	public void setParent(ILayoutObject lo) {

	}

	@Override
	public void setRootObject(boolean root) {

	}

	@Override
	public void setRotation(double rotation) {

	}

	@Override
	public void setTestLayout(boolean testlayout) {

	}

	@Override
	public void setVAnchorObject(ILayoutObject anchorObject) {

	}

	@Override
	public void setWidthPixel(double width) {

	}

	@Override
	public void setXmlIndex(int index) {

	}

	@Override
	public void setZOrder(double order) {

	}

	@Override
	public void setZOrderBehindDoc(boolean behindDoc) {

	}

	@Override
	public void update() {

	}

	@Override
	public void updateFromXml() {

	}

	@Override
	public void updateOverflowClipping() {

	}

	@Override
	public void setColumn(int column) {

	}

	@Override
	public int getColumn() {

		return 0;
	}

	@Override
	public void setRow(int row) {

	}

	@Override
	public int getRow() {

		return 0;
	}

	@Override
	public void setWidth(double width) {

	}

	@Override
	public void setHeight(double height) {

	}

	@Override
	public double getHeight() {

		return 0;
	}

	@Override
	public double getWidth() {

		return 0;
	}

	@Override
	public boolean isEmpty() {

		return false;
	}

	@Override
	public void createBorder() {

	}

	@Override
	public void removeBullet() {

	}

	@Override
	public void setBullet() {

	}

	@Override
	public void setBulletNumber(int level, int number) {

	}

	@Override
	public boolean hasBulletNumber() {

		return false;
	}

	@Override
	public boolean hasBullet() {

		return false;
	}

	@Override
	public boolean isSelected() {

		return false;
	}

	@Override
	public void setIndentation(double pixel) {

	}

	@Override
	public void advanceCaretOffset() {

	}

	@Override
	public void backCaretOffset() {

	}

	@Override
	public int getCaretOffset() {

		return 0;
	}

	@Override
	public void setCaretOffset(int offset) {

	}

	@Override
	public boolean isLoaded() {

		return false;
	}

	@Override
	public IParagraphFigure getLayoutFigure() {

		return null;
	}

	@Override
	public void activate() {

	}

	@Override
	public void addStyle(IStyle style) {

	}

	@Override
	public void applyBackground(int start, int length, IColor color) {

	}

	@Override
	public void applyBold(int start, int length, boolean bold) {

	}

	@Override
	public void applyForeground(int start, int length, IColor color) {

	}

	@Override
	public void applyHeight(int start, int length, double height) {

	}

	@Override
	public void applyItalic(int start, int length, boolean italic) {

	}

	@Override
	public void applyUnderline(int start, int length, boolean underline) {

	}

	@Override
	public void applyStrikeThrough(int start, int length, boolean strikeThrough) {

	}

	@Override
	public void applySubScript(int start, int length, boolean subScript) {

	}

	@Override
	public void applySuperScript(int start, int length, boolean superScript) {

	}

	@Override
	public void clearRunStyles() {

	}

	@Override
	public CTR createRun() {

		return null;
	}

	@Override
	public IStyle findCharacterStyleAtOffset() {

		return null;
	}

	@Override
	public IStyle findCharacterStyleAtOffset(int offset) {
		return null;
	}

	@Override
	public IAlignment getAlignment() {

		return null;
	}

	@Override
	public ICell getCell() {

		return null;
	}

	@Override
	public IStyle[] getCharaterStyles(int fromIndex, int toIndex) {

		return null;
	}

	@Override
	public double getCellMarginBottom() {

		return 0;
	}

	@Override
	public double getCellMarginLeft() {

		return 0;
	}

	@Override
	public double getCellMarginTop() {

		return 0;
	}

	@Override
	public IStyle[] getCharaterStyles() {

		return null;
	}

	@Override
	public int getCharCount() {

		return 0;
	}

	@Override
	public List<IDrawing> getDrawings() {

		return null;
	}

	@Override
	public boolean getJustify() {

		return false;
	}

	@Override
	public int getLineAlignment(int line) {

		return 0;
	}

	@Override
	public IProperty2 getMarginLeft() {

		return null;
	}

	@Override
	public IParagraph getNextParagraph() {

		return null;
	}

	@Override
	public int getSelectionEnd() {

		return 0;
	}

	@Override
	public int getSelectionLength() {

		return 0;
	}

	@Override
	public int getSelectionStart() {

		return 0;
	}

	@Override
	public IProperty2 getSpacingAfter() {

		return null;
	}

	@Override
	public ITableCell getTableCell() {

		return null;
	}

	@Override
	public IJOProperty getTabs() {

		return null;
	}

	@Override
	public double getTextBoundsHeight() {

		return 0;
	}

	@Override
	public StringBuilder getTextBuffer() {

		return null;
	}

	@Override
	public boolean hasCell() {

		return false;
	}

	@Override
	public boolean hasDrawing() {

		return false;
	}

	@Override
	public boolean hasSelection() {

		return false;
	}

	@Override
	public boolean isAllSelected() {

		return false;
	}

	@Override
	public boolean isPageBreakBefore() {

		return false;
	}

	@Override
	public boolean isStartNewSection() {

		return false;
	}

	@Override
	public boolean selectAll() {

		return false;
	}

	@Override
	public void setAlignment(ParagraphAlignment align) {

	}

	@Override
	public void setBold(boolean bold) {

	}

	@Override
	public void setFontSize(double fontSize) {

	}

	@Override
	public void setItalic(boolean bold) {

	}

	@Override
	public void setSelectionEnd(int selectionEnd) {

	}

	@Override
	public void setSelectionStart(int selectionStart) {

	}

	@Override
	public void setStyle(IStyle style) {

	}

	@Override
	public void setTableCell(ITableCell cell) {

	}

	@Override
	public void setText(String text) {

	}

	@Override
	public void setTextBoundsHeight(double textBoundsHeight) {

	}

	@Override
	public void setUnderline(boolean underline) {

	}

	@Override
	public void clearSelection() {

	}

	@Override
	public void updateFromXml(boolean update) {

	}

	@Override
	public void applyFontName(int start, int length, String fontName) {

	}

	@Override
	public void setFontName(String fontName) {

	}

	@Override
	public String getText() {

		return null;
	}

}
