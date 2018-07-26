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
import org.eclipse.rcpl.navigator.treeparts.DefaultNavigatorTreePart;

public abstract class AbstractEmfHandler<T> {

	protected DefaultNavigatorTreePart treePart;

	public AbstractEmfHandler(DefaultNavigatorTreePart treePart) {
		this.treePart = treePart;
	}

	public abstract void execute();

	protected abstract EObject createObject();

	protected abstract EClass newObjectClass();

	public abstract boolean canExecute();

	public abstract String getImage();

	public abstract String getText();
}
