package org.eclipse.rcpl.components;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.scene.shape.Rectangle;

public class RcplResizableSelectionPane extends Region {

	private boolean selectionRectangleVisible = true;
	private boolean dragHandlesVisible = true;
	private final Node monitoredShape;
	private ChangeListener<Bounds> boundsChangeListener;
	private double diameter = 6;
	private double radius = diameter / 2.0;
	private Rectangle selectionRectangle = new Rectangle();
	private DragHandle dragHandleNW;
	private DragHandle dragHandleNE;
	private DragHandle dragHandleSE;
	private DragHandle dragHandleSW;
	private DragHandle dragHandleN;
	private DragHandle dragHandleS;
	private DragHandle dragHandleE;
	private DragHandle dragHandleW;

	private RcplResizablePane resizablePane;
	private WindowRotateButton rotateButton;

	private class Delta {
		double x;
		double y;
		double minX;
		double maxX;
		double minY;
		double maxY;
	}

	RcplResizableSelectionPane(RcplResizablePane resizablePane) {

		this.resizablePane = resizablePane;

		setPickOnBounds(false);
		selectionRectangle.setMouseTransparent(true);

		if (selectionRectangleVisible) {
			selectionRectangle.getStyleClass().add("selection_rectangle");
			getChildren().add(selectionRectangle);
		}

		if (dragHandlesVisible) {
			dragHandleNW = new DragHandle(diameter, Cursor.NW_RESIZE);
			dragHandleNE = new DragHandle(diameter, Cursor.NE_RESIZE);
			dragHandleSE = new DragHandle(diameter, Cursor.SE_RESIZE);
			dragHandleSW = new DragHandle(diameter, Cursor.SW_RESIZE);
			dragHandleN = new DragHandle(diameter, Cursor.N_RESIZE);
			dragHandleS = new DragHandle(diameter, Cursor.S_RESIZE);
			dragHandleE = new DragHandle(diameter, Cursor.E_RESIZE);
			dragHandleW = new DragHandle(diameter, Cursor.W_RESIZE);
			rotateButton = new WindowRotateButton(resizablePane);
			getChildren().addAll(dragHandleNW, dragHandleNE, dragHandleSE, dragHandleSW, dragHandleN, dragHandleS,
					dragHandleE, dragHandleW, rotateButton);
		}

		monitoredShape = resizablePane;

		monitorBounds();

	}

	/**
	 * Set bounds listener for the overlay.
	 */
	private void monitorBounds() {
		final ReadOnlyObjectProperty<Bounds> bounds = monitoredShape.boundsInParentProperty();
		updateBounds(bounds.get());
		boundsChangeListener = new ChangeListener<Bounds>() {
			@Override
			public void changed(ObservableValue<? extends Bounds> observableValue, Bounds oldBounds, Bounds newBounds) {
				updateBounds(newBounds);
			}
		};
		bounds.addListener(boundsChangeListener);
	}

	/**
	 * 
	 * @param newBounds
	 */
	private void updateBounds(Bounds newBounds) {

//		resizablePane.getBg().setX(newBounds.getMinX());
//		resizablePane.getBg().setY(newBounds.getMinY());
//		resizablePane.getBg().setWidth(newBounds.getWidth());
//		resizablePane.getBg().setHeight(newBounds.getHeight());

		if (selectionRectangleVisible) {
			selectionRectangle.setX(newBounds.getMinX());
			selectionRectangle.setY(newBounds.getMinY());
			selectionRectangle.setWidth(newBounds.getWidth());
			selectionRectangle.setHeight(newBounds.getHeight());
		}

		if (dragHandlesVisible) {
			dragHandleNW.setX(newBounds.getMinX() - radius);
			dragHandleNW.setY(newBounds.getMinY() - radius);
			dragHandleNE.setX(newBounds.getMaxX() - radius);
			dragHandleNE.setY(newBounds.getMinY() - radius);
			dragHandleSE.setX(newBounds.getMaxX() - radius);
			dragHandleSE.setY(newBounds.getMaxY() - radius);
			dragHandleSW.setX(newBounds.getMinX() - radius);
			dragHandleSW.setY(newBounds.getMaxY() - radius);
			dragHandleN.setX(newBounds.getMinX() + newBounds.getWidth() / 2.0 - radius);
			dragHandleN.setY(newBounds.getMinY() - radius);
			dragHandleS.setX(newBounds.getMinX() + newBounds.getWidth() / 2.0 - radius);
			dragHandleS.setY(newBounds.getMaxY() - radius);
			dragHandleE.setX(newBounds.getMaxX() - radius);
			dragHandleE.setY(newBounds.getMinY() + newBounds.getHeight() / 2.0 - radius);
			dragHandleW.setX(newBounds.getMinX() - radius);
			dragHandleW.setY(newBounds.getMinY() + newBounds.getHeight() / 2.0 - radius);
			double max = Math.max(newBounds.getWidth(), newBounds.getHeight());
			rotateButton.setLayoutY(newBounds.getMinY() - max / 3);
			rotateButton.setLayoutX(newBounds.getMinX() + newBounds.getWidth() / 2.0 - 11);
		}
	}

