package org.eclipse.rcpl.navigator.details;

import org.eclipse.rcpl.INavigatorDetailPage;
import org.eclipse.rcpl.navigator.INavigatorDetailPageControler;

public abstract class AbstractNavigatorDetailPage extends AbstractDetailPane implements INavigatorDetailPage {

	private INavigatorDetailPageControler controler;

	abstract INavigatorDetailPageControler createControler();

	@Override
	public INavigatorDetailPageControler getControler() {
		getNode();
		if (controler == null) {
			controler = createControler();
		}
		return controler;
	}
}
