package com.eclipse.rcpl.addon.demo.application;

import org.eclipse.rcpl.IRcplFactory;
import org.eclipse.rcpl.IServiceFactory;
import org.eclipse.rcpl.IToolFactory;
import org.eclipse.rcpl.application.AbstractApplicationProvider;
import org.eclipse.rcpl.application.AbstractRcplApplication;
import org.eclipse.rcpl.images.RcplImage;
import org.eclipse.rcpl.internal.factory.impl.RcplBasicFactory;
import org.eclipse.rcpl.internal.factory.impl.RcplServiceFactory;
import org.eclipse.rcpl.internal.factory.impl.RcplToolFactory;

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
		return "Demo Rcpl Application";
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

	@Override
	protected IServiceFactory createServiceFactory() {
		return new RcplServiceFactory();
	}

}
