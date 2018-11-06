package org.eclipse.rcpl;

/**
 * @author Ramin
 *
 */
public interface RcplConstants {

	static final boolean DEBUG = true;

	public static final String COPYRIGHT = "\u00a9";
	public static final String REGISTERED = "\u00ae";
	public static final String EURO = "\u20ac";

	// ===============================================================
	//
	// DATA BINDING KEYS
	//
	// ===============================================================

	public static String DBK_SECTION_VERTICAL_ALIGNMENT = "DBK_SECTION_VERTICAL_ALIGNMENT";

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

	public static final String OPEN_RECENTLY_OPENED_DOCUMENT = "actions/document/openRecentlyUsedDocument"; //$NON-NLS-1$

	public static final String CONTENT_TYPE_IMAGE_SVG = "image/svg"; //$NON-NLS-1$

	public static final String JO_TEMPLATE_VAR = "JOTEMPLATEVAR_"; //$NON-NLS-1$

	public static final String TEMPLATEVAR_1 = "TEMPLATEvAR1"; //$NON-NLS-1$

	// ---------- constants ----------------------------------------------------

	public static final int Z_ORDER_STEPS = 100000;

	// ---------- sound templates ----------------------------------------------

	public static final String SOUND_CLAVES = "claves"; //$NON-NLS-1$
	public static final String SOUND_CLICK = "click"; //$NON-NLS-1$

	// -------------------------------------------------------------------------

	public static int MAX_LAYOUT_NUMBER_IN_ONE_CYCLE = 1000000;

	public static boolean ACTIVATED_MODULE_VIEWER = false;
	public static boolean ACTIVATED_MODULE_EDITOR = true;

	public static final int TIMER_ANIMATION = 1;
	public static final int TIMER_SCROLL = 2;
	public static final int TIME_LAYOUT = 3;

	public final static int MAX_LOGINS = 100;

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

	public static final String MAIN_CONTENT_TYPE = "application/vnd.openxmlformats-officedocument.presentationml.presentation.main+xml"; //$NON-NLS-1$
	public static final String NOTES_CONTENT_TYPE = "application/vnd.openxmlformats-officedocument.presentationml.notesSlide+xml"; //$NON-NLS-1$
	public static final String SLIDE_CONTENT_TYPE = "application/vnd.openxmlformats-officedocument.presentationml.slide+xml"; //$NON-NLS-1$
	public static final String SLIDE_LAYOUT_RELATION_TYPE = "http://schemas.openxmlformats.org/officeDocument/2006/relationships/slideLayout"; //$NON-NLS-1$
	public static final String NOTES_RELATION_TYPE = "http://schemas.openxmlformats.org/officeDocument/2006/relationships/notesSlide"; //$NON-NLS-1$
	public static final String COMMENT_RELATION_TYPE = "http://schemas.openxmlformats.org/officeDocument/2006/relationships/comments"; //$NON-NLS-1$

}
