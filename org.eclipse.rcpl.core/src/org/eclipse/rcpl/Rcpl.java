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
public class Rcpl {

	private static boolean DEBUG = true;

	public static final String COPYRIGHT = "\u00a9";
	public static final String REGISTERED = "\u00ae";
	public static final String EURO = "\u20ac";

	// public static boolean APPLET = false;

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

	private static IStyleTemplate globalStyleTemplate;

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

	public static IRcplUic UIC;

	public static IRcplApplicationProvider rcplApplicationProvider;

	// public static JOSession session;
	//
	// public static JOMigration migration;

	// ===============================================================
	//
	// DATA BINDING KEYS
	//
	// ===============================================================

	public static String DBK_SECTION_VERTICAL_ALIGNMENT = "DBK_SECTION_VERTICAL_ALIGNMENT";

	// SWT

	public static final int TRAIL = 1 << 17;

	public static final int RIGHT = TRAIL;

	public static final int LEAD = 1 << 14;

	public static final int LEFT = LEAD;

	public static final int CENTER = 1 << 24;

	public static final int UP = 1 << 7;

	public static final int TOP = UP;

	public static final int DOWN = 1 << 10;

	public static final int BOTTOM = DOWN;

	public static final int NORMAL = 0;

	public final static String OBJECT_PLACEHOLDER = "\uFFFC"; //$NON-NLS-1$

	public static final int BOLD = 1 << 0;

	public static final int ITALIC = 1 << 1;

	public static final int UNDERLINE_SINGLE = 0;

	public static final int UNDERLINE_DOUBLE = 1;

	public static final int UNDERLINE_ERROR = 2;

	public static final int UNDERLINE_SQUIGGLE = 3;

	public static final int UNDERLINE_LINK = 4;

	// -----------------------------------------------

	public static ITopToolbar topToolbar;

	public static long lastUserActivity;

	public static ITopTools browserTopTools;

	public static ITextable browserAddressField;

	private static List<IEditorListener> editorListeners = new ArrayList<IEditorListener>();

	private static List<ILocalable> localables = new ArrayList<ILocalable>();

	/**
	 * @return editor listeners
	 */
	public static List<IEditorListener> getEditorListeners() {
		return editorListeners;
	}

	public static List<ILocalable> getLocalables() {
		return localables;
	}

	public static final String OPEN_RECENTLY_OPENED_DOCUMENT = "actions/document/openRecentlyUsedDocument"; //$NON-NLS-1$

	public static final String CONTENT_TYPE_IMAGE_SVG = "image/svg"; //$NON-NLS-1$

	public static String JO_TEMPLATE_VAR = "JOTEMPLATEVAR_"; //$NON-NLS-1$

	// ---------- tools --------------------------------------------------------

	public static int TOOL_SCHEMA_STANDARD = 0;
	public static int TOOL_SCHEMA_PROFESSIONAL = 1;
	public static int TOOL_SCHEMA_CUSTOM = 2;

	// public static int TOOL_URL_ADDRESS = 3;

	public static String TEMPLATEVAR_1 = "TEMPLATEvAR1"; //$NON-NLS-1$

	// ---------- constants ----------------------------------------------------

	public static final int Z_ORDER_STEPS = 100000;

	// ---------- sound templates ----------------------------------------------

	public static final String SOUND_CLAVES = "claves"; //$NON-NLS-1$
	public static final String SOUND_CLICK = "click"; //$NON-NLS-1$

	// ---------- tool keys ----------------------------------------------------

