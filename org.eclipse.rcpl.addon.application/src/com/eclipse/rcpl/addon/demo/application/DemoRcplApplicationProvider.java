package com.eclipse.rcpl.addon.demo.application;

import org.eclipse.rcpl.IRcplFactory;
import org.eclipse.rcpl.IToolFactory;
import org.eclipse.rcpl.RcplBasicFactory;
import org.eclipse.rcpl.application.AbstractRcplApplication;
import org.eclipse.rcpl.application.AbstractApplicationProvider;
import org.eclipse.rcpl.images.RcplImage;
import org.eclipse.rcpl.internal.impl.RcplToolFactory;

/**
 * @author ramin
 *
 */
public class DemoRcplApplicationProvider extends AbstractApplicationProvider {

	public DemoRcplApplicationProvider(AbstractRcplApplication rcplApplication) {
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

	@Override
	protected IToolFactory createToolFactory() {
		return new RcplToolFactory();
	}

	@Override
	protected IRcplFactory createRcplFactory() {
		return new RcplBasicFactory();
	}

	@Override
	public Class<?> getApplicationResourceBaseClass() {
		return RcplImage.class;
	}

}
