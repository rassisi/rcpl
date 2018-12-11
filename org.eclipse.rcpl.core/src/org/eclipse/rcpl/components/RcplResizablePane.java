package org.eclipse.rcpl.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.rcpl.ILayoutFigure;

import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

/**
 * @author Ramin
 *
 */
public class RcplResizablePane extends StackPane {

	private ILayoutFigure layoutFigure;

	private Group selectionLayer;

	private Map<Node, RcplResizableSelectionPane> map = new HashMap<Node, RcplResizableSelectionPane>();

	List<Node> selection = new ArrayList<>();

	RcplResizableSelectionPane selectionOverlay;

	private class DragContext {
		double x;
		double y;
	}

	public RcplResizablePane(ILayoutFigure layoutFigure, Group selectionLayer) {
		super();
		this.selectionLayer = selectionLayer;
		this.layoutFigure = layoutFigure;
		final DragContext dragDelta = new DragContext();

		setOnMousePressed(mouseEvent -> {
			clear();
			if (selection.contains(this))
				return;
			selectionOverlay = new RcplResizableSelectionPane(this);
			map.put(this, selectionOverlay);
			selectionLayer.getChildren().add(selectionOverlay);
			selection.add(this);
			dragDelta.x = getTranslateX() - mouseEvent.getSceneX();
			dragDelta.y = getTranslateY() - mouseEvent.getSceneY();
			mouseEvent.consume();
		});

		setOnMouseDragged(mouseEvent -> {
			if (!selection.contains(this)) {
				return;
			}
			setTranslateX(mouseEvent.getSceneX() + dragDelta.x);
			setTranslateY(mouseEvent.getSceneY() + dragDelta.y);
			updateLayoutFigureBounds();
		});

		setOnMouseReleased(mouseEvent -> {
			if (!selection.contains(this)) {
				return;
			}
			double x = getTranslateX();
			double y = getTranslateY();
			relocate(getLayoutX() + x, getLayoutY() + y);
			setTranslateX(0);
			setTranslateY(0);
			updateLayoutFigureBounds();
		});
	}

	public double computePrefHeight(double arg0) {
		return super.computePrefHeight(arg0);
	}

	public void add(Node node) {

	}

	public void remove(Node node) {
		removeOverlay(node);
		selection.remove(node);
	}

	private void removeOverlay(Node node) {
		RcplResizableSelectionPane boundsDisplay = map.get(node);
		if (boundsDisplay != null) {
			selectionLayer.getChildren().remove(boundsDisplay);
		}
	}

	public void clear() {
		for (Node node : selection) {
			removeOverlay(node);
		}
		selection.clear();
	}

	protected void doSetWidth(double width) {
		setPrefWidth(width);
		setWidth(width);
		if (layoutFigure != null) {
			layoutFigure.setWidth(width);
			updateLayoutFigureBounds();
		}
	}

	protected void doSetHeight(double height) {
		setHeight(height);
		setPrefHeight(height);
		if (layoutFigure != null) {
			layoutFigure.setHeight(height);
			updateLayoutFigureBounds();
		}
	}

	void updateLayoutFigureBounds() {
		if (layoutFigure != null) {
			double w = layoutFigure.getWidth();
			double h = layoutFigure.getHeight();
			layoutFigure.changeBounds(getLayoutX() + getTranslateX(), getLayoutY() + getTranslateY(), w, h);
		}
	}

	Point2D getCenter() {
		return localToScene(getWidth() / 2, getHeight() / 2);
	}

	ILayoutFigure getLayoutFigure() {
		return layoutFigure;
	}

	public Group getSelectionLayer() {
		return selectionLayer;
	}

}
