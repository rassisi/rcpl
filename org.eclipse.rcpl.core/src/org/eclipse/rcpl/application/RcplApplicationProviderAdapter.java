package org.eclipse.rcpl.application;

import java.util.Collection;

import org.eclipse.rcpl.IRcplAddon;
import org.eclipse.rcpl.IRcplApplicationProvider;

import javafx.application.Application;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class RcplApplicationProviderAdapter implements IRcplApplicationProvider {

	@Override
	public void setPrimaryStage(Stage stage) {
		// TODO Auto-generated method stub

	}

	@Override
	public double getLoginWindowX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getLoginWindowY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Class<?> getApplicationResourceBaseClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLoginDebug() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isLoginDebug() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void reStart() {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<IRcplAddon> getRcplAddons() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void bindAddonsToModel() {
		// TODO Auto-generated method stub

	}

	@Override
	public IRcplAddon findRcplAddon(String className) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IRcplAddon findRcplAddon(Class<? extends IRcplAddon> addon) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub

	}

	@Override
	public void login() {
		// TODO Auto-generated method stub

	}

	@Override
	public StackPane getMainContent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMainStackPane(StackPane stackPane) {
		// TODO Auto-generated method stub

	}

	@Override
	public Stage getPrimaryStage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Application getFxApplication() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StackPane getMainApplicationStack() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setResizable(boolean resizable) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setMinimizable(boolean minimizable) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setMaximizable(boolean maximizable) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFullscreenAble(boolean fullscreenAble) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSimpleDialog() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setNormalWindow() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSize(double width, double height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void centerWindow() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getImage() {
		// TODO Auto-generated method stub
		return null;
	}

}
