package org.eclipse.rcpl.internal.tools;

import static java.lang.String.format;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Collectors;

import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.web.WebView;

public class WebViewWithFileDragEvents {
	private final WebView webview;

	public WebViewWithFileDragEvents(WebView webview) {
		this.webview = webview;
		this.webview.getEngine().setJavaScriptEnabled(true);
		this.webview.setOnDragOver(this::handleOnDragOver);
		this.webview.setOnDragDropped(this::handleOnDragDropped);
	}

	private void handleOnDragOver(DragEvent e) {
		Dragboard db = e.getDragboard();
		if (db.hasFiles()) {
			e.acceptTransferModes(TransferMode.COPY);
			injectDragOverEvent(e);
		} else {
			e.consume();
		}
	}

	private void injectDragOverEvent(DragEvent e) {
		inject(join("", "{", "  var newElement=document.elementFromPoint(%d,%d);",
				"  if (window.lastInjectedEvent && window.lastInjectedEvent != newElement) {", "     //fire dragout",
				"     window.lastInjectedEvent.dispatchEvent(%s)", "  }", "  window.lastInjectedEvent = newElement",
				"  newElement.dispatchEvent(%s);", "}"), (int) e.getX(), (int) e.getY(), dragLeaveEvent(e),
				dragOverEvent(e));
	}

	private String join(String... lines) {
		return String.join("\n", Arrays.asList(lines));
	}

	private void inject(String text, Object... args) {
		webview.getEngine().executeScript(String.format(text, args));
	}

	private String dragLeaveEvent(DragEvent e) {
		return join("", "function() {", "  var e = new Event('dragleave');", "  e.dataTransfer={ types: ['Files']};",
				"  return e;", "}()");
	}

	private String dragOverEvent(DragEvent e) {
		return join("", "function() {", "  var e = new Event('dragover');", "  e.dataTransfer={ types: ['Files']};",
				"  return e;", "}()");
	}

	private String dropEvent(DragEvent e) {
		String files = e.getDragboard().getFiles().stream().map(File::getAbsolutePath).map(f -> "{ name: '" + f + "'}")
				.collect(Collectors.joining(",", "[", "]"));

		return format(join("", "function() {", "  var e = new Event('drop');", " e.dataTransfer={ files: %s};",
				"  return e;", "}()"), files);

	}

	private void handleOnDragDropped(DragEvent e) {
		boolean success = false;
		if (e.getDragboard().hasFiles()) {
			success = true;
			injectDropEvent(e);
		}
		e.setDropCompleted(success);
		e.consume();
	}

	private void injectDropEvent(DragEvent e) {
		inject(join("", "{", "  var newElement=document.elementFromPoint(%d,%d);", "  newElement.dispatchEvent(%s);",
				"}"), (int) e.getX(), (int) e.getY(), dropEvent(e));

	}
}