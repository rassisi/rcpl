package org.eclipse.rcpl;

import org.eclipse.rcpl.login.RcplLogin;

import javafx.stage.Stage;

/**
 * @author ramin
 *
 */
public interface IApplicationStarter {

	boolean start(final RcplLogin login, final Stage primaryStage);

	IRcplApplicationProvider getRcplApplicationProvider();

}
