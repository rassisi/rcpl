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
import org.eclipse.rcpl.model_2_0_0.rcpl.Tool;
import org.eclipse.rcpl.ui.listener.RcplEvent;

import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

/**
 * @author ramin
 *
 */
public class ColorTool extends AbstractRcplTool<Color> {

	@Override
	public ColorPicker getNode() {
		return (ColorPicker) super.getNode();
	}

	public ColorTool(Tool model) {
		super(model);

		getNode().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				getModel().setData(ColorTool.this);
				Rcpl.get().getFactory().createCommand(ColorTool.this, null, EnCommandId.foregroundColor, null)
						.execute();
			}
		});

	}

	@Override
	public Tool getModel() {
		return (Tool) super.getModel();
	}

	@Override
	public Node createNode() {
		String f = getModel().getFormat();
		if (f != null && f.length() > 0) {
			try {
				Color c = Color.web(f);
				if (c != null) {
					return new ColorPicker(c);
				}
			} catch (Exception ex) {
				// ignore invalid color formats
			}
		}
		return new ColorPicker();
	}

	@Override
	protected ChangeListener<Color> createChangeListener() {
		return null;
	}

	@Override
	protected void doRemoveListener(ChangeListener<Color> changeListener) {
	}

	@Override
	protected void doAddListener(ChangeListener<Color> changeListener) {
	}

	@Override
	protected void doUpdate(RcplEvent event) {
		IStyle style = event.getStyle();
		if (style != null) {
			String id = getModel().getId();

			if (EnCommandId.foregroundColor.name().equals(id)) {
				IColor color = style.getForeGround();
				if (color != null) {
					getNode().setValue(color.getFx());
				}
			}
		}
	}

}
