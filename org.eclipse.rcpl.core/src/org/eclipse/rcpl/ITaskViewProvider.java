package org.eclipse.rcpl;

/**
 * @author ramin
 *
 */
public interface ITaskViewProvider {

	void taskMessage(int taskNumber, String message);

	void taskProgress(int taskNumber, double workDone, double maxWork);

	void startTask(String title, int taskNumber);

	void expandTaskView();

	void collapseTaskView();

	void waitForTaskCompletion(int taskNumber);
}
