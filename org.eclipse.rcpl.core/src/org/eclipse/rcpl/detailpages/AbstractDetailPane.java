package org.eclipse.rcpl.detailpages;

import org.eclipse.rcpl.IDetailPage;
import org.eclipse.rcpl.images.RcplImage;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 * @author ramin
 *
 */
public abstract class AbstractDetailPane implements IDetailPage {

	private StackPane stackPane;

	private VBox node;

	private StackPane imageStack = new StackPane();

	@Override
	public Node getNode() {
		if (node == null) {
			node = new VBox();

			HBox header = new HBox();
			TextFlow tf = new TextFlow();
			Text text = new Text(getName());
			tf.getChildren().add(text);
			tf.setId("detailPageHeaderText");
			header.setMinHeight(40);
			header.setPrefHeight(40);
			header.setMaxHeight(40);
			HBox.setHgrow(tf, Priority.ALWAYS);
			header.setSpacing(20);
			header.setAlignment(Pos.CENTER_LEFT);
			imageStack = new StackPane();
			imageStack.setPrefSize(32, 32);
			imageStack.setMinSize(32, 32);
			imageStack.setMaxSize(32, 32);
			HBox.setMargin(imageStack, new Insets(0, 0, 0, 20));
			header.getChildren().addAll(imageStack, tf);

			stackPane = new StackPane();
			node.getChildren().addAll(header, stackPane);

			VBox.setVgrow(header, Priority.NEVER);
			VBox.setVgrow(stackPane, Priority.ALWAYS);
			create(stackPane);
		}
		return node;
	}

	public AbstractDetailPane() {
		super();

	}

	@Override
	public void setImage(String imageName) {
		imageStack.getChildren().clear();
		imageStack.getChildren().add(new RcplImage(imageName, 32, 32).getNode());
	}

	@Override
	abstract public void create(StackPane stackPane);

	@Override
	abstract public String getName();

}
