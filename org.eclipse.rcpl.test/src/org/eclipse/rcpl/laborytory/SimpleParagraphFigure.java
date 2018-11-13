package org.eclipse.rcpl.laborytory;

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

	public SimpleParagraphFigure(SimpleParagraph paragraph) {
		this.paragraph = paragraph;
		this.node = new StackPane();
		this.node.getChildren().add(new TextField(paragraph.getText()));
	}

	@Override
	public double getWidth() {
		return node.getWidth();
	}

	@Override
	public double getHeight() {
		return node.getHeight();
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

}
