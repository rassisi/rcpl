package org.eclipse.rcpl.components;

import org.eclipse.rcpl.ILayoutFigure;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

/**
 * @author Ramin
 *
 */
public class RcplResizablePane extends StackPane {

	private RcplResizableAndDraggableStackPaneSelectionModel selectionModel;

	private ILayoutFigure layoutFigure;

	private class DragContext {
		double x;
		double y;
	}

	public RcplResizablePane(ILayoutFigure layoutFigure, Group selectionLayer) {
		super();
		this.layoutFigure = layoutFigure;
		selectionModel = new RcplResizableAndDraggableStackPaneSelectionModel(selectionLayer);
		makeDraggable(this);
	}

	public double computePrefHeight(double arg0) {
		return super.computePrefHeight(arg0);
	}

	public void clear() {
		selectionModel.clear();
	}

	public void makeDraggable(final Node node) {

		final DragContext dragDelta = new DragContext();

		node.setOnMousePressed(mouseEvent -> {
			selectionModel.clear();
			selectionModel.add(node);
			dragDelta.x = node.getTranslateX() - mouseEvent.getSceneX();
			dragDelta.y = node.getTranslateY() - mouseEvent.getSceneY();
			mouseEvent.consume();
		});

		node.setOnMouseDragged(mouseEvent -> {
			node.setTranslateX(mouseEvent.getSceneX() + dragDelta.x);
			node.setTranslateY(mouseEvent.getSceneY() + dragDelta.y);
		});

		node.setOnMouseReleased(mouseEvent -> {
			double x = node.getTranslateX();
			double y = node.getTranslateY();
			node.relocate(node.getLayoutX() + x, node.getLayoutY() + y);
			node.setTranslateX(0);
			node.setTranslateY(0);
		});
	}

}
