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

package org.eclipse.rcpl.model;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Currency;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import org.apache.xmlbeans.XmlObject;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javafx.geometry.Rectangle2D;

public class AUtil {

	// private static final Logger LOGGER =
	// LoggerFactory.getLogger(JOUtil2.class);

	private static final Object[][] CP1252_ESCAPE =

			{

					{ Byte.valueOf((byte) 228), "&auml;" }, // 'ä',

					{ Byte.valueOf((byte) 252), "&uuml;" }, // 'ü'

			};

	// € 128
	// ‚
	// 201A
	// 130
	//
	// ƒ
	// 0192
	// 131
	//
	// „
	// 201E
	// 132
	// …
	// 2026
	// 133
	// †
	// 2020
	// 134
	// ‡
	// 2021
	// 135
	// ˆ
	// 02C6
	// 136
	// ‰
	// 2030
	// 137
	// Š
	// 0160
	// 138
	// ‹
	// 2039
	// 139
	// Œ
	// 0152
	// 140
	// Ž
	// 017D
	// 142
	//
	// 9_
	//
	// ‘
	// 2018
	// 145
	// ’
	// 2019
	// 146
	// “
	// 201C
	// 147
	// ”
	// 201D
	// 148
	// •
	// 2022
	// 149
	// –
	// 2013
	// 150
	// —
	// 2014
	// 151
	// ˜
	// 02DC
	// 152
	// ™
	// 2122
	// 153
	// š
	// 0161
	// 154
	// ›
	// 203A
	// 155
	// œ
	// 0153
	// 156
	// ž
	// 017E
	// 158
	// Ÿ
	// 0178
	// 159
	//
	// A_
	// NBSP
	// 00A0
	// 160
	// ¡
	// 00A1
	// 161
	// ¢
	// 00A2
	// 162
	// £
	// 00A3
	// 163
	// ¤
	// 00A4
	// 164
	// ¥
	// 00A5
	// 165
	// ¦
	// 00A6
	// 166
	// §
	// 00A7
	// 167
	// ¨
	// 00A8
	// 168
	// ©
	// 00A9
	// 169
	// ª
	// 00AA
	// 170
	// «
	// 00AB
	// 171
	// ¬
	// 00AC
	// 172
	// SHY
	// 00AD
	// 173
	// ®
	// 00AE
	// 174
	// ¯
	// 00AF
	// 175
	//
	// B_
	// °
	// 00B0
	// 176
	// ±
	// 00B1
	// 177
	// ²
	// 00B2
	// 178
	// ³
	// 00B3
	// 179
	// ´
	// 00B4
	// 180
	// µ
	// 00B5
	// 181
	// ¶
	// 00B6
	// 182
	// ·
	// 00B7
	// 183
	// ¸
	// 00B8
	// 184
	// ¹
	// 00B9
	// 185
	// º
	// 00BA
	// 186
	// »
	// 00BB
	// 187
	// ¼
	// 00BC
	// 188
	// ½
	// 00BD
	// 189
	// ¾
	// 00BE
	// 190
	// ¿
	// 00BF
	// 191
	//
	// C_
	// À
	// 00C0
	// 192
	// Á
	// 00C1
	// 193
	// Â
	// 00C2
	// 194
	// Ã
	// 00C3
	// 195
	// Ä
	// 00C4
	// 196
	// Å
	// 00C5
	// 197
	// Æ
	// 00C6
	// 198
	// Ç
	// 00C7
	// 199
	// È
	// 00C8
	// 200
	// É
	// 00C9
	// 201
	// Ê
	// 00CA
	// 202
	// Ë
	// 00CB
	// 203
	// Ì
	// 00CC
	// 204
	// Í
	// 00CD
	// 205
	// Î
	// 00CE
	// 206
	// Ï
	// 00CF
	// 207
	//
	// D_
	// Ð
	// 00D0
	// 208
	// Ñ
	// 00D1
	// 209
	// Ò
	// 00D2
	// 210
	// Ó
	// 00D3
	// 211
	// Ô
	// 00D4
	// 212
	// Õ
	// 00D5
	// 213
	// Ö
	// 00D6
	// 214
	// ×
	// 00D7
	// 215
	// Ø
	// 00D8
	// 216
	// Ù
	// 00D9
	// 217
	// Ú
	// 00DA
	// 218
	// Û
	// 00DB
	// 219
	// Ü
	// 00DC
	// 220
	// Ý
	// 00DD
	// 221
	// Þ
	// 00DE
	// 222
	// ß
	// 00DF
	// 223
	//
	// E_
	// à
	// 00E0
	// 224
	// á
	// 00E1
	// 225
	// â
	// 00E2
	// 226
	// ã
	// 00E3
	// 227
	//
	// å
	// 00E5
	// 229
	// æ
	// 00E6
	// 230
	// ç
	// 00E7
	// 231
	// è
	// 00E8
	// 232
	// é
	// 00E9
	// 233
	// ê
	// 00EA
	// 234
	// ë
	// 00EB
	// 235
	// ì
	// 00EC
	// 236
	// í
	// 00ED
	// 237
	// î
	// 00EE
	// 238
	// ï
	// 00EF
	// 239
	//
	// F_
	//
	// ð
	// 00F0
	// 240
	// ñ
	// 00F1
	// 241
	// ò
	// 00F2
	// 242
	// ó
	// 00F3
	// 243
	// ô
	// 00F4
	// 244
	// õ
	// 00F5
	// 245
	// ö
	// 00F6
	// 246
	// ÷
	// 00F7
	// 247
	// ø
	// 00F8
	// 248
	// ù
	// 00F9
	// 249
	// ú
	// 00FA
	// 250
	// û
	// 00FB
	// 251