	public static final String TOOL_WORD_SHOW_GRID = "word/actions/editor/grid"; //$NON-NLS-1$
	public static final String TOOL_WORD_SHOW_PAGE_OUTLINE = "word/actions/editor/outline"; //$NON-NLS-1$
	public static final String TOOL_WORD_SHOW_PARAGRAPH_OUTLINE = "word/actions/paragraph/outline_paragraph"; //$NON-NLS-1$
	public static final String TOOL_INSERT_PARAGRAPH = "word/actions/editor/insert_paragraph"; //$NON-NLS-1$
	public static final String TOOL_SHOW_PICTURE_GROUP = "word/actions/editor/show_picture_group"; //$NON-NLS-1$
	public static final String TOOL_SHOW_TABLE_GROUP = "word/actions/editor/show_table_group"; //$NON-NLS-1$
	public static final String TOOL_SHOW_TEXTBOX_GROUP = "word/actions/editor/show_textbox_group"; //$NON-NLS-1$

	// -------------------------------------------------------------------------

	public static int MAX_LAYOUT_NUMBER_IN_ONE_CYCLE = 1000000;

	public static boolean ACTIVATED_MODULE_VIEWER = false;
	public static boolean ACTIVATED_MODULE_EDITOR = true;

	public static final int TIMER_ANIMATION = 1;
	public static final int TIMER_SCROLL = 2;
	public static final int TIME_LAYOUT = 3;

	public final static int MAX_LOGINS = 100;

	// private static final Logger LOGGER =
	// LoggerFactory.getLogger(OOXML.class);

	public static final String REGISTRY_ZOOM = "zoom"; //$NON-NLS-1$
	public static final String REGISTRY_AUTOMATIC_RESIZE = "automatic_resize"; //$NON-NLS-1$
	public static final String REGISTRY_TWO_PAGE_LAYOUT = "two_page_layout"; //$NON-NLS-1$
	public static final String REGISTRY_PARAGRAPH_LAYOUT_INFO = "pli"; //$NON-NLS-1$
	public static final String REGISTRY_PARAGRAPH_LAYOUT_SAVED = "pl_saved"; //$NON-NLS-1$
	public static final String REGISTRY_PRINT_OPTIONS_ALL_PAGES = "print_options_all_pages"; //$NON-NLS-1$
	public static final String REGISTRY_PRINT_OPTIONS_PAGE_RANGE_FROM = "print_options_PAGES_RANGE_FROM"; //$NON-NLS-1$
	public static final String REGISTRY_PRINT_OPTIONS_PAGE_RANGE_TO = "print_options_PAGES_RANGE_TO"; //$NON-NLS-1$

	public static final String REGISTRY_RECENTLY_USED_DOCUMENTS = "recentlyUsedDocument"; //$NON-NLS-1$
	public static final String REGISTRY_RECENTLY_BROWSED_URL = "recentlyBrowsedURL"; //$NON-NLS-1$
	public static final String REGISTRY_LAST_OPENED_BROWSER_TABS = "lastOpenBrowserTabs"; //$NON-NLS-1$
	public static final String REGISTRY_LAST_OPENED_BROWSER_TAB_INDEX = "lastOpenBrowserTabIndex"; //$NON-NLS-1$
	public static final String REGISTRY_BOOKMARK_URL = "bookmarkBrowsedURL"; //$NON-NLS-1$
	public static final String REGISTRY_FAVORITE_URL = "favoriteBrowsedURL"; //$NON-NLS-1$
	public static final String REGISTRY_PROPERTIES_MIGRATION = "propertiesMigration"; //$NON-NLS-1$
	public static final String REGISTRY_WEBSITE_LOGIN = "websiteLogin"; //$NON-NLS-1$

	public final static String TEMPLATE_WORD_TEMPLATE_DEFAULT = "TEMPLATE_WORD_TEMPLATE_DEFAULT"; //$NON-NLS-1$
	public final static String TEMPLATE_WORD_TEMPLATE_HEADERS = "TEMPLATE_WORD_TEMPLATE_HEADERS"; //$NON-NLS-1$

