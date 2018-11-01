/******************************************************************************
 *
 * Copyright (c) 2009 Ramin Assisi
 * All rights reserved.
 *
 ****************************************************************************/

package org.eclipse.rcpl;

/**
 * @author ramin
 * 
 */
public enum EnDocumentType {

	FOLDER(null, null),

	// ---------- categories ---------------------------------------------------

	CATEGORY_OFFICE(null, FOLDER),

	CATEGORY_RECENTLY_USED_DOCUMENT(null, FOLDER),

	CATEGORY_LINK(null, FOLDER),

	CATEGORY_OFFICE_TEMPLATE(null, FOLDER),

	CATEGORY_BROWSER_HISTORY(null, FOLDER),

	CATEGORY_BROWSER_BOOKMARKS(null, FOLDER),

	CATEGORY_BROWSER_FAVORITES(null, FOLDER),

	CATEGORY_WORDPROCESSING(null, FOLDER),

	CATEGORY_SPREADSHEET(null, FOLDER),

	CATEGORY_PRESENTATION(null, FOLDER),

	CATEGORY_FORMULA(null, FOLDER),

	CATEGORY_GRAPHIC(null, FOLDER),

	CATEGORY_MASTER(null, FOLDER), CATEGORY_URL(null, FOLDER),

	// ---------- documents ----------------------------------------------------

	// ---------- OOXML

	WORD("docx", CATEGORY_WORDPROCESSING), //$NON-NLS-1$

	SPREADSHEET("xlsx", CATEGORY_SPREADSHEET), //$NON-NLS-1$

	PRESENTATION("pptx", CATEGORY_PRESENTATION), //$NON-NLS-1$

	NUMBERING("", CATEGORY_OFFICE), //$NON-NLS-1$

	DRAWING("", CATEGORY_GRAPHIC), //$NON-NLS-1$

	SETTINGS("", CATEGORY_OFFICE), //$NON-NLS-1$

	SLIDE_LAYOUT("", CATEGORY_SPREADSHEET), //$NON-NLS-1$

	SLIDE_MASTER("", CATEGORY_SPREADSHEET), //$NON-NLS-1$

	// ---------- OPEN OFFICE

	OOTEXT("odt", CATEGORY_WORDPROCESSING), //$NON-NLS-1$

	OOFORMULA("odf", CATEGORY_FORMULA), //$NON-NLS-1$

	OOSPREADSHEET("ods", CATEGORY_SPREADSHEET), //$NON-NLS-1$

	OOGRAPHIC("odg", CATEGORY_GRAPHIC), //$NON-NLS-1$

	OOPRESENTATION("odp", CATEGORY_PRESENTATION), //$NON-NLS-1$

	OOMASTER("odm", CATEGORY_MASTER), //$NON-NLS-1$

	URL("html", CATEGORY_URL), //$NON-NLS-1$

	BROWSER("html", CATEGORY_URL),

	INFOTAB("infotab", CATEGORY_MASTER);

	private String extension;

	private EnDocumentType category;

	/**
	 * @param extension
	 * @param category
	 */
	private EnDocumentType(String extension, EnDocumentType category) {
		this.extension = extension;
		this.category = category;
	}

	/**
	 * @return
	 */
	public String getExtension() {
		return extension;
	}

	/**
	 * @return
	 */
	public String getDotExtension() {
		return "." + extension; //$NON-NLS-1$
	}

	/**
	 * @return
	 */
	public EnDocumentType getCategory() {
		return category;
	}

	/**
	 * @param ext
	 * @return
	 */
	public static EnDocumentType getType(String fName) {
		EnDocumentType[] types = values();
		for (EnDocumentType joDocumentType : types) {
			if (fName.toLowerCase().endsWith(joDocumentType.getDotExtension())) {
				return joDocumentType;
			}
		}
		return EnDocumentType.URL;
	}

	/**
	 * @param segment
	 * @return
	 */
	public static boolean isFolderSegment(String segment) {
		EnDocumentType[] types = values();
		for (EnDocumentType joDocumentType : types) {
			if (segment.startsWith(joDocumentType.name())) {
				return true;
			}
		}
		return false;
	}
}
