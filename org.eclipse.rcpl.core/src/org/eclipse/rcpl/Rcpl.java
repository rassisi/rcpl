/******************************************************************************
 *
 * Copyright (c) 2009 Ramin Assisi
 * All rights reserved.
 *
 ****************************************************************************/
package org.eclipse.rcpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.rcpl.impl.RcplMonitor;
import org.eclipse.rcpl.model.EnKeyValue;
import org.eclipse.rcpl.model.IResources;
import org.eclipse.rcpl.model.RcplModel;
import org.eclipse.rcpl.model.client.RcplSession;
import org.eclipse.rcpl.model_2_0_0.rcpl.RCPL;

import javafx.collections.ObservableList;
import javafx.geometry.Rectangle2D;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;

/**
 * @author ramin
 * 
 */
public class Rcpl implements RcplConstants {

	public enum ResourceType {
		IMAGE, SVG
	}

	private IRcplFactory factory;

	private IToolFactory toolFactory;

	private IServiceFactory serviceFactory;

	private IService service;

	private IResources resources;

	private IColorProvider colorProvider;

	private IFontProvider fontProvider;

	private HashMap<String, String> pathRegistry = new HashMap<String, String>();

	private boolean mobile;

	private Throwable runtimeException;

	private List<INavigatorListener> navigatorListeners = new ArrayList<INavigatorListener>();

	private HashMap<Screen, IMonitor> monitors = new HashMap<Screen, IMonitor>();

	private IStyleTemplate globalStyleTemplate;

	private IRcplUic UIC;

	private IRcplApplicationProvider rcplApplicationProvider;

	private ITopToolbar topToolbar;

	private long lastUserActivity;

	private ITopTools browserTopTools;

	private ITextable browserAddressField;

	private List<IEditorListener> editorListeners = new ArrayList<IEditorListener>();

	private List<ILocalable> localables = new ArrayList<ILocalable>();

	private IMonitor actualMonitor;

	private double physicalWidth;

	private Boolean bigDisplay;

	private static Rcpl INSTANCE;

	private static String createKeyValuePath(EnKeyValue key) {
		return key.getFolder().name();
	}

	private static String createKeyValuePath(EnKeyValue key, IEditor editor) {
		return key.getFolder() + "/" + editor.getDocument().getFile().getName();
	}

	public static void deleteAllValues(String path, EnKeyValue key) {
		RcplSession.getDefault().deleteAllValues(path, key.name());
	}

	public static Rcpl get() {
		if (INSTANCE == null) {
			INSTANCE = new Rcpl();
		}
		return INSTANCE;
	}

	public static String get(EnKeyValue key) {
		return RcplSession.getDefault().getValue(createKeyValuePath(key), key.name());
	}

	public static boolean get(EnKeyValue key, boolean defaultValue) {
		String value = get(key, "" + defaultValue);
		try {
			return Boolean.valueOf(value).booleanValue();
		} catch (Exception ex) {
			return defaultValue;
		}
	}

	public static double get(EnKeyValue key, double defaultValue) {
		String value = get(key, "" + defaultValue);
		try {
			return Double.valueOf(value).doubleValue();
		} catch (Exception ex) {
			return defaultValue;
		}
	}

	public static int get(EnKeyValue key, int defaultValue) {
		String value = get(key, "" + defaultValue);
		try {
			return Integer.valueOf(value).intValue();
		} catch (Exception ex) {
			return defaultValue;
		}
	}

	public static String get(EnKeyValue key, String defaultValue) {
		String value = get(key);
		if (value == null) {
			value = defaultValue;
		}
		return value;
	}

	public static boolean get(IEditor editor, EnKeyValue key, boolean defaultValue) {
		String value = get(editor, key, "" + defaultValue);
		try {
			return Boolean.valueOf(value).booleanValue();
		} catch (Exception ex) {
			return defaultValue;
		}
	}

	public static double get(IEditor editor, EnKeyValue key, double defaultValue) {
		String value = get(editor, key, "" + defaultValue);
		try {
			return Double.valueOf(value).doubleValue();
		} catch (Exception ex) {
			return defaultValue;
		}
	}

