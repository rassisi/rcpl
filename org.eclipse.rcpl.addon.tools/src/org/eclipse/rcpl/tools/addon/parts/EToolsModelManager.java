package org.eclipse.rcpl.tools.addon.parts;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.domain.EditingDomain;

public interface EToolsModelManager {

	public static EToolsModelFactory FACTORY = new EToolsModelFactory();

	AdapterFactory getAdapterFactory();

	EditingDomain getEditingDomain();

}