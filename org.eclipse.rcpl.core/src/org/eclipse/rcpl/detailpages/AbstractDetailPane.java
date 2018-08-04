package org.eclipse.rcpl.detailpages;

import org.eclipse.rcpl.IDetailPage;

import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * @author ramin
 *
 */
public abstract class AbstractDetailPane implements IDetailPage {

	private StackPane stackPane;

	VBox node;

	@Override
	public Node getNode() {
		if (node == null) {
			node = new VBox();
			HBox hBox = new HBox();
			Text text = new Text(getName());
			hBox.getChildren().add(text);
			hBox.setId("detailPageHeaderText");
			hBox.setMinHeight(32);

			node.getChildren().add(hBox);
			stackPane = new StackPane();
			node.getChildren().add(stackPane);
			create(stackPane);
		}
		return node;
	}

	public AbstractDetailPane() {
		super();

	}

	@Override
	abstract public void create(StackPane stackPane);

	@Override
	abstract public String getName();

}
