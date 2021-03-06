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

import org.apache.batik.transcoder.TranscoderException;
import org.eclipse.rcpl.AbstractRcplTool;
import org.eclipse.rcpl.EnCommandId;
import org.eclipse.rcpl.EnLatexMath;
import org.eclipse.rcpl.IButton;
import org.eclipse.rcpl.ILayoutObject;
import org.eclipse.rcpl.IParagraph;
import org.eclipse.rcpl.IResourceEntry;
import org.eclipse.rcpl.IToolComponent;
import org.eclipse.rcpl.IToolGroup;
import org.eclipse.rcpl.IToolRegistry;
import org.eclipse.rcpl.images.RcplImage;
import org.eclipse.rcpl.model.IImage;
import org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool;
import org.eclipse.rcpl.model_2_0_0.rcpl.RcplFactory;
import org.eclipse.rcpl.model_2_0_0.rcpl.ToolGroup;
import org.eclipse.rcpl.model_2_0_0.rcpl.ToolType;
import org.eclipse.rcpl.ui.controler.RcplUic;
import org.eclipse.rcpl.ui.listener.RcplEvent;

import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.text.TextAlignment;

/**
 * @author ramin
 *
 */
public class RcplButton extends AbstractRcplTool<Boolean> implements IButton {

	private Node imageNode;

	private double width = 16.0;

	private double height = 16.0;

	private IImage image;

	private boolean executeService = true;

	public boolean isToggle() {
		return ToolType.TOGGLEBUTTON.equals(getModel().getType()) || ToolType.RADIOBUTTON.equals(getModel().getType());
	}

	public RcplButton(String id) {
		super(RcplFactory.eINSTANCE.createTool());
		model.setId(id);
		model.setType(ToolType.BUTTON);
	}

	public RcplButton(AbstractTool tool) {
		super(tool);
		if (tool.getWidth() > 0 && tool.getHeight() > 0) {
			width = tool.getWidth();
			height = tool.getHeight();
		}
	}

	@Override
	public void fire() {
		execute(isSelected());
	}

	@Override
	protected void execute(Object data) {
		if (executeService) {
			super.execute(data);
		} else {
			doAction();
		}
		if (!(getModel() instanceof ToolGroup)) {
			RcplUic.activateCaret();
		}
	}

	@Override
	public void doAction() {

	}

	@Override
	public boolean isSelected() {
		if (isToggle()) {
			return ((Toggle) getNode()).isSelected();
		}
		return selected;
	}

	@Override
	public void setSelected(boolean selected) {
		if (isToggle()) {
			((Toggle) getNode()).setSelected(selected);
		}
		this.selected = selected;
	}

	protected String getNodeId() {
		return "toolButton";
	}

	@Override
	public ButtonBase createNode() {

		if (ToolType.TOGGLEBUTTON.equals(getModel().getType())) {
			node = new ToggleButton();
			((ToggleButton) node).setMinWidth(2);

		} else if (ToolType.RADIOBUTTON.equals(getModel().getType())) {
			node = new RadioButton();
			((RadioButton) node).setMinWidth(2);

		} else {
			node = new Button();
			((Button) node).setMinWidth(2);
		}
		((ButtonBase) node).setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				execute(isSelected());
			}
		});

		node.setId(getNodeId());

		if (!ToolType.RADIOBUTTON.equals(getModel().getType())) {
			if (model.getId() != null && !model.getId().equals(EnCommandId.PARAGRAPH_INSERTLATEX.name())) {
				createImage();
			}
		}

		((ButtonBase) node).setCenterShape(true);
		node.setUserData(this);

		if (getModel() != null) {
			getModel().setData(node);
		}

		if (!isImplemented()) {
			node.setDisable(true);

		}
		return (ButtonBase) node;
	}

	private void createImage() {
		
		TranscoderException ex = null;
		
		String imageName = getImageName();
		image = new RcplImage(imageName, getWidth(), getHeight());
		this.imageNode = image.getNode();
		((ButtonBase) node).setGraphic(imageNode);
	}

	@Override
	public void reset() {
		if (isToggle()) {
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
	public void doUpdate(RcplEvent event) {
		if (getModel() != null) {

			TextAlignment alignment = null;

			alignment = (TextAlignment) event.get(RcplEvent.KEY_TEXT_ALIGNMENT);

			String id = getModel().getId();
			if (id == null || "".equals(id)) {
				return;
			}
			if (!ToolType.TOGGLEBUTTON.equals(getModel().getType())
					&& !ToolType.RADIOBUTTON.equals(getModel().getType())) {
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
			case PAGE_LANDSCAPE:
				found = true;
				if (event.getLayoutObject().getPage() != null) {
					select = event.getLayoutObject().getPage().getSection().isLandscape();
				}
				break;
			case PAGE_PORTRAIT:
				found = true;
				if (event.getLayoutObject().getPage() != null) {
					select = !event.getLayoutObject().getPage().getSection().isLandscape();
				}
				break;
			case PARAGRAPH_ALIGNTEXTCENTER:
				found = true;
				select = TextAlignment.CENTER == alignment;
				break;
			case PARAGRAPH_ALIGNTEXTJUSTIFIED:
				select = TextAlignment.JUSTIFY == alignment;
				break;
			case PARAGRAPH_ALIGNTEXTLEFT:
				found = true;
				select = TextAlignment.LEFT == alignment;
				break;
			case PARAGRAPH_ALIGNTEXTRIGHT:
				found = true;
				select = TextAlignment.RIGHT == alignment;
				break;
			case COLOR_BACKGROUND:
				break;
			case PARAGRAPH_BOLD:
				found = true;
				select = isBold(event);
				break;
			case PARAGRAPH_ITALIC:
				found = true;
				select = isItalic(event);
				break;
			case PARAGRAPH_UNDERLINE:
				found = true;
				select = isUnderline(event);
				break;
			case PARAGRAPH_SUBSCRIPT:
				found = true;
				select = isSubScript(event);
				break;
			case PARAGRAPH_SUPERSCRIPT:
				found = true;
				select = isSuperScript(event);
				break;
			case PARAGRAPH_STRIKETHROUGH:
				found = true;
				select = isStrikeThrough(event);
				break;
			case PARAGRAPH_STYLENORMAL:
				found = true;
				select = isNormalStyle(event, cmd);
				break;
			case PARAGRAPH_STYLETITLE:
				found = true;
				select = isTitleStyle(event, cmd);
				break;
			case PARAGRAPH_STYLEHEADING1:
				found = true;
				select = isHeading1Style(event, cmd);
				break;
			case PARAGRAPH_STYLEHEADING2:
				found = true;
				select = isHeading2Style(event, cmd);
				break;
			case PARAGRAPH_STYLEHEADING3:
				found = true;
				select = isHeading3Style(event, cmd);
				break;
			case PARAGRAPH_STYLEHEADING4:
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
		ILayoutObject lo = event.getLayoutObject();
		if (lo == null || lo.getStyle() == null) {
			return false;
		}
		if (lo.getStyle().isUnderline()) {
			return true;
		}
		IStyle style = findSelectedStyle(event);
		return style != null && style.isUnderline();
	}

	private boolean isSubScript(RcplEvent event) {
		ILayoutObject lo = event.getLayoutObject();
		if (lo == null || lo.getStyle() == null) {
			return false;
		}
		if (lo.getStyle().isSubScript()) {
			return true;
		}
		IStyle style = findSelectedStyle(event);
		return style != null && style.isSubScript();
	}

	private boolean isSuperScript(RcplEvent event) {
		ILayoutObject lo = event.getLayoutObject();
		if (lo == null || lo.getStyle() == null) {
			return false;
		}
		if (lo.getStyle().isSuperScript()) {
			return true;
		}
		IStyle style = findSelectedStyle(event);
		return style != null && style.isSuperScript();
	}

	private boolean isStrikeThrough(RcplEvent event) {
		ILayoutObject lo = event.getLayoutObject();
		if (lo == null || lo.getStyle() == null) {
			return false;
		}
		if (lo.getStyle().isStrikeThrough()) {
			return true;
		}
		IStyle style = findSelectedStyle(event);
		return style != null && style.isUnderline();
	}

	@Override
	public IImage getImage() {
		return image;
	}

	@Override
	public void disableService() {
		executeService = false;
	}

	@Override
	public IButton setData(Object... data) {
		if (model != null && EnCommandId.PARAGRAPH_INSERTLATEX.name().equals(model.getId())) {
			EnLatexMath math = (EnLatexMath) data[2];
			getNode().setText(math.getText());
			getModel().setToolTip("Insert a " + math.getToolTip());
			createToolTip();
		}
		return (IButton) super.setData(data);
	}

	@Override
	protected ChangeListener<Boolean> createChangeListener() {
		return null;
	}

	@Override
	protected void doRemoveListener(ChangeListener<Boolean> changeListener) {
		setEnableAction(false);
	}

	@Override
	protected void doAddListener(ChangeListener<Boolean> changeListener) {
		setEnableAction(true);
	}

}
