package org.eclipse.rcpl.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.xmlbeans.XmlObject;
import org.eclipse.rcpl.EnMeasurementUnits;
import org.eclipse.rcpl.EnPageSize;
import org.eclipse.rcpl.IColorProvider;
import org.eclipse.rcpl.ILayoutObject;
import org.eclipse.rcpl.IMonitor;
import org.eclipse.rcpl.Rcpl;
import org.eclipse.rcpl.RcplCountry;
import org.eclipse.rcpl.internal.config.RcplConfig;
import org.eclipse.rcpl.libs.util.AUtil;
import org.eclipse.rcpl.libs.util.StringOutputStream;
import org.eclipse.rcpl.model.RcplModel;
import org.eclipse.rcpl.model.client.RcplSession;
import org.eclipse.rcpl.model_2_0_0.rcpl.Tool;
import org.w3c.dom.Node;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * @author Ramin
 *
 */
public class RcplUtil {

	private static double point2PixelFactor = -1;

//	private static double physicalWidth = -1;

	private static IMonitor actualMonitor;

	/**
	 * 
	 */
	public static void initProperties() {

		if (RcplConfig.preferenceColor_1 == null) {
			RcplConfig.preferenceColor_1 = (int[]) RcplConfig.getEditorColors()[5];
		}
		;
		if (RcplConfig.preferenceColor_2 == null) {
			RcplConfig.preferenceColor_2 = (int[]) RcplConfig.getEditorColors()[5];
		}
		;
		if (RcplConfig.preferenceColor_3 == null) {
			RcplConfig.preferenceColor_3 = (int[]) RcplConfig.getEditorColors()[5];
		}

		int number = 1;
		// if (JO.officePane != null && JO.officePane.getContainer() != null) {
		// number = JO.officePane.getContainer().getNumber();
		// }
		switch (number) {
		case 1:
			setIfNull(IColorProvider.COLOR_MAIN_OFFICE_COLOR, RcplConfig.preferenceColor_1[0] + "," //$NON-NLS-1$
					+ RcplConfig.preferenceColor_1[1] + "," + RcplConfig.preferenceColor_1[2]); //$NON-NLS-1$
			break;
		case 2:
			setIfNull(IColorProvider.COLOR_MAIN_OFFICE_COLOR, RcplConfig.preferenceColor_2[0] + "," //$NON-NLS-1$
					+ RcplConfig.preferenceColor_2[1] + "," + RcplConfig.preferenceColor_2[2]); //$NON-NLS-1$
			break;
		case 3:
			setIfNull(IColorProvider.COLOR_MAIN_OFFICE_COLOR, RcplConfig.preferenceColor_3[0] + "," //$NON-NLS-1$
					+ RcplConfig.preferenceColor_3[1] + "," + RcplConfig.preferenceColor_3[2]); //$NON-NLS-1$
			break;
		}
		setIfNull("infotab/actions/color/show_background_images", false); //$NON-NLS-1$
		setIfNull("profile_mode", 0); //$NON-NLS-1$
		setIfNull("spreadsheet/actions/editor/grid", true); //$NON-NLS-1$

		setIfNull("infotab/actions/setup/setup_browser_url_home", "http://google.com"); //$NON-NLS-1$ //$NON-NLS-2$
		setIfNull("infotab/actions/setup/setup_search_url_1", //$NON-NLS-1$
				"http://www.google.co.uk/search?q=" + Rcpl.TEMPLATEVAR_1 + "&ie=utf-8&oe=utf-8&aq=t"); //$NON-NLS-1$ //$NON-NLS-2$
		setIfNull("infotab/actions/setup/setup_search_url_2", //$NON-NLS-1$
				"http://uk.search.yahoo.com/search?p=" + Rcpl.TEMPLATEVAR_1 + "&ei=UTF-8&fr=chrf-ytbm"); //$NON-NLS-1$ //$NON-NLS-2$
		setIfNull("infotab/actions/setup/setup_search_url_3", //$NON-NLS-1$
				"http://www.amazon.co.uk/s?ie=UTF8&tag=firefox-uk-21&index=blended&link_code=qs&field-keywords=" //$NON-NLS-1$
						+ Rcpl.TEMPLATEVAR_1 + ""); //$NON-NLS-1$
		setIfNull("infotab/actions/setup/setup_search_url_4", //$NON-NLS-1$
				"http://www.answers.com/main/ntquery?s=" + Rcpl.TEMPLATEVAR_1 + "&gwp=13"); //$NON-NLS-1$ //$NON-NLS-2$
		setIfNull("infotab/actions/setup/setup_search_url_5", //$NON-NLS-1$
				"http://www.chambersharrap.co.uk/chambers/features/chref/chref.py/main?query=" + Rcpl.TEMPLATEVAR_1 //$NON-NLS-1$
						+ "&title=21st"); //$NON-NLS-1$
		setIfNull("infotab/actions/setup/setup_search_url_6", //$NON-NLS-1$
				"http://search.creativecommons.org/?q=" + Rcpl.TEMPLATEVAR_1 + "&sourceid=Mozilla-search"); //$NON-NLS-1$ //$NON-NLS-2$
		setIfNull("infotab/actions/setup/setup_search_url_7", //$NON-NLS-1$
				"http://shop.ebay.co.uk/i.html?_nkw=" + Rcpl.TEMPLATEVAR_1 + "&_armrs=1&_from=&_ipg="); //$NON-NLS-1$ //$NON-NLS-2$
		setIfNull("infotab/actions/setup/setup_search_url_8", //$NON-NLS-1$
				"http://en.wikipedia.org/wiki/" + Rcpl.TEMPLATEVAR_1 + ""); //$NON-NLS-1$ //$NON-NLS-2$
		setIfNull("infotab/actions/setup/setup_search_url_9", ""); //$NON-NLS-1$//$NON-NLS-2$

		setIfNull("infotab/actions/setup/setup_my_web_host", RcplSession.getDefault().getImageCodeBases().get(0)); //$NON-NLS-1$ //$NON-NLS-2$
		setIfNull("infotab/actions/setup/setup_my_web_port", 8088); //$NON-NLS-1$

		RcplCountry country = RcplCountry.getCountry(Locale.getDefault());
		if (country.equals(RcplCountry.UNITED_STATES)
				|| country.equals(RcplCountry.UNITED_STATES_MINOR_OUTLYING_ISLANDS)

		) {
			setIfNull("infotab/actions/editor/default_page_size", //$NON-NLS-1$
					EnPageSize.LETTER.ordinal());
		} else {
			setIfNull("infotab/actions/editor/default_page_size", //$NON-NLS-1$
					EnPageSize.A4.ordinal());
		}

	}

	/**
	 * 
	 */
	private static void initDefaultProperties() {
		if (RcplConfig.preferenceColor_1 == null) {
			RcplConfig.preferenceColor_1 = (int[]) RcplConfig.getEditorColors()[5];
		}
		;
		if (RcplConfig.preferenceColor_2 == null) {
			RcplConfig.preferenceColor_2 = (int[]) RcplConfig.getEditorColors()[5];
		}
		;
		if (RcplConfig.preferenceColor_3 == null) {
			RcplConfig.preferenceColor_3 = (int[]) RcplConfig.getEditorColors()[5];
		}

		setDefaultIfNull(getDefaultProperties(), "infotab/actions/color/show_background_images", false); //$NON-NLS-1$
		setDefaultIfNull(getDefaultProperties(), IColorProvider.COLOR_MAIN_OFFICE_COLOR, 164 + "," + 196 + "," + 246); //$NON-NLS-1$ //$NON-NLS-2$
		setDefaultIfNull(getDefaultProperties(), "profile_mode", 0); //$NON-NLS-1$
		setDefaultIfNull(getDefaultProperties(), "spreadsheet/actions/editor/grid", true); //$NON-NLS-1$
		setDefaultIfNull(getDefaultProperties(), "infotab/actions/editor/generated_password_length", 10); //$NON-NLS-1$
		setDefaultIfNull(getDefaultProperties(), "word/actions/editor/match_case", true); //$NON-NLS-1$

		setDefaultIfNull(getDefaultProperties(), "infotab/actions/color/show_background_images", false); //$NON-NLS-1$
		setDefaultIfNull(getDefaultProperties(), "profile_mode", 0); //$NON-NLS-1$
		setDefaultIfNull(getDefaultProperties(), "spreadsheet/actions/editor/grid", true); //$NON-NLS-1$

		setDefaultIfNullOrEmpty(getDefaultProperties(), "infotab/actions/setup/setup_browser_url_home", //$NON-NLS-1$
				"http://google.com"); //$NON-NLS-1$
		setDefaultIfNullOrEmpty(getDefaultProperties(), "infotab/actions/setup/setup_search_url_1", //$NON-NLS-1$
				"http://www.google.co.uk/search?q=" + Rcpl.TEMPLATEVAR_1 + "&ie=utf-8&oe=utf-8&aq=t"); //$NON-NLS-1$ //$NON-NLS-2$
		setDefaultIfNullOrEmpty(getDefaultProperties(), "infotab/actions/setup/setup_search_url_2", //$NON-NLS-1$
				"http://uk.search.yahoo.com/search?p=" + Rcpl.TEMPLATEVAR_1 + "&ei=UTF-8&fr=chrf-ytbm"); //$NON-NLS-1$ //$NON-NLS-2$
		setDefaultIfNullOrEmpty(getDefaultProperties(), "infotab/actions/setup/setup_search_url_3", //$NON-NLS-1$
				"http://www.amazon.co.uk/s?ie=UTF8&tag=firefox-uk-21&index=blended&link_code=qs&field-keywords=" //$NON-NLS-1$
						+ Rcpl.TEMPLATEVAR_1 + ""); //$NON-NLS-1$
		setDefaultIfNullOrEmpty(getDefaultProperties(), "infotab/actions/setup/setup_search_url_4", //$NON-NLS-1$
				"http://www.answers.com/main/ntquery?s=" + Rcpl.TEMPLATEVAR_1 + "&gwp=13"); //$NON-NLS-1$ //$NON-NLS-2$
		setDefaultIfNullOrEmpty(getDefaultProperties(), "infotab/actions/setup/setup_search_url_5", //$NON-NLS-1$
				"http://www.chambersharrap.co.uk/chambers/features/chref/chref.py/main?query=" + Rcpl.TEMPLATEVAR_1 //$NON-NLS-1$
						+ "&title=21st"); //$NON-NLS-1$
		setDefaultIfNullOrEmpty(getDefaultProperties(), "infotab/actions/setup/setup_search_url_6", //$NON-NLS-1$
				"http://search.creativecommons.org/?q=" + Rcpl.TEMPLATEVAR_1 + "&sourceid=Mozilla-search"); //$NON-NLS-1$ //$NON-NLS-2$
		setDefaultIfNullOrEmpty(getDefaultProperties(), "infotab/actions/setup/setup_search_url_7", //$NON-NLS-1$
				"http://shop.ebay.co.uk/i.html?_nkw=" + Rcpl.TEMPLATEVAR_1 + "&_armrs=1&_from=&_ipg="); //$NON-NLS-1$ //$NON-NLS-2$
		setDefaultIfNullOrEmpty(getDefaultProperties(), "infotab/actions/setup/setup_search_url_8", //$NON-NLS-1$
				"http://en.wikipedia.org/wiki/" + Rcpl.TEMPLATEVAR_1 + ""); //$NON-NLS-1$ //$NON-NLS-2$
		setDefaultIfNullOrEmpty(getDefaultProperties(), "infotab/actions/setup/setup_search_url_9", //$NON-NLS-1$
				"http://www.youtube.com/results?search_query=" + Rcpl.TEMPLATEVAR_1 + "&aq=f"); //$NON-NLS-1$ //$NON-NLS-2$
		// infotab/actions/setup/setup_search_url
		int index;

		index = 1;

		setDefaultIfNull(getDefaultProperties(), "browser/actions/browser/search_engine_default_" + index, true); //$NON-NLS-1$
		setIfNull("browser/actions/browser/search_engine_default_" + index, true); //$NON-NLS-1$

		setDefaultIfNull(getDefaultProperties(), "infotab/actions/setup/setup_my_web_host", //$NON-NLS-1$
				RcplSession.getDefault().getImageCodeBases().get(0)); // $NON-NLS-2$
		setDefaultIfNull(getDefaultProperties(), "infotab/actions/setup/setup_my_web_port", 8088); //$NON-NLS-1$

		RcplCountry country = RcplCountry.getCountry(Locale.getDefault());
		initDefaultProperties(country);
	}

	/**
	 * @param country
	 */
	public static void initDefaultProperties(RcplCountry country) {

		// ---------- us -------------------------------------------------------

		if (country.equals(RcplCountry.UNITED_STATES)
				|| country.equals(RcplCountry.UNITED_STATES_MINOR_OUTLYING_ISLANDS)

		) {
			setDefaultIfNull(getDefaultProperties(), "infotab/actions/editor/default_page_size", //$NON-NLS-1$
					EnPageSize.LETTER.ordinal());
			setDefaultIfNull(getDefaultProperties(), "infotab/actions/editor/show_measurements_in_units_of", 0); //$NON-NLS-1$

			setDefaultIfNullOrEmpty(getDefaultProperties(), "infotab/actions/setup/setup_site_mail", //$NON-NLS-1$
					"http://gmail.com"); //$NON-NLS-1$
			setDefaultIfNullOrEmpty(getDefaultProperties(), "infotab/actions/setup/setup_site_news", "http://nbc.com"); //$NON-NLS-1$//$NON-NLS-2$
			setDefaultIfNullOrEmpty(getDefaultProperties(), "infotab/actions/setup/setup_site_messenger", //$NON-NLS-1$
					"http://webmessenger.yahoo.com"); //$NON-NLS-1$
			setDefaultIfNullOrEmpty(getDefaultProperties(), "infotab/actions/setup/setup_site_finance", //$NON-NLS-1$
					"http://finance.yahoo.com"); //$NON-NLS-1$
			setDefaultIfNullOrEmpty(getDefaultProperties(), "infotab/actions/setup/setup_site_maps", //$NON-NLS-1$
					"http://maps.google.com"); //$NON-NLS-1$
			setDefaultIfNullOrEmpty(getDefaultProperties(), "infotab/actions/setup/setup_site_sports", //$NON-NLS-1$
					"http://www.skysports.com"); //$NON-NLS-1$
			setDefaultIfNullOrEmpty(getDefaultProperties(), "infotab/actions/setup/setup_site_travel", //$NON-NLS-1$
					"http://www.thomascook.com"); //$NON-NLS-1$
			setDefaultIfNullOrEmpty(getDefaultProperties(), "infotab/actions/setup/setup_site_weather", //$NON-NLS-1$
					"http://weather.com"); //$NON-NLS-1$
			setDefaultIfNullOrEmpty(getDefaultProperties(), "infotab/actions/setup/setup_site_cars", //$NON-NLS-1$
					"http://www.whatcar.com"); //$NON-NLS-1$
			setDefaultIfNullOrEmpty(getDefaultProperties(), "infotab/actions/setup/setup_site_answers", //$NON-NLS-1$
					"http://www.answers.com"); //$NON-NLS-1$
			setDefaultIfNullOrEmpty(getDefaultProperties(), "infotab/actions/setup/setup_site_dating", //$NON-NLS-1$
					"http://www.datingforseniors.com/"); //$NON-NLS-1$
			setDefaultIfNullOrEmpty(getDefaultProperties(), "infotab/actions/setup/setup_site_games", //$NON-NLS-1$
					"http://www.games.com"); //$NON-NLS-1$
			setDefaultIfNullOrEmpty(getDefaultProperties(), "infotab/actions/setup/setup_site_groups", //$NON-NLS-1$
					"http://groups.google.com"); //$NON-NLS-1$
			setDefaultIfNullOrEmpty(getDefaultProperties(), "infotab/actions/setup/setup_site_horoscopes", //$NON-NLS-1$
					"http://www.horoscopes.co.uk"); //$NON-NLS-1$
			setDefaultIfNullOrEmpty(getDefaultProperties(), "infotab/actions/setup/setup_site_lifestyle", //$NON-NLS-1$
					"http://uk.lifestyle.yahoo.com"); //$NON-NLS-1$
			setDefaultIfNullOrEmpty(getDefaultProperties(), "infotab/actions/setup/setup_site_health", //$NON-NLS-1$
					"http://uk.reuters.com/news/health"); //$NON-NLS-1$
			setDefaultIfNullOrEmpty(getDefaultProperties(), "infotab/actions/setup/setup_site_video", //$NON-NLS-1$
					"http://www.youtube.com/"); //$NON-NLS-1$
			setDefaultIfNullOrEmpty(getDefaultProperties(), "infotab/actions/setup/setup_site_radio", //$NON-NLS-1$
					"http://www.live365.com/index.live"); //$NON-NLS-1$
		}

		// ---------- uk -------------------------------------------------------

		else {
			setDefaultIfNull(getDefaultProperties(), "infotab/actions/editor/default_page_size", //$NON-NLS-1$
					EnPageSize.A4.ordinal());
			setDefaultIfNull(getDefaultProperties(), "infotab/actions/editor/show_measurements_in_units_of", 1); //$NON-NLS-1$

			setDefaultIfNullOrEmpty(getDefaultProperties(), "infotab/actions/setup/setup_site_mail", //$NON-NLS-1$
					"http://gmail.com"); //$NON-NLS-1$
			setDefaultIfNullOrEmpty(getDefaultProperties(), "infotab/actions/setup/setup_site_news", //$NON-NLS-1$
					"http://bbc.co.uk"); //$NON-NLS-1$
			setDefaultIfNullOrEmpty(getDefaultProperties(), "infotab/actions/setup/setup_site_messenger", //$NON-NLS-1$
					"http://webmessenger.yahoo.com"); //$NON-NLS-1$
			setDefaultIfNullOrEmpty(getDefaultProperties(), "infotab/actions/setup/setup_site_finance", //$NON-NLS-1$
					"http://finance.yahoo.com"); //$NON-NLS-1$
			setDefaultIfNullOrEmpty(getDefaultProperties(), "infotab/actions/setup/setup_site_maps", //$NON-NLS-1$
					"http://maps.google.com"); //$NON-NLS-1$
			setDefaultIfNullOrEmpty(getDefaultProperties(), "infotab/actions/setup/setup_site_sports", //$NON-NLS-1$
					"http://www.skysports.com"); //$NON-NLS-1$
			setDefaultIfNullOrEmpty(getDefaultProperties(), "infotab/actions/setup/setup_site_travel", //$NON-NLS-1$
					"http://www.thomascook.com"); //$NON-NLS-1$
			setDefaultIfNullOrEmpty(getDefaultProperties(), "infotab/actions/setup/setup_site_weather", //$NON-NLS-1$
					"http://news.bbc.co.uk/weather"); //$NON-NLS-1$
			setDefaultIfNullOrEmpty(getDefaultProperties(), "infotab/actions/setup/setup_site_cars", //$NON-NLS-1$
					"http://www.whatcar.com"); //$NON-NLS-1$
			setDefaultIfNullOrEmpty(getDefaultProperties(), "infotab/actions/setup/setup_site_answers", //$NON-NLS-1$
					"http://www.answers.com"); //$NON-NLS-1$
			setDefaultIfNullOrEmpty(getDefaultProperties(), "infotab/actions/setup/setup_site_dating", //$NON-NLS-1$
					"http://www.seniordatinggroup.co.uk/"); //$NON-NLS-1$
			setDefaultIfNullOrEmpty(getDefaultProperties(), "infotab/actions/setup/setup_site_games", //$NON-NLS-1$
					"http://www.games.com"); //$NON-NLS-1$
			setDefaultIfNullOrEmpty(getDefaultProperties(), "infotab/actions/setup/setup_site_groups", //$NON-NLS-1$
					"http://groups.google.com"); //$NON-NLS-1$
			setDefaultIfNullOrEmpty(getDefaultProperties(), "infotab/actions/setup/setup_site_horoscopes", //$NON-NLS-1$
					"http://www.horoscopes.co.uk"); //$NON-NLS-1$
			setDefaultIfNullOrEmpty(getDefaultProperties(), "infotab/actions/setup/setup_site_lifestyle", //$NON-NLS-1$
					"http://uk.lifestyle.yahoo.com"); //$NON-NLS-1$
			setDefaultIfNullOrEmpty(getDefaultProperties(), "infotab/actions/setup/setup_site_health", //$NON-NLS-1$
					"http://www.bbc.co.uk/health/"); //$NON-NLS-1$
			setDefaultIfNullOrEmpty(getDefaultProperties(), "infotab/actions/setup/setup_site_video", //$NON-NLS-1$
					"http://www.youtube.com/"); //$NON-NLS-1$
			setDefaultIfNullOrEmpty(getDefaultProperties(), "infotab/actions/setup/setup_site_radio", //$NON-NLS-1$
					"http://www.bbc.co.uk/iplayer/console/bbc_radio_one"); //$NON-NLS-1$
		}
	}

