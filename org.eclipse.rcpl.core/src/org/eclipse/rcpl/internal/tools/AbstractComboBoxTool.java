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

import java.util.List;

import org.eclipse.rcpl.AbstractRcplTool;
import org.eclipse.rcpl.Rcpl;
import org.eclipse.rcpl.model_2_0_0.rcpl.Tool;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ComboBox;

/**
 * @author ramin
 *
 */
public abstract class AbstractComboBoxTool<T> extends AbstractRcplTool {

	private List<String> datas;

	private Class<?> enumClass;

	public AbstractComboBoxTool(Tool tool) {
		super(tool);
	}

	@Override
	public Tool getModel() {
		return (Tool) super.getModel();
	}

	@Override
	public ComboBox<T> createNode() {
		ComboBox<T> combo = new ComboBox<T>();
		return combo;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ComboBox<T> getNode() {
		return (ComboBox<T>) super.getNode();
	}

	public List<String> getDatas() {
		return datas;
	}

	@Override
	protected ChangeListener<T> createChangeListener() {
		ChangeListener<T> changeListener = new ChangeListener<T>() {
			@Override
			public void changed(ObservableValue<? extends T> observable, T oldValue, T newValue) {
				if (Rcpl.UIC().getEditor() != null) {
					execute(newValue);
				}
			}
		};
		return changeListener;
	}

}
