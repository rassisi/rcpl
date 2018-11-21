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
import org.eclipse.rcpl.model_2_0_0.rcpl.Tool;
import org.eclipse.rcpl.ui.listener.RcplEvent;

import javafx.beans.value.ChangeListener;
import javafx.scene.layout.GridPane;

/**
 * @author ramin
 *
 */
public class GridPaneTool extends AbstractRcplTool {

	public GridPaneTool(Tool tool) {
		super(tool);
	}

	@Override
	public GridPane createNode() {
		return new GridPane();
	}

	@Override
	protected ChangeListener createChangeListener() {
		return null;
	}

	@Override
	protected void doRemoveListener(ChangeListener changeListener) {
	}

	@Override
	protected void doAddListener(ChangeListener changeListener) {
	}

	@Override
	protected void doUpdate(RcplEvent event) {
	}

}
