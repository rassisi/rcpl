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

import org.eclipse.rcpl.AbstractRcplTool;
import org.eclipse.rcpl.IFont;
import org.eclipse.rcpl.ILayoutObject;
import org.eclipse.rcpl.IParagraph;
import org.eclipse.rcpl.IStyle;
import org.eclipse.rcpl.Rcpl;
import org.eclipse.rcpl.model_2_0_0.rcpl.Tool;
import org.eclipse.rcpl.ui.listener.RcplEvent;

import javafx.scene.control.ComboBox;

public class FontSizeTool extends AbstractRcplTool<Double> {

	Double[] items = new Double[] { 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 10.0, 11.0, 12.0, 14.0, 16.0, 18.0, 20.0, 22.0,
			24.0, 26.0, 28.0, 36.0, 48.0, 72.0 };

	boolean enableEvents = true;

	public FontSizeTool(final Tool tool) {
		super(tool);
		getNode().getItems().addAll(items);
		getNode().setPrefWidth(65);
		initSelection();
		addListener();
	}

	private void initSelection() {
		if (Rcpl.globalStyleTemplate() != null) {
			IFont font = Rcpl.globalStyleTemplate().getDefaultStyle().getFont();
			getNode().getSelectionModel().select(font.getHeight());
			setFontSize(font.getHeight());
		}
	}

	public void setFontSize(double h) {
		removeListener();
		enableEvents = false;
		for (Double d : items) {
			if (d.doubleValue() >= h) {
				getNode().getSelectionModel().select(d);
				return;
			}
		}
		enableEvents = true;
	}

	public double getSize() {
		try {
			return getNode().getSelectionModel().getSelectedItem();
		} catch (Exception ex) {
			return 12;
		}
	}

	@Override
	public ComboBox<Double> createNode() {
		return new ComboBox<Double>();
	}

	@SuppressWarnings("unchecked")
	@Override
	public ComboBox<Double> getNode() {
		return (ComboBox<Double>) super.getNode();
	}

	@Override
	public boolean update(RcplEvent event) {
		ILayoutObject lo = event.getLayoutObject();
		if (lo instanceof IParagraph) {
			IParagraph p = (IParagraph) lo;
			IStyle style = p.findCharacterStyleAtOffset();
			removeListener();
			setFontSize(style.getFont().getHeight());
			addListener();
		}
		return true;
	}

}
