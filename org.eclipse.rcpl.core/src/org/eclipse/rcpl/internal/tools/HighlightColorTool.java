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

		getNode().valueProperty().addListener(new ChangeListener<Color>() {
			@Override
			public void changed(ObservableValue<? extends Color> observableValue, Color oldColor, Color newColor) {
//				System.out.println("Chose: " + colorChooser.getChosenColorName() + " " + colorChooser.getChosenColor());
				getModel().setData(HighlightColorTool.this);
				Rcpl.get().getFactory().createCommand(HighlightColorTool.this, null).execute();
			}
		});

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

	@Override
	public boolean update(RcplEvent event) {

		return true;
	}

	public static void main(String[] args) {

		String s = Color.ALICEBLUE.toString();

		System.out.println("s = " + s);

	}
}
