/*******************************************************************************
 * Copyright (c) 2003 - 2014 Ramin Assisi and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     Ramin Assisi - initial implementation
 *******************************************************************************/
package org.eclipse.rcpl.internal.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFColor;
import org.eclipse.rcpl.IColor;
import org.eclipse.rcpl.IColorProvider;
import org.eclipse.rcpl.IWorkbookPart;
import org.eclipse.rcpl.RcplColor;
import org.eclipse.rcpl.util.RcplUtil;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorScheme;
import org.openxmlformats.schemas.drawingml.x2006.main.CTHslColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTScRgbColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSchemeColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor;
import org.openxmlformats.schemas.drawingml.x2006.main.STColorSchemeIndex;
import org.openxmlformats.schemas.drawingml.x2006.main.STSchemeColorVal;
import org.openxmlformats.schemas.drawingml.x2006.main.STSystemColorVal;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRgbColor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBackground;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColorSchemeMapping;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHighlight;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHighlightColor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STThemeColor;

import javafx.scene.paint.Color;

/**
 * Provides access Color Resources
 */
public class RcplColorProvider implements IColorProvider {

	public static IColorProvider INSTANCE = new RcplColorProvider();

	private static Map<String, Color> colors = new HashMap<String, Color>(256);
	private static Map<Color, String> colorNames = new HashMap<Color, String>(256);

	static {
		colors.put("aliceblue", Color.ALICEBLUE);
		colors.put("antiquewhite", Color.ANTIQUEWHITE);
		colors.put("aqua", Color.AQUA);
		colors.put("aquamarine", Color.AQUAMARINE);
		colors.put("azure", Color.AZURE);
		colors.put("beige", Color.BEIGE);
		colors.put("bisque", Color.BISQUE);
		colors.put("black", Color.BLACK);
		colors.put("blanchedalmond", Color.BLANCHEDALMOND);
		colors.put("blue", Color.BLUE);
		colors.put("blueviolet", Color.BLUEVIOLET);
		colors.put("brown", Color.BROWN);
		colors.put("burlywood", Color.BURLYWOOD);
		colors.put("cadetblue", Color.CADETBLUE);
		colors.put("chartreuse", Color.CHARTREUSE);
		colors.put("chocolate", Color.CHOCOLATE);
		colors.put("coral", Color.CORAL);
		colors.put("cornflowerblue", Color.CORNFLOWERBLUE);
		colors.put("cornsilk", Color.CORNSILK);
		colors.put("crimson", Color.CRIMSON);
		colors.put("cyan", Color.CYAN);
		colors.put("darkblue", Color.DARKBLUE);
		colors.put("darkcyan", Color.DARKCYAN);
		colors.put("darkgoldenrod", Color.DARKGOLDENROD);
		colors.put("darkgray", Color.DARKGRAY);
		colors.put("darkgreen", Color.DARKGREEN);
		colors.put("darkgrey", Color.DARKGREY);
		colors.put("darkkhaki", Color.DARKKHAKI);
		colors.put("darkmagenta", Color.DARKMAGENTA);
		colors.put("darkolivegreen", Color.DARKOLIVEGREEN);
		colors.put("darkorange", Color.DARKORANGE);
		colors.put("darkorchid", Color.DARKORCHID);
		colors.put("darkred", Color.DARKRED);
		colors.put("darksalmon", Color.DARKSALMON);
		colors.put("darkseagreen", Color.DARKSEAGREEN);
		colors.put("darkslateblue", Color.DARKSLATEBLUE);
		colors.put("darkslategray", Color.DARKSLATEGRAY);
		colors.put("darkslategrey", Color.DARKSLATEGREY);
		colors.put("darkturquoise", Color.DARKTURQUOISE);
		colors.put("darkviolet", Color.DARKVIOLET);
		colors.put("deeppink", Color.DEEPPINK);
		colors.put("deepskyblue", Color.DEEPSKYBLUE);
		colors.put("dimgray", Color.DIMGRAY);
		colors.put("dimgrey", Color.DIMGREY);
		colors.put("dodgerblue", Color.DODGERBLUE);
		colors.put("firebrick", Color.FIREBRICK);
		colors.put("floralwhite", Color.FLORALWHITE);
		colors.put("forestgreen", Color.FORESTGREEN);
		colors.put("fuchsia", Color.FUCHSIA);
		colors.put("gainsboro", Color.GAINSBORO);
		colors.put("ghostwhite", Color.GHOSTWHITE);
		colors.put("gold", Color.GOLD);
		colors.put("goldenrod", Color.GOLDENROD);
		colors.put("gray", Color.GRAY);
		colors.put("green", Color.GREEN);
		colors.put("greenyellow", Color.GREENYELLOW);
		colors.put("grey", Color.GREY);
		colors.put("honeydew", Color.HONEYDEW);
		colors.put("hotpink", Color.HOTPINK);
		colors.put("indianred", Color.INDIANRED);
		colors.put("indigo", Color.INDIGO);
		colors.put("ivory", Color.IVORY);
		colors.put("khaki", Color.KHAKI);
		colors.put("lavender", Color.LAVENDER);
		colors.put("lavenderblush", Color.LAVENDERBLUSH);
		colors.put("lawngreen", Color.LAWNGREEN);
		colors.put("lemonchiffon", Color.LEMONCHIFFON);
		colors.put("lightblue", Color.LIGHTBLUE);
		colors.put("lightcoral", Color.LIGHTCORAL);
		colors.put("lightcyan", Color.LIGHTCYAN);
		colors.put("lightgoldenrodyellow", Color.LIGHTGOLDENRODYELLOW);
		colors.put("lightgray", Color.LIGHTGRAY);
		colors.put("lightgreen", Color.LIGHTGREEN);
		colors.put("lightgrey", Color.LIGHTGREY);
		colors.put("lightpink", Color.LIGHTPINK);
		colors.put("lightsalmon", Color.LIGHTSALMON);
		colors.put("lightseagreen", Color.LIGHTSEAGREEN);
		colors.put("lightskyblue", Color.LIGHTSKYBLUE);
		colors.put("lightslategray", Color.LIGHTSLATEGRAY);
		colors.put("lightslategrey", Color.LIGHTSLATEGREY);
		colors.put("lightsteelblue", Color.LIGHTSTEELBLUE);
		colors.put("lightyellow", Color.LIGHTYELLOW);
		colors.put("lime", Color.LIME);
		colors.put("limegreen", Color.LIMEGREEN);
		colors.put("linen", Color.LINEN);
		colors.put("magenta", Color.MAGENTA);
		colors.put("maroon", Color.MAROON);
		colors.put("mediumaquamarine", Color.MEDIUMAQUAMARINE);
		colors.put("mediumblue", Color.MEDIUMBLUE);
		colors.put("mediumorchid", Color.MEDIUMORCHID);
		colors.put("mediumpurple", Color.MEDIUMPURPLE);
		colors.put("mediumseagreen", Color.MEDIUMSEAGREEN);
		colors.put("mediumslateblue", Color.MEDIUMSLATEBLUE);
		colors.put("mediumspringgreen", Color.MEDIUMSPRINGGREEN);
		colors.put("mediumturquoise", Color.MEDIUMTURQUOISE);
		colors.put("mediumvioletred", Color.MEDIUMVIOLETRED);
		colors.put("midnightblue", Color.MIDNIGHTBLUE);
		colors.put("mintcream", Color.MINTCREAM);
		colors.put("mistyrose", Color.MISTYROSE);
		colors.put("moccasin", Color.MOCCASIN);
		colors.put("navajowhite", Color.NAVAJOWHITE);
		colors.put("navy", Color.NAVY);
		colors.put("oldlace", Color.OLDLACE);
		colors.put("olive", Color.OLIVE);
		colors.put("olivedrab", Color.OLIVEDRAB);
		colors.put("orange", Color.ORANGE);
		colors.put("orangered", Color.ORANGERED);
		colors.put("orchid", Color.ORCHID);
		colors.put("palegoldenrod", Color.PALEGOLDENROD);
		colors.put("palegreen", Color.PALEGREEN);
		colors.put("paleturquoise", Color.PALETURQUOISE);
		colors.put("palevioletred", Color.PALEVIOLETRED);
		colors.put("papayawhip", Color.PAPAYAWHIP);
		colors.put("peachpuff", Color.PEACHPUFF);
		colors.put("peru", Color.PERU);
		colors.put("pink", Color.PINK);
		colors.put("plum", Color.PLUM);
		colors.put("powderblue", Color.POWDERBLUE);
		colors.put("purple", Color.PURPLE);
		colors.put("red", Color.RED);
		colors.put("rosybrown", Color.ROSYBROWN);
		colors.put("royalblue", Color.ROYALBLUE);
		colors.put("saddlebrown", Color.SADDLEBROWN);
		colors.put("salmon", Color.SALMON);
		colors.put("sandybrown", Color.SANDYBROWN);
		colors.put("seagreen", Color.SEAGREEN);
		colors.put("seashell", Color.SEASHELL);
		colors.put("sienna", Color.SIENNA);
		colors.put("silver", Color.SILVER);
		colors.put("skyblue", Color.SKYBLUE);
		colors.put("slateblue", Color.SLATEBLUE);
		colors.put("slategray", Color.SLATEGRAY);
		colors.put("slategrey", Color.SLATEGREY);
		colors.put("snow", Color.SNOW);
		colors.put("springgreen", Color.SPRINGGREEN);
		colors.put("steelblue", Color.STEELBLUE);
		colors.put("tan", Color.TAN);
		colors.put("teal", Color.TEAL);
		colors.put("thistle", Color.THISTLE);
		colors.put("tomato", Color.TOMATO);
		colors.put("transparent", Color.TRANSPARENT);
		colors.put("turquoise", Color.TURQUOISE);
		colors.put("violet", Color.VIOLET);
		colors.put("wheat", Color.WHEAT);
		colors.put("white", Color.WHITE);
		colors.put("whitesmoke", Color.WHITESMOKE);
		colors.put("yellow", Color.YELLOW);
		colors.put("yellowgreen", Color.YELLOWGREEN);

		for (String key : colors.keySet()) {
			Color c = colors.get(key);
			colorNames.put(c, key);
		}
	}

