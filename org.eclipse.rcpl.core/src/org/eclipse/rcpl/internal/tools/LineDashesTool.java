package org.eclipse.rcpl.internal.tools;

import org.eclipse.rcpl.model_2_0_0.rcpl.Tool;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.paint.Color;

public class LineDashesTool extends SplitMenuTool {

	public LineDashesTool(Tool tool) {
		super(tool);
	}

	@Override
	public void createContent() {
		b.setPrefWidth(100);
		updateButton(createLineItem(b, "dash_1"));
		createLineItem(b, "dash_2", 5, 10, 20);
		createLineItem(b, "dash_3", 2, 4, 20);
		createLineItem(b, "dash_4", 1, 3, 5, 7);
	}

	private MenuItem createLineItem(SplitMenuButton b, String name, double... dashes) {
		Canvas canvas = new Canvas(40, 16);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setStroke(Color.WHITE);
		double width = 3;
		gc.setLineWidth(width);
		gc.setLineDashes(dashes);
		gc.strokeLine(2, 8 - width / 2, 36, 8 - width / 2);
		MenuItem menuItem = new MenuItem();
		menuItem.setGraphic(canvas);
		menuItem.setUserData(name);
		b.getItems().add(menuItem);
		addActionListener(menuItem);
		return menuItem;
	}

}
