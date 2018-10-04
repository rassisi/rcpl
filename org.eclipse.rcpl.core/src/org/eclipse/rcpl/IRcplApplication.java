package org.eclipse.rcpl;

import org.eclipse.rcpl.model.IIdProvider;

import javafx.stage.Stage;

/**
 * @author ramin
 *
 */
public interface IRcplApplication extends IIdProvider {

	@Override
	String getId();

	IRcplApplicationProvider getApplicationProvider();

	IApplicationStarter getApplicationStarter();

	Stage getSplashStage();
}
