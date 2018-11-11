package org.eclipse.rcpl;

import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetGeometry2D;
import org.openxmlformats.schemas.drawingml.x2006.main.STShapeType;

/**
 * @author ramin
 * 
 */
public enum EnShapeType {

	UNDEFINED("undefined", "Undefined Shape"), //$NON-NLS-1$
	RIGHT_ARROW("#_x0000_t66", "Insert Right Arrow"), //$NON-NLS-1$
	LEFT_ARROW("#_x0000_t68", "Insert Left Arrow"), //$NON-NLS-1$
	UP_ARROW("#_x0000_t67", "Insert Up Arrow"), //$NON-NLS-1$
	DOWN_ARROW("#_x0000_t69", "Insert Bent-Up Arrow"), //$NON-NLS-1$
	LEFT_UP_RIGHT_ARROW("#_x0000_t91", "Insert Left-Up-Right Arrow"), //$NON-NLS-1$
	LEFT_RIGHT_ARROW("#_x0000_t70", "Insert Left-Right Arrow"), //$NON-NLS-1$
	QUAD_ARROW("#_x0000_t182", "Insert Quad Arrow"), //$NON-NLS-1$
	BENT_ARROW("#_x0000_t101", "Insert Bent Arrow"), //$NON-NLS-1$
	UP_DOWN_ARROW("#_x0000_t76", "Insert Up-Down Arrow"), //$NON-NLS-1$
	U_TURN_ARROW("#_x0000_t89", "Insert U-Turn Arrow"), //$NON-NLS-1$
	BLOCK_ARC("#_x0000_t74", "Insert Block Arc"), //$NON-NLS-1$
	LEFT_UP_ARROW("#_x0000_t90", "Insert Left-Up Arrow"), //$NON-NLS-1$
	HEART("#_x0000_t73", "Insert Heart"), //$NON-NLS-1$
	CUBE("#_x0000_t84", "Insert Cube"), //$NON-NLS-1$
	SUN("#_x0000_t184", "Insert Sun"), //$NON-NLS-1$
	NO_SYMBOL("#_x0000_t95", "Insert No Symbol"), //$NON-NLS-1$
	FOLDED_CORNER("#_x0000_t96", "Insert Folded Corner"), //$NON-NLS-1$
	DOUBLE_BRACE("#_x0000_t21", "Insert Double Brace"), //$NON-NLS-1$
	LEFT_BRACE("#_x0000_t88", "Insert Left Brace"), //$NON-NLS-1$
	RIGHT_BRACE("#_x0000_t13", "Insert Right Brace"), //$NON-NLS-1$
	MOON("#_x0000_t19", "Insert Moon"), //$NON-NLS-1$
	DOUBLE_BRACKET("#_x0000_t186", "Insert Double Bracket"), //$NON-NLS-1$
	LEFT_BRACKET("#_x0000_t86", "Insert Left Bracket"), //$NON-NLS-1$
	RIGHT_BRACKET("#_x0000_t87", "Insert Right Bracket"), //$NON-NLS-1$
	LIGHTNING_BOLT("#_x0000_t183", "Insert Lightning Bolt"), //$NON-NLS-1$
	SMILEY_FACE("#_x0000_t23", "Insert Smiley Face"), //$NON-NLS-1$
	ARC("#_x0000_t185", "Insert Arc"), //$NON-NLS-1$
	PLAQUE("#_x0000_t21", "Plaque"), //$NON-NLS-1$
	BEVEL("#_x0000_t84", "bevel_shape"), //$NON-NLS-1$
	REGULAR_PENTAGON("#_x0000_t56", "pentagon"), //$NON-NLS-1$
	CROSS("#_x0000_t11", "cross"), //$NON-NLS-1$
	HEXAGON("#_x0000_t9", "hexagon"), //$NON-NLS-1$
	ISOCELES_TRIANGLE("#_x0000_t5", "triangle"), //$NON-NLS-1$
	RIGHT_TRIANGLE("#_x0000_t6", "right_triangle"), //$NON-NLS-1$
	OCTAGON("#_x0000_t10", "octagon"), //$NON-NLS-1$
	DIAMOND("#_x0000_t4", "diamond"), //$NON-NLS-1$
	TRAPEZOID("#_x0000_t8", "trapezoid"), //$NON-NLS-1$
	PARALLELOGRAM("#_x0000_t7", "parallelogram"), //$NON-NLS-1$
	CURVE("#_x0000_t38", "curve"), //$NON-NLS-1$
	TEXTBOX("#_x0000_t202", "textbox"), //$NON-NLS-1$
	CYLINDER("#_x0000_t22", "cylinder"), //$NON-NLS-1$
	DONUT("#_x0000_t23", "donut"), //$NON-NLS-1$
	FREEFORM("custom", "freeform"), //$NON-NLS-1$
	SCRIBBLE("#_x0000_t23", "scribble"), //$NON-NLS-1$
	LINE("#_x0000_t32", "line"), //$NON-NLS-1$
	RECTANGLE("#_x0000_txxxx", "rectangle"), //$NON-NLS-1$
	ROUND_RECTANGLE("#_x0000_txxxx", "round_rectangle"), //$NON-NLS-1$
	RECTANGLE_WITH_IMAGE("#_x0000_txxxx", "rectangle_with_image"), //$NON-NLS-1$
	CHEVRON(null, "Chevron"), //$NON-NLS-1$ ,;
	STAR_POINT_4(null, "4-Point Star"), //$NON-NLS-1$ ,;
	STAR_POINT_5(null, "5-Point Star"), //$NON-NLS-1$ ,;
	STAR_POINT_8(null, "8-Point Star"), //$NON-NLS-1$ ,;
	ROUND_1_RECT(null, "Round JORectangle 1"), //$NON-NLS-1$ ,;
	ACCENT_BORDER_CALLOUT_1(null, "Accent Border Callout 1"), //$NON-NLS-1$ ,;
	ACCENT_BORDER_CALLOUT_2(null, "Accent Border Callout 2"), //$NON-NLS-1$ ,;
	ACCENT_BORDER_CALLOUT_3(null, "Accent Border Callout 3"), //$NON-NLS-1$ ,;
	ACCENT_CALLOUT_1(null, "Accent Callout 1"), //$NON-NLS-1$ ,;
	ACCENT_CALLOUT_2(null, "Accent Callout 2"), //$NON-NLS-1$ ,;
	ACCENT_CALLOUT_3(null, "Accent Callout 3"), //$NON-NLS-1$ ,;
	ACTION_BUTTON_BACK_PREVIOUS(null, "Action Button Previous"), //$NON-NLS-1$ ,;
	ACTION_BUTTON_BEGINNING(null, "Action Button Beginning"), //$NON-NLS-1$ ,;
	ACTION_BUTTON_BLANK(null, "Action Button Blank"), //$NON-NLS-1$ ,;
	ACTION_BUTTON_DOCUMENT(null, "Action Button Document"), //$NON-NLS-1$ ,;
	ACTION_BUTTON_END(null, "Action Button End"), //$NON-NLS-1$ ,;
	ACTION_BUTTON_FORWARD_NEXT(null, "Action Button Forward"), //$NON-NLS-1$ ,;
	ACTION_BUTTON_HELP(null, "Action Button Help"), //$NON-NLS-1$ ,;
	ACTION_BUTTON_HOME(null, "Action Button Home"), //$NON-NLS-1$ ,;
	ACTION_BUTTON_INFORMATION(null, "Action Button Information"), //$NON-NLS-1$ ,;
	ACTION_BUTTON_MOVIE(null, "Action Button Movie"), //$NON-NLS-1$ ,;
	ACTION_BUTTON_RETURN(null, "Action Button Return"), //$NON-NLS-1$ ,;
	ACTION_BUTTON_SOUND(null, "Action Button Sound"), //$NON-NLS-1$ ,;
	BENT_CONNECTOR_2(null, "Bent Connector 2"), //$NON-NLS-1$ ,;
	BENT_CONNECTOR_3(null, "Bent Connector 3"), //$NON-NLS-1$ ,;
	BENT_CONNECTOR_4(null, "Bent Connector 3"), //$NON-NLS-1$ ,;
	BENT_CONNECTOR_5(null, "Bent Connector 4"), //$NON-NLS-1$ ,;
	BENT_UP_ARROW(null, "Bent Up Arrow"), //$NON-NLS-1$ ,;
	BORDER_CALLOUT_1(null, "Border Callout 1"), //$NON-NLS-1$ ,;
	BORDER_CALLOUT_2(null, "Border Callout 2"), //$NON-NLS-1$ ,;
	BORDER_CALLOUT_3(null, "Border Callout 3"), //$NON-NLS-1$ ,;
	BRACE_PAIR(null, "Brace Pair"), //$NON-NLS-1$ ,;
	BRACKET_PAIR(null, "Bracket Pair"), //$NON-NLS-1$ ,;
	CALLOUT_1(null, "Callout 1"), //$NON-NLS-1$ ,;
	CALLOUT_2(null, "Callout 2"), //$NON-NLS-1$ ,;
	CALLOUT_3(null, "Callout 3"), //$NON-NLS-1$ ,;
	CAN(null, "Can"), //$NON-NLS-1$ ,;
	CHART_PLUS(null, "Chart Plus"), //$NON-NLS-1$ ,;
	CHART_STAR(null, "Chart Star"), //$NON-NLS-1$ ,;
	CHART_X(null, "Chart X"), //$NON-NLS-1$ ,;
	CHORD(null, "Chord"), //$NON-NLS-1$ ,;
	CIRCULAR_ARROW(null, "Circular Arrow"), //$NON-NLS-1$ ,;
	CLOUD(null, "Cloud"), //$NON-NLS-1$ ,;
	CLOUD_CALLOUT(null, "Cloud Callout"), //$NON-NLS-1$ ,;
	CORNER(null, "Corner"), //$NON-NLS-1$ ,;
	CORNER_TABS(null, "Corner Tabs"), //$NON-NLS-1$ ,;
	CURVED_CONNECTOR_2(null, "Curved Connector 2"), //$NON-NLS-1$ ,;
	CURVED_CONNECTOR_3(null, "Curved Connector 3"), //$NON-NLS-1$ ,;
	CURVED_CONNECTOR_4(null, "Curved Connector 4"), //$NON-NLS-1$ ,;
	CURVED_CONNECTOR_5(null, "Curved Connector 5"), //$NON-NLS-1$ ,;
	CURVED_DOWN_ARROW(null, "Curved Down Arrow"), //$NON-NLS-1$ ,;
	CURVED_LEFT_ARROW(null, "Curved Left Arrow"), //$NON-NLS-1$ ,;
	CURVED_RIGHT_ARROW(null, "Curved Right Arrow"), //$NON-NLS-1$ ,;
	CURVED_UP_ARROW(null, "Curved Up Arrow"), //$NON-NLS-1$ ,;
	DECAGON(null, "Decagon"), //$NON-NLS-1$ ,;
	DIAG_STRIPE(null, "Diag Stripe"), //$NON-NLS-1$ ,;
	DODECAGON(null, "Dodecagon"), //$NON-NLS-1$ ,;
	DOUBLE_WAVE(null, "Double Wave"), //$NON-NLS-1$ ,;
	DOWN_ARROW_CALLOUT(null, "Down Arrow Callout"), //$NON-NLS-1$ ,;
	ELLIPSE(null, "Ellipse"), //$NON-NLS-1$ ,;
	ELLIPSE_RIBBON(null, "Ellipse Ribbon"), //$NON-NLS-1$ ,;
	ELLIPSE_RIBBON_2(null, "Ellipse Ribbon 2"), //$NON-NLS-1$ ,;
	EXPLOSION(null, "Explosion"), //$NON-NLS-1$ ,;
	FLOW_CHART_ALTERNATE_PROCESS(null, "Flow Chart Alternate Process"), //$NON-NLS-1$ ,;
	FLOW_CHART_CARD(null, "Flow Chart Card"), //$NON-NLS-1$ ,;
	FLOW_CHART_COLLATE(null, "Flow Chart Collate"), //$NON-NLS-1$ ,;
	FLOW_CHART_CONNECTOR(null, "Flow Chart Connector"), //$NON-NLS-1$ ,;
	FLOW_CHART_DATA(null, "Flow Chart Data"), //$NON-NLS-1$ ,;
	FLOW_CHART_DECISION(null, "Flow Chart Decision"), //$NON-NLS-1$ ,;
	FLOW_CHART_DELAY(null, "Flow Chart Delay"), //$NON-NLS-1$ ,;
	FLOW_CHART_DIRECT_ACCESS_STORAGE(null, "Flow Chart Direct Access Storage"), //$NON-NLS-1$ ,;
	FLOW_CHART_DISPLAY(null, "Flow Chart Display"), //$NON-NLS-1$ ,;
	FLOW_CHART_DOCUMENT(null, "Flow Chart Document"), //$NON-NLS-1$ ,;
	FLOW_CHART_EXTRACT(null, "Flow Chart Document"), //$NON-NLS-1$ ,;
	FLOW_CHART_INPUT_OUTPUT(null, "Flow Chart Input Output"), //$NON-NLS-1$ ,;
	FLOW_CHART_INTERNAL_STORAGE(null, "Flow Chart Internal Storage"), //$NON-NLS-1$ ,;
	FLOW_CHART_MAGNETIC_DISK(null, "Flow Chart Magnetic Disk"), //$NON-NLS-1$ ,;
	FLOW_CHART_MAGNETIC_DRUM(null, "Flow Chart Magnetic Drum"), //$NON-NLS-1$ ,;
	FLOW_CHART_MAGNETIC_TAPE(null, "Flow Chart Magnetic Tape"), //$NON-NLS-1$ ,;
	FLOW_CHART_MANUAL_INPUT(null, "Flow Chart Manual Input"), //$NON-NLS-1$ ,;
	FLOW_CHART_MANUAL_OPERATION(null, "Flow Chart Manual Operation"), //$NON-NLS-1$ ,;
	FLOW_CHART_MERGE(null, "Flow Chart Merge"), //$NON-NLS-1$ ,;
	FLOW_CHART_MULTIDOCUMENT(null, "Flow Chart Multidocument"), //$NON-NLS-1$ ,;
	FLOW_CHART_OFFLINE_STORAGE(null, "Flow Chart Offline Storage"), //$NON-NLS-1$ ,;
	FLOW_CHART_OFFPAGE_CONNECTOR(null, "Flow Chart Offpage Connector"), //$NON-NLS-1$ ,;
	FLOW_CHART_ONLINE_STORAGE(null, "Flow Chart Online Storage"), //$NON-NLS-1$ ,;
	FLOW_CHART_OR(null, "Flow Chart Or"), //$NON-NLS-1$ ,;
	FLOW_CHART_PREDEFINED_PROCESS(null, "Flow Chart Predefined Process"), //$NON-NLS-1$ ,;
	FLOW_CHART_PREPARATION(null, "Flow Chart Preparation"), //$NON-NLS-1$ ,;
	FLOW_CHART_PROCESS(null, "Flow Chart Process"), //$NON-NLS-1$ ,;
	FLOW_CHART_PUNCHED_CARD(null, "Flow Chart Punched Card"), //$NON-NLS-1$ ,;
	FLOW_CHART_PUNCHED_TAPE(null, "Flow Chart Punched Tape"), //$NON-NLS-1$ ,;
	FLOW_CHART_SEQUENTIAL_ACCESS_STORAGE(null, "Flow Chart Sequential Access Storage"), //$NON-NLS-1$ ,;
	FLOW_CHART_SORT(null, "Flow Chart Sort"), //$NON-NLS-1$ ,;
	FLOW_CHART_STORED_DATA(null, "Flow Chart Stored Data"), //$NON-NLS-1$ ,;
	FLOW_CHART_SUMMING_JUNCTION(null, "Flow Chart Summing Junction"), //$NON-NLS-1$ ,;
	FLOW_CHART_TERMINATOR(null, "Flow Chart Terminator"), //$NON-NLS-1$ ,;
	FRAME(null, "Frame"), //$NON-NLS-1$ ,;
	FUNNEL(null, "Funnel"), //$NON-NLS-1$ ,;
	GEAR_6(null, "Gear 6"), //$NON-NLS-1$ ,;
	GEAR_9(null, "Gear 9"), //$NON-NLS-1$ ,;
	HALF_FRAME(null, "Half Frame"), //$NON-NLS-1$ ,;
	HEPTAGON(null, "Heptagon"), //$NON-NLS-1$ ,;
	HOME_PLATE(null, "Home Plate"), //$NON-NLS-1$ ,;
	HORIZONTAL_SCROLL(null, "Horizontal Scroll"), //$NON-NLS-1$ ,;
	IRREGULAR_SEAL_1(null, "Irregular Seal 1"), //$NON-NLS-1$ ,;
	IRREGULAR_SEAL_2(null, "Irregular Seal 2"), //$NON-NLS-1$ ,;
	LEFT_ARROW_CALLOUT(null, "Left Arrow Callout"), //$NON-NLS-1$ ,;
	LEFT_CIRCULAR_ARROW(null, "Left Circular Arrow"), //$NON-NLS-1$ ,;
	LEFT_RIGHT_ARROW_CALLOUT(null, "Left Right Arrow Callout"), //$NON-NLS-1$ ,;
	LEFT_RIGHT_CIRCULAR_ARROW(null, "Left Right Circular Arrow"), //$NON-NLS-1$ ,;
	LEFT_RIGHT_RIBBON(null, "Left Right Ribbon"), //$NON-NLS-1$ ,;
	LEFT_RIGHT_UP_ARROW(null, "Left Right Up Arrow"), //$NON-NLS-1$ ,;
	LINE_CALLOUT(null, "Line Callout"), //$NON-NLS-1$ ,;
	LINE_CALLOUT_2(null, "Line Callout 2"), //$NON-NLS-1$ ,;
	LINE_CALLOUT_3(null, "Line Callout 3"), //$NON-NLS-1$ ,;
	LINE_INV(null, "Line Inv"), //$NON-NLS-1$ ,;
	MATH_DIVIDE(null, "Math Divide"), //$NON-NLS-1$ ,;
	MATH_EQUAL(null, "Math Equal"), //$NON-NLS-1$ ,;
	MATH_MINUS(null, "Math Minus"), //$NON-NLS-1$ ,;
	MATH_MULTIPLY(null, "Math Multiply"), //$NON-NLS-1$ ,;
	MATH_NOT_EQUAL(null, "Math Not Equal"), //$NON-NLS-1$ ,;
	MATH_PLUS(null, "Math Plus"), //$NON-NLS-1$ ,;
	NO_SMOKING(null, "No Smoking"), //$NON-NLS-1$ ,;
	NON_ISOSCELES_TRAPEZOID(null, "Non Isosceles Trapezoid"), //$NON-NLS-1$ ,;
	NOTCHED_RIGHT_ARROW(null, "Notched Right Arrow"), //$NON-NLS-1$ ,;
	OVAL_CALLOUT(null, "Oval Callout"), //$NON-NLS-1$ ,;
	PENTAGON(null, "Pentagon"), //$NON-NLS-1$ ,;
	PIE(null, "Pie"), //$NON-NLS-1$ ,;
	PIE_WEDGE(null, "Pie Wedge"), //$NON-NLS-1$ ,;
	PLAQUE_TABS(null, "Plaque Tabs"), //$NON-NLS-1$ ,;
	PLUS(null, "Plus"), //$NON-NLS-1$ ,;
	QUAD_ARROW_CALLOUT(null, "Quad Arrow Callout"), //$NON-NLS-1$ ,;
	RECT(null, "Rect"), //$NON-NLS-1$ ,;
	RECTANGULAR_CALLOUT(null, "Rectangular Callout"), //$NON-NLS-1$ ,;
	ROUNDED_RECTANGULAR_CALLOUT(null, "Rounded Rectangular Callout"), //$NON-NLS-1$ ,;
	RIBBON(null, "Ribbon"), //$NON-NLS-1$ ,;
	RIBBON_2(null, "Ribbon 2"), //$NON-NLS-1$ ,;
	RIGHT_ARROW_CALLOUT(null, "Right Arrow Callout"), //$NON-NLS-1$ ,;
	ROUND_2_DIAG_RECT(null, "Round 2 Diag Rect"), //$NON-NLS-1$ ,;
	ROUND_2_SAME_RECT(null, "Round 2 Same Rect"), //$NON-NLS-1$ ,;
	RT_TRIANGLE(null, "Rt Triangle"), //$NON-NLS-1$ ,;
	SNIP_1_RECT(null, "Snip Rect 1"), //$NON-NLS-1$ ,;
	SNIP_2_DIAG_RECT(null, "Snip Diag Rect 2"), //$NON-NLS-1$ ,;
	SNIP_2_SAME_RECT(null, "Snip 2 Same Rect"), //$NON-NLS-1$ ,;
	SNIP_ROUND_RECT(null, "Snip Round Rect"), //$NON-NLS-1$ ,;

