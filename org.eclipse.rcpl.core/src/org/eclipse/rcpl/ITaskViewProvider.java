package org.eclipse.rcpl;

/**
 * @author ramin
 *
 */
public interface ITaskViewProvider {

	void taskMessage(int taskNumber, String message);

	void taskProgress(int taskNumber, String message);

	void startTask(String title, int taskNumber);

	void expandTaskView();

	void collapseTaskView();
}
