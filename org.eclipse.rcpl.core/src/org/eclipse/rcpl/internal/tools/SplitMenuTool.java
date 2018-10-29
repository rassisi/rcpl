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
import org.eclipse.rcpl.images.RcplImage;
import org.eclipse.rcpl.model.RcplModel;
import org.eclipse.rcpl.model_2_0_0.rcpl.Tool;
import org.eclipse.rcpl.util.RcplUtil;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.image.ImageView;

/**
 * @author ramin
 *
 */
public class SplitMenuTool extends AbstractRcplTool {

	private List<String> items;

	protected SplitMenuButton b;

	public SplitMenuTool(Tool tool) {
		super(tool);
	}

	@Override
	public SplitMenuButton createNode() {
		b = new SplitMenuButton();
		createContent();
		b.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				performAction();
			}
		});
		return b;
	}

	protected void createContent() {
		String f = getModel().getFormat();

		// index=0;entries=●{},123...{numbers};

		List<String> rawItems = RcplUtil.getListFromDelimiterSeparatedList(getModel().getFormatValue("entries"), ",");
		if (!rawItems.isEmpty()) {
			for (String rawItem : rawItems) {
				try {
					MenuItem menuItem = new MenuItem();
					b.getItems().add(menuItem);

					String menuItemText;
					String menuItemImage = null;
					int pos = rawItem.indexOf("{");
					if (pos != -1) {
						menuItemText = rawItem.substring(0, pos);
						String data = rawItem.substring(pos + 1, rawItem.length());
						if (data.endsWith("}")) {
							data = data.substring(0, data.length() - 1);
						}
						if (data != null && data.length() > 0) {
							menuItemImage = (getModel().getId() + "_" + data).toLowerCase();
						} else {
							menuItemImage = getModel().getId();
						}
					} else {
						menuItemText = rawItem;
					}

					if (menuItemText != null && menuItemText.length() > 0) {
						menuItem.setText(menuItemText);
					}
					if (menuItemImage != null) {
						ImageView iv = new RcplImage(menuItemImage, 16, 16).getNode();
						menuItem.setGraphic(iv);
					}

					String additionalId = menuItemText;
					if (additionalId == null || additionalId.length() == 0) {
						additionalId = menuItemImage;
					}
					menuItem.setUserData(additionalId);

				} catch (Exception ex) {
					System.out.println();
				}

			}
		}
	}

	void performAction() {
		if (!isImplemented()) {
			return;
		}
		try {
			Object o = getNode().getUserData();
			getModel().setData(SplitMenuTool.this);
			Rcpl.getFactory().createCommand(SplitMenuTool.this, o).execute();
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

	protected void updateButton(MenuItem menuItem) {
		b.setText(menuItem.getText());
		b.setGraphic(menuItem.getGraphic());
		Object o = menuItem.getUserData();
		b.setUserData(o);
		setData(o);
	}

	protected void addActionListener(MenuItem menuItem) {
		menuItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				updateButton(menuItem);
			}
		});
	}
}
