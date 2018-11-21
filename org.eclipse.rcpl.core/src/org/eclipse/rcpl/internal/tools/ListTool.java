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
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

/**
 * @author ramin
 *
 */
/**
 * @author ramin
 *
 */
public class ListTool extends AbstractRcplTool<String> {

	public ListTool(Tool tool) {
		super(tool);
	}

	@Override
	public ListView<String> createNode() {
		return new ListView<String>();
	}

	@SuppressWarnings("unchecked")
	@Override
	public ListView<String> getNode() {
		return (ListView<String>) super.getNode();
	}

	@Override
	protected void doUpdate(RcplEvent event) {
	}

	@Override
	protected ChangeListener<String> createChangeListener() {
		getNode().setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				if (arg0.getClickCount() == 2) {
					execute(getNode().getSelectionModel().getSelectedItem());
				}
			}
		});
		return null;
	}

	@Override
	protected void doRemoveListener(ChangeListener<String> changeListener) {
		setEnableAction(false);
	}

	@Override
	protected void doAddListener(ChangeListener<String> changeListener) {
		setEnableAction(true);
	}

}
