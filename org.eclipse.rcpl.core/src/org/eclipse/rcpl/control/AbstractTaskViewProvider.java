package org.eclipse.rcpl.control;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.controlsfx.control.TaskProgressView;
import org.eclipse.rcpl.ITaskViewProvider;
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

	protected class RcplTask extends Task<Void> {

		private long startTime;

		private int taskNumber;

		public RcplTask(String title, int taskNumber) {
			updateTitle(title);
			this.taskNumber = taskNumber;
			this.startTime = System.currentTimeMillis();
		}

		public void progress(int taskNumber, String message, double workDone, double maxWork) {
			if (maxWork == 0) {
				maxWork = 100.0;
			}
			System.out.println("workDone = " + workDone + "   maxWork = " + maxWork);
			tasks.get(taskNumber).updateProgress(workDone, maxWork);

			tasks.get(taskNumber).updateMessage(message);
			if (isLongTask()) {
				expandTaskView();
				System.out.println("*** LONG TASK " + taskNumber + " " + message);
			} else {
				System.out.println("*** NO LONG TASK " + taskNumber + " " + message);

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
				task_1();
				break;
			case 2:
				task_2();
				break;
			case 3:
				task_3();
				break;
			case 4:
				task_4();
				break;
			case 5:
				task_5();
				break;
			case 6:
				task_6();
				break;
			case 7:
				task_7();
				break;
			case 8:
				task_8();
				break;
			case 9:
				task_9();
				break;
			case 10:
				task_10();
				break;
			}

			updateProgress(0, 0);
			Platform.runLater(new Runnable() {

				@Override
				public void run() {
					collapseTaskView();
				}
			});

			taskCounter--;
			done();

			tasks.remove(taskNumber);

			return null;
		}

	}

	protected void task_1() {

	}

	protected void task_2() {

	}

	protected void task_3() {

	}

	protected void task_4() {

	}

	protected void task_5() {

	}

	protected void task_6() {

	}

	protected void task_7() {

	}

	protected void task_8() {

	}

	protected void task_9() {

	}

	protected void task_10() {

	}

	HashMap<Integer, RcplTask> tasks = new HashMap<Integer, RcplTask>();

	@Override
	public void startTask(String title, int taskNumber) {
		taskCounter++;
		expandTaskView();
		tasks.put(taskNumber, new RcplTask(taskCounter + ". " + title, taskNumber));
		taskProgressView.getTasks().add(tasks.get(taskNumber));
		executorService.submit(tasks.get(taskNumber));
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

}