	/**
	 * 
	 */
	public static void updateSetupFields() {
		String idx = (String) AUtil.get(defaultProperties, "infotab/actions/editor/show_measurements_in_units_of"); //$NON-NLS-1$
		int index = 1;
		if (idx != null) {
			try {
				index = Integer.valueOf(idx);
				if (index >= 0) {
					defaultMeasurementUnits = EnMeasurementUnits.valueOf(index);
				}
			} catch (Exception ex) {
			}
		}
	}

	public static EnMeasurementUnits defaultMeasurementUnits = EnMeasurementUnits.CM;

	/**
	 * @param key
	 * @return
	 */
	public static String getDefaultString(String key) {
		String result = (String) AUtil.get(getDefaultProperties(), key);
		return result;
	}

	private static Properties defaultProperties;

	/**
	 * @return
	 */
	public static Properties getDefaultProperties() {
		if (defaultProperties == null) {
			defaultProperties = new Properties();
			// try {
			// File f = JOUtil.getDefaultPropertyFile();
			// if (f.exists()) {
			// defaultProperties.load(new FileInputStream(f));
			// }
			// } catch (FileNotFoundException e) {
			// LOGGER.error("", e); //$NON-NLS-1$
			// } catch (IOException e) {
			// LOGGER.error("", e); //$NON-NLS-1$
			// }
			initDefaultProperties();
			updateSetupFields();

			// if (migrateProperties()){
			// return getDefaultProperties();
			// }

			if (defaultProperties == null) {
				return getDefaultProperties();
			}

		}

		return defaultProperties;
	}

