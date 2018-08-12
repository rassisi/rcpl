package org.eclipse.rcpl;

/**
 * @author ramin
 *
 */
public interface ITaskViewProvider {

	void taskProgress(int taskNumber, String message, double workDone, double maxWork);

	void startTask(String title, int taskNumber);

	void expandTaskView();

	void collapseTaskView();

	void waitForTaskCompletion(int taskNumber);
}
