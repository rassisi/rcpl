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
import org.eclipse.rcpl.navigator.addon.DefaultNavigatorAddon;

public class PasteHandler {

	Command command;

	public PasteHandler() {
	}

	public boolean canExecute(Object selectedItem) {

		// try {
		// EContactGroup group = null;
		//
		// if (selectedItem instanceof EContact)
		// // get containing Group if selection is a Contact
		// group = (EContactGroup) ((EContact) selectedItem).eContainer();
		//
		// else if (selectedItem instanceof EContactGroup)
		// group = (EContactGroup) selectedItem;

		// if (group != null) {
		// command = PasteFromClipboardCommand.create(Activator
		// .getDefault().getManager().getEditingDomain(), group,
		// JoPackage.eINSTANCE.getEContactGroup_Contacts());
		// return command.canExecute();
		// }
		// } catch (Exception ex) {
		//
		// }
		return false;
	}

	public void execute() {
		if (command != null && command.canExecute())
			DefaultNavigatorAddon.getDefault().getManager().getEditingDomain().getCommandStack().execute(command);
	}

}