	public static final String PATH_TO_MEDIA_PARTS = "/word/media/"; //$NON-NLS-1$
	public static final String PATH_TO_PPT_SLIDE_PARTS = "/ppt/slides/"; //$NON-NLS-1$
	public static final String PATH_TO_PPT_SLIDE_MASTER_PARTS = "/ppt/slideMasters/"; //$NON-NLS-1$
	public static final String PATH_TO_PPT_THEME_PARTS = "/ppt/slideMasters/"; //$NON-NLS-1$
	public static final String PATH_TO_PPT_MEDIA_PARTS = "/ppt/slideMasters/"; //$NON-NLS-1$
	public static final String IMAGE_PART_NAME_PREFIX = "image"; //$NON-NLS-1$
	public static final String PROPERTY_SHELL_BOUNDS = "PROPERTY_SHELL_BOUNDS"; //$NON-NLS-1$

	// ---------- RELATION TYPES -----------------------------------------------

	public static final String RELATION_TYPE_IMAGE = "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image"; //$NON-NLS-1$
	public static final String RELATION_TYPE_SLIDE_LAYOUT = "http://schemas.openxmlformats.org/officeDocument/2006/relationships/slideLayout"; //$NON-NLS-1$
	public static final String RELATION_TYPE_SLIDE_MASTER = "http://schemas.openxmlformats.org/officeDocument/2006/relationships/slideMaster"; //$NON-NLS-1$
	public static final String THEME_RELATION_TYPE = "http://schemas.openxmlformats.org/officeDocument/2006/relationships/theme"; //$NON-NLS-1$

	// ---------- NAMESPACES ---------------------------------------------------

	public static final String NS_WORD = "http://schemas.openxmlformats.org/wordprocessingml/2006/main"; //$NON-NLS-1$
	public static final String NS_PICTURE = "http://schemas.openxmlformats.org/drawingml/2006/picture"; //$NON-NLS-1$
	public static final String NS_MS_VML = "urn:schemas-microsoft-com:vml"; //$NON-NLS-1$

	public static final String CORE_DOCUMENT_REL = "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument"; //$NON-NLS-1$
	public static final String TYPES_NAMESPACE_URI = "http://schemas.openxmlformats.org/package/2006/content-types"; //$NON-NLS-1$

	public final static String NAMESPACE_DC_URI = "http://purl.org/dc/elements/1.1/"; //$NON-NLS-1$

	public final static String NAMESPACE_CP_URI = "http://schemas.openxmlformats.org/package/2006/metadata/core-properties"; //$NON-NLS-1$

	public final static String NAMESPACE_DCTERMS_URI = "http://purl.org/dc/terms/"; //$NON-NLS-1$

	public final static String NAMESPACE_XSI_URI = "http://www.w3.org/2001/XMLSchema-instance"; //$NON-NLS-1$

	public final static String DOC_ENTRY_PAR_GROUP = "__g_"; //$NON-NLS-1$
	public final static String DOC_ENTRY_PAR_LIMITER = "__"; //$NON-NLS-1$
	public final static String DOC_ENTRY_PAR_PROFESSIONAL = "__p_"; //$NON-NLS-1$
	public final static String DOC_ENTRY_PAR_SEPARATOR = "__s_"; //$NON-NLS-1$
	public final static String DOC_ENTRY_PAR_LABEL = "__l_"; //$NON-NLS-1$
	public final static String DOC_ENTRY_PAR_INDEX = "__i_"; //$NON-NLS-1$
	public final static String DOC_ENTRY_PAR_WIDTH_1 = "__w1_"; //$NON-NLS-1$
	public final static String DOC_ENTRY_PAR_HEIGHT_1 = "__h1_"; //$NON-NLS-1$
	public final static String DOC_ENTRY_PAR_WIDTH_2 = "__w2_"; //$NON-NLS-1$
	public final static String DOC_ENTRY_PAR_HEIGHT_2 = "__h2_"; //$NON-NLS-1$

