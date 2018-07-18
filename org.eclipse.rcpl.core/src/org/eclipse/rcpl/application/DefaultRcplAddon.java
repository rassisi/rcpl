package org.eclipse.rcpl.application;

import org.eclipse.rcpl.AbstractRcplAddon;
import org.eclipse.rcpl.IApplicationStarter;
import org.eclipse.rcpl.IRcplApplicationProvider;
import org.eclipse.rcpl.IRcplAddon;
import org.eclipse.rcpl.IRcplPluginControler;
import org.eclipse.rcpl.RcplAbstractMigration;
import org.eclipse.rcpl.RcplAddon;

/**
 * @author Ramin
 * 
 */
@RcplAddon
public class DefaultRcplAddon extends AbstractRcplAddon implements IRcplAddon {

	public DefaultRcplAddon() {
	}

	@Override
	public String getDisplayName() {
		return "Default RCPL Plugin";
	}

	@Override
	protected RcplAbstractMigration getMigration() {
		return null; // new EContactsMigration(this);
	}

	@Override
	public IApplicationStarter createApplicationStarter(IRcplApplicationProvider rcplApplication) {
		return new DefaultApplicationStarter(rcplApplication);
	}

	@Override
	public boolean isCustomApplication() {
		return true;
	}

	@Override
	protected IRcplPluginControler createController() {
		return null;
	}

}
