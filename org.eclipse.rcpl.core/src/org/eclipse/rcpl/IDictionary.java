package org.eclipse.rcpl;

import java.util.Locale;

import org.eclipse.rcpl.internal.dictionary.impl.RcplDictionary;

/**
 * @author Ramin
 *
 */
public interface IDictionary {

	static IDictionary INSTANCE = new RcplDictionary();

	String get(String text);

	void setLocale(Locale locale);

	Locale getLocale();

}
