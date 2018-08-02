package org.eclipse.rcpl.navigator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;

public interface IModelDetailPageControler {

	void updateBindings(EObject contact, EditingDomain editingDomain);

	void unbindAll();
}
