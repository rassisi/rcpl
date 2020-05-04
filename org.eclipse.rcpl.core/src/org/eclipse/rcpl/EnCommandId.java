package org.eclipse.rcpl;

/**
 * @author ramin
 *
 */
public enum EnCommandId {

	PARAGRAPH_STYLELIST(EnServiceId.PARAGRAPH_SERVICE, null, "", "", null),

	PAGE_SIZE(EnServiceId.PAGE_SERVICE, null, "", "", null),

	PAGE_LANDSCAPE(EnServiceId.PAGE_SERVICE, null, "", "", null),

	PAGE_PORTRAIT(EnServiceId.PAGE_SERVICE, null, "", "", null),

	PAGE_WIDTH(EnServiceId.PAGE_SERVICE, null, "", "", null),

	PAGE_HEIGHT(EnServiceId.PAGE_SERVICE, null, "", "", null),

	DOCUMENT_NEWWORD(EnServiceId.DOCUMENT_SERVICE, null, "", "", null),

	DOCUMENT_NEWSPREADSHEET(EnServiceId.DOCUMENT_SERVICE, null, "", "", null),

	DOCUMENMT_NEWPRESENTATION(EnServiceId.DOCUMENT_SERVICE, null, "", "", null),

	PICTURE_DELETE(EnServiceId.PICTURE_SERVICE, "delete", "", "", null),

	PICTURE_TOFRONT(EnServiceId.PICTURE_SERVICE, "to_front", "", "", null),

	PICTURE_TOBACK(EnServiceId.PICTURE_SERVICE, "to_back", "", "", null),

	PICTURE_TOFRONTONELEVEL(EnServiceId.PICTURE_SERVICE, "to_front_one_level", "", "", null),

	PICTURE_TOBACKONELEVEL(EnServiceId.PICTURE_SERVICE, "to_back_one_level", "", "", null),

	EDITOR_SHOWHLINEAL(EnServiceId.EDITOR_SERVICE, "h_lineal", "H", "H", null),

	EDITOE_SHOWVLINEAL(EnServiceId.EDITOR_SERVICE, "v_lineal", "V", "V", null),

	LAYOUT_SHOWTWOPAGES(EnServiceId.LAYOUT_SERVICE, "two_pages", "", "Show two Pages", null),

	PARAGRAPH_ALIGNLEFT(EnServiceId.PARAGRAPH_SERVICE, null, "", "Align Left", null),

	PARAGRAPH_ALIGNCENTER(EnServiceId.PARAGRAPH_SERVICE, null, "", "Align Center", null),

	PARAGRAPH_ALIGNRIGHT(EnServiceId.PARAGRAPH_SERVICE, null, "", "Align Right", null),

	PARAGRAPH_ALIGNJUSTIFY(EnServiceId.PARAGRAPH_SERVICE, null, "", "Align Justify", null),

	PARAGRAPH_ALIGNTEXTLEFT(EnServiceId.PARAGRAPH_SERVICE, null, "", "Align Left", null),

	PARAGRAPH_ALIGNTEXTCENTER(EnServiceId.PARAGRAPH_SERVICE, null, "", "Align Center", null),

	PARAGRAPH_ALIGNTEXTRIGHT(EnServiceId.PARAGRAPH_SERVICE, null, "", "Align Right", null),

	PARAGRAPH_ALIGNTEXTJUSTIFIED(EnServiceId.PARAGRAPH_SERVICE, null, "", "Align Justified", null),

	PARAGRAPH_ALIGNHORIZONTALCENTER(EnServiceId.PARAGRAPH_SERVICE, null, "", "Align Horizontal Center", null),

	PARAGRAPH_ALIGN_VERTICALCENTER(EnServiceId.PARAGRAPH_SERVICE, null, "", "Align Vertical Center", null),

	PARAGRAPH_DISTRIBUTELEFT(EnServiceId.PARAGRAPH_SERVICE, null, "", "Align Vertical Center", null),

	PARAGRAPH_DISTRIBUTEHORIZONTALCENTER(EnServiceId.PARAGRAPH_SERVICE, null, "", "Align Vertical Center", null),

	PARAGRAPH_DISTRIBUTERIGHT(EnServiceId.PARAGRAPH_SERVICE, null, "", "Align Vertical Center", null),

	PARAGRAPH_DISTRIBUTEHORIZONTALGAPS(EnServiceId.PARAGRAPH_SERVICE, null, "", "Align Vertical Center", null),

