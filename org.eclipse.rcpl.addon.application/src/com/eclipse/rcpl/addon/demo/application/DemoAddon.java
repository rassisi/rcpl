package com.eclipse.rcpl.addon.demo.application;

import org.eclipse.rcpl.AbstractRcplAddon;
import org.eclipse.rcpl.IApplicationStarter;
import org.eclipse.rcpl.IRcplApplicationProvider;
import org.eclipse.rcpl.IRcplAddon;
import org.eclipse.rcpl.RcplAbstractMigration;
import org.eclipse.rcpl.RcplAddon;
import org.eclipse.rcpl.navigator.EViewController;

/**
 * @author Ramin
 * 
 */
@RcplAddon
public class DemoAddon extends AbstractRcplAddon implements IRcplAddon {

	public static final String ID = "DEMO_APPLICATION";





	@Override
	public String getDisplayName() {
		return "Demo Application";
	}

	@Override
	protected RcplAbstractMigration getMigration() {
		return null; // new EContactsMigration(this);
	}



	@Override
	public IApplicationStarter createApplicationStarter(IRcplApplicationProvider rcplApplication) {
		return new DemoApplicationStarter(rcplApplication);
	}



	@Override
	protected EViewController createController() {
		return null;
	}
	
	@Override
	public boolean isCustomApplication() {
		return false;
	}


}