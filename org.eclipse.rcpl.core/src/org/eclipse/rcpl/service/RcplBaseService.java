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
package org.eclipse.rcpl.service;

import java.util.Hashtable;

import org.eclipse.rcpl.EnServiceId;
import org.eclipse.rcpl.ICommand;
import org.eclipse.rcpl.IDocument;
import org.eclipse.rcpl.ILayoutObject;
import org.eclipse.rcpl.IParagraph;
import org.eclipse.rcpl.IService;
import org.eclipse.rcpl.Rcpl;
import org.eclipse.rcpl.internal.services.RcplCommandService;
import org.eclipse.rcpl.internal.services.RcplObjectService;
import org.eclipse.rcpl.model_2_0_0.rcpl.Command;
import org.eclipse.rcpl.ui.action.RcplCommand;

/**
 * @author ramin
 *
 */
public class RcplBaseService implements IService {

	protected int savedOffset = 0;

	protected boolean selectionSimulation;

	public static boolean enableUnimplementedMessage = true;

	@Deprecated
	@Override
	public Object doExecute(ICommand event) throws Exception {
		return null;
	}

	@Override
	public Object doExecute(Command event) throws Exception {
		return null;
	}

	private Hashtable<Class<?>, IService> services;

	public RcplBaseService() {
	}

	@Override
	public void registerService(Class<? extends IService> serviceClass) {
		if (services == null) {
			services = new Hashtable<Class<?>, IService>();
		}
		try {
			services.put(serviceClass, serviceClass.newInstance());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	protected IDocument getDocument(ICommand command) {
		ILayoutObject lo = command.getLayoutObject();
		if (lo != null) {
			return lo.getDocument();
		}
		return Rcpl.UIC().getEditor().getDocument();
	}

	// protected boolean match(JOCommand event, String key) {
	// return match(event, key, true);
	// }

	// /**
	// * @param event
	// * @param key
	// * @return
	// */
	// protected boolean match(JOCommand event, String key, boolean exact) {
	// // String key2 = event.getContext() + key;
	// // if (exact) {
	// // if (event.getEntry().getKey().equals(key2)
	// // || event.getEntry().getKey().equals(key)) {
	// // // browser/actions/browser/find_what
	// // // browser/actions/browser/find_what
	// // return true;
	// // }
	// // } else {
	// // key2 = JOResources.getGeneralKey(key);
	// // if (event.getEntry().getKey().endsWith(key2)
	// // || event.getEntry().getKey().startsWith(key)) {
	// // return true;
	// // }
	// // }
	// return false;
	// }

	@Deprecated
	public boolean getBoolean(ICommand cmd) {
		if (cmd.getNewData().length > 0 && cmd.getNewData()[0] instanceof Boolean) {
			return ((Boolean) cmd.getNewData()[0]).booleanValue();
		}
		return false;
	}

	public boolean getBoolean(Command cmd) {
		if (cmd.getNewData().length > 0 && cmd.getNewData()[0] instanceof Boolean) {
			return ((Boolean) cmd.getNewData()[0]).booleanValue();
		}
		return false;
	}

	public String getString(Command cmd) {
		if (cmd.getNewData().length > 0 && cmd.getNewData()[0] instanceof String) {
			return (String) cmd.getNewData()[0];
		}
		return null;
	}

	protected String getId(RcplCommand command) {
		if (command.getTool() != null) {
			return command.getTool().getModel().getId();
		}
		if (command.getCommandId() != null) {
			return command.getCommandId().name();
		}
		return "";
	}

	/**
	 * 
	 */
	protected void initSelectedObjects(ICommand command) {
		selectionSimulation = false;
	}

	/**
	 * @param colorType
	 */
	protected boolean showColorChooser(int colorType, int shelfIndex) {
		// IColorTool colorChooser = (IColorTool) JOUtil2.findEditorTools(
		// "word/actions/object/color_chooser") //$NON-NLS-1$
		// .get(0);
		// boolean result = true;
		// if (colorChooser.getChoosenColorType() == colorType) {
		// result = false;
		// }
		// colorChooser.setChoosenColorType(colorType);
		// JO.service.selectGroup("word/actions/groups/colors", shelfIndex,
		// true); //$NON-NLS-1$
		// return result;

		return true;
	}

	/**
	 * @param figure
	 */
	protected boolean simulateSelection(ICommand command, IParagraph paragraph) {
		if (!(paragraph.hasSelection() && Rcpl.UIC().getEditor().getActiveParagraph() == paragraph)) {
			selectionSimulation = true;
			paragraph.selectAll();
			return true;
		}

		return false;
	}

	//
	// /**
	// *
	// */
	// protected void finalizeSelectedObjects() {
	// getEditor().unselectAll();
	// updateFocusOwner(getEditor());
	// if (dirtyLayoutObjects.size() > 0) {
	// getEditor().setDirtyLayout(dirtyLayoutObjects.get(0));
	// }
	// }

	public RcplObjectService getObjectService() {
		return (RcplObjectService) getService(RcplObjectService.class);
	}

	// public JOPageService getPageService() {
	// return (JOPageService) getService(JOPageService.class);
	// }
	//
	// public JOParagraphService getParagraphService() {
	// return (JOParagraphService) getService(JOParagraphService.class);
	// }
	//
	// public JOPictureService getPictureService() {
	// return (JOPictureService) getService(JOPictureService.class);
	// }

	public IService getService(ICommand command) {

		if (command.getService() != null) {
			return command.getService();
		}
		if (command.getCommandId().getServiceId() != null) {
			EnServiceId servId = command.getCommandId().getServiceId();
			if (servId != null) {
				IService customService = getService(servId);
				if (customService != null) {
					return customService;
				}
			}

		}

		if (command.getTool() != null && command.getTool().getModel().getId() != null) {
			EnServiceId servId = EnServiceId.getServiceId(command.getTool().getModel().getId());
			if (servId != null) {
				IService customService = getService(servId);
				if (customService != null) {
					return customService;
				}
			}
		}

		IService service = getService(command.getCommandId().getServiceId());
		return service;
	}

	public IService getService(EnServiceId serviceId) {
		return null;
	}

	// public JOTableService getTableService() {
	// return (JOTableService) getService(JOTableService.class);
	// }

	/**
	 * @param <T>
	 * @param serviceClass
	 * @return
	 */
	public IService getServiceBySimpleName(String serviceClassSimpleName) {
		for (Class<?> cl : services.keySet()) {
			String sn = cl.getSimpleName();
			if (serviceClassSimpleName.equals(sn)) {
				return getService(cl);
			}
		}
		return null;

	}

	/**
	 * @param <T>
	 * @param serviceClass
	 * @return
	 */
	public IService getService(Class<?> serviceClass) {
		IService service = services.get(serviceClass);
		if (service == null) {
			try {
				service = (IService) serviceClass.newInstance();
				services.put(serviceClass, service);
			} catch (InstantiationException e) {
				// LOGGER.error("", e); //$NON-NLS-1$
			} catch (IllegalAccessException e) {
				// LOGGER.error("", e); //$NON-NLS-1$
			}
		}
		return service;
	}

	@Override
	public void selectGroup(String id, int shelfIndex, boolean b) {
		// TODO Auto-generated method stub

	}

	public RcplCommandService getCommandService() {
		return (RcplCommandService) getService(RcplCommandService.class);
	}

	@Override
	public Object execute(ICommand command) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registerService(EnServiceId serviceId, IService service) {
		// TODO Auto-generated method stub

	}

}
