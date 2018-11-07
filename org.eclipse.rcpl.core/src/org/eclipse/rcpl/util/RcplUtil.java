package org.eclipse.rcpl.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRelation;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.eclipse.rcpl.EnMeasurementUnits;
import org.eclipse.rcpl.EnPageSize;
import org.eclipse.rcpl.IColorProvider;
import org.eclipse.rcpl.ILayoutObject;
import org.eclipse.rcpl.IMonitor;
import org.eclipse.rcpl.Rcpl;
import org.eclipse.rcpl.RcplCountry;
import org.eclipse.rcpl.internal.config.RcplConfig;
import org.eclipse.rcpl.libs.util.AFile;
import org.eclipse.rcpl.libs.util.AUtil;
import org.eclipse.rcpl.libs.util.StringOutputStream;
import org.eclipse.rcpl.model.RcplModel;
import org.eclipse.rcpl.model.client.RcplSession;
import org.eclipse.rcpl.model_2_0_0.rcpl.Tool;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeStyleSheet;
import org.openxmlformats.schemas.drawingml.x2006.main.ThemeDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFontsList;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.FontsDocument;
import org.w3c.dom.Node;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @author Ramin
 *
 */
public class RcplUtil {

	private static double point2PixelFactor = -1;

//	private static double physicalWidth = -1;

	private static IMonitor actualMonitor;

