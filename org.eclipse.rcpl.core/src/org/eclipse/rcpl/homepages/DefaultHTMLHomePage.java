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

import java.io.File;
import java.util.HashMap;

import org.eclipse.rcpl.EnCommandId;
import org.eclipse.rcpl.IDocument;
import org.eclipse.rcpl.IRcplUic;
import org.eclipse.rcpl.model_2_0_0.rcpl.HomePage;
import org.eclipse.rcpl.util.RcplUtil;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.web.HTMLEditor;

public class DefaultHTMLHomePage extends AbstractHomePage {

	private IDocument document = null;

	HTMLEditor htmlEditor;

	public DefaultHTMLHomePage(IRcplUic uic, HomePage modelHomePage, Pane pane, String documentTemplate,
			HashMap<String, String> wordReplacements) {
		super(uic, modelHomePage, pane);

		htmlEditor = new HTMLEditor();

		File f = RcplUtil.loadTemplateDocumentToFile(documentTemplate, true);

		// WebView w = new WebView();
		// w.getEngine().load("file://" + f.getAbsolutePath());
		// contentPane.getChildren().add(w);

		// String htmlText = new JODocumentProvider().createHtmlDocument(
		// documentTemplate, wordReplacements);

		getContentPane().getChildren().add(htmlEditor);

		String htmlText = RcplUtil.loadTemplateHTMLDocument(documentTemplate, wordReplacements, true);
		if (htmlText != null) {
			for (String key : wordReplacements.keySet()) {
				String replacement = wordReplacements.get(key);
				htmlText = htmlText.replaceAll(key, replacement);
			}
			htmlEditor.setHtmlText(htmlText);
		}
	}

	public IDocument getDocument() {
		return document;
	}

	@Override
	public EnCommandId getId() {
		return EnCommandId.HOME_PAGE_DOCUMENT;
	}

	@Override
	protected void doCreateContent(StackPane contentPane) {

	}

}
