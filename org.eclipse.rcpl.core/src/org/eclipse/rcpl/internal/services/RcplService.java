package org.eclipse.rcpl.internal.services;

import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.rcpl.EnCommandId;
import org.eclipse.rcpl.EnServiceId;
import org.eclipse.rcpl.ICommand;
import org.eclipse.rcpl.IDetailPage;
import org.eclipse.rcpl.ILayoutObject;
import org.eclipse.rcpl.IService;
import org.eclipse.rcpl.ITool;
import org.eclipse.rcpl.Rcpl;
import org.eclipse.rcpl.model.RcplModel;
import org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool;
import org.eclipse.rcpl.model_2_0_0.rcpl.HomePage;
import org.eclipse.rcpl.model_2_0_0.rcpl.HomePageType;
import org.eclipse.rcpl.model_2_0_0.rcpl.ToolType;
import org.eclipse.rcpl.service.RcplBaseService;
import org.eclipse.rcpl.ui.action.RcplCommand;

/**
 * @author ramin
 * 
 */
public class RcplService extends RcplBaseService implements IService {

	private IService browserService;

	private IService commandService;

	private IService contextMenuGeneralService;

	private IService deleteService;

	private IService documentService;

	private IService editorService;

	private IService setupService;

	private IService colorService;

	private IService fontService;

	private IService insertService;

	private IService layoutService;

	private IService paragraphService;

	private IService pictureService;

	private IService tableService;

	private IService pageService;

	private HashMap<EnServiceId, IService> serviceRegistry;

	public RcplService() {
	}

	@Override
	public Object doExecute(ICommand command) throws Exception {

		try {
			ITool iTool = command.getTool();
			if (iTool != null) {
				AbstractTool tool = iTool.getModel();
				if (tool != null) {

					if (!ToolType.NAVIGATOR.equals(tool.getType()) && tool.getUrl() != null) {
						Rcpl.UIC().getWebBrowserDetailPage().setTool(tool);
						Rcpl.UIC().getActiveHomePage().getContentPane().getChildren().clear();
						Rcpl.UIC().getActiveHomePage().getContentPane().getChildren()
								.add(Rcpl.UIC().getWebBrowserDetailPage().getNode());
						return true;
					}
					if (tool.getDetailPaneClassName() != null) {
						IDetailPage detailPage = Rcpl.UIC().getDetailPage(tool.getDetailPaneClassName());
						if (detailPage != null) {
							Rcpl.UIC().getActiveHomePage().getContentPane().getChildren().clear();
							Rcpl.UIC().getActiveHomePage().getContentPane().getChildren().add(detailPage.getNode());
							return true;
						}
						return false;
					}
				}
			}

			switch (command.getCommandId()) {
			case PARAGRAPH_COLLAPSEALL:
				Rcpl.UIC().collapseAll();
				break;
			default:
				String service = command.getTool().getService();
				if (service != null) {
					IService srv = getServiceBySimpleName(service);
					if (srv != null) {
						srv.doExecute(command);
						return true;
					}
				}
				return true;
			}

			return true;
		} catch (Throwable ex) {
			RcplModel.logError(ex);
			return false;
		}
	}

	@Override
	public Object execute(ICommand command) {

		if (command.getCommandId() != null && command.getCommandId().equals(EnCommandId.PARAGRAPH_SHOWSTARTMENU)) {
			Rcpl.UIC().showHomePage(HomePageType.OVERVIEW, null);
			return true;
		}

		if (command.getTool() != null) {
			Object[] data = command.getTool().getData();
			if (data != null && data[0] instanceof HomePage) {
				HomePage homePage = (HomePage) data[0];
				Rcpl.UIC().showHomePage(homePage.getType(), homePage.getId());
				return true;
			}
		}

		IService service = getService(command);
		if (service == null) {
			return null;
		}

		try {
			if (command.getModel() != null) {
				return service.doExecute(command.getModel());
			}

			// ---------- LEGACY SUPPORT

			return service.doExecute(command);

		} catch (Exception e) {
			RcplModel.logError(e);
		}

		return null;
	}

	protected void finalizeCommand(RcplCommand command) {
		command.update();
	}

	/**
	 * @param key
	 */
	protected void showGroup(String key, int shelfIndex) {
		selectGroup(key, shelfIndex, true);
	}

