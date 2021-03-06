package org.eclipse.rcpl.contacts.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.rcpl.contacts.addon.OsgiContactsAddon;
import org.eclipse.rcpl.model_2_0_0.rcpl.PersonGroup;
import org.eclipse.rcpl.model_2_0_0.rcpl.RcplFactory;
import org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage;

public class AddGroupHandler {

	private Object selectedItem;

	@Execute
	public void execute() {
		if (selectedItem instanceof PersonGroup) {
			PersonGroup group = (PersonGroup) selectedItem;
			PersonGroup newGroup = RcplFactory.eINSTANCE.createPersonGroup();
			newGroup.setName("New Group");
			// EContactGroup rootGroup = JO.session.getJoffice().getContacts();
			Command command = AddCommand.create(
					OsgiContactsAddon.getEditingDomain(), group,
					RcplPackage.Literals.PERSON_GROUP, newGroup);
			if (command != null && command.canExecute())
				OsgiContactsAddon.getEditingDomain().getCommandStack()
						.execute(command);
		}
	}

	public Object getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(Object selectedItem) {
		this.selectedItem = selectedItem;
	}
}
