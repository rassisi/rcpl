package com.eclipse.rcpl.addon.demo.application;

import org.eclipse.rcpl.ILogin;
import org.eclipse.rcpl.IRcplApplicationProvider;
import org.eclipse.rcpl.IWindowAdvisor;
import org.eclipse.rcpl.application.AbstractApplicationStarter;
import org.eclipse.rcpl.application.RcplWindowAdvisor;
import org.eclipse.rcpl.ui.controler.RcplUic;

/**
 * @author Ramin
 *
 */
public class DemoRcplApplicationStarter extends AbstractApplicationStarter {

	public DemoRcplApplicationStarter(IRcplApplicationProvider application) {
		super(application);
	}

	@Override
	protected RcplUic createUIC(ILogin login) {
		return new DemoRcplUic(this);
	}

	@Override
	protected IWindowAdvisor createWindowAdvisor() {
		return new RcplWindowAdvisor(getRcplApplicationProvider());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.rcpl.application.RcplApplicationStarter#
	 * doInitApplicationWithModel()
	 */
	@Override
	protected void doInitApplicationWithModel() {

	}

	@Override
	protected void registerServices() {
	}
}
