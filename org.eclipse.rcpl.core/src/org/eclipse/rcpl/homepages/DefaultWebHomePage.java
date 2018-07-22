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
package org.eclipse.rcpl.homepages;

import org.eclipse.rcpl.EnCommandId;
import org.eclipse.rcpl.IRcplUic;
import org.eclipse.rcpl.model_2_0_0.rcpl.HomePage;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebView;

/**
 * @author Ramin
 *
 */
public class DefaultWebHomePage extends AbstractHomePage {

	private WebView webView;

	public DefaultWebHomePage(IRcplUic uic, HomePage modelHomePage, Pane pane, String url) {
		super(uic, modelHomePage, pane);
		webView.getEngine().load(url);
	}

	@Override
	protected void doCreateContent(StackPane contentPane) {
		webView = new WebView();
		contentPane.getChildren().add(webView);
	}

	@Override
	public void refresh() {
		webView.getEngine().reload();
	}

	@Override
	public EnCommandId getId() {
		return EnCommandId.HOME_PAGE_HTML;
	}
}
