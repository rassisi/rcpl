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
import javafx.scene.control.Separator;

/**
 * @author ramin
 *
 */
/**
 * @author ramin
 *
 */
public class SeparatorTool extends AbstractRcplTool {

	public SeparatorTool(Tool tool) {
		super(tool);
	}

	@Override
	public Separator createNode() {
		return new Separator();
	}

	@Override
	public Separator getNode() {
		return (Separator) super.getNode();
	}

	@Override
	protected ChangeListener createChangeListener() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void doRemoveListener(ChangeListener changeListener) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void doAddListener(ChangeListener changeListener) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void doUpdate(RcplEvent event) {
		// TODO Auto-generated method stub

	}

}
