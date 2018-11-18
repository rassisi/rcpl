package org.eclipse.rcpl.internal.dictionary.impl;

import java.util.Locale;

import org.eclipse.rcpl.IDictionary;
import org.eclipse.rcpl.ILocalable;
import org.eclipse.rcpl.Rcpl;
import org.eclipse.rcpl.model.EnKeyValueFolder;
import org.eclipse.rcpl.model.client.RcplSession;

/**
 * @author Ramin
 *
 */
public class Dict implements IDictionary {

	private Locale locale = Locale.US;

	public Dict() {
	}

	public static String get(String text) {
		return INSTANCE.translate(text);
	}

	@Override
	public void setLocale(Locale locale) {
		init();
		if (this.locale != Locale.US) {
			this.locale = Locale.US;
		} else {
			this.locale = locale;
		}
		for (final ILocalable l : Rcpl.get().getLocalables()) {
			l.updateLocale();
		}
		Rcpl.UIC().getSideToolBarControl().updateLocale();
	}

	@Override
	public Locale getLocale() {
		return locale;
	}

	public void put(String us, Locale loc, String foreign) {
		RcplSession.getDefault().putValue(createFolder(us, loc), us, foreign);
	}

	@Override
	public String translate(String us) {
		if (locale == Locale.US) {
			return us;
		}
		try {
			return RcplSession.getDefault().getValue(createFolder(us, locale), us, us);
		} catch (Exception ex) {
			return us;
		}
	}

	private String createFolder(String us, Locale loc) {
		StringBuilder sb = new StringBuilder();
		sb.append(EnKeyValueFolder.DICTIONARY + "/");
		if (us.length() == 1) {
			sb.append(us.substring(0, 1));
		} else if (us.length() == 2) {
			sb.append(us.substring(0, 2));
		} else if (us.length() > 2) {
			sb.append(us.substring(0, 3));
		}
		sb.append("/" + loc.getISO3Language());
		return sb.toString();
	}

	private void init() {

		put("Bold", Locale.GERMAN, "Fett");
		put("Italic", Locale.GERMAN, "Kursiv");

		put("Show Outline", Locale.GERMAN, "Formatierung anzeigen");
		put("Show H Lineal", Locale.GERMAN, "H Lineal anzeigen");
		put("Show V Lineal", Locale.GERMAN, "V Lineal anzeigen");
		put("Equations", Locale.GERMAN, "Formeln");
		put("Symbols", Locale.GERMAN, "Symbole");
		put("Images", Locale.GERMAN, "Bilder");
		put("Shapes", Locale.GERMAN, "Formen");
		put("Tables", Locale.GERMAN, "Tabellen");
		put("Arrange", Locale.GERMAN, "Anordnen");
		put("Object Properties", Locale.GERMAN, "Objekteigenschaften");
		put("Paragraph & Font", Locale.GERMAN, "Absätze und Zeichen");

		put("Colors", Locale.GERMAN, "Farben");
		put("Page", Locale.GERMAN, "Seite");
		put("Resources", Locale.GERMAN, "Dateien");
		put("Alignment", Locale.GERMAN, "Ausrichtung");
		put("Distribution", Locale.GERMAN, "Verteilung");
		put("Foreground Color", Locale.GERMAN, "Zeichenfarbe");
		put("Background Color", Locale.GERMAN, "Hintergrundfarbe");
		put("Font", Locale.GERMAN, "Zeichen");
		put("Bold", Locale.GERMAN, "Fett");
		put("Bold", Locale.GERMAN, "Fett");
		put("Bold", Locale.GERMAN, "Fett");

	}

}
