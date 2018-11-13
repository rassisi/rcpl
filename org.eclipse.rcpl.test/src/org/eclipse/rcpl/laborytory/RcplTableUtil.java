package org.eclipse.rcpl.laborytory;

/**
 * @author Ramin
 *
 */
public class RcplTableUtil {

	public static String calculateColumnName(int number) {
		String letter = "";
		while (number >= 0) {
			final int remainder = number % 26;
			letter = (char) (remainder + 'A') + letter;
			number = number / 26 - 1;
		}

		return letter;
	}
}
