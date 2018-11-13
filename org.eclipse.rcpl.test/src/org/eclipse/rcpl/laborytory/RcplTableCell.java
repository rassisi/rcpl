package org.eclipse.rcpl.laborytory;

import org.eclipse.rcpl.ICellable;
import org.eclipse.rcpl.IParagraph;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

/**
 * @author Ramin
 *
 */
public class RcplTableCell extends TableCell<RcplCellRow, ICellable> {

	private VBox excelBox;

	RcplTableView tableView;

	public RcplTableCell(RcplTableView tableView) {
		excelBox = new VBox();
		this.tableView = tableView;
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
			setGraphic(excelBox);
		} else if (item instanceof ICellable) {
			ICellable cell = (ICellable) item;
			if (cell.getColumn() == 0) {
				Label l = new Label("" + (cell.getRow() + 1));
				l.setPrefWidth(40);
				l.setTextAlignment(TextAlignment.CENTER);
				l.setAlignment(Pos.CENTER);
				setAlignment(Pos.CENTER);
				excelBox.getChildren().add(l);
				if (item.getHeight() > 0) {
					excelBox.setPrefHeight(item.getHeight());
				} else {
					excelBox.setPrefHeight(20);
				}
				VBox.setVgrow(l, Priority.ALWAYS);
				excelBox.setAlignment(Pos.CENTER);
				excelBox.setStyle("-fx-background-color: lightgray;");
				setGraphic(excelBox);
				setGraphicTextGap(0);
			}
		}

	}

}
