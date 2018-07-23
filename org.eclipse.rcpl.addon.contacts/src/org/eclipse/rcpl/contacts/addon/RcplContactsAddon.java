package org.eclipse.rcpl.contacts.addon;

import org.eclipse.rcpl.AbstractRcplAddon;
import org.eclipse.rcpl.IRcplAddon;
import org.eclipse.rcpl.RcplAddon;
import org.eclipse.rcpl.migration.RcplAbstractMigration;
import org.eclipse.rcpl.navigator.EViewController;
import org.eclipse.rcpl.ui.parts.contacts.EContactsAddonController;
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
	protected EViewController createController() {
		return new EContactsAddonController();
	}

	@Override
	public EContactsAddonController getController() {
		return (EContactsAddonController) super.getController();
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

}