	PARAGRAPH_DISTRIBUTERANDOM(EnServiceId.PARAGRAPH_SERVICE, null, "", "Align Vertical Center", null),

	PARAGRAPH_DISTRIBUTETOP(EnServiceId.PARAGRAPH_SERVICE, null, "", "Align Vertical Center", null),

	PARAGRAPH_DISTRIBUTEVERTICALCENTER(EnServiceId.PARAGRAPH_SERVICE, null, "", "Align Vertical Center", null),

	PARAGRAPH_DISTRIBUTEBOTTOM(EnServiceId.PARAGRAPH_SERVICE, null, "", "Align Vertical Center", null),

	PARAGRAPH_DISTRIBUTEVERTICALGAPS(EnServiceId.PARAGRAPH_SERVICE, null, "", "Align Vertical Center", null),

	PARAGRAPH_ROTATE90ANTICLOCKWISE(EnServiceId.PARAGRAPH_SERVICE, null, "", "Align Vertical Center", null),

	PARAGRAPH_ROTATE90CLOCKWISE(EnServiceId.PARAGRAPH_SERVICE, null, "", "Align Vertical Center", null),

	PARAGRAPH_FLIPHORIZONTAL(EnServiceId.PARAGRAPH_SERVICE, null, "", "Align Vertical Center", null),

	PARAGRAPH_FLIPVERTICAL(EnServiceId.PARAGRAPH_SERVICE, null, "", "Align Vertical Center", null),

	PARAGRAPH_INCREASEINDENT(EnServiceId.PARAGRAPH_SERVICE, null, "", "Align Justified", null),

	PARAGRAPH_DECREASEINDENT(EnServiceId.PARAGRAPH_SERVICE, null, null, "Align Justified", null),

	PARAGRAPH_CHANGECASE(EnServiceId.PARAGRAPH_SERVICE, null, null, "Align Justified", null),

	PARAGRAPH_BULLETS(EnServiceId.PARAGRAPH_SERVICE, null, "", "Bullets", null),

	PARAGRAPH_BORDER(EnServiceId.PARAGRAPH_SERVICE, null, "", "Border", null),

	PARAGRAPH_LINEWIDTH(EnServiceId.PARAGRAPH_SERVICE, null, "", "Line Width", null),

	PARAGRAPH_LINEARROWS(EnServiceId.PARAGRAPH_SERVICE, null, "", "Line Arrows", null),

	PARAGRAPH_LINEDASHES(EnServiceId.PARAGRAPH_SERVICE, null, "", "Line Type", null),

	PARAGRAPH_PATTERN(EnServiceId.PARAGRAPH_SERVICE, null, "", "Pattern", null),

	PARAGRAPH_LINESPACING(EnServiceId.PARAGRAPH_SERVICE, null, "", "Line Spacing", null),

	COMMAND_UNDO(EnServiceId.COMMAND_SERVICE, null, "Undo", "", null),

	COMMAND_REDO(EnServiceId.COMMAND_SERVICE, null, "Redo", "", null),

	PICTURE_INSERTDRAWING(EnServiceId.PICTURE_SERVICE, "image", "", "", null),

	TABLE_INSERTTABLE(EnServiceId.TABLE_SERVICE, "table", "Insert Table", "Insert Table", null),

	INSERT_TEXTBOX(EnServiceId.INSERT_SERVICE, "textbox", "Insert Textbox", "Insert Textbox", null),

	PARAGRAPH_TEXTSTYLETOOL(EnServiceId.PARAGRAPH_SERVICE, null, "", "", null),

	COLOR_FOREGROUND(EnServiceId.COLOR_SERVICE, "color", "", "Foreground Color", null),

	COLOR_BACKGROUND(EnServiceId.COLOR_SERVICE, "color", "", "Background Color", null),

	COLOR_HIGHLIGHT(EnServiceId.COLOR_SERVICE, "color", "", "Background Color", null),

	PARAGRAPH_FONTNAME(EnServiceId.PARAGRAPH_SERVICE, null, "", "Font Name", null),

	PARAGRAPH_FONTSIZE(EnServiceId.PARAGRAPH_SERVICE, null, "", "Font Size", null),

	PARAGRAPH_BOLD(EnServiceId.PARAGRAPH_SERVICE, null, "", "Bold", null),

	PARAGRAPH_ITALIC(EnServiceId.PARAGRAPH_SERVICE, null, "", "Italic", null),

