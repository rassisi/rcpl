package org.eclipse.rcpl.internal.factory.impl;

import org.eclipse.rcpl.EnServiceId;
import org.eclipse.rcpl.IService;
import org.eclipse.rcpl.IServiceFactory;
import org.eclipse.rcpl.internal.services.RcplBrowserService;
import org.eclipse.rcpl.internal.services.RcplCommandService;
import org.eclipse.rcpl.internal.services.RcplContextMenuGeneralService;
import org.eclipse.rcpl.internal.services.RcplDeleteService;
import org.eclipse.rcpl.internal.services.RcplDocumentService;
import org.eclipse.rcpl.internal.services.RcplEditorService;
import org.eclipse.rcpl.internal.services.RcplService;
import org.eclipse.rcpl.internal.services.RcplSetupService;

/**
 * @author Ramin
 *
 */
public class RcplServiceFactory implements IServiceFactory {

	@Override
	public IService createService(EnServiceId id) {
		switch (id) {
		case BROWSER_SERVICE:
			return new RcplBrowserService();
		case COLOR_SERVICE:
			return null;
		case COMMAND_SERVICE:
			return new RcplCommandService();
		case CONTEXT_MENU_SERVICE:
			return new RcplContextMenuGeneralService();
		case DEFAULT_SERVICE:
			return new RcplService();
		case DELETE_SERVICE:
			return new RcplDeleteService();
		case DOCUMENT_SERVICE:
			return new RcplDocumentService();
		case EDITOR_SERVICE:
			return new RcplEditorService();
		case FONT_SERVICE:
			return null;
		case INSERT_SERVICE:
			return null;
		case LAYOUT_SERVICE:
			return null;
		case PARAGRAPH_SERVICE:
			return null;
		case PICTURE_SERVICE:
			return null;
		case SETUP_SERVICE:
			return new RcplSetupService();
		case TABLE_SERVICE:
			return null;
		default:
			break;

		}
		return null;
	}

	@Override
	public IService createService(String id) {
		return null;
	}

}