	public final static String DOC_ENTRY_PAR_WRAP = "__r_"; //$NON-NLS-1$
	public final static String DOC_ENTRY_PAR_TOGGEL = "__t_"; //$NON-NLS-1$
	public final static String DOC_ENTRY_PAR_MS_1 = "ms_"; //$NON-NLS-1$
	public final static String DOC_ENTRY_PAR_MS2 = "/ms_"; //$NON-NLS-1$
	public final static String DOC_ENTRY_PAR_TOOLTIP = "__tip_"; //$NON-NLS-1$
	public final static String DOC_ENTRY_PAR_PERSIST = "__persist_"; //$NON-NLS-1$
	public final static String DOC_ENTRY_PAR_TOOLTYPE = "__tooltype_"; //$NON-NLS-1$
	public final static String DOC_ENTRY_PAR_X = "__x_"; //$NON-NLS-1$
	public final static String DOC_ENTRY_PAR_Y = "__y_"; //$NON-NLS-1$
	public final static String DOC_ENTRY_PAR_IMAGE_NAME = "__image_"; //$NON-NLS-1$
	public final static String DOC_ENTRY_PAR_SUBGROUP = "__subgroup_"; //$NON-NLS-1$
	public final static String DOC_ENTRY_PAR_SPAN_HORIZONTAL = "__spanh_"; //$NON-NLS-1$
	public final static String DOC_ENTRY_PAR_MENUPARENT = "__menuparent_"; //$NON-NLS-1$
	public final static String DOC_ENTRY_PAR_SUBGROUPITEM = "__subgroupitem_"; //$NON-NLS-1$
	public final static String DOC_ENTRY_PAR_ITEMS = "__items_"; //$NON-NLS-1$
	public final static String DOC_ENTRY_PAR_ICONS = "__icons_"; //$NON-NLS-1$
	public final static String DOC_ENTRY_PAR_RADIOGROUP = "__radiogroup_"; //$NON-NLS-1$
	public final static String DOC_ENTRY_PAR_DOCUMENTPERSIST = "__documentpersist_"; //$NON-NLS-1$
	public final static String DOC_ENTRY_PAR_NOACTION = "__noaction_"; //$NON-NLS-1$
	public final static String DOC_ENTRY_PAR_FORCE_ACTION = "__forceaction_"; //$NON-NLS-1$
	public final static String DOC_ENTRY_PAR_hidden = "__hidden_"; //$NON-NLS-1$
	public final static String DOC_ENTRY_PAR_NOT_ECLIPSE = "__noteclipse_"; //$NON-NLS-1$
	public final static String DOC_ENTRY_PAR_NOT_ONLY_BROWSER = "__notonlybrowser_"; //$NON-NLS-1$

	public final static String DOC_ENTRY_PAR_TOOL_DIALOG_X = "__tx_"; //$NON-NLS-1$
	public final static String DOC_ENTRY_PAR_TOOL_DIALOG_Y = "__ty_"; //$NON-NLS-1$
	public final static String DOC_ENTRY_PAR_TOOL_DIALOG_W = "__tw_"; //$NON-NLS-1$
	public final static String DOC_ENTRY_PAR_TOOL_DIALOG_H = "__th_"; //$NON-NLS-1$

	public final static String DOC_ENTRY_PAR_DIALOG_W = "__tdw_"; //$NON-NLS-1$
	public final static String DOC_ENTRY_PAR_DIALOG_H = "__tdh_"; //$NON-NLS-1$
	public final static String DOC_ENTRY_PAR_X_OFFSET = "__xoffset_"; //$NON-NLS-1$
	public final static String DOC_ENTRY_PAR_LAYOUT = "__layout_"; //$NON-NLS-1$
	public final static String DOC_ENTRY_PAR_FILL_LAYOUT = "__filllayout_"; //$NON-NLS-1$
	public final static String DOC_ENTRY_PAR_FORCE_CREATION = "__forcecreation_"; //$NON-NLS-1$
	public final static String DOC_ENTRY_PAR_DATA_BINDING = "__databinding_"; //$NON-NLS-1$
	public final static String DOC_ENTRY_PAR_FORMATTING = "__formatting_"; //$NON-NLS-1$
	public final static String DOC_ENTRY_PAR_SHELFS = "__shelfs_"; //$NON-NLS-1$
	public final static String DOC_ENTRY_PAR_SHELF_ITEM = "__shelfitem_"; //$NON-NLS-1$
	public final static String DOC_ENTRY_PAR_ENUM = "__enum_"; //$NON-NLS-1$
	public final static String DOC_ENTRY_PAR_NO_COMMAND = "__nocommand_"; //$NON-NLS-1$
	public final static String DOC_ENTRY_PAR_SHOWGROUP = "__showgroup_"; //$NON-NLS-1$
	public final static String DOC_ENTRY_PAR_PERSIST_GLOBAL = "__persistglobal_"; //$NON-NLS-1$
	public final static String DOC_ENTRY_PAR_EXCLUDE_PRODUCTS = "__excludeproducts_"; //$NON-NLS-1$