	PARAGRAPH_UNDERLINE(EnServiceId.PARAGRAPH_SERVICE, null, "", "Underline", null),

	PARAGRAPH_STRIKETHROUGH(EnServiceId.PARAGRAPH_SERVICE, null, "", "Strikethrough", null),

	PARAGRAPH_SUBSCRIPT(EnServiceId.PARAGRAPH_SERVICE, null, "", "SubScript", null),

	PARAGRAPH_SUPERSCRIPT(EnServiceId.PARAGRAPH_SERVICE, null, "", "SuperScript", null),

	PARAGRAPH_SHOWSTARTMENU(EnServiceId.PARAGRAPH_SERVICE, null, "", "", null),

	LAYOUT_LAYOUT(EnServiceId.LAYOUT_SERVICE, null, "", "", null),

	LAYOUT_LAYOUTPAGES(EnServiceId.LAYOUT_SERVICE, null, "", "", null),

	PARAGRAPH_SHOWRULERS(EnServiceId.PARAGRAPH_SERVICE, null, "", "", null),

	PARAGRAPH_CHARACTERSTYLE(EnServiceId.PARAGRAPH_SERVICE, null, "", "", null),

	PARAGRAPH_COLLAPSEALL(EnServiceId.PARAGRAPH_SERVICE, null, "", "", null),

	PARAGRAPH_USECASE(EnServiceId.PARAGRAPH_SERVICE, null, "", "", null),

	PARAGRAPH_SHOWOUTLINE(EnServiceId.PARAGRAPH_SERVICE, "paragraph", "", "Show Outline", null),

	PARAGRAPH_UPDATEPARAGRAPH(EnServiceId.PARAGRAPH_SERVICE, null, "", "", null),

	PARAGRAPH_EXPANDAFTER(EnServiceId.PARAGRAPH_SERVICE, null, "", "", null),

	PARAGRAPH_EXPANDBEFORE(EnServiceId.PARAGRAPH_SERVICE, null, "", "", null),

	PARAGRAPH_SPLIT(EnServiceId.PARAGRAPH_SERVICE, null, "", "", null),

	PARAGRAPH_SETSTYLE(EnServiceId.PARAGRAPH_SERVICE, null, "", "", null),

	PARAGRAPH_INSERTPARAGRAPH(EnServiceId.PARAGRAPH_SERVICE, null, "", "", null),

	PARAGRAPH_INSERTTEXT(EnServiceId.PARAGRAPH_SERVICE, null, "", "", null),

	PARAGRAPH_STYLENORMAL(EnServiceId.PARAGRAPH_SERVICE, null, "N", "Normal", null),

	PARAGRAPH_STYLETITLE(EnServiceId.PARAGRAPH_SERVICE, null, "T", "Title", null),

	PARAGRAPH_STYLEHEADING1(EnServiceId.PARAGRAPH_SERVICE, null, "H1", "Header 1", null),

	PARAGRAPH_STYLEHEADING2(EnServiceId.PARAGRAPH_SERVICE, null, "H2", "Header 2", null),

	PARAGRAPH_STYLEHEADING3(EnServiceId.PARAGRAPH_SERVICE, null, "H3", "Header 3", null),

	PARAGRAPH_STYLEHEADING4(EnServiceId.PARAGRAPH_SERVICE, null, "H4", "Header 4", null),

	PARAGRAPH_STYLEHEADING5(EnServiceId.PARAGRAPH_SERVICE, null, "H5", "Header 5", null),

	PARAGRAPH_SHADOW(EnServiceId.PARAGRAPH_SERVICE, null, null, "Shadow", null),

	EDITOR_ZOOMIN(EnServiceId.EDITOR_SERVICE, null, "Zoom In", "Zoom In", null),

	EDITOR_ZOOMOUT(EnServiceId.EDITOR_SERVICE, null, "Zoom out", "Zoom out", null),

	EDITOR_SELECT(EnServiceId.EDITOR_SERVICE, null, "Select", "Select", null),

	EDITOR_SHOWTOOLS(EnServiceId.EDITOR_SERVICE, "tools", "Show Tools", "Show Tools", null),

	EDITOR_EDITMODE(EnServiceId.EDITOR_SERVICE, "edit", "Edit Mode", "Edit Mode", null),

	EDITOR_SAVE(EnServiceId.EDITOR_SERVICE, null, "Save", "Save", null),

