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

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.rcpl.AbstractRcplTool;
import org.eclipse.rcpl.model_2_0_0.rcpl.Tool;
import org.eclipse.rcpl.util.RcplUtil;
import org.w3c.dom.Document;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.concurrent.Worker.State;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebView;

/**
 * @author ramin
 *
 */
public class WebBrowserTool extends AbstractRcplTool {

	private WebViewWithFileDragEvents wvd;

	private WebView wv;

	private Document doc;

	private List<String> htmls = new ArrayList<String>();

	public WebBrowserTool(Tool tool) {
		super(tool);
		wv = new WebView();
		wvd = new WebViewWithFileDragEvents(wv);

		wv.getEngine().getLoadWorker().stateProperty().addListener(new ChangeListener<State>() {
			public void changed(ObservableValue ov, State oldState, State newState) {
				if (newState == Worker.State.SUCCEEDED) {
					doc = wv.getEngine().getDocument();

					System.out.println("*** DOC LOADED");

					try {
						Transformer transformer = TransformerFactory.newInstance().newTransformer();
						transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
						transformer.setOutputProperty(OutputKeys.METHOD, "xml");
						transformer.setOutputProperty(OutputKeys.INDENT, "yes");
						transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
						transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

						final ByteArrayOutputStream baos = new ByteArrayOutputStream();
						PrintStream ps = new PrintStream(baos, true, "UTF-8");
						transformer.transform(new DOMSource(doc),
								new StreamResult(new OutputStreamWriter(ps, "UTF-8")));

						String html = new String(baos.toByteArray());
						htmls.add(html);

					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		});

		getNode().getChildren().add(wv);
		wv.getEngine().load(tool.getFormat());
	}

	@Override
	public StackPane createNode() {
		return new StackPane();
	}

	@Override
	public StackPane getNode() {
		return (StackPane) super.getNode();
	}

	public void showUrl(String url, boolean wait) {
		htmls.clear();
		javafx.application.Platform.runLater(new Runnable() {
			@Override
			public void run() {
				wv.getEngine().load(url);
			}
		});
	}

	public List<String> getHtml() {
		for (int i = 0; htmls.isEmpty() && i < 100; i++) {
			RcplUtil.sleep(100);
		}
		return htmls;
	}

	public String getLocation() {
		return wv.getEngine().getLocation();
	}

}
