package org.eclipse.rcpl.navigator.details;

import org.eclipse.rcpl.IDetailPane;
import org.eclipse.rcpl.navigator.IDetailPaneControler;

/**
 * @author ramin
 *
 */
public abstract class AbstractDetailPane implements IDetailPane {

	private IDetailPaneControler controler;

	public AbstractDetailPane() {
		super();
	}

	abstract IDetailPaneControler createControler();

	@Override
	public IDetailPaneControler getControler() {
		if (controler == null) {
			controler = createControler();
		}
		return controler;
	}

}