	/**
	 * Content Types.
	 */
	public static final String CONTENT_TYPES = "http://schemas.openxmlformats.org/package/2006/content-types"; //$NON-NLS-1$

	/**
	 * Relationships.
	 */
	public static final String RELATIONSHIPS = "http://schemas.openxmlformats.org/package/2006/relationships"; //$NON-NLS-1$

	/**
	 * Markup Compatibility.
	 */
	public static final String MARKUP_COMPATIBILITY = "http://schemas.openxmlformats.org/markup-compatibility/2006"; //$NON-NLS-1$

	/**
	 * Core properties relationship type.
	 */
	String CORE_PROPERTIES = "http://schemas.openxmlformats.org/package/2006/relationships/metadata/core-properties"; //$NON-NLS-1$

	/**
	 * Digital signature relationship type.
	 */
	String DIGITAL_SIGNATURE = "http://schemas.openxmlformats.org/package/2006/relationships/digital-signature/signature"; //$NON-NLS-1$

	/**
	 * Digital signature certificate relationship type.
	 */
	String DIGITAL_SIGNATURE_CERTIFICATE = "http://schemas.openxmlformats.org/package/2006/relationships/digital-signature/certificate"; //$NON-NLS-1$

	/**
	 * Digital signature origin relationship type.
	 */
	String DIGITAL_SIGNATURE_ORIGIN = "http://schemas.openxmlformats.org/package/2006/relationships/digital-signature/origin"; //$NON-NLS-1$

	/**
	 * Thumbnail relationship type.
	 */
	String THUMBNAIL = "http://schemas.openxmlformats.org/package/2006/relationships/metadata/thumbnail"; //$NON-NLS-1$

	/**
	 * Extended properties relationship type.
	 */
	String EXTENDED_PROPERTIES = "http://schemas.openxmlformats.org/officeDocument/2006/relationships/extended-properties"; //$NON-NLS-1$

	/**
	 * Core properties relationship type.
	 */
	String CORE_DOCUMENT = "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument"; //$NON-NLS-1$

	/**
	 * Custom XML relationship type.
	 */
	String CUSTOM_XML = "http://schemas.openxmlformats.org/officeDocument/2006/relationships/customXml"; //$NON-NLS-1$

	/**
	 * Image type.
	 */
	String IMAGE_PART = "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image"; //$NON-NLS-1$

	/**
	 * Style type.
	 */
	String STYLE_PART = "http://schemas.openxmlformats.org/officeDocument/2006/relationships/styles"; //$NON-NLS-1$

