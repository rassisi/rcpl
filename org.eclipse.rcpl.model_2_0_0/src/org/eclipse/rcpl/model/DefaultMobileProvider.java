package org.eclipse.rcpl.model;

import java.io.File;

import org.eclipse.rcpl.model.IMobileProvider;
import org.eclipse.rcpl.model.RcplModel;

/**
 * @author ramin
 *
 */
public class DefaultMobileProvider implements IMobileProvider {

	@Override
	public File getApplicationDir() {
		try {
			File f = new File(System.getProperty("user.home") + "/.rcpl");
			f.mkdirs();
			return f;
		} catch (Throwable ex) {
			RcplModel.logError(ex);
		}
		return new File("");
	}

	@Override
	public void showSoftKeyboard() {
	}

	@Override
	public void hideSoftKeyboard() {

	}

	@Override
	public void appendLog(String text) {
	}

	@Override
	public void displayNotification(String message) {
	}

}