	SQUARE_TABS(null, "Square Tabs"), //$NON-NLS-1$ ,;

	STAR_10(null, "Star 10"), //$NON-NLS-1$ ,;

	STAR_12(null, "Star 12"), //$NON-NLS-1$ ,;

	STAR_16(null, "Star 16"), //$NON-NLS-1$ ,;

	STAR_24(null, "Star 24"), //$NON-NLS-1$ ,;

	STAR_32(null, "Star 32"), //$NON-NLS-1$ ,;

	STAR_4(null, "Star 4"), //$NON-NLS-1$ ,;

	STAR_5(null, "Star 5"), //$NON-NLS-1$ ,;

	STAR_6(null, "Star 6"), //$NON-NLS-1$ ,;

	STAR_7(null, "Star 7"), //$NON-NLS-1$ ,;

	STAR_8(null, "Star 8"), //$NON-NLS-1$ ,;

	STRAIGHT_CONNECTOR_1(null, "Straight Connector"), //$NON-NLS-1$ ,;

	STRIPED_RIGHT_ARROW(null, "Striped Right Arrow"), //$NON-NLS-1$ ,;
	TRIANGLE(null, "Triangle"), //$NON-NLS-1$ ,;
	TEARDROP(null, "Teardrop"), //$NON-NLS-1$ ,;
	SWOOSH_ARROW(null, "Swoosh Arrow"), //$NON-NLS-1$ ,;
	UP_ARROW_CALLOUT(null, "Up Arrow Callout"), //$NON-NLS-1$ ,;

