package org.eclipse.rcpl;

import org.eclipse.rcpl.model.IIdProvider;

/**
 * @author ramin
 *
 */
public interface IRcplApplication extends IIdProvider {

	@Override
	String getId();

	IRcplApplicationProvider getApplicationProvider();

	IApplicationStarter getApplicationStarter();

}
