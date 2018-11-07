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

package org.eclipse.rcpl.internal.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.rcpl.AbstractRcplTool;
import org.eclipse.rcpl.IButton;
import org.eclipse.rcpl.ITool;
import org.eclipse.rcpl.Rcpl;
import org.eclipse.rcpl.internal.factory.impl.RcplToolFactory;
import org.eclipse.rcpl.internal.fx.figures.RcplButton;
import org.eclipse.rcpl.model.EnKeyValue;
import org.eclipse.rcpl.model.RcplModel;
import org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool;
import org.eclipse.rcpl.model_2_0_0.rcpl.RcplFactory;
import org.eclipse.rcpl.model_2_0_0.rcpl.Tool;
import org.eclipse.rcpl.model_2_0_0.rcpl.ToolGroup;
import org.eclipse.rcpl.model_2_0_0.rcpl.ToolType;
import org.eclipse.rcpl.ui.listener.RcplEvent;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.Control;
import javafx.scene.control.Labeled;
import javafx.scene.control.Separator;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 * @author Ramin
 * 
 */
public class RibbonGroup extends AbstractRcplTool {

	private GridPane mainGridPane;

//	protected ToolGroup toolGroup;

	protected HashMap<AbstractTool, ITool> registry = new HashMap<AbstractTool, ITool>();

	// public JOTool(String id, String name, String toolTip, String imageName,
	// boolean toggle) {

	private static List<RcplButton> dialogButtons = new ArrayList<RcplButton>();

	/**
	 * Default Constructor.
	 */
	public RibbonGroup(final ToolGroup toolGroup, boolean first, boolean isDialogButton) {
		super(toolGroup);

		// ---------- Main VBox Container

		getNode().setMaxHeight(80);
		getNode().setPrefHeight(80);
		getNode().setMinHeight(80);
		getNode().setPickOnBounds(false);
		getNode().setAlignment(Pos.CENTER);
		if (toolGroup.getWidth() > 0) {
			getNode().setPrefWidth(toolGroup.getWidth());
			getNode().setMaxWidth(toolGroup.getWidth());
			HBox.setHgrow(getNode(), Priority.SOMETIMES);
		} else {
			HBox.setHgrow(getNode(), Priority.NEVER);
		}

		DropShadow dropShadow = new DropShadow(3, Color.GRAY);
		dropShadow.setOffsetX(1.0);
		dropShadow.setOffsetY(1.0);
		getNode().setEffect(dropShadow);
		getNode().getStyleClass().add("toolbarContainer");

		// ---------- GridPane

		this.mainGridPane = new GridPane();
		mainGridPane.setPickOnBounds(false);
		this.mainGridPane.setId("clipboard");
		this.mainGridPane.setGridLinesVisible(false);
		this.mainGridPane.setVgap(5);
		this.mainGridPane.setHgap(5);

		if (!toolGroup.isHGrow()) {
			HBox.setHgrow(mainGridPane, Priority.NEVER);
		}

		VBox.setVgrow(mainGridPane, Priority.ALWAYS);

		// ---------- label ---------------------------------

		InnerShadow is = new InnerShadow();
		is.setOffsetX(4.0f);
		is.setOffsetY(4.0f);
		Text label = new Text();
		label.setTextAlignment(TextAlignment.CENTER);
		label.setEffect(is);
		label.setId("ribbonLabel");
		label.setText(toolGroup.getName());
		label.setFill(Color.LIGHTGRAY);
		label.setFont(javafx.scene.text.Font.font("Arial", FontWeight.BOLD, 12));
		label.setOpacity(0.7);
		HBox.setHgrow(label, Priority.NEVER);

		// ---------- grid container

		StackPane bottomStackPane = new StackPane();
		bottomStackPane.setAlignment(Pos.CENTER);
		bottomStackPane.setPickOnBounds(false);
		VBox.setVgrow(bottomStackPane, Priority.NEVER);
		bottomStackPane.setMinHeight(20);
		bottomStackPane.setPrefHeight(20);
		bottomStackPane.setMaxHeight(20);
		bottomStackPane.getChildren().add(label);

		// ---------- Dialog Button ---------------------------

		Tool t = RcplFactory.eINSTANCE.createTool();
		t.setId("showSideBar");
		t.setImage("dialog_button");
		t.setType(ToolType.TOGGLEBUTTON);
		if (isDialogButton) {
			RcplButton dialogButton = new RcplButton(t) {
				@Override
				public void doAction() {
					for (RcplButton b2 : dialogButtons) {
						if (b2 != this) {
							b2.reset();
						}
					}
					if (isSelected()) {
						ToolGroup tg = (ToolGroup) RibbonGroup.this.getModel();
						Rcpl.UIC().getSideToolBarControl().expand(tg.getExpandToolGroup()); // toolGroup.getSideToolbarPath());
					} else {
						Rcpl.UIC().getSideToolBarControl().collapseToolPane();
						Rcpl.set(Rcpl.UIC().getEditor(), EnKeyValue.SIDEBAR_PATH, (String) null);
					}
				};
			};
			dialogButtons.add(dialogButton);
			dialogButton.disableService();
			dialogButton.setWidth(10);
			dialogButton.setHeight(10);
			dialogButton.getNode().setPrefSize(10, 10);
			dialogButton.getNode().setMaxSize(10, 10);
			dialogButton.getNode().setId("dialogButton");
			StackPane.setAlignment(dialogButton.getNode(), Pos.CENTER_RIGHT);
			bottomStackPane.getChildren().add(dialogButton.getNode()); // , 1, 0);
		}

		VBox.setMargin(mainGridPane, new Insets(2, 2, 0, 2));
		VBox.setMargin(bottomStackPane, new Insets(0, 0, 0, 0));
		getNode().getChildren().addAll(mainGridPane, bottomStackPane);

		processRibbonGroup();

		if (!toolGroup.isHGrow()) {
			getNode().setMinWidth(2);
			mainGridPane.setMinWidth(2);
		}
	}

