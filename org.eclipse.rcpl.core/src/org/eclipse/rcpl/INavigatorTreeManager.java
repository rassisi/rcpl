package org.eclipse.rcpl;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * @author Ramin
 *
 */
public interface INavigatorTreeManager {

	EObject getRoot();

	AdapterFactory getAdapterFactory();

	EditingDomain getEditingDomain();

}