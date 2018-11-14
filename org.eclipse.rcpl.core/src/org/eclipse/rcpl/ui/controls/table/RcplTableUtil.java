package org.eclipse.rcpl.ui.controls.table;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

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

	public static Node getNode(final int row, final int column, GridPane gridPane) {
		Node result = null;
		try {
			ObservableList<Node> childrens = gridPane.getChildren();
			for (Node node : childrens) {
				if (GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == column) {
					result = node;
					break;
				}
			}
		} catch (Exception ex) {
		}
		return result;
	}
}
