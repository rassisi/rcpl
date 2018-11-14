package org.eclipse.rcpl.laborytory;

import org.eclipse.rcpl.IParagraph;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

/**
 * @author Ramin
 *
 */
public class RcplTable2 {

	private int rowCount = 100;

	private int columnCount = 100;

	private final boolean spreadsheet;

	private RcplTableView2 tableView;

	private Pane node;

	private boolean header = false;

	private Scene scene;

	public RcplTable2(boolean spreadsheet, boolean header) {
		this.spreadsheet = spreadsheet;
		this.header = header;
		if (spreadsheet) {
			header = true;
		}
		tableView = new RcplTableView2(this);
		node = tableView;
	}

	protected IParagraph createParagraph() {
		return null;
	}

	public boolean isSpreadsheet() {
		return spreadsheet;
	}

	public void updateCss(Scene scene) {
		this.scene = scene;
		if (spreadsheet) {
			scene.getStylesheets().add(RcplTable2.class.getResource("rcpltableview_spreadsheet.css").toExternalForm());
		} else {
			scene.getStylesheets().add(RcplTable2.class.getResource("rcpltableview.css").toExternalForm());
		}

		tableView.getStyleClass().add("gridStyle_normal");
	}

	public Pane getNode() {
		return node;
	}

	public boolean hasHeader() {
		return header;
	}

	public int getRowCount() {
		return rowCount;
	}

	public int getColumnCount() {
		return columnCount;
	}

	public RcplTableView2 getTableView() {
		return tableView;
	}

}