	private static Properties instanceProperties;

	/**
	 * @return
	 */
	public static int getGeneratedPasswordsLength() {
		int length = AUtil.getDefaultInteger(getDefaultProperties(),
				"infotab/actions/editor/generated_password_length"); //$NON-NLS-1$
		if (length == 0) {
			length = 10;
		}
		return length;
	}

	/**
	 * @param key
	 * @param value
	 * @param save
	 */
	public static void set(String key, Object value) {
		if (value instanceof Boolean) {
			if (key.startsWith("word/actions/groups/styles")) { //$NON-NLS-1$
				return;
			}
			AUtil.put(getInstanceProperties(), key, ((Boolean) value) ? "t" : "f"); //$NON-NLS-1$//$NON-NLS-2$
		} else {
			AUtil.put(getInstanceProperties(), key, value.toString());
		}
	}
	// /**
	// * @param templateResourceName
	// * @return
	// */
	// public static InputStream loadLibTemplate(String templateResourceName) {
	// InputStream is = RcplResourcesPlugin.class
	// .getResourceAsStream(templateResourceName);
	// return is;
	// }

	public static InputStream loadTemplate(String templateResourceName) {
		InputStream is = Rcpl.class.getResourceAsStream(Rcpl.getDefaultTemplatesPath() + templateResourceName); // $NON-NLS-1$
		return is;
	}