	// ý
	// 00FD
	// 253
	// þ
	// 00FE
	// 254
	// ÿ
	// 00FF
	// 255

	public static Rectangle2D setHeight(Rectangle2D r, double height) {
		return new Rectangle2D(r.getMinX(), r.getMinY(), r.getWidth(), height);
	}

	public static Rectangle2D setSize(Rectangle2D r, double width, double height) {
		return new Rectangle2D(r.getMinX(), r.getMinY(), width, height);
	}

	public static Rectangle2D setWidth(Rectangle2D r, double width) {
		return new Rectangle2D(r.getMinX(), r.getMinY(), width, r.getHeight());
	}

	public static Rectangle2D setX(Rectangle2D r, double x) {
		return new Rectangle2D(x, r.getMinY(), r.getWidth(), r.getHeight());
	}

	public static Rectangle2D setY(Rectangle2D r, double y) {
		Rectangle2D r2 = new Rectangle2D(r.getMinX(), y, r.getWidth(), r.getHeight());
		return r2;
	}

	public static Rectangle2D setPosition(Rectangle2D r, double x, double y) {
		return new Rectangle2D(x, y, r.getWidth(), r.getHeight());
	}

	public static Rectangle2D addX(Rectangle2D r, double x) {
		if (x == 0) {
			return r;
		}
		return new Rectangle2D(r.getMinX() + x, r.getMinY(), r.getWidth(), r.getHeight());
	}

	public static Rectangle2D addY(Rectangle2D r, double y) {

		if (y == 0) {
			return r;
		}
		return new Rectangle2D(r.getMinX(), r.getMinY() + y, r.getWidth(), r.getHeight());
	}

	public static Rectangle2D copy(Rectangle2D r) {
		return new Rectangle2D(r.getMinX(), r.getMinY(), r.getWidth(), r.getHeight());
	}

	public static int getIndex(XmlObject xmlObject, boolean onlySameType) {
		Node node = xmlObject.getDomNode();
		String nodeName = node.getNodeName();
		Node parentNode = node.getParentNode();
		NodeList nodeList = parentNode.getChildNodes();
		int index = 0;
		int length = nodeList.getLength();

		int ind = 0;
		Node prev = node.getPreviousSibling();

		if (onlySameType) {
			for (int i = 0; i < length; i++) {
				Node node2 = nodeList.item(i);
				String nodeName2 = node2.getNodeName();
				if (nodeName.equals(nodeName2)) {
					if (node2 == node) {
						return index;
					}
					index++;
				}
			}
		} else {
			while (prev != null) {
				prev = prev.getPreviousSibling();
				ind++;
			}
			return ind;
			// for (index = 0; index < length; index++) {
			// Node node2 = nodeList.item(index);
			// if (node2 == node) {
			// if(ind!=index){
			// System.
			// }
			// return index;
			// }
			// }
		}
		return 0;
	}

	// /**
	// * @param key
	// * @return
	// */
	// public static List<IToolComponent> findEditorToolComponents(String key) {
	// List<IToolComponent> editorToolComponents = new
	// ArrayList<IToolComponent>();
	// if (JO.officePane.getToolRegistry() != null) {
	// List<ITool> editorTools = JO.officePane.getToolRegistry()
	// .findTools(key);
	// for (ITool editorTool : editorTools) {
	// editorToolComponents.add((IToolComponent) editorTool
	// .getToolComponent());
	// }
	// }
	// return editorToolComponents;
	// }

	// /**
	// * @param key
	// * @return
	// */
	// public static List<IToolComponent> findToolComponents(String key) {
	// List<IToolComponent> toolComponents = new ArrayList<IToolComponent>();
	// List<IToolComponent> c = findEditorToolComponents(key);
	// if (c != null) {
	// toolComponents.addAll(c);
	// }
	//
	// List<ITool> officeTools = JO.officePane.getToolRegistry()
	// .findTools(key);
	// if (officeTools != null) {
	// for (ITool officeTool : officeTools) {
	// toolComponents.add((IToolComponent) officeTool
	// .getToolComponent());
	// }
	// }
	//
	// List<IToolComponent> topToolComponents = findTopTools(key);
	// toolComponents.addAll(topToolComponents);
	// return toolComponents;
	// }

	// /**
	// * @return
	// */
	// public static List<IToolComponent> findTopTools(String key) {
	// List<IToolComponent> tools = new ArrayList<IToolComponent>();
	// List<IToolComponent> topTools = JO.officePane.getTopTools()
	// .getToolComponents();
	// for (IToolComponent topTool : topTools) {
	// if (topTool != null && topTool.getEntry() != null
	// && topTool.getEntry().getKey().equals(key)) {
	// tools.add((IToolComponent) topTool);
	// }
	// }
	// return tools;
	// }

