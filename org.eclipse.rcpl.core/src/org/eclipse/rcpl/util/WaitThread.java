package org.eclipse.rcpl.util;

import org.eclipse.rcpl.IEditor;
import org.eclipse.rcpl.Rcpl;

import javafx.application.Platform;

/**
 * @author ramin
 *
 */
public abstract class WaitThread {

	private boolean wait;

	private IEditor editor;

	private long millis = 0;

	private int nanos = 10;

	class Waiter extends Thread {
		private Object ob;

		/**
		*/
		public Waiter(Object ob) {
			this.ob = ob;
			setName("Waiter");
		}

		@Override
		public void run() {
			// waiter warten sofort
			synchronized (ob) {
				try {
					System.out.println(this.getName() + " waits");
					ob.wait();
					System.out.println(this.getName() + " ends waiting");
				} catch (InterruptedException ex) {
					System.out.println("interrupted");
				}
			}
		}
	}

	public WaitThread() {
		this(null, 0, 10);
	}

	public WaitThread(IEditor editor) {
		this(editor, 0, 10);
	}

	public WaitThread(IEditor editor, long millis, int nanos) {
		this.editor = editor;
		if (editor == null || !editor.isDisposed()) {
			try {
				run();
			} catch (Exception ex) {
				Rcpl.printErrorln("", ex);
			}
		}
	}

	private void run() {
//		final Object o = new Object();
//		final Waiter waiter = new Waiter(o);
		if (Platform.isFxApplicationThread()) {
			doRun();
//			synchronized (o) {
//				o.notifyAll();
//			}
		} else {
			wait = true;
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					doRun();
					wait = false;
//					waiter.interrupt();
//					synchronized (o) {
//						o.notifyAll();
//					}
				}
			});

//			waiter.start();

			do {
				if (editor == null || editor.isDisposed()) {
					break;
				}
				if (!wait) {
					sleep();
					break;
				}
				sleep();
			} while (true);
		}

	}

	private void sleep() {
		try {
			Thread.sleep(millis, nanos);
		} catch (InterruptedException e) {
		}
	}

	public abstract void doRun();
}