	public static final String MAIN_CONTENT_TYPE = "application/vnd.openxmlformats-officedocument.presentationml.presentation.main+xml"; //$NON-NLS-1$
	public static final String NOTES_CONTENT_TYPE = "application/vnd.openxmlformats-officedocument.presentationml.notesSlide+xml"; //$NON-NLS-1$
	public static final String SLIDE_CONTENT_TYPE = "application/vnd.openxmlformats-officedocument.presentationml.slide+xml"; //$NON-NLS-1$
	public static final String SLIDE_LAYOUT_RELATION_TYPE = "http://schemas.openxmlformats.org/officeDocument/2006/relationships/slideLayout"; //$NON-NLS-1$
	public static final String NOTES_RELATION_TYPE = "http://schemas.openxmlformats.org/officeDocument/2006/relationships/notesSlide"; //$NON-NLS-1$
	public static final String COMMENT_RELATION_TYPE = "http://schemas.openxmlformats.org/officeDocument/2006/relationships/comments"; //$NON-NLS-1$
	// map.put("http://schemas.openxmlformats.org/drawingml/2006/main", "a");

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
		RcplModel.mobileProvider.appendLog(message);
		progressMessage(message, 0);
	}

	public static void progressMessage(final String message, long delay) {
	}

	public static void progressMessage(Exception ex) {
		progressMessage(ex.getMessage());
	}

	public static void showProgress(final boolean show) {
//		if (isProgressVisible == show) {
//			return;
//		}
//
//		isProgressVisible = show;
//
//		if (progressText != null) {
//
//			if (Platform.isFxApplicationThread()) {
//				progressText.setVisible(show);
//				progressBar.setVisible(show && showProgressBar);
//				progressIndicator.setVisible(show && !showProgressBar);
//				progressBar.toFront();
//				progressIndicator.toFront();
//				progressText.toFront();
//			} else {
//				Platform.runLater(new Runnable() {
//
//					@Override
//					public void run() {
//						progressText.setVisible(show);
//						progressBar.setVisible(show && showProgressBar);
//						progressIndicator.setVisible(show && !showProgressBar);
//						progressBar.toFront();
//						progressIndicator.toFront();
//						progressText.toFront();
//					}
//				});
//			}
//		}
	}

	public static void createProgress(StackPane progressGroup) {
//		if (progressText == null) {
//
//			progressText = new Text();
//			DropShadow ds = new DropShadow();
//			ds.setOffsetY(3.0f);
//			ds.setColor(Color.color(0.4f, 0.4f, 0.4f));
//
//			progressText.setEffect(ds);
//			progressText.setCache(true);
//			progressText.setFill(Color.CORNFLOWERBLUE);
//			progressText.setFont(Font.font(null, FontWeight.NORMAL, 24));
//
//			StackPane.setMargin(progressText, new Insets(130, 0, 0, 0));
//			task = new Task<Void>() {
//				@Override
//				public Void call() {
//					for (;;) {
//						try {
//							Thread.sleep(100);
//						} catch (InterruptedException e) {
//							e.printStackTrace();
//						}
//
//						updateProgress(progressValue, 130);
//						progressValue += progressIncrement / 10;
//						updateMessage(progressMessage);
//					}
//				}
//			};
//
//			progressText.textProperty().bind(task.messageProperty());
//			progressBar = new ProgressBar();
//			progressBar.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, null, null)));
//			progressBar.progressProperty().bind(task.progressProperty());
//			Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
//			progressBar.setMinWidth(bounds.getWidth() / 2);
//			progressBar.setPrefWidth(bounds.getWidth() / 2);
//			progressIndicator = new ProgressIndicator();
//			progressIndicator.progressProperty().bind(task.progressProperty());
//			double height = Screen.getPrimary().getBounds().getHeight() / 10;
//			progressIndicator.setMaxHeight(height);
//			progressIndicator.setMaxWidth(height);
//			int prio = Thread.currentThread().getPriority();
//			Thread t = new Thread(task);
//			t.setPriority(prio + 1);
//			t.setDaemon(true);
//			t.start();
//
//			progressGroup.getChildren().addAll(progressIndicator, progressBar, progressText);
//
//		}

	}

	public static boolean isMobile() {
		return mobile;
	}

	private static IMonitor actualMonitor;

	private static double physicalWidth;

	public static double getPhysicalWidth() {
		IMonitor m = getActualMonitor();
		if (actualMonitor != m) {
			physicalWidth = m.getPhysicalWidthInCm();
		}
		actualMonitor = m;
		return physicalWidth;
	}

	private static Boolean bigDisplay;

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
