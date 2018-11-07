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
package org.eclipse.rcpl.internal.factory.impl;

import org.eclipse.rcpl.EnServiceId;
import org.eclipse.rcpl.ITool;
import org.eclipse.rcpl.IToolFactory;
import org.eclipse.rcpl.IURLAddressTool;
import org.eclipse.rcpl.Rcpl;
import org.eclipse.rcpl.internal.fx.figures.RcplButton;
import org.eclipse.rcpl.internal.tools.CheckBoxTool;
import org.eclipse.rcpl.internal.tools.ColorTool;
import org.eclipse.rcpl.internal.tools.ComboBoxTool;
import org.eclipse.rcpl.internal.tools.DateTool;
import org.eclipse.rcpl.internal.tools.FlowPaneTool;
import org.eclipse.rcpl.internal.tools.FontNameTool;
import org.eclipse.rcpl.internal.tools.FontSizeTool;
import org.eclipse.rcpl.internal.tools.GridPaneTool;
import org.eclipse.rcpl.internal.tools.HtmlTool;
import org.eclipse.rcpl.internal.tools.HyperLinkTool;
import org.eclipse.rcpl.internal.tools.ImageTool;
import org.eclipse.rcpl.internal.tools.LabelTool;
import org.eclipse.rcpl.internal.tools.LineArrowsTool;
import org.eclipse.rcpl.internal.tools.LineDashesTool;
import org.eclipse.rcpl.internal.tools.LineWidthTool;
import org.eclipse.rcpl.internal.tools.ListTool;
import org.eclipse.rcpl.internal.tools.MenuButtonTool;
import org.eclipse.rcpl.internal.tools.PasswordTool;
import org.eclipse.rcpl.internal.tools.PatternTool;
import org.eclipse.rcpl.internal.tools.ProgressBarTool;
import org.eclipse.rcpl.internal.tools.ProgressIndicatorTool;
import org.eclipse.rcpl.internal.tools.RadioButtonTool;
import org.eclipse.rcpl.internal.tools.SeparatorTool;
import org.eclipse.rcpl.internal.tools.SliderTool;
import org.eclipse.rcpl.internal.tools.SplitMenuTool;
import org.eclipse.rcpl.internal.tools.TextAreaTool;
import org.eclipse.rcpl.internal.tools.TextFieldTool;
import org.eclipse.rcpl.internal.tools.URLAddressTool;
import org.eclipse.rcpl.internal.tools.UndoRedoTool;
import org.eclipse.rcpl.internal.tools.WebBrowserTool;
import org.eclipse.rcpl.model_2_0_0.rcpl.Tool;
import org.eclipse.rcpl.model_2_0_0.rcpl.ToolGroup;

import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.ListView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;

public class RcplToolFactory implements IToolFactory {

	public static UndoRedoTool undoRedoTool;

	public static UndoRedoTool getUndoRedoTool() {
		if (undoRedoTool == null) {
			undoRedoTool = new UndoRedoTool();
		}
		return undoRedoTool;
	}

	public ITool createURLAddressTool(ToolGroup toolGroup) {
		IURLAddressTool iurl = new URLAddressTool(null);
		iurl.setToolGroup(toolGroup);
		return iurl;
	}

	@Override
	public ITool createTool(final Tool model, Object... data) {

		ITool tool = null;
		String id = model.getId();

		if (id != null && !Tool.ids.contains(id)) {
			Tool.ids.add(id);
		}

		switch (model.getType()) {

		case COLOR_CHOOSER:
			tool = new ColorTool(model);
			break;
		case LINE_WIDTH:
			tool = new LineWidthTool(model);
			break;
		case LINE_DASHES:
			tool = new LineDashesTool(model);
			break;
		case LINE_ARROWS:
			tool = new LineArrowsTool(model);
			break;
		case PATTERN:
			tool = new PatternTool(model);
			break;
		case NAVIGATOR:
			break;
		case BUTTON:
			tool = new RcplButton(model);
			tool.setBounds(0, 0, model.getWidth(), model.getHeight());
			break;
		case CHECKBOX:
			tool = new CheckBoxTool(model);
			model.setLabeled(true);
			break;
		case COMBO:

			if ("fontName".equals(model.getFormat())) {
				tool = new FontNameTool(model);
				model.setService(EnServiceId.PARAGRAPH_SERVICE.name());
				GridPane.setHgrow(tool.getNode(), Priority.ALWAYS);
				break;
			}

			if ("fontSize".equals(model.getFormat())) {
				tool = new FontSizeTool(model);
				model.setService(EnServiceId.PARAGRAPH_SERVICE.name());
				GridPane.setHgrow(tool.getNode(), Priority.ALWAYS);
				break;
			}

			ComboBoxTool comboTool = new ComboBoxTool(model);
			ComboBox<String> combo = comboTool.getNode();
			combo.setMinWidth(2);
			GridPane.setHgrow(combo, Priority.ALWAYS);
			tool = comboTool;
			break;
		case DATEANDTIMEFIELD:
			tool = new DateTool(model);
			break;
		case DATEFIELD:
			tool = new DateTool(model);
			break;
		case PASSWORDFIELD:
			tool = new PasswordTool(model);
			break;
		case RADIOBUTTON:
			tool = new RadioButtonTool(model);
			break;
		case SPLITMENUBUTTON:
			SplitMenuTool b = new SplitMenuTool(model);
			b.getNode().setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));

