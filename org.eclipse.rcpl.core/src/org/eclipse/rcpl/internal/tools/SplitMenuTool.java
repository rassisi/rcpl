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

import java.util.List;

import org.eclipse.rcpl.AbstractRcplTool;
import org.eclipse.rcpl.Rcpl;
import org.eclipse.rcpl.model.RcplModel;
import org.eclipse.rcpl.model_2_0_0.rcpl.Tool;
import org.eclipse.rcpl.util.RcplUtil;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;

/**
 * @author ramin
 *
 */
public class SplitMenuTool extends AbstractRcplTool {

	private List<String> items;

	public SplitMenuTool(Tool tool) {
		super(tool);
	}

	@Override
	public SplitMenuButton createNode() {
		SplitMenuButton b = new SplitMenuButton();
		String f = getModel().getFormat();
		items = RcplUtil.getListFromDelimiterSeparatedList(f, ",");
		for (String string : items) {
			MenuItem item = new MenuItem(string);
			item.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					b.setText(string);
				}
			});
			b.getItems().add(item);
		}

		b.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				performAction();
			}
		});

		return b;
	}

	private void performAction() {
		if (!isImplemented()) {
			return;
		}
		try {
			getModel().setData(SplitMenuTool.this);
			Rcpl.getFactory().createCommand(SplitMenuTool.this).execute();
		} catch (Throwable ex) {
			RcplModel.logError(ex);
		}
	}

	@Override
	public SplitMenuButton getNode() {
		return (SplitMenuButton) super.getNode();
	}

	@Override
	public Tool getModel() {
		return (Tool) super.getModel();
	}
}