	UP_DOWN_ARROW_CALLOUT(null, "Up Down Arrow Callout"), //$NON-NLS-1$ ,;

	UTURN_ARROW(null, "Uturn Arrow"), //$NON-NLS-1$ ,;

	VERTICAL_SCROLL(null, "Vertical Scroll"), //$NON-NLS-1$ ,;

	WAVE(null, "Wave"), //$NON-NLS-1$ ,;

	WEDGE_ELLIPSE_CALLOUT(null, "Wedge Ellipse Callout"), //$NON-NLS-1$ ,;

	WEDGE_RECT_CALLOUT(null, "Wedge Rect Callout"), //$NON-NLS-1$ ,;

	WEDGE_ROUND_RECT_CALLOUT(null, "Wedge Round Rect Callout"),

	textart_1("#_x0000_t136", "WordArt Style 1"), //$NON-NLS-1$
	textart_2("#_x0000_t172", "WordArt Style 2"), //$NON-NLS-1$
	textart_3("#_x0000_t144", "WordArt Style 3"), //$NON-NLS-1$
	textart_4("#_x0000_t161", "WordArt Style 4"), //$NON-NLS-1$
	textart_5("#_x0000_t175", "WordArt Style 5"), //$NON-NLS-1$
	textart_6("#_x0000_t136", "WordArt Style 6"), //$NON-NLS-1$
	textart_7("#_x0000_t136", "WordArt Style 7"), //$NON-NLS-1$
	textart_8("#_x0000_t136", "WordArt Style 8"), //$NON-NLS-1$
	textart_9("#_x0000_t136", "WordArt Style 9"), //$NON-NLS-1$
	textart_10("#_x0000_t136", "WordArt Style 10"), //$NON-NLS-1$
	textart_11("#_x0000_t136", "WordArt Style 11"), //$NON-NLS-1$
	textart_12("#_x0000_t136", "WordArt Style 12"), //$NON-NLS-1$
	textart_13("#_x0000_t136", "WordArt Style 13"), //$NON-NLS-1$
	textart_14("#_x0000_t172", "WordArt Style 14"), //$NON-NLS-1$
	textart_15("#_x0000_t136", "WordArt Style 15"), //$NON-NLS-1$
	textart_16("#_x0000_t136", "WordArt Style 16"), //$NON-NLS-1$
	textart_17("#_x0000_t156", "WordArt Style 17"), //$NON-NLS-1$
	textart_18("#_x0000_t136", "WordArt Style 18"), //$NON-NLS-1$
	textart_19("#_x0000_t136", "WordArt Style 19"), //$NON-NLS-1$
	textart_20("#_x0000_t138", "WordArt Style 20"), //$NON-NLS-1$
	textart_21("#_x0000_t170", "WordArt Style 21"), //$NON-NLS-1$
	textart_22("#_x0000_t158", "WordArt Style 22"), //$NON-NLS-1$
	textart_23("#_x0000_t152", "WordArt Style 23"), //$NON-NLS-1$
	textart_24("#_x0000_t159", "WordArt Style 24"), //$NON-NLS-1$
	textart_25("#_x0000_t136", "WordArt Style 25"), //$NON-NLS-1$
	textart_26("#_x0000_t136", "WordArt Style 26"), //$NON-NLS-1$
	textart_27("#_x0000_t163", "WordArt Style 27"), //$NON-NLS-1$
	textart_28("#_x0000_t154", "WordArt Style 28"), //$NON-NLS-1$
	textart_29("#_x0000_t136", "WordArt Style 29"), //$NON-NLS-1$
	textart_30("#_x0000_t136", "WordArt Style 30"), //$NON-NLS-1$