	/**
	 * @author ramin
	 * 
	 */
	public static class BackgroundSettings {
		private Object control;

		private double brightness;

		public BackgroundSettings(Object controlOrFigure, double brightness) {
			this.control = controlOrFigure;
			this.brightness = brightness;
		}

		public double getBrightness() {
			return brightness;
		}

		public Object getControl() {
			return control;
		}
	}

	// private final static org.slf4j.Logger LOGGER = LoggerFactory
	// .getLogger(JOColorProvider.class);

	private static HashMap<String, IColor> colorRegistry = null;

	private static int[] INDEXED_COLOORS = {

			0x00000000, // 0
			0x00FFFFFF, // 1
			0x00FF0000, // 2
			0x0000FF00, // 3
			0x000000FF, // 4
			0x00FFFF00, // 5
			0x00FF00FF, // 6
			0x0000FFFF, // 7
			0x00000000, // 8
			0x00FFFFFF, // 9
			0x00FF0000, // 10
			0x0000FF00, // 11
			0x000000FF, // 12
			0x00FFFF00, // 13
			0x00FF00FF, // 14
			0x0000FFFF, // 15
			0x00800000, // 16
			0x00008000, // 17
			0x00000080, // 18
			0x00808000, // 19
			0x00800080, // 20
			0x00008080, // 21
			0x00C0C0C0, // 22
			0x00808080, // 23
			0x009999FF, // 24
			0x00993366, // 25
			0x00FFFFCC, // 26
			0x00CCFFFF, // 27
			0x00660066, // 28
			0x00FF8080, // 29
			0x000066CC, // 30
			0x00CCCCFF, // 31
			0x00000080, // 32
			0x00FF00FF, // 33
			0x00FFFF00, // 34
			0x0000FFFF, // 35
			0x00800080, // 36
			0x00800000, // 37
			0x00008080, // 38
			0x000000FF, // 39
			0x0000CCFF, // 40
			0x00CCFFFF, // 41
			0x00CCFFCC, // 42
			0x00FFFF99, // 43
			0x0099CCFF, // 44
			0x00FF99CC, // 45
			0x00CC99FF, // 46
			0x00FFCC99, // 47
			0x003366FF, // 48
			0x0033CCCC, // 49
			0x0099CC00, // 50
			0x00FFCC00, // 51
			0x00FF9900, // 52
			0x00FF6600, // 53
			0x00666699, // 54
			0x00969696, // 55
			0x00003366, // 56
			0x00339966, // 57
			0x00003300, // 58
			0x00333300, // 59
			0x00993300, // 60
			0x00993366, // 61
			0x00333399, // 62
			0x00333333, // 63
			-1, // System Foreground n/a
			-1, // System Background
	};

	private static List<BackgroundSettings> backgroundSettingList = new ArrayList<BackgroundSettings>();

	public static IColor accent1;

	public static IColor accent2;

	public static IColor accent3;

	public static IColor accent4;

	public static IColor accent5;

	public static IColor accent6;

	public static IColor background1;

	public static IColor background2;

	public static IColor dk2;

	public static IColor folHLink;

	public static IColor hLink;

	public static IColor lt1;

	public static IColor lt2;

	public static IColor textColor1;

	// ---------- spreadsheet colors -------------------------------------------

	public static IColor textColor2;

	public static IColor get(CTColor ctColor) {
		if (ctColor.getSrgbClr() != null) {
			byte[] bytes = ctColor.getSrgbClr().getVal();
			return INSTANCE.get(bytes);
		}
		if (ctColor.getSysClr() != null) {
			// STSystemColorVal.Enum sysColor = ctColor.getSysClr().getVal();
			// if(STSystemColorVal.WINDOW.equals(sysColor)){
			// return Display.getDefault().getSystemColor(SWT.color_)
			// }

			byte[] bytes = ctColor.getSysClr().getLastClr();
			return INSTANCE.get(bytes);
		}
		return IColor.RED;
	}

	/**
	 * Loads the colors
	 */
	public static void loadColors() {
		String colorMainOfficeColor = RcplUtil.getString(COLOR_MAIN_OFFICE_COLOR);
		if (colorMainOfficeColor != null) {
			colorRegistry.put(COLOR_MAIN_OFFICE_COLOR, string2Color(colorMainOfficeColor));
		} else {
			// colorRegistry.put(COLOR_MAIN_OFFICE_COLOR, new JORGB(220, 220,
			// 220));
			colorRegistry.put(COLOR_MAIN_OFFICE_COLOR, new RcplColor(164, 196, 246));

		}
	}

