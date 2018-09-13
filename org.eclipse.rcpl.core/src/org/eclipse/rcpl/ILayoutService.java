package org.eclipse.rcpl;

/**
 * @author ramin
 *
 */
public interface ILayoutService extends IService {

	IEditor getEditor();

	IDocument getDocument();

	int layout(EnLayoutReason layoutReason);

	LayoutData getLayoutData();

	EnLayoutReason getLayoutReason();

//	void setLayoutReason(EnLayoutReason layoutReason);

}
