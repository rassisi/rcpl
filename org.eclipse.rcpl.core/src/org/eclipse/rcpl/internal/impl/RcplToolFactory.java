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
package org.eclipse.rcpl.internal.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.rcpl.EnServiceId;
import org.eclipse.rcpl.ITool;
import org.eclipse.rcpl.IToolFactory;
import org.eclipse.rcpl.IURLAddressTool;
import org.eclipse.rcpl.Rcpl;
import org.eclipse.rcpl.internal.fx.figures.RcplButton;
import org.eclipse.rcpl.internal.tools.CheckBoxTool;
import org.eclipse.rcpl.internal.tools.ComboBoxTool;
import org.eclipse.rcpl.internal.tools.DateTool;
import org.eclipse.rcpl.internal.tools.FontNameTool;
import org.eclipse.rcpl.internal.tools.FontSizeTool;
import org.eclipse.rcpl.internal.tools.GridPaneTool;
import org.eclipse.rcpl.internal.tools.JOFlowPaneTool;
import org.eclipse.rcpl.internal.tools.JOHtmlTool;
import org.eclipse.rcpl.internal.tools.JOHyperLinkTool;
import org.eclipse.rcpl.internal.tools.JOImageTool;
import org.eclipse.rcpl.internal.tools.JOListTool;
import org.eclipse.rcpl.internal.tools.JOMenuButtonTool;
import org.eclipse.rcpl.internal.tools.JOPasswordTool;
import org.eclipse.rcpl.internal.tools.JOProgressBarTool;
import org.eclipse.rcpl.internal.tools.JOProgressIndicatorTool;
import org.eclipse.rcpl.internal.tools.JORadioButtonTool;
import org.eclipse.rcpl.internal.tools.JOSeparatorTool;
import org.eclipse.rcpl.internal.tools.JOSliderTool;
import org.eclipse.rcpl.internal.tools.JOSplitMenuTool;
import org.eclipse.rcpl.internal.tools.JOTextAreaTool;
import org.eclipse.rcpl.internal.tools.JOTextFieldTool;
import org.eclipse.rcpl.internal.tools.JOWebBrowserTool;
import org.eclipse.rcpl.internal.tools.LabelTool;
import org.eclipse.rcpl.internal.tools.URLAddressTool;
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

	@Override
	public ITool createURLAddressTool(ToolGroup toolGroup) {
		IURLAddressTool iurl = new URLAddressTool(null);
		iurl.setToolGroup(toolGroup);
		return iurl;
	}

	@Override
	public ITool createTool(final Tool emfTool) {
		return createTool(emfTool, 0, 0);
	}

	@Override
	public ITool createTool(final Tool model, double width, double height) {

		ITool tool = null;
		String id = model.getId();

		if (id != null && !Tool.ids.contains(id)) {
			Tool.ids.add(id);
		}

		switch (model.getType()) {
		case NAVIGATOR:

			break;
		case BUTTON:
			tool = new RcplButton(model);
			tool.setBounds(0, 0, width, height);
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
			ComboBoxTool combo = new ComboBoxTool(model);
			((ComboBox<?>) combo.getNode()).setMinWidth(2);

			GridPane.setHgrow(combo.getNode(), Priority.ALWAYS);
			tool = combo;
			if (model.getFormat() != null) {

				try {
					Class<?> clazz = Class.forName(model.getFormat());
					if (clazz.isEnum()) {
						Object[] values = clazz.getEnumConstants();

						for (int i = 0; i < values.length; i++) {
							combo.getNode().getItems().add(values[i].toString());
						}
					}
				} catch (ClassNotFoundException e) {
					if (model.getFormat() != null) {
						List<String> list = new ArrayList<String>(Arrays.asList(model.getFormat().split(",")));

						List<String> list2 = new ArrayList<String>();
						int index = 0;
						int sel = -1;
						for (String string : list) {
							int pos = string.indexOf("{");
							if (pos != -1) {
								string = string.substring(0, pos);
								sel = index++;
							}
							list2.add(string);
						}
						combo.getNode().getItems().addAll(list2);
						combo.getNode().getSelectionModel().select(sel);
					}
				}

			}
			break;
		case DATEANDTIMEFIELD:
			tool = new DateTool(model);
			break;
		case DATEFIELD:
			tool = new DateTool(model);
			break;
		case PASSWORDFIELD:
			tool = new JOPasswordTool(model);
			break;
		case RADIOBUTTON:
			tool = new JORadioButtonTool(model);
			break;
		case SPLITMENUBUTTON:
			JOSplitMenuTool b = new JOSplitMenuTool(model);
			b.getNode().setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));

			String imName = model.getImage();
			if (imName != null) {
				Node im = Rcpl.resources().getImage(imName, 16, 16).getNode();
				if (im != null) {
					b.getNode().setGraphic(im);
				} else {

				}
			}
			b.getNode().setMaxHeight(18);
			tool = b;
			break;
		case TEXTFIELD:
			tool = new JOTextFieldTool(model);
			break;
		case TOGGLEBUTTON:
			tool = new RcplButton(model);
			((RcplButton) tool).setSelected(false);
			break;
		case CHOICEBOX:
			break;
		case COLOR_CHOOSER:
			break;
		case HTMLEDITOR:
			tool = new JOHtmlTool(model);
			break;
		case HYPERLINK:
			tool = new JOHyperLinkTool(model);
			break;
		case IMAGEVIEW:
			tool = new JOImageTool(model);
			break;
		case LABEL:
			tool = new LabelTool(model);
			break;
		case LISTVIEW:
			tool = new JOListTool(model);
			((ListView<?>) tool.getNode()).setMinWidth(2);
			break;
		case MENUBAR:
			tool = new JOMenuButtonTool(model);
			break;
		case MENUBUTTON:
			tool = new JOMenuButtonTool(model);
			break;
		case PROGRESSBAR:
			tool = new JOProgressBarTool(model);
			break;
		case PROGRESSINDICATOR:
			tool = new JOProgressIndicatorTool(model);
			break;
		case SEPARATOR_HORIZONTAL:
			tool = new JOSeparatorTool(model); // (Orientation.HORIZONTAL);
			break;
		case SEPARATOR_VERTICAL:
			tool = new JOSeparatorTool(model); // Orientation.VERTICAL);
			break;
		case SLIDER_HORIZONTAL:
			JOSliderTool sl = new JOSliderTool(model);
			sl.getNode().setOrientation(Orientation.HORIZONTAL);
			tool = sl;
			break;
		case SLIDER_VERTICAL:
			sl = new JOSliderTool(model);
			sl.getNode().setOrientation(Orientation.VERTICAL);
			tool = sl;
			break;
		case TEXTAREA:
			tool = new JOTextAreaTool(model);
			break;
		case WEBVIEW:
			tool = new JOWebBrowserTool(model);
			break;
		case GRIDPANE:
			tool = new GridPaneTool(model);
			break;
		case FLOWPANE:
			tool = new JOFlowPaneTool(model);
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

	private static double getWidth(Tool tool) {
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

}
