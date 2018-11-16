package org.eclipse.rcpl.application;

import org.eclipse.rcpl.IApplicationStarter;
import org.eclipse.rcpl.ILogin;
import org.eclipse.rcpl.IRcplApplicationProvider;

import javafx.stage.Stage;

/**
 * @author Ramin
 *
 */
public class RcplApplicationStarterAdapter implements IApplicationStarter {

	private IRcplApplicationProvider applicationProvider;

	public RcplApplicationStarterAdapter(IRcplApplicationProvider applicationProvider) {
		this.applicationProvider = applicationProvider;
	}

	@Override
	public IRcplApplicationProvider getRcplApplicationProvider() {
		return applicationProvider;
	}

	@Override
	public String getVersionString() {
		return "0.0.1";
	}

	@Override
	public boolean start(ILogin login, Stage primaryStage) {
		return true;
	}

}
