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
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * @author ramin
 *
 */
public abstract class AbstractTaskViewProvider implements ITaskViewProvider {

	private final long LONG_TASK_MILLIS = 3000;

	protected StackPane progressViewArea = new StackPane();
	private TaskProgressView<RcplTask> taskProgressView;

	int taskCounter = 0;

	private ExecutorService executorService = Executors.newCachedThreadPool();

	public AbstractTaskViewProvider() {
		super();
		taskProgressView = new TaskProgressView<RcplTask>();

//		Node n = taskProgressView.getSkin().getNode();

		progressViewArea = new StackPane();
		progressViewArea.setPrefHeight(120);
		progressViewArea.setMinHeight(120);
		progressViewArea.setMaxHeight(120);
		progressViewArea.getChildren().add(taskProgressView);
	}

	public void taskDone(int taskNumber) {
		tasks.get(taskNumber).cancel();
	}

	@Override
	public void taskProgress(int taskNumber, String message, double workDone, double maxWork) {
		RcplTask task = tasks.get(taskNumber);
		if (task != null) {
			task.progress(taskNumber, message, workDone, maxWork);
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

		public void progress(int taskNumber, String message, double workDone, double maxWork) {
			if (maxWork == 0) {
				maxWork = 100.0;
			}
			Rcpl.println("workDone = " + workDone + "   maxWork = " + maxWork);
			tasks.get(taskNumber).updateProgress(workDone, maxWork);

			tasks.get(taskNumber).updateMessage(message);
			if (isLongTask()) {
				expandTaskView();
				Rcpl.println("*** LONG TASK " + taskNumber + " " + message);
			} else {
				Rcpl.println("*** NO LONG TASK " + taskNumber + " " + message);

			}
		}

		public boolean isLongTask() {
			long diff = System.currentTimeMillis() - startTime;
			return diff > LONG_TASK_MILLIS;
		}

		@Override
		protected Void call() throws Exception {

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

			updateProgress(0, 0);
			Platform.runLater(new Runnable() {

				@Override
				public void run() {
					collapseTaskView();
				}
			});

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
				expandTaskView();
				tasks.put(taskNumber,
						new RcplTask(taskCounter + ". " + title, taskNumber, completionListener, parameters));
				taskProgressView.getTasks().add(tasks.get(taskNumber));
				executorService.submit(tasks.get(taskNumber));
			}
		});
	}

	@Override
	public void expandTaskView() {
		if (!getNode().getChildren().contains(progressViewArea)) {

			Platform.runLater(new Runnable() {

				@Override
				public void run() {
					getNode().getChildren().add(progressViewArea);
				}
			});
		}
	}

	@Override
	public void collapseTaskView() {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				getNode().getChildren().remove(progressViewArea);
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

	public TaskProgressView<RcplTask> getTaskProgressView() {
		return taskProgressView;
	}

	public StackPane getProgressViewArea() {
		return progressViewArea;
	}

	@Override
	public RcplTask getTask(int taskNumber) {
		return tasks.get(taskNumber);
	}

}
