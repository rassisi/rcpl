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
package org.eclipse.rcpl.migration;

import org.eclipse.rcpl.IRcplAddon;
import org.eclipse.rcpl.Rcpl;
import org.eclipse.rcpl.model.RCPLModel;
import org.eclipse.rcpl.model.cdo.client.RcplSession;
import org.eclipse.rcpl.model_2_0_0.rcpl.Addon;
import org.eclipse.rcpl.model_2_0_0.rcpl.Perspective;
import org.eclipse.rcpl.model_2_0_0.rcpl.RCPL;
import org.eclipse.rcpl.model_2_0_0.rcpl.RcplFactory;
import org.eclipse.rcpl.model_2_0_0.rcpl.SideToolBar;
import org.eclipse.rcpl.model_2_0_0.rcpl.ToolGroup;
import org.eclipse.rcpl.model_2_0_0.rcpl.TopToolBar;

/**
 * @author ramin
 *
 */
public abstract class RcplAbstractMigration extends RCPLModel {

	protected IRcplAddon addon;

	public RcplAbstractMigration(IRcplAddon addon) {
		this.addon = addon;
	}

	public RcplAbstractMigration() {

	}

	public abstract void migrate();

	/**
	 * @param perspectiveType
	 * @param id
	 */
	protected void addGroupToTopBar(String perspectiveType, String id, String name, String image) {
		addGroupToTopBar(perspectiveType, id, name, image, -1);
	}

	// protected void addGroupToTopBar(String useCaseId, String id, String name,
	// int index) {
	// IUseCase useCase = JO.UIC.findUsecase(useCaseId);
	// if (useCase != null) {
	// addGroupToTopBar(useCase, id, name, index);
	// }
	// }

	protected void addToolToQuickBar(String useCaseId, String id, String name, String image, int index) {
		IRcplAddon useCase = Rcpl.UIC.findRcplAddons(useCaseId);
		if (useCase != null) {
			addToolToQuickBar(id, name, index);
		}
	}

	protected Perspective findOrCreatePerspective(String id, String name, String image) {
		Perspective perspective = RcplSession.getDefault().getModelUtil().findPerspective(id);
		if (perspective == null) {
			perspective = RcplFactory.eINSTANCE.createPerspective();
			perspective.setId(id);
			perspective.setName(name);
			perspective.setImage(image);
			getRCPL().getAllPerspectives().getChildren().add(perspective);
			commit();
		}

		return perspective;
	}

	protected void commit() {
		RcplSession.getDefault().commit();
	}

	protected RCPL getRCPL() {
		return RcplSession.getDefault().getRcpl();
	}

	protected void removeGroupFromTopBar(String useCaseId, String id) {
		IRcplAddon useCase = Rcpl.UIC.findRcplAddons(useCaseId);
		if (useCase != null) {
			removeGroupFromTopBar(useCase, id);
		}
	}

	protected void addGroupToTopBar(IRcplAddon useCase, String id, String name, String image, int index) {
		Addon eAddon = useCase.getModel();
		if (eAddon == null) {
			return;
		}
		addGroupToTopBar(getAddonTopBar(useCase), id, name, image, index);
	}

	protected void addGroupToSideBar(IRcplAddon useCase, String id, String name, String image, int index) {
		Addon eAddon = useCase.getModel();
		if (eAddon == null) {
			return;
		}
		addGroupToSideBar(getAddonSideBar(useCase), id, name, image, index);
	}

	public TopToolBar getAddonTopBar(IRcplAddon addon) {
		if (addon.getModel().getDefaultPerspective() != null) {
			addon.getModel().getDefaultPerspective().getTopToolBar();
		}
		return null;
	}

	public SideToolBar getAddonSideBar(IRcplAddon useCase) {
		if (addon.getModel().getDefaultPerspective() != null) {
			addon.getModel().getDefaultPerspective().getSideToolBar();
		}
		return null;
	}

	/**
	 * @param perspectiveType
	 * @param id
	 * @param index
	 */
	protected void addGroupToTopBar(String perspectiveType, String id, String name, String image, int index) {
		Perspective perspective = RcplSession.getDefault().getModelUtil().findPerspective(perspectiveType);
		addGroupToTopBar(perspective.getTopToolBar(), id, name, image, index);
	}

	/**
	 * @param perspectiveType
	 * @param id
	 * @param index
	 */
	private void addGroupToTopBar(TopToolBar topToolBar, String id, String name, String image, int index) {
		ToolGroup g = RcplSession.getDefault().getModelUtil().findToolGroup(topToolBar, id);
		if (g == null) {
			g = RcplSession.getDefault().getModelUtil().findToolGroup(RcplSession.getDefault().getRcpl(), id);
		}
		if (g == null) {
			g = RcplFactory.eINSTANCE.createToolGroup();
			g.setId(id);
			g.setName(name);
			g.setImage(image);
			RcplSession.getDefault().getRcpl().getAllTools().getToolgroupChildren().add(g);
			RcplSession.getDefault().commit();
		}

		if (!topToolBar.getToolGroups().contains(g)) {
			if (index >= 0) {
				topToolBar.getToolGroups().add(index, g);
			} else {
				topToolBar.getToolGroups().add(g);
			}
		}
	}

