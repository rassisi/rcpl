package org.eclipse.rcpl.ui.controls.table;

import java.util.Iterator;
import java.util.List;

import org.apache.xmlbeans.XmlObject;
import org.eclipse.rcpl.EnLayoutAlignment;
import org.eclipse.rcpl.EnLayoutReason;
import org.eclipse.rcpl.IBorder;
import org.eclipse.rcpl.IColor;
import org.eclipse.rcpl.IColorProperty;
import org.eclipse.rcpl.IDocument;
import org.eclipse.rcpl.IEditor;
import org.eclipse.rcpl.IJOProperty;
import org.eclipse.rcpl.ILayoutAnchor;
import org.eclipse.rcpl.ILayoutFigure;
import org.eclipse.rcpl.ILayoutObject;
import org.eclipse.rcpl.IPage;
import org.eclipse.rcpl.IParagraph;
import org.eclipse.rcpl.IProperty2;
import org.eclipse.rcpl.ISection;
import org.eclipse.rcpl.internal.tools.IStyle;
import org.eclipse.rcpl.model.IImage;

import javafx.geometry.Rectangle2D;

public class RcplLayoutObjectAdapter implements ILayoutObject {

	private RcplCellInfo cellInfo;

	@Override
	public boolean isStartNewSection() {
		return false;
	}

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
	public ILayoutFigure getLayoutFigure() {

		return null;
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
	public boolean isPageBreakBefore() {

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
	public void setCellInfo(RcplCellInfo cellInfo) {
		this.cellInfo = cellInfo;
	}

	@Override
	public RcplCellInfo getCellInfo() {
		return cellInfo;
	}

	@Override
	public int getRow() {
		if (cellInfo != null) {
			return cellInfo.x;
		}
		return -1;
	}

	@Override
	public int getColumn() {
		if (cellInfo != null) {
			return cellInfo.x;
		}
		return -1;
	}

	@Override
	public double getSpacingBefore() {
		// TODO Auto-generated method stub
		return 0;
	}

}
