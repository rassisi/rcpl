package com.eclipse.rcpl.addon.demo.application;

import org.eclipse.rcpl.AbstractRcplAddon;
import org.eclipse.rcpl.IRcplAddon;
import org.eclipse.rcpl.RcplAddon;
import org.eclipse.rcpl.migration.RcplAbstractMigration;
import org.eclipse.rcpl.navigator.EViewController;

/**
 * @author Ramin
 * 
 */
@RcplAddon
public class DemoRcplAddon extends AbstractRcplAddon implements IRcplAddon {

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
	protected EViewController createController() {
		return null;
	}

	@Override
	public boolean isCustomApplication() {
		return false;
	}

}