package org.eclipse.rcpl.contacts.handlers;

import java.util.List;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.rcpl.contacts.addon.OsgiContactsAddon;

public class DeleteContactHandler {

	Command command;

	public DeleteContactHandler() {
	}

	@CanExecute
	public boolean canExecute(@Optional List<?> selection) {
		if (selection != null) {
			command = DeleteCommand.create(OsgiContactsAddon.getEditingDomain(),
					selection);
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
