package org.eclipse.rcpl;

import org.eclipse.rcpl.model_2_0_0.rcpl.Command;

/**
 * @author ramin
 *
 */
public interface ICommand {

	void execute();

	@Deprecated
	EnCommandId getCommandId();

	@Deprecated
	void setCommandId(EnCommandId id);

	Command getModel();

	void setModel(Command model);

	ITool getTool();

	Object[] getNewData();

	ILayoutObject getLayoutObject();

	String getNewStringValue();

	IService getService();

	IEditor getEditor();
}
