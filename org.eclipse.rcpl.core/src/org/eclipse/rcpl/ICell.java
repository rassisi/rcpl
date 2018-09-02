package org.eclipse.rcpl;

import org.controlsfx.control.spreadsheet.SpreadsheetCell;

/**
 * @author Ramin
 *
 */
public interface ICell {

	SpreadsheetCell getSpreadsheetCell();

	int getHorizontalSpan();

	String getFormattedValue();

}
