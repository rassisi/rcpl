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
package org.eclipse.rcpl.app.toolcontrols;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.rcpl.IEditor;
import org.eclipse.rcpl.IRcplAddon;
import org.eclipse.rcpl.ITool;
import org.eclipse.rcpl.ITopToolbar;
import org.eclipse.rcpl.Rcpl;
import org.eclipse.rcpl.model.RCPLModel;
import org.eclipse.rcpl.model.client.RcplSession;
import org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool;
import org.eclipse.rcpl.model_2_0_0.rcpl.Perspective;
import org.eclipse.rcpl.model_2_0_0.rcpl.RcplFactory;
import org.eclipse.rcpl.model_2_0_0.rcpl.Tool;
import org.eclipse.rcpl.model_2_0_0.rcpl.ToolGroup;
import org.eclipse.rcpl.model_2_0_0.rcpl.TopToolBar;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

/**
 * @author ramin
 *
 */
public class RcplTopToolBar implements ITopToolbar {

	private HashMap<String, HBox> toolPaneRegistry = new HashMap<String, HBox>();

	public static final int RIBBON_HEIGHT = 110;

//	private static final int BROWSER_HEIGHT = 63;

	public static final int COLLAPSED_HEIGHT_WITH_EDITOR = 50;

	public static final int COLLAPSED_HEIGHT = 10;

	private IEditor editor;

//	public static double RIBBON_GROUP_PADDING = 0;

	public RcplTopToolBar(StackPane parent) {
		Rcpl.topToolbar = this;
		init();
	}

	@Override
	public void init() {
		toolPaneRegistry.clear();
		Rcpl.UIC.getMainTopStack().getChildren().clear();

		try {
			if (RcplSession.getDefault().getRcpl() != null) {
				for (Perspective p : RcplSession.getDefault().getRcpl().getAllPerspectives().getChildren()) {
					IRcplAddon addon = null;
					for (IRcplAddon u : Rcpl.rcplApplicationProvider.getRcplAddons()) {
						if (u.getModel() != null) {
							if (u.getModel().getDefaultPerspective() == p) {
								addon = u;
								break;
							}
						}
					}
					processTopBarMainGroups(p.getId(), addon);
				}
			}
		} catch (Throwable ex) {
			RCPLModel.logError(ex);
		}

	}

	@Override
	public void expandAll() {
		if (collapsed) {
			collapse(false);
			Rcpl.UIC.expandLeftAra(true);
		}

	}

	private List<Node> homeRibbons = new ArrayList<Node>();

	private boolean inHomeRibbonChange = false;

	private void processTopBarMainGroups(String perspectiveId, IRcplAddon addon) {
		HBox pane = new HBox();
		Perspective perspective = RcplSession.getDefault().getModelUtil().findPerspective(perspectiveId);
		pane.setId("topBarHBox");
		pane.setPadding(new Insets(3, 0, 0, 7));
		Rcpl.UIC.getMainTopStack().getChildren().add(pane);
		Rcpl.UIC.getMainTopStack().layout();
		toolPaneRegistry.put(perspectiveId, pane);
//		pane.setPadding(new Insets(RIBBON_GROUP_PADDING, 0, 0, 0));
		processTopBar(pane, perspective.getTopToolBar(), addon);
	}

	private void createCustomRibbonGroup(HBox pane, String name, String toolTip, String toolId, String toolImage,
			boolean firstGroup, IRcplAddon addon) {
		ToolGroup group = null;

		try {
			group = RcplFactory.eINSTANCE.createToolGroup();
			group.setName(name);
			Tool t = RcplFactory.eINSTANCE.createTool();
			t.setId(toolId);
			t.setImage(toolImage);
			group.getTools().add(t);
		} catch (Throwable ex) {
			RCPLModel.logError(ex);

		}
		Node ng = Rcpl.getFactory().createRibbonGroup(group, addon, firstGroup, false);
		pane.getChildren().add(ng);

		homeRibbons.add(ng);

	}

