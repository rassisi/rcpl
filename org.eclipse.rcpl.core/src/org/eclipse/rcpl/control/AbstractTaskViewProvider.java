package org.eclipse.rcpl.control;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.controlsfx.control.TaskProgressView;
import org.eclipse.rcpl.ITaskViewProvider;
import org.eclipse.rcpl.Rcpl;
import org.eclipse.rcpl.util.RcplUtil;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.control.Skin;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

/**
 * @author ramin
 *
 */
public abstract class AbstractTaskViewProvider implements ITaskViewProvider {

	private final long LONG_TASK_MILLIS = 3000;

	private static TaskProgressView<RcplTask> taskProgressView;

	int taskCounter = 0;

	private ExecutorService executorService = Executors.newCachedThreadPool();

	public AbstractTaskViewProvider() {
		super();
		if (taskProgressView == null) {
			taskProgressView = new TaskProgressView<RcplTask>() {
				@Override
				protected Skin<?> createDefaultSkin() {
					return new RcplTaskProgressViewSkin<>(this);
				}
			};
			HBox.setHgrow(taskProgressView, Priority.ALWAYS);
			if (Rcpl.UIC != null) {
				Rcpl.UIC.getProgressArea().getChildren().add(taskProgressView);
			}
		}
	}

	public void taskDone(int taskNumber) {
		tasks.get(taskNumber).cancel();
	}

	@Override
	public void progress(int taskNumber, String message, double workDone, double maxWork) {
		RcplTask task = tasks.get(taskNumber);
		if (task != null) {
			task.progress(message, workDone, maxWork);
		}
	}

	/**
	 * @author ramin
	 *
	 */
	public class RcplTask extends Task<Void> {

		private long startTime;

		private int taskNumber;

		private Object[] parameters;

		private Object result;

		private RcplCompletionListener completionListener;

		public RcplTask(String title, int taskNumber, RcplCompletionListener completionListener, Object... parameters) {
			updateTitle(title);
			this.taskNumber = taskNumber;
			this.startTime = System.currentTimeMillis();
			this.parameters = parameters;
			this.completionListener = completionListener;
		}

		public void progress(String message, double workDone, double maxWork) {
			if (maxWork == 0) {
				maxWork = 100.0;
			}
			if (tasks.get(taskNumber) == null) {
				return;
			}
			tasks.get(taskNumber).updateProgress(workDone, maxWork);
			tasks.get(taskNumber).updateMessage(message);
			if (isLongTask()) {
//				Rcpl.println("*** LONG TASK " + taskNumber + " " + message);
			} else {
//				Rcpl.println("*** NO LONG TASK " + taskNumber + " " + message);

			}
		}

		public boolean isLongTask() {
			long diff = System.currentTimeMillis() - startTime;
			return diff > LONG_TASK_MILLIS;
		}

		@Override
		protected Void call() throws Exception {
			progress("", 1.0, 100.0);
			switch (taskNumber) {
			case 1:
				result = task_1(this, parameters);
				break;
			case 2:
				result = task_2(this, parameters);
				break;
			case 3:
				result = task_3(this, parameters);
				break;
			case 4:
				result = task_4(this, parameters);
				break;
			case 5:
				result = task_5(this, parameters);
				break;
			case 6:
				result = task_6(this, parameters);
				break;
			case 7:
				result = task_7(this, parameters);
				break;
			case 8:
				result = task_8(this, parameters);
				break;
			case 9:
				result = task_9(this, parameters);
				break;
			case 10:
				result = task_10(this, parameters);
				break;
			}

			if (completionListener != null) {
				completionListener.onCompleted();
			}

			taskCounter--;
			done();
			tasks.remove(taskNumber);
			return null;
		}

		public Object getResult() {
			return result;
		}

		public void setCompletionListener(RcplCompletionListener completionListener) {
			this.completionListener = completionListener;
		}

	}

	protected Object task_1(RcplTask task, Object[] parameters) {
		return null;
	}

	protected Object task_2(RcplTask task, Object[] parameters) {
		return null;
	}

	protected Object task_3(RcplTask task, Object[] parameters) {
		return null;
	}

	protected Object task_4(RcplTask task, Object[] parameters) {
		return null;
	}

	protected Object task_5(RcplTask task, Object[] parameters) {
		return null;
	}

	protected Object task_6(RcplTask task, Object[] parameters) {
		return null;
	}

	protected Object task_7(RcplTask task, Object[] parameters) {
		return null;
	}

	protected Object task_8(RcplTask task, Object[] parameters) {
		return null;
	}

	protected Object task_9(RcplTask task, Object[] parameters) {
		return null;
	}

	protected Object task_10(RcplTask task, Object[] parameters) {
		return null;
	}

	private HashMap<Integer, RcplTask> tasks = new HashMap<Integer, RcplTask>();

	@Override
	public void startTask(String title, int taskNumber, RcplCompletionListener completionListener,
			Object... parameters) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				taskCounter++;
				final RcplTask task = new RcplTask(title, taskNumber, completionListener, parameters);
				tasks.put(taskNumber, task);
				taskProgressView.getTasks().add(task);
				executorService.submit(task);
			}
		});
	}

	@Override
	public void waitForTaskCompletion(int taskNumber) {
		while (tasks.get(taskNumber) != null && !tasks.get(taskNumber).isDone()) {
			RcplUtil.sleep(10);
		}
	}

	abstract public Pane getNode();

	@Override
	public RcplTask getTask(int taskNumber) {
		return tasks.get(taskNumber);
	}

	@Override
	public void cancelAllTasks() {
		for (RcplTask task : tasks.values()) {
			task.cancel();
		}
		tasks.clear();
	}
}