	public void showOutLine(ICommand command, boolean show) {
		if (Rcpl.UIC().getEditor() != null) {
			Rcpl.UIC().getEditor().setShowOutlineParagraph(show);
			Iterator<ILayoutObject> it = getDocument(command).layoutObjects();
			while (it.hasNext()) {
				ILayoutObject lo = it.next();
				// TODO ??
				if (lo.getLayoutFigure() != null && lo.getLayoutFigure() != null) {
					lo.getLayoutFigure().showOutline(show);
				}
			}
		}
	}

	public RcplSetupService getSetupService() {
		return (RcplSetupService) getService(RcplSetupService.class);
	}

	protected RcplContextMenuGeneralService getContextMenuGeneralService() {
		return (RcplContextMenuGeneralService) getService(RcplContextMenuGeneralService.class);
	}

	protected RcplDeleteService getDeleteService() {
		return (RcplDeleteService) getService(RcplDeleteService.class);
	}

	protected RcplDocumentService getDocumentService() {
		return (RcplDocumentService) getService(RcplDocumentService.class);
	}

	RcplBrowserService getBrowserService() {
		return (RcplBrowserService) getService(RcplBrowserService.class);
	}

	@Override
	public IService getService(EnServiceId serviceId) {

		switch (serviceId) {
		case BROWSER_SERVICE:
			if (browserService == null) {
				browserService = Rcpl.get().getServiceFactory().createService(serviceId);
			}
			return browserService;
		case COMMAND_SERVICE:
			if (commandService == null) {
				commandService = Rcpl.get().getServiceFactory().createService(serviceId);
			}
			return commandService;
		case CONTEXT_MENU_SERVICE:
			if (contextMenuGeneralService == null) {
				contextMenuGeneralService = Rcpl.get().getServiceFactory().createService(serviceId);
			}
			return contextMenuGeneralService;
		case DEFAULT_SERVICE:
			return this;
		case DELETE_SERVICE:
			if (deleteService == null) {
				deleteService = Rcpl.get().getServiceFactory().createService(serviceId);
			}
			return deleteService;
		case DOCUMENT_SERVICE:
			if (documentService == null) {
				documentService = Rcpl.get().getServiceFactory().createService(serviceId);
			}
			return documentService;
		case EDITOR_SERVICE:
			if (editorService == null) {
				editorService = Rcpl.get().getServiceFactory().createService(serviceId);
			}
			return editorService;
		case SETUP_SERVICE:
			if (setupService == null) {
				setupService = Rcpl.get().getServiceFactory().createService(serviceId);
			}
			return setupService;
		case COLOR_SERVICE:
			if (colorService == null) {
				colorService = Rcpl.get().getServiceFactory().createService(serviceId);
			}
			return colorService;
		case FONT_SERVICE:
			if (fontService == null) {
				fontService = Rcpl.get().getServiceFactory().createService(serviceId);
			}
			return fontService;
		case INSERT_SERVICE:
			if (insertService == null) {
				insertService = Rcpl.get().getServiceFactory().createService(serviceId);
			}
			return insertService;
		case LAYOUT_SERVICE:
			if (layoutService == null) {
				layoutService = Rcpl.get().getServiceFactory().createService(serviceId);
			}
			return layoutService;
		case PARAGRAPH_SERVICE:
			if (paragraphService == null) {
				paragraphService = Rcpl.get().getServiceFactory().createService(serviceId);
			}
			return paragraphService;
		case PICTURE_SERVICE:
			if (pictureService == null) {
				pictureService = Rcpl.get().getServiceFactory().createService(serviceId);
			}
			return pictureService;
		case TABLE_SERVICE:
			if (tableService == null) {
				tableService = Rcpl.get().getServiceFactory().createService(serviceId);
			}
			return tableService;

		case PAGE_SERVICE:
			if (pageService == null) {
				pageService = Rcpl.get().getServiceFactory().createService(serviceId);
			}
			return pageService;

		default:
			break;
		}

		if (serviceRegistry != null) {
			return serviceRegistry.get(serviceId);
		}
		return null;
	}

	@Override
	public void registerService(EnServiceId serviceId, IService service) {
		if (serviceRegistry == null) {
			serviceRegistry = new HashMap<EnServiceId, IService>();
		}
		serviceRegistry.put(serviceId, service);
		Rcpl.get().progressMessage(service.getClass().getSimpleName() + " registered");
	}

}