	/**
	 * 
	 */
	protected int processRibbonGroup() {
		try {

			if (getModel() == null) {
				Tool tool = RcplFactory.eINSTANCE.createTool();
				tool.setId("error");
				IButton b = Rcpl.get().getFactory().createButton(tool);
				add(b.getNode(), 0, 0);
				return 0;
			}

			for (ToolGroup g : getModel().getToolGroups()) {
				processSubGroup(g);
			}

			int lastX = 0;
			ToggleGroup toggleGroup = new ToggleGroup();

			if ("paragraph_styles".equals(getModel().getId())) {
				System.out.println();
			}

			for (Tool toolModel : getModel().getTools()) {
				ITool tool;
				int spanX = Math.max(1, toolModel.getSpanX());
				int spanY = Math.max(1, toolModel.getSpanY());
				String imageName = toolModel.getImage();
				Node node;

				if (ToolType.BUTTON.equals(toolModel.getType()) && "undo".equals(toolModel.getFormat())) {
					node = RcplToolFactory.getUndoRedoTool().getUndoButton();
				} else if (ToolType.BUTTON.equals(toolModel.getType()) && "redo".equals(toolModel.getFormat())) {
					node = RcplToolFactory.getUndoRedoTool().getRedoButton();
				} else if (ToolType.COMBO.equals(toolModel.getType()) && "undo".equals(toolModel.getFormat())) {
					node = RcplToolFactory.getUndoRedoTool().getUndoCombo();
				} else if (ToolType.COMBO.equals(toolModel.getType()) && "redo".equals(toolModel.getFormat())) {
					node = RcplToolFactory.getUndoRedoTool().getRedoCombo();
				} else {
					tool = Rcpl.get().getToolFactory().createTool(toolModel);
					if (tool instanceof IButton) {
						if (ToolType.TOGGLEBUTTON.equals(toolModel.getType()) && toolModel.isToggleGroup()) {
							toggleGroup.getToggles().add(((ToggleButton) tool.getNode()));
						}
					}
					registry.put(toolModel, tool);

					if (tool instanceof Labeled) {
						Node image = Rcpl.get().resources().getImage(imageName, 16, 16).getNode();
						if (image != null) {
							((Labeled) tool).setGraphic(image);
						}
					}
					lastX = toolModel.getGridX();
					node = tool.getNode();
				}
				if (toolModel.getWidth() > 0) {
					if (node instanceof Control) {
						((Control) node).setPrefWidth(toolModel.getWidth());
					}
				}
				GridPane.setValignment(node, VPos.CENTER);

				if (toolModel.getWidth() > 0) {
//					GridPane.setMargin(node, new Insets(0, 5, 0, 5));
					((Control) node).setPrefWidth(toolModel.getWidth() + 10);
				}
				add(node, toolModel.getGridX(), toolModel.getGridY(), spanX, spanY);
			}
			return lastX;
		} catch (Throwable ex) {
			RcplModel.logError(ex);
			return 0;
		}
	}

