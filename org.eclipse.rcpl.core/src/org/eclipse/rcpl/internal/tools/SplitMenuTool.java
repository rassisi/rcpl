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

import org.eclipse.rcpl.RcplTool;
import org.eclipse.rcpl.model_2_0_0.rcpl.Tool;

import javafx.scene.control.SplitMenuButton;

/**
 * @author ramin
 *
 */
public class SplitMenuTool extends RcplTool {

	public SplitMenuTool(Tool tool) {
		super(tool);
	}

	@Override
	public SplitMenuButton createNode() {
		return new SplitMenuButton();
	}

	@Override
	public SplitMenuButton getNode() {
		return (SplitMenuButton) super.getNode();
	}
}