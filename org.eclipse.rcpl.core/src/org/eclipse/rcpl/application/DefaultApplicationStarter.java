package org.eclipse.rcpl.application;

import org.eclipse.rcpl.IRcplApplicationProvider;
import org.eclipse.rcpl.IRcplFactory;
import org.eclipse.rcpl.IToolFactory;
import org.eclipse.rcpl.IWindowAdvisor;
import org.eclipse.rcpl.RcplBasicFactory;
import org.eclipse.rcpl.internal.impl.RcplToolFactory;
import org.eclipse.rcpl.login.RcplLogin;
import org.eclipse.rcpl.ui.controler.RcplUic;

public class DefaultApplicationStarter extends RcplApplicationStarter {

	public DefaultApplicationStarter(IRcplApplicationProvider applicationProvider) {
		super(applicationProvider);
	}

	@Override
	protected RcplUic createUIC(RcplLogin login) {
		return new RcplUic(this);
	}

	@Override
	protected IWindowAdvisor createWindowAdvisor() {
		return new RcplWindowAdvisor(getRcplApplicationProvider(),
				getClass().getResource("/css/default.css").toExternalForm());
	}

	@Override
	protected IToolFactory createToolFactory() {
		return new RcplToolFactory();
	}

	@Override
	protected IRcplFactory createRcplFactory() {
		return new RcplBasicFactory();
	}

	@Override
	protected void doInitApplicationWithModel() {
	}

	@Override
	protected void registerServices() {
	}

}
