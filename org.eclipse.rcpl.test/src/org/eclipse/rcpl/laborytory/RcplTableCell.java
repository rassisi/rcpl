package org.eclipse.rcpl.laborytory;

import org.eclipse.rcpl.ICellable;
import org.eclipse.rcpl.IParagraph;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.layout.VBox;

/**
 * @author Ramin
 *
 */
public class RcplTableCell extends TableCell<RcplCellRow, ICellable> {

	private VBox excelBox;

	public RcplTableCell() {
		excelBox = new VBox();
//		excelBox.setStyle("-fx-border-style: solid;-fx-border-color: red;-fx-border-width: 1.0;");
	}

	@Override
	protected void updateItem(ICellable item, boolean empty) {
		excelBox.getChildren().clear();
		if (item instanceof IParagraph) {
			IParagraph p = (IParagraph) item;
			double h = p.getHeightPixel();
			excelBox.setPrefWidth(p.getWidthPixel());
			excelBox.setPrefHeight(h);
			Node n = p.getLayoutFigure().getNode();
			excelBox.getChildren().add(n);
		} else if (item instanceof ICellable) {
			ICellable cell = (ICellable) item;
			Label l = new Label(cell.getRow() + " " + cell.getColumn());
			excelBox.getChildren().add(l);
		}
		setGraphic(excelBox);
	}

}
