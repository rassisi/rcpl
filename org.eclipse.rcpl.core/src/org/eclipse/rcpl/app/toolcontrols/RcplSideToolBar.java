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

import org.eclipse.emf.common.util.EList;
import org.eclipse.rcpl.DelayedExecution;
import org.eclipse.rcpl.IButton;
import org.eclipse.rcpl.IHomePage;
import org.eclipse.rcpl.IRcplAddon;
import org.eclipse.rcpl.ISideToolBar;
import org.eclipse.rcpl.ITool;
import org.eclipse.rcpl.Rcpl;
import org.eclipse.rcpl.internal.fx.figures.RcplButton;
import org.eclipse.rcpl.internal.tools.ColorTool;
import org.eclipse.rcpl.model.RcplModel;
import org.eclipse.rcpl.model_2_0_0.rcpl.GroupType;
import org.eclipse.rcpl.model_2_0_0.rcpl.Perspective;
import org.eclipse.rcpl.model_2_0_0.rcpl.Tool;
import org.eclipse.rcpl.model_2_0_0.rcpl.ToolGroup;
import org.eclipse.rcpl.model_2_0_0.rcpl.ToolType;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.util.Duration;

/**
 * @author ramin
 *
 */
public class RcplSideToolBar implements ISideToolBar {

	private HashMap<String, AccordionColorTitlePane> titlePaneRegistry = new HashMap<String, AccordionColorTitlePane>();

	private StackPane toolbarStack;

	private StackPane toolPaneStack;

	private HashMap<String, VBox> toolPaneStackRegistry = new HashMap<String, VBox>();

	private HashMap<String, ToolBar> toolbarRegistry = new HashMap<String, ToolBar>();

	boolean startMenu;

	double lastMinWidth = 0;

	double lastMaxWidth = 0;

	Node firstNode;

	private HBox parent;

	int count = 0;

	private String activeGroupId = "";

	private Pane activeToolPane;

	private List<Object> processedList = new ArrayList<Object>();

	public RcplSideToolBar(HBox parent) {
		this.parent = parent;
		init();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.rcpl.ISideToolBar#showPerspective(org.eclipse.rcpl.model_2_0_0.
	 * rcpl.Perspective, boolean)
	 */
	@Override
	public void showPerspective(Perspective perspective) {

		toolbarStack.getChildren().clear();

		if (perspective != null) {
			Rcpl.UIC.showStartMenuButton(!perspective.isOverview());

			try {
				if (!processedList.contains(perspective.getId())) {
					processedList.add(perspective.getId());

					ToolBar groupsToolBar = new ToolBar();
					StackPane.setMargin(groupsToolBar, new Insets(0, 0, 0, 0));
					groupsToolBar.setOrientation(Orientation.VERTICAL);
					groupsToolBar.setMinWidth(WIDTH_COLLAPSED);
					groupsToolBar.setId("groupVBox");
					toolbarRegistry.put(getKey(perspective.getId()), groupsToolBar);
					List<ToolGroup> toolGroups = getToolGroups(perspective);

					// ---------- create the accordions

					processPerspectiveToolGroups(groupsToolBar, toolGroups, perspective, false);

					// ---------- new: sidebar main buttons can also be simple tool buttons
					// the can be used to open detail panes

					List<Tool> tools = getTools(perspective);

					for (Tool tool : tools) {
						m04_processMainToolGroupButtons(groupsToolBar, perspective, tool);
					}

				}

				ToolBar n = toolbarRegistry.get(getKey(perspective.getId()));
				if (n != null) {
					toolbarStack.getChildren().add(n);

					if (Rcpl.UIC.getEditor() != null) {
						toolbarStack.setPadding(new Insets(-14, 0, 0, 0));
					} else if (Rcpl.UIC.getActiveHomePage() != null) {
						toolbarStack.setPadding(new Insets(IHomePage.HOMEPAGE_HEADER_HEIGHT, 0, 0, 0));
					} else {
						toolbarStack.setPadding(new Insets(0, 0, 0, 0));
					}

					// n.setVisible(true);
				}
				collapseToolPane();

			} catch (Throwable ex) {
				RcplModel.logError(ex);
			}
		}
	}

