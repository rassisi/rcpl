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

	private static IRcplFactory factory;

	private static IToolFactory toolFactory;

	private static IServiceFactory serviceFactory;

	private static IService service;

	private static IResources resources;

	private static IColorProvider colorProvider;

	private static IFontProvider fontProvider;

	private static HashMap<String, String> pathRegistry = new HashMap<String, String>();

	private static boolean mobile;

	public static Throwable runtimeException;

	public static List<INavigatorListener> navigatorListeners = new ArrayList<INavigatorListener>();

	public static HashMap<Screen, IMonitor> monitors = new HashMap<Screen, IMonitor>();

	private static IStyleTemplate globalStyleTemplate;

	public static IRcplUic UIC;

	public static IRcplApplicationProvider rcplApplicationProvider;

	// -----------------------------------------------

	public static ITopToolbar topToolbar;

	public static long lastUserActivity;

	public static ITopTools browserTopTools;

	public static ITextable browserAddressField;

	private static List<IEditorListener> editorListeners = new ArrayList<IEditorListener>();

	private static List<ILocalable> localables = new ArrayList<ILocalable>();

	// private static final Logger LOGGER =
	// LoggerFactory.getLogger(OOXML.class);

	private static IMonitor actualMonitor;

	private static double physicalWidth;

	private static Boolean bigDisplay;

	public static void clear() {
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
//		UIC = null;
		rcplApplicationProvider = null;
		topToolbar = null;
		browserTopTools = null;
		browserAddressField = null;
		editorListeners.clear();
		localables.clear();
	}

	public static void addNavigatorListener(INavigatorListener navigatorListener) {
		navigatorListeners.add(navigatorListener);
	}

	public static IMonitor getActualMonitor() {
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
		Rcpl.monitors.put(s, m);
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

	public static IMonitor geMainMonitor() {
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
		Rcpl.monitors.put(s, m);
		return m;

	}

	public static IService service() {
		if (service == null) {
			service = factory.createService();
		}
		return service;
	}

	public static IResources resources() {
		if (resources == null) {
			resources = factory.createResources();
			RcplModel.resources = resources;
		}
		return resources;
	}

	public static IColorProvider colorProvider() {
		if (colorProvider == null) {
			colorProvider = factory.createColorProvider();
		}
		return colorProvider;
	}

	public static IStyleTemplate globalStyleTemplate() {
		if (globalStyleTemplate == null) {
			globalStyleTemplate = getFactory().createStyleTemplate();
		}
		return globalStyleTemplate;
	}

	public static IFontProvider fontProvider() {
		if (fontProvider == null) {
			fontProvider = factory.createFontProvider();
		}
		return fontProvider;
	}

	/**
	 * @return editor listeners
	 */
	public static List<IEditorListener> getEditorListeners() {
		return editorListeners;
	}

	public static List<ILocalable> getLocalables() {
		return localables;
	}

	public enum ResourceType {
		IMAGE, SVG
	}

	/**
	 * 
	 * Nicht l�schen!!! (wird f�r dies Generierung des Ant gebraucht)
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

	}

	public static void println(String msg) {
		if (DEBUG) {
			System.out.println(msg);
		}
	}

	public static void print(String msg) {
		if (DEBUG) {
			System.out.print(msg);
		}
	}

	public static void printErrorln(String msg) {
		System.err.println(msg);
	}

	public static void printErrorln(String msg, Throwable ex) {
		printErrorln(msg + ": " + ex.getMessage());
	}

	public static void setDebugText(String text) {
		UIC.setDebugText(text);
	}

	/**
	 * @param key
	 * @param path
	 * @return true, if the path was registered, false if the there was a path
	 *         lready associated with the key, so that nothing was changed
	 * 
	 */
	public static boolean registerPath(String key, String path) {
		if (!pathRegistry.containsKey(key)) {
			pathRegistry.put(key, path);
			return true;
		}
		return false;
	}

	public static String getPath(String key) {
		return pathRegistry.get(key);
	}

	public static String getDefaultTemplatesPath() {
		return "/com/joffice/rcpl/addon/office/internal/templates/";
	}

	public static String getDefaultCssPath() {
		return "/css/";
	}

	public static void startProgress(final double increment, final boolean showProgressBar) {
	}

	public static void progressMessage(final String message) {
		RcplModel.getMobileProvider().appendLog(message);
		progressMessage(message, 0);
	}

	public static void progressMessage(final String message, long delay) {
	}

	public static void progressMessage(Exception ex) {
		progressMessage(ex.getMessage());
	}

	public static void showProgress(final boolean show) {
	}

	public static void createProgress(StackPane progressGroup) {
	}

	public static boolean isMobile() {
		return mobile;
	}

	public static double getPhysicalWidth() {
		IMonitor m = getActualMonitor();
		if (actualMonitor != m) {
			physicalWidth = m.getPhysicalWidthInCm();
		}
		actualMonitor = m;
		return physicalWidth;
	}

	public static boolean isBigDisplay() {
		if (bigDisplay == null) {
			IMonitor m = monitors.get(Screen.getScreens().get(0));
			double w = m.getPhysicalWidthInCm();
			boolean b = w > 15;
			bigDisplay = Boolean.valueOf(b);
		}
		return bigDisplay.booleanValue();
	}

	public static boolean isSmallDisplay() {
		return !isBigDisplay();
	}

	public static void setMobile(boolean mobile) {
		Rcpl.mobile = mobile;
	}

	public static IRcplFactory getFactory() {
		return factory;
	}

	public static void setFactory(IRcplFactory factory) {
		Rcpl.factory = factory;
	}

	public static IToolFactory getToolFactory() {
		return toolFactory;
	}

	public static IServiceFactory getServiceFactory() {
		return serviceFactory;
	}

	public static void setToolFactory(IToolFactory toolFactory) {
		Rcpl.toolFactory = toolFactory;
	}

	public static void setServiceFactory(IServiceFactory serviceFactory) {
		Rcpl.serviceFactory = serviceFactory;
	}

	public static void fxSleep() {
		try {
			Thread.sleep(0, 100);
		} catch (InterruptedException e) {
		}
	}

	public static void setConfiguration() {

	}

	// ---------- getValues

	public static double get(IEditor editor, EnKeyValue key, double defaultValue) {
		String value = get(editor, key, "" + defaultValue);
		try {
			return Double.valueOf(value).doubleValue();
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

	public static int get(IEditor editor, EnKeyValue key, int defaultValue) {
		String value = get(editor, key, "" + defaultValue);
		try {
			return Integer.valueOf(value).intValue();
		} catch (Exception ex) {
			return defaultValue;
		}
	}

	public static boolean get(EnKeyValue key, boolean defaultValue) {
		String value = get(key, "" + defaultValue);
		try {
			return Boolean.valueOf(value).booleanValue();
		} catch (Exception ex) {
			return defaultValue;
		}
	}

	public static boolean get(IEditor editor, EnKeyValue key, boolean defaultValue) {
		String value = get(editor, key, "" + defaultValue);
		try {
			return Boolean.valueOf(value).booleanValue();
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

	public static String get(EnKeyValue key, String defaultValue) {
		String value = get(key);
		if (value == null) {
			value = defaultValue;
		}
		return value;
	}

	public static String get(EnKeyValue key) {
		return RcplSession.getDefault().getValue(createKeyValuePath(key), key.name());
	}

	public static String getWithIndex(EnKeyValue key, int index) {
		return RcplSession.getDefault().getValue(createKeyValuePath(key), key.name() + "_" + index);
	}

	// ---------- set

	public static void set(IEditor editor, EnKeyValue key, String value) {
		if (editor != null && editor.getDocument() != null && editor.getDocument().getFile() != null) {
			String path = createKeyValuePath(key, editor);
			RcplSession.getDefault().putValue(path, key.name(), value == null ? "" : value);
		}
	}

	public static void set(EnKeyValue key, int value) {
		set(key, "" + value);
	}

	public static void set(IEditor editor, EnKeyValue key, int value) {
		set(editor, key, "" + value);
	}

	public static void set(IEditor editor, EnKeyValue key, double value) {
		set(editor, key, "" + value);
	}

	public static void set(EnKeyValue key, double value) {
		set(key, "" + value);
	}

	public static void set(EnKeyValue key, boolean value) {
		set(key, "" + value);
	}

	public static void set(IEditor editor, EnKeyValue key, boolean value) {
		set(editor, key, "" + value);
	}

	public static void set(EnKeyValue key, String value) {
		RcplSession.getDefault().putValue(key.getFolder().name() + "/", key.name(), value);
	}

	public static void setWithIndex(EnKeyValue key, int index, String value) {
		RcplSession.getDefault().putValue(key.getFolder().name() + "/", key.name() + "_" + index, value);
	}

	private static String createKeyValuePath(EnKeyValue key) {
		return key.getFolder().name();
	}

	private static String createKeyValuePath(EnKeyValue key, IEditor editor) {
		return key.getFolder() + "/" + editor.getDocument().getFile().getName();
	}

	// ---------- delete

	public static void deleteAllValues(String path, EnKeyValue key) {
		RcplSession.getDefault().deleteAllValues(path, key.name());
	}

	public static RCPL getRcpl() {
		return RcplSession.getDefault().getRcpl();
	}

}
