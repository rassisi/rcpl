package org.eclipse.rcpl.contacts.plugin;

import org.eclipse.rcpl.AbstractRcplAddon;
import org.eclipse.rcpl.IApplicationStarter;
import org.eclipse.rcpl.IRcplApplicationProvider;
import org.eclipse.rcpl.IRcplAddon;
import org.eclipse.rcpl.RcplAbstractMigration;
import org.eclipse.rcpl.RcplPlugin;
import org.eclipse.rcpl.navigator.EViewController;
import org.eclipse.rcpl.ui.parts.contacts.EContactsMigration;
import org.eclipse.rcpl.ui.parts.contacts.EContactsPluginController;

/**
 * @author Ramin
 * 
 */
@RcplPlugin
public class RcplContactsPlugin extends AbstractRcplAddon implements IRcplAddon {

	public static final String ID = "USE_CASE_CONTACTS";

	public RcplContactsPlugin() {
		// super(ID);
	}

	@Override
	protected EViewController createController() {
		return new EContactsPluginController();
	}

	@Override
	public EContactsPluginController getController() {
		return (EContactsPluginController) super.getController();
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
	public IApplicationStarter createApplicationStarter(IRcplApplicationProvider application) {
		return null;
	}

	@Override
	public boolean isCustomApplication() {
		return false;
	}


}
