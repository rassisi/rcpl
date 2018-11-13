package org.eclipse.rcpl.laborytory;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

/**
 * @author Ramin
 *
 */
public class RcplTableView2 extends BorderPane {

	private RcplTable2 table;

	private GridPane headerPane;

	private GridPane cellPane;

	public RcplTableView2(RcplTable2 table) {
		this.table = table;
		if (this.table.hasHeader()) {
			headerPane = new GridPane();
			headerPane.setGridLinesVisible(true);
			setTop(headerPane);
		}
		cellPane = new GridPane();
		cellPane.setGridLinesVisible(true);

		if (table.isSpreadsheet()) {
			StackPane st = new StackPane();
			ScrollPane sp = new ScrollPane();
			st.getChildren().add(sp);
			sp.setVbarPolicy(ScrollBarPolicy.ALWAYS);
			sp.setHbarPolicy(ScrollBarPolicy.ALWAYS);
			sp.setFitToHeight(true);
			sp.setFitToWidth(true);
			sp.setContent(cellPane);
			setCenter(st);
		} else {
			setCenter(cellPane);
		}

	}

	public GridPane getHeaderPane() {
		return headerPane;
	}

	public GridPane getCellPane() {
		return cellPane;
	}

}
