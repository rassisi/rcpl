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

import org.eclipse.rcpl.internal.dictionary.impl.Dict;
import org.eclipse.rcpl.model_2_0_0.rcpl.Tool;
import org.eclipse.rcpl.ui.listener.RcplEvent;

import javafx.scene.control.Label;

/**
 * @author ramin
 *
 */
public class LabelTool extends RcplToolAdapter {

	public LabelTool(Tool tool) {
		super(tool);
	}

	final Label node = new Label();

	@Override
	public Label createNode() {
		return new Label(getModel().getName());
	}

	@Override
	public Label getNode() {
		return (Label) super.getNode();
	}

	@Override
	public Tool getModel() {
		return (Tool) super.getModel();
	}

	@Override
	public void updateLocale() {
		super.updateLocale();
		getNode().setText(Dict.get(getModel().getName()));
	}

	@Override
	protected void doUpdate(RcplEvent event) {
	}
}
