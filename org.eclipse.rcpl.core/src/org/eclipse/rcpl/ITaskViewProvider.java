package org.eclipse.rcpl;

import org.eclipse.rcpl.control.AbstractTaskViewProvider.RcplTask;
import org.eclipse.rcpl.control.RcplCompletionListener;

/**
 * @author ramin
 *
 */
public interface ITaskViewProvider {

	RcplTask getTask(int taskNumber);

	void progress(int taskNumber, String message, double workDone, double maxWork);

	void startTask(String title, int taskNumber, RcplCompletionListener completionListener, Object... parameters);

	void expandTaskView();

	void collapseTaskView();

	void waitForTaskCompletion(int taskNumber);
}