	; // $NON-NLS-1$,;

	private String shapeId;

	String displayName;

	private EnShapeType(String shapeId, String displayName) {
		this.shapeId = shapeId;
		this.displayName = displayName;
	}

	public String getShapeId() {
		return shapeId;
	}

	public String getDisplayName() {
		return displayName;
	}

	public static EnShapeType create(CTPresetGeometry2D ctPresetGeometry2D) {

		EnShapeType type = null;

		if (ctPresetGeometry2D != null) {

			STShapeType.Enum stShapeType = ctPresetGeometry2D.getPrst();

			if (stShapeType.equals(STShapeType.RECT)) {
				type = RECTANGLE;
			} else if (stShapeType.equals(STShapeType.ROUND_RECT)) {
				type = ROUND_RECTANGLE;
			} else if (stShapeType.equals(STShapeType.ROUND_1_RECT)) {
				type = ROUND_RECTANGLE;
			} else if (stShapeType.equals(STShapeType.CHEVRON)) {
				type = CHEVRON;
			} else if (stShapeType.equals(STShapeType.ACCENT_BORDER_CALLOUT_1)) {
				type = ACCENT_BORDER_CALLOUT_1;
			} else if (stShapeType.equals(STShapeType.ACCENT_BORDER_CALLOUT_2)) {
				type = ACCENT_BORDER_CALLOUT_2;
			} else if (stShapeType.equals(STShapeType.ACCENT_BORDER_CALLOUT_3)) {
				type = ACCENT_BORDER_CALLOUT_3;
			} else if (stShapeType.equals(STShapeType.ACCENT_CALLOUT_1)) {
				type = ACCENT_CALLOUT_1;
			} else if (stShapeType.equals(STShapeType.ACCENT_CALLOUT_2)) {
				type = ACCENT_CALLOUT_2;
			} else if (stShapeType.equals(STShapeType.ACCENT_CALLOUT_3)) {
				type = ACCENT_CALLOUT_3;
			} else if (stShapeType.equals(STShapeType.ACTION_BUTTON_BACK_PREVIOUS)) {
				type = ACTION_BUTTON_BACK_PREVIOUS;
			} else if (stShapeType.equals(STShapeType.ACTION_BUTTON_BEGINNING)) {
				type = ACTION_BUTTON_BEGINNING;
			} else if (stShapeType.equals(STShapeType.ACTION_BUTTON_BLANK)) {
				type = ACTION_BUTTON_BLANK;
			} else if (stShapeType.equals(STShapeType.ACTION_BUTTON_DOCUMENT)) {
				type = ACTION_BUTTON_DOCUMENT;
			} else if (stShapeType.equals(STShapeType.ACTION_BUTTON_END)) {
				type = ACTION_BUTTON_END;
			} else if (stShapeType.equals(STShapeType.ACTION_BUTTON_FORWARD_NEXT)) {
				type = ACTION_BUTTON_FORWARD_NEXT;
			} else if (stShapeType.equals(STShapeType.ACTION_BUTTON_HELP)) {
				type = ACTION_BUTTON_HELP;
			} else if (stShapeType.equals(STShapeType.ACTION_BUTTON_HOME)) {
				type = ACTION_BUTTON_HOME;
			} else if (stShapeType.equals(STShapeType.ACTION_BUTTON_INFORMATION)) {
				type = ACTION_BUTTON_INFORMATION;
			} else if (stShapeType.equals(STShapeType.ACTION_BUTTON_MOVIE)) {
				type = ACTION_BUTTON_MOVIE;
			} else if (stShapeType.equals(STShapeType.ACTION_BUTTON_RETURN)) {
				type = ACTION_BUTTON_RETURN;
			} else if (stShapeType.equals(STShapeType.ACTION_BUTTON_SOUND)) {
				type = ACTION_BUTTON_SOUND;
			} else if (stShapeType.equals(STShapeType.ARC)) {
				type = ARC;
			} else if (stShapeType.equals(STShapeType.BENT_ARROW)) {
				type = BENT_ARROW;
			} else if (stShapeType.equals(STShapeType.BENT_CONNECTOR_2)) {
				type = BENT_CONNECTOR_2;
			} else if (stShapeType.equals(STShapeType.BENT_CONNECTOR_3)) {
				type = BENT_CONNECTOR_3;
			} else if (stShapeType.equals(STShapeType.BENT_CONNECTOR_4)) {
				type = BENT_CONNECTOR_4;
			} else if (stShapeType.equals(STShapeType.BENT_CONNECTOR_5)) {
				type = BENT_CONNECTOR_5;
			} else if (stShapeType.equals(STShapeType.BENT_UP_ARROW)) {
				type = BENT_UP_ARROW;
			} else if (stShapeType.equals(STShapeType.BEVEL)) {
				type = BEVEL;
			} else if (stShapeType.equals(STShapeType.BLOCK_ARC)) {
				type = BLOCK_ARC;
			} else if (stShapeType.equals(STShapeType.BORDER_CALLOUT_1)) {
				type = BORDER_CALLOUT_1;
			} else if (stShapeType.equals(STShapeType.BORDER_CALLOUT_2)) {
				type = BORDER_CALLOUT_2;
			} else if (stShapeType.equals(STShapeType.BORDER_CALLOUT_3)) {
				type = BORDER_CALLOUT_3;
			} else if (stShapeType.equals(STShapeType.BRACE_PAIR)) {
				type = BRACE_PAIR;
			} else if (stShapeType.equals(STShapeType.BRACKET_PAIR)) {
				type = BRACKET_PAIR;
			} else if (stShapeType.equals(STShapeType.CALLOUT_1)) {
				type = CALLOUT_1;
			} else if (stShapeType.equals(STShapeType.CALLOUT_2)) {
				type = CALLOUT_2;
			} else if (stShapeType.equals(STShapeType.CALLOUT_3)) {
				type = CALLOUT_3;
			} else if (stShapeType.equals(STShapeType.CAN)) {
				type = CAN;
			} else if (stShapeType.equals(STShapeType.CHART_PLUS)) {
				type = CHART_PLUS;
			} else if (stShapeType.equals(STShapeType.CHART_STAR)) {
				type = CHART_STAR;
			} else if (stShapeType.equals(STShapeType.CHART_X)) {
				type = CHART_X;
			} else if (stShapeType.equals(STShapeType.CHEVRON)) {
				type = CHEVRON;
			} else if (stShapeType.equals(STShapeType.CHORD)) {
				type = CHORD;
			} else if (stShapeType.equals(STShapeType.CIRCULAR_ARROW)) {
				type = CIRCULAR_ARROW;
			} else if (stShapeType.equals(STShapeType.CLOUD)) {
				type = CLOUD;
			} else if (stShapeType.equals(STShapeType.CLOUD_CALLOUT)) {
				type = CLOUD_CALLOUT;
			} else if (stShapeType.equals(STShapeType.CORNER)) {
				type = CORNER;
			} else if (stShapeType.equals(STShapeType.CORNER_TABS)) {
				type = CORNER_TABS;
			} else if (stShapeType.equals(STShapeType.CUBE)) {
				type = CUBE;
			} else if (stShapeType.equals(STShapeType.CURVED_CONNECTOR_2)) {
				type = CURVED_CONNECTOR_2;
			} else if (stShapeType.equals(STShapeType.CURVED_CONNECTOR_3)) {
				type = CURVED_CONNECTOR_3;
			} else if (stShapeType.equals(STShapeType.CURVED_CONNECTOR_4)) {
				type = CURVED_CONNECTOR_4;
			} else if (stShapeType.equals(STShapeType.CURVED_CONNECTOR_5)) {
				type = CURVED_CONNECTOR_5;
			} else if (stShapeType.equals(STShapeType.CURVED_DOWN_ARROW)) {
				type = CURVED_DOWN_ARROW;
			} else if (stShapeType.equals(STShapeType.CURVED_LEFT_ARROW)) {
				type = CURVED_LEFT_ARROW;
			} else if (stShapeType.equals(STShapeType.CURVED_RIGHT_ARROW)) {
				type = CURVED_RIGHT_ARROW;
			} else if (stShapeType.equals(STShapeType.CURVED_UP_ARROW)) {
				type = CURVED_UP_ARROW;
			} else if (stShapeType.equals(STShapeType.DECAGON)) {
				type = DECAGON;
			} else if (stShapeType.equals(STShapeType.DIAG_STRIPE)) {
				type = DIAG_STRIPE;
			} else if (stShapeType.equals(STShapeType.DIAMOND)) {
				type = DIAMOND;
			} else if (stShapeType.equals(STShapeType.DODECAGON)) {
				type = DODECAGON;
			} else if (stShapeType.equals(STShapeType.DONUT)) {
				type = DONUT;
			} else if (stShapeType.equals(STShapeType.DOUBLE_WAVE)) {
				type = DOUBLE_WAVE;
			} else if (stShapeType.equals(STShapeType.DOWN_ARROW)) {
				type = DOWN_ARROW;
			} else if (stShapeType.equals(STShapeType.DOWN_ARROW_CALLOUT)) {
				type = DOWN_ARROW_CALLOUT;
			} else if (stShapeType.equals(STShapeType.ELLIPSE)) {
				type = ELLIPSE;
			} else if (stShapeType.equals(STShapeType.ELLIPSE_RIBBON)) {
				type = ELLIPSE_RIBBON;
			} else if (stShapeType.equals(STShapeType.ELLIPSE_RIBBON_2)) {
				type = ELLIPSE_RIBBON_2;
			} else if (stShapeType.equals(STShapeType.FLOW_CHART_ALTERNATE_PROCESS)) {
				type = FLOW_CHART_ALTERNATE_PROCESS;
			} else if (stShapeType.equals(STShapeType.FLOW_CHART_COLLATE)) {
				type = FLOW_CHART_COLLATE;
			} else if (stShapeType.equals(STShapeType.FLOW_CHART_CONNECTOR)) {
				type = FLOW_CHART_CONNECTOR;
			} else if (stShapeType.equals(STShapeType.FLOW_CHART_DECISION)) {
				type = FLOW_CHART_DECISION;
			} else if (stShapeType.equals(STShapeType.FLOW_CHART_DELAY)) {
				type = FLOW_CHART_DELAY;
			} else if (stShapeType.equals(STShapeType.FLOW_CHART_DISPLAY)) {
				type = FLOW_CHART_DISPLAY;
			} else if (stShapeType.equals(STShapeType.FLOW_CHART_DOCUMENT)) {
				type = FLOW_CHART_DOCUMENT;
			} else if (stShapeType.equals(STShapeType.FLOW_CHART_EXTRACT)) {
				type = FLOW_CHART_EXTRACT;
			} else if (stShapeType.equals(STShapeType.FLOW_CHART_INPUT_OUTPUT)) {
				type = FLOW_CHART_INPUT_OUTPUT;
			} else if (stShapeType.equals(STShapeType.FLOW_CHART_INTERNAL_STORAGE)) {
				type = FLOW_CHART_INTERNAL_STORAGE;
			} else if (stShapeType.equals(STShapeType.FLOW_CHART_MAGNETIC_DISK)) {
				type = FLOW_CHART_MAGNETIC_DISK;
			} else if (stShapeType.equals(STShapeType.FLOW_CHART_MAGNETIC_DRUM)) {
				type = FLOW_CHART_MAGNETIC_DRUM;
			} else if (stShapeType.equals(STShapeType.FLOW_CHART_MAGNETIC_TAPE)) {
				type = FLOW_CHART_MAGNETIC_TAPE;
			} else if (stShapeType.equals(STShapeType.FLOW_CHART_MANUAL_INPUT)) {
				type = FLOW_CHART_MANUAL_INPUT;
			} else if (stShapeType.equals(STShapeType.FLOW_CHART_MANUAL_OPERATION)) {
				type = FLOW_CHART_MANUAL_OPERATION;
			} else if (stShapeType.equals(STShapeType.FLOW_CHART_MERGE)) {
				type = FLOW_CHART_MERGE;
			} else if (stShapeType.equals(STShapeType.FLOW_CHART_MULTIDOCUMENT)) {
				type = FLOW_CHART_MULTIDOCUMENT;
			} else if (stShapeType.equals(STShapeType.FLOW_CHART_OFFLINE_STORAGE)) {
				type = FLOW_CHART_OFFLINE_STORAGE;
			} else if (stShapeType.equals(STShapeType.FLOW_CHART_OFFPAGE_CONNECTOR)) {
				type = FLOW_CHART_OFFPAGE_CONNECTOR;
			} else if (stShapeType.equals(STShapeType.FLOW_CHART_ONLINE_STORAGE)) {
				type = FLOW_CHART_ONLINE_STORAGE;
			} else if (stShapeType.equals(STShapeType.FLOW_CHART_OR)) {
				type = FLOW_CHART_OR;
			} else if (stShapeType.equals(STShapeType.FLOW_CHART_PREDEFINED_PROCESS)) {
				type = FLOW_CHART_PREDEFINED_PROCESS;
			} else if (stShapeType.equals(STShapeType.FLOW_CHART_PREPARATION)) {
				type = FLOW_CHART_PREPARATION;
			} else if (stShapeType.equals(STShapeType.FLOW_CHART_PROCESS)) {
				type = FLOW_CHART_PROCESS;
			} else if (stShapeType.equals(STShapeType.FLOW_CHART_PUNCHED_CARD)) {
				type = FLOW_CHART_PUNCHED_CARD;
			} else if (stShapeType.equals(STShapeType.FLOW_CHART_PUNCHED_TAPE)) {
				type = FLOW_CHART_PUNCHED_TAPE;
			} else if (stShapeType.equals(STShapeType.FLOW_CHART_SORT)) {
				type = FLOW_CHART_SORT;
			} else if (stShapeType.equals(STShapeType.FLOW_CHART_SUMMING_JUNCTION)) {
				type = FLOW_CHART_SUMMING_JUNCTION;
			} else if (stShapeType.equals(STShapeType.FLOW_CHART_TERMINATOR)) {
				type = FLOW_CHART_TERMINATOR;
			} else if (stShapeType.equals(STShapeType.FOLDED_CORNER)) {
				type = FOLDED_CORNER;
			} else if (stShapeType.equals(STShapeType.FRAME)) {
				type = FRAME;
			} else if (stShapeType.equals(STShapeType.FUNNEL)) {
				type = FUNNEL;
			} else if (stShapeType.equals(STShapeType.GEAR_6)) {
				type = GEAR_6;
			} else if (stShapeType.equals(STShapeType.GEAR_9)) {
				type = GEAR_9;
			} else if (stShapeType.equals(STShapeType.HALF_FRAME)) {
				type = HALF_FRAME;
			} else if (stShapeType.equals(STShapeType.HEART)) {
				type = HEART;
			} else if (stShapeType.equals(STShapeType.HEPTAGON)) {
				type = HEPTAGON;
			} else if (stShapeType.equals(STShapeType.HEXAGON)) {
				type = HEXAGON;
			} else if (stShapeType.equals(STShapeType.HOME_PLATE)) {
				type = HOME_PLATE;
			} else if (stShapeType.equals(STShapeType.HORIZONTAL_SCROLL)) {
				type = HORIZONTAL_SCROLL;
			} else if (stShapeType.equals(STShapeType.IRREGULAR_SEAL_1)) {
				type = IRREGULAR_SEAL_1;
			} else if (stShapeType.equals(STShapeType.IRREGULAR_SEAL_2)) {
				type = IRREGULAR_SEAL_2;
			} else if (stShapeType.equals(STShapeType.LEFT_ARROW)) {
				type = LEFT_ARROW;
			} else if (stShapeType.equals(STShapeType.LEFT_ARROW_CALLOUT)) {
				type = LEFT_ARROW_CALLOUT;
			} else if (stShapeType.equals(STShapeType.LEFT_BRACE)) {
				type = LEFT_BRACE;
			} else if (stShapeType.equals(STShapeType.LEFT_BRACKET)) {
				type = LEFT_BRACKET;
			} else if (stShapeType.equals(STShapeType.LEFT_CIRCULAR_ARROW)) {
				type = LEFT_CIRCULAR_ARROW;
			} else if (stShapeType.equals(STShapeType.LEFT_RIGHT_ARROW)) {
				type = LEFT_RIGHT_ARROW;
			} else if (stShapeType.equals(STShapeType.LEFT_RIGHT_ARROW_CALLOUT)) {
				type = LEFT_RIGHT_ARROW_CALLOUT;
			} else if (stShapeType.equals(STShapeType.LEFT_RIGHT_CIRCULAR_ARROW)) {
				type = LEFT_RIGHT_CIRCULAR_ARROW;
			} else if (stShapeType.equals(STShapeType.LEFT_RIGHT_RIBBON)) {
				type = LEFT_RIGHT_RIBBON;
			} else if (stShapeType.equals(STShapeType.LEFT_RIGHT_UP_ARROW)) {
				type = LEFT_RIGHT_UP_ARROW;
			} else if (stShapeType.equals(STShapeType.LEFT_UP_ARROW)) {
				type = LEFT_RIGHT_UP_ARROW;
			} else if (stShapeType.equals(STShapeType.LIGHTNING_BOLT)) {
				type = LIGHTNING_BOLT;
			} else if (stShapeType.equals(STShapeType.LINE)) {
				type = LINE;
			} else if (stShapeType.equals(STShapeType.LINE_INV)) {
				type = LINE_INV;
			} else if (stShapeType.equals(STShapeType.MATH_DIVIDE)) {
				type = MATH_DIVIDE;
			} else if (stShapeType.equals(STShapeType.MATH_EQUAL)) {
				type = MATH_EQUAL;
			} else if (stShapeType.equals(STShapeType.MATH_MINUS)) {
				type = MATH_MINUS;
			} else if (stShapeType.equals(STShapeType.MATH_MULTIPLY)) {
				type = MATH_MULTIPLY;
			} else if (stShapeType.equals(STShapeType.MATH_NOT_EQUAL)) {
				type = MATH_NOT_EQUAL;
			} else if (stShapeType.equals(STShapeType.MATH_PLUS)) {
				type = MATH_PLUS;
			} else if (stShapeType.equals(STShapeType.MOON)) {
				type = MOON;
			} else if (stShapeType.equals(STShapeType.NO_SMOKING)) {
				type = NO_SMOKING;
			} else if (stShapeType.equals(STShapeType.NON_ISOSCELES_TRAPEZOID)) {
				type = NO_SYMBOL;
			} else if (stShapeType.equals(STShapeType.NOTCHED_RIGHT_ARROW)) {
				type = NOTCHED_RIGHT_ARROW;
			} else if (stShapeType.equals(STShapeType.OCTAGON)) {
				type = OCTAGON;
			} else if (stShapeType.equals(STShapeType.PARALLELOGRAM)) {
				type = PARALLELOGRAM;
			} else if (stShapeType.equals(STShapeType.PENTAGON)) {
				type = PENTAGON;
			} else if (stShapeType.equals(STShapeType.PIE)) {
				type = PIE;
			} else if (stShapeType.equals(STShapeType.PIE_WEDGE)) {
				type = PIE_WEDGE;
			} else if (stShapeType.equals(STShapeType.PLAQUE)) {
				type = PLAQUE;
			} else if (stShapeType.equals(STShapeType.PLAQUE_TABS)) {
				type = PLAQUE_TABS;
			} else if (stShapeType.equals(STShapeType.PLUS)) {
				type = PLUS;
			} else if (stShapeType.equals(STShapeType.QUAD_ARROW)) {
				type = QUAD_ARROW;
			} else if (stShapeType.equals(STShapeType.QUAD_ARROW_CALLOUT)) {
				type = QUAD_ARROW_CALLOUT;
			} else if (stShapeType.equals(STShapeType.RECT)) {
				type = RECT;
			} else if (stShapeType.equals(STShapeType.RIBBON)) {
				type = RIBBON;
			} else if (stShapeType.equals(STShapeType.RIBBON_2)) {
				type = RIBBON_2;
			} else if (stShapeType.equals(STShapeType.RIGHT_ARROW)) {
				type = RIGHT_ARROW;
			} else if (stShapeType.equals(STShapeType.RIGHT_ARROW_CALLOUT)) {
				type = RIGHT_ARROW_CALLOUT;
			} else if (stShapeType.equals(STShapeType.RIGHT_BRACE)) {
				type = RIGHT_BRACE;
			} else if (stShapeType.equals(STShapeType.RIGHT_BRACKET)) {
				type = RIGHT_BRACKET;
			} else if (stShapeType.equals(STShapeType.ROUND_1_RECT)) {
				type = ROUND_1_RECT;
			} else if (stShapeType.equals(STShapeType.ROUND_2_DIAG_RECT)) {
				type = ROUND_2_DIAG_RECT;
			} else if (stShapeType.equals(STShapeType.ROUND_2_SAME_RECT)) {
				type = ROUND_2_SAME_RECT;
			} else if (stShapeType.equals(STShapeType.ROUND_RECT)) {
				type = ROUND_RECTANGLE;
			} else if (stShapeType.equals(STShapeType.RT_TRIANGLE)) {
				type = RT_TRIANGLE;
			} else if (stShapeType.equals(STShapeType.SMILEY_FACE)) {
				type = SMILEY_FACE;
			} else if (stShapeType.equals(STShapeType.SNIP_1_RECT)) {
				type = SNIP_1_RECT;
			} else if (stShapeType.equals(STShapeType.SNIP_2_DIAG_RECT)) {
				type = SNIP_2_DIAG_RECT;
			} else if (stShapeType.equals(STShapeType.SNIP_2_SAME_RECT)) {
				type = SNIP_2_SAME_RECT;
			} else if (stShapeType.equals(STShapeType.SNIP_ROUND_RECT)) {
				type = SNIP_ROUND_RECT;
			} else if (stShapeType.equals(STShapeType.SQUARE_TABS)) {
				type = SQUARE_TABS;
			} else if (stShapeType.equals(STShapeType.STAR_10)) {
				type = STAR_10;
			} else if (stShapeType.equals(STShapeType.STAR_12)) {
				type = STAR_12;
			} else if (stShapeType.equals(STShapeType.STAR_16)) {
				type = STAR_16;
			} else if (stShapeType.equals(STShapeType.STAR_24)) {
				type = STAR_24;
			} else if (stShapeType.equals(STShapeType.STAR_32)) {
				type = STAR_32;
			} else if (stShapeType.equals(STShapeType.STAR_4)) {
				type = STAR_4;
			} else if (stShapeType.equals(STShapeType.STAR_5)) {
				type = STAR_5;
			} else if (stShapeType.equals(STShapeType.STAR_6)) {
				type = STAR_6;
			} else if (stShapeType.equals(STShapeType.STAR_7)) {
				type = STAR_7;
			} else if (stShapeType.equals(STShapeType.STAR_8)) {
				type = STAR_8;
			} else if (stShapeType.equals(STShapeType.STRAIGHT_CONNECTOR_1)) {
				type = STRAIGHT_CONNECTOR_1;
			} else if (stShapeType.equals(STShapeType.STRIPED_RIGHT_ARROW)) {
				type = STRIPED_RIGHT_ARROW;
			} else if (stShapeType.equals(STShapeType.SUN)) {
				type = SUN;
			} else if (stShapeType.equals(STShapeType.SWOOSH_ARROW)) {
				type = SWOOSH_ARROW;
			} else if (stShapeType.equals(STShapeType.TRIANGLE)) {
				type = TRIANGLE;
			} else if (stShapeType.equals(STShapeType.TEARDROP)) {
				type = TEARDROP;
			} else if (stShapeType.equals(STShapeType.TRAPEZOID)) {
				type = TRAPEZOID;
			} else if (stShapeType.equals(STShapeType.UP_ARROW)) {
				type = UP_ARROW;
			} else if (stShapeType.equals(STShapeType.UP_ARROW_CALLOUT)) {
				type = UP_ARROW_CALLOUT;
			} else if (stShapeType.equals(STShapeType.UP_DOWN_ARROW)) {
				type = UP_DOWN_ARROW;
			} else if (stShapeType.equals(STShapeType.UP_DOWN_ARROW_CALLOUT)) {
				type = UP_DOWN_ARROW_CALLOUT;
			} else if (stShapeType.equals(STShapeType.UTURN_ARROW)) {
				type = UTURN_ARROW;
			} else if (stShapeType.equals(STShapeType.VERTICAL_SCROLL)) {
				type = VERTICAL_SCROLL;
			} else if (stShapeType.equals(STShapeType.WAVE)) {
				type = WAVE;
			} else if (stShapeType.equals(STShapeType.WEDGE_ELLIPSE_CALLOUT)) {
				type = WEDGE_ELLIPSE_CALLOUT;
			} else if (stShapeType.equals(STShapeType.WEDGE_RECT_CALLOUT)) {
				type = WEDGE_RECT_CALLOUT;
			} else if (stShapeType.equals(STShapeType.WEDGE_ROUND_RECT_CALLOUT)) {
				type = WEDGE_ROUND_RECT_CALLOUT;
			}

		}

		return type;
	}

