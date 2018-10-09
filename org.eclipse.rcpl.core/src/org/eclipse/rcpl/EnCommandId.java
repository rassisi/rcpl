package org.eclipse.rcpl;

/**
 * @author ramin
 *
 */
public enum EnCommandId {

	NO_COMMAND(EnServiceId.PARAGRAPH_SERVICE, null, "", "", null),

	NEW_WORD_DOCUMENT(EnServiceId.DOCUMENT_SERVICE, null, "", "", null),

	NEW_SpreadSheet_DOCUMENT(EnServiceId.DOCUMENT_SERVICE, null, "", "", null),

	NEW_PRESENTATION_DOCUMENT(EnServiceId.DOCUMENT_SERVICE, null, "", "", null),

	delete(EnServiceId.PICTURE_SERVICE, "delete", "", "", null),

	toFront(EnServiceId.PICTURE_SERVICE, "to_front", "", "", null),

	toBack(EnServiceId.PICTURE_SERVICE, "to_back", "", "", null),

	toFrontOneLevel(EnServiceId.PICTURE_SERVICE, "to_front_one_level", "", "", null),

	toBackOneLevel(EnServiceId.PICTURE_SERVICE, "to_back_one_level", "", "", null),

	showHLineal(EnServiceId.EDITOR_SERVICE, "h_lineal", "H", "H", null),

	showVLineal(EnServiceId.EDITOR_SERVICE, "v_lineal", "V", "V", null),

	showTwoPages(EnServiceId.LAYOUT_SERVICE, "two_pages", "", "Show two Pages", null),

	align_left(EnServiceId.PARAGRAPH_SERVICE, null, "", "Align Left", null),

	align_center(EnServiceId.PARAGRAPH_SERVICE, null, "", "Align Center", null),

	align_right(EnServiceId.PARAGRAPH_SERVICE, null, "", "Align Right", null),

	align_justify(EnServiceId.PARAGRAPH_SERVICE, null, "", "Align Justify", null),

	align_text_left(EnServiceId.PARAGRAPH_SERVICE, null, "", "Align Left", null),

	align_text_center(EnServiceId.PARAGRAPH_SERVICE, null, "", "Align Center", null),

	align_text_right(EnServiceId.PARAGRAPH_SERVICE, null, "", "Align Right", null),

	align_text_justify(EnServiceId.PARAGRAPH_SERVICE, null, "", "Align Justify", null),

	undo(EnServiceId.COMMAND_SERVICE, null, "Undo", "", null),

	redo(EnServiceId.COMMAND_SERVICE, null, "Redo", "", null),

	insertDrawing(EnServiceId.PICTURE_SERVICE, "image", "", "", null),

	insertTable(EnServiceId.TABLE_SERVICE, "table", "Insert Table", "Insert Table", null),

	insertTextbox(EnServiceId.INSERT_SERVICE, "textbox", "Insert Textbox", "Insert Textbox", null),

	textStyleListTool(EnServiceId.PARAGRAPH_SERVICE, null, "", "", null),

	foregroundColor(EnServiceId.COLOR_SERVICE, "color", "", "Foreground Color", null),

	backgroundColor(EnServiceId.COLOR_SERVICE, "color", "", "Background Color", null),

	fontName(EnServiceId.PARAGRAPH_SERVICE, null, "", "Font Name", null),

	fontSize(EnServiceId.PARAGRAPH_SERVICE, null, "", "Font Size", null),

	bold(EnServiceId.PARAGRAPH_SERVICE, null, "", "Bold", null),

	italic(EnServiceId.PARAGRAPH_SERVICE, null, "", "Italic", null),

	underline(EnServiceId.PARAGRAPH_SERVICE, null, "", "Underline", null),

	strikethrough(EnServiceId.PARAGRAPH_SERVICE, null, "", "Strikethrough", null),

	showStartMenu(EnServiceId.PARAGRAPH_SERVICE, null, "", "", null),

	layout(EnServiceId.LAYOUT_SERVICE, null, "", "", null),

	layoutPages(EnServiceId.LAYOUT_SERVICE, null, "", "", null),

	showRulers(EnServiceId.PARAGRAPH_SERVICE, null, "", "", null),

	characterStyle(EnServiceId.PARAGRAPH_SERVICE, null, "", "", null),

	collapse_all(EnServiceId.PARAGRAPH_SERVICE, null, "", "", null),

	USE_CASE(EnServiceId.PARAGRAPH_SERVICE, null, "", "", null),

	showOutline(EnServiceId.PARAGRAPH_SERVICE, "paragraph", "", "Show Outline", null),

	updateParagraph(EnServiceId.PARAGRAPH_SERVICE, null, "", "", null),

	expandAfter(EnServiceId.PARAGRAPH_SERVICE, null, "", "", null),

	expandBefore(EnServiceId.PARAGRAPH_SERVICE, null, "", "", null),

	splitParagraph(EnServiceId.PARAGRAPH_SERVICE, null, "", "", null),

	setStyle(EnServiceId.PARAGRAPH_SERVICE, null, "", "", null),

