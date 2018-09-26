package org.eclipse.rcpl.util;

import org.eclipse.rcpl.IEditor;

import javafx.application.Platform;

/**
 * @author ramin
 *
 */
public abstract class ForceFXThread {

	public ForceFXThread() {
		run();
	}

	public ForceFXThread(IEditor editor) {
		if (editor == null || !editor.isDisposed()) {
			run();
		}
	}

	private void run() {
		if (Platform.isFxApplicationThread()) {
			doRun();
		} else {
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					doRun();
				}
			});
		}

	}

	public abstract void doRun();
}
