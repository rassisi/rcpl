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

import org.eclipse.rcpl.AbstractRcplTool;
import org.eclipse.rcpl.Rcpl;
import org.eclipse.rcpl.model_2_0_0.rcpl.Tool;
import org.eclipse.rcpl.ui.listener.RcplEvent;
import org.eclipse.rcpl.util.RcplUtil;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;

/**
 * @author ramin
 *
 */
public class ComboBoxTool extends AbstractRcplTool<String> {

	private List<String> datas;

	private Class<?> enumClass;

	public ComboBoxTool(Tool tool) {
		super(tool);
		datas = new ArrayList<String>();

		if (getModel().getFormat() != null) {

			ComboBox<String> combo = getNode();

//			combo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
//
//				@Override
//				public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//					execute(newValue);
//				}
//			});
//			combo.valueProperty().addListener(new ChangeListener<String>() {
//				@Override
//				public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//					execute(newValue);
//				}
//
//			});

			try {
				Class<?> clazz = Class.forName(getModel().getFormat());
				if (clazz.isEnum()) {
					enumClass = clazz;
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
	public ComboBox<String> getNode() {
		return (ComboBox<String>) super.getNode();
	}

	@Override
	public void doUpdate(RcplEvent event) {
		if (getModel() != null) {
			String className = getModel().getFormat();
			if (className != null) {
				if (enumClass != null) {
					if (enumClass.getName().equals(className)) {
						String id = getModel().getId();

						if (id != null) {
							Object o = event.get(id);
							if (o != null) {
								String v = o.toString();
								getNode().getSelectionModel().select(v);
							}
						}
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
		ComboBox<String> combo = new ComboBox<String>();
		return combo;
	}

	public List<String> getDatas() {
		return datas;
	}

	@Override
	protected void doRemoveListener(ChangeListener<String> changeListener) {
		getNode().valueProperty().removeListener(changeListener);
	}

	@Override
	protected ChangeListener<String> createChangeListener() {
		ChangeListener<String> changeListener = new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (Rcpl.UIC().getEditor() != null) {
					execute(newValue);
				}
			}
		};
		return changeListener;
	}

	@Override
	protected void doAddListener(ChangeListener<String> changeListener) {
		getNode().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				execute(getNode().getSelectionModel().getSelectedItem());
			}
		});
		getNode().valueProperty().addListener(changeListener);
	}

}