	/**
	 * @param rgbString
	 * @return
	 */
	public static IColor string2Color(String rgbString) {
		try {
			String[] cols = rgbString.split(","); //$NON-NLS-1$
			IColor result = new RcplColor(Integer.valueOf(cols[0].trim()), Integer.valueOf(cols[1].trim()),
					Integer.valueOf(cols[2].trim()));
			return result;
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * @param b
	 * @return
	 */
	private static int toInt(byte b) {
		int result = b;
		if (b < 0) {
			result = (b & 0x7f) + 128;
		}
		return result;
	}

	public IColor getOutlineColor = get(1.1);

	public IColor getOutlineShadowColor = get(0.6);

	public IColor getOutlineTextColor = get(0.3);

	private IColor transparentColor;

	public static IColor dk1;

	/**
	 * Private Constructor
	 */
	public RcplColorProvider() {
		// do nothing
	}

	/**
	 * @param color
	 * @return
	 */
	@Override
	public String colorToHexString(IColor color) {
		if (color == null) {
			return "000000"; //$NON-NLS-1$
		}
		String hexR = Integer.toHexString((int) color.getRed());
		String hexG = Integer.toHexString((int) color.getGreen());
		String hexB = Integer.toHexString((int) color.getBlue());
		if (hexR.length() == 1) {
			hexR = "0" + hexR; //$NON-NLS-1$
		}
		if (hexG.length() == 1) {
			hexG = "0" + hexG; //$NON-NLS-1$
		}
		if (hexB.length() == 1) {
			hexB = "0" + hexB; //$NON-NLS-1$
		}
		return hexR + hexG + hexB;
	}

	/**
	 * Initializes the {@link ColorRegistry}
	 */
	private void createColorRegistry() {
		colorRegistry = new HashMap<String, IColor>();
		loadColors();
	}

	@Override
	public void createColorScheme(CTColorScheme ctColorScheme) {
		accent1 = get(ctColorScheme.getAccent1());
		accent2 = get(ctColorScheme.getAccent2());
		accent3 = get(ctColorScheme.getAccent3());
		accent4 = get(ctColorScheme.getAccent4());
		accent5 = get(ctColorScheme.getAccent5());
		accent6 = get(ctColorScheme.getAccent6());
		dk1 = get(ctColorScheme.getDk1());
		dk2 = get(ctColorScheme.getDk2());
		folHLink = get(ctColorScheme.getFolHlink());
		hLink = get(ctColorScheme.getHlink());
		lt1 = get(ctColorScheme.getLt1());
		lt2 = get(ctColorScheme.getLt2());
		textColor1 = get(ctColorScheme.getAccent1());
		textColor2 = get(ctColorScheme.getAccent2());
		background1 = get(ctColorScheme.getDk1());
		background2 = get(ctColorScheme.getDk2());
	}

	/**
	 * @param bytes
	 * @return
	 */
	@Override
	public IColor get(byte[] bytes) {

		if (bytes == null) {
			// LOGGER.error("Color Triple wrong");
			return null;
		}
		if (bytes.length == 4) {
			return get(toInt(bytes[bytes.length - 3]), toInt(bytes[bytes.length - 2]), toInt(bytes[bytes.length - 1]));
		}
		if (bytes.length == 3) {
			return get(toInt(bytes[bytes.length - 3]), toInt(bytes[bytes.length - 2]), toInt(bytes[bytes.length - 1]));
		}
		return null;
	}

	/**
	 * @param color
	 * @param brightness
	 * @return
	 */
	public IColor get(Color color, double brightness) {
		return get(color, (float) brightness);
	}

	/**
	 * @param bg
	 * @return
	 */
	@Override
	public IColor get(CTBackground bg) {
		Object o = bg.getColor();
		if (o instanceof byte[]) {
			return get((byte[]) o);
		}
		if (bg.getThemeColor() != null) {
			return getThemeColor(null, bg.getThemeColor());
		}
		if (bg.getThemeShade() != null) {
		}

		return null;
	}

	@Override
	public IColor get(CTColorMapping colorMapping, CTSolidColorFillProperties fillProperties) {
		if (fillProperties != null) {
			CTHslColor ctHslColor = fillProperties.getHslClr();
			if (ctHslColor != null) {

			}
			CTPresetColor ctPresetColor = fillProperties.getPrstClr();
			if (ctPresetColor != null) {

			}
			CTSchemeColor ctSchemeColor = fillProperties.getSchemeClr();
			if (ctSchemeColor != null) {
				return getThemeColor(colorMapping, ctSchemeColor);
			}
			CTScRgbColor ctScRgbColor = fillProperties.getScrgbClr();
			if (ctScRgbColor != null) {
				return get(ctScRgbColor);
			}
			CTSRgbColor ctSRgbColor = fillProperties.getSrgbClr();
			if (ctSRgbColor != null) {
				return get(ctSRgbColor);
			}
			CTSystemColor ctSystemColor = fillProperties.getSysClr();
			if (ctSystemColor != null) {
				return get(ctSystemColor);
			}
		}
		return null;
	}

	@Override
	public IColor get(CTHighlight bg) {
		if (bg != null) {
			STHighlightColor.Enum en = bg.getVal();
			if (en.equals(STHighlightColor.BLACK)) {
				return IColor.BLACK;
			} else if (en.equals(STHighlightColor.WHITE)) {
				return IColor.WHITE;
			} else if (en.equals(STHighlightColor.RED)) {
				return IColor.RED;
			} else if (en.equals(STHighlightColor.BLUE)) {
				return IColor.BLUE;
			} else if (en.equals(STHighlightColor.YELLOW)) {
				return IColor.YELLOW;
			} else if (en.equals(STHighlightColor.DARK_RED)) {
				return get(139, 0, 0);
			} else if (en.equals(STHighlightColor.GREEN)) {
				return IColor.GREEN;
			} else if (en.equals(STHighlightColor.DARK_BLUE)) {
				return IColor.DARK_BLUE;
			} else if (en.equals(STHighlightColor.DARK_YELLOW)) {
				return get(Color.DARKSLATEGRAY);
			} else if (en.equals(STHighlightColor.DARK_GREEN)) {
				return get(javafx.scene.paint.Color.DARKGREEN);
			} else if (en.equals(STHighlightColor.CYAN)) {
				return get(Color.CYAN);
			} else if (en.equals(STHighlightColor.DARK_CYAN)) {
				return get(Color.DARKCYAN);
			} else if (en.equals(STHighlightColor.DARK_GRAY)) {
				return get(Color.DARKGREY);
			} else if (en.equals(STHighlightColor.DARK_MAGENTA)) {
				return get(Color.DARKMAGENTA);
			} else if (en.equals(STHighlightColor.DARK_RED)) {
				return get(Color.DARKRED);
			} else if (en.equals(STHighlightColor.DARK_YELLOW)) {
				return get(Color.DARKGOLDENROD);
			} else if (en.equals(STHighlightColor.LIGHT_GRAY)) {
				return get(Color.LIGHTGRAY);
			} else if (en.equals(STHighlightColor.MAGENTA)) {
				return get(Color.MAGENTA);
			}
		}
		return null;
	}

	@Override
	public IColor get(CTHslColor ctHslColor) {
		if (ctHslColor == null) {
			return null;
		}
		// TODO:
		// ctHslColor.get

		return get(100, 100, 100);
	}

	@Override
	public IColor get(CTPresetColor ctPresetColor) {
		if (ctPresetColor == null) {
			return null;
		}
		// TODO:
		// ctHslColor.get

		return get(100, 100, 100);
	}

	/**
	 * @param ctRgbColor
	 * @return
	 */
	@Override
	public IColor get(CTRgbColor ctRgbColor) {
		byte[] bytes = ctRgbColor.getRgb();
		return get(bytes);
	}

	/**
	 * @param ctScrgbColor
	 * @return
	 */
	@Override
	public IColor get(CTScRgbColor ctScrgbColor) {
		if (ctScrgbColor == null) {
			return null;
		}
		int r = ctScrgbColor.getR();
		int g = ctScrgbColor.getG();
		int b = ctScrgbColor.getB();

		return get(r, g, b);
	}

	/**
	 * @param bg
	 * @return
	 */
	@Override
	public IColor get(CTShd bg) {
		if (bg == null) {
			return null;
		}
		STShd.Enum val = bg.getVal();

		// Object color = bg.get();

		Object fill = bg.getFill();

		if (fill instanceof byte[]) {
			return get((byte[]) fill);
		}

		STThemeColor.Enum themeColor = bg.getThemeColor();
		if (themeColor != null) {
			return getThemeColor(null, themeColor);
		}
		STThemeColor.Enum themeFill = bg.getThemeFill();
		if (themeFill != null) {
			return getThemeColor(null, themeFill);
		}

		// byte[] themeFillShade = bg.getThemeFillShade();
		// byte[] themeFillTint = bg.getThemeFillTint();
		// byte[] themeShade = bg.getThemeShade();
		// byte[] themeTint = bg.getThemeTint();

		if (val.equals(STShd.CLEAR)) {

		}

		return null;
	}

	@Override
	public IColor get(CTSolidColorFillProperties fill) {
		IColor c = get(fill.getScrgbClr());
		if (c != null) {
			return c;
		}
		c = get(fill.getSrgbClr());
		if (c != null) {
			return c;
		}
		c = get(fill.getSysClr());
		if (c != null) {
			return c;
		}
		c = get(fill.getHslClr());
		if (c != null) {
			return c;
		}
		c = get(fill.getPrstClr());
		if (c != null) {
			return c;
		}
		c = getThemeColor(null, fill.getSchemeClr());
		if (c != null) {
			return c;
		}
		return null;
	}

	/**
	 * @param ctSrgbColor
	 * @return
	 */
	@Override
	public IColor get(CTSRgbColor ctSrgbColor) {
		if (ctSrgbColor == null) {
			return null;
		}
		byte[] bytes = ctSrgbColor.getVal();
		return get(bytes);
	}

	@Override
	public IColor get(CTSystemColor ctSystemColor) {
		if (ctSystemColor == null) {
			return null;
		}
		STSystemColorVal.Enum sysColor = ctSystemColor.getVal();

		// Color c;
		// if (sysColor.equals(STSystemColorVal.ACTIVE_BORDER)) {
		// c = Display.getDefault().getSystemColor(
		// SWT.COLOR_TITLE_INACTIVE_BACKGROUND);
		// } else if (sysColor.equals(STSystemColorVal.ACTIVE_CAPTION)) {
		// c = Display.getDefault().getSystemColor(SWT.COLOR_CYAN);
		// } else if (sysColor.equals(STSystemColorVal.APP_WORKSPACE)) {
		// c = Display.getDefault().getSystemColor(SWT.COLOR_CYAN);
		// } else if (sysColor.equals(STSystemColorVal.BACKGROUND)) {
		// c = Display.getDefault().getSystemColor(SWT.COLOR_CYAN);
		// } else if (sysColor.equals(STSystemColorVal.BTN_FACE)) {
		// c = Display.getDefault().getSystemColor(SWT.COLOR_CYAN);
		// } else if (sysColor.equals(STSystemColorVal.BTN_HIGHLIGHT)) {
		// c = Display.getDefault().getSystemColor(SWT.COLOR_CYAN);
		// } else if (sysColor.equals(STSystemColorVal.BTN_SHADOW)) {
		// c = Display.getDefault().getSystemColor(SWT.COLOR_CYAN);
		// } else if (sysColor.equals(STSystemColorVal.BTN_TEXT)) {
		// c = Display.getDefault().getSystemColor(SWT.COLOR_CYAN);
		// } else if (sysColor.equals(STSystemColorVal.CAPTION_TEXT)) {
		// c = Display.getDefault().getSystemColor(SWT.COLOR_CYAN);
		// } else if (sysColor.equals(STSystemColorVal.GRADIENT_ACTIVE_CAPTION))
		// {
		// c = Display.getDefault().getSystemColor(SWT.COLOR_CYAN);
		// } else if
		// (sysColor.equals(STSystemColorVal.GRADIENT_INACTIVE_CAPTION)) {
		// c = Display.getDefault().getSystemColor(SWT.COLOR_CYAN);
		// } else if (sysColor.equals(STSystemColorVal.GRAY_TEXT)) {
		// c = Display.getDefault().getSystemColor(SWT.COLOR_CYAN);
		// } else if (sysColor.equals(STSystemColorVal.HIGHLIGHT)) {
		// c = Display.getDefault().getSystemColor(SWT.COLOR_CYAN);
		// } else if (sysColor.equals(STSystemColorVal.HIGHLIGHT_TEXT)) {
		// c = Display.getDefault().getSystemColor(SWT.COLOR_CYAN);
		// } else if (sysColor.equals(STSystemColorVal.HOT_LIGHT)) {
		// c = Display.getDefault().getSystemColor(SWT.COLOR_CYAN);
		// } else if (sysColor.equals(STSystemColorVal.INACTIVE_BORDER)) {
		// c = Display.getDefault().getSystemColor(SWT.COLOR_CYAN);
		// } else if (sysColor.equals(STSystemColorVal.INACTIVE_CAPTION)) {
		// c = Display.getDefault().getSystemColor(SWT.COLOR_CYAN);
		// } else if (sysColor.equals(STSystemColorVal.INACTIVE_CAPTION_TEXT)) {
		// c = Display.getDefault().getSystemColor(SWT.COLOR_CYAN);
		// } else if (sysColor.equals(STSystemColorVal.INFO_BK)) {
		// c = Display.getDefault().getSystemColor(SWT.COLOR_CYAN);
		// } else if (sysColor.equals(STSystemColorVal.INFO_TEXT)) {
		// c = Display.getDefault().getSystemColor(SWT.COLOR_CYAN);
		// } else if (sysColor.equals(STSystemColorVal.MENU)) {
		// c = Display.getDefault().getSystemColor(SWT.COLOR_CYAN);
		// } else if (sysColor.equals(STSystemColorVal.MENU_BAR)) {
		// c = Display.getDefault().getSystemColor(SWT.COLOR_CYAN);
		// } else if (sysColor.equals(STSystemColorVal.MENU_HIGHLIGHT)) {
		// c = Display.getDefault().getSystemColor(SWT.COLOR_CYAN);
		// } else if (sysColor.equals(STSystemColorVal.MENU_TEXT)) {
		// c = Display.getDefault().getSystemColor(SWT.COLOR_CYAN);
		// } else if (sysColor.equals(STSystemColorVal.SCROLL_BAR)) {
		// c = Display.getDefault().getSystemColor(SWT.COLOR_CYAN);
		// } else if (sysColor.equals(STSystemColorVal.WINDOW)) {
		// c = Display.getDefault().getSystemColor(SWT.COLOR_CYAN);
		// } else if (sysColor.equals(STSystemColorVal.WINDOW_FRAME)) {
		// c = Display.getDefault().getSystemColor(SWT.COLOR_CYAN);
		// } else if (sysColor.equals(STSystemColorVal.WINDOW_TEXT)) {
		// c = Display.getDefault().getSystemColor(SWT.COLOR_CYAN);
		// } else if (sysColor.equals(STSystemColorVal.X_3_D_DK_SHADOW)) {
		// c = Display.getDefault().getSystemColor(SWT.COLOR_CYAN);
		// } else if (sysColor.equals(STSystemColorVal.X_3_D_LIGHT)) {
		// c = Display.getDefault().getSystemColor(SWT.COLOR_CYAN);
		// } else {
		// c = Display.getDefault().getSystemColor(SWT.COLOR_RED);
		// }
		// return getFromSwt(c);

		return IColor.RED;
	}

	@Override
	public IColor get(double brightness) {
		return get(COLOR_MAIN_OFFICE_COLOR, (float) brightness);
	}

	/**
	 * @param r
	 * @param g
	 * @param b
	 * @return the {@link Color}
	 */
	@Override
	public IColor get(double r, double g, double b) {
		if (colorRegistry == null) {
			createColorRegistry();
		}
		String symbolicName = "" + r + g + b;
		IColor color = colorRegistry.get(symbolicName);
		if (color == null) {
			colorRegistry.put(symbolicName, new RcplColor(r, g, b));
			return colorRegistry.get(symbolicName);
		}
		return color;
	}

	public IColor get(float brightness) {

		return get(COLOR_MAIN_OFFICE_COLOR, brightness);
	}

	@Override
	public IColor get(IColor color, double brightness) {
		String symbolicName = "" + color.hashCode() + brightness;
		IColor color2 = colorRegistry.get(symbolicName);
		if (color2 == null) {
			colorRegistry.put(symbolicName, transformRGB(color, brightness));
			return colorRegistry.get(symbolicName);
		}
		return color2;
	}

	@Override
	public IColor get(org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColor charStyleCtColor) {
		if (charStyleCtColor != null) {
			Object val = charStyleCtColor.getVal();
			if (val instanceof byte[]) {
				byte[] b = (byte[]) val;
				return get(b);
			}
		}
		return null;
	}

	@Override
	public IColor get(int brightness) {
		return get(COLOR_MAIN_OFFICE_COLOR, brightness);
	}

	@Override
	public IColor get(int[] bytes) {
		if (bytes == null || bytes.length != 3) {
			// LOGGER.error("Color Triple wrong");
			return null;
		}
		return get(bytes[0], bytes[1], bytes[2]);
	}

	/**
	 * @param awtColor
	 * @return
	 */
	@Override
	public IColor get(java.awt.Color awtColor) {
		IColor result = get(awtColor.getRed(), awtColor.getGreen(), awtColor.getBlue());
		return result;
	}

	@Override
	public IColor get(javafx.scene.paint.Color fxColor) {
		return new RcplColor(fxColor);
	}

	/**
	 * Retrieve a Color instance for a specific id from the {@link ColorRegistry}.
	 * The first call to this method will initialize the ColorRegstry.
	 * 
	 * @param id id of the font to be retrieved. Preferably use constants from
	 *           ColorProvider.
	 * @return the {@link Color} instance for the provided id.
	 */
	@Override
	public IColor get(String value) {

		if (value == null) {
			return null;
		}
		try {
			if (colorRegistry == null) {
				createColorRegistry();
			}
			if (value.startsWith("#")) { //$NON-NLS-1$
				int red = Integer.parseInt(value.substring(1, 3), 16);
				int green = Integer.parseInt(value.substring(3, 5), 16);
				int blue = Integer.parseInt(value.substring(5, 7), 16);
				return get(red, green, blue);
			} else if (value.toLowerCase().startsWith("white")) { //$NON-NLS-1$
				return IColor.WHITE;
			} else if (value.toLowerCase().startsWith("lightGray")) { //$NON-NLS-1$
				return IColor.LIGHT_GRAY;
			} else if (value.toLowerCase().startsWith("gray")) { //$NON-NLS-1$
				return IColor.GRAY;
			} else if (value.toLowerCase().startsWith("darkGray")) { //$NON-NLS-1$
				return IColor.GRAY;
			} else if (value.toLowerCase().startsWith("black")) { //$NON-NLS-1$
				return IColor.BLACK;
			} else if (value.toLowerCase().startsWith("red")) { //$NON-NLS-1$
				return IColor.RED;
			} else if (value.toLowerCase().startsWith("orange")) { //$NON-NLS-1$
				return IColor.ORANGE;
			} else if (value.toLowerCase().startsWith("yellow")) { //$NON-NLS-1$
				return IColor.YELLOW;
			} else if (value.toLowerCase().startsWith("green")) { //$NON-NLS-1$
				return IColor.GREEN;
			} else if (value.toLowerCase().startsWith("lightGreen")) { //$NON-NLS-1$
				return IColor.LIGHT_GRAY;
			} else if (value.toLowerCase().startsWith("darkGreen")) { //$NON-NLS-1$
				return IColor.GREEN;
			} else if (value.toLowerCase().startsWith("cyan")) { //$NON-NLS-1$
				return IColor.CYAN;
			} else if (value.toLowerCase().startsWith("lightBlue")) { //$NON-NLS-1$
				return IColor.LIGHT_GRAY;
			} else if (value.toLowerCase().startsWith("blue")) { //$NON-NLS-1$
				return IColor.BLUE;
			} else if (value.toLowerCase().startsWith("darkBlue")) { //$NON-NLS-1$
				return IColor.DARK_BLUE;
			} else {
				return colorRegistry.get(value);
			}
		} catch (Exception ex) {
			return IColor.RED;
		}
	}

	@Override
	public IColor get(String key, double brightness) {
		return null;
	}

	/**
	 * @param id
	 * @param brightness
	 * @return
	 */
	@Override
	public IColor get(String id, float brightness) {
		IColor result = null;
		if (brightness == 1.0) {
			result = get(id);
		} else {
			String newId = id + brightness;
			result = get(newId);
			if (result == null) {
				IColor cOriginal = get(id);
				if (cOriginal != null) {
					IColor rgb = transformRGB(cOriginal, brightness);
					colorRegistry.put(newId, rgb);
					result = colorRegistry.get(newId);
				}
			}
		}
		return result;
	}

	@Override
	public IColor get(STSystemColorVal.Enum sysColor) {

		String s = sysColor.toString();

		if (s.equals("windowText")) { //$NON-NLS-1$
			return get(200, 200, 200);
		}
		int sysCol = sysColor.intValue();
		// try {
		// return getFromSwt(Display.getDefault().getSystemColor(sysCol));
		// } catch (Exception ex) {
		// return IColor.RED;
		// }

		return IColor.RED;

	}

	// public IColor getThemeColor(STThemeColor.Enum themeColor) {
	// return getThemeColor(null, themeColor);
	// }

	@Override
	public IColor get(XSSFColor xSSFColor) {
		if (xSSFColor == null) {
			return null;
		}
		return get(xSSFColor.getRGB());
	}

	@Override
	public IColor getBrightColor(double brightness) {
		return getBrightColor(COLOR_MAIN_OFFICE_COLOR, (float) brightness);
	}

	@Override
	public IColor getBrightColor(String id, float brightness) {
		IColor result = null;
		if (brightness == 1.0) {
			result = get(id + "bright"); //$NON-NLS-1$
		} else {
			String newId = id + brightness + "bright"; //$NON-NLS-1$
			result = get(newId);
			if (result == null) {
				IColor cOriginal = get(id);
				if (cOriginal != null) {
					IColor rgb = transformRGB(cOriginal, brightness);

					double red = 0;
					double green = 0;
					double blue = 0;
					if (rgb.getBlue() > 0) {
						blue = 255 / rgb.getBlue() * rgb.getBlue();
					}
					if (rgb.getGreen() > 0) {
						green = 255 / rgb.getGreen() * rgb.getGreen();
					}
					if (rgb.getRed() > 0) {
						red = 255 / rgb.getRed() * rgb.getRed();
					}
					colorRegistry.put(newId, new RcplColor(red, green, blue));
					result = colorRegistry.get(newId);
				}
			}
		}
		return result;
	}

	/**
	 * @param brightness makes the color brighter when its too dark
	 * @return
	 */
	@Override
	public IColor getBrighterColor(double brightness) {
		IColor c = get(brightness);
		// if (isDark()) {
		// javafx.scene.paint.Color col = c.getFx().brighter();
		// return get(col);
		// }
		return c;
	}

	@Override
	public byte[] getBytesFromCOLOR(IColor color) {
		byte[] result = new byte[3];
		result[0] = (byte) color.getRed();
		result[1] = (byte) color.getGreen();
		result[2] = (byte) color.getBlue();
		return result;
	}

	@Override
	public IColor getDefaultShapeColor() {
		return get(108, 174, 255);
	}

	@Override
	public IColor getFgColor() {
		// if (isDark()) {
		// return ColorConstants.white;
		// }
		return get(0.3);
	}

	@Override
	public IColor getFromSwt(Object color) {
		Color c = (Color) color;
		return new RcplColor(c);
	}

	@Override
	public IColor getFromSwt(Object color, double brightness) {
		return get(getFromSwt(color), brightness);
	}

	@Override
	public javafx.scene.paint.Color getFx(IColor color) {
		return new javafx.scene.paint.Color(color.getRed(), color.getGreen(), color.getBlue(), color.getOpacity());
	}

	@Override
	public STHighlightColor.Enum getHighlightColor(IColor bg) {
		if (bg != null) {
			if (bg.equals(IColor.BLACK)) {
				return STHighlightColor.BLACK;
			} else if (bg.equals(IColor.WHITE)) {
				return STHighlightColor.WHITE;
			} else if (bg.equals(IColor.RED)) {
				return STHighlightColor.RED;
			} else if (bg.equals(IColor.BLUE)) {
				return STHighlightColor.BLUE;
			} else if (bg.equals(IColor.YELLOW)) {
				return STHighlightColor.YELLOW;
			} else if (bg.equals(get(139, 0, 0))) {
				return STHighlightColor.CYAN;
			} else if (bg.equals(IColor.CYAN)) {
				return STHighlightColor.GREEN;
			} else if (bg.equals(IColor.DARK_BLUE)) {
				return STHighlightColor.DARK_BLUE;
			} else if (bg.equals(get(255, 209, 42))) {
				return STHighlightColor.DARK_BLUE;
			} else if (bg.equals(IColor.BLACK)) {
				return STHighlightColor.BLACK;
			} else if (bg.equals(IColor.BLACK)) {
				return STHighlightColor.BLACK;
			} else if (bg.equals(IColor.BLACK)) {
				return STHighlightColor.BLACK;
			} else if (bg.equals(IColor.BLACK)) {
				return STHighlightColor.BLACK;
			} else if (bg.equals(IColor.BLACK)) {
				return STHighlightColor.BLACK;
			} else if (bg.equals(IColor.BLACK)) {
				return STHighlightColor.BLACK;
			} else if (bg.equals(IColor.BLACK)) {
				return STHighlightColor.BLACK;
			} else if (bg.equals(IColor.BLACK)) {
				return STHighlightColor.BLACK;
			} else if (bg.equals(IColor.BLACK)) {
				return STHighlightColor.BLACK;
			} else if (bg.equals(IColor.BLACK)) {
				return STHighlightColor.BLACK;
			}
		}
		return null;
	}

	/**
	 * @param highlightColor
	 * @return
	 */
	@Override
	public IColor getHighlightColor(int highlightColor) {
		switch (highlightColor) {
		case STHighlightColor.INT_BLACK:
			return IColor.BLACK;
		case STHighlightColor.INT_BLUE:
			return IColor.BLUE;
		case STHighlightColor.INT_CYAN:
			return IColor.CYAN;
		case STHighlightColor.INT_DARK_BLUE:
			return IColor.DARK_BLUE;
		case STHighlightColor.INT_DARK_CYAN:
			return IColor.RED;
		case STHighlightColor.INT_DARK_GRAY:
			return IColor.RED;
		case STHighlightColor.INT_DARK_GREEN:
			return IColor.GREEN;
		case STHighlightColor.INT_DARK_MAGENTA:
			return IColor.RED;
		case STHighlightColor.INT_DARK_RED:
			return IColor.RED;
		case STHighlightColor.INT_DARK_YELLOW:
			return IColor.RED;
		case STHighlightColor.INT_GREEN:
			return IColor.GREEN;
		case STHighlightColor.INT_LIGHT_GRAY:
			return IColor.LIGHT_GRAY;
		case STHighlightColor.INT_MAGENTA:
			return IColor.RED;
		case STHighlightColor.INT_NONE:
			return IColor.RED;
		case STHighlightColor.INT_RED:
			return IColor.RED;
		case STHighlightColor.INT_WHITE:
			return IColor.WHITE;
		case STHighlightColor.INT_YELLOW:
			return IColor.YELLOW;
		default:
			return IColor.WHITE;
		}
	}

	@Override
	public IColor getOutlineColor() {
		return get(1);
	}

	@Override
	public IColor getOutlineShadowColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IColor getOutlineTextColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IColor getSelectedParagraphColor() {
		return IColor.ORANGE;
	}

	@Override
	public IColor getSignalColor() {
		return IColor.ORANGE;
	}

	@Override
	public IColor getTextSelectionColorBackground() {
		return get(1.1);
	}

	// ///////////////////////////////////////////////////////////////////
	// /////////////////////// Private From Here /////////////////////////
	// ///////////////////////////////////////////////////////////////////

	@Override
	public IColor getTextSelectionColorForground(IColor fg) {
		if (isDark(fg)) {
			return IColor.WHITE;
		}
		return fg;
	}

	@Override
	public IColor getThemeColor(CTColorMapping colorMapping, CTSchemeColor schemeColor) {

		if (schemeColor == null) {
			return null;
		}
		// if(schemeColor.equals(CTSchemeColor.))
		STSchemeColorVal.Enum en = schemeColor.getVal();

		if (en.equals(STSchemeColorVal.ACCENT_1)) {
			if (colorMapping != null) {
				STColorSchemeIndex.Enum stSchemeIndex = colorMapping.getAccent1();
				IColor c = schemeIndexToChemeColor(stSchemeIndex);
				if (c != null) {
					return c;
				}
			}
			return accent1;
		} else if (en.equals(STSchemeColorVal.ACCENT_2)) {
			if (colorMapping != null) {
				STColorSchemeIndex.Enum stSchemeIndex = colorMapping.getAccent2();
				IColor c = schemeIndexToChemeColor(stSchemeIndex);
				if (c != null) {
					return c;
				}
			}
			return accent2;
		} else if (en.equals(STSchemeColorVal.ACCENT_3)) {
			if (colorMapping != null) {
				STColorSchemeIndex.Enum stSchemeIndex = colorMapping.getAccent3();
				IColor c = schemeIndexToChemeColor(stSchemeIndex);
				if (c != null) {
					return c;
				}
			}
			return accent3;
		} else if (en.equals(STSchemeColorVal.ACCENT_4)) {
			if (colorMapping != null) {
				STColorSchemeIndex.Enum stSchemeIndex = colorMapping.getAccent4();
				IColor c = schemeIndexToChemeColor(stSchemeIndex);
				if (c != null) {
					return c;
				}
			}
			return accent4;
		} else if (en.equals(STSchemeColorVal.ACCENT_5)) {
			if (colorMapping != null) {
				STColorSchemeIndex.Enum stSchemeIndex = colorMapping.getAccent5();
				IColor c = schemeIndexToChemeColor(stSchemeIndex);
				if (c != null) {
					return c;
				}
			}
			return accent5;
		} else if (en.equals(STSchemeColorVal.ACCENT_6)) {
			if (colorMapping != null) {
				STColorSchemeIndex.Enum stSchemeIndex = colorMapping.getAccent6();
				IColor c = schemeIndexToChemeColor(stSchemeIndex);
				if (c != null) {
					return c;
				}
			}
			return accent6;
		} else if (en.equals(STSchemeColorVal.BG_1)) {
			if (colorMapping != null) {
				STColorSchemeIndex.Enum stSchemeIndex = colorMapping.getBg1();
				IColor c = schemeIndexToChemeColor(stSchemeIndex);
				if (c != null) {
					return c;
				}
			}
			return background1;
		} else if (en.equals(STSchemeColorVal.BG_2)) {
			if (colorMapping != null) {
				STColorSchemeIndex.Enum stSchemeIndex = colorMapping.getBg2();
				IColor c = schemeIndexToChemeColor(stSchemeIndex);
				if (c != null) {
					return c;
				}
			}
			return background2;
		} else if (en.equals(STSchemeColorVal.DK_1)) {
			return dk1;
		} else if (en.equals(STSchemeColorVal.DK_2)) {
			return dk2;
		} else if (en.equals(STSchemeColorVal.HLINK)) {
			if (colorMapping != null) {
				STColorSchemeIndex.Enum stSchemeIndex = colorMapping.getHlink();
				IColor c = schemeIndexToChemeColor(stSchemeIndex);
				if (c != null) {
					return c;
				}
			}
			return hLink;
		} else if (en.equals(STSchemeColorVal.FOL_HLINK)) {
			if (colorMapping != null) {
				STColorSchemeIndex.Enum stSchemeIndex = colorMapping.getFolHlink();
				IColor c = schemeIndexToChemeColor(stSchemeIndex);
				if (c != null) {
					return c;
				}
			}
			return folHLink;
		} else if (en.equals(STSchemeColorVal.LT_1)) {
			return lt1;
		} else if (en.equals(STSchemeColorVal.LT_2)) {
			return lt2;
		} else if (en.equals(STSchemeColorVal.PH_CLR)) {
			return new RcplColor(255, 0, 0);
		} else if (en.equals(STSchemeColorVal.TX_1)) {
			if (colorMapping != null) {
				STColorSchemeIndex.Enum stSchemeIndex = colorMapping.getTx1();
				IColor c = schemeIndexToChemeColor(stSchemeIndex);
				if (c != null) {
					return c;
				}
			}
			return textColor1;
		} else if (en.equals(STSchemeColorVal.TX_2)) {
			if (colorMapping != null) {
				STColorSchemeIndex.Enum stSchemeIndex = colorMapping.getTx2();
				IColor c = schemeIndexToChemeColor(stSchemeIndex);
				if (c != null) {
					return c;
				}
			}
			return textColor2;
		}
		return null;

	}

	@Override
	public IColor getThemeColor(CTColorMapping colorMapping, STThemeColor.Enum themeColor) {
		if (themeColor.equals(STThemeColor.ACCENT_1)) {
			if (colorMapping != null) {
				STColorSchemeIndex.Enum stSchemeIndex = colorMapping.getAccent1();
				IColor c = schemeIndexToChemeColor(stSchemeIndex);
				if (c != null) {
					return c;
				}
			}
			return accent1;
		}
		if (themeColor.equals(STThemeColor.ACCENT_2)) {
			if (colorMapping != null) {
				STColorSchemeIndex.Enum stSchemeIndex = colorMapping.getAccent2();
				IColor c = schemeIndexToChemeColor(stSchemeIndex);
				if (c != null) {
					return c;
				}
			}
			return accent2;
		}
		if (themeColor.equals(STThemeColor.ACCENT_3)) {
			if (colorMapping != null) {
				STColorSchemeIndex.Enum stSchemeIndex = colorMapping.getAccent3();
				IColor c = schemeIndexToChemeColor(stSchemeIndex);
				if (c != null) {
					return c;
				}
			}
			return accent3;
		}
		if (themeColor.equals(STThemeColor.ACCENT_4)) {
			if (colorMapping != null) {
				STColorSchemeIndex.Enum stSchemeIndex = colorMapping.getAccent4();
				IColor c = schemeIndexToChemeColor(stSchemeIndex);
				if (c != null) {
					return c;
				}
			}
			return accent4;
		}
		if (themeColor.equals(STThemeColor.ACCENT_5)) {
			if (colorMapping != null) {
				STColorSchemeIndex.Enum stSchemeIndex = colorMapping.getAccent5();
				IColor c = schemeIndexToChemeColor(stSchemeIndex);
				if (c != null) {
					return c;
				}
			}
			return accent5;
		}
		if (themeColor.equals(STThemeColor.ACCENT_6)) {
			if (colorMapping != null) {
				STColorSchemeIndex.Enum stSchemeIndex = colorMapping.getAccent6();
				IColor c = schemeIndexToChemeColor(stSchemeIndex);
				if (c != null) {
					return c;
				}
			}
			return accent6;
		}
		if (themeColor.equals(STThemeColor.BACKGROUND_1)) {
			if (colorMapping != null) {
				STColorSchemeIndex.Enum stSchemeIndex = colorMapping.getBg1();
				IColor c = schemeIndexToChemeColor(stSchemeIndex);
				if (c != null) {
					return c;
				}
			}
			return background1;
		}
		if (themeColor.equals(STThemeColor.BACKGROUND_2)) {
			if (colorMapping != null) {
				STColorSchemeIndex.Enum stSchemeIndex = colorMapping.getBg2();
				IColor c = schemeIndexToChemeColor(stSchemeIndex);
				if (c != null) {
					return c;
				}
			}
			return background2;
		}
		if (themeColor.equals(STThemeColor.FOLLOWED_HYPERLINK)) {
			if (colorMapping != null) {
				STColorSchemeIndex.Enum stSchemeIndex = colorMapping.getFolHlink();
				IColor c = schemeIndexToChemeColor(stSchemeIndex);
				if (c != null) {
					return c;
				}
			}
			return folHLink;
		}
		if (themeColor.equals(STThemeColor.HYPERLINK)) {
			if (colorMapping != null) {
				STColorSchemeIndex.Enum stSchemeIndex = colorMapping.getHlink();
				IColor c = schemeIndexToChemeColor(stSchemeIndex);
				if (c != null) {
					return c;
				}
			}
			return hLink;
		}
		if (themeColor.equals(STThemeColor.LIGHT_1)) {
			return lt1;
		}
		if (themeColor.equals(STThemeColor.LIGHT_2)) {
			return lt2;
		}
		if (themeColor.equals(STThemeColor.DARK_1)) {
			return dk1;
		}
		if (themeColor.equals(STThemeColor.DARK_2)) {
			return dk2;
		}
		if (themeColor.equals(STThemeColor.TEXT_1)) {
			if (colorMapping != null) {
				STColorSchemeIndex.Enum stSchemeIndex = colorMapping.getTx1();
				IColor c = schemeIndexToChemeColor(stSchemeIndex);
				if (c != null) {
					return c;
				}
			}
			return textColor1;
		}
		if (themeColor.equals(STThemeColor.TEXT_2)) {
			if (colorMapping != null) {
				STColorSchemeIndex.Enum stSchemeIndex = colorMapping.getTx2();
				IColor c = schemeIndexToChemeColor(stSchemeIndex);
				if (c != null) {
					return c;
				}
			}
			return textColor2;
		}
		return IColor.GRAY;
	}

	/**
	 * @param colorMapping
	 * @param schemeColor
	 * @return
	 */
	@Override
	public IColor getThemeColor(CTColorSchemeMapping colorMapping, STThemeColor themeColor) {

		if (themeColor == null) {
			return null;
		}
		org.openxmlformats.schemas.wordprocessingml.x2006.main.STColorSchemeIndex.Enum stSchemeIndex;

		if (themeColor.enumValue().equals(STThemeColor.ACCENT_1)) {
			if (colorMapping != null) {
				stSchemeIndex = colorMapping.getAccent1();
				IColor c = schemeIndexToChemeColor(stSchemeIndex);
				if (c != null) {
					return c;
				}
			}
			return accent1;
		} else if (themeColor.enumValue().equals(STThemeColor.ACCENT_2)) {
			if (colorMapping != null) {
				stSchemeIndex = colorMapping.getAccent2();
				IColor c = schemeIndexToChemeColor(stSchemeIndex);
				if (c != null) {
					return c;
				}
			}
			return accent2;
		} else if (themeColor.enumValue().equals(STThemeColor.ACCENT_3)) {
			if (colorMapping != null) {
				stSchemeIndex = colorMapping.getAccent3();
				IColor c = schemeIndexToChemeColor(stSchemeIndex);
				if (c != null) {
					return c;
				}
			}
			return accent3;
		} else if (themeColor.enumValue().equals(STThemeColor.ACCENT_4)) {
			if (colorMapping != null) {
				stSchemeIndex = colorMapping.getAccent4();
				IColor c = schemeIndexToChemeColor(stSchemeIndex);
				if (c != null) {
					return c;
				}
			}
			return accent4;
		} else if (themeColor.enumValue().equals(STThemeColor.ACCENT_5)) {
			if (colorMapping != null) {
				stSchemeIndex = colorMapping.getAccent5();
				IColor c = schemeIndexToChemeColor(stSchemeIndex);
				if (c != null) {
					return c;
				}
			}
			return accent5;
		} else if (themeColor.enumValue().equals(STThemeColor.ACCENT_6)) {
			if (colorMapping != null) {
				stSchemeIndex = colorMapping.getAccent6();
				IColor c = schemeIndexToChemeColor(stSchemeIndex);
				if (c != null) {
					return c;
				}
			}
			return accent6;
		} else if (themeColor.enumValue().equals(STThemeColor.BACKGROUND_1)) {
			if (colorMapping != null) {
				stSchemeIndex = colorMapping.getBg1();
				IColor c = schemeIndexToChemeColor(stSchemeIndex);
				if (c != null) {
					return c;
				}
			}
			return background1;
		} else if (themeColor.enumValue().equals(STThemeColor.BACKGROUND_2)) {
			if (colorMapping != null) {
				stSchemeIndex = colorMapping.getBg2();
				IColor c = schemeIndexToChemeColor(stSchemeIndex);
				if (c != null) {
					return c;
				}
			}
			return background2;
		} else if (themeColor.enumValue().equals(STThemeColor.DARK_1)) {
			return dk1;
		} else if (themeColor.enumValue().equals(STThemeColor.DARK_2)) {
			return dk2;
		} else if (themeColor.enumValue().equals(STThemeColor.HYPERLINK)) {
			if (colorMapping != null) {
				stSchemeIndex = colorMapping.getHyperlink();
				IColor c = schemeIndexToChemeColor(stSchemeIndex);
				if (c != null) {
					return c;
				}
			}
			return hLink;
		} else if (themeColor.enumValue().equals(STThemeColor.FOLLOWED_HYPERLINK)) {
			if (colorMapping != null) {
				stSchemeIndex = colorMapping.getFollowedHyperlink();
				IColor c = schemeIndexToChemeColor(stSchemeIndex);
				if (c != null) {
					return c;
				}
			}
			return folHLink;
		} else if (themeColor.enumValue().equals(STThemeColor.LIGHT_1)) {
			return lt1;
		} else if (themeColor.enumValue().equals(STThemeColor.LIGHT_2)) {
			return lt2;
		} else if (themeColor.enumValue().equals(STThemeColor.TEXT_1)) {
			if (colorMapping != null) {
				stSchemeIndex = colorMapping.getT1();
				IColor c = schemeIndexToChemeColor(stSchemeIndex);
				if (c != null) {
					return c;
				}
			}
			return textColor1;
		} else if (themeColor.enumValue().equals(STThemeColor.TEXT_2)) {
			if (colorMapping != null) {
				stSchemeIndex = colorMapping.getT2();
				IColor c = schemeIndexToChemeColor(stSchemeIndex);
				if (c != null) {
					return c;
				}
			}
			return textColor2;
		}
		return IColor.RED;

	}

	@Override
	public IColor getToolTipColor() {
		return get(250, 250, 0);
	}

	/**
	 * @return
	 */
	@Override
	public IColor getTransparentColor() {
		if (transparentColor == null) {
			// transparentColor = get(255, 51, 204);
			transparentColor = get(250, 250, 250);
		}
		return transparentColor;
	}

	@Override
	public boolean isDark() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isDark(IColor c) {
		if (c == null) {
			return false;
		}
		double red = c.getRed();
		double green = c.getGreen();
		double blue = c.getBlue();
		double brightness = red + green + blue;
		return brightness < (3 * 128);
	}

	@Override
	public Object loadSwt(IColor color) {
		// return new Color(null, (int) color.getRed(), (int) color.getGreen(),
		// (int) color.getBlue());

		return null;
	}

	private IColor schemeIndexToChemeColor(
			org.openxmlformats.schemas.wordprocessingml.x2006.main.STColorSchemeIndex.Enum stSchemeIndex) {
		if (stSchemeIndex.equals(STColorSchemeIndex.ACCENT_1)) {
			return accent1;
		}
		if (stSchemeIndex.equals(STColorSchemeIndex.ACCENT_2)) {
			return accent2;
		}
		if (stSchemeIndex.equals(STColorSchemeIndex.ACCENT_3)) {
			return accent3;
		}
		if (stSchemeIndex.equals(STColorSchemeIndex.ACCENT_4)) {
			return accent4;
		}
		if (stSchemeIndex.equals(STColorSchemeIndex.ACCENT_5)) {
			return accent5;
		}
		if (stSchemeIndex.equals(STColorSchemeIndex.ACCENT_6)) {
			return accent6;
		}
		if (stSchemeIndex.equals(STColorSchemeIndex.DK_1)) {
			return dk1;
		}
		if (stSchemeIndex.equals(STColorSchemeIndex.DK_2)) {
			return dk2;
		}
		if (stSchemeIndex.equals(STColorSchemeIndex.FOL_HLINK)) {
			return folHLink;
		}
		if (stSchemeIndex.equals(STColorSchemeIndex.HLINK)) {
			return hLink;
		}
		if (stSchemeIndex.equals(STColorSchemeIndex.LT_1)) {
			return lt1;
		}
		if (stSchemeIndex.equals(STColorSchemeIndex.LT_2)) {
			return lt2;
		}
		return null;
	}

	private IColor schemeIndexToChemeColor(STColorSchemeIndex.Enum stSchemeIndex) {
		if (stSchemeIndex.equals(STColorSchemeIndex.ACCENT_1)) {
			return accent1;
		}
		if (stSchemeIndex.equals(STColorSchemeIndex.ACCENT_2)) {
			return accent2;
		}
		if (stSchemeIndex.equals(STColorSchemeIndex.ACCENT_3)) {
			return accent3;
		}
		if (stSchemeIndex.equals(STColorSchemeIndex.ACCENT_4)) {
			return accent4;
		}
		if (stSchemeIndex.equals(STColorSchemeIndex.ACCENT_5)) {
			return accent5;
		}
		if (stSchemeIndex.equals(STColorSchemeIndex.ACCENT_6)) {
			return accent6;
		}
		if (stSchemeIndex.equals(STColorSchemeIndex.DK_1)) {
			return dk1;
		}
		if (stSchemeIndex.equals(STColorSchemeIndex.DK_2)) {
			return dk2;
		}
		if (stSchemeIndex.equals(STColorSchemeIndex.FOL_HLINK)) {
			return folHLink;
		}
		if (stSchemeIndex.equals(STColorSchemeIndex.HLINK)) {
			return hLink;
		}
		if (stSchemeIndex.equals(STColorSchemeIndex.LT_1)) {
			return lt1;
		}
		if (stSchemeIndex.equals(STColorSchemeIndex.LT_2)) {
			return lt2;
		}
		return null;
	}

	public void setMainOfficeColor(IColor newColor) {
		colorRegistry = new HashMap<String, IColor>();
		colorRegistry.put(COLOR_MAIN_OFFICE_COLOR, newColor);
		RcplUtil.set(COLOR_MAIN_OFFICE_COLOR, newColor.getRed() + "," + newColor.getGreen() + "," + newColor.getBlue()); //$NON-NLS-1$//$NON-NLS-2$
	}

	/**
	 * @param red
	 * @param green
	 * @param blue
	 */
	public void setMainOfficeColor(int red, int green, int blue) {
		colorRegistry = new HashMap<String, IColor>();
		colorRegistry.put(COLOR_MAIN_OFFICE_COLOR, new RcplColor(red, green, blue));
		RcplUtil.set(COLOR_MAIN_OFFICE_COLOR, red + "," + green + "," + blue); //$NON-NLS-1$//$NON-NLS-2$
	}

	/**
	 * @param rgb
	 * @param brightness
	 * @return
	 */
	private IColor transformRGB(IColor rgb, double brightness) {
		int red = (int) (Math.min(255, (rgb.getRed() * brightness)));
		int green = (int) (Math.min(255, (rgb.getGreen() * brightness)));
		int blue = (int) (Math.min(255, (rgb.getBlue() * brightness)));
		return new RcplColor(red, green, blue);
	}

	@Override
	public IColor getIndexedFillColorFromStylesDocument(IWorkbookPart workbook, int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Color getColor(STHighlightColor.Enum hc) {

		if (hc == STHighlightColor.BLACK) {
			return Color.BLACK;
		}
		if (hc == STHighlightColor.BLUE) {
			return Color.BLUE;
		}
		if (hc == STHighlightColor.CYAN) {
			return Color.CYAN;
		}
		if (hc == STHighlightColor.DARK_BLUE) {
			return Color.DARKBLUE;
		}
		if (hc == STHighlightColor.DARK_CYAN) {
			return Color.DARKCYAN;
		}
		if (hc == STHighlightColor.DARK_GRAY) {
			return Color.DARKGREY;
		}
		if (hc == STHighlightColor.DARK_GREEN) {
			return Color.DARKGREEN;
		}
		if (hc == STHighlightColor.DARK_MAGENTA) {
			return Color.DARKMAGENTA;
		}
		if (hc == STHighlightColor.DARK_RED) {
			return Color.DARKRED;
		}
		if (hc == STHighlightColor.DARK_YELLOW) {
			return Color.GOLDENROD;
		}
		if (hc == STHighlightColor.GREEN) {
			return Color.GREEN;
		}
		if (hc == STHighlightColor.LIGHT_GRAY) {
			return Color.LIGHTGRAY;
		}
		if (hc == STHighlightColor.MAGENTA) {
			return Color.MAGENTA;
		}
		if (hc == STHighlightColor.NONE) {
			return Color.TRANSPARENT;
		}
		if (hc == STHighlightColor.RED) {
			return Color.RED;
		}
		if (hc == STHighlightColor.WHITE) {
			return Color.WHITE;
		}
		if (hc == STHighlightColor.YELLOW) {
			return Color.YELLOW;
		}

		return Color.RED;

	}

	public static List<Color> getHighlightColors() {
		List<Color> highlightColors = new ArrayList<Color>();
		highlightColors.add(getColor(STHighlightColor.BLACK));
		highlightColors.add(getColor(STHighlightColor.BLUE));
		highlightColors.add(getColor(STHighlightColor.CYAN));
		highlightColors.add(getColor(STHighlightColor.DARK_BLUE));
		highlightColors.add(getColor(STHighlightColor.DARK_CYAN));
		highlightColors.add(getColor(STHighlightColor.DARK_GRAY));
		highlightColors.add(getColor(STHighlightColor.DARK_GREEN));
		highlightColors.add(getColor(STHighlightColor.DARK_MAGENTA));
		highlightColors.add(getColor(STHighlightColor.DARK_RED));
		highlightColors.add(getColor(STHighlightColor.DARK_YELLOW));
		highlightColors.add(getColor(STHighlightColor.GREEN));
		highlightColors.add(getColor(STHighlightColor.LIGHT_GRAY));
		highlightColors.add(getColor(STHighlightColor.MAGENTA));
		highlightColors.add(getColor(STHighlightColor.NONE));
		highlightColors.add(getColor(STHighlightColor.RED));
		highlightColors.add(getColor(STHighlightColor.WHITE));
		highlightColors.add(getColor(STHighlightColor.YELLOW));

		return highlightColors;
	}

	public static STHighlightColor.Enum getColor(Color hc) {

		if (hc == Color.BLACK) {
			return STHighlightColor.BLACK;
		}
		if (hc == Color.BLUE) {
			return STHighlightColor.BLUE;
		}
		if (hc == Color.CYAN) {
			return STHighlightColor.CYAN;
		}
		if (hc == Color.DARKBLUE) {
			return STHighlightColor.DARK_BLUE;
		}
		if (hc == Color.DARKCYAN) {
			return STHighlightColor.DARK_CYAN;
		}
		if (hc == Color.DARKGREY) {
			return STHighlightColor.DARK_GRAY;
		}
		if (hc == Color.DARKGREEN) {
			return STHighlightColor.DARK_GREEN;
		}
		if (hc == Color.DARKMAGENTA) {
			return STHighlightColor.DARK_MAGENTA;
		}
		if (hc == Color.DARKRED) {
			return STHighlightColor.DARK_RED;
		}
		if (hc.equals(Color.GOLDENROD)) {
			return STHighlightColor.DARK_YELLOW;
		}
		if (hc == Color.GREEN) {
			return STHighlightColor.GREEN;
		}
		if (hc == Color.LIGHTGRAY) {
			return STHighlightColor.LIGHT_GRAY;
		}
		if (hc == Color.MAGENTA) {
			return STHighlightColor.MAGENTA;
		}
		if (hc == Color.TRANSPARENT) {
			return STHighlightColor.NONE;
		}
		if (hc == Color.RED) {
			return STHighlightColor.RED;
		}
		if (hc == Color.WHITE) {
			return STHighlightColor.WHITE;
		}
		if (hc == Color.YELLOW) {
			return STHighlightColor.YELLOW;
		}

		return null;

	}

	public static String[][] getHighlightColorPalette() {
		return getColorToPalette(getHighlightColors());
	}

	public static String[][] getColorToPalette(List<Color> colorList) {
		String[][] result = new String[colorList.size()][2];
		int index = 0;
		for (String[] strings : result) {
			Color color = colorList.get(index);
			strings[0] = colorNames.get(color);
			strings[1] = getColorHex(color);

			index++;
		}
		return result;
	}

	public static String getColorHex(Color color) {
		String s = "#" + color.toString().substring(2, color.toString().length() - 2);
		return s;
	}

	public static String getColorName(Color color) {
		String s = color.toString();
		return s;
	}

//	public static void main(String[] args) {
//		List<Color> hl = getHighlightColors();
//		String[][] result = getColorToPalette(hl);
//
//		System.out.println();
//	}
}