	// /**
	// * @param key
	// * @return
	// */
	// public static List<ITool> findEditorTools(String key) {
	// List<ITool> editorTools = new ArrayList<ITool>();
	// if (JO.officePane.getToolRegistry() == null) {
	// return null;
	// }
	// ITool[] tools = JO.officePane.getToolRegistry().findAllTools(key);
	// for (ITool joTool : tools) {
	// editorTools.add(joTool);
	// }
	// return editorTools;
	// }

	/**
	 * @param xmlObjects
	 * @param progress
	 */
	public static void sortXmlObjects(List<XmlObject> xmlObjects) {
		profile();
		Collections.sort(xmlObjects, new Comparator<XmlObject>() {
			@Override
			public int compare(XmlObject o1, XmlObject o2) {
				if (getIndex(o1, false) < getIndex(o2, false)) {
					return -1;
				}
				return 1;
			}
		});
		profileEnd();
	}

	// /**
	// * @param key
	// * @return
	// */
	// public static boolean getBooleanGuiState(String key) {
	// List<IToolComponent> tools = findToolComponents(key);
	// if (!tools.isEmpty()) {
	// return tools.get(0).isSelected();
	// }
	// return false;
	// }

	// /**
	// * @param key
	// * @return
	// */
	// public static int getComboGuiState(String key) {
	// List<IToolComponent> tools = findToolComponents(key);
	// if (!tools.isEmpty() && tools.get(0) instanceof IComboTool) {
	// return (Integer) ((IComboTool) tools.get(0)).getState();
	// }
	// return 0;
	// }

	// /**
	// * @param key
	// * @return
	// */
	// public static String getStringGuiState(String key) {
	// List<IToolComponent> tools = findEditorToolComponents(key);
	// if (!tools.isEmpty() && tools.get(0) instanceof ITextable) {
	// return ((ITextable) tools.get(0)).getText();
	// }
	// return null;
	// }

	// /**
	// * @param key
	// * @param text
	// */
	// public static void setStringGuiState(String key, String text) {
	// List<IToolComponent> tools = findEditorToolComponents(key);
	// if (!tools.isEmpty() && tools.get(0) instanceof ITextable) {
	// ((ITextable) tools.get(0)).setText(text);
	// }
	// }

	// /**
	// * @param key
	// * @param en
	// */
	// @SuppressWarnings("rawtypes")
	// public static void setComboGuiState(String key, Enum en) {
	// List<IToolComponent> tools = findEditorToolComponents(key);
	// if (!tools.isEmpty() && tools.get(0) instanceof IComboTool) {
	// ((IComboTool) tools.get(0)).setSelect(en);
	// }
	// }

	/**
	 * Copy the input stream into the output stream.
	 * 
	 * @param inStream  The source stream.
	 * @param outStream The destination stream.
	 * @return <b>true</b> if the operation succeed, else return <b>false</b>.
	 */
	public static byte[] copyStreamTyByteArray(InputStream inStream) {
		try {
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int bytesRead;
			while ((bytesRead = inStream.read(buffer)) >= 0) {
				os.write(buffer, 0, bytesRead);
			}
			os.flush();
			os.close();
			return os.toByteArray();
		} catch (Exception e) {
			return new byte[0];
		}
	}

	public static int imageHandles = 0;

//	/**
//	 * Returns the styles object used
//	 */
//	public static CTFontsList getFontTable(XWPFDocument xml) throws XmlException, IOException {
//		PackagePart[] parts;
//		try {
//			parts = getRelatedByType(xml, XWPFRelation.FONT_TABLE.getRelation());
//		} catch (InvalidFormatException e) {
//			throw new IllegalStateException(e);
//		}
//		if (parts.length != 1) {
//			throw new IllegalStateException("" + parts.length); //$NON-NLS-1$
//		}
//
//		FontsDocument fd = FontsDocument.Factory.parse(parts[0].getInputStream());
//		return fd.getFonts();
//	}

	/**
	 * @return
	 */
	public static boolean isWindows() {
		String os = System.getenv("os"); //$NON-NLS-1$
		return os.toLowerCase().indexOf("windows") != -1; //$NON-NLS-1$
	}

	// /**
	// * @param officePane
	// * @return
	// */
	// public static File getPropertyFile() {
	//
	// instanceNumber = 1;
	// if (JO.officePane != null && JO.officePane.getContainer() != null) {
	// instanceNumber = JO.officePane.getContainer().getNumber();
	// }
	//
	// // ---------- get a new number for a new started office ----------------
	//
	// if (instanceNumber == 0) {
	// for (int i = 1; i < 4; i++) {
	// lockFile = new File(getUserLocalArea(), "joffice" + i + ".lock");
	// //$NON-NLS-1$//$NON-NLS-2$
	// if (!lockFile.exists()) {
	// instanceNumber = i;
	// JO.officePane.getContainer().setNumber(i);
	// break;
	// }
	// }
	// if (instanceNumber == 0) {
	// // MessageDialog.openError(new Shell(), Messages.JOUtil_Error,
	// // Messages.JOUtil_TooManyOfficeOpened);
	// System.exit(1);
	//
	// }
	// writeLockFile();
	// return new File(getUserLocalArea(),
	// "joffice" + instanceNumber + ".properties"); //$NON-NLS-1$ //$NON-NLS-2$
	// }
	//
	// return new File(getUserLocalArea(),
	// "joffice" + instanceNumber + ".properties"); //$NON-NLS-1$ //$NON-NLS-2$
	// }

