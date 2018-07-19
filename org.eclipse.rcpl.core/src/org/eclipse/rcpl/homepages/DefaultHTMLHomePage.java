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

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.web.HTMLEditor;

import org.eclipse.rcpl.IDocument;
import org.eclipse.rcpl.IRcplUic;
import org.eclipse.rcpl.util.RcplUtil;

public class DefaultHTMLHomePage extends AbstractHomePage {

	private IDocument document = null;

	private StackPane contentPane;

	public DefaultHTMLHomePage(IRcplUic uic, String title, String documentTemplate,
			String image, HashMap<String, String> wordReplacements,
			Pane controlPane) {
		super(uic, title, image, controlPane);

		HTMLEditor htmlEditor = new HTMLEditor();

		File f = RcplUtil.loadTemplateDocumentToFile(documentTemplate, true);

		// WebView w = new WebView();
		// w.getEngine().load("file://" + f.getAbsolutePath());
		// contentPane.getChildren().add(w);

		// String htmlText = new JODocumentProvider().createHtmlDocument(
		// documentTemplate, wordReplacements);

		String htmlText = RcplUtil.loadTemplateHTMLDocument(documentTemplate,
				wordReplacements, true);

		if (htmlText != null) {
			for (String key : wordReplacements.keySet()) {
				String replacement = wordReplacements.get(key);
				htmlText = htmlText.replaceAll(key, replacement);
			}
			htmlEditor.setHtmlText(htmlText);
		}
		contentPane.getChildren().add(htmlEditor);

	}

	@Override
	protected void createContent(StackPane contentPane) {
		this.contentPane = contentPane;
	}

	@Override
	public Node getNode() {
		super.getNode().setUserData(this);
		return super.getNode();
	}

	public IDocument getDocument() {
		return document;
	}

}
