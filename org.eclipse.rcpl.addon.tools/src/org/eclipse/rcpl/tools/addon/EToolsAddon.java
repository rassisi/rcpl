package org.eclipse.rcpl.tools.addon;

import org.eclipse.rcpl.AbstractRcplAddon;
import org.eclipse.rcpl.IRcplAddon;
import org.eclipse.rcpl.IRcplPluginControler;
import org.eclipse.rcpl.RcplAddon;
import org.eclipse.rcpl.migration.RcplAbstractMigration;
import org.eclipse.rcpl.navigator.tree.details.EToolsAddonController;

/**
 * @author Ramin
 * 
 */
@RcplAddon
public class EToolsAddon extends AbstractRcplAddon implements IRcplAddon {

	public static final String USE_CASE_ID = "USE_CASE_TOOLS";

	public EToolsAddon() {
		// super(USE_CASE_ID);
	}

	@Override
	public EToolsAddonController getController() {
		return (EToolsAddonController) super.getController();
	}

	@Override
	public void init() {
		super.init();
	}

	@Override
	public String getDisplayName() {
		return "Setup Tools";
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

	@Override
	protected RcplAbstractMigration getMigration() {
		// TODO Auto-generated method stub
		return null;
	}

}
