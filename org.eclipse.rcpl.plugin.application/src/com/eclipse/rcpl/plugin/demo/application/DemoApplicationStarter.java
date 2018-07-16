package com.eclipse.rcpl.plugin.demo.application;

import org.eclipse.rcpl.IRcplApplicationProvider;
import org.eclipse.rcpl.IRcplFactory;
import org.eclipse.rcpl.IToolFactory;
import org.eclipse.rcpl.IWindowAdvisor;
import org.eclipse.rcpl.RcplUic;
import org.eclipse.rcpl.application.RcplApplicationStarter;
import org.eclipse.rcpl.application.RcplWindowAdvisor;
import org.eclipse.rcpl.RcplLogin;

public class DemoApplicationStarter extends RcplApplicationStarter {

	public DemoApplicationStarter(IRcplApplicationProvider application) {
		super(application);
	}

	@Override
	protected RcplUic createUIC(RcplLogin login) {
		return new DemoUic(this);
	}

	@Override
	protected IWindowAdvisor createWindowAdvisor() {
		return new RcplWindowAdvisor(getRcplApplicationProvider(),
				getClass().getResource("/css/default.css").toExternalForm());
	}

	@Override
	protected IToolFactory createToolFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected IRcplFactory createRcplFactory() {
		// TODO Auto-generated method stub
		return null;
	}
}
