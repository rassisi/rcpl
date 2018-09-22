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
package org.eclipse.rcpl.internal.fx.figures;

import org.eclipse.rcpl.AlignType;
import org.eclipse.rcpl.EnCommandId;
import org.eclipse.rcpl.IAlignment;
import org.eclipse.rcpl.IButton;
import org.eclipse.rcpl.ICommand;
import org.eclipse.rcpl.ILayoutObject;
import org.eclipse.rcpl.IParagraph;
import org.eclipse.rcpl.IResourceEntry;
import org.eclipse.rcpl.IStyle;
import org.eclipse.rcpl.IToolComponent;
import org.eclipse.rcpl.IToolGroup;
import org.eclipse.rcpl.IToolRegistry;
import org.eclipse.rcpl.Rcpl;
import org.eclipse.rcpl.RcplTool;
import org.eclipse.rcpl.model.IImage;
import org.eclipse.rcpl.model.RcplModel;
import org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool;
import org.eclipse.rcpl.model_2_0_0.rcpl.RcplFactory;
import org.eclipse.rcpl.model_2_0_0.rcpl.ToolType;
import org.eclipse.rcpl.ui.listener.RcplEvent;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Tooltip;

/**
 * @author ramin
 *
 */
public class RcplButton extends RcplTool<Boolean> implements IButton {

	private Node imageNode;

	private double width = 16.0;

	private double height = 16.0;

	private IImage image;

	private boolean executeService = true;

	public boolean isToggle() {
		return ToolType.TOGGLEBUTTON.equals(getTool().getType());
	}

	public RcplButton(String id) {
		super(RcplFactory.eINSTANCE.createTool());
		tool.setId(id);
		tool.setType(ToolType.BUTTON);
	}

	public RcplButton(AbstractTool tool) {
		super(tool);
		if (tool.getWidth() > 0 && tool.getHeight() > 0) {
			width = tool.getWidth();
			height = tool.getHeight();
		}
	}

	private void performAction() {
		if (executeService) {
			try {
				getTool().setData(RcplButton.this);
				ICommand command = Rcpl.getFactory().createCommand(RcplButton.this);
				Rcpl.service().execute(command);
			} catch (Throwable ex) {
				RcplModel.logError(ex);
			}
		} else {
			doAction();
		}

	}

	@Override
	public void doAction() {

	}

	public boolean isSelected() {
		if (isToggle()) {
			return ((ToggleButton) getNode()).isSelected();
		}
		return selected;
	}

	@Override
	public void setSelected(boolean selected) {
		if (isToggle()) {
			((ToggleButton) getNode()).setSelected(selected);
		}
		this.selected = selected;
	}

	@Override
	public ButtonBase createNode() {

		if (isToggle()) {
			node = new ToggleButton();
			((ToggleButton) node).setMinWidth(2);

		} else {
			node = new Button();
			((Button) node).setMinWidth(2);
			((ButtonBase) node).setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					performAction();
				}
			});
		}

		String imageName = getTool().getImage();
		if (imageName == null) {
			imageName = getTool().getId();
		}

		node.setId("toolButton");
		image = Rcpl.resources().getImage(imageName,

				getWidth(), getHeight());

		this.imageNode = image.getNode();

		String toolTip = getTool().getToolTip();
		if (toolTip == null) {
			toolTip = getTool().getName();
		}

		if (toolTip == null) {
			toolTip = getTool().getId();
		}
		final String tt = toolTip;
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				Tooltip t = new Tooltip(tt);
				Tooltip.install(node, t);
				t.getStyleClass().add("ttip");
			}
		});

		((ButtonBase) node).setGraphic(imageNode);
		((ButtonBase) node).setCenterShape(true);
		node.setUserData(this);

		if (getTool() != null) {
			getTool().setData(node);
		}

		return (ButtonBase) node;
	}

	public void reset() {
		if (node instanceof ToggleButton) {
			setSelected(false);
		}
	}

	@Override
	public IToolRegistry getToolRegistry() {
		return null;
	}

	@Override
	public IResourceEntry getEntry() {
		return null;
	}

	@Override
	public IToolComponent getToolComponent() {
		return null;
	}

	@Override
	public IToolGroup getGroup() {
		return null;
	}

	@Override
	public void setBounds(double x, double y, double Width, double height) {
		setWidth(Width);
		setHeight(height);
	}

	@Override
	public void setVisible(boolean visible) {
		getNode().setVisible(visible);

	}

	@Override
	public void setDisable(boolean disable) {
		getNode().setDisable(disable);
	}

	public Node getWebView() {
		return imageNode;
	}

	@Override
	public void setWidth(double width) {
		this.width = width;
	}

	@Override
	public void setHeight(double height) {
		this.height = height;
	}

	public double getWidth() {
		if (width == 0) {
			width = 16;
		}
		return width;
	}

	public double getHeight() {
		if (height == 0) {
			height = 16;
		}
		return height;
	}

	@Override
	public ButtonBase getNode() {
		return (ButtonBase) super.getNode();
	}

	@Override
	public void update(RcplEvent event) {
		if (getTool() != null) {

			String id = getTool().getId();
			if (id == null || "".equals(id)) {
				return;
			}
			if (!ToolType.TOGGLEBUTTON.equals(getTool().getType())) {
				return;
			}

			EnCommandId cmd;
			try {
				cmd = EnCommandId.valueOf(id);
			} catch (IllegalArgumentException ex) {
				// There is no value for this id
				return;
			}
			boolean select = false;
			boolean found = false;
			switch (cmd) {
			case align_text_center:
				found = true;
				select = isAlign(event, AlignType.CENTER);
				break;
			case align_text_justify:
				select = isAlign(event, AlignType.BOTH);
				break;
			case align_text_left:
				found = true;
				select = isAlign(event, AlignType.LEFT);
				break;
			case align_text_right:
				found = true;
				select = isAlign(event, AlignType.RIGHT);
				break;
			case backgroundColor:
				break;
			case bold:
				found = true;
				select = isBold(event);
				break;
			case italic:
				found = true;
				select = isItalic(event);
				break;
			case underline:
				found = true;
				select = isUnderline(event);
				break;
			case style_normal:
				found = true;
				select = isNormalStyle(event, cmd);
				break;
			case style_title:
				found = true;
				select = isTitleStyle(event, cmd);
				break;
			case style_heading_1:
				found = true;
				select = isHeading1Style(event, cmd);
				break;
			case style_heading_2:
				found = true;
				select = isHeading2Style(event, cmd);
				break;
			case style_heading_3:
				found = true;
				select = isHeading3Style(event, cmd);
				break;
			case style_heading_4:
				found = true;
				select = isHeading4Style(event, cmd);
				break;
			default:
				break;

			}
			if (found) {
				setSelected(select);
			}

		}

	}

	private boolean isNormalStyle(RcplEvent event, EnCommandId cmd) {
		IStyle style = findSelectedStyle(event);
		if (style != null) {
			String styleName = style.getName();
			return "Standard".equals(styleName) || "Normal".equals(styleName);

		}
		return false;
	}

	private boolean isTitleStyle(RcplEvent event, EnCommandId cmd) {
		IStyle style = findSelectedStyle(event);
		if (style != null) {
			String styleName = style.getName();
			return "Title".equals(styleName);

		}
		return false;
	}

	private boolean isHeading1Style(RcplEvent event, EnCommandId cmd) {
		IStyle style = findSelectedStyle(event);
		if (style != null) {
			String styleName = style.getName();
			return "heading 1".equals(styleName);

		}
		return false;
	}

	private boolean isHeading2Style(RcplEvent event, EnCommandId cmd) {
		IStyle style = findSelectedStyle(event);
		if (style != null) {
			String styleName = style.getName();
			return "heading 2".equals(styleName);

		}
		return false;
	}

	private boolean isHeading3Style(RcplEvent event, EnCommandId cmd) {
		IStyle style = findSelectedStyle(event);
		if (style != null) {
			String styleName = style.getName();
			return "heading 3".equals(styleName);

		}
		return false;
	}

	private boolean isHeading4Style(RcplEvent event, EnCommandId cmd) {
		IStyle style = findSelectedStyle(event);
		if (style != null) {
			String styleName = style.getName();
			return "heading 4".equals(styleName);

		}
		return false;
	}

	private IStyle findSelectedStyle(RcplEvent event) {
		ILayoutObject lo = event.getLayoutObject();
		if (lo instanceof IParagraph) {
			IParagraph p = (IParagraph) lo;
			return p.findCharacterStyleAtOffset();
		}
		return null;
	}

	private boolean isBold(RcplEvent event) {
		IStyle style = findSelectedStyle(event);
		return style != null && style.isBold();
	}

	private boolean isItalic(RcplEvent event) {
		IStyle style = findSelectedStyle(event);
		return style != null && style.isItalic();
	}

	private boolean isUnderline(RcplEvent event) {
		IStyle style = findSelectedStyle(event);
		return style != null && style.isUnderline();
	}

	private boolean isAlign(RcplEvent event, AlignType type) {
		ILayoutObject lo = event.getLayoutObject();
		if (lo instanceof IParagraph) {
			IParagraph p = (IParagraph) lo;
			IAlignment al = p.getAlignment();
			if (al != null) {
				return al.getType().equals(type);
			}
		}
		return false;
	}

	@Override
	public IImage getImage() {
		return image;
	}

	@Override
	public void disableService() {
		executeService = false;
	}

}
