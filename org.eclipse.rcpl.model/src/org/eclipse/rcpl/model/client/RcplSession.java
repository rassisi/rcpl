package org.eclipse.rcpl.model.client;

import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.rcpl.model_2_0_0.rcpl.provider.RcplItemProviderAdapterFactory;

/**
 * @author Ramin
 * 
 */
public class RcplSession<EObject> extends AbstractSession<org.eclipse.emf.ecore.EObject> {

	@Override
	protected void addAdapterFactories(ComposedAdapterFactory composedAdapterFactory) {
		composedAdapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		composedAdapterFactory.addAdapterFactory(new RcplItemProviderAdapterFactory());
		composedAdapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
	}

	@Override
	protected void registerApplicationPackages(CDOSession cdoSession) {
	}

	@Override
	protected void createInitialApplicationModel(EList<org.eclipse.emf.ecore.EObject> contents) {
	}

}