	EDITOR_SAVEAS(EnServiceId.EDITOR_SERVICE, null, null, null, null),

	EDITOR_OPENDOCUMENT(EnServiceId.EDITOR_SERVICE, "open", "Open Document", "Open Document...", null),

	EDITOR_OPENLASTDOCUMENT(EnServiceId.EDITOR_SERVICE, null, "Open Last Document", "Open Last Document", null),

	EDITOR_TESTLAYOUT(EnServiceId.EDITOR_SERVICE, "setup", "Test Layout", "Test Layout", null),

	EDITOR_TESTZORDER(EnServiceId.EDITOR_SERVICE, "setup", "Test Z-Order", "Test Z-Order", null),

	TABLE_INSERTROWABOVE(EnServiceId.TABLE_SERVICE, null, "", "", null),

	TABLE_INSERTROWBELOW(EnServiceId.TABLE_SERVICE, null, "", "", null),

	TABLE_INSERTCOLUMNLEFT(EnServiceId.TABLE_SERVICE, null, "", "", null),

	TABLE_INSERTCOLUMNRIGHT(EnServiceId.TABLE_SERVICE, null, "", "", null),

	TABLE_DELETECELLS(EnServiceId.TABLE_SERVICE, null, "", "", null),

	TABLE_DELETECOLUMNS(EnServiceId.TABLE_SERVICE, null, "", "", null),

	TABLE_DELETEROWS(EnServiceId.TABLE_SERVICE, null, "", "", null),

	TABLE_DELETETABLE(EnServiceId.TABLE_SERVICE, null, "", "", null),

	TABLE_MERGECELLS(EnServiceId.TABLE_SERVICE, null, "", "", null),

	TABLE_SPLITCELLS(EnServiceId.TABLE_SERVICE, null, "", "", null),

	TABLE_INSERTNEWEQUATION(EnServiceId.PARAGRAPH_SERVICE, "equations", "", "Insert A New Equation As Text", null),

	TABLE_INSERTNEWEQUATIONASIMAGE(EnServiceId.PARAGRAPH_SERVICE, "images", "", "Insert a New Equation As Image", null),

	INSERT_INSERTNEWEQUATIONASTEXTBOX(EnServiceId.INSERT_SERVICE, "equations", "", "Insert a New Equation As Textbox",
			null),

	INSERT_NEWEQUATIONASTEXTBOXIMAGE(EnServiceId.INSERT_SERVICE, "images", "Insert a New Equation As Textbox (Image)",
			"Insert a New Equation As Textbox (Image)", null),

	INSERT_DELETEEQUATION(EnServiceId.INSERT_SERVICE, "delete", "Reset", "Reset", null),

	PARAGRAPH_INSERTLATEX(EnServiceId.PARAGRAPH_SERVICE, null, "", null, null),

	PICTURE_SEARCHIMAGEINWEB(EnServiceId.PICTURE_SERVICE, "search", "Search Image", "Search Image", null),

	PICTURE_INSERTIMAGEFROMWEB(EnServiceId.PICTURE_SERVICE, "insert", "Insert Image", "Insert Image", null),

	PICTURE_INSERTSHAPE(EnServiceId.PICTURE_SERVICE, "insert", "Insert Shape", "Insert Shape", null),

	EDITOR_ARRANGEALIGNLEFT(EnServiceId.EDITOR_SERVICE, null, null, null, null),

	EDITOR_ARRANGEALIGNRIGHT(EnServiceId.EDITOR_SERVICE, null, null, null, null),

	EDITOR_ARRANGEALIGNTOP(EnServiceId.EDITOR_SERVICE, null, null, null, null),

	EDITOR_ARRANGEALIGNBOTTOM(EnServiceId.EDITOR_SERVICE, null, null, null, null),

	EDITOR_ARRANGEVERTICALCENTER(EnServiceId.EDITOR_SERVICE, null, null, null, null),

	EDITOR_ARRANGEALIGNHOROZONTALCENTER(EnServiceId.EDITOR_SERVICE, null, null, null, null),

	DEFAULT_SHOWHOMEPAGE(EnServiceId.DEFAULT_SERVICE, null, null, null, null),

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
		Object data = null;
		if (id.startsWith("shape")) {
			data = id;
			id = "insertShape";
		}
		for (EnCommandId e : EnCommandId.values()) {
			String enId = e.getId();
			if (id.equals(enId)) {
				if (data != null) {
					e.setData(data);
				}
				return e;
			}
		}
		return null;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