			String imName = model.getImage();
			if (imName != null) {
				Node im = Rcpl.get().resources().getImage(imName, 16, 16).getNode();
				if (im != null) {
					b.getNode().setGraphic(im);
				} else {

				}
			}
			b.getNode().setMaxHeight(18);
			tool = b;
			break;
		case TEXTFIELD:
			tool = new TextFieldTool(model);
			break;
		case TOGGLEBUTTON:
			tool = new RcplButton(model);
			((RcplButton) tool).setSelected(false);
			break;
		case CHOICEBOX:
			break;

		case HTMLEDITOR:
			tool = new HtmlTool(model);
			break;
		case HYPERLINK:
			tool = new HyperLinkTool(model);
			break;
		case IMAGEVIEW:
			tool = new ImageTool(model);
			break;
		case LABEL:
			tool = new LabelTool(model);
			break;
		case LISTVIEW:
			tool = new ListTool(model);
			((ListView<?>) tool.getNode()).setMinWidth(2);
			break;
		case MENUBAR:
			tool = new MenuButtonTool(model);
			break;
		case MENUBUTTON:
			tool = new MenuButtonTool(model);
			break;
		case PROGRESSBAR:
			tool = new ProgressBarTool(model);
			break;
		case PROGRESSINDICATOR:
			tool = new ProgressIndicatorTool(model);
			break;
		case SEPARATOR_HORIZONTAL:
			tool = new SeparatorTool(model); // (Orientation.HORIZONTAL);
			break;
		case SEPARATOR_VERTICAL:
			tool = new SeparatorTool(model); // Orientation.VERTICAL);
			break;
		case SLIDER_HORIZONTAL:
			SliderTool sl = new SliderTool(model);
			sl.getNode().setOrientation(Orientation.HORIZONTAL);
			tool = sl;
			break;
		case SLIDER_VERTICAL:
			sl = new SliderTool(model);
			sl.getNode().setOrientation(Orientation.VERTICAL);
			tool = sl;
			break;
		case TEXTAREA:
			tool = new TextAreaTool(model);
			break;
		case WEBVIEW:
			tool = new WebBrowserTool(model);
			break;
		case GRIDPANE:
			tool = new GridPaneTool(model);
			break;
		case FLOWPANE:
			tool = new FlowPaneTool(model);
			break;
		default:
			break;

		}

		if (tool.getNode() instanceof Control) {
			((Control) tool.getNode()).setMinWidth(2);
			double w = getWidth(model);
			if (w > 0) {
				((Control) tool.getNode()).setMaxWidth(w);
			}
		}
		if (tool != null) {
			tool.getNode().setUserData(model);
		}
		return tool;
	}

	protected double getWidth(Tool tool) {
		try {
			String format = tool.getFormat();
			if (format != null) {
				String[] splits = format.split(",");
				for (String tok : splits) {
					if (tok.startsWith("w=")) {
						return Integer.valueOf(tok.substring(2));
					}
				}

			}
		} catch (Exception ex) {
			// TODO
		}
		return -1;
	}

	protected void updateNode(Tool model, ITool tool) {
		if (tool != null) {
			GridPane.setHgrow(tool.getNode(), Priority.ALWAYS);
			if (tool.getNode() instanceof Control) {
				double width = getWidth(model);
				if (width > 0) {
					((Control) tool.getNode()).setMaxWidth(width);
				}
			}
			tool.getNode().setUserData(model);
		}
	}

}
