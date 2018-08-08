package org.eclipse.rcpl;

/**
 * @author ramin
 *
 */
public interface ITaskViewProvider {

	void taskMessage(String message);

	void taskProgress(String message);

	void startTask(String title, int taskNumber);

	void expandTaskView();

	void collapseTaskView();
}
