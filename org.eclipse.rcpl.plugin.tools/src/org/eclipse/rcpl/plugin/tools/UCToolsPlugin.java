package org.eclipse.rcpl.plugin.tools;

import org.eclipse.rcpl.plugin.tools.parts.EToolsModelManager;
import org.eclipse.rcpl.plugin.tools.parts.EToolsModelManagerImpl;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class UCToolsPlugin implements BundleActivator {

	private static BundleContext context;

	private EToolsModelManager toolsManager;

	private static UCToolsPlugin instance;

	static BundleContext getContext() {
		return context;
	}

	public UCToolsPlugin() {
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
		UCToolsPlugin.context = bundleContext;
		// JO.UIC.registerUseCase(EToolsUseCase.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		UCToolsPlugin.context = null;
	}

	public EToolsModelManager getToolsManager() {
		if (toolsManager == null) {
			toolsManager = new EToolsModelManagerImpl();
		}
		return toolsManager;
	}

	public static UCToolsPlugin getDefault() {
		if (instance == null) {
			new UCToolsPlugin();
		}
		return instance;
	}
}
