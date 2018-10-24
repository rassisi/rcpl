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
import java.util.List;

import org.eclipse.rcpl.RcplTool;
import org.eclipse.rcpl.model_2_0_0.rcpl.Tool;
import org.eclipse.rcpl.util.RcplUtil;

import javafx.scene.control.ComboBox;

/**
 * @author ramin
 *
 */
public class ComboBoxTool extends RcplTool {

	List<String> datas;

	public ComboBoxTool(Tool tool) {
		super(tool);
		datas = new ArrayList<String>();

		if (getModel().getFormat() != null) {

			ComboBox<String> combo = getNode();
			try {
				Class<?> clazz = Class.forName(getModel().getFormat());
				if (clazz.isEnum()) {
					Object[] values = clazz.getEnumConstants();
					for (int i = 0; i < values.length; i++) {
						combo.getItems().add(values[i].toString());
						datas.add("");
					}
				}

			} catch (ClassNotFoundException e) {
				if (getModel().getFormat() != null) {

					// ---------- new format

					List<String> rawItems = RcplUtil
							.getListFromDelimiterSeparatedList(getModel().getFormatValue("entries"), ",");
					if (!rawItems.isEmpty()) {
						List<String> items = new ArrayList<String>();

						for (String rawItem : rawItems) {
							int pos = rawItem.indexOf("{");
							if (pos != -1) {
								String item = rawItem.substring(0, pos);
								String data = rawItem.substring(pos + 1, rawItem.length());
								if (data.endsWith("}")) {
									data = data.substring(0, data.length() - 1);
								}
								items.add(item);
								datas.add(data);
							} else {
								items.add(rawItem);
								datas.add("");
							}
						}
						combo.getItems().addAll(items);
						combo.getSelectionModel().select(getModel().getIntFormatValue("index"));
					}
				}
			}

		}
	}

	@Override
	public Tool getModel() {
		return (Tool) super.getModel();
	}

	@Override
	public ComboBox<String> createNode() {
		return new ComboBox<String>();
	}

	@SuppressWarnings("unchecked")
	@Override
	public ComboBox<String> getNode() {
		return (ComboBox<String>) super.getNode();
	}

	public List<String> getDatas() {
		return datas;
	}

}
