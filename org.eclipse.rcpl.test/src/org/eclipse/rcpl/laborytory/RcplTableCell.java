package org.eclipse.rcpl.laborytory;

import org.eclipse.rcpl.IParagraph;

import javafx.scene.Node;
import javafx.scene.control.TableCell;
import javafx.scene.layout.VBox;

/**
 * @author Ramin
 *
 */
public class RcplTableCell extends TableCell<RcplParagraphRow, IParagraph> {

	private VBox excelBox;

	public RcplTableCell() {
		excelBox = new VBox();
		excelBox.setStyle("-fx-border-style: solid;-fx-border-color: red;-fx-border-width: 1.0;");
	}

	@Override
	protected void updateItem(IParagraph item, boolean empty) {
		excelBox.getChildren().clear();
		if (item != null) {
			double h = item.getHeightPixel();
			excelBox.setPrefWidth(item.getWidthPixel());
			excelBox.setPrefHeight(h);
			Node n = item.getLayoutFigure().getNode();
			excelBox.getChildren().add(n);
		}
		setGraphic(excelBox);
	}

}