	@Override
	public ToolGroup getModel() {
		return (ToolGroup) super.getModel();
	}

	/**
	 * @param t
	 */
	private void processSubGroup(ToolGroup t) {
		HBox hBox = new HBox();
		hBox.setId("ribbonSubGroup");
		hBox.setPickOnBounds(false);

		int spanX = Math.max(1, t.getSpanX());
		int spanY = Math.max(1, t.getSpanY());
		int gridX = t.getGridX();
		int gridY = t.getGridY();
		add(hBox, gridX, gridY, spanX, spanY);
		ToggleGroup toggleGroup = new ToggleGroup();

		for (Tool t2 : t.getTools()) {
			Node n = Rcpl.get().getToolFactory().createTool(t2).getNode();

			if (n instanceof IButton) {
				if (ToolType.TOGGLEBUTTON.equals(t2.getType()) && t2.isToggleGroup()) {
					toggleGroup.getToggles().add(((ToggleButton) n));
				}
			}

			// String name = t2.getName();
			String imageName = t2.getImage();
			if (imageName != null) {
				Node image = Rcpl.get().resources().getImage(imageName, 16, 16).getNode();
				if (image == null) {
					image = Rcpl.get().resources().getImage("close", 16, 16).getNode();
				}
				if (image != null) {
					if (n instanceof Labeled) {
						((Labeled) n).setGraphic(image);
						if (n instanceof SplitMenuButton) {
							((ButtonBase) n).setPrefHeight(18);
							((ButtonBase) n).setMinHeight(18);
							((ButtonBase) n).setMaxHeight(18);
						} else if (n instanceof ButtonBase) {
							((ButtonBase) n).setPrefSize(18, 18);
							((ButtonBase) n).setMinSize(18, 18);
							((ButtonBase) n).setMaxSize(18, 18);
						}
					}
				}
			}
			HBox.setMargin(n, new Insets(0));
			hBox.getChildren().add(n);
			Separator s = new Separator();
			s.setId("ribbonSubGroupSeparator");
			s.setOrientation(Orientation.VERTICAL);
			s.setMaxWidth(2);
			s.setPrefWidth(2);
			s.setMinWidth(2);
			s.setMinHeight(16);
			s.setPrefHeight(16);
			s.setMaxHeight(16);
			hBox.getChildren().add(s);
		}
	}

	/**
	 * get. Returns the instance of the HBox which contains the mainGridPane of the
	 * clipboard region.
	 * 
	 * @return
	 */
	public VBox get() {
		return getNode();
	}

	public void add(Node node, int col, int row) {
		this.mainGridPane.add(node, col, row);
	}

	public void add(Node node, int col, int row, int colSpan, int rowSpan) {
		this.mainGridPane.add(node, col, row, colSpan, rowSpan);
	}

	protected void updateToolGroup(RcplEvent event) {

		try {
			String id = getModel().getId();

			if ("topBar/font".equals(id)) {

				for (ToolGroup g : getModel().getToolGroups()) {

					try {
						id = g.getId();
						if ("characterStyle".equals(id)) {
							for (Tool tool : g.getTools()) {
								id = tool.getId();

								if ("bold".equals(id)) {
									ITool n = registry.get(tool);
									if (n instanceof IButton) {
										((IButton) n).setSelected(event.getStyle().isBold());
									}
								}

								if ("italic".equals(id)) {
									RcplButton n = (RcplButton) registry.get(tool);
									if (n != null) {
										n.setSelected(event.getStyle().isItalic());
									}
								}
							}
						}
					} catch (Exception ex) {
						RcplModel.logError(ex);
					}

				}

			}

		} catch (Exception ex) {
			// TODO

		}

	}

	@Override
	public VBox getNode() {
		return (VBox) super.getNode();
	}

	@Override
	public Node createNode() {
		return new VBox();
	}

}