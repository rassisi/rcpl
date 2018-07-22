package com.eclipse.rcpl.addon.demo.application;

import org.eclipse.rcpl.RcplBasicFactory;
import org.eclipse.rcpl.IRcplApplicationProvider;
import org.eclipse.rcpl.IRcplFactory;
import org.eclipse.rcpl.IToolFactory;
import org.eclipse.rcpl.IWindowAdvisor;
import org.eclipse.rcpl.application.RcplApplicationStarter;
import org.eclipse.rcpl.application.RcplWindowAdvisor;
import org.eclipse.rcpl.internal.impl.RcplToolFactory;
import org.eclipse.rcpl.login.RcplLogin;
import org.eclipse.rcpl.ui.controler.RcplUic;

/**
 * @author Ramin
 *
 */
public class DemoRcplApplicationStarter extends RcplApplicationStarter {

	public DemoRcplApplicationStarter(IRcplApplicationProvider application) {
		super(application);
	}

	@Override
	protected RcplUic createUIC(RcplLogin login) {
		return new DemoRcplUic(this);
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
}
