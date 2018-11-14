package org.eclipse.rcpl.laborytory;

import org.eclipse.rcpl.IParagraph;

import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

/**
 * @author Ramin
 *
 */
public class RcplCellTable {

	private RcplTable2 table;

	private GridPane grid;

	private Node node;

	private ScrollPane scrollPane;

	public RcplCellTable(RcplTable2 table) {
		this.table = table;
		this.grid = new GridPane();
		grid.setGridLinesVisible(true);

		if (table.isSpreadsheet()) {
			scrollPane = new ScrollPane();
			scrollPane.setContent(grid);
			node = scrollPane;
		} else {
			node = grid;
		}

		node.setStyle("-fx-border-color: blue;-fx-border-width: 1;");
		for (int row = 0; row < this.table.getRowCount(); row++) {
			for (int column = 0; column < table.getColumnCount(); column++) {
				StackPane sp = new StackPane();
				sp.setPrefSize(IRcplTableConstants.DEFAULT_CELL_WIDTH, IRcplTableConstants.DEFAULT_ROW_HEIGHT);
				sp.setMinSize(IRcplTableConstants.DEFAULT_CELL_WIDTH, IRcplTableConstants.DEFAULT_ROW_HEIGHT);
				sp.setMaxSize(IRcplTableConstants.DEFAULT_CELL_WIDTH, IRcplTableConstants.DEFAULT_ROW_HEIGHT);
				grid.add(sp, column, row);
			}

		}

	}

	protected IParagraph createParagraph() {
		return null;
	}

	public Node getNode() {
		return node;
	}

	public ScrollPane getScrollPane() {
		if (table.isSpreadsheet()) {
			return (ScrollPane) node;
		}
		return null;
	}

}
