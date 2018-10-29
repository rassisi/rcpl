package org.eclipse.rcpl.internal.tools;

import org.eclipse.rcpl.model_2_0_0.rcpl.Tool;
import org.eclipse.rcpl.util.RcplUtil;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.paint.Color;

/**
 * @author Ramin
 *
 */
public class LineWidthTool extends SplitMenuTool {

	public LineWidthTool(Tool tool) {
		super(tool);
	}

	@Override
	public void createContent() {
		b.setPrefWidth(100);
		MenuItem firstItem = createLineItem(b, 0.05);
		updateButton(firstItem);
		createLineItem(b, 0.50);
		createLineItem(b, 0.75);
		createLineItem(b, 1.00);
		createLineItem(b, 1.25);
		createLineItem(b, 1.50);
		createLineItem(b, 1.75);
		createLineItem(b, 2.00);
		createLineItem(b, 2.25);
		createLineItem(b, 2.50);
		createLineItem(b, 2.75);
		createLineItem(b, 3.25);
		createLineItem(b, 3.50);
		createLineItem(b, 3.75);
		createLineItem(b, 4.00);
		createLineItem(b, 5.00);
		createLineItem(b, 6.00);
		createLineItem(b, 7.00);
		createLineItem(b, 8.00);
		createLineItem(b, 9.00);
	}

	private MenuItem createLineItem(SplitMenuButton b, double points) {
		double width = RcplUtil.getPoint2PixelFactor() * points;
		Canvas canvas = new Canvas(40, 16);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.WHITE);
		gc.fillRect(2, 8 - width / 2, 36, width);
		MenuItem menuItem = new MenuItem();
		menuItem.setGraphic(canvas);
		menuItem.setUserData(points);
		b.getItems().add(menuItem);
		addActionListener(menuItem);
		return menuItem;
	}

}