	// public static ISpreadsheetTopTools getSpreadsheetTopTools() {
	// IOfficePane op = JO.officePane;
	// if (op != null) {
	// ITopTools tt = op.getTopTools();
	// if (tt instanceof ISpreadsheetTopTools) {
	// return (ISpreadsheetTopTools) tt;
	// }
	// }
	// return null;
	// }

	// /**
	// *
	// */
	// public static void writeLockFile() {
	// if (JO.officePane.getContainer() != null) {
	// int number = JO.officePane.getContainer().getNumber();
	// if (number > 0) {
	// // File lockFile = new File(getUserLocalArea(),
	// // "joffice" + number + ".lock"); //$NON-NLS-1$//$NON-NLS-2$
	// FileOutputStream fo;
	// try {
	// fo = new FileOutputStream(lockFile);
	// fo.close();
	// } catch (FileNotFoundException e) {
	// } catch (IOException e) {
	// }
	// }
	// }
	// }

	/**
	 * // * //
	 */
	// public static void deleteLocklFile() {
	// if (JO.officePane.getContainer() != null) {
	// int number = JO.officePane.getContainer().getNumber();
	// if (number != 0) {
	// File lockF = new File(getUserLocalArea(),
	// "joffice" + number + ".lock"); //$NON-NLS-1$//$NON-NLS-2$
	// if (lockF.exists()) {
	// lockF.delete();
	// }
	// }
	// }
	// }

	// /**
	// * @return
	// */
	// public static JOInstanceDB getInstanceDB() {
	// getPropertyFile();
	// JOInstanceDB instanceDB = null;
	// switch (instanceNumber) {
	// case 1:
	// instanceDB = getInstanceDB1();
	// break;
	// case 2:
	// instanceDB = getInstanceDB2();
	// break;
	// case 3:
	// instanceDB = getInstanceDB3();
	// break;
	// default:
	// break;
	// }
	// // if (getPropertyFile().exists()) {
	// // getPropertyFile().delete();
	// // }
	// return instanceDB;
	// }
	//
	// private static JODefaultDB defaultDB;
	//
	// private static JOInstanceDB instanceDB1;
	//
	// private static JOInstanceDB instanceDB2;
	//
	// private static JOInstanceDB instanceDB3;
	//
	// public static JODefaultDB getDefaultDB() {
	// if (defaultDB == null) {
	// defaultDB = new JODefaultDB();
	// }
	// // File f = JOUtil.getDefaultPropertyFile();
	// // if (f.exists()) {
	// // f.delete();
	// // }
	// return defaultDB;
	// }

	// public static JOInstanceDB getInstanceDB1() {
	// if (instanceDB1 == null) {
	// instanceDB1 = new JOInstanceDB(1);
	// }
	// return instanceDB1;
	// }
	//
	// public static JOInstanceDB getInstanceDB2() {
	// if (instanceDB2 == null) {
	// instanceDB2 = new JOInstanceDB(2);
	// }
	// return instanceDB2;
	// }
	//
	// public static JOInstanceDB getInstanceDB3() {
	// if (instanceDB3 == null) {
	// instanceDB3 = new JOInstanceDB(3);
	// }
	// return instanceDB3;
	// }

	public static void remove(Properties properties, String key) {
		// if (properties == getInstanceProperties()) {
		// getInstanceDB().remove(key);
		// } else if (properties == getDefaultProperties()) {
		// getDefaultDB().remove(key);
		// } else
		{
			properties.remove(key);
		}
	}

	public static void removeByValue(Properties properties, String value) {
		// if (properties == getInstanceProperties()) {
		// getInstanceDB().removeByValue(value);
		// } else if (properties == getDefaultProperties()) {
		// getDefaultDB().removeByValue(value);
		// } else
		{
			for (Object o : properties.keySet()) {
				if (o instanceof String) {
					String v = (String) properties.get(o);
					if (v.equals(value)) {
						properties.remove(o);
					}
				}
			}
		}
	}

	// /**
	// * @param key
	// * @return
	// */
	// public static List<String> getAllInstancePropertiesLike(String key) {
	// getInstanceProperties();
	// return getInstanceDB().getLike(key);
	// }

	// /**
	// * @return
	// */
	// public static boolean isProductElderBrowser() {
	// String p = JOConfigStrings.product;
	// return p.equals("SeniorBrowser"); //$NON-NLS-1$
	// }

	// ---------- properties ---------------------------------------------------

	public static Object get(Properties properties, Object key) {
		// if (properties == getInstanceProperties()) {
		// return getInstanceDB().get((String) key);
		// } else if (properties == getDefaultProperties()) {
		// return getDefaultDB().get((String) key);
		// }
		return properties.get(key);
	}

