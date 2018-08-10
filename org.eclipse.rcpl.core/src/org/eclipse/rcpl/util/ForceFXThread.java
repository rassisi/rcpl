package org.eclipse.rcpl.util;

import org.eclipse.rcpl.IEditor;

import javafx.application.Platform;

/**
 * @author ramin
 *
 */
public abstract class ForceFXThread {

	private boolean wait;

	private IEditor editor;

	public ForceFXThread(IEditor editor) {
		this.editor = editor;
		if (editor == null || !editor.isDisposed()) {
			run();
		}
	}

	private void run() {
		if (Platform.isFxApplicationThread()) {
			doRun();
		} else {
			wait = true;
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					doRun();
					wait = false;
				}
			});
		}

	}

	public abstract void doRun();
}