	/**
	 * 
	 * 
	 * @param toolGroups
	 * @param perspective
	 * @param startMenu
	 */
	private void processPerspectiveToolGroups(ToolBar groupsToolBar, final List<ToolGroup> toolGroups,
			final Perspective perspective, boolean startMenu) {

		if (toolGroups.isEmpty()) {
			return;
		}

		this.startMenu = startMenu;

		final double screenHeight = Screen.getPrimary().getBounds().getHeight();

		Platform.runLater(new Runnable() {

			@Override
			public void run() {

				for (ToolGroup toolGroup_0 : toolGroups) {

					// ---------- create the main toolbar button

					IButton b = new RcplButton(toolGroup_0) {
						@Override
						public void doAction() {
							String groupId0 = toolGroup_0.getId();
							if (groupId0.equals(activeGroupId)) {
								collapseToolPane();
							} else {
								showSideTools(groupId0);
							}
						}
					};

					String url = toolGroup_0.getUrl();
					String detailPaneClassName = toolGroup_0.getDetailPaneClassName();
					if ((url == null || "".contentEquals(url))
							&& (detailPaneClassName == null || "".equals(detailPaneClassName))) {
						b.disableService();
					}
					if (!Rcpl.isBigDisplay()) {
						b.setWidth(16);
						b.setHeight(16);

					} else {
						b.setWidth(18);
						b.setHeight(18);
					}
					Tooltip toolTip = new Tooltip(
							toolGroup_0.getToolTip() != null ? toolGroup_0.getToolTip() : toolGroup_0.getName());
					toolTip.setId("joffice_tooltip");
					groupsToolBar.getItems().add(b.getNode());

					if (ToolType.NAVIGATOR.equals(toolGroup_0.getType())) {
						// navigator type for tool group is allowed
					} else if (toolGroup_0.getToolGroups().isEmpty() && toolGroup_0.getTools().isEmpty()) {
						continue;
					}

					// ---------- create an accordion

					try {
						VBox sideToolsVbox = new VBox(2);
						sideToolsVbox.setPrefHeight(100);
						sideToolsVbox.setPrefWidth(304);

						toolPaneStackRegistry.put(getKey(perspective.getId(), toolGroup_0.getId()), sideToolsVbox);

						sideToolsVbox.setPrefHeight(screenHeight);

						// ---------- accordion -----------

						Accordion accordion = new Accordion();

						accordion.expandedPaneProperty().addListener(new ChangeListener<TitledPane>() {
							@Override
							public void changed(ObservableValue<? extends TitledPane> property,
									final TitledPane oldPane, final TitledPane newPane) {
								if (oldPane != null)
									oldPane.setCollapsible(true);
								if (newPane != null)
									Platform.runLater(new Runnable() {
										@Override
										public void run() {
											newPane.setCollapsible(false);
										}
									});
							}
						});

						accordion.setUserData(toolGroup_0);
						accordion.setId("sideBarAccordion");
						accordion.setPrefHeight(screenHeight);
						accordion.setPrefWidth(WIDTH_EXPANDED_1);
						sideToolsVbox.getChildren().add(accordion);

						processAccordion(toolGroup_0, accordion, null, 0);

						toolGroup_0.setReady(true);
					} catch (Exception ex) {
						RcplModel.logError(ex);
					}
				}

				// selectFirstGroup(perspective, useCase, toolGroups, false);
			}
		});

	}

	/**
	 * Create all accordions
	 * 
	 * @param toolGroup
	 * @param accordion
	 * @param titlePane
	 */
	private void processAccordion(ToolGroup toolGroup, Accordion accordion, AccordionColorTitlePane titlePane,
			int hierarchy) {

		if ("TOOLBAR_SHAPES".equals(toolGroup.getId())) {
			System.out.println();
		}

		// ---------- If there are no top level groups then process only Tools -

		if (!groupHasAccordionItems(toolGroup)) {
			processTools(toolGroup, accordion, hierarchy);
			return;
		}

		// ---------- creae new accordion & request Focus ----------------------

		if (!toolGroup.getToolGroups().isEmpty()) {
			Accordion newAccordion = new Accordion() {
				@Override
				public void requestFocus() {
					try {
						super.requestFocus();
					} catch (Exception ex) {
						RcplModel.logError(ex);
					}
				};
			};
			titlePane = new AccordionColorTitlePane(this, toolGroup, newAccordion, hierarchy, titlePaneRegistry);
			accordion.getPanes().add(titlePane);
			accordion = newAccordion;
		}

		// ---------- process all groups ---------------------------------------

		for (ToolGroup accordionGroup : toolGroup.getToolGroups()) {
			if (accordionGroup.getGroupType() == null
					|| GroupType.ACCORDIONITEM.equals(accordionGroup.getGroupType())) {
				processAccordion(accordionGroup, accordion, titlePane, hierarchy + 1);
			}
		}

	}

	/**
	 * @param toolGroupToolBar
	 * @param perspectiveType
	 * @param toolGroup
	 */
	private void m04_processMainToolGroupButtons(final ToolBar toolGroupToolBar, final Perspective perspectiveType,
			final Tool tool) {
		IButton b = Rcpl.getFactory().createButton(tool);
		if (!Rcpl.isBigDisplay()) {
			b.setWidth(16);
			b.setHeight(16);

		} else {
			b.setWidth(18);
			b.setHeight(18);
		}
		Tooltip toolTip = new Tooltip(tool.getToolTip() != null ? tool.getToolTip() : tool.getName());
		toolTip.setId("joffice_tooltip");
		toolGroupToolBar.getItems().add(b.getNode());
	}

	private void processTool(final Tool model, Pane pane, final AccordionColorTitlePane titlePane) {

		try {
			String image = model.getImage();
			if (image == null || image.length() == 0) {
				image = model.getId();
			}

			final ITool tool;

			if ("fontName".equals(model.getId())) {
				tool = Rcpl.getToolFactory().createTool(model);
			} else if ("fontSize".equals(model.getId())) {
				tool = Rcpl.getToolFactory().createTool(model);
			} else {
				switch (model.getType()) {
				case COLOR_CHOOSER:
					tool = createColorTool(model, pane, titlePane);
					break;

				case OTHER:
					tool = Rcpl.getToolFactory().createTool(model);
					break;
				default:
					tool = Rcpl.getToolFactory().createTool(model);
					break;
				}
			}

			final ITool nodeCreated = tool;
			if (tool != null) {
				if (pane instanceof GridPane) {
					int x = model.getGridX();
					int y = model.getGridY();
					int spanX = model.getSpanX();
					int spanY = model.getSpanY();
					if (model.isLabeled()) {
						Label label = new Label(model.getName());
						((GridPane) pane).add(label, x, y, 1, 1);
						x++;
					}

					try {
						((GridPane) pane).add(tool.getNode(), x, y, spanX, spanY);
					} catch (Exception ex) {
						RcplModel.logError(ex);
					}
					GridPane.setMargin(tool.getNode(), new Insets(5));
				} else {
					FlowPane.setMargin(tool.getNode(), new Insets(3));
					try {
						pane.getChildren().add(tool.getNode());
					} catch (Exception ex) {
						RcplModel.logError(ex);
					}
				}
				tool.getNode().setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent arg0) {
						if (nodeCreated instanceof ListView<?>) {
							if (arg0.getClickCount() == 2) {
								Rcpl.service().execute(Rcpl.getFactory().createCommand(tool));
							}
						}
					}
				});
			}
		} catch (Exception ex) {
			RcplModel.logError(ex);
		}
	}

	/**
	 * @param perspective
	 * @param startMenu
	 * @return
	 */

	private void processTools(ToolGroup toolGroup, Accordion accordion, int hierarchy) {

		try {
			final StackPane stackPane = new StackPane();

			AccordionColorTitlePane titlePane = new AccordionColorTitlePane(this, toolGroup, stackPane, hierarchy,
					titlePaneRegistry);

			accordion.getPanes().add(titlePane);
			ScrollPane scrollPane = new ScrollPane();
			scrollPane.setFitToHeight(true);
			scrollPane.setFitToWidth(true);
			StackPane.setMargin(scrollPane, new Insets(0));
			stackPane.getChildren().add(scrollPane);

			if (ToolType.NAVIGATOR.equals(toolGroup.getType())) {

				try {
					scrollPane.setContent(Rcpl.UIC.getRcplTreepart().getNode());
				} catch (Throwable ex) {
					RcplModel.logError(ex);
				}
				return;
			}

			Pane pane;
			VBox vBox2 = new VBox();

			if (toolGroup.isGrid()) {
				GridPane gridPane = new GridPane();
				// gridPane.setStyle("-fx-background-color:green");
				// gridPane.setId("accordeonItemPaneId");
				vBox2.getChildren().add(gridPane);
				VBox.setMargin(gridPane, new Insets(MARGIN_BOX_1));
				VBox.setVgrow(gridPane, Priority.ALWAYS);
				pane = gridPane;
			} else {
				FlowPane toolFlowPane = new FlowPane();
				// toolFlowPane.setStyle("-fx-background-color: orange");
				toolFlowPane.setHgap(3);
				toolFlowPane.setVgap(3);
				// toolFlowPane.setId("accordeonItemPaneId");
				vBox2.getChildren().add(toolFlowPane);
				VBox.setMargin(toolFlowPane, new Insets(MARGIN_BOX_1));
				VBox.setVgrow(toolFlowPane, Priority.ALWAYS);
				pane = toolFlowPane;
			}

			scrollPane.setContent(vBox2);
			// scrollPane.setStyle("-fx-background-color: gold");

			for (ToolGroup g : toolGroup.getToolGroups()) {

				if (GroupType.GRIDPANE.equals(g.getType())) {
					GridPane gp = new GridPane();
					gp.setId("verticalGradientPane");
					if (toolGroup.isGrid()) {
						int x = g.getGridX();
						int y = g.getGridY();
						int spanX = g.getSpanX();
						int spanY = g.getSpanY();
						((GridPane) pane).add(gp, x, y, spanX, spanY);
						GridPane.setMargin(gp, new Insets(5));
						GridPane.setHgrow(gp, Priority.ALWAYS);
						// ((GridPane) gp).setGridLinesVisible(true);
					} else {
						pane.getChildren().add(gp);
					}
					for (Tool t : g.getTools()) {
						processTool(t, gp, titlePane);
					}
				}

				else {

					processTools(g, accordion, ++hierarchy);
					return;
				}

			}

			for (Tool tool : toolGroup.getTools()) {
				processTool(tool, pane, titlePane);
			}
		} catch (Exception ex) {
			RcplModel.logError(ex);
		}
	}

	public void selectFirstGroup(final String perspective, IRcplAddon useCase, EList<ToolGroup> tools) {
		if (!tools.isEmpty()) {
			for (ToolGroup t : tools) {
				showSideTools(t.getId());
				break;
			}
		}
	}

	@Override
	public void showSideTools() {
		String id = activeGroupId;
		activeGroupId = "";
		showSideTools(id);
	}

	private boolean showSideTools(final String groupId) {

		try {
			if (groupId == null || groupId.length() == 0) {
				return false;
			}

			Perspective actualPerspective = Rcpl.UIC.getPerspective();
			String perspectiveId = actualPerspective.getId();

			Pane pane = toolPaneStackRegistry.get(getKey(perspectiveId, groupId));
			if (pane != null) {
				pane.setVisible(true);
				activeToolPane = pane;
				activeGroupId = groupId;

				final Timeline timeline = new Timeline(
						new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent actionEvent) {
								expandAccordion();
								expandToolPane(groupId);

							}
						}));
				timeline.setCycleCount(1);
				timeline.play();

				return true;
			} else {
				activeToolPane = null;
			}
		} catch (Throwable ex) {
			RcplModel.logError(ex);
		}
		return false;
	}

	@Override
	public void clear() {
		titlePaneRegistry.clear();
		toolPaneStackRegistry.clear();
		toolbarRegistry.clear();
		processedList.clear();
	}

	@Override
	public void init() {
		this.parent.getChildren().clear();
		toolbarStack = new StackPane();
		HBox.setMargin(toolbarStack, new Insets(0, 0, 0, -6));
		toolPaneStack = new StackPane();
		this.parent.getChildren().addAll(toolbarStack, toolPaneStack);
	}

	/**
	 * Nur die Groupbuttons sind zu sehen
	 */
	@Override
	public void collapseToolPane() {
		parent.setMaxWidth(WIDTH_COLLAPSED);
		parent.setMinWidth(WIDTH_COLLAPSED);
		parent.setPrefWidth(WIDTH_COLLAPSED);
		BorderPane.setMargin(Rcpl.UIC.getMainBottomArea(), new Insets(0, 0, 0, WIDTH_COLLAPSED_BOTTOM));
		activeGroupId = null;
		toolPaneStack.getChildren().clear();
	}

	private ITool createColorTool(final Tool eTool, Pane flowPane, final AccordionColorTitlePane titlePane) {

		final ColorTool ct = new ColorTool(eTool);

		return ct;
	}

	private void expandAccordion() {
		try {
			if (activeToolPane != null) {
				for (Node n : activeToolPane.getChildren()) {

					if (n instanceof Accordion) {

						final Accordion acc = (Accordion) n;
						for (TitledPane p : acc.getPanes()) {
							if (p instanceof AccordionColorTitlePane) {
								final AccordionColorTitlePane ap = (AccordionColorTitlePane) p;

								Platform.runLater(new Runnable() {
									@Override
									public void run() {
										ap.setExpanded(true);
										// always expand first child

										acc.layout();

										if (!ap.getToolGroup().getToolGroups().isEmpty()) {

											final AccordionColorTitlePane tp1 = getTitlePane(
													ap.getToolGroup().getToolGroups().get(0));
											if (tp1 != null) {
												new DelayedExecution(10) {
													@Override
													protected void execute() {
														tp1.setExpanded(true);
														tp1.layout();

													};
												};
												if (!tp1.getToolGroup().getToolGroups().isEmpty()) {

													final AccordionColorTitlePane tp2 = getTitlePane(
															tp1.getToolGroup().getToolGroups().get(0));
													if (tp2 != null) {

														new DelayedExecution(10) {
															@Override
															protected void execute() {
																tp2.setExpanded(true);
																tp2.layout();

															};
														};

													}

													if (tp2 != null && !tp2.getToolGroup().getToolGroups().isEmpty()) {

														final AccordionColorTitlePane tp3 = getTitlePane(
																tp2.getToolGroup().getToolGroups().get(0));
														if (tp3 != null) {

															new DelayedExecution(300) {
																@Override
																protected void execute() {
																	tp3.setExpanded(true);
																	tp3.layout();

																};
															};

														}

													}

												}
											}

										}

									}
								});

							}

							break;

						}
						// ToolGroup g = (ToolGroup) n.getUserData();
						// String gid = g.getToolId();
						break;
					}
				}
			}
		} catch (Throwable ex) {
			RcplModel.logError(ex);
		}

	}

	/**
	 * @param groupId
	 */
	private void expandToolPane(String groupId) {

		try {
			try {
				Pane pane = toolPaneStackRegistry.get(getKey(getPerspectiveId(), groupId));
				toolPaneStack.getChildren().clear();
				toolPaneStack.getChildren().add(pane);
				pane.setVisible(true);

			} catch (Exception ex) {
				RcplModel.logError(ex);
			}

			if ("images".equals(groupId)) {
				parent.setMaxWidth(WIDTH_EXPANDED_IMAGES);
				parent.setMinWidth(WIDTH_EXPANDED_IMAGES);
				parent.setPrefWidth(WIDTH_EXPANDED_IMAGES);
			} else {
				parent.setMaxWidth(WIDTH_EXPANDED_1);
				parent.setMinWidth(WIDTH_EXPANDED_1);
				parent.setPrefWidth(WIDTH_EXPANDED_1);
			}

		} catch (Throwable ex) {
			RcplModel.logError(ex);
		}
	}

	/**
	 * To get a ToolBar for a perspective
	 * 
	 * @param perspective
	 * @param pluginId
	 * @return
	 */
	private String getKey(String perspective) {
		return "PERSPECTIVE_" + perspective;
	}

	/**
	 * To get a tool pane
	 * 
	 * @param perspective
	 * @param pluginId
	 * @param id
	 * @return
	 */
	private String getKey(String perspective, String groupId) {
		return "PERSPECTIVE_GROUP_ID_" + perspective + groupId;
	}

	private String getPerspectiveId() {
		return Rcpl.UIC.getPerspective().getId();
	}

	private AccordionColorTitlePane getTitlePane(ToolGroup group) {
		return titlePaneRegistry.get(group.getId());
	}

	private EList<ToolGroup> getToolGroups(Perspective perspective) {
		return perspective.getSideToolBar().getToolGroups();
	}

	private EList<Tool> getTools(Perspective perspective) {
		return perspective.getSideToolBar().getTools();
	}

	private boolean groupHasAccordionItems(ToolGroup toolGroup) {

		for (ToolGroup t : toolGroup.getToolGroups()) {
			if (t.getGroupType() == null || GroupType.ACCORDIONITEM.equals(t.getGroupType())) {
				return true;
			}
		}

		return false;
	}

}
