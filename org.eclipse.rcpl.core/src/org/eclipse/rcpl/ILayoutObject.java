package org.eclipse.rcpl;

import java.util.List;

import org.apache.xmlbeans.XmlObject;
import org.eclipse.rcpl.internal.tools.IStyle;
import org.eclipse.rcpl.model.IImage;
import org.eclipse.rcpl.ui.controls.table.RcplCellInfo;

import javafx.geometry.Rectangle2D;

/**
 * @author ramin
 *
 */
public interface ILayoutObject {

	int getRow();

	int getColumn();

	void setCellInfo(RcplCellInfo cellInfo);

	RcplCellInfo getCellInfo();

	boolean isStartNewSection();

	IColorProperty getLineColorProperty();

	void boundsChanged2(Rectangle2D newBounds);

	boolean commit();

	ILayoutFigure createLayoutFigure();

	void createOverflowFigure(double remaining);

	void deActivate();

	void detachOverflowFigure();

	boolean dispose();

	IBorder getBorder();

	double getBottomMargin();

	List<ILayoutObject> getChildList();

	ILayoutObject[] getChildren();

	String getDisplayName();

	IDocument getDocument();

	IEditor getEditor();

	ILayoutAnchor getHAnchor();

	ILayoutObject getHAnchorObject();

	double getHeightOverflow();

	double getHeightPixel();

	IImage getImage();

	IJOProperty getIndent();

	int getIndex();

	IProperty2 getInsets();

	Rectangle2D getLayoutBounds();

	ILayoutFigure getLayoutFigure();

	double getLeftMargin();

	ILayoutObject getNextRootObject();

	IParagraph getNextRootParagraph();

	ILayoutFigure getOverflowFigure();

	IPage getPage();

	ILayoutObject getParent();

	ILayoutObject getPreviousRootObject();

	IParagraph getPreviousRootParagraph();

	double getRightMargin();

	int getRootIndex();

	ILayoutObject getRootObject();

	int getRootObjectIndex();

	public double getRotation();

	double getSavedZOrder();

	ISection getSection();

	IProperty2 getSize();

	double getSpacingAfterPixel();

	double getSpacingBeforePixel();

	IStyle getStyle();

	double getTopMargin();

	ILayoutAnchor getVAnchor();

	ILayoutObject getVAnchorObject();

	double getWidthPixel();

	EnLayoutAlignment getxAlign();

	XmlObject getXmlObject();

	double getXPixel();

	EnLayoutAlignment getyAlign();

	double getYPixel();

	double getZOrder();

	boolean isBehindDoc();

	boolean isDirtyContent();

	boolean isOverflowActive();

	boolean isPageBreakAfter();

	boolean isPageBreakBefore();

	boolean isRealPageBreakAfterAndNoSectionBreak();

	boolean isRootObject();

	boolean isTestLayout();

	java.util.Iterator<ILayoutObject> iterator();

	void layout(EnLayoutReason reason);

	void remove(ILayoutObject lo);

	void removeChildren();

	void setBorderColor(IColor color);

	void setDirtyContent(boolean dirty);

	void setHAnchorObject(ILayoutObject anchorObject);

	void setHeightOverflow(double heightOverflow);

	void setHeightPixel(double height);

	void setLayoutBounds(Rectangle2D layoutBounds);

	void setLayoutFigure(ILayoutFigure f);

	void setOverflowActive(boolean overflowActive);

	void setPage(IPage page);

	void setPageBreakBefore(boolean breakBefore);

	void setParent(ILayoutObject lo);

	void setRootObject(boolean root);

	public void setRotation(double rotation);

	void setTestLayout(boolean testlayout);

	void setVAnchorObject(ILayoutObject anchorObject);

	void setWidthPixel(double width);

	void setXmlIndex(int index);

	void setZOrder(double order);

	void setZOrderBehindDoc(boolean behindDoc);

	void update();

	void updateFromXml();

	void updateOverflowClipping();

}
