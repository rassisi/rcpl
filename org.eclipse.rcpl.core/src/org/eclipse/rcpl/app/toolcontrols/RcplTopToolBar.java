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

import java.util.HashMap;
import java.util.List;

import org.eclipse.rcpl.IRcplAddon;
import org.eclipse.rcpl.ITool;
import org.eclipse.rcpl.ITopToolbar;
import org.eclipse.rcpl.Rcpl;
import org.eclipse.rcpl.model.RcplModel;
import org.eclipse.rcpl.model.client.RcplSession;
import org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool;
import org.eclipse.rcpl.model_2_0_0.rcpl.Perspective;
import org.eclipse.rcpl.model_2_0_0.rcpl.ToolGroup;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

/**
 * @author ramin
 *
 */
public class RcplTopToolBar implements ITopToolbar {

	private HashMap<String, HBox> toolPaneRegistry = new HashMap<String, HBox>();

	public static final int RIBBON_HEIGHT = 110 + 30;

	public static final int COLLAPSED_HEIGHT_WITH_EDITOR = 50;

	public static final int COLLAPSED_HEIGHT = 10;

	@Override
	public void clear() {
		toolPaneRegistry.clear();
	}

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
					processTopBarMainGroups(p.getId(), null);
				}
			}
		} catch (Throwable ex) {
			RcplModel.logError(ex);
		}

	}

	@Override
	public void expandAll() {
		if (collapsed) {
			collapse(false);
			Rcpl.UIC.expandLeftAra(true);
		}

	}

	private void processTopBarMainGroups(String perspectiveId, IRcplAddon addon) {
		HBox pane = new HBox();
		pane.setAlignment(Pos.CENTER_LEFT);
		pane.setSpacing(4);
		Perspective perspective = RcplSession.getDefault().getModelUtil().findPerspective(perspectiveId);
		pane.setId("topBarHBox");
		Rcpl.UIC.getMainTopStack().getChildren().add(pane);
		toolPaneRegistry.put(perspectiveId, pane);
		List<ToolGroup> toolGroups = perspective.getTopToolBar().getToolGroups();

		boolean first = true;
		for (AbstractTool eAbstractTool : toolGroups) {
			String id = eAbstractTool.getId();
			if ("topBar/URL_ADDRESS_TOOL_COMPONENT".equals(id)) {
				ITool toolNode = null;
				toolNode = Rcpl.getToolFactory().createURLAddressTool((ToolGroup) eAbstractTool);
				if (toolNode != null) {
					pane.getChildren().add(toolNode.getNode());
				}
			} else {
				Node toolNode = null;
				toolNode = Rcpl.getFactory().createRibbonGroup((ToolGroup) eAbstractTool, addon, first, true);
				if (toolNode != null) {
					pane.getChildren().add(toolNode);
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
					updateHeight();
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

}
