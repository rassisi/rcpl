package org.eclipse.rcpl.application;

import org.eclipse.rcpl.ILogin;
import org.eclipse.rcpl.IRcplApplicationProvider;
import org.eclipse.rcpl.IWindowAdvisor;
import org.eclipse.rcpl.ui.controler.RcplUic;

public class DefaultApplicationStarter extends AbstractApplicationStarter {

	public DefaultApplicationStarter(IRcplApplicationProvider applicationProvider) {
		super(applicationProvider);
	}

	@Override
	protected RcplUic createUIC(ILogin login) {
		return new RcplUic(this);
	}

	@Override
	protected IWindowAdvisor createWindowAdvisor() {
		return new RcplWindowAdvisor(getRcplApplicationProvider(),
				getClass().getResource("/css/default.css").toExternalForm());
	}

	@Override
	protected void doInitApplicationWithModel() {
	}

	@Override
	protected void registerServices() {
	}

}
