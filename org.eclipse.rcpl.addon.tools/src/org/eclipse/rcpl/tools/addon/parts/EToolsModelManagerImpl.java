package org.eclipse.rcpl.tools.addon.parts;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.rcpl.model.cdo.client.RcplSession;
import org.eclipse.rcpl.model_2_0_0.rcpl.provider.RcplItemProviderAdapterFactory;

/**
 * @author Ramin
 * 
 */
public class EToolsModelManagerImpl implements EToolsModelManager {

	public static EditingDomain editingDomain;

	public static ComposedAdapterFactory adapterFactory;

	public EToolsModelManagerImpl() {
		if (adapterFactory == null) {
			adapterFactory = new ComposedAdapterFactory(
					ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
			adapterFactory
					.addAdapterFactory(new ResourceItemProviderAdapterFactory());
			adapterFactory
					.addAdapterFactory(new RcplItemProviderAdapterFactory());

			adapterFactory
					.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
		}

	}

	public AdapterFactory getAdapterFactory() {
		return adapterFactory;
	}

	public EditingDomain getEditingDomain() {
		if (editingDomain == null) {
			editingDomain = AdapterFactoryEditingDomain
					.getEditingDomainFor(RcplSession.getDefault().getRcpl()
							.getAllTools());
			if (editingDomain != null) {
				try {
					Resource resource = RcplSession.getDefault().getResource();
					editingDomain.getResourceSet().getResources().add(resource);
				} catch (Exception ex) {
					// System. out.println();
				}
			}

			if (editingDomain == null) {
				BasicCommandStack commandStack = new BasicCommandStack();
				editingDomain = new AdapterFactoryEditingDomain(adapterFactory,
						commandStack);

				Resource cdoResource = RcplSession.getDefault().getResource();

				try {
					editingDomain.getResourceSet().getResources()
							.add(cdoResource);
				} catch (Exception ex) {
					// System. out.println();
				}
			}

		}
		return editingDomain;
	}

}