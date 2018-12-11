/*******************************************************************************
 * Copyright (c) 2003 - 2014 Ramin Assisi and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     Ramin Assisi - initial implementation
 *******************************************************************************/
package org.eclipse.rcpl.components;

import org.eclipse.rcpl.ILayoutFigure;
import org.eclipse.rcpl.Rcpl;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

/**
 * Simple draggable area for rotation
 */
public class WindowRotateButton extends HBox {

	public WindowRotateButton(final RcplResizablePane resizablePane) {

		setSpacing(10);
		ImageView imageView = new ImageView();
		imageView.setFitHeight(20);
		imageView.setFitWidth(20);

		Label angleLabel = new Label();
		angleLabel.setStyle("-fx-font: bold 16.0pt Arial;");
		getChildren().addAll(imageView, angleLabel);

		Image img = ((ImageView) Rcpl.get().resources().getImage("rotate", 20, 20).getNode()).getImage();
		imageView.setImage(img);

		setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				event.consume();
			}
		});

		setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				((Node) event.getSource()).setCursor(Cursor.OPEN_HAND);
			}
		});

		setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				((Node) event.getSource()).setCursor(Cursor.DEFAULT);
			}
		});

		setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				Point2D target = new Point2D(e.getSceneX(), e.getSceneY());
				Point2D center = resizablePane.getCenter();
				double angle = calcRotationAngleInDegrees(center, target);

				if (e.isControlDown()) {
					int a = (int) angle / 10 * 10;
					angle = a;
				}

				angleLabel.setText(angle + " °");
				resizablePane.setRotate(angle);
				if (resizablePane.getLayoutFigure() != null) {
					resizablePane.getLayoutFigure().getPane().setRotate(angle);
					for (ILayoutFigure f : Rcpl.UIC().getEditor().getSelectedDraggables()) {
						f.getLayoutObject().setRotation(angle);
					}
				}
				e.consume();

			}
		});
	}

	private double calcRotationAngleInDegrees(Point2D centerPt, Point2D targetPt) {
		double theta = Math.atan2(targetPt.getY() - centerPt.getY(), targetPt.getX() - centerPt.getX());
		theta += Math.PI / 2.0;
		double angle = Math.toDegrees(theta); // - 360; // 342;
		if (angle < 0) {
			angle += 360;
		}
		return angle;
	}

}
