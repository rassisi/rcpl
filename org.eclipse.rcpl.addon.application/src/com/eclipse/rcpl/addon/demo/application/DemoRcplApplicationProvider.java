package com.eclipse.rcpl.addon.demo.application;

import org.eclipse.rcpl.application.RcplApplication;
import org.eclipse.rcpl.application.RcplApplicationProvider;

public class DemoRcplApplicationProvider extends RcplApplicationProvider {

	public DemoRcplApplicationProvider(RcplApplication rcplApplication) {
		super(rcplApplication);
	}

	@Override
	public String getName() {
		return "Dmeo Rcpl Application";
	}

	@Override
	public String getImage() {
		return "rcpl";
	}
}
