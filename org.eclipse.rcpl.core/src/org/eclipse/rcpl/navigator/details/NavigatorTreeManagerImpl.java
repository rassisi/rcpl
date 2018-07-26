/*******************************************************************************
 * Copyright (c) 2003 - 2014 Ramin Assisi and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     Ramin Assisi - initial implementation
 *******************************************************************************/

package org.eclipse.rcpl.navigator.details;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.rcpl.INavigatorTreeManager;
import org.eclipse.rcpl.model.cdo.client.RcplSession;
import org.eclipse.rcpl.model_2_0_0.rcpl.provider.RcplItemProviderAdapterFactory;

public class NavigatorTreeManagerImpl implements INavigatorTreeManager {

	public static EditingDomain editingDomain;
	public static ComposedAdapterFactory adapterFactory;

	public NavigatorTreeManagerImpl() {

	}

	public EObject getRoot() {
		return RcplSession.getDefault().getRcpl();
	}

	@Override
	public AdapterFactory getAdapterFactory() {
		if (adapterFactory == null) {
			adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
			adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
			adapterFactory.addAdapterFactory(new RcplItemProviderAdapterFactory());

			// adapterFactory
			// .addAdapterFactory(new SdItemProviderAdapterFactory());

			adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

			editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(RcplSession.getDefault().getRcpl());

			// editingDomain = new AdapterFactoryEditingDomain(adapterFactory,
			// new BasicCommandStack());

			Resource cdoResource = RcplSession.getDefault().getResource();

			try {
				editingDomain.getResourceSet().getResources().add(cdoResource);
			} catch (Exception ex) {
				// System. out.println();
			}

		}
		return adapterFactory;
	}

	@Override
	public EditingDomain getEditingDomain() {
		return editingDomain;
	}

}
