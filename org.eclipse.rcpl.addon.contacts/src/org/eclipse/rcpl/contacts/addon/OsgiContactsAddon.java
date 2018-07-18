package org.eclipse.rcpl.contacts.addon;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.rcpl.ui.parts.contacts.EContactsModelManager;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * @author ramin
 *
 */
public class OsgiContactsAddon implements BundleActivator {

	private static BundleContext context;

	private static OsgiContactsAddon instance;

	private EContactsModelManager modelManager;

	static BundleContext getContext() {
		return context;
	}

	public OsgiContactsAddon() {
		instance = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext bundleContext) throws Exception {
		OsgiContactsAddon.context = bundleContext;
//		JO.UIC.registerRcplPlugin(RcplContactsPlugin.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		OsgiContactsAddon.context = null;
	}

	public static OsgiContactsAddon getDefault() {

		// This is for Standalone
		if (instance == null) {
			instance = new OsgiContactsAddon();
		}
		return instance;
	}

	public EContactsModelManager getModelManager() {
		if (modelManager == null) {
			modelManager = EContactsModelManager.FACTORY.newInstance();
		}
		return modelManager;
	}

	public static EditingDomain getEditingDomain() {
		return getDefault().getModelManager().getEditingDomain();
	}
}
