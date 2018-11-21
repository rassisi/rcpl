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
import org.eclipse.rcpl.EnCommandId;
import org.eclipse.rcpl.IColor;
import org.eclipse.rcpl.Rcpl;
import org.eclipse.rcpl.internal.resources.RcplColorProvider;
import org.eclipse.rcpl.model_2_0_0.rcpl.Tool;
import org.eclipse.rcpl.ui.listener.RcplEvent;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.paint.Color;

/**
 * @author ramin
 *
 */
public class HighlightColorTool extends AbstractRcplTool<Color> {

	@Override
	public RcplColorChooser getNode() {
		return (RcplColorChooser) super.getNode();
	}

	public HighlightColorTool(Tool model) {
		super(model);
		addListener();

	}

	public Color getValue() {
		return getNode().getChosenColor();
	}

	@Override
	public Tool getModel() {
		return (Tool) super.getModel();
	}

	@Override
	public Node createNode() {
		final RcplColorChooser colorChooser = new RcplColorChooser(RcplColorProvider.getHighlightColorPalette());
		return colorChooser;
	}

	// ========== Methods to implement for listening and updating ===========

	@Override
	protected ChangeListener<Color> createChangeListener() {
		return new ChangeListener<Color>() {
			@Override
			public void changed(ObservableValue<? extends Color> observableValue, Color oldColor, Color newColor) {
				getModel().setData(HighlightColorTool.this);
				Rcpl.get().getFactory().createCommand(HighlightColorTool.this, null, EnCommandId.highlight_color, null)
						.execute();
			}
		};
	}

	@Override
	protected void doAddListener(ChangeListener<Color> changeListener) {
		getNode().valueProperty().addListener(changeListener);
	}

	@Override
	protected void doRemoveListener(ChangeListener<Color> changeListener) {
		getNode().valueProperty().removeListener(changeListener);
	}

	@Override
	public void doUpdate(RcplEvent event) {
		IStyle style = event.getStyle();
		if (style != null) {
			String id = getModel().getId();

			if (EnCommandId.highlight_color.name().equals(id)) {
				IColor color = style.getHighlightColor();
				if (color != null) {
					getNode().setValue(color.getFx());
				} else {
					getNode().setValue(Color.WHITE);
				}
			}
		}
	}

}