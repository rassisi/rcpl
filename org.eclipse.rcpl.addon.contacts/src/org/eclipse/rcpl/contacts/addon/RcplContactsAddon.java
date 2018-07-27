package org.eclipse.rcpl.contacts.addon;

import org.eclipse.rcpl.AbstractRcplAddon;
import org.eclipse.rcpl.IRcplAddon;
import org.eclipse.rcpl.IRcplPluginControler;
import org.eclipse.rcpl.RcplAddon;
import org.eclipse.rcpl.migration.RcplAbstractMigration;
import org.eclipse.rcpl.ui.parts.contacts.EContactsMigration;

/**
 * @author Ramin
 * 
 */
@RcplAddon
public class RcplContactsAddon extends AbstractRcplAddon implements IRcplAddon {

	public static final String ID = "USE_CASE_CONTACTS";

	public RcplContactsAddon() {
		// super(ID);
	}

	@Override
	public String getDisplayName() {
		return "Contacts";
	}

	@Override
	protected RcplAbstractMigration getMigration() {
		return new EContactsMigration(this);
	}

	@Override
	public boolean isCustomApplication() {
		return false;
	}

	@Override
	protected IRcplPluginControler createController() {
		// TODO Auto-generated method stub
		return null;
	}

}
