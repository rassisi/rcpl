/*******************************************************************************
 * Copyright (c) 2003 - 2014 Ramin Assisi and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     Ramin Assisi - initial implementation
 *******************************************************************************/
package org.eclipse.rcpl.application;

import java.io.File;

import org.eclipse.rcpl.IApplicationStarter;
import org.eclipse.rcpl.IRcplApplication;
import org.eclipse.rcpl.IRcplApplicationProvider;
import org.eclipse.rcpl.Rcpl;
import org.eclipse.rcpl.model.EnKeyValue;
import org.eclipse.rcpl.model.ISessionFacory;
import org.eclipse.rcpl.model.RcplModel;
import org.eclipse.rcpl.model.client.AbstractSession;
import org.eclipse.rcpl.util.RcplUtil;
import org.jpedal.examples.viewer.OpenViewerFX;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * @author ramin
 *
 */
public abstract class AbstractRcplApplication extends Application implements IRcplApplication {

	private ProgressBar loadProgress;

	private Label progressText;

	OpenViewerFX viewer;

	private Pane splashLayout;

	private final Stage splashStage = new Stage();

	protected static final int SPLASH_WIDTH = 600;

	protected static final int SPLASH_HEIGHT = 200;

	protected abstract IRcplApplicationProvider createApplicationProvider();

	protected abstract boolean isMobile();

	protected abstract Class<? extends RcplModel> getRcplModel();

	protected abstract ISessionFacory createSessionFactory();

	private IApplicationStarter applicationStarter;

	private IRcplApplicationProvider applicationProvider;

	public AbstractRcplApplication() {
		super();
		getApplicationProvider();
	}

	@Override
	public IRcplApplicationProvider getApplicationProvider() {
		if (applicationProvider == null) {
			AbstractSession.applicationId = this;
			AbstractSession.sessionFactory = createSessionFactory();
			applicationProvider = createApplicationProvider();
		}
		return applicationProvider;
	}

	public abstract IApplicationStarter createApplicationStarter(IRcplApplicationProvider rcplApplication);

	@Override
	public IApplicationStarter getApplicationStarter() {
		if (applicationStarter == null) {
			applicationStarter = createApplicationStarter(getApplicationProvider());
		}
		return applicationStarter;
	}

	@Override
	public void start(final Stage primaryStage) {
		initApplication();
		final String imgPath;
		final String barColour;

		imgPath = "https://madebymany-v2-prod.s3.amazonaws.com/uploads/blog/featured_image/1266/large_startup_leaf.png";
		barColour = ("-fx-accent: blue;");

		final ImageView splash = new ImageView(imgPath); // getClass().getResource(imgPath).toExternalForm());
		splash.setFitHeight(SPLASH_HEIGHT);
		splash.setFitWidth(SPLASH_WIDTH);
		loadProgress = new ProgressBar();
		loadProgress.setPrefWidth(SPLASH_WIDTH);
		progressText = new Label("All modules are loaded.");
		loadProgress.setStyle(barColour);
		splashLayout = new VBox();
		splashLayout.getChildren().addAll(splash,

				loadProgress, progressText);
		progressText.setAlignment(Pos.CENTER);
		splashLayout.setEffect(new DropShadow());

		final Task<ObservableList<String>> loadModsTask = new Task<ObservableList<String>>() {
			@Override
			protected ObservableList<String> call() throws InterruptedException {
				final ObservableList<String> loadMods = FXCollections.observableArrayList();
				final ObservableList<String> availableFriends = FXCollections.observableArrayList("Network Module",
						"User Module", "User Interface", "User Controls");

				updateMessage("Loading. . .");
				for (int i = 0; i < availableFriends.size(); i++) {
					Thread.sleep(900);
					updateProgress(i + 1, availableFriends.size());
					final String nextFriend = availableFriends.get(i);
					loadMods.add(nextFriend);
					updateMessage("Loading . . .  " + nextFriend);
				}
				Thread.sleep(500);
				updateMessage("All Modules are loaded.");

				return loadMods;
			}

		};
		showSplash(loadModsTask);

		loadModsTask.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
			@Override
			public void handle(final WorkerStateEvent event) {
				getApplicationProvider().start(primaryStage);
			}
		});

		new Thread(loadModsTask).start();
	}

	/**
	 * 
	 */
	private void initApplication() {
		Rcpl.get().setMobile(isMobile());
		RcplModel.modelClass = getRcplModel();
		File errorCache = new File(RcplUtil.getUserLocalCacheDir(), "images/___ERROR___/");
		RcplUtil.deleteFolder(errorCache);
		doInitApplication();
	}

	abstract protected void doInitApplication();

	/**
	 * Starting the splash screen
	 * 
	 * @param task
	 */
	private void showSplash(final Task<ObservableList<String>> task) {
		progressText.textProperty().bind(task.messageProperty());
		loadProgress.progressProperty().bind(task.progressProperty());
		task.stateProperty().addListener(new ChangeListener<Worker.State>() {
			@Override
			public void changed(final ObservableValue<? extends Worker.State> observableValue,
					final Worker.State oldState, final Worker.State newState) {
				if (newState == Worker.State.SUCCEEDED) {
					loadProgress.progressProperty().unbind();
					loadProgress.setProgress(1);
					splashStage.toFront();
					final FadeTransition fadeSplash = new FadeTransition(Duration.seconds(1.2), splashLayout);
					fadeSplash.setFromValue(1.0);
					fadeSplash.setToValue(0.0);
					fadeSplash.setOnFinished(new EventHandler<ActionEvent>() {
						@Override
						public void handle(final ActionEvent actionEvent) {
							splashStage.hide();
						}
					});
					fadeSplash.play();

				}
			}
		});
		final Scene splashScene = new Scene(splashLayout);
		splashStage.initStyle(StageStyle.UNDECORATED);
		splashStage.setScene(splashScene);
		splashStage.toFront();

		double initialStageX = Rcpl.get(EnKeyValue.LOGIN_WINDOW_X, -1.0);
		double initialStageY = Rcpl.get(EnKeyValue.LOGIN_WINDOW_Y, -1.0);

		if (initialStageX > Rcpl.get().getActualMonitor().getPixelWidth() - 600
				|| initialStageY > Rcpl.get().getActualMonitor().getHeight() - 600) {
			splashStage.centerOnScreen();
		}

		if (initialStageX == -1) {
			splashStage.centerOnScreen();
		} else {

			Screen sc = Screen.getScreensForRectangle(new Rectangle2D(initialStageX, initialStageY, 2, 2)).get(0);

			splashStage.setX(sc.getBounds().getMinX() + sc.getBounds().getWidth() / 2 - SPLASH_WIDTH / 2);
			splashStage.setY(sc.getBounds().getMinY() + sc.getBounds().getHeight() / 2 - SPLASH_HEIGHT / 2);
		}

		splashStage.show();
	}

	@Override
	public Stage getSplashStage() {
		return splashStage;
	}

}
