package org.eclipse.rcpl;

/**
 * @author ramin
 *
 */
public interface ILayoutService extends IService {

	IEditor getEditor();

	IDocument getDocument();

	int layout();

	LayoutData getLayoutData();
}