	public static void put(Properties properties, Object key, Object value) {
		// if (properties == getInstanceProperties()) {
		// getInstanceDB().put((String) key, (String) value);
		// } else if (properties == getDefaultProperties()) {
		// getDefaultDB().put((String) key, (String) value);
		// }
		properties.put(key, value);
	}

	public static boolean IS_IDE = false;

	private static File installDir;

	/**
	 * @return
	 */
	@SuppressWarnings("unused")
	private static boolean migrateProperties() {
		// int version = getDefaultInteger("property_version"); //$NON-NLS-1$
		// if (version != PROPERTY_VERSION) {
		// // officeProperties.clear();
		// initDefaultProperties();
		// setDefaultProperty("property_version", PROPERTY_VERSION);
		// //$NON-NLS-1$
		// }
		//
		// // wenn es sich um die gleiche art von migration handelt, einfach
		// // version aendern, ansonsten alle migs nacheinander durchfuehren
		// // (mit den aeltesten beginnen).
		//
		// int migrationVersion = JOUiConfig.getVersion(0, 8, 11, 15);
		// Object migration = get(defaultProperties,
		// JO.REGISTRY_PROPERTIES_MIGRATION + migrationVersion);
		// if (migration == null) {
		// put(defaultProperties, JO.REGISTRY_PROPERTIES_MIGRATION
		// + migrationVersion, "OK"); //$NON-NLS-1$
		// removeAllDefaultProperties(JO.REGISTRY_RECENTLY_BROWSED_URL);
		// removeAllDefaultProperties(JO.REGISTRY_RECENTLY_USED_DOCUMENTS);
		// removeAllDefaultProperties(JO.REGISTRY_FAVORITE_URL);
		// for (int i = 1; i <= 3; i++) {
		// Properties properties = getOfficeInstanceProperties(i);
		// if (properties != null) {
		// removeAllProperties(properties,
		// JO.REGISTRY_RECENTLY_BROWSED_URL);
		// removeAllProperties(properties,
		// JO.REGISTRY_RECENTLY_USED_DOCUMENTS);
		// removeAllProperties(properties, JO.REGISTRY_BOOKMARK_URL);
		// removeAllProperties(properties, JO.REGISTRY_FAVORITE_URL);
		// }
		// }
		// instanceProperties = null;
		// return true;
		// }
		return false;
	}

	/**
	 * @param key
	 * @return
	 */
	public static long getDefaultLong(Properties properties, String key) {
		String result = (String) get(properties, key);
		if (result == null) {
			return 0;
		}
		return Long.valueOf(result);
	}

	/**
	 * @param key
	 * @return
	 */
	public static int getDefaultInteger(Properties properties, String key) {
		String result = (String) get(properties, key);
		if (result == null) {
			return 0;
		}
		return Integer.valueOf(result);
	}

	/**
	 * @param key
	 * @return
	 */
	public static boolean getDefaultBoolean(Properties properties, String key) {
		String result = (String) get(properties, key);
		if (result == null) {
			return false;
		}
		return "t".equals(result) ? true : false; //$NON-NLS-1$
	}

	/**
	 * @param key
	 * @return
	 */
	public static boolean getBoolean(Properties properties, String key) {
		String result = (String) get(properties, key);
		if (result == null) {
			return false;
		}
		return "t".equals(result) ? true : false; //$NON-NLS-1$
	}

	/**
	 * @param key
	 * @return
	 */
	public static int getInteger(Properties properties, String key) {
		String result = (String) get(properties, key);
		if (result == null) {
			return 0;
		}
		return Integer.valueOf(result);
	}

	public static float getFloat(String s) {
		float result = 0.0f;
		if (s == null) {
			return result;
		}
		if (s.endsWith("f")) { //$NON-NLS-1$
			s = s.substring(0, s.length() - 1);
		}
		try {
			return Float.valueOf(s);
		} catch (Exception ex) {

		}
		return result;
	}

	public static double getDouble(Properties properties, String key) {
		String result = (String) get(properties, key);
		if (result == null) {
			return 0.0;
		}
		if (result.endsWith("d")) { //$NON-NLS-1$
			result = result.substring(0, result.length() - 1);
		}
		try {
			return Double.valueOf(result);
		} catch (Exception ex) {

		}
		return 0.0;
	}

	/**
	 * @param key
	 * @return
	 */
	public static long getLong(Properties properties, String key) {
		String result = (String) get(properties, key);
		if (result == null) {
			return 0;
		}
		return Long.valueOf(result);
	}

	// /**
	// * @param matchKey
	// */
	// public static void removeAllDefaultProperties(String matchKey) {
	// List<String> keys = getDefaultDB().getKeysLike(matchKey);
	// for (String key : keys) {
	// remove(defaultProperties, key);
	// }
	// }

	/**
	 * @param properties
	 * @param matchKey
	 */
	public static void removeAllProperties(Properties properties, String matchKey) {
		Enumeration<Object> keys = properties.keys();
		while (keys.hasMoreElements()) {
			String key = (String) keys.nextElement();
			if (key.startsWith(matchKey)) {
				remove(properties, key);
			}
		}
	}

	/**
	 * @param properties
	 * @param key
	 * @param value
	 * @param save
	 */
	public static void setProperty(Properties properties, String key, String value) {
		put(properties, key, value);
	}

