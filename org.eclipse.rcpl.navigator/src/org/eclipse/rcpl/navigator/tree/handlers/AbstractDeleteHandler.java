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

package org.eclipse.rcpl.navigator.tree.handlers;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.rcpl.model.cdo.client.RcplSession;
import org.eclipse.rcpl.navigator.tree.parts.DefaultNavigatorTreePart;

public abstract class AbstractDeleteHandler<T> extends AbstractEmfHandler<T> {

	public AbstractDeleteHandler(DefaultNavigatorTreePart treePart) {
		super(treePart);
	}

	@Override
	public void execute() {
		try {
			@SuppressWarnings({ "unchecked", "unused" })
			T test = (T) treePart.getSelectedObject();
		} catch (ClassCastException e) {
			return;
		}
		Command command = DeleteCommand.create(treePart.getEditingDomain(), treePart.getSelectedObject());
		if (command != null && command.canExecute()) {
			treePart.getEditingDomain().getCommandStack().execute(command);
			RcplSession.getDefault().commit();
		}

	}

	@Override
	protected EObject createObject() {
		return null;
	}

	@Override
	protected EClass newObjectClass() {
		return null;
	}
}
