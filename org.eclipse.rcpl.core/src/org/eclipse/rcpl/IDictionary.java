package org.eclipse.rcpl;

import java.util.Locale;

import org.eclipse.rcpl.internal.dictionary.impl.Dict;

/**
 * @author Ramin
 *
 */
public interface IDictionary {

	static IDictionary INSTANCE = new Dict();

	String translate(String text);

	void setLocale(Locale locale);

	Locale getLocale();

}