	// /**
	// * @param key
	// * @return
	// */
	// public static List<String> getAllDefaultPropertiesLike(String key) {
	// getDefaultProperties();
	// return getDefaultDB().getLike(key);
	//
	// // List<String> values = new ArrayList<String>();
	// // Set<Object> keys = getDefaultOfficeProperties().keySet();
	// // for (Object object : keys) {
	// // if (((String) object).startsWith(key)) {
	// // values.add(object + "," //$NON-NLS-1$
	// // + (String) getDefaultOfficeProperties().get(object));
	// // }
	// // }
	// // return values;
	// }

	/**
	 * @param properties
	 * @param key
	 * @return
	 */
	// public static List<String> getAllPropertiesLike(Properties properties,
	// String key) {
	//
	// if (properties == getInstanceProperties()) {
	// return getInstanceDB().getLike(key);
	// } else if (properties == getDefaultProperties()) {
	// return getDefaultDB().getLike(key);
	// } else {
	//
	// List<String> values = new ArrayList<String>();
	// Set<Object> keys = properties.keySet();
	// for (Object object : keys) {
	// if (((String) object).startsWith(key)) {
	// values.add(object + "," //$NON-NLS-1$
	// + (String) properties.get(object));
	// }
	// }
	// return values;
	// }
	// }
	//
	// public static List<String> getAllPropertyKeysLike(Properties properties,
	// String key) {
	// if (properties == getInstanceProperties()) {
	// return getInstanceDB().getKeysLike(key);
	// } else if (properties == getDefaultProperties()) {
	// return getDefaultDB().getKeysLike(key);
	// } else {
	// List<String> values = new ArrayList<String>();
	// Set<Object> keys = properties.keySet();
	// for (Object object : keys) {
	// if (((String) object).startsWith(key)) {
	// values.add(object + "," //$NON-NLS-1$
	// + (String) properties.get(object));
	// }
	// }
	// return values;
	// }
	// }
	//
	/**
	 * @return
	 */
	public static File getInstallDir() {
		if (installDir == null) {
			String classPath = System.getProperty("java.class.path", "."); //$NON-NLS-1$//$NON-NLS-2$
			String os = System.getProperty("os.name"); //$NON-NLS-1$
			String separator = ";"; //$NON-NLS-1$
			if (!os.toLowerCase().startsWith("windows")) { //$NON-NLS-1$
				separator = ":"; //$NON-NLS-1$
			}
			String[] classPathElements = classPath.split(separator);
			for (String cl : classPathElements) {
				if (cl.indexOf("ooxml.jar") != -1) { //$NON-NLS-1$
					File f = new File(cl);
					installDir = f.getParentFile();
					break;
				} else if (cl.indexOf("org.eclipse.rcpl.app\\bin") != -1) { //$NON-NLS-1$
					File f = new File(cl);
					installDir = new File(f.getParentFile().getParentFile(),
							"org.eclipse.rcpl.build/installer/components"); //$NON-NLS-1$
				}
			}
		}
		return installDir;

	}

	/**
	 * @return
	 */
	public static File getLogFile() {
		File file = new File(getInstallDir(), "joffice.log"); //$NON-NLS-1$
		if (file.exists()) {
			return file;
		}
		file = new File(getInstallDir(), "xulrunner/joffice.log"); //$NON-NLS-1$
		if (file.exists()) {
			return file;
		}
		file = new File(getInstallDir(), "../../../org.eclipse.rcpl.app/joffice.log"); //$NON-NLS-1$
		if (file.exists()) {
			return file;
		}
		return null;
	}

	/**
	 * @return
	 */
	public static File getInkscapeProgram() {
		return new File(getInstallDir(), "inkscape/inkscape_portable.exe");// inkscape_portable.exe"); //$NON-NLS-1$
	}

	/**
	 * @param s
	 * @return
	 */
	public static String createMD5(String s, boolean removeDashesAndSpaces) {
		if (removeDashesAndSpaces) {
			s = s.replaceAll(" ", ""); //$NON-NLS-1$//$NON-NLS-2$
			s = s.replaceAll("-", ""); //$NON-NLS-1$ //$NON-NLS-2$
		}
		MessageDigest algorithm;
		try {
			algorithm = MessageDigest.getInstance("MD5"); //$NON-NLS-1$
			algorithm.reset();
			algorithm.update(s.getBytes());
			byte messageDigest[] = algorithm.digest();
			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < messageDigest.length; i++) {
				hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
			}
			// String foo = messageDigest.toString();
			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}

	// /**
	// * @param templateResourceName
	// * @return
	// */
	// public static InputStream loadSvgTemplate(String templateResourceName) {
	// return loadLibTemplate("/com/joffice/ui/resources/svg/" //$NON-NLS-1$
	// + templateResourceName + ".svg"); //$NON-NLS-1$
	// }

