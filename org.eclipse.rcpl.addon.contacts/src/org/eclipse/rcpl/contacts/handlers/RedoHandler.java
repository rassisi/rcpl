package org.eclipse.rcpl.contacts.handlers;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.rcpl.contacts.addon.OsgiContactsAddon;

public class RedoHandler {

	@CanExecute
	public boolean canUndo() {
		CommandStack commandStack = OsgiContactsAddon.getEditingDomain()
				.getCommandStack();
		return commandStack.canRedo();
	}

	@Execute
	public void undo() {
		CommandStack commandStack = OsgiContactsAddon.getEditingDomain()
				.getCommandStack();
		if (commandStack.canRedo())
			commandStack.redo();
	}
}
