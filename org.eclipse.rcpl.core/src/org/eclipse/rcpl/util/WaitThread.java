package org.eclipse.rcpl.util;

import org.eclipse.rcpl.IEditor;

import javafx.application.Platform;

/**
 * @author ramin
 *
 */
public abstract class WaitThread {

	private boolean wait;

	private IEditor editor;

	class Waiter extends Thread {
		private Object ob;

		/**
		*/
		public Waiter(Object ob) {
			this.ob = ob;
			setName("Waiter");
		}

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
		this(null);
	}

	public WaitThread(IEditor editor) {
		this.editor = editor;
		if (editor == null || !editor.isDisposed()) {
			run();
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
			Thread.sleep(0, 100);
		} catch (InterruptedException e) {
		}
	}

	public abstract void doRun();
}