	/**
	 * @param is
	 * @return
	 * @throws IOException
	 */
	public static String convertStreamToString(InputStream is) {
		if (is != null) {
			StringBuilder sb = new StringBuilder();
			String line;
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8")); //$NON-NLS-1$
				while ((line = reader.readLine()) != null) {
					sb.append(line).append("\n"); //$NON-NLS-1$
				}
			} catch (IOException ex) {
				// LOGGER.error("", ex); //$NON-NLS-1$
			} finally {
				try {
					is.close();
				} catch (IOException e) {
					// LOGGER.error("", e); //$NON-NLS-1$
				}
			}
			return sb.toString();
		}
		return ""; //$NON-NLS-1$

	}

	/**
	 * @param in
	 * @param out
	 * @throws IOException
	 */
	public static final String copyInputStream(InputStream in, OutputStream out, boolean escapeHtml)
			throws IOException {
		if (in == null) {
			return null;
		}
		byte[] buffer = new byte[1024];
		byte[] buffer2 = new byte[1024 * 3];

		int len;
		while ((len = in.read(buffer)) >= 0) {

			if (escapeHtml) {
				escapeHtml(out, buffer, buffer2, len);
			} else {
				out.write(buffer, 0, len);
			}
		}

		String result = "";
		if (out instanceof StringOutputStream) {
			out.flush();
			result = out.toString();

		}

		in.close();
		out.close();
		return result;
	}

	/**
	 * @param out
	 * @param buffer
	 * @param buffer2
	 * @param len
	 * @throws IOException
	 */
	private static void escapeHtml(OutputStream out, byte[] buffer, byte[] buffer2, int len) throws IOException {
		for (int i = 0, j = 0; i < len; i++, j++) {

			boolean found = false;
			for (int k = 0; k < CP1252_ESCAPE.length; k++) {
				if (buffer[i] == (Byte) CP1252_ESCAPE[k][0]) {
					String s = (String) CP1252_ESCAPE[k][1];
					byte[] bytes = s.getBytes();
					buffer2[j++] = bytes[0];
					buffer2[j++] = bytes[1];
					buffer2[j++] = bytes[2];
					buffer2[j++] = bytes[3];
					buffer2[j++] = bytes[4];
					buffer2[j] = bytes[5];
					found = true;
					break;
				}
			}

			// if (buffer[i] == (byte) 0xfc) {
			// buffer2[j++] = '&';
			// buffer2[j++] = 'u';
			// buffer2[j++] = 'u';
			// buffer2[j++] = 'm';
			// buffer2[j++] = 'l';
			// buffer2[j] = ';';
			// } else {
			// buffer2[j] = buffer[i];
			// }

			if (!found) {
				buffer2[j] = buffer[i];
			}

		}
		out.write(buffer2, 0, len);
	}

	/**
	 * @param in
	 * @param out
	 * @throws IOException
	 */
	public static final String copyInputStream(InputStreamReader in, OutputStreamWriter out) throws IOException {

		if (in == null) {
			return null;
		}
		char[] buffer = new char[1024];
		int len;
		while ((len = in.read(buffer)) >= 0) {
			out.write(buffer, 0, len);
		}

		in.close();

		return out.toString();
	}

	public static float round(double val, int rpl) {
		return round((float) val, rpl);
	}

	/**
	 * @param Rval
	 * @param Rpl
	 * @return
	 */
	public static float round(float val, int rpl) {
		float p = (float) Math.pow(10, rpl);
		val = val * p;
		float tmp = Math.round(val);
		return tmp / p;
	}

	/**
	 * @param inFile
	 * @param outFile
	 * @throws IOException
	 */
	public static final void copyFile(File inFile, File outFile, boolean escapeHtml) throws IOException {
		FileInputStream fis = new FileInputStream(inFile);
		copyInputStream(fis, new FileOutputStream(outFile), escapeHtml);
	}

	public static final void copyInputStream(InputStream is, File outFile, boolean escapeHtml) throws IOException {
		copyInputStream(is, new FileOutputStream(outFile), escapeHtml);
	}

	/**
	 * @param is
	 * @param fileName
	 * @return
	 */
	public static final File copyInputStreamToCache(InputStream is, File outFile) {
		outFile.getParentFile().mkdirs();
		try {
			copyInputStream(is, new FileOutputStream(outFile), false);
		} catch (FileNotFoundException e) {
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return outFile;
	}

	public static Rectangle2D union(Rectangle2D src1, Rectangle2D src2) {
		Rectangle2D result = null;
		double x1;
		double y1;
		double x2;
		double y2;

		if (src1 == null && src2 == null) {
			return null;
		} else if (src1 != null && src2 != null) {
			x1 = Math.min(src1.getMinX(), src2.getMinX());
			y1 = Math.min(src1.getMinY(), src2.getMinY());
			x2 = Math.max(src1.getMaxX(), src2.getMaxX());
			y2 = Math.max(src1.getMaxY(), src2.getMaxY());

		} else if (src1 != null) {
			x1 = src1.getMinX();
			y1 = src1.getMinY();
			x2 = src1.getMaxX();
			y2 = src1.getMaxY();

		} else {
			// only src2 is non-null
			x1 = src2.getMinX();
			y1 = src2.getMinY();
			x2 = src2.getMaxX();
			y2 = src2.getMaxY();

		}

		result = new Rectangle2D(x1, y1, x2 - x1, y2 - y1);
		return result;
	}

	// public static Response showConfirmDialog( Stage owner, String message,
	// String title ) {
	// VBox vb = new VBox();
	// Scene scene = new Scene( vb );
	// final Dialog dial = new Dialog( title, owner, scene, "res/Confirm.png" );
	// vb.setPadding( Layout.PADDING );
	// vb.setSpacing( Layout.SPACING );
	// Button yesButton = new Button( "Yes" );
	// yesButton.setOnAction( new EventHandler<ActionEvent>() {
	// @Override public void handle( ActionEvent e ) {
	// dial.close();
	// buttonSelected = Response.YES;
	// }
	// } );
	// Button noButton = new Button( "No" );
	// noButton.setOnAction( new EventHandler<ActionEvent>() {
	// @Override public void handle( ActionEvent e ) {
	// dial.close();
	// buttonSelected = Response.NO;
	// }
	// } );
	// BorderPane bp = new BorderPane();
	// HBox buttons = new HBox();
	// buttons.setAlignment( Pos.CENTER );
	// buttons.setSpacing( Layout.SPACING );
	// buttons.getChildren().addAll( yesButton, noButton );
	// bp.setCenter( buttons );
	// HBox msg = new HBox();
	// msg.setSpacing( Layout.SPACING_SMALL );
	// msg.getChildren().addAll( icon, new Message( message ) );
	// vb.getChildren().addAll( msg, bp );
	// dial.showDialog();
	// return buttonSelected;
	// }

	/**
	 * @param in
	 * @param out
	 * @throws IOException
	 */
	public static final String copyInputStream(InputStream in, File outFile) throws IOException {
		if (in == null) {
			return null;
		}
		byte[] buffer = new byte[1024];

		FileOutputStream fos = new FileOutputStream(outFile);

		int len;
		while ((len = in.read(buffer)) >= 0) {
			fos.write(buffer, 0, len);
		}

		String result = "";

		in.close();
		fos.close();
		return result;
	}

	private static boolean isProfile() {
		return true;
	}

	public static long profileEnd() {
		return profileEnd(false);
	}

	private static boolean DEBUG;

	public static long profileEnd(boolean force) {
		if (!DEBUG) {
			return 0;
		}

		if (!force) {
			if (!isProfile()) {
				return 0;
			}
		}
		long diff = 0;
		try {
			String msg = ""; //$NON-NLS-1$
			if (profileStack.size() > 0) {
				int index = profileStack.size() - 1;
				msg = profileStack.get(index);
				profileStack.remove(profileStack.size() - 1);
			}
			// if (time != 0)
			{
				diff = System.currentTimeMillis() - time;
				// if (diff > 0 && (diff > profileTrigger() || force))

				System.out.format("%10d %20s ", diff, msg);
				System.out.println();

				// {
				// msg += " t = " + diff; //$NON-NLS-1$
				// println(msg);
				// // LOGGER.info(msg);
				//
				// }

				// else {
				// }
				time = System.currentTimeMillis();
			}
		} catch (Exception ex) {
			// ignore
		}
		return diff;
	}

	private static List<String> profileStack = new ArrayList<String>();

	public static void profile() {
		profile(null);
	}

	private static long time = 0;
	private static String className = ""; //$NON-NLS-1$
	private static String methodName = ""; //$NON-NLS-1$
	private static int counter = 10000000;

	public static void profile(String text) {
		profile(text, false);
	}

	/**
	 * 
	 */
	public static void profile(String text, boolean force) {
		if (!DEBUG) {
			return;
		}
		if (!force && !isProfile()) {
			return;
		}
		// profileEnd();
		time = System.currentTimeMillis();

		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		int index = 0;
		for (; index < 10; index++) {
			String m = stackTraceElements[index].getMethodName();
			if (!m.equals("profile") //$NON-NLS-1$
					&& !m.equals("getStackTrace")) { //$NON-NLS-1$
				break;
			}
		}
		if (index == 10) {
			return;
		}
		StackTraceElement se = stackTraceElements[index];

		className = normalizeProfileName(se.getClassName());
		methodName = normalizeProfileName(se.getMethodName());
		String className0 = normalizeProfileName(stackTraceElements[index + 1].getClassName());
		String methodName0 = normalizeProfileName(stackTraceElements[index + 1].getMethodName());
		String msg = String.format("%12d %-60s", //$NON-NLS-1$
				counter++, className0 + " -> " + className + " Method = " + methodName0 + " -> " + methodName); //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$

		if (profileStack == null) {
			profileStack = new ArrayList<String>();
		}
		if (text != null) {
			profileStack.add(msg + " (" + text + ")"); //$NON-NLS-1$ //$NON-NLS-2$
		} else {
			profileStack.add(msg);
		}
	}

	/**
	 * @param s
	 * @return
	 */
	private static String normalizeProfileName(String s) {
		int pos = s.lastIndexOf("."); //$NON-NLS-1$
		if (pos != -1) {
			s = s.substring(pos + 1, s.length());
		}
		return s;
	}

	public static void println(String msg) {
		System.out.println(msg);
	}

	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	*
	*/
	public String formatAmount(double amount, String currency) {
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
		Currency curr = Currency.getInstance(currency);
		numberFormat.setCurrency(curr);
		String result = numberFormat.format(amount);
		return result;
	}
}
