package org.eclipse.rcpl;

import java.io.File;
import java.util.List;

import org.eclipse.rcpl.model_2_0_0.rcpl.Perspective;

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

	void addSelectedDraggable(ILayoutFigure f);

	void removeSelectedDraggable(ILayoutFigure f);

	void clearSelectedDraggables();

	List<ILayoutFigure> getSelectedDraggables();

	IParagraph getFirstSelectionParagraph();

	IParagraph getLastSelectionParagraph();

	void layout();

	void setLayoutReason(EnLayoutReason reason);

	void addDirtyLayoutObject(ILayoutObject layoutObject);

	ILayoutObject nextDirtyLayoutObject();

	ILayoutService getLayoutService();

	boolean isLayouted();

	void updateOutline();

	boolean isDisposed();

	void showPageGroup(boolean show);

	void updateDocumentInfo();

	void finishAddPages();

	void setActualPage(IPage actualPage);

	void stopScroll();

	boolean updateScrollTargetForCaret();

	void scrollPageDown();

	void scrollPageUp();

	boolean isDirty();

	IPage getLastPage();

	IPage getFirstPage();

	List<IPage> getPages();

	void removeEmptyPages();

	void addPage(IPage page);

	void addPage(final IPage page, int index);

	void centerHorizontally();

	void collapseHorizontalRuler();

	boolean dispose();

	void expandHorizontalRuler();

	void expandVerticalArea();

	IPage findFirstPageOfSection();

	ILayoutObject getAnchorObject();

	IDocument getDocument();

	EnDocumentType getDocumentType();

	Parent getNode();

	IPage getPage(int index);

	int getPageColumns();

	int getPageCount();

	int getPageIndex(IPage page);

	double getScale();

	ILayoutObject getSelectedLayoutObject();

	IPage getSelectedPage();

	IParagraph getActiveParagraph();

	Object getTabItem();

	boolean hasPages();

	boolean isEnableCommandStack();

	boolean isLastPage(IPage page);

	boolean isReadOnly();

	boolean isShowLines();

	boolean isShowOutline();

	boolean isSlideMasterView();

	boolean isSortMode();

	boolean isSuppressClipChildren();

	boolean isTwoPageLayout();

	void positionToLastEditParagraph();

	void redo();

	void removePage(IPage page);

	void resetAll();

	void setAnchorObject(ILayoutObject lo);

	void setBrowser(IBrowser browser);

	void setDocument(IDocument document);

	void setEnableCommandStack(boolean enable);

	void setPageColumns(int columns);

	void setPages(List<IPage> pages);

	void setPrintMode(boolean noParagraphImages);

	void setResizeAutomatic(boolean auto);

	void setScale(double scale);

	boolean setSelectedPage(IPage page);

	void setSelectedParagraph(IParagraph paragraph);

	void setShowGrid(boolean show);

	void setShowLines(boolean showLines);

	void setShowOutline(boolean show);

	void setShowOutlineParagraph(boolean show);

	void setSortMode(boolean sortMode);

	void setSuppressClipChildren(boolean suppress);

	void showAspect();

	void showAspect(EnDocumentType type, boolean fx);

	void showOutline(boolean show);

	void undo();

	void updateCanvasSize();

	void updatePageVisibility(boolean isScrollBarEvent);

	void unselectAllParagraphs();

	boolean hasSelection();

	double getZoom();

	boolean isEditable();

	void showTools(boolean show);

	void hideAnchor();

	void showAnchor(ILayoutFigure figure);

	Perspective getPerspective();

	void showEditorTools(boolean show);

	void loadDocument(final String docName, String tabName, File file);

}
