package org.eclipse.rcpl.ui.parts.contacts;

import org.eclipse.rcpl.IRcplAddon;
import org.eclipse.rcpl.contacts.addon.RcplContactsAddon;
import org.eclipse.rcpl.migration.RcplAbstractMigration;

public class EContactsMigration extends RcplAbstractMigration {

	public EContactsMigration(IRcplAddon useCase) {
		super(useCase);
	}

	@Override
	public void migrate() {

		// removeGroupFromTopBar(JOModel.USE_CASE_CONTACTS,
		// "sideBar/clipboard");
		// removeGroupFromTopBar(JOModel.USE_CASE_CONTACTS, "topBar/contacts");
		// removeGroupFromTopBar(JOModel.USE_CASE_CONTACTS, "topBar/Contacts");
		// addGroupToTopBar(JOModel.USE_CASE_CONTACTS, "sideBar/clipboard", 0);

		// IUseCase ucContacts = JO.UIC.findUsecase(JOModel.USE_CASE_CONTACTS);
		// ucContacts.getEUseCase().setName("Contacts");
		//
		addGroupToTopBar(addon, "addContact_419", "Add Contact", "addContact_419", 0);
		addGroupToTopBar(addon, "addContactsGroup", "Add Contact Group", "addContactsGroup", 0);

		// removeGroupFromTopBar(EContactsUseCase.ID, "addItProject");

		addToolToQuickBar(RcplContactsAddon.ID, "openContactsPerspective", "Open Contacts Perspective", "contacts", 0);

		// addToolToQuickBar(JOModel.USE_CASE_CONTACTS, "addContactsGroup", 0);
		//
		// addToolToQuickBar(JOModel.USE_CASE_CONTACTS, "deleteContactItem", 0);

	}
}
