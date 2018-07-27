package org.eclipse.rcpl.navigator.details;

import org.eclipse.rcpl.IDetailPane;
import org.eclipse.rcpl.navigator.IDetailPaneControler;

/**
 * @author ramin
 *
 */
public abstract class AbstractDetailPane implements IDetailPane {

	public AbstractDetailPane() {
		super();
	}

	@Override
	public abstract IDetailPaneControler getControler();

}
