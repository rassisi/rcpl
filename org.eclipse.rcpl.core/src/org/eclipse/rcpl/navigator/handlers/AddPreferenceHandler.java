/*******************************************************************************
 * Copyright (c) 2003 - 2014 Ramin Assisi and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     Ramin Assisi - initial implementation
 *******************************************************************************/

package org.eclipse.rcpl.navigator.handlers;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcpl.model_2_0_0.rcpl.Preference;
import org.eclipse.rcpl.model_2_0_0.rcpl.RcplFactory;
import org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage;
import org.eclipse.rcpl.navigator.treeparts.DefaultNavigatorTreePart;

public class AddPreferenceHandler extends AbstractAddHandler<Preference> {

	public AddPreferenceHandler(DefaultNavigatorTreePart treePart) {
		super(treePart);
	}

	@Override
	protected EObject createObject() {
		Preference f = RcplFactory.eINSTANCE.createPreference();
		f.setKey("New Preference");
		return f;
	}

	@Override
	protected EClass newObjectClass() {
		return RcplPackage.Literals.PREFERENCE;
	}

	@Override
	public boolean canExecute() {
		return true;
	}

	@Override
	public String getImage() {
		return "preferences";
	}

	@Override
	public String getText() {
		return "Add Preference";
	}

}