	protected static final PackageAccess defaultPackageAccess = PackageAccess.READ_WRITE;

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
		InputStream is = Rcpl.class.getResourceAsStream(Rcpl.get().getDefaultTemplatesPath() + templateResourceName); // $NON-NLS-1$
		return is;
	}

	public static InputStream loadCssInputStream(String cssName) {
		InputStream is = Rcpl.class.getResourceAsStream(Rcpl.get().getDefaultCssPath() + cssName); // $NON-NLS-1$
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

	public static String loadCssAsString(String cssResourceName) {
		InputStream is = loadCssInputStream(cssResourceName);
		return AUtil.convertStreamToString(is);
	}

	/**
	 * @param templateResourceName
	 * @return
	 */
	public static File loadTemplateDocumentToFile(String name, boolean escapeHtml) {

		String path = Rcpl.get().getDefaultTemplatesPath() + name;
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
		InputStream is = AUtil.class.getResourceAsStream(Rcpl.get().getDefaultTemplatesPath() + name); // $NON-NLS-1$
		try {
			AUtil.copyInputStream(is, outFile, escapeHtml);
		} catch (IOException e) {
			// LOGGER.error("", e); //$NON-NLS-1$
		}
	}

	public static String loadTemplateHTMLDocument(String name, HashMap<String, String> wordReplacements,
			boolean escapeHtml) {

		InputStream is = AUtil.class.getResourceAsStream(Rcpl.get().getDefaultTemplatesPath() + name); // $NON-NLS-1$

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
		File outFile = createCacheFile(fileName);
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

	public static final void copyFromCacheToFile(String fileName, File output) {
		File cacheFile = createCacheFile(fileName);
		try {
			FileInputStream fis = new FileInputStream(cacheFile);
			output.getParentFile().mkdirs();
			AUtil.copyInputStream(fis, output);
		} catch (FileNotFoundException e) {
			return;
		} catch (IOException e) {
			return;
		}
	}

	public static final void copyFromFileToFile(File input, File output) {
		try {
			FileInputStream fis = new FileInputStream(input);
			output.getParentFile().mkdirs();
			AUtil.copyInputStream(fis, output);
		} catch (FileNotFoundException e) {
			return;
		} catch (IOException e) {
			return;
		}
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
		File outFile = createCacheFile(fileName);
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
		File file = createCacheFile(fileName);
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
		File file = createCacheFile(fileName);
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
		File outFile = createCacheFile(fileName);
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
//			if (RcplModel.mobileProvider != null) {
//				userLocalArea = RcplModel.mobileProvider.getApplicationDir(); // $NON-NLS-1$
//			} else {
//				userLocalArea = new File(System.getProperty("user.home"), ".rcpl"); //$NON-NLS-1$
//			}

			userLocalArea = RcplModel.getMobileProvider().getApplicationDir(); // $NON-NLS-1$

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
		if (point2PixelFactor == -1 || point2PixelFactor == 0) {
			IMonitor m = Rcpl.get().getActualMonitor();
			if (actualMonitor != m || point2PixelFactor == -1 || point2PixelFactor == 0) {
				final Text text = new Text("1234567890abcdefghijklmnopqrstABCDEFGHIJKLMNOPQRSTUVW");
				final double width = text.getLayoutBounds().getWidth();
				double widthFac = 438.97705078125 / width;
				double dpi = m.getDpi();
				point2PixelFactor = (dpi / widthFac) / 72;
				// physicalWidth = m.getCmpi();
			}
			actualMonitor = m;
		}
		return point2PixelFactor;
	}

	public static String ColorToHexString(Color color) {
		String result = color.toString();
		try {
			result = "#" + to2DigitsHex(color.getRed() * 255) + to2DigitsHex(color.getGreen() * 255)
					+ to2DigitsHex(color.getBlue() * 255);
		} catch (Exception ex) {
			System.out.println();
		}
		return result;
	}

	public static String to2DigitsHex(double col) {
		String result = Integer.toHexString((int) col);
		if (result.length() < 2) {
			result = "0" + result;
		}
		return result;
	}

	/**
	 * @param resourceName
	 * @param deleteIfNotEqualContent
	 * @return
	 */
	public static boolean compareFileWithResource(String resourceName, boolean deleteIfNotEqualContent) {
		File file = getCachedFile(resourceName);
		File tempFile;
		try {
			tempFile = File.createTempFile("rcpl_temp_", "temp");
			AUtil.copyInputStream(RcplModel.modelClass.getResourceAsStream(resourceName), tempFile);
		} catch (Throwable ex) {
			RcplModel.logError(ex);
			return false;
		}
		boolean isEqual = false;

		if (file.exists()) {
			try {
				isEqual = FileUtils.contentEquals(tempFile, file);
			} catch (IOException e) {
			}
			if (!isEqual && deleteIfNotEqualContent) {
				file.delete();
			}
		}
		return isEqual;
	}

	public static boolean copyResourceToUserDir(Class<?> cl, String fileName) {
		String userDir = RcplModel.getMobileProvider().getApplicationDir().getAbsolutePath();
		return copyResourceToFile(cl, fileName, new File(userDir, fileName).getAbsolutePath());
	}

	/**
	 * @param pathToResource
	 * @param pathToFile
	 * @return
	 */
	public static boolean copyResourceToFile(Class<?> cl, String pathToResource, String pathToFile) {
		InputStream stream = cl.getResourceAsStream(pathToResource);
		if (stream == null) {
			RcplModel.log(stream, "InputStream to " + pathToResource + " is null");
			return false;
		}
		OutputStream resStreamOut = null;
		int readBytes;
		File outFile = new File(pathToFile);
		outFile.getParentFile().mkdirs();
		byte[] buffer = new byte[4096];
		try {
			resStreamOut = new FileOutputStream(new File(pathToFile));
			while ((readBytes = stream.read(buffer)) > 0) {
				resStreamOut.write(buffer, 0, readBytes);
			}
		} catch (Throwable e1) {
			RcplModel.logError(e1);
		} finally {
			try {
				stream.close();
				resStreamOut.close();
			} catch (IOException e) {
				RcplModel.logError(e);
				return false;
			} catch (Throwable e) {
				RcplModel.logError(e);
			}
		}
		return true;
	}

	public static boolean showQuestion(String title, String message) {
		Alert dlg = new Alert(AlertType.CONFIRMATION, "", ButtonType.OK, ButtonType.NO, ButtonType.CANCEL);
		dlg.initModality(Modality.APPLICATION_MODAL);
		dlg.initOwner(null);
		dlg.setTitle(title);
		dlg.getDialogPane().setContentText(message);

		dlg.setX(Rcpl.UIC().getApplicationStarter().getRcplApplicationProvider().getLoginWindowX());
		dlg.setY(Rcpl.UIC().getApplicationStarter().getRcplApplicationProvider().getLoginWindowY());

//		dlg.getDialogPane().getButtonTypes().remove(ButtonType.CANCEL);
//		configureSampleDialog(dlg, optionalMasthead);
		dlg.showAndWait();
		ButtonType result = dlg.getResult();
		dlg.close();
		return ButtonType.OK.equals(result);
	}

	public static File openDocumentFileDialog(String workingDir, boolean word, boolean spreadsheet,
			boolean presentation, boolean all) {
		return openDocumentWithFileDialog(workingDir, word, spreadsheet, presentation, all, false);
	}

	public static File openSaveFileDialog(String workingDir, boolean word, boolean spreadsheet, boolean presentation,
			boolean all) {
		return openDocumentWithFileDialog(workingDir, word, spreadsheet, presentation, all, true);
	}

	private static File openDocumentWithFileDialog(String workingDir, boolean word, boolean spreadsheet,
			boolean presentation, boolean all, boolean save) {
		final FileChooser fileChooser = new FileChooser();

		if (workingDir != null && workingDir.length() > 0) {
			fileChooser.setInitialDirectory(new File(workingDir));
		}

		if (word) {
			FileChooser.ExtensionFilter wordExtFilter = new FileChooser.ExtensionFilter("Word Documents", "*.docx");
			fileChooser.getExtensionFilters().add(wordExtFilter);
			fileChooser.setSelectedExtensionFilter(wordExtFilter);
		}
		if (spreadsheet) {
			FileChooser.ExtensionFilter spreadsheetExtFilter = new FileChooser.ExtensionFilter("Spreadsheets",
					"*.xlsx");
			fileChooser.getExtensionFilters().add(spreadsheetExtFilter);
			fileChooser.setSelectedExtensionFilter(spreadsheetExtFilter);
		}
		if (presentation) {
			FileChooser.ExtensionFilter presentationExtFilter = new FileChooser.ExtensionFilter("Presentions",
					"*.pptx");
			fileChooser.getExtensionFilters().add(presentationExtFilter);
			fileChooser.setSelectedExtensionFilter(presentationExtFilter);
		}
		if (word && spreadsheet && presentation) {
			FileChooser.ExtensionFilter officeExtFilter = new FileChooser.ExtensionFilter("Office Documents", "*.docx",
					"*.xlsx", "*.pptx");
			fileChooser.getExtensionFilters().add(officeExtFilter);
			fileChooser.setSelectedExtensionFilter(officeExtFilter);
		}
		if (all) {
			FileChooser.ExtensionFilter allExtFilter = new FileChooser.ExtensionFilter("All", "*.*");
			fileChooser.getExtensionFilters().add(allExtFilter);
		}

		try {
//			File dir = RcplSession.getDefault().getSystemPreferences().getFile(RcplKey.FILE_DIALOG_DIR);
//			if (dir != null && dir.exists()) {
//				fileChooser.setInitialDirectory(dir);
//			}
		} catch (Exception ex) {
			RcplModel.logError(ex);
		}
		File file;

		if (save) {
			file = fileChooser.showSaveDialog(getStage());
		} else {
			file = fileChooser.showOpenDialog(getStage());
		}
		RcplSession.getDefault().commit();
		return file;
	}

	public static Stage getStage() {
		return Rcpl.UIC().getApplicationStarter().getRcplApplicationProvider().getPrimaryStage();
	}

	public static boolean isControlCharacter(String c) {
		byte[] ba = c.getBytes();
		return c.equals("\r") || c.equals("\b") || c.equals("\n") || ba[0] == 127; // 127 = DEL
	}

	public static void waitForDone(boolean[] done) {
		while (!done[0]) {
			sleep(10);
		}
	}

	private static boolean matches(Color c1, Color c2, String name) {

		double diffRed = Math.abs(c1.getRed() - c2.getRed());
		double diffGreen = Math.abs(c1.getGreen() - c2.getGreen());
		double diffBlue = Math.abs(c1.getBlue() - c2.getBlue());
		double totalDiff = diffRed + diffGreen + diffBlue;
		boolean result = totalDiff == 0.0;
		colorMap.put(totalDiff, new ColorName(c2, name));
		return result;
	}

	private static Map<Double, ColorName> colorMap = new HashMap<Double, ColorName>();
	private static SortedMap<Double, ColorName> sortedMap;

	public static class ColorName {

		public Color col;
		public String name;

		public ColorName(Color col, String name) {
			super();
			this.col = col;
			this.name = name;
		}
	}

	public static ColorName findColor(Color color) {

		colorMap.clear();

		if (matches(color, Color.ALICEBLUE, "ALICEBLUE"))
			;
		else if (matches(color, Color.ANTIQUEWHITE, "ANTIQUEWHITE"))
			;
		else if (matches(color, Color.AQUA, "AQUA"))
			;
		else if (matches(color, Color.AQUAMARINE, "AQUAMARINE"))
			;
		else if (matches(color, Color.AZURE, "AZURE"))
			;
		else if (matches(color, Color.BEIGE, "BEIGE"))
			;
		else if (matches(color, Color.BISQUE, "BISQUE"))
			;
		else if (matches(color, Color.BLACK, "BLACK"))
			;
		else if (matches(color, Color.BLANCHEDALMOND, "BLANCHEDALMOND"))
			;
		else if (matches(color, Color.BLUE, "BLUE"))
			;
		else if (matches(color, Color.BLUEVIOLET, "BLUEVIOLET"))
			;
		else if (matches(color, Color.BROWN, "BROWN"))
			;
		else if (matches(color, Color.BURLYWOOD, "BURLYWOOD"))
			;
		else if (matches(color, Color.CADETBLUE, "CADETBLUE"))
			;
		else if (matches(color, Color.CHARTREUSE, "CHARTREUSE"))
			;
		else if (matches(color, Color.CHOCOLATE, "CHOCOLATE"))
			;
		else if (matches(color, Color.CORAL, "CORAL"))
			;
		else if (matches(color, Color.CORNFLOWERBLUE, "CORNFLOWERBLUE"))
			;
		else if (matches(color, Color.CORNSILK, "CORNSILK"))
			;
		else if (matches(color, Color.CRIMSON, "CRIMSON"))
			;
		else if (matches(color, Color.CYAN, "CYAN"))
			;
		else if (matches(color, Color.DARKBLUE, "DARKBLUE"))
			;
		else if (matches(color, Color.DARKCYAN, "DARKCYAN"))
			;
		else if (matches(color, Color.DARKGOLDENROD, "DARKGOLDENROD"))
			;
		else if (matches(color, Color.DARKGRAY, "DARKGRAY"))
			;
		else if (matches(color, Color.DARKGREEN, "DARKGREEN"))
			;
		else if (matches(color, Color.DARKGREY, "DARKGREY"))
			;
		else if (matches(color, Color.DARKKHAKI, "DARKKHAKI"))
			;
		else if (matches(color, Color.DARKMAGENTA, "DARKMAGENTA"))
			;
		else if (matches(color, Color.DARKOLIVEGREEN, "DARKOLIVEGREEN"))
			;
		else if (matches(color, Color.DARKORANGE, "DARKORANGE"))
			;
		else if (matches(color, Color.DARKORCHID, "DARKORCHID"))
			;
		else if (matches(color, Color.DARKRED, "DARKRED"))
			;
		else if (matches(color, Color.DARKSALMON, "DARKSALMON"))
			;
		else if (matches(color, Color.DARKSEAGREEN, "DARKSEAGREEN"))
			;
		else if (matches(color, Color.DARKSLATEBLUE, "DARKSEAGREEN"))
			;
		else if (matches(color, Color.DARKSLATEGRAY, "DARKSLATEGRAY"))
			;
		else if (matches(color, Color.DARKSLATEGREY, "DARKSLATEGREY"))
			;
		else if (matches(color, Color.DARKTURQUOISE, "DARKTURQUOISE"))
			;
		else if (matches(color, Color.DARKVIOLET, "DARKVIOLET"))
			;
		else if (matches(color, Color.DEEPPINK, "DEEPPINK"))
			;
		else if (matches(color, Color.DEEPSKYBLUE, "DEEPSKYBLUE"))
			;
		else if (matches(color, Color.DIMGRAY, "DIMGRAY"))
			;
		else if (matches(color, Color.DIMGREY, "DIMGREY"))
			;
		else if (matches(color, Color.DODGERBLUE, "DODGERBLUE"))
			;
		else if (matches(color, Color.FIREBRICK, "FIREBRICK"))
			;
		else if (matches(color, Color.FLORALWHITE, "FLORALWHITE"))
			;
		else if (matches(color, Color.FORESTGREEN, "FORESTGREEN"))
			;
		else if (matches(color, Color.FUCHSIA, "FUCHSIA"))
			;
		else if (matches(color, Color.GAINSBORO, "GAINSBORO"))
			;
		else if (matches(color, Color.GHOSTWHITE, "GHOSTWHITE"))
			;
		else if (matches(color, Color.GOLD, "GOLD"))
			;
		else if (matches(color, Color.GOLDENROD, "GOLDENROD"))
			;
		else if (matches(color, Color.GRAY, "GRAY"))
			;
		else if (matches(color, Color.GREEN, "GREEN"))
			;
		else if (matches(color, Color.GREENYELLOW, "GREENYELLOW"))
			;
		else if (matches(color, Color.GREY, "GREY"))
			;
		else if (matches(color, Color.HONEYDEW, "HONEYDEW"))
			;
		else if (matches(color, Color.HOTPINK, "HOTPINK"))
			;
		else if (matches(color, Color.INDIANRED, "INDIANRED"))
			;
		else if (matches(color, Color.INDIGO, "INDIGO"))
			;
		else if (matches(color, Color.IVORY, "IVORY"))
			;
		else if (matches(color, Color.KHAKI, "KHAKI"))
			;
		else if (matches(color, Color.LAVENDER, "LAVENDER"))
			;
		else if (matches(color, Color.LAVENDERBLUSH, "LAVENDERBLUSH"))
			;
		else if (matches(color, Color.LAWNGREEN, "LAWNGREEN"))
			;
		else if (matches(color, Color.LIGHTBLUE, "LIGHTBLUE"))
			;
		else if (matches(color, Color.LIGHTCORAL, "LIGHTCORAL"))
			;
		else if (matches(color, Color.LIGHTCYAN, "LIGHTCYAN"))
			;
		else if (matches(color, Color.LIGHTGOLDENRODYELLOW, "LIGHTGOLDENRODYELLOW"))
			;
		else if (matches(color, Color.LIGHTGRAY, "LIGHTGRAY"))
			;
		else if (matches(color, Color.LIGHTGREEN, "LIGHTGREEN"))
			;
		else if (matches(color, Color.LIGHTGREY, "LIGHTGREY"))
			;
		else if (matches(color, Color.LIGHTPINK, "LIGHTPINK"))
			;
		else if (matches(color, Color.LIGHTSALMON, "LIGHTSALMON"))
			;
		else if (matches(color, Color.LIGHTSEAGREEN, "LIGHTSEAGREEN"))
			;
		else if (matches(color, Color.LIGHTSKYBLUE, "LIGHTSKYBLUE"))
			;
		else if (matches(color, Color.LIGHTSLATEGRAY, "LIGHTSLATEGRAY"))
			;
		else if (matches(color, Color.LIGHTSLATEGREY, "LIGHTSLATEGREY"))
			;
		else if (matches(color, Color.LIGHTYELLOW, "LIGHTYELLOW"))
			;
		else if (matches(color, Color.LIME, "LIME"))
			;
		else if (matches(color, Color.LIMEGREEN, "LIMEGREEN"))
			;
		else if (matches(color, Color.LINEN, "LINEN"))
			;
		else if (matches(color, Color.MAGENTA, "MAGENTA"))
			;
		else if (matches(color, Color.MAROON, "MAROON"))
			;
		else if (matches(color, Color.MEDIUMAQUAMARINE, "MEDIUMAQUAMARINE"))
			;
		else if (matches(color, Color.MEDIUMBLUE, "MEDIUMBLUE"))
			;
		else if (matches(color, Color.MEDIUMORCHID, "MEDIUMORCHID"))
			;
		else if (matches(color, Color.MEDIUMPURPLE, "MEDIUMPURPLE"))
			;
		else if (matches(color, Color.MEDIUMSEAGREEN, "MEDIUMSEAGREEN"))
			;
		else if (matches(color, Color.MEDIUMSLATEBLUE, "MEDIUMSLATEBLUE"))
			;
		else if (matches(color, Color.MEDIUMSPRINGGREEN, "MEDIUMSPRINGGREEN"))
			;
		else if (matches(color, Color.MEDIUMTURQUOISE, "MEDIUMTURQUOISE"))
			;
		else if (matches(color, Color.MEDIUMVIOLETRED, "MEDIUMVIOLETRED"))
			;
		else if (matches(color, Color.MIDNIGHTBLUE, "MIDNIGHTBLUE"))
			;
		else if (matches(color, Color.MINTCREAM, "MINTCREAM"))
			;
		else if (matches(color, Color.MISTYROSE, "MISTYROSE"))
			;
		else if (matches(color, Color.MOCCASIN, "MOCCASIN"))
			;
		else if (matches(color, Color.NAVAJOWHITE, "NAVAJOWHITE"))
			;
		else if (matches(color, Color.NAVY, "NAVY"))
			;
		else if (matches(color, Color.OLDLACE, "OLDLACE"))
			;
		else if (matches(color, Color.OLIVE, "OLIVE"))
			;
		else if (matches(color, Color.OLIVEDRAB, "OLIVEDRAB"))
			;
		else if (matches(color, Color.ORANGE, "ORANGE"))
			;
		else if (matches(color, Color.ORANGERED, "ORANGERED"))
			;
		else if (matches(color, Color.ORCHID, "ORCHID"))
			;
		else if (matches(color, Color.PALEGOLDENROD, "PALEGOLDENROD"))
			;
		else if (matches(color, Color.PALEGREEN, "PALEGREEN"))
			;
		else if (matches(color, Color.PALETURQUOISE, "PALETURQUOISE"))
			;
		else if (matches(color, Color.PALEVIOLETRED, "PALEVIOLETRED"))
			;
		else if (matches(color, Color.PAPAYAWHIP, "PAPAYAWHIP"))
			;
		else if (matches(color, Color.PEACHPUFF, "PEACHPUFF"))
			;
		else if (matches(color, Color.PERU, "PERU"))
			;
		else if (matches(color, Color.PINK, "PINK"))
			;
		else if (matches(color, Color.PLUM, "PLUM"))
			;
		else if (matches(color, Color.POWDERBLUE, "POWDERBLUE"))
			;
		else if (matches(color, Color.PURPLE, "PURPLE"))
			;
		else if (matches(color, Color.RED, "RED"))
			;
		else if (matches(color, Color.ROSYBROWN, "ROSYBROWN"))
			;
		else if (matches(color, Color.ROYALBLUE, "ROYALBLUE"))
			;
		else if (matches(color, Color.SADDLEBROWN, "SADDLEBROWN"))
			;
		else if (matches(color, Color.SALMON, "SALMON"))
			;
		else if (matches(color, Color.SANDYBROWN, "SANDYBROWN"))
			;
		else if (matches(color, Color.SEAGREEN, "SEAGREEN"))
			;
		else if (matches(color, Color.SEASHELL, "SEASHELL"))
			;
		else if (matches(color, Color.SIENNA, "SIENNA"))
			;
		else if (matches(color, Color.SILVER, "SILVER"))
			;
		else if (matches(color, Color.SKYBLUE, "SKYBLUE"))
			;
		else if (matches(color, Color.SLATEBLUE, "SLATEBLUE"))
			;
		else if (matches(color, Color.SLATEGRAY, "SLATEGRAY"))
			;
		else if (matches(color, Color.SLATEGREY, "SLATEGREY"))
			;
		else if (matches(color, Color.SNOW, "SNOW"))
			;
		else if (matches(color, Color.SPRINGGREEN, "SPRINGGREEN"))
			;
		else if (matches(color, Color.STEELBLUE, "STEELBLUE"))
			;
		else if (matches(color, Color.TAN, "TAN"))
			;
		else if (matches(color, Color.TEAL, "TEAL"))
			;
		else if (matches(color, Color.THISTLE, "THISTLE"))
			;
		else if (matches(color, Color.TOMATO, "TOMATO"))
			;
		else if (matches(color, Color.TRANSPARENT, "TRANSPARENT"))
			;
		else if (matches(color, Color.TURQUOISE, "TURQUOISE"))
			;
		else if (matches(color, Color.VIOLET, "VIOLET"))
			;
		else if (matches(color, Color.WHEAT, "WHEAT"))
			;
		else if (matches(color, Color.WHITE, "WHITE"))
			;
		else if (matches(color, Color.WHITESMOKE, "WHITESMOKE"))
			;
		else if (matches(color, Color.YELLOW, "YELLOW"))
			;
		else if (matches(color, Color.YELLOWGREEN, "YELLOWGREEN"))
			;

		sortedMap = new TreeMap<Double, ColorName>(colorMap);

		ColorName result = sortedMap.get(sortedMap.firstKey());

		System.out.println(result.name);

		return result;
	}

	public static File createCacheFile(String fileName) {
		return new File(getUserLocalCacheDir(), fileName);
	}

	public static String loadStringFromCssResource(String cssName) {
		return RcplUtil.loadCssAsString(cssName);
	}

	public static File saveStringToFileInCache(String fileName, String s) {
		File file = createCacheFile(fileName);
		AFile.saveFile(file, s);
		return file;
	}

	public static Color getFXColor(java.awt.Color awtColor) {
		int r = awtColor.getRed();
		int g = awtColor.getGreen();
		int b = awtColor.getBlue();
		int a = awtColor.getAlpha();
		double opacity = a / 255.0;
		return Color.rgb(r, g, b, opacity);
	}

	public static java.awt.Color getAWTColor(Color color) {
		double r = color.getRed() * 255.0;
		double g = color.getGreen() * 255.0;
		double b = color.getBlue() * 255.0;
//		double a = color.getOpacity() * 255.0;
		return new java.awt.Color((int) r, (int) g, (int) b); // , (float) a);
	}

	public static int getTokenCount(String input, String token) {
		int pos = 0;
		int count = 0;
		while (pos != -1) {
			pos = input.indexOf(token, pos);
			if (pos != -1) {
				count++;
				pos += token.length();
			}
		}
		return count;
	}

	public static String maxString(String s, int max) {
		return s.substring(0, Math.min(s.length(), max));
	}

	public static String loadHtml(String urlString) {
		URL url;
		String str = null;
		try {
			url = new URL(urlString);
			URLConnection con = url.openConnection();
			Pattern p = Pattern.compile("text/html;\\s+charset=([^\\s]+)\\s*");
			Matcher m = p.matcher(con.getContentType());
			/*
			 * If Content-Type doesn't match this pre-conception, choose default and hope
			 * for the best.
			 */
			String charset = m.matches() ? m.group(1) : "ISO-8859-1";
			Reader r = new InputStreamReader(con.getInputStream(), charset);
			StringBuilder buf = new StringBuilder();
			while (true) {
				int ch = r.read();
				if (ch < 0)
					break;
				buf.append((char) ch);
			}
			str = buf.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

	public static List<String> getListFromDelimiterSeparatedList(String str, String delimiter) {
		if (str == null) {
			return new ArrayList<String>();
		}
		List<String> items = Arrays.asList(str.split("\\s*" + delimiter + "\\s*"));
		return items;
	}

	public static File saveToFile(Image image, File outputFile, String fileType) {
		String filePath = outputFile.getAbsolutePath();
		if (!filePath.endsWith(fileType)) {
			filePath += "." + fileType;
			outputFile = new File(filePath);
		}
		BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
		if (bImage != null) {
			try {
				ImageIO.write(bImage, fileType, outputFile);
			} catch (IOException e) {
				Rcpl.get().printErrorln("", e);
			}
		}
		return outputFile;
	}

	public static String getFileExtension(File file) {
		return FilenameUtils.getExtension(file.getName());
	}

	public static String findAndReplaceAll(String pattern, String replaceWith, String inputString) {
		Pattern patt = Pattern.compile(pattern);
		Matcher matcher = patt.matcher(inputString);
		return matcher.replaceAll(replaceWith);
	}

	/**
	 * Get the PackagePart that is the target of a relationship.
	 * 
	 * @param rel The relationship
	 * @param pkg The package to fetch from
	 * @return The target part
	 * @throws InvalidFormatException
	 */
	public static PackagePart getTargetPart(OPCPackage pkg, PackageRelationship rel) throws InvalidFormatException {
		PackagePartName relName = PackagingURIHelper.createPartName(rel.getTargetURI());
		PackagePart part = pkg.getPart(relName);
		if (part == null) {
			throw new IllegalArgumentException("No part found for relationship " + rel); //$NON-NLS-1$
		}
		return part;
	}

	/**
	 * @param xml
	 * @param rel
	 * @return
	 * @throws InvalidFormatException
	 */
	public static PackagePart getTargetPart(XWPFDocument xml, PackageRelationship rel) throws InvalidFormatException {
		return getTargetPart(xml.getPackage(), rel);
	}

	public static PackagePart[] getRelatedByType(XWPFDocument xml, String contentType) throws InvalidFormatException {
		PackageRelationshipCollection partsC = xml.getPackagePart().getRelationshipsByType(contentType);

		PackagePart[] parts = new PackagePart[partsC.size()];
		int count = 0;
		for (PackageRelationship rel : partsC) {
			parts[count] = getTargetPart(xml, rel);
			count++;
		}
		return parts;
	}

	/**
	 * Returns the styles object used
	 */
	public static CTOfficeStyleSheet getThemes(XWPFDocument xml) throws XmlException, IOException {
		PackagePart[] parts;
		try {
			// parts = getRelatedByType(xml, XWPFRelation.STYLES.getRelation());

			String s = "http://schemas.openxmlformats.org/officeDocument/2006/relationships/theme"; //$NON-NLS-1$
			parts = getRelatedByType(xml, s);

		} catch (InvalidFormatException e) {
			throw new IllegalStateException(e);
		}
		if (parts.length != 1) {
			throw new IllegalStateException("" + parts.length); //$NON-NLS-1$
		}

		ThemeDocument themeDocument = ThemeDocument.Factory.parse(parts[0].getInputStream());
		CTOfficeStyleSheet theme = themeDocument.getTheme();

		return theme;
	}

//	/**
//	 * Returns the styles object used
//	 */
//	public static CTOfficeStyleSheet getThemes(XWPFDocument xml) throws XmlException, IOException {
//		PackagePart[] parts;
//		try {
//			// parts = getRelatedByType(xml, XWPFRelation.STYLES.getRelation());
//
//			String s = "http://schemas.openxmlformats.org/officeDocument/2006/relationships/theme"; //$NON-NLS-1$
//			parts = getRelatedByType(xml, s);
//
//		} catch (InvalidFormatException e) {
//			throw new IllegalStateException(e);
//		}
//		if (parts.length != 1) {
//			throw new IllegalStateException("" + parts.length); //$NON-NLS-1$
//		}
//
//		ThemeDocument themeDocument = ThemeDocument.Factory.parse(parts[0].getInputStream());
//		CTOfficeStyleSheet theme = themeDocument.getTheme();
//
//		return theme;
//	}

	/**
	 * Returns the styles object used
	 */
	public static CTFontsList getFontTable(XWPFDocument xml) throws XmlException, IOException {
		PackagePart[] parts;
		try {
			parts = getRelatedByType(xml, XWPFRelation.FONT_TABLE.getRelation());
		} catch (InvalidFormatException e) {
			throw new IllegalStateException(e);
		}
		if (parts.length != 1) {
			throw new IllegalStateException("" + parts.length); //$NON-NLS-1$
		}

		FontsDocument fd = FontsDocument.Factory.parse(parts[0].getInputStream());
		return fd.getFonts();
	}

}