	/**
	 * @param perspectiveType
	 * @param id
	 * @param index
	 */
	private void addGroupToSideBar(SideToolBar sideToolBar, String id, String name, String image, int index) {
		ToolGroup g = RcplSession.getDefault().getModelUtil().findToolGroup(sideToolBar, id);
		if (g == null) {
			g = RcplSession.getDefault().getModelUtil().findToolGroup(RcplSession.getDefault().getRcpl(), id);
		}
		if (g == null) {
			g = RcplFactory.eINSTANCE.createToolGroup();
			g.setId(id);
			g.setName(name);
			g.setImage("24/" + id);
			RcplSession.getDefault().getRcpl().getAllTools().getToolgroupChildren().add(g);
			RcplSession.getDefault().commit();
		}

		if (!sideToolBar.getToolGroups().contains(g)) {
			if (index >= 0) {
				sideToolBar.getToolGroups().add(index, g);
			} else {
				sideToolBar.getToolGroups().add(g);
			}
		}
	}

	/**
	 * @param perspectiveType
	 * @param id
	 * @param index
	 */
	private void addToolToQuickBar(String id, String name, int index) {

		// !!! 1
		// QuickTools quickTools =
		// JOSession.getDefault().getRcpl().getTools().getQuickTools();
		// if (quickTools == null) {
		// quickTools = RcplFactory.eINSTANCE.createQuickTools();
		// JOSession.getDefault().getRcpl().getAllTools().setQuickTools(quickTools);
		// }
		// Tool t =
		// JOSession.getDefault().findTool(JOSession.getDefault().getRcpl(),
		// id);
		// if (t == null) {
		// t = JOSession.getDefault().findTool(JOSession.getDefault().getRcpl(),
		// id);
		// }
		// if (t != null) {
		// if (!quickTools.getQuickTools().contains(t)) {
		// if (index >= 0) {
		// quickTools.getQuickTools().add(index, t);
		// } else {
		// quickTools.getQuickTools().add(t);
		// }
		// }
		// }
	}

	protected void removeGroupFromTopBar(IRcplAddon useCase, String id) {
		Addon eAddon = useCase.getModel();
		if (eAddon == null) {
			return;
		}
		removeGroupFromTopBar(getAddonTopBar(useCase), id);
	}

	protected void removeAllToolGroupsFromTopBar(IRcplAddon useCase) {
		getAddonTopBar(useCase).getToolGroups().clear();
	}

	protected void removeAllToolGroupsFromSideBar(IRcplAddon useCase) {
		getAddonSideBar(useCase).getToolGroups().clear();
	}

	// protected void removeGroupFromTopBar(String perspectiveType, String id) {
	// Perspective wordPerspective =
	// JOSession.getDefault().findPerspective(perspectiveType);
	// removeGroupFromTopBar(wordPerspective.getTopToolBar(), id);
	// }

	protected void removeGroupFromTopBar(TopToolBar topToolBar, String id) {
		ToolGroup g = RcplSession.getDefault().getModelUtil().findToolGroup(topToolBar, id);
		if (g != null) {
			topToolBar.getToolGroups().remove(g);
		}
	}

	/**
	 * @param perspectiveType
	 * @param id
	 */
	protected void addGroupToSideBar(String perspectiveType, String id, String image) {
		addGroupToSideBar(perspectiveType, id, image, -1);
	}

	// /**
	// * @param perspectiveType
	// * @param id
	// * @param index
	// */
	// protected void addGroupToSideBar(String perspectiveType, String id,
	// String image, int index) {
	// Perspective wordPerspective =
	// JOSession.getDefault().findPerspective(perspectiveType);
	// SideToolBar sideToolBar = wordPerspective.getSideToolBar();
	// addGroupToSideBar(sideToolBar, id, image, index);
	// }

	protected void addGroupToSideBar(String useCaseId, String id, String image, int index) {
		IRcplAddon useCase = Rcpl.UIC.findRcplAddons(useCaseId);
		SideToolBar sideToolBar = getAddonSideBar(useCase);
		addGroupToSideBar(sideToolBar, id, image, index);
	}

	protected void removeGroupFromSideBar(String useCaseId, String id, int index) {
		IRcplAddon useCase = Rcpl.UIC.findRcplAddons(useCaseId);
		SideToolBar sideToolBar = getAddonSideBar(useCase);
		removeGroupFromSideBar(sideToolBar, id);
	}

	/**
	 * @param perspectiveType
	 * @param id
	 * @param index
	 */
	private void addGroupToSideBar(SideToolBar sideToolBar, String id, String image, int index) {
		ToolGroup g = RcplSession.getDefault().getModelUtil().findToolGroup(sideToolBar, id);
		if (g == null) {
			g = RcplSession.getDefault().getModelUtil().findToolGroup(RcplSession.getDefault().getRcpl(), id);
			if (g != null) {
				if (index >= 0) {
					sideToolBar.getToolGroups().add(index, g);
				} else {
					sideToolBar.getToolGroups().add(g);
				}
			}
		}
	}

	protected void removeGroupFromSideBar(String perspectiveType, String id) {
		Perspective wordPerspective = RcplSession.getDefault().getModelUtil().findPerspective(perspectiveType);
		SideToolBar sideToolBar = wordPerspective.getSideToolBar();
		removeGroupFromSideBar(sideToolBar, id);
	}

	private void removeGroupFromSideBar(SideToolBar sideToolBar, String id) {
		ToolGroup g = RcplSession.getDefault().getModelUtil().findToolGroup(sideToolBar, id);
		if (g != null) {
			sideToolBar.getToolGroups().remove(g);
		}
	}

}
