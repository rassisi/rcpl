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

import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.rcpl.navigator.treeparts.DefaultNavigatorTreePart;

public class RedoHandler {

	private DefaultNavigatorTreePart treePart;

	public RedoHandler(DefaultNavigatorTreePart treePart) {
		this.treePart = treePart;
	}

	public boolean canUndo() {
		try {
			CommandStack commandStack = treePart.getRcplManager().getEditingDomain().getCommandStack();
			return commandStack.canRedo();
		} catch (Exception ex) {

		}
		return false;
	}

	public void undo() {
		CommandStack commandStack = treePart.getRcplManager().getEditingDomain().getCommandStack();
		if (commandStack.canRedo())
			commandStack.redo();
	}
}
