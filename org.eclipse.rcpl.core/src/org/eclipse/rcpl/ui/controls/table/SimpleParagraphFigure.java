package org.eclipse.rcpl.ui.controls.table;

import org.eclipse.rcpl.IParagraph;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;

/**
 * @author Ramin
 *
 */
public class SimpleParagraphFigure extends RcplAbstractParagraphFigure {

	private SimpleParagraph paragraph;

	private StackPane node;

	private TextArea textField;

	private RcplTable table;

	public SimpleParagraphFigure(SimpleParagraph paragraph) {
		this.paragraph = paragraph;
		this.node = new StackPane();
		textField = new TextArea(paragraph.getText());
		textField.setPrefWidth(10000);
		textField.widthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				for (Node n : textField.getChildrenUnmodifiable()) {
					if (n instanceof ScrollPane) {
						ScrollPane sp = (ScrollPane) n;
						sp.setVbarPolicy(ScrollBarPolicy.NEVER);
						sp.setHbarPolicy(ScrollBarPolicy.NEVER);
						Region n2 = (Region) sp.getContent();

						double h = n2.getHeight();
						node.setPrefHeight(h);
						textField.setPrefHeight(h);
						if (table != null) {
							int row = getRow(node);
							int column = getColumn(node);
							if (table.isAutoRowSize()) {
								if (table.getRowHeight(row) < h) {
									table.setRowHeight(row, h);
								}
							}

							if (!table.isWrap(row, column)) {
								int spanX = 5; // table.getColumnSpan(row, column);
								table.setColumnSpan(row, column, spanX);
							}

						}

						break;
					}
				}

			}
		});

		textField.setPrefHeight(25);
		this.node.setPrefHeight(textField.getPrefHeight());
		this.node.getChildren().add(textField);
	}

	int getRow(Node n) {
		Parent p = node.getParent();
		return ((int[]) p.getUserData())[0];
	}

	int getColumn(Node n) {
		Parent p = node.getParent();
		return ((int[]) p.getUserData())[1];
	}

	@Override
	public double getWidth() {
		return node.getWidth();
	}

	@Override
	public double getHeight() {
		double h = node.getLayoutBounds().getHeight();
		if (h == 0) {
			h = node.getPrefHeight();
		}
		return h;
	}

	@Override
	public Point2D getCenter() {
		return null;
	}

	@Override
	public IParagraph getLayoutObject() {
		return paragraph;
	}

	@Override
	public Pane getNode() {
		return node;
	}

	@Override
	public void activate() {
		textField.requestFocus();
	}

	@Override
	public void setWrap(boolean wrap) {
		textField.setWrapText(wrap);
	}

	@Override
	public void setTable(RcplTable table) {
		this.table = table;
	}

	@Override
	public RcplTable getTable() {
		return table;
	}
}