	/**
	 * @param templateResourceName
	 * @return
	 */
	public static String loadTemplateAsString(String templateResourceName) {
		InputStream is = loadTemplate(templateResourceName);
		return AUtil.convertStreamToString(is);
	}

	/**
	 * @param templateResourceName
	 * @return
	 */
	public static File loadTemplateDocumentToFile(String name, boolean escapeHtml) {

		String path = Rcpl.getDefaultTemplatesPath() + name;
		InputStream is = AUtil.class.getResourceAsStream(path); // $NON-NLS-1$
		if (is == null) {
			return null;
		}
		File outFile = new File(getUserLocalTempArea(),
				// "temp_" + new Date().getTime() + "_" +
				name);
		try {
			AUtil.copyInputStream(is, outFile, escapeHtml);

		} catch (Throwable e) {
			RcplModel.logError(e);
		}

		return outFile;
	}

	public static File loadTemplateDocumentToTempFile(String name, boolean escapeHtml) {
		File outFile = new File(getUserLocalTempArea(),
				// "temp_" + new Date().getTime() + "_" +
				name);
		loadTemplateDocumentToFile(name, outFile, escapeHtml);
		return outFile;
	}

	/**
	 * @param templateResourceName
	 * @return
	 */
	public static void loadTemplateDocumentToFile(String name, File outFile, boolean escapeHtml) {
		InputStream is = AUtil.class.getResourceAsStream(Rcpl.getDefaultTemplatesPath() + name); // $NON-NLS-1$
		try {
			AUtil.copyInputStream(is, outFile, escapeHtml);
		} catch (IOException e) {
			// LOGGER.error("", e); //$NON-NLS-1$
		}
	}

