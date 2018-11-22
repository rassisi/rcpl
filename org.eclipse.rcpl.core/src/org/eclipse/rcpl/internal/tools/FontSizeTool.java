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
import org.eclipse.rcpl.Rcpl;
import org.eclipse.rcpl.model_2_0_0.rcpl.Tool;
import org.eclipse.rcpl.ui.listener.RcplEvent;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ComboBox;
import javafx.util.StringConverter;

/**
 * @author Ramin
 *
 */
public class FontSizeTool extends AbstractRcplTool<Double> {

	Double[] items = new Double[] { 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 10.0, 11.0, 12.0, 14.0, 16.0, 18.0, 20.0, 22.0,
			24.0, 26.0, 28.0, 36.0, 48.0, 72.0 };

	boolean enableEvents = true;

	public FontSizeTool(final Tool tool) {
		super(tool);
		getNode().getItems().addAll(items);
		getNode().setPrefWidth(65);
		initSelection();
	}

	private void initSelection() {
		if (Rcpl.get().globalStyleTemplate() != null) {
			IFont font = Rcpl.get().globalStyleTemplate().getDefaultStyle().getFont();
			getNode().getSelectionModel().select(font.getHeight());
			setFontSize(font.getHeight());
		}
	}

	public void setFontSize(double h) {
		for (Double d : items) {
			if (d.doubleValue() >= h) {
				getNode().getSelectionModel().select(d);
				return;
			}
		}
	}

	public double getSize() {
		try {
			return getNode().getSelectionModel().getSelectedItem().doubleValue();
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
		ComboBox<Double> combo = (ComboBox<Double>) super.getNode();
		combo.setEditable(true);
		combo.setConverter(new StringConverter<Double>() {
			@Override
			public String toString(Double obj) {
				return obj.toString();
			}

			@Override
			public Double fromString(String obj) {
				try {
					return Double.valueOf(obj);
				} catch (Exception ex) {
					return 11.0;
				}
			}
		});
		return combo;
	}

	@Override
	public void doUpdate(RcplEvent event) {
		ILayoutObject lo = event.getLayoutObject();
		if (lo instanceof IParagraph) {
			IParagraph p = (IParagraph) lo;
			IStyle style = p.findCharacterStyleAtOffset();
			if (style == null) {
				style = p.getStyle();
			}
			removeListener();
			setFontSize(style.getFont().getHeight());
		}
	}

	@Override
	protected void doRemoveListener(ChangeListener<Double> changeListener) {
//		setEnableAction(false);
		getNode().valueProperty().removeListener(changeListener);
	}

	@Override
	protected ChangeListener<Double> createChangeListener() {
		ChangeListener<Double> changeListener = new ChangeListener<Double>() {
			@Override
			public void changed(ObservableValue<? extends Double> observable, Double oldValue, Double newValue) {
				if (Rcpl.UIC().getEditor() != null) {
					System.out.println("**** size " + newValue);
					execute(newValue);
				}
			}
		};
		return changeListener;
	}

	@Override
	protected void doAddListener(ChangeListener<Double> changeListener) {

		getNode().valueProperty().addListener(changeListener);

//		getNode().setOnAction(new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent event) {
//				Double newValue = getNode().getSelectionModel().getSelectedItem();
//				execute(newValue);
//			}
//		});
//		setEnableAction(true);
	}

}
