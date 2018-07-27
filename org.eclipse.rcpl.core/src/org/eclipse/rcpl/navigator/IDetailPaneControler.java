package org.eclipse.rcpl.navigator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.rcpl.ITreePart;

public interface IDetailPaneControler {

	ITreePart getTreePart();

	void updateBindings(EObject contact, EditingDomain editingDomain);
}
