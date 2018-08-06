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

package org.eclipse.rcpl.detailpages;

import org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool;

import javafx.scene.layout.StackPane;
import javafx.scene.web.WebView;

/**
 * @author ramin
 *
 */
public class WebBrowserDetailsPage extends AbstractDetailPane {

	private WebView webView;

	@Override
	public String getName() {
		if (getTool() != null) {
			return getTool().getName();
		}
		return "";
	}

	@Override
	public void create(StackPane stackPane) {
		webView = new WebView();
		stackPane.getChildren().add(webView);
	}

	@Override
	public void setTool(AbstractTool tool) {
		getNode();
		webView.getEngine().load(tool.getUrl());
	}

}
