package org.eclipse.rcpl.internal.dictionary.impl;

import java.util.Locale;

import org.eclipse.rcpl.IDictionary;
import org.eclipse.rcpl.ILocalable;
import org.eclipse.rcpl.Rcpl;

/**
 * @author Ramin
 *
 */
public class RcplDictionary implements IDictionary {

	private Locale locale = Locale.US;

	@Override
	public String get(String text) {

		if (Locale.GERMAN == locale) {
			if ("Bold".equals(text)) {
				return "Fett";
			}
		}

		return text;
	}

	@Override
	public void setLocale(Locale locale) {
		this.locale = locale;
		for (final ILocalable l : Rcpl.getLocalables()) {
			l.updateLocale();
		}
	}

	@Override
	public Locale getLocale() {
		return locale;
	}

}
