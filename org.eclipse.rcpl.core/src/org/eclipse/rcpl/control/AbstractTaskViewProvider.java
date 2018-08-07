package org.eclipse.rcpl.control;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.controlsfx.control.TaskProgressView;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * @author ramin
 *
 */
public abstract class AbstractTaskViewProvider {

	protected StackPane progressViewArea = new StackPane();

	private TaskProgressView<RcplTask> taskProgressView;

	private RcplTask task;

	int taskCounter = 0;

	private ExecutorService executorService = Executors.newCachedThreadPool();

	public AbstractTaskViewProvider() {
		super();
		taskProgressView = new TaskProgressView<RcplTask>();
		progressViewArea = new StackPane();
		progressViewArea.setPrefHeight(60);
		progressViewArea.setMinHeight(60);
		progressViewArea.setMaxHeight(60);
	}

	protected void taskMessage(String message) {
		task.message(message);
	}

	protected void taskProgress(String message) {
		task.message(message);
	}

	protected class RcplTask extends Task<Void> {

		private double maxWork = 100.0;

		private int taskNumber;

		public RcplTask(String title, int taskNumber) {
			updateTitle(title);
			this.taskNumber = taskNumber;
		}

		public void message(String msg) {
			task.updateMessage(msg);
		}

		public void progress(double workDone) {
			task.updateProgress(workDone, maxWork);
		}

		public void progress(double workDone, double maxWork) {
			this.maxWork = maxWork;
			progress(workDone);
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

	protected void startTask(String title, int taskNumber) {
		expandTaskView();
		taskCounter++;
		expandTaskView();
		task = new RcplTask(taskCounter + ". " + title, taskNumber);
		taskProgressView.getTasks().add(task);
		executorService.submit(task);
	}

	protected void expandTaskView() {
		if (!getNode().getChildren().contains(progressViewArea)) {
			getNode().getChildren().add(progressViewArea);
		}
	}

	protected void collapseTaskView() {
		getNode().getChildren().remove(progressViewArea);
	}

	abstract public Pane getNode();

	public TaskProgressView<RcplTask> getTaskProgressView() {
		return taskProgressView;
	}

}
