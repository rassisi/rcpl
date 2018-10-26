package org.eclipse.rcpl.model;

public enum EnKeyValue {

	// ---------- WINDOW

	WINDOW_WIDTH(EnKeyValueFolder.WINDOW),

	WINDOW_HEIGHT(EnKeyValueFolder.WINDOW),

	WINDOW_X(EnKeyValueFolder.WINDOW),

	WINDOW_Y(EnKeyValueFolder.WINDOW),

	LOGIN_WINDOW_X(EnKeyValueFolder.WINDOW),

	LOGIN_WINDOW_Y(EnKeyValueFolder.WINDOW),

	SIDEBAR_LEFT(EnKeyValueFolder.WINDOW),

	THEME(EnKeyValueFolder.WINDOW),

	// ---------- HISTORY

	LAST_OPENED_DOCUMENT(EnKeyValueFolder.HISTORY),

	RECENT_DOCUMENT(EnKeyValueFolder.HISTORY),

	WORKING_DIR(EnKeyValueFolder.HISTORY),

	// ---------- EDITOR

	PAGE_COLUMNS(EnKeyValueFolder.EDITOR),

	SIDEBAR_PATH(EnKeyValueFolder.EDITOR),

	EDITOR_SCALE(EnKeyValueFolder.EDITOR),

	SHOW_EDITOR_TOOLS(EnKeyValueFolder.EDITOR),

	SHOW_OUTLINE(EnKeyValueFolder.EDITOR),

	SHOW_V_LINEAL(EnKeyValueFolder.EDITOR),

	SHOW_H_LINEAL(EnKeyValueFolder.EDITOR),

	TOP_TOOLBAR_COLLAPSED(EnKeyValueFolder.EDITOR),

	;

	private EnKeyValueFolder folder;

	private EnKeyValue(EnKeyValueFolder folder) {
		this.folder = folder;
	}

	public EnKeyValueFolder getFolder() {
		return folder;
	}

}
