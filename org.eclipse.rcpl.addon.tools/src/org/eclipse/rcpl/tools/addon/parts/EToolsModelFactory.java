package org.eclipse.rcpl.tools.addon.parts;

public class EToolsModelFactory {

	public EToolsModelManager newInstance() {
		return new EToolsModelManagerImpl();
	}
}
