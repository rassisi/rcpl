package org.eclipse.rcpl.internal.tools;

import org.eclipse.rcpl.images.RcplImage;
import org.eclipse.rcpl.model_2_0_0.rcpl.Tool;

import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

/**
 * @author Ramin
 *
 */
public class PatternTool extends SplitMenuTool {

	public PatternTool(Tool tool) {
		super(tool);
	}

	@Override
	public void createContent() {
		b.setPrefWidth(100);
		updateButton(createLineItem(b, "folder"));
		createLineItem(b, "image");

	}

	private MenuItem createLineItem(SplitMenuButton b, String name) {
		Image image = new RcplImage(name, 16, 16).getNode().getImage();
		ImagePattern p = new ImagePattern(image, 1, 1, 3, 3, true);
		Rectangle r = new Rectangle(40, 16);
		r.setFill(p);
		MenuItem menuItem = new MenuItem();
		menuItem.setGraphic(r);
		menuItem.setUserData(name);
		b.getItems().add(menuItem);
		addActionListener(menuItem);
		return menuItem;
	}

}