	INSERT_PARAGRAPH(EnServiceId.PARAGRAPH_SERVICE, null, "", "", null),

	insertText(EnServiceId.PARAGRAPH_SERVICE, null, "", "", null),

	style_normal(EnServiceId.PARAGRAPH_SERVICE, null, "N", "Normal", null),

	style_title(EnServiceId.PARAGRAPH_SERVICE, null, "T", "Title", null),

	style_heading_1(EnServiceId.PARAGRAPH_SERVICE, null, "H1", "Header 1", null),

	style_heading_2(EnServiceId.PARAGRAPH_SERVICE, null, "H2", "Header 2", null),

	style_heading_3(EnServiceId.PARAGRAPH_SERVICE, null, "H3", "Header 3", null),

	style_heading_4(EnServiceId.PARAGRAPH_SERVICE, null, "H4", "Header 4", null),

	style_heading_5(EnServiceId.PARAGRAPH_SERVICE, null, "H5", "Header 5", null),

	zoom_in(EnServiceId.EDITOR_SERVICE, null, "Zoom In", "Zoom In", null),

	zoom_out(EnServiceId.EDITOR_SERVICE, null, "Zoom out", "Zoom out", null),

	select(EnServiceId.EDITOR_SERVICE, null, "Select", "Select", null),

	showTools(EnServiceId.EDITOR_SERVICE, "tools", "Show Tools", "Show Tools", null),

	editMode(EnServiceId.EDITOR_SERVICE, "edit", "Edit Mode", "Edit Mode", null),

	save(EnServiceId.EDITOR_SERVICE, null, "Save", "Save", null),

	save_as(EnServiceId.EDITOR_SERVICE, null, "Save", "Save As...", null),

	OPEN_DOCUMENT(EnServiceId.EDITOR_SERVICE, "open", "Open Document", "Open Document...", null),

	open_last_document(EnServiceId.EDITOR_SERVICE, null, "Open Last Document", "Open Last Document", null),

	test_layout(EnServiceId.EDITOR_SERVICE, "setup", "Test Layout", "Test Layout", null),

	test_z_order(EnServiceId.EDITOR_SERVICE, "setup", "Test Z-Order", "Test Z-Order", null),

	// ---------- TABLES --------------------------------------

	tableInsertRowsAbove(EnServiceId.TABLE_SERVICE, null, "", "", null),

	tableInsertRowsBelow(EnServiceId.TABLE_SERVICE, null, "", "", null),

	tableInsertColumnsLeft(EnServiceId.TABLE_SERVICE, null, "", "", null),

	tableInsertColumnsRight(EnServiceId.TABLE_SERVICE, null, "", "", null),

	tableDeleteCells(EnServiceId.TABLE_SERVICE, null, "", "", null),

	tableDeleteColumns(EnServiceId.TABLE_SERVICE, null, "", "", null),

	tableDeleteRows(EnServiceId.TABLE_SERVICE, null, "", "", null),

	tableDeleteTable(EnServiceId.TABLE_SERVICE, null, "", "", null),

	tableMergeCells(EnServiceId.TABLE_SERVICE, null, "", "", null),

	tableSplitCells(EnServiceId.TABLE_SERVICE, null, "", "", null),

	insertNewEquation(EnServiceId.PARAGRAPH_SERVICE, "equations", "", "Insert A New Equation As Text", null),

	insertNewEquationAsImage(EnServiceId.PARAGRAPH_SERVICE, "images", "", "Insert a New Equation As Image", null),

	insertNewEquationAsTextbox(EnServiceId.INSERT_SERVICE, "equations", "", "Insert a New Equation As Textbox", null),

	insertNewEquationAsTextboxImage(EnServiceId.INSERT_SERVICE, "images", "Insert a New Equation As Textbox (Image)",
			"Insert a New Equation As Textbox (Image)", null),

	resetEquation(EnServiceId.INSERT_SERVICE, "delete", "Reset", "Reset", null),

	insertLatex(EnServiceId.PARAGRAPH_SERVICE, null, "", null, null),

	;

	private final String image;
	private final String displayName;
	private final String toolTip;
	private final EnServiceId serviceId;
	private Object data;

	EnCommandId(EnServiceId serviceId, String image, String displayName, String toolTip, Object data) {

		this.image = image;
		this.displayName = displayName;
		this.toolTip = toolTip;
		this.serviceId = serviceId;
		this.data = data;
	}

	public String getDisplayName() {
		if (displayName == null) {
			return getId();
		}
		return displayName;
	}

	public String getId() {
		return name();
	}

	public String getImage() {
		if (image == null) {
			return getId();
		}
		return image;
	}

	public String getToolTip() {
		if (toolTip == null) {
			return getId();
		}
		return toolTip;
	}

	public EnServiceId getServiceId() {
		return serviceId;
	}

	public static EnCommandId findCommandId(String id) {
		for (EnCommandId e : EnCommandId.values()) {
			String enId = e.getId();
			if (id.equals(enId)) {
				return e;
			}
		}
		return EnCommandId.NO_COMMAND;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
