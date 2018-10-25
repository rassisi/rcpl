package org.eclipse.rcpl;

/**
 * @author ramin
 *
 */
public interface ILayoutService extends IService {

	void layoutPages();

	IPage addPage(IPage newPageFigure);

	IPage addPage(int index);

	IPage addPage(IPage newPageFigure, int index);

	IPage addPage(IPage newPageFigure, int index, boolean forceEven, boolean forceOdd);

	IEditor getEditor();

	IDocument getDocument();

	int layout(EnLayoutReason layoutReason);

	LayoutData getLayoutData();

	EnLayoutReason getLayoutReason();

}