	@Override
	public void processTopBarMainGroups(IRcplAddon addon) {
		if (addon.getModel() != null) {
			// !!!
			// if (new JOMigration().getUseCaseTopBar(useCase) != null) {
			// HBox pane = new HBox();
			// pane.setId("topBarHBox");
			// JO.UIC.getMainTopStack().getChildren().add(pane);
			// JO.UIC.getMainTopStack().layout();
			// registerToolPane(useCase.getId(), pane);
			// // !!!
			// // processTopBar(pane,
			// // new JOMigration().getUseCaseTopBar(useCase), useCase);
			// }
		}
	}

	private void processTopBar(HBox pane, TopToolBar topToolBar, IRcplAddon useCase) {
		List<ToolGroup> toolGroups = topToolBar.getToolGroups();

		boolean first = true;
		for (AbstractTool eAbstractTool : toolGroups) {
			String id = eAbstractTool.getId();
			if ("topBar/URL_ADDRESS_TOOL_COMPONENT".equals(id)) {
				ITool toolNode = null;
				toolNode = Rcpl.getToolFactory().createURLAddressTool((ToolGroup) eAbstractTool);
				if (toolNode != null) {
					pane.getChildren().add(toolNode.getNode());
					HBox.setMargin(toolNode.getNode(), new Insets(0, 14, 0, 0));
				}
			} else {
				Node toolNode = null;
				toolNode = Rcpl.getFactory().createRibbonGroup((ToolGroup) eAbstractTool, useCase, first, true);
				if (toolNode != null) {
					pane.getChildren().add(toolNode);
					HBox.setMargin(toolNode, new Insets(3, 10, 7, 0));
				}
			}
			first = false;
		}
	}

	private boolean collapsed = false;

	@Override
	public void collapse(boolean collapse) {
		collapsed = collapse;
		Rcpl.UIC.collapseMainTopArea(collapse);
		updateHeight();
	}

	@Override
	public void updateHeight() {
		if (collapsed) {

//			Rcpl.UIC.setTopAreaHeight(COLLAPSED_HEIGHT);

			if (Rcpl.UIC.getEditor() != null) {
				Rcpl.UIC.setTopAreaHeight(COLLAPSED_HEIGHT_WITH_EDITOR);
			} else {
				Rcpl.UIC.setTopAreaHeight(COLLAPSED_HEIGHT);
			}
			return;
		}
		if (Rcpl.UIC.getPerspective() != null) {
			Perspective p = Rcpl.UIC.getPerspective();
			if (!p.getTopToolBar().getToolGroups().isEmpty()) {
				Rcpl.UIC.setTopAreaHeight(RIBBON_HEIGHT);
			} else {
				if (Rcpl.UIC.getEditor() != null) {
					Rcpl.UIC.setTopAreaHeight(COLLAPSED_HEIGHT_WITH_EDITOR);
				} else {
					Rcpl.UIC.setTopAreaHeight(COLLAPSED_HEIGHT);
				}
			}

		}
	}

	@Override
	public void showPerspective(final Perspective perspective) {

		javafx.application.Platform.runLater(new Runnable() {

			@Override
			public void run() {
				Rcpl.UIC.getMainTopStack().getChildren().clear();
				if (perspective != null) {
					Node n = toolPaneRegistry.get(perspective.getId());
					if (n != null) {
						Rcpl.UIC.getMainTopStack().getChildren().add(n);
					}
					collapsed = false;
					updateHeight();
					collapse(false);
				}

			}
		});

	}

	@Override
	public void hideAll() {
		if (Platform.isFxApplicationThread()) {
			Rcpl.UIC.getMainTopStack().getChildren().clear();
			Rcpl.UIC.setTopAreaHeight(0);
		} else {
			Platform.runLater(new Runnable() {

				@Override
				public void run() {
					Rcpl.UIC.getMainTopStack().getChildren().clear();
					Rcpl.UIC.setTopAreaHeight(0);
				}
			});
		}
	}

	public boolean isCollapsed() {
		return collapsed;
	}

	public IEditor getEditor() {
		return editor;
	}

	@Override
	public void setEditor(IEditor editor) {
		this.editor = editor;
	}

}
