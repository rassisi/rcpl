package org.eclipse.rcpl;

import java.util.Collection;

import org.eclipse.rcpl.internal.services.RcplService;
import org.eclipse.rcpl.model_2_0_0.rcpl.Tool;

import javafx.application.Application;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * @author ramin
 *
 */
public interface IRcplApplicationProvider {

	void setLoginDebug();

	boolean isLoginDebug();

	void reStart();

	Collection<IRcplAddon> getRcplAddons();

	void bindAddonsToModel();

	IRcplAddon findRcplAddon(String className);

	IRcplAddon findRcplAddon(Class<? extends IRcplAddon> addon);

	INavigatorAddon findNavigatorAddon(Tool tool);

	void registerService(Class<? extends RcplService> serviceClass);

	void start(Stage primaryStage);

	void login();

	StackPane getMainContent();

	void setMainStackPane(StackPane stackPane);

	Stage getPrimaryStage();

	Application getFxApplication();

	StackPane getMainApplicationStack();

	IApplicationWindow getApplicationWindow();

	void setResizable(boolean resizable);

	void setMinimizable(boolean minimizable);

	void setMaximizable(boolean maximizable);

	void setFullscreenAble(boolean fullscreenAble);

	void setSimpleDialog();

	void setNormalWindow();

	void setSize(double width, double height);

	void centerWindow();
}
