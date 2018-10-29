package org.eclipse.rcpl.internal.tools;

import org.eclipse.rcpl.model_2_0_0.rcpl.Tool;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineJoin;

/**
 * @author Ramin
 *
 */
public class LineArrowsTool extends SplitMenuTool {

	public LineArrowsTool(Tool tool) {
		super(tool);
	}

	@Override
	public void createContent() {
		b.setPrefWidth(100);
		updateButton(createLineItem(b, "arrow_1", StrokeLineJoin.BEVEL));
		createLineItem(b, "arrow_2", StrokeLineJoin.MITER);
		createLineItem(b, "arrow_3", StrokeLineJoin.ROUND);
	}

	private MenuItem createLineItem(SplitMenuButton b, String name, StrokeLineJoin join) {
		Canvas canvas = new Canvas(40, 16);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setStroke(Color.WHITE);
		double width = 3;
		gc.setLineWidth(width);
		gc.setLineJoin(join);
		gc.strokeRect(2, 8 - width / 2, 36, width);
		MenuItem menuItem = new MenuItem();
		menuItem.setGraphic(canvas);
		menuItem.setUserData(name);
		b.getItems().add(menuItem);
		addActionListener(menuItem);
		return menuItem;
	}

}
