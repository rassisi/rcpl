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

import org.eclipse.rcpl.IDocument;
import org.eclipse.rcpl.IRcplUic;
import org.eclipse.rcpl.model_2_0_0.rcpl.HomePage;
import org.eclipse.rcpl.model_2_0_0.rcpl.HomePageType;
import org.eclipse.rcpl.util.RcplUtil;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.web.HTMLEditor;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class DefaultHTMLReadOnlyHomePage extends AbstractHomePage {

	private IDocument document = null;

	private StackPane contentPane;

	public DefaultHTMLReadOnlyHomePage(IRcplUic uic, HomePage modelHomePage, Pane pane, String documentTemplate,
			HashMap<String, String> wordReplacements) {
		super(uic, modelHomePage, pane);

		HTMLEditor htmlEditor = new HTMLEditor();

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

		final WebView webView = new WebView();

		final WebEngine webengine = webView.getEngine();

		// URL url = JOTemplates.class.getResource(documentTemplate);
		// webengine.load(url.toExternalForm());

		// String htmlText = webView.getEngine().getDocument().getTextContent();

		// String htmlText = new JODocumentProvider().createHtmlDocument(
		// documentTemplate, wordReplacements)

		htmlText = RcplUtil.loadTemplateHTMLDocument(documentTemplate, wordReplacements, true);

		// .replaceAll(
		// new String(new byte[] { (byte) 63 }), "&uuml;")

		;

		// int pos = htmlText.indexOf("Auftrag f");
		//
		// if (pos != -1) {
		// String s = htmlText.substring(pos + 9, pos + 10);
		//
		// byte[] bytes = s.getBytes(Charset.forName("UTF-8"));
		// int x = s.getBytes()[0];
		//
		// if (x == 63) {
		// htmlText = htmlText.substring(0, pos) + "&uuml;"
		// + htmlText.substring(pos + 10, htmlText.length());
		// }
		//
		// }
		if (htmlText != null) {
			for (String key : wordReplacements.keySet()) {
				String replacement = wordReplacements.get(key);
				htmlText = htmlText.replaceAll(key, replacement);
			}
			webView.getEngine().loadContent(htmlText);
		}

		contentPane.getChildren().add(webView);

	}

	@Override
	public Node getNode() {
		super.getNode().setUserData(this);
		return super.getNode();
	}

	public IDocument getDocument() {
		return document;
	}

	@Override
	public HomePageType getId() {
		return HomePageType.HOME;
	}

	@Override
	protected void doCreateContent(StackPane contentPane) {
		// TODO Auto-generated method stub

	}

}
