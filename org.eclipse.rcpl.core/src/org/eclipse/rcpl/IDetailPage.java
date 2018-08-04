package org.eclipse.rcpl;

import javafx.scene.Node;
import javafx.scene.layout.StackPane;

/**
 * @author ramin
 *
 */
public interface IDetailPage {

	Node getNode();

	void create(StackPane stackPane);

	String getName();

	void setImage(String imageName);
}
