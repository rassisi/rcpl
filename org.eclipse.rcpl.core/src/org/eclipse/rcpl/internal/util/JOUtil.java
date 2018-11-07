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

package org.eclipse.rcpl.internal.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.eclipse.rcpl.Rcpl;
import org.eclipse.rcpl.libs.util.AUtil;

import javafx.scene.Parent;
import javafx.scene.image.Image;

/**
 * @author ramin
 * 
 */
public class JOUtil {

	// private static final Logger LOGGER =
	// LoggerFactory.getLogger(JOUtil.class);

	/**
	 * @param fileName
	 * @return
	 */
	public static String getFileExtension(String fileName) {
		File f = new File(fileName);
		fileName = f.getName();
		int pos = fileName.lastIndexOf("."); //$NON-NLS-1$
		if (pos != -1) {
			String ext = fileName.substring(pos + 1, fileName.length());
			return ext;
		}
		return ""; //$NON-NLS-1$
	}

	public static String getFileNameWithoutExtension(String fileName) {
		int pos = fileName.lastIndexOf("."); //$NON-NLS-1$
		if (pos != -1) {
			return fileName.substring(0, pos);
		}
		return ""; //$NON-NLS-1$
	}

	public static void startInkscape(String filePath) {
		// shutDownInskapeThread = new ShutDown();
		File inkscapeProgram = AUtil.getInkscapeProgram();

		File workingDir = inkscapeProgram.getAbsoluteFile().getParentFile();
		String inkScapeName = inkscapeProgram.getName();

		inkScapeName = inkscapeProgram.getAbsolutePath();

		try {
			Runtime.getRuntime().exec(new String[] { inkScapeName, filePath }, null, workingDir);// ,

			// Runtime.getRuntime().exec(inkScapeName,new String[]{"svgfile=" +
			// filePath}, //$NON-NLS-1$
			// workingDir);// ,

			// null, workingDir);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Runtime rt = Runtime.getRuntime();
		// // rt.addShutdownHook(shutDownInskapeThread);
		// process = rt.exec(f.getAbsolutePath() + " " + filePath);
		// //$NON-NLS-1$
		// process.waitFor();

		//
		// while (true) {
		//
		// Display.getCurrent().readAndDispatch();
		// Thread.sleep(100);
		// try {
		// process.getInputStream().available();
		// } catch (Exception ex) {
		// }
		// }
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

	}

	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// ignore
		}
	}

	/**
	 * @return
	 */
	public static String getMemoryInfo() {
		return "FreeMemory " + Runtime.getRuntime().freeMemory() + "\n" //$NON-NLS-1$
				+ "TotalHeapSize " + Runtime.getRuntime().maxMemory() + "\n" //$NON-NLS-1$
				+ "CurrentHeapSize " + Runtime.getRuntime().totalMemory();
	}

	/**
	 * @param w
	 * @param h
	 * @return
	 */
	public static double getPythagoras(double w, double h) {
		return Math.sqrt(w * w + h * h);
	}

	/**
	 * @param x
	 * @param y
	 * @param xm
	 * @param ym
	 * @return
	 */
	public static double calculateAngle(double x, double y, double xm, double ym) {
		double dx = Math.abs(x - xm);
		double dy = Math.abs(y - ym);
		double r = JOUtil.getPythagoras(dx, dy);
		double umfang = 2 * Math.PI;
		double winkel = 0.0;
		switch (getQuadrant(xm, ym, x, y)) {

		case 1:
			winkel = Math.acos(dy / r) / umfang * 360;
			break;
		case 2:
			winkel = Math.asin(dy / r) / umfang * 360 + 90;
			break;
		case 3:
			winkel = Math.acos(dy / r) / umfang * 360 + 180;
			break;
		case 4:
			winkel = Math.asin(dy / r) / umfang * 360 + 270;
			break;
		}
		return winkel;
	}

	public static double calculateRealAngle(double x, double y, double xm, double ym) {
		double dx = Math.abs(x - xm);
		double dy = Math.abs(y - ym);
		double r = JOUtil.getPythagoras(dx, dy);
		double umfang = 2 * Math.PI;
		double winkel = 0.0;
		switch (getQuadrant(xm, ym, x, y)) {
		case 1:
			winkel = Math.acos(dy / r) / umfang * 360;
			break;
		case 2:
			winkel = Math.acos(dy / r) / umfang * 360 - 90;
			break;
		case 3:
			winkel = Math.asin(dy / r) / umfang * 360 + 180;
			break;
		case 4:
			winkel = Math.acos(dy / r) / umfang * 360 - 270;
			break;
		}
		return winkel;
	}

	/**
	 * @param xm
	 * @param ym
	 * @param x
	 * @param y
	 * @return
	 */
	public static int getQuadrant(double xm, double ym, double x, double y) {
		int quadrant = 0;
		if (x >= xm && y < ym) {
			quadrant = 1;
		} else if (x > xm && y >= ym) {
			quadrant = 2;
		} else if (x <= xm && y < ym) {
			quadrant = 4;
		} else if (x < xm && y >= ym) {
			quadrant = 3;
		} else {
			quadrant = 3;
		}

		return quadrant;

	}

	/**
	 * @param xm
	 * @param ym
	 * @param r
	 * @param angle
	 * @return
	 */
	public static double[] calculateCoordinates(double xm, double ym, double r, double angle) {
		double[] result = new double[2];
		result[0] = Math.sin(2 * Math.PI * (angle / 360.0)) * r + xm;
		result[1] = -Math.cos(2 * Math.PI * (angle / 360.0)) * r + ym;
		return result;
	}

	/**
	 * @param xm
	 * @param ym
	 * @param x1
	 * @param y1
	 * @param degree
	 * @return
	 */
	public static double[] calculateRotation(double xm, double ym, double x, double y, double rotation) {
		double[] result = new double[2];
		double dx = x - xm;
		double dy = y - ym;
		double r = JOUtil.getPythagoras(dx, dy);

		double startAngle = calculateAngle(x, y, xm, ym);

		double newRotation = startAngle + rotation;
		if (newRotation >= 360) {
			newRotation -= 360;
		}

		result = calculateCoordinates(xm, ym, r, newRotation);
		return result;
	}

	/**
	 * @param xm
	 * @param ym
	 * @param x
	 * @param y
	 * @param rotation
	 * @return
	 */
	public static double recalculateRotation(double xm, double ym, double x, double y, double rotation) {
		double result = rotation;

		switch (getQuadrant(xm, ym, x, y)) {
		case 1:
			result = Math.abs(90 - rotation);
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		}

		return result;
	}

	/**
	 * @param value
	 * @return
	 */
	public static String getBooleanString(boolean value) {
		return value ? "1" : "0"; //$NON-NLS-1$//$NON-NLS-2$
	}

	/**
	 * @param value
	 * @return
	 */
	public static boolean stringToBoolean(String value) {
		return value.equals("1") ? true : false; //$NON-NLS-1$
	}

	/**
	 * @param value
	 * @return
	 */
	public static int stringToInteger(String value) {
		try {
			return Integer.valueOf(value);
		} catch (Exception ex) {

		}
		return 0;
	}

	public static int[] createCirclePolygon(int r, int offsetX, int offsetY) {
		int f1 = 8;
		int[] polygon = new int[f1 * r + f1 / 2];
		for (int i = 0; i < 2 * r + 1; i++) {
			int x = i - r;
			int y = (int) Math.sqrt(r * r - x * x);
			polygon[2 * i] = offsetX + x;
			polygon[2 * i + 1] = offsetY + y;
			polygon[f1 * r - 2 * i - 2] = offsetX + x;
			polygon[f1 * r - 2 * i - 1] = offsetY - y;
		}
		return polygon;
	}

	/**
	 * @param var
	 * @param replacement
	 */
	public static String replaceTemplateVariable(String buf, String var, String replacement) {
		int pos = 0;
		while (true) {
			String key = Rcpl.JO_TEMPLATE_VAR + var;
			pos = buf.indexOf(key, pos);
			if (pos == -1) {
				break;
			}
			buf = buf.substring(0, pos) + replacement + buf.substring(pos + key.length(), buf.length());

		}
		return buf;
	}

	/**
	 * @param is
	 */
	public static void playClip(InputStream is, float volume) {
		AudioInputStream sound;
		try {
			sound = AudioSystem.getAudioInputStream(is);
			DataLine.Info info = new DataLine.Info(Clip.class, sound.getFormat());
			Clip clip = (Clip) AudioSystem.getLine(info);
			clip.open(sound);
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(volume);
			clip.start();
			clip.addLineListener(new LineListener() {
				@Override
				public void update(LineEvent event) {
					if (event.getType() == LineEvent.Type.STOP) {
						event.getLine().close();
					}
				}
			});
		} catch (UnsupportedAudioFileException e) {
		} catch (IOException e) {
		} catch (LineUnavailableException e) {
		}

		// play the sound clip

	}

	public static String getDomainFromUrl(String url) {
		try {
			if (!url.startsWith("http://") && !url.startsWith("https://")) { //$NON-NLS-1$ //$NON-NLS-2$
				url = "http://" + url; //$NON-NLS-1$
			}
			URL url2 = new URL(url);
			return getDomain(url2.getHost());

		} catch (Exception ex) {
		}
		return url;
	}

	/**
	 * @param host
	 * @return
	 */
	public static String getDomain(String host) {
		String[] splits = host.split("\\."); //$NON-NLS-1$
		if (splits.length < 3) {
			return host;
		}
		String domain = splits[splits.length - 2] + "." + splits[splits.length - 1]; //$NON-NLS-1$
		if (host.endsWith("co.uk")) { //$NON-NLS-1$
			domain = splits[splits.length - 3] + "." + domain; //$NON-NLS-1$
		} else if (splits[splits.length - 2].equals("gov")) { //$NON-NLS-1$
			domain = splits[splits.length - 3] + "." + domain; //$NON-NLS-1$
		} else if (splits[splits.length - 2].equals("edu")) { //$NON-NLS-1$
			domain = splits[splits.length - 3] + "." + domain; //$NON-NLS-1$
		} else if (splits[splits.length - 2].equals("mil")) { //$NON-NLS-1$
			domain = splits[splits.length - 3] + "." + domain; //$NON-NLS-1$
		}
		return domain;
	}

	/**
	 * @param host
	 * @return
	 */
	public static String getLastSegmentOfDomainName(String url) {
		String domain = getDomainFromUrl(url);
		String[] splits = domain.split("\\."); //$NON-NLS-1$
		return splits[splits.length - 1];
	}

	/**
	 * @param url
	 * @return
	 */
	public static String getUrlDisplayName(String url) {
		if (url == null) {
			return null;
		}
		if (!url.startsWith("http://") && !url.startsWith("https://")) { //$NON-NLS-1$ //$NON-NLS-2$
			url = "http://" + url; //$NON-NLS-1$
		}
		try {
			URL u = new URL(url);
			return u.getHost();
		} catch (MalformedURLException e) {
		}
		if (url.startsWith("http://")) { //$NON-NLS-1$
			url = url.substring(7, url.length());
		}
		if (url.startsWith("https://")) { //$NON-NLS-1$
			url = url.substring(8, url.length());
		}
		return url;
	}

	private static HashMap<String, String> htmlEntities;

	static {
		htmlEntities = new HashMap<String, String>();
		htmlEntities.put("&lt;", "<"); //$NON-NLS-1$ //$NON-NLS-2$
		htmlEntities.put("&gt;", ">"); //$NON-NLS-1$ //$NON-NLS-2$
		htmlEntities.put("&amp;", "&"); //$NON-NLS-1$ //$NON-NLS-2$
		htmlEntities.put("&quot;", "\""); //$NON-NLS-1$ //$NON-NLS-2$

		htmlEntities.put("&agrave;", "�"); //$NON-NLS-1$//$NON-NLS-2$
		htmlEntities.put("&Agrave;", "�"); //$NON-NLS-1$ //$NON-NLS-2$
		htmlEntities.put("&acirc;", "�"); //$NON-NLS-1$ //$NON-NLS-2$
		htmlEntities.put("&auml;", "�"); //$NON-NLS-1$ //$NON-NLS-2$
		htmlEntities.put("&Auml;", "�"); //$NON-NLS-1$ //$NON-NLS-2$
		htmlEntities.put("&Acirc;", "�"); //$NON-NLS-1$ //$NON-NLS-2$
		htmlEntities.put("&aring;", "�"); //$NON-NLS-1$ //$NON-NLS-2$
		htmlEntities.put("&Aring;", "�"); //$NON-NLS-1$ //$NON-NLS-2$
		htmlEntities.put("&aelig;", "�"); //$NON-NLS-1$ //$NON-NLS-2$
		htmlEntities.put("&AElig;", "�"); //$NON-NLS-1$ //$NON-NLS-2$
		htmlEntities.put("&ccedil;", "�"); //$NON-NLS-1$ //$NON-NLS-2$
		htmlEntities.put("&Ccedil;", "�"); //$NON-NLS-1$ //$NON-NLS-2$
		htmlEntities.put("&eacute;", "�"); //$NON-NLS-1$ //$NON-NLS-2$
		htmlEntities.put("&Eacute;", "�"); //$NON-NLS-1$ //$NON-NLS-2$
		htmlEntities.put("&Egrave;", "�"); //$NON-NLS-1$ //$NON-NLS-2$
		htmlEntities.put("&ecirc;", "�"); //$NON-NLS-1$ //$NON-NLS-2$
		htmlEntities.put("&Ecirc;", "�"); //$NON-NLS-1$ //$NON-NLS-2$
		htmlEntities.put("&euml;", "�"); //$NON-NLS-1$ //$NON-NLS-2$
		htmlEntities.put("&Euml;", "�"); //$NON-NLS-1$ //$NON-NLS-2$
		htmlEntities.put("&iuml;", "�"); //$NON-NLS-1$ //$NON-NLS-2$
		htmlEntities.put("&ocirc;", "�"); //$NON-NLS-1$ //$NON-NLS-2$
		htmlEntities.put("&Ocirc;", "�"); //$NON-NLS-1$ //$NON-NLS-2$
		htmlEntities.put("&ouml;", "�"); //$NON-NLS-1$ //$NON-NLS-2$
		htmlEntities.put("&Ouml;", "�"); //$NON-NLS-1$ //$NON-NLS-2$
		htmlEntities.put("&oslash;", "�"); //$NON-NLS-1$ //$NON-NLS-2$
		htmlEntities.put("&Oslash;", "�"); //$NON-NLS-1$ //$NON-NLS-2$
		htmlEntities.put("&szlig;", "�"); //$NON-NLS-1$ //$NON-NLS-2$
		htmlEntities.put("&ugrave;", "�"); //$NON-NLS-1$ //$NON-NLS-2$
		htmlEntities.put("&Ugrave;", "�"); //$NON-NLS-1$ //$NON-NLS-2$
		htmlEntities.put("&ucirc;", "�"); //$NON-NLS-1$ //$NON-NLS-2$
		htmlEntities.put("&Ucirc;", "�"); //$NON-NLS-1$ //$NON-NLS-2$
		htmlEntities.put("&uuml;", "�"); //$NON-NLS-1$ //$NON-NLS-2$
		htmlEntities.put("&Uuml;", "�"); //$NON-NLS-1$ //$NON-NLS-2$
		htmlEntities.put("&nbsp;", " "); //$NON-NLS-1$ //$NON-NLS-2$

		htmlEntities.put("&copy;", "\u00a9"); //$NON-NLS-1$ //$NON-NLS-2$
		htmlEntities.put("&reg;", "\u00ae"); //$NON-NLS-1$ //$NON-NLS-2$
		htmlEntities.put("&euro;", "\u20a0"); //$NON-NLS-1$ //$NON-NLS-2$
		htmlEntities.put("%20", " "); //$NON-NLS-1$ //$NON-NLS-2$
	}

	public static final String unescapeHTML(String source) {
		int i, j;

		boolean continueLoop;
		int skip = 0;
		do {
			continueLoop = false;
			i = source.indexOf("&", skip); //$NON-NLS-1$
			if (i > -1) {
				j = source.indexOf(";", i); //$NON-NLS-1$
				if (j > i) {
					String entityToLookFor = source.substring(i, j + 1);
					String value = htmlEntities.get(entityToLookFor);
					if (value != null) {
						source = source.substring(0, i) + value + source.substring(j + 1);
						continueLoop = true;
					} else {
						skip = i + 1;
						continueLoop = true;
					}
				}
			}
		} while (continueLoop);

		if (source.indexOf("%20") != -1) { //$NON-NLS-1$
			source = source.replaceAll("%20", " "); //$NON-NLS-1$//$NON-NLS-2$
		}

		return source;
	}

	/**
	 * @param key2
	 * @return
	 */
	public static String getImageResourceName(String key2) {
		int pos = key2.lastIndexOf("/"); //$NON-NLS-1$
		if (pos != -1) {
			return "images" + key2.substring(pos, key2.length()); //$NON-NLS-1$
		}
		return "images" + key2; //$NON-NLS-1$

	}

	/**
	 * @param s
	 * @param delimiter
	 * @return
	 */
	public static String getLastSegment(String s, String delimiter) {
		int pos = s.lastIndexOf(delimiter);
		if (pos != -1) {
			return s.substring(pos + 1, s.length());
		}
		return s;

	}

	public static void dump(javafx.scene.Node n) {
		dump(n, 0);
	}

	private static void dump(javafx.scene.Node n, int depth) {
		for (int i = 0; i < depth; i++)
			System.out.print("  ");
		// System.out.log("*** dump: " + n);
		if (n instanceof Parent)
			for (javafx.scene.Node c : ((Parent) n).getChildrenUnmodifiable())
				dump(c, depth + 1);
	}

	// debugging routine to highlight the borders of nodes.
	public static void highlight(javafx.scene.Node n) {
		highlight(n, 0);
	}

	private static void highlight(javafx.scene.Node n, int depth) {
		n.setStyle("-fx-stroke: red; -fx-stroke-width: 1; -fx-stroke-type: inside;");
		if (n instanceof Parent)
			for (javafx.scene.Node c : ((Parent) n).getChildrenUnmodifiable())
				highlight(c, depth + 1);
	}

}

/**
 * @author ramin
 * 
 */
class FavIcon {
	public Image image;
	public Image imageOriginal;
	public boolean loaded;
}