	public static int get(IEditor editor, EnKeyValue key, int defaultValue) {
		String value = get(editor, key, "" + defaultValue);
		try {
			return Integer.valueOf(value).intValue();
		} catch (Exception ex) {
			return defaultValue;
		}
	}

	public static String get(IEditor editor, EnKeyValue key, String defaultValue) {
		String value = null;
		if (editor != null && editor.getDocument() != null && editor.getDocument().getFile() != null) {
			String path = createKeyValuePath(key, editor);
			value = RcplSession.getDefault().getValue(path, key.name());
		}
		if (value == null) {
			value = defaultValue;
		}
		return value;
	}

	public static RCPL getRcpl() {
		return RcplSession.getDefault().getRcpl();
	}

	// -----------------------------------------------

	public static String getWithIndex(EnKeyValue key, int index) {
		return RcplSession.getDefault().getValue(createKeyValuePath(key), key.name() + "_" + index);
	}

	/**
	 * 
	 * Nicht l�schen!!! (wird f�r dies Generierung des Ant gebraucht)
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

	}

	public static void set(EnKeyValue key, boolean value) {
		set(key, "" + value);
	}

	public static void set(EnKeyValue key, double value) {
		set(key, "" + value);
	}

	public static void set(EnKeyValue key, int value) {
		set(key, "" + value);
	}

	public static void set(EnKeyValue key, String value) {
		RcplSession.getDefault().putValue(key.getFolder().name() + "/", key.name(), value);
	}

	// private static final Logger LOGGER =
	// LoggerFactory.getLogger(OOXML.class);

	public static void set(IEditor editor, EnKeyValue key, boolean value) {
		set(editor, key, "" + value);
	}

	public static void set(IEditor editor, EnKeyValue key, double value) {
		set(editor, key, "" + value);
	}

	public static void set(IEditor editor, EnKeyValue key, int value) {
		set(editor, key, "" + value);
	}

	public static void set(IEditor editor, EnKeyValue key, String value) {
		if (editor != null && editor.getDocument() != null && editor.getDocument().getFile() != null) {
			String path = createKeyValuePath(key, editor);
			RcplSession.getDefault().putValue(path, key.name(), value == null ? "" : value);
		}
	}

	public static void setConfiguration() {

	}

	public void setWithIndex(EnKeyValue key, int index, String value) {
		RcplSession.getDefault().putValue(key.getFolder().name() + "/", key.name() + "_" + index, value);
	}

	public static IRcplUic UIC() {
		return get().UIC;
	}

	public void addNavigatorListener(INavigatorListener navigatorListener) {
		navigatorListeners.add(navigatorListener);
	}

	public IColorProvider colorProvider() {
		if (colorProvider == null) {
			colorProvider = factory.createColorProvider();
		}
		return colorProvider;
	}

	public void createProgress(StackPane progressGroup) {
	}

	public void dispose() {
		UIC.dispose();
		factory = null;
		toolFactory = null;
		serviceFactory = null;
		service = null;
		resources = null;
		colorProvider = null;
		fontProvider = null;
		pathRegistry.clear();
		runtimeException = null;
		navigatorListeners.clear();
		globalStyleTemplate = null;
		UIC = null;
		rcplApplicationProvider = null;
		topToolbar = null;
		browserTopTools = null;
		browserAddressField = null;
		editorListeners.clear();
		localables.clear();
	}

	public IFontProvider fontProvider() {
		if (fontProvider == null) {
			fontProvider = factory.createFontProvider();
		}
		return fontProvider;
	}

	public IMonitor geMainMonitor() {
		Rectangle2D r = new Rectangle2D(100, 100, 2, 2); // stage.getX(), stage.getY(), 2, 2);
		ObservableList<Screen> screens = Screen.getScreensForRectangle(r);
		if (screens.isEmpty()) {
			return monitors.values().iterator().next();
		}
		IMonitor m = monitors.get(screens.get(0));

		if (m != null) {
			return m;
		}
		Screen s = Screen.getPrimary();
		m = new RcplMonitor(s, 0);
		monitors.put(s, m);
		return m;

	}

	public IMonitor getActualMonitor() {
		Rectangle2D r = new Rectangle2D(100, 100, 2, 2); // stage.getX(), stage.getY(), 2, 2);
		ObservableList<Screen> screens = Screen.getScreensForRectangle(r);
		if (screens.isEmpty()) {
			return monitors.values().iterator().next();
		}
		IMonitor m = monitors.get(screens.get(0));

		if (m != null) {
			return m;
		}
		Screen s = Screen.getPrimary();
		m = new RcplMonitor(s, 0);
		monitors.put(s, m);
		return m;

//		Stage stage = rcplApplicationProvider.getPrimaryStage();
//		Rectangle2D r = new Rectangle2D(stage.getX(), stage.getY(), 2, 2);
//		ObservableList<Screen> screens = Screen.getScreensForRectangle(r);
//		if (screens.isEmpty()) {
//			return monitors.values().iterator().next();
//		}
//		IMonitor m = monitors.get(screens.get(0));
//
//		if (m != null) {
//			return m;
//		}
//		Screen s = Screen.getPrimary();
//		m = new RcplMonitor(s, 0);
//		Rcpl.monitors.put(s, m);
//		return m;
	}

	public IColorProvider getColorProvider() {
		if (colorProvider == null) {
			colorProvider = getFactory().createColorProvider();
		}
		return colorProvider;
	}

	public String getDefaultCssPath() {
		return "/css/";
	}

	public String getDefaultTemplatesPath() {
		return "/com/joffice/rcpl/addon/office/internal/templates/";
	}

	/**
	 * @return editor listeners
	 */
	public List<IEditorListener> getEditorListeners() {
		return editorListeners;
	}

	public IRcplFactory getFactory() {
		return factory;
	}

	public List<ILocalable> getLocalables() {
		return localables;
	}

	public String getPath(String key) {
		return pathRegistry.get(key);
	}

	// ---------- getValues

	public double getPhysicalWidth() {
		IMonitor m = getActualMonitor();
		if (actualMonitor != m) {
			physicalWidth = m.getPhysicalWidthInCm();
		}
		actualMonitor = m;
		return physicalWidth;
	}

	public IServiceFactory getServiceFactory() {
		return serviceFactory;
	}

	public IToolFactory getToolFactory() {
		return toolFactory;
	}

	public IStyleTemplate globalStyleTemplate() {
		if (globalStyleTemplate == null) {
			globalStyleTemplate = getFactory().createStyleTemplate();
		}
		return globalStyleTemplate;
	}

	public boolean isBigDisplay() {
		if (bigDisplay == null) {
			IMonitor m = monitors.get(Screen.getScreens().get(0));
			double w = m.getPhysicalWidthInCm();
			boolean b = w > 15;
			bigDisplay = Boolean.valueOf(b);
		}
		return bigDisplay.booleanValue();
	}

	public boolean isMobile() {
		return mobile;
	}

	public boolean isSmallDisplay() {
		return !isBigDisplay();
	}

	public void print(String msg) {
		if (DEBUG) {
			System.out.print(msg);
		}
	}

	public void printErrorln(String msg) {
		System.err.println(msg);
	}

	public void printErrorln(String msg, Throwable ex) {
		printErrorln(msg + ": " + ex.getMessage());
	}

	// ---------- set

	public void println(String msg) {
		if (DEBUG) {
			System.out.println(msg);
		}
	}

	public void progressMessage(Exception ex) {
		progressMessage(ex.getMessage());
	}

	public void progressMessage(final String message) {
		RcplModel.getMobileProvider().appendLog(message);
		progressMessage(message, 0);
	}

	public void progressMessage(final String message, long delay) {
	}

	/**
	 * @param key
	 * @param path
	 * @return true, if the path was registered, false if the there was a path
	 *         lready associated with the key, so that nothing was changed
	 * 
	 */
	public boolean registerPath(String key, String path) {
		if (!pathRegistry.containsKey(key)) {
			pathRegistry.put(key, path);
			return true;
		}
		return false;
	}

	public IResources resources() {
		if (resources == null) {
			resources = factory.createResources();
			RcplModel.resources = resources;
		}
		return resources;
	}

	public IService service() {
		if (service == null) {
			service = factory.createService();
		}
		return service;
	}

	public void setDebugText(String text) {
		UIC.setDebugText(text);
	}

	public void setFactory(IRcplFactory factory) {
		this.factory = factory;
	}

	public void setMobile(boolean mobile) {
		this.mobile = mobile;
	}

	public void setServiceFactory(IServiceFactory serviceFactory) {
		this.serviceFactory = serviceFactory;
	}

	// ---------- delete

	public void setToolFactory(IToolFactory toolFactory) {
		this.toolFactory = toolFactory;
	}

	public void setUIC(IRcplUic uIC) {
		UIC = uIC;
	}

	public void showProgress(final boolean show) {
	}

	public void startProgress(final double increment, final boolean showProgressBar) {
	}

	public ITopToolbar getTopToolbar() {
		return topToolbar;
	}

	public void setTopToolbar(ITopToolbar topToolbar) {
		this.topToolbar = topToolbar;
	}

	public IResources getResources() {
		return resources;
	}

	public void setResources(IResources resources) {
		this.resources = resources;
	}

	public IFontProvider getFontProvider() {
		return fontProvider;
	}

	public void setFontProvider(IFontProvider fontProvider) {
		this.fontProvider = fontProvider;
	}

	public HashMap<String, String> getPathRegistry() {
		return pathRegistry;
	}

	public void setPathRegistry(HashMap<String, String> pathRegistry) {
		this.pathRegistry = pathRegistry;
	}

	public Throwable getRuntimeException() {
		return runtimeException;
	}

	public void setRuntimeException(Throwable runtimeException) {
		this.runtimeException = runtimeException;
	}

	public List<INavigatorListener> getNavigatorListeners() {
		return navigatorListeners;
	}

	public void setNavigatorListeners(List<INavigatorListener> navigatorListeners) {
		this.navigatorListeners = navigatorListeners;
	}

	public HashMap<Screen, IMonitor> getMonitors() {
		return monitors;
	}

	public void setMonitors(HashMap<Screen, IMonitor> monitors) {
		this.monitors = monitors;
	}

	public IStyleTemplate getGlobalStyleTemplate() {
		return globalStyleTemplate;
	}

	public void setGlobalStyleTemplate(IStyleTemplate globalStyleTemplate) {
		this.globalStyleTemplate = globalStyleTemplate;
	}

	public IRcplApplicationProvider getRcplApplicationProvider() {
		return rcplApplicationProvider;
	}

	public void setRcplApplicationProvider(IRcplApplicationProvider rcplApplicationProvider) {
		this.rcplApplicationProvider = rcplApplicationProvider;
	}

	public long getLastUserActivity() {
		return lastUserActivity;
	}

	public void setLastUserActivity(long lastUserActivity) {
		this.lastUserActivity = lastUserActivity;
	}

	public ITopTools getBrowserTopTools() {
		return browserTopTools;
	}

	public void setBrowserTopTools(ITopTools browserTopTools) {
		this.browserTopTools = browserTopTools;
	}

	public ITextable getBrowserAddressField() {
		return browserAddressField;
	}

	public void setBrowserAddressField(ITextable browserAddressField) {
		this.browserAddressField = browserAddressField;
	}

	public Boolean getBigDisplay() {
		return bigDisplay;
	}

	public void setBigDisplay(Boolean bigDisplay) {
		this.bigDisplay = bigDisplay;
	}

	public void setColorProvider(IColorProvider colorProvider) {
		this.colorProvider = colorProvider;
	}

	public void setEditorListeners(List<IEditorListener> editorListeners) {
		this.editorListeners = editorListeners;
	}

	public void setLocalables(List<ILocalable> localables) {
		this.localables = localables;
	}

	public void setActualMonitor(IMonitor actualMonitor) {
		this.actualMonitor = actualMonitor;
	}

	public void setPhysicalWidth(double physicalWidth) {
		this.physicalWidth = physicalWidth;
	}

}
