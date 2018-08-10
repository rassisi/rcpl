package org.eclipse.rcpl.control;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.controlsfx.control.TaskProgressView;
import org.eclipse.rcpl.ITaskViewProvider;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * @author ramin
 *
 */
public abstract class AbstractTaskViewProvider implements ITaskViewProvider {

	private final long LONG_TASK_MILLIS = 2000;

	protected StackPane progressViewArea = new StackPane();

	private TaskProgressView<RcplTask> taskProgressView;

	int taskCounter = 0;

	private ExecutorService executorService = Executors.newCachedThreadPool();

	public AbstractTaskViewProvider() {
		super();
		taskProgressView = new TaskProgressView<RcplTask>();
		progressViewArea = new StackPane();
		progressViewArea.setPrefHeight(60);
		progressViewArea.setMinHeight(60);
		progressViewArea.setMaxHeight(60);
		progressViewArea.getChildren().add(taskProgressView);
	}

	@Override
	public void taskMessage(int taskNumber, String message) {
		RcplTask task = tasks.get(taskNumber);
		if (task != null) {
			task.message(taskNumber, message);
		}
	}

	@Override
	public void taskProgress(int taskNumber, String message) {
		tasks.get(taskNumber).message(taskNumber, message);
	}

	protected class RcplTask extends Task<Void> {

		private long startTime;

		private double maxWork = 100.0;

		private int taskNumber;

		public RcplTask(String title, int taskNumber) {
			updateTitle(title);
			this.taskNumber = taskNumber;
			this.startTime = System.currentTimeMillis();
		}

		public void message(int taskNumber, String msg) {
			tasks.get(taskNumber).updateMessage(msg);
			if (isLongTask()) {
				expandTaskView();
			}
		}

		public void progress(int taskNumber, double workDone) {
			tasks.get(taskNumber).updateProgress(workDone, maxWork);
			if (isLongTask()) {
				expandTaskView();
			}
		}

		public boolean isLongTask() {
			long diff = System.currentTimeMillis() - startTime;
			return diff > LONG_TASK_MILLIS;
		}

		public void progress(int taskNumber, double workDone, double maxWork) {
			this.maxWork = maxWork;
			progress(taskNumber, workDone);
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

		public void setMaxWork(double maxWork) {
			this.maxWork = maxWork;
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
			getNode().getChildren().add(progressViewArea);
		}
	}

	@Override
	public void collapseTaskView() {
		getNode().getChildren().remove(progressViewArea);
	}

	abstract public Pane getNode();

	public TaskProgressView<RcplTask> getTaskProgressView() {
		return taskProgressView;
	}

	public StackPane getProgressViewArea() {
		return progressViewArea;
	}

}