	private void enableDrag(final DragHandle dragHandle) {

		final Delta dragDelta = new Delta();

		dragHandle.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				dragDelta.x = dragHandle.getX() - mouseEvent.getX();
				dragDelta.y = dragHandle.getY() - mouseEvent.getY();
				dragDelta.minX = resizablePane.getBoundsInParent().getMinX();
				dragDelta.maxX = resizablePane.getBoundsInParent().getMaxX();
				dragDelta.minY = resizablePane.getBoundsInParent().getMinY();
				dragDelta.maxY = resizablePane.getBoundsInParent().getMaxY();
				getScene().setCursor(dragHandle.getDragCursor());
				mouseEvent.consume();
			}
		});
		dragHandle.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				getScene().setCursor(Cursor.DEFAULT);
				mouseEvent.consume();
			}
		});
		dragHandle.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {

				double newX = mouseEvent.getX() + dragDelta.x;
				double newY = mouseEvent.getY() + dragDelta.y;

				dragHandle.setX(newX);
				dragHandle.setY(newY);

				double newWidth = -1;
				double newHeight = -1;

				if (dragHandle == dragHandleN) {
					newHeight = dragDelta.maxY - newY - radius;
					if (newHeight > 0) {
						resizablePane.relocate(dragDelta.minX, newY + radius);
					}
				} else if (dragHandle == dragHandleNE) {
					newWidth = newX - dragDelta.minX + radius;
					newHeight = dragDelta.maxY - newY - radius;
					if (newWidth > 0 && newHeight > 0) {
						resizablePane.relocate(dragDelta.minX, newY + radius);
					}
				} else if (dragHandle == dragHandleE) {
					newWidth = newX - dragDelta.minX + radius;
				} else if (dragHandle == dragHandleSE) {
					newWidth = newX - dragDelta.minX + radius;
					newHeight = newY - dragDelta.minY + radius;
				} else if (dragHandle == dragHandleS) {
					newHeight = newY - dragDelta.minY + radius;
				} else if (dragHandle == dragHandleSW) {
					newWidth = dragDelta.maxX - newX - radius;
					newHeight = newY - dragDelta.minY + radius;
					if (newWidth > 0 && newHeight > 0) {
						resizablePane.relocate(newX + radius, dragDelta.minY);
					}
				} else if (dragHandle == dragHandleW) {
					newWidth = dragDelta.maxX - newX - radius;
					if (newWidth > 0) {
						resizablePane.relocate(newX + radius, dragDelta.minY);
					}
				} else if (dragHandle == dragHandleNW) {
					newWidth = dragDelta.maxX - newX - radius;
					newHeight = dragDelta.maxY - newY - radius;
					if (newWidth > 0 && newHeight > 0) {
						resizablePane.relocate(newX + radius, newY + radius);
					}
				}

				if (newWidth > 0) {
					setWidth(resizablePane, newWidth);
//					resizablePane.getBg().setWidth(newWidth);
				}
				if (newHeight > 0) {
					setHeight(resizablePane, newHeight);
//					resizablePane.getBg().setWidth(newHeight);
				}
				resizablePane.updateLayoutFigureBounds();

				mouseEvent.consume();
			}
		});
		dragHandle.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				if (mouseEvent.isPrimaryButtonDown()) {
					return;
				}

				getScene().setCursor(dragHandle.getDragCursor());

			}
		});
		dragHandle.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				if (!mouseEvent.isPrimaryButtonDown()) {
					getScene().setCursor(Cursor.DEFAULT);
				}
			}
		});

	}

	private void setWidth(Node node, double width) {
		if (width < 1) {
			return;
		}
		if (node instanceof Rectangle) {
			Rectangle shape = (Rectangle) node;
			shape.setWidth(width);
		} else if (node instanceof Control) {
			Control control = (Control) node;
			control.setPrefWidth(width);
		} else if (node instanceof Region) {
			Region region = (Region) node;
			region.setPrefWidth(width);
		}

		setPrefWidth(width);
		this.resizablePane.doSetWidth(width - 30);
	}

	private void setHeight(Node node, double height) {
		if (height < 1) {
			return;
		}
		if (node instanceof Rectangle) {
			Rectangle shape = (Rectangle) node;
			shape.setHeight(height);
		} else if (node instanceof Control) {
			Control control = (Control) node;
			control.setPrefHeight(height);
		} else if (node instanceof Region) {
			Region region = (Region) node;
			region.setPrefHeight(height);
		}

		setPrefHeight(height);
		this.resizablePane.doSetHeight(height);
	}

	/**
	 * Drag handle
	 */
	private class DragHandle extends Rectangle {
		Cursor dragCursor;

		public DragHandle(double size, Cursor dragCursor) {
			this.dragCursor = dragCursor;
			setWidth(size);
			setHeight(size);
			getStyleClass().add("selection_drag_handle");
			enableDrag(this);
		}

		public Cursor getDragCursor() {
			return dragCursor;
		}
	}

	void rotate(double angle) {
		setRotate(angle);
		selectionRectangle.setRotate(angle);
	}

}