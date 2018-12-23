package org.eclipse.rcpl.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.rcpl.ILayoutFigure;
import org.eclipse.rcpl.Rcpl;

import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

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

	private class DragContext {
		double x;
		double y;
	}

	public RcplResizablePane(ILayoutFigure layoutFigure, Group freeFlowtingBgGroup, Group selectionLayer) {
		super();

		this.selectionLayer = selectionLayer;
		this.layoutFigure = layoutFigure;
		this.freeFlowtingBgGroup = freeFlowtingBgGroup;
		final DragContext dragDelta = new DragContext();
//		createBg();

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

			double scale = Rcpl.UIC().getEditor().getScale();

			setTranslateX((mouseEvent.getSceneX() + dragDelta.x) / scale);
			setTranslateY((mouseEvent.getSceneY() + dragDelta.y) / scale);
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

//	private void createBg() {
//		bg = new Rectangle();
//		bg.setUserData(layoutFigure);
//
//		bg.setVisible(true);
//		bg.setPickOnBounds(false);
//		bg.setFill(Color.rgb(10, 10, 10, 0.01));
//		bg.setMouseTransparent(true);
//		bg.setWidth(layoutFigure.getWidth());
//		bg.setHeight(layoutFigure.getHeight());
//
//		double z1 = layoutFigure.getLayoutObject().getZOrder();
//		for (Node n : freeFlowtingBgGroup.getChildren()) {
//			Object o = n.getUserData();
//			if (o instanceof ILayoutFigure) {
//				ILayoutObject lo = ((ILayoutFigure) o).getLayoutObject();
//				double z2 = lo.getZOrder();
//				if (z1 < z2) {
//					int index = freeFlowtingBgGroup.getChildren().indexOf(n);
//					freeFlowtingBgGroup.getChildren().add(index, bg);
//					return;
//				}
//			}
//		}
//		freeFlowtingBgGroup.getChildren().add(bg);
//
//	}

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
	}

	@Override
	protected void setHeight(double value) {
		super.setHeight(value);
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

	public void setBgColor(Color color) {
//		if (color == null) {
//			setBackground(null);
//			return;
//		}
		setBackground(new Background(new BackgroundFill(color, null, null)));
	}
}
