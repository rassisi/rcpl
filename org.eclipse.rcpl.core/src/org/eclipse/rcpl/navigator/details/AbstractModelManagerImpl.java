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
import org.eclipse.rcpl.IModelManager;

/**
 * @author ramin
 *
 */
public abstract class AbstractModelManagerImpl implements IModelManager {

	public EditingDomain editingDomain;
	public ComposedAdapterFactory adapterFactory;

	public AbstractModelManagerImpl() {

	}

	@Override
	public abstract EObject getRoot();

	protected abstract Resource getResource();

	public abstract AdapterFactory[] createAdapterFactories();

	private AdapterFactory[] adapterFactories;

	private AdapterFactory[] getAdapterFactories() {
		if (adapterFactories == null) {
			adapterFactories = createAdapterFactories();
		}
		return adapterFactories;
	}

	@Override
	public AdapterFactory getAdapterFactory() {
		if (adapterFactory == null) {
			adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
			adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
			adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

			for (AdapterFactory adapter : getAdapterFactories()) {
				adapterFactory.addAdapterFactory(adapter);
			}

			// adapterFactory
			// .addAdapterFactory(new SdItemProviderAdapterFactory());

			editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(getRoot());

			// editingDomain = new AdapterFactoryEditingDomain(adapterFactory,
			// new BasicCommandStack());

			try {
				editingDomain.getResourceSet().getResources().add(getResource());
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
