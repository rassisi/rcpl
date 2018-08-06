package org.eclipse.rcpl;

import javafx.stage.Stage;

/**
 * @author ramin
 *
 */
public interface IApplicationStarter {

	IRcplApplicationProvider getRcplApplicationProvider();

	String getVersionString();

	boolean start(final ILogin login, Stage primaryStage);

}
