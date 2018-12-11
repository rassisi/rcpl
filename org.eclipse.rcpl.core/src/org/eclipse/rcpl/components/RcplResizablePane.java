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
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * @author Ramin
 *
 */
public class RcplResizablePane extends StackPane {

	private ILayoutFigure layoutFigure;

	private Group selectionLayer;

	Group freeFlowtingBgGroup;

	private Map<Node, RcplResizableSelectionPane> map = new HashMap<Node, RcplResizableSelectionPane>();

	private List<Node> selection = new ArrayList<>();

	private RcplResizableSelectionPane selectionPane;

	private Rectangle bg;

	private class DragContext {
		double x;
		double y;
	}

	public RcplResizablePane(ILayoutFigure layoutFigure, Group freeFlowtingBgGroup, Group selectionLayer) {
		super();
		this.selectionLayer = selectionLayer;
		this.layoutFigure = layoutFigure;
		final DragContext dragDelta = new DragContext();

		bg = new Rectangle();
		bg.setFill(Color.TRANSPARENT);
		bg.setVisible(true);
		bg.setPickOnBounds(false);
		bg.setMouseTransparent(true);
		freeFlowtingBgGroup.getChildren().add(bg);

		setOnMousePressed(mouseEvent -> {
			clear();
			if (selection.contains(this))
				return;
			selectionPane = new RcplResizableSelectionPane(this);
			map.put(this, selectionPane);
			selectionLayer.getChildren().add(selectionPane);
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

	@Override
	protected void setWidth(double value) {
		super.setWidth(value);
		bg.setWidth(value);
	}

	@Override
	protected void setHeight(double value) {
		super.setHeight(value);
		bg.setHeight(value);
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

	public Rectangle getBg() {
		return bg;
	}

	public void setX(double x) {
		setLayoutX(x);
		bg.setX(x);
	}

	public void setBgColor(Color color) {
		bg.setFill(color);
	}
}
