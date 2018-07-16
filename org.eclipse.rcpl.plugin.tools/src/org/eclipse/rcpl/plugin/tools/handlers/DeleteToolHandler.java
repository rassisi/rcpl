package org.eclipse.rcpl.plugin.tools.handlers;

import java.util.List;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.rcpl.plugin.tools.UCToolsPlugin;
import org.eclipse.rcpl.plugin.tools.parts.EToolsTreePart;

public class DeleteToolHandler {

	private Command command;
	private EToolsTreePart eToolsTreePart;

	public DeleteToolHandler(EToolsTreePart eToolsTreePart) {
		this.eToolsTreePart = eToolsTreePart;
	}

	@CanExecute
	public boolean canExecute(@Optional List<?> selection) {
		if (selection != null) {
			eToolsTreePart.getUseCase().getController().unbindAll();
			command = DeleteCommand.create(UCToolsPlugin.getDefault()
					.getToolsManager().getEditingDomain(), selection);
			return command.canExecute();
		}
		return false;
	}

	@Execute
	public void execute() {
		EObject rootGroup = ((EObject) eToolsTreePart.getSelectedObject());
		command = DeleteCommand.create(UCToolsPlugin.getDefault()
				.getToolsManager().getEditingDomain(), rootGroup);
		if (command != null && command.canExecute())
			UCToolsPlugin.getDefault().getToolsManager().getEditingDomain()
					.getCommandStack().execute(command);
	}

}
