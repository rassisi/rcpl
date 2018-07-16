package org.eclipse.rcpl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * @author ramin
 *
 */
public interface IRcplPluginControler {

	void init(IRcplAddon rcplPlugin);

	void updateBindings(EObject eObject, EditingDomain editingDomain);
}