	public static String loadTemplateHTMLDocument(String name, HashMap<String, String> wordReplacements,
			boolean escapeHtml) {

		InputStream is = AUtil.class.getResourceAsStream(Rcpl.getDefaultTemplatesPath() + name); // $NON-NLS-1$

		// InputStreamReader r;
		// OutputStreamWriter w;

		try {
			// r = new InputStreamReader(is, Charset.forName("windows-1252"));

			StringOutputStream out = new StringOutputStream();
			// w = new OutputStreamWriter(out, Charset.forName("UTF-8"));

			try {
				String htmlText = AUtil.copyInputStream(is, out, escapeHtml);
				out.flush();
				out.close();
				htmlText = new String(htmlText.getBytes("windows-1252"));
				return htmlText;

			} catch (IOException e) {
				// LOGGER.error("", e); //$NON-NLS-1$
			}

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return null;
	}

	/**
	 * @param editorFigure
	 */
	public static void indexAllRootObjects(List<ILayoutObject> layoutObjects) {

		ILayoutObject firstRootObject = null;
		for (ILayoutObject l : layoutObjects) {
			if (l.isRootObject()) {
				firstRootObject = l;
				break;
			}
		}
		Node firstNode = null;
		if (firstRootObject != null) {
			XmlObject startNode = firstRootObject.getXmlObject();
			firstNode = startNode.getDomNode().getParentNode().getFirstChild();
			Node next = firstNode;
			int ind = 0;
			while (next != null) {
				for (ILayoutObject l : layoutObjects) {
					if (next == l.getXmlObject().getDomNode()) {
						l.setXmlIndex(ind);
						break;
					}
				}
				next = next.getNextSibling();
				ind++;
			}
		}
	}

	/**
	 * @param layoutObjects
	 * @param progress
	 */
	public static void sortRootObjects(List<ILayoutObject> layoutObjects) {
		indexAllRootObjects(layoutObjects);
		Collections.sort(layoutObjects, new Comparator<ILayoutObject>() {
			@Override
			public int compare(ILayoutObject o1, ILayoutObject o2) {
				if (o1.getIndex() < o2.getIndex()) {
					return -1;
				}
				return 1;
			}
		});
	}

	/**
	 * @param key
	 * @param value
	 * @param save
	 */
	public static void setIfNull(String key, Object value) {
		if (AUtil.get(getInstanceProperties(), key) == null) {
			set(key, value);
		}
	}

	public static void setDefaultIfNull(Properties properties, String key, Object value) {
		if (AUtil.get(properties, key) == null) {
			setDefaultProperty(getDefaultProperties(), key, value);
		}
	}

	public static void setDefaultIfNullOrEmpty(Properties properties, String key, Object value) {
		Object oldValue = AUtil.get(properties, key);
		if (oldValue == null || oldValue instanceof String && ((String) oldValue).length() == 0) {
			setDefaultProperty(getDefaultProperties(), key, value);
		}
	}

	/**
	 * @param key
	 * @param value
	 * @param save
	 */
	public static void setDefaultProperty(Properties properties, String key, Object value) {
		if (value instanceof Boolean) {
			if (key.startsWith("word/actions/groups/styles")) { //$NON-NLS-1$
				return;
			}
			AUtil.put(properties, key, ((Boolean) value) ? "t" : "f"); //$NON-NLS-1$//$NON-NLS-2$
		} else {
			AUtil.put(properties, key, value.toString());
		}
	}

	/**
	 * @param key
	 * @return
	 */
	public static String getString(String key) {
		String result = (String) AUtil.get(getInstanceProperties(), key);
		return result;
	}

	private final static int PROPERTY_VERSION = 1;

	/**
	 * If a shell container is used then all properties will be linked to that.
	 * Otherwise there is only one set.
	 * 
	 * @return
	 */
	public static Properties getInstanceProperties() {
		if (instanceProperties == null) {
			instanceProperties = new Properties();
			// try {
			// File file = JOUtil.getPropertyFile();
			// instanceProperties.load(new FileInputStream(file));
			// } catch (FileNotFoundException e) {
			// } catch (IOException e) {
			// }
			initProperties();
			int version = AUtil.getInteger(getInstanceProperties(), "property_version"); //$NON-NLS-1$
			if (version != PROPERTY_VERSION) {
				instanceProperties.clear();
				set("property_version", PROPERTY_VERSION); //$NON-NLS-1$
				// try {
				// instanceProperties.load(new FileInputStream(
				// getDefaultPropertyFile()));
				// } catch (FileNotFoundException e) {
				// } catch (IOException e) {
				// }
				initProperties();
			}
			// if (migrateProperties()) {
			// return getInstanceProperties();
			// }
			if (instanceProperties == null) {
				return getInstanceProperties();
			}
		}
		return instanceProperties;
	}

	public static int getInteger(String key) {
		return AUtil.getInteger(getInstanceProperties(), key);
	}

	public static int getDefaultInteger(String key) {
		return AUtil.getInteger(getDefaultProperties(), key);
	}

	public static boolean getBoolean(String key) {
		return AUtil.getBoolean(getInstanceProperties(), key);
	}

	/**
	 * @param matchKey
	 */
	public static void removeAllInstanceProperties(String matchKey) {
		Enumeration<Object> keys = instanceProperties.keys();
		while (keys.hasMoreElements()) {
			String key = (String) keys.nextElement();
			if (key.startsWith(matchKey)) {
				AUtil.remove(instanceProperties, key);
			}
		}
	}

	public static final File copyFileFromUrlToCache(URL url, boolean escapeHtml) {
		String fileName = url.getFile();
		InputStream is;
		try {
			is = url.openStream();
		} catch (IOException e1) {
			return null;
		}
		File outFile = new File(getUserLocalCacheDir(), fileName);
		outFile.getParentFile().mkdirs();
		try {
			AUtil.copyInputStream(is, new FileOutputStream(outFile), escapeHtml);
		} catch (FileNotFoundException e) {
			return null;
		} catch (IOException e) {
			return null;
		}
		return outFile;
	}

	private static File userLocalCacheDir;
	private static File userLocalArea;
	private static File userLocalTempDir;

	/**
	 * @param is
	 * @param fileName
	 * @return
	 */
	public static final File copyByteArrayToCache(byte[] byteArray, String fileName) {
		File outFile = new File(getUserLocalCacheDir(), fileName);
		outFile.getParentFile().mkdirs();
		try {
			OutputStream os = new FileOutputStream(outFile);
			os.write(byteArray);
			os.flush();
			os.close();
		} catch (FileNotFoundException e) {
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return outFile;
	}

	/**
	 * @param fileName
	 * @return
	 */
	public static long getCachedFileSize(String fileName) {
		File file = new File(getUserLocalCacheDir(), fileName);
		if (file.exists()) {
			return file.length();
		}
		return 0;
	}

	/**
	 * @param fileName
	 * @return
	 */
	public static File getCachedFile(String fileName) {
		File file = new File(getUserLocalCacheDir(), fileName);
		if (file.exists()) {
			return file;
		}
		return null;
	}

	/**
	 * @param is
	 * @param fileName
	 * @return
	 */
	public static final File copyInputStreamToCache(InputStream is, String fileName) {
		File outFile = new File(getUserLocalCacheDir(), fileName);
		outFile.getParentFile().mkdirs();
		try {
			AUtil.copyInputStream(is, new FileOutputStream(outFile), false);
		} catch (FileNotFoundException e) {
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return outFile;
	}

	/**
	 * @param num
	 * @return
	 */
	public static File getPropertyFile(int num) {
		return new File(getUserLocalArea(), "rcpl" + num + ".properties"); //$NON-NLS-1$ //$NON-NLS-2$
	}

	@SuppressWarnings("unused")
	private static File getDefaultPropertyFile() {
		return new File(getUserLocalArea(), "rcpl.properties"); //$NON-NLS-1$
	}

	public static File getOOXMLRegistryFile() {
		return new File(getUserLocalArea(), "rcpl.dat"); //$NON-NLS-1$
	}

	/**
	 * 
	 */
	public static void deleteOldLockFiles() {
		for (int i = 1; i < 10; i++) {
			File lockFile = new File(getUserLocalArea(), "joffice" + i + ".lock"); //$NON-NLS-1$//$NON-NLS-2$
			if (lockFile.exists()) {
				long diff = System.currentTimeMillis() - lockFile.lastModified();
				if (diff > 3000) {
					lockFile.delete();
				}
			}
		}
	}

//	private static int instanceNumber;

	public static File lockFile;

	/**
	 * @return
	 */
	public static File getUserLocalTempArea() {
		if (userLocalTempDir == null) {
			userLocalTempDir = new File(getUserLocalArea(), "temp");
			userLocalTempDir.mkdirs();
		}
		return userLocalTempDir;
	}

	/**
	 * @return
	 */
	public static File getUserLocalCacheDir() {
		if (userLocalCacheDir == null) {
			userLocalCacheDir = new File(getUserLocalArea(), "cache");
			userLocalCacheDir.mkdirs();
		}
		return userLocalCacheDir;
	}

	public static File getUserLocalArea() {
		if (userLocalArea == null) {
			if (RcplModel.mobileProvider != null) {
				userLocalArea = RcplModel.mobileProvider.getApplicationDir(); // $NON-NLS-1$
			} else {
				userLocalArea = new File(System.getProperty("user.home"), ".rcpl"); //$NON-NLS-1$
			}
			userLocalArea.mkdirs();
		}
		return userLocalArea;
	}

	public static Properties getOfficeInstanceProperties(int num) {
		Properties properties = new Properties();
		initProperties();
		return properties;

		// try {
		// File file = JOUtil.getPropertyFile(num);
		// properties.load(new FileInputStream(file));
		// initProperties();
		// return properties;
		// } catch (FileNotFoundException e) {
		// } catch (IOException e) {
		// }
		// return null;
	}

	public static void deleteFolder(File folder) {
		File[] files = folder.listFiles();
		if (files != null) { // some JVMs return null for empty dirs
			for (File f : files) {
				if (f.isDirectory()) {
					deleteFolder(f);
				} else {
					f.delete();
				}
			}
		}
		folder.delete();
	}

	public static String getImageId(Tool tool) {
		String id = tool.getImage();
		if (id == null) {
			id = tool.getId();
		}
		return id;
	}

	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
		}
	}

	public static boolean compareContent(File file1, File file2) {
		try {
			return FileUtils.contentEquals(file1, file2);
		} catch (IOException e) {
			return false;
		}
	}

	public static double getPoint2PixelFactor() {
		IMonitor m = Rcpl.getActualMonitor();
		if (actualMonitor != m) {
			final Text text = new Text("1234567890abcdefghijklmnopqrstABCDEFGHIJKLMNOPQRSTUVW");
			final double width = text.getLayoutBounds().getWidth();
			double widthFac = 438.97705078125 / width;
			double dpi = m.getDpi();
			point2PixelFactor = (dpi / widthFac) / 72;
			// physicalWidth = m.getCmpi();
		}
		actualMonitor = m;
		return point2PixelFactor;
	}

	public static String ColorToHexString(Color color) {

		String result = color.toString();

		try {
			result = "#" + Integer.toHexString(color.hashCode()).substring(0, 6).toUpperCase();
		} catch (Exception ex) {
			System.out.println();
		}
		return result;
	}
}
