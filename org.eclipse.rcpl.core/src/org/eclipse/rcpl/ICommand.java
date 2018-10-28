package org.eclipse.rcpl;

/**
 * @author ramin
 *
 */
public interface ICommand {

	void execute();

	EnCommandId getCommandId();

	ITool getTool();

	Object[] getNewData();

	Object[] getOldData();

	ILayoutObject getLayoutObject();

	void setCommandId(EnCommandId id);

	String getNewStringValue();

	IService getService();
}
