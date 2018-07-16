package org.eclipse.rcpl;

import java.util.Collection;

import org.eclipse.rcpl.internal.services.RcplService;

import javafx.application.Application;
import javafx.scene.Group;
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

	void registerRcplAddonClass(String rcpPluginClassName);

	IRcplAddon findRcplAddon(String className);

	IRcplAddon findRcplAddon(Class<? extends IRcplAddon> addon);

	void registerService(Class<? extends RcplService> serviceClass);

	void start(Stage primaryStage);

	void login();

	StackPane getMainContentGroup();

	void setMainStackPane(StackPane stackPane);

	Stage getPrimaryStage();

	Application getFxApplication();

	StackPane getMainApplicationStack();

}
