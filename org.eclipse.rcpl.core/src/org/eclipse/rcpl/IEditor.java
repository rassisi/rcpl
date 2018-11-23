package org.eclipse.rcpl;

import java.io.File;
import java.util.List;

import org.eclipse.rcpl.model_2_0_0.rcpl.Perspective;
import org.eclipse.rcpl.ui.listener.RcplEvent;

import javafx.scene.Parent;

/**
 * @author ramin
 *
 */
public interface IEditor extends ICommandProvider, ITaskViewProvider {

	public static final int TASK_LOAD_TEMPLATE_DOCUMENT = 1;

	public static final int TASK_LAYOUT_DOCUMENT = 2;

	public static final int TASK_FINISH_DOCUMENT = 3;

	public static final int TASK_ACTIVATE_FIRST_PARAGRAPH = 4;

	public static final int TASK_LOAD_FILE_DOCUMENT = 5;

	void addDirtyLayoutObject(ILayoutObject layoutObject);

	void addPage(IPage page);

	void addPage(final IPage page, int index);

	void addSelectedDraggable(ILayoutFigure f);

	void centerHorizontally();

	void clearSelectedDraggables();

	void collapseHorizontalRuler();

	boolean dispose();

	void expandHorizontalRuler();

	void expandVerticalArea();

	IPage findFirstPageOfSection();

	void finishAddPages();

	ILayoutObject getActiveLayoutObject();

	IParagraph getActiveParagraph();

	ILayoutObject getAnchorObject();

	IDocument getDocument();

	EnDocumentType getDocumentType();

	IPage getFirstPage();

	IParagraph getFirstSelectionParagraph();

	IPage getLastPage();

	IParagraph getLastSelectionParagraph();

	ILayoutService getLayoutService();

	Parent getNode();

	IPage getPage(int index);

	int getPageColumns();

	int getPageCount();

	int getPageIndex(IPage page);

	List<IPage> getPages();

	Perspective getPerspective();

	double getScale();

	List<ILayoutFigure> getSelectedDraggables();

	IPage getSelectedPage();

	Object getTabItem();

	double getZoom();

	boolean hasPages();

	boolean hasSelection();

	void hideAnchor();

	boolean isDirty();

	boolean isDisposed();

	boolean isEditable();

	boolean isEnableCommandStack();

	boolean isLastPage(IPage page);

	boolean isLayouted();

	boolean isReadOnly();

	boolean isShowLines();

	boolean isShowOutline();

	boolean isSlideMasterView();

	boolean isSortMode();

	boolean isSuppressClipChildren();

	boolean isTwoPageLayout();

	void layout();

	void layoutPages();

	void loadDocument(final String docName, String tabName, File file);

	ILayoutObject nextDirtyLayoutObject();

	void positionToLastEditParagraph();

	void redo();

	void removeEmptyPages();

	void removePage(IPage page);

	void removeSelectedDraggable(ILayoutFigure f);

	void resetAll();

	void save();

	void scrollPageDown();

	void scrollPageUp();

	void setActiveLayoutObject(ILayoutObject layoutObject);

	boolean setActivePage(IPage page);

	void setActualPage(IPage actualPage);

	void setAnchorObject(ILayoutObject lo);

	void setBrowser(IBrowser browser);

	void setDocument(IDocument document);

	void setEnableCommandStack(boolean enable);

	void setLayoutReason(EnLayoutReason reason);

	void setPageColumns(int columns);

	void setPages(List<IPage> pages);

	void setPrintMode(boolean noParagraphImages);

	void setResizeAutomatic(boolean auto);

	void setScale(double scale);

	void setShowGrid(boolean show);

	void setShowLines(boolean showLines);

	void setShowOutline(boolean show);

	void setShowOutlineParagraph(boolean show);

	void setSortMode(boolean sortMode);

	void setSuppressClipChildren(boolean suppress);

	void showAnchor(ILayoutFigure figure);

	void showAspect();

	void showAspect(EnDocumentType type, boolean fx);

	void showEditorTools(boolean show);

	void showOutline(boolean show);

	void showPageGroup(boolean show);

	void showTools(boolean show);

	void stopScroll();

	void undo();

	void unselectAllParagraphs();

	void updateCanvasSize();

	void updateDocumentInfo();

	void updateOutline();

	void updatePageVisibility(boolean isScrollBarEvent);

	boolean updateScrollTargetForCaret();

	void updateTools(RcplEvent event);

}
