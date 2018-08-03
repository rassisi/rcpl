package org.eclipse.rcpl.detailpages;

import org.eclipse.rcpl.IModelDetailPage;
import org.eclipse.rcpl.navigator.IModelDetailPageControler;

public abstract class AbstractModelDetailPage extends AbstractDetailPane implements IModelDetailPage {

	private IModelDetailPageControler controler;

	abstract protected IModelDetailPageControler createControler();

	@Override
	public IModelDetailPageControler getControler() {
		getNode();
		if (controler == null) {
			controler = createControler();
		}
		return controler;
	}
}
