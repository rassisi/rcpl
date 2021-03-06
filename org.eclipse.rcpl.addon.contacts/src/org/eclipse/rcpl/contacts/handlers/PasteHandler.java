/*******************************************************************************
 * Copyright (c) 2009, 2010 Siemens AG and others.
 * 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html.
 * 
 * Contributors:
 *     Kai Tödter - initial implementation
 ******************************************************************************/

package org.eclipse.rcpl.contacts.handlers;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.PasteFromClipboardCommand;
import org.eclipse.rcpl.contacts.addon.OsgiContactsAddon;
import org.eclipse.rcpl.model_2_0_0.rcpl.Person;
import org.eclipse.rcpl.model_2_0_0.rcpl.PersonGroup;
import org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage;

public class PasteHandler {

	Command command;

	public PasteHandler() {
	}

	@CanExecute
	public boolean canExecute(@Optional Object selectedItem) {
		PersonGroup group = null;

		if (selectedItem instanceof Person)
			// get containing Group if selection is a Contact
			group = (PersonGroup) ((Person) selectedItem).eContainer();

		else if (selectedItem instanceof PersonGroup)
			group = (PersonGroup) selectedItem;

		if (group != null) {
			command = PasteFromClipboardCommand.create(
					OsgiContactsAddon.getEditingDomain(), group,
					RcplPackage.eINSTANCE.getPersonGroup_Persons());
			return command.canExecute();
		}

		return false;
	}

	@Execute
	public void execute() {
		if (command != null && command.canExecute())
			OsgiContactsAddon.getEditingDomain().getCommandStack()
					.execute(command);
	}

}
