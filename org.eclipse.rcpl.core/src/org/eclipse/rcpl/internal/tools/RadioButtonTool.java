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
import org.eclipse.rcpl.model_2_0_0.rcpl.Tool;
import org.eclipse.rcpl.model_2_0_0.rcpl.ToolType;
import org.eclipse.rcpl.ui.listener.RcplEvent;

import javafx.scene.control.RadioButton;

/**
 * @author ramin
 *
 */
public class RadioButtonTool extends AbstractRcplTool {

	public RadioButtonTool(Tool tool) {
		super(tool);
	}

	final RadioButton node = new RadioButton();

	@Override
	public RadioButton createNode() {
		return new RadioButton();
	}

	@Override
	public RadioButton getNode() {
		return (RadioButton) super.getNode();
	}

	@Override
	public boolean update(RcplEvent event) {
		if (getModel() != null) {

			String id = getModel().getId();
			if (id == null || "".equals(id)) {
				return false;
			}
			if (!ToolType.RADIOBUTTON.equals(getModel().getType())) {
				return false;
			}

			EnCommandId cmd;
			try {
				cmd = EnCommandId.valueOf(id);
			} catch (IllegalArgumentException ex) {
				// There is no value for this id
				return false;
			}
			boolean select = false;
			boolean found = false;
			switch (cmd) {
			case background_color:
				break;

			default:
				break;

			}
			if (found) {
				setSelected(select);
			}

		}

		return true;

	}
}
