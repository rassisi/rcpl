package org.eclipse.rcpl.detailpages;

import org.eclipse.rcpl.IDetailPage;
import org.eclipse.rcpl.images.RcplImage;
import org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool;

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

	private AbstractTool tool;

	private Text headerText;

	private StackPane progressViewArea;

	@Override
	public Node getNode() {
		if (node == null) {
			node = new VBox();

			HBox header = new HBox();
			TextFlow tf = new TextFlow();

			tf.setMinHeight(18);
			tf.setPrefHeight(18);
			tf.setMaxHeight(18);

			headerText = new Text(getName());
			tf.getChildren().add(headerText);
			tf.setId("detailPageHeaderText");
			header.setMinHeight(60);
			header.setPrefHeight(60);
			header.setMaxHeight(60);
			HBox.setHgrow(tf, Priority.ALWAYS);
			header.setSpacing(20);
			header.setAlignment(Pos.CENTER_LEFT);
			imageStack = new StackPane();
			imageStack.setPrefSize(32, 32);
			imageStack.setMinSize(32, 32);
			imageStack.setMaxSize(32, 32);
			HBox.setMargin(imageStack, new Insets(0, 0, 0, 60));
			header.getChildren().addAll(imageStack, tf);

			stackPane = new StackPane();

			progressViewArea = new StackPane();
			progressViewArea.setPrefHeight(60);
			progressViewArea.setMinHeight(60);
			progressViewArea.setMaxHeight(60);

			node.getChildren().addAll(header, stackPane);

			VBox.setVgrow(header, Priority.NEVER);
			VBox.setVgrow(stackPane, Priority.ALWAYS);
			create(stackPane);
		}
		return node;
	}

	protected void expandTaskView() {
		if (!node.getChildren().contains(progressViewArea)) {
			node.getChildren().add(progressViewArea);
		}
	}

	protected void collapseTaskView() {
		node.getChildren().remove(progressViewArea);
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

	@Override
	public void setTool(AbstractTool tool) {
		this.tool = tool;
	}

	@Override
	public AbstractTool getTool() {
		return tool;
	}

	protected void setTitle(String title) {
		headerText.setText(title);
	}

	@Override
	public StackPane getProgressViewArea() {
		return progressViewArea;
	}

}
