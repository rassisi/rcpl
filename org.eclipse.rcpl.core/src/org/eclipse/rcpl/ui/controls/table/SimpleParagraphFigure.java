package org.eclipse.rcpl.ui.controls.table;

import org.eclipse.rcpl.IParagraph;

import javafx.geometry.Point2D;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * @author Ramin
 *
 */
public class SimpleParagraphFigure extends RcplAbstractParagraphFigure {

	private SimpleParagraph paragraph;

	private StackPane node;

	private TextField textField;

	public SimpleParagraphFigure(SimpleParagraph paragraph) {
		this.paragraph = paragraph;
		this.node = new StackPane();

		textField = new TextField(paragraph.getText());
		textField.setPrefHeight(25);
		this.node.setPrefHeight(textField.getPrefHeight());
		this.node.getChildren().add(textField);
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
}