	/**
	 * @param shapeId
	 * @return
	 */
	public static EnShapeType create(String shapeId) {

		if (shapeId.equals("undefined")) { //$NON-NLS-1$
			return UNDEFINED;

		} else if (shapeId.endsWith("_x0000_t4")) {
			return DIAMOND;
		} else if (shapeId.endsWith("_x0000_t5")) {
			return ISOCELES_TRIANGLE;
		} else if (shapeId.endsWith("_x0000_t5")) {
			return DIAMOND;
		} else if (shapeId.endsWith("_x0000_t6")) {
			return RIGHT_TRIANGLE;
		} else if (shapeId.endsWith("_x0000_t9")) {
			return HEXAGON;
		} else if (shapeId.endsWith("_x0000_t11")) {
			return CROSS;
		} else if (shapeId.endsWith("_x0000_t56")) {
			return REGULAR_PENTAGON;
		} else if (shapeId.endsWith("_x0000_t22")) {
			return CAN;
		} else if (shapeId.endsWith("_x0000_t16")) {
			return CUBE;
		} else if (shapeId.endsWith("_x0000_t65")) {
			return FOLDED_CORNER;
		} else if (shapeId.endsWith("_x0000_t23")) {
			return DONUT;
		} else if (shapeId.endsWith("_x0000_t95")) {
			return BLOCK_ARC;
		} else if (shapeId.endsWith("_x0000_t84")) {
			return BEVEL;
		} else if (shapeId.endsWith("_x0000_t74")) {
			return HEART;
		} else if (shapeId.endsWith("_x0000_t8")) {
			return TRAPEZOID;
		} else if (shapeId.endsWith("_x0000_t96")) {
			return SMILEY_FACE;
		} else if (shapeId.endsWith("_x0000_t184")) {
			return MOON;
		} else if (shapeId.endsWith("_x0000_t185")) {
			return DOUBLE_BRACKET;
		} else if (shapeId.endsWith("_x0000_t186")) {
			return DOUBLE_BRACE;
		} else if (shapeId.endsWith("_x0000_t21")) {
			return PLAQUE;
		} else if (shapeId.endsWith("_x0000_t85")) {
			return LEFT_BRACKET;
		} else if (shapeId.endsWith("_x0000_t86")) {
			return RIGHT_BRACKET;
		} else if (shapeId.endsWith("_x0000_t87")) {
			return LEFT_BRACE;
		} else if (shapeId.endsWith("_x0000_t88")) {
			return RIGHT_BRACE;
		} else if (shapeId.endsWith("_x0000_t7")) {
			return PARALLELOGRAM;
		} else if (shapeId.endsWith("_x0000_t13")) {
			return RIGHT_ARROW;
		} else if (shapeId.endsWith("_x0000_t66")) {
			return LEFT_ARROW;
		} else if (shapeId.endsWith("_x0000_t68")) {
			return UP_ARROW;
		} else if (shapeId.endsWith("_x0000_t67")) {
			return DOWN_ARROW;
		} else if (shapeId.endsWith("_x0000_t69")) {
			return LEFT_RIGHT_ARROW;
		} else if (shapeId.endsWith("_x0000_t70")) {
			return UP_DOWN_ARROW;
		} else if (shapeId.endsWith("_x0000_t76")) {
			return QUAD_ARROW;
		} else if (shapeId.endsWith("_x0000_t182")) {
			return LEFT_RIGHT_UP_ARROW;
		} else if (shapeId.endsWith("_x0000_t90")) {
			return BENT_ARROW;
		} else if (shapeId.endsWith("_x0000_t89")) {
			return LEFT_UP_ARROW;
		} else if (shapeId.endsWith("_x0000_t93")) {
			return STRIPED_RIGHT_ARROW;
		} else if (shapeId.endsWith("_x0000_t94")) {
			return NOTCHED_RIGHT_ARROW;
		} else if (shapeId.endsWith("_x0000_t15")) {
			return PENTAGON;
		} else if (shapeId.endsWith("_x0000_t55")) {
			return CHEVRON;
		} else if (shapeId.endsWith("_x0000_t78")) {
			return RIGHT_ARROW_CALLOUT;
		} else if (shapeId.endsWith("_x0000_t77")) {
			return LEFT_ARROW_CALLOUT;
		} else if (shapeId.endsWith("_x0000_t79")) {
			return UP_ARROW_CALLOUT;
		} else if (shapeId.endsWith("_x0000_t80")) {
			return DOWN_ARROW_CALLOUT;
		} else if (shapeId.endsWith("_x0000_t81")) {
			return LEFT_RIGHT_ARROW_CALLOUT;
		} else if (shapeId.endsWith("_x0000_t99")) {
			return CIRCULAR_ARROW;
		} else if (shapeId.endsWith("_x0000_t83")) {
			return QUAD_ARROW_CALLOUT;
		} else if (shapeId.endsWith("_x0000_t109")) {
			return FLOW_CHART_PROCESS;
		} else if (shapeId.endsWith("_x0000_t176")) {
			return FLOW_CHART_ALTERNATE_PROCESS;
		} else if (shapeId.endsWith("_x0000_t110")) {
			return FLOW_CHART_DECISION;
		} else if (shapeId.endsWith("_x0000_t111")) {
			return FLOW_CHART_DATA;
		} else if (shapeId.endsWith("_x0000_t112")) {
			return FLOW_CHART_PREDEFINED_PROCESS;
		} else if (shapeId.endsWith("_x0000_t113")) {
			return FLOW_CHART_INTERNAL_STORAGE;
		} else if (shapeId.endsWith("_x0000_t114")) {
			return FLOW_CHART_DOCUMENT;
		} else if (shapeId.endsWith("_x0000_t115")) {
			return FLOW_CHART_MULTIDOCUMENT;
		} else if (shapeId.endsWith("_x0000_t116")) {
			return FLOW_CHART_TERMINATOR;
		} else if (shapeId.endsWith("_x0000_t117")) {
			return FLOW_CHART_PREPARATION;
		} else if (shapeId.endsWith("_x0000_t118")) {
			return FLOW_CHART_MANUAL_INPUT;
		} else if (shapeId.endsWith("_x0000_t119")) {
			return FLOW_CHART_MANUAL_OPERATION;
		} else if (shapeId.endsWith("_x0000_t120")) {
			return FLOW_CHART_CONNECTOR;
		} else if (shapeId.endsWith("_x0000_t177")) {
			return FLOW_CHART_OFFPAGE_CONNECTOR;
		} else if (shapeId.endsWith("_x0000_t121")) {
			return FLOW_CHART_CARD;
		} else if (shapeId.endsWith("_x0000_t122")) {
			return FLOW_CHART_PUNCHED_TAPE;
		} else if (shapeId.endsWith("_x0000_t123")) {
			return FLOW_CHART_SUMMING_JUNCTION;
		} else if (shapeId.endsWith("_x0000_t124")) {
			return FLOW_CHART_OR;
		} else if (shapeId.endsWith("_x0000_t125")) {
			return FLOW_CHART_COLLATE;
		} else if (shapeId.endsWith("_x0000_t126")) {
			return FLOW_CHART_SORT;
		} else if (shapeId.endsWith("_x0000_t127")) {
			return FLOW_CHART_EXTRACT;
		} else if (shapeId.endsWith("_x0000_t128")) {
			return FLOW_CHART_MERGE;
		} else if (shapeId.endsWith("_x0000_t130")) {
			return FLOW_CHART_STORED_DATA;
		} else if (shapeId.endsWith("_x0000_t135")) {
			return FLOW_CHART_DELAY;
		} else if (shapeId.endsWith("_x0000_t131")) {
			return FLOW_CHART_SEQUENTIAL_ACCESS_STORAGE;
		} else if (shapeId.endsWith("_x0000_t132")) {
			return FLOW_CHART_MAGNETIC_DISK;
		} else if (shapeId.endsWith("_x0000_t133")) {
			return FLOW_CHART_DIRECT_ACCESS_STORAGE;
		} else if (shapeId.endsWith("_x0000_t134")) {
			return FLOW_CHART_DISPLAY;
		} else if (shapeId.endsWith("_x0000_t61")) {
			return RECTANGULAR_CALLOUT;
		} else if (shapeId.endsWith("_x0000_t62")) {
			return ROUNDED_RECTANGULAR_CALLOUT;
		} else if (shapeId.endsWith("_x0000_t63")) {
			return OVAL_CALLOUT;
		} else if (shapeId.endsWith("_x0000_t106")) {
			return CLOUD_CALLOUT;
		} else if (shapeId.endsWith("_x0000_t180")) {
			return LINE_CALLOUT;
		} else if (shapeId.endsWith("_x0000_t47")) {
			return LINE_CALLOUT_2;
		} else if (shapeId.endsWith("_x0000_t48")) {
			return LINE_CALLOUT_3;
		} else if (shapeId.endsWith("_x0000_t71")) {
			return EXPLOSION;
		} else if (shapeId.endsWith("_x0000_t133")) {
			return STAR_POINT_4;
		} else if (shapeId.endsWith("_x0000_t133")) {
			return STAR_POINT_5;
		} else if (shapeId.endsWith("_x0000_t133")) {
			return STAR_POINT_8;
		} else if (shapeId.endsWith("_x0000_t133")) {
			return VERTICAL_SCROLL;
		} else if (shapeId.endsWith("_x0000_t133")) {
			return HORIZONTAL_SCROLL;
		} else if (shapeId.endsWith("_x0000_t84")) { //$NON-NLS-1$
			return BEVEL;
		} else if (shapeId.endsWith("_x0000_t56")) { //$NON-NLS-1$
			return REGULAR_PENTAGON;
		} else if (shapeId.endsWith("_x0000_t125")) { //$NON-NLS-1$
			return FLOW_CHART_COLLATE;
		} else if (shapeId.endsWith("_x0000_t11")) { //$NON-NLS-1$
			return CROSS;
		} else if (shapeId.endsWith("_x0000_t9")) { //$NON-NLS-1$
			return HEXAGON;
		} else if (shapeId.endsWith("_x0000_t5")) { //$NON-NLS-1$
			return ISOCELES_TRIANGLE;
		} else if (shapeId.endsWith("_x0000_t6")) { //$NON-NLS-1$
			return RIGHT_TRIANGLE;
		} else if (shapeId.endsWith("_x0000_t10")) { //$NON-NLS-1$
			return OCTAGON;
		} else if (shapeId.endsWith("_x0000_t4")) { //$NON-NLS-1$
			return DIAMOND;
		} else if (shapeId.endsWith("_x0000_t8")) { //$NON-NLS-1$
			return TRAPEZOID;
		} else if (shapeId.endsWith("_x0000_t7")) { //$NON-NLS-1$
			return PARALLELOGRAM;
		} else if (shapeId.endsWith("_x0000_t38")) { //$NON-NLS-1$
			return CURVE;
		} else if (shapeId.endsWith("_x0000_t202")) { //$NON-NLS-1$
			return TEXTBOX;
		} else if (shapeId.endsWith("_x0000_t22")) { //$NON-NLS-1$
			return CYLINDER;
		} else if (shapeId.endsWith("_x0000_t23")) { //$NON-NLS-1$
			return DONUT;
		} else if (shapeId.endsWith("custom")) { //$NON-NLS-1$
			return FREEFORM;
		} else if (shapeId.endsWith("_x0000_t23")) { //$NON-NLS-1$
			return SCRIBBLE;
		} else if (shapeId.endsWith("_x0000_t32")) { //$NON-NLS-1$
			return LINE;

		} else if (shapeId.endsWith("_x0000_t136")) { //$NON-NLS-1$
			return textart_1;
		} else if (shapeId.endsWith("_x0000_t172")) { //$NON-NLS-1$
			return textart_2;
		} else if (shapeId.endsWith("_x0000_t144")) { //$NON-NLS-1$
			return textart_3;
		} else if (shapeId.endsWith("_x0000_t161")) { //$NON-NLS-1$
			return textart_4;
		} else if (shapeId.endsWith("_x0000_t175")) { //$NON-NLS-1$
			return textart_5;
		} else if (shapeId.endsWith("_x0000_t136")) { //$NON-NLS-1$
			return textart_6;
		} else if (shapeId.endsWith("_x0000_t136")) { //$NON-NLS-1$
			return textart_7;
		} else if (shapeId.endsWith("_x0000_t136")) { //$NON-NLS-1$
			return textart_8;
		} else if (shapeId.endsWith("_x0000_t136")) { //$NON-NLS-1$
			return textart_9;
		} else if (shapeId.endsWith("_x0000_t136")) { //$NON-NLS-1$
			return textart_10;
		} else if (shapeId.endsWith("_x0000_t136")) { //$NON-NLS-1$
			return textart_11;
		} else if (shapeId.endsWith("_x0000_t136")) { //$NON-NLS-1$
			return textart_12;
		} else if (shapeId.endsWith("_x0000_t136")) { //$NON-NLS-1$
			return textart_13;
		} else if (shapeId.endsWith("_x0000_t172")) { //$NON-NLS-1$
			return textart_14;
		} else if (shapeId.endsWith("_x0000_t136")) { //$NON-NLS-1$
			return textart_15;
		} else if (shapeId.endsWith("_x0000_t136")) { //$NON-NLS-1$
			return textart_16;
		} else if (shapeId.endsWith("_x0000_t156")) { //$NON-NLS-1$
			return textart_17;
		} else if (shapeId.endsWith("_x0000_t136")) { //$NON-NLS-1$
			return textart_18;
		} else if (shapeId.endsWith("_x0000_t136")) { //$NON-NLS-1$
			return textart_19;
		} else if (shapeId.endsWith("_x0000_t138")) { //$NON-NLS-1$
			return textart_20;
		} else if (shapeId.endsWith("_x0000_t170")) { //$NON-NLS-1$
			return textart_21;
		} else if (shapeId.endsWith("_x0000_t158")) { //$NON-NLS-1$
			return textart_22;
		} else if (shapeId.endsWith("_x0000_t152")) { //$NON-NLS-1$
			return textart_23;
		} else if (shapeId.endsWith("_x0000_t159")) { //$NON-NLS-1$
			return textart_24;
		} else if (shapeId.endsWith("_x0000_t136")) { //$NON-NLS-1$
			return textart_25;
		} else if (shapeId.endsWith("_x0000_t136")) { //$NON-NLS-1$
			return textart_26;
		} else if (shapeId.endsWith("_x0000_t163")) { //$NON-NLS-1$
			return textart_27;
		} else if (shapeId.endsWith("_x0000_t154")) { //$NON-NLS-1$
			return textart_28;
		} else if (shapeId.endsWith("_x0000_t136")) { //$NON-NLS-1$
			return textart_29;
		} else if (shapeId.endsWith("_x0000_t136")) { //$NON-NLS-1$
			return textart_30;

		} else {
			if (!shapeId.startsWith("#")) { //$NON-NLS-1$
				return create("#" + shapeId); //$NON-NLS-1$
			}
			return UNDEFINED;
		}

	}

}
