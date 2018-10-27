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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.rcpl.AbstractRcplTool;
import org.eclipse.rcpl.IWebViewListener;
import org.eclipse.rcpl.model_2_0_0.rcpl.Tool;

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

//	private Document doc;

	private List<IWebViewListener> webViewListeners = new ArrayList<IWebViewListener>();

	public WebBrowserTool(Tool tool) {
		super(tool);
		wv = new WebView();
		wvd = new WebViewWithFileDragEvents(wv);

		wv.getEngine().getLoadWorker().stateProperty().addListener(new ChangeListener<State>() {
			public void changed(ObservableValue ov, State oldState, State newState) {
				if (newState == Worker.State.SUCCEEDED) {

					System.out.println(getLocation());

					for (IWebViewListener w : webViewListeners) {
						w.loaded(getLocation());

					}
//					doc = wv.getEngine().getDocument();
//
//					System.out.println("*** DOC LOADED");
//
//					try {
//						Transformer transformer = TransformerFactory.newInstance().newTransformer();
//						transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
//						transformer.setOutputProperty(OutputKeys.METHOD, "xml");
//						transformer.setOutputProperty(OutputKeys.INDENT, "yes");
//						transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
//						transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
//
//						final ByteArrayOutputStream baos = new ByteArrayOutputStream();
//						PrintStream ps = new PrintStream(baos, true, "UTF-8");
//						transformer.transform(new DOMSource(doc),
//								new StreamResult(new OutputStreamWriter(ps, "UTF-8")));
//
//						String html = new String(baos.toByteArray());
//						htmls.add(html);
//
//					} catch (Exception ex) {
//						ex.printStackTrace();
//					}
				}
			}
		});

		wv.getEngine().locationProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

				System.out.println("############# " + newValue);

			}
		});
		wv.getEngine().getLoadWorker().valueProperty().addListener(new ChangeListener<Object>() {

			@Override
			public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {

				System.out.println();
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
		javafx.application.Platform.runLater(new Runnable() {
			@Override
			public void run() {
				wv.getEngine().load(url);
			}
		});
	}

	public String getLocation() {
		return wv.getEngine().getLocation();
	}

	public void addListener(IWebViewListener listener) {
		webViewListeners.add(listener);
	}

	public void removeListener(IWebViewListener listener) {
		webViewListeners.remove(listener);
	}

}
