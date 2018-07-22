package org.eclipse.rcpl;

import javafx.scene.Node;
import javafx.scene.layout.StackPane;

/**
 * @author Ramin
 *
 */
public interface IHomePage {

	StackPane getContentPane();

	Node getNode();

	int getRow();

	void refresh();

	EnCommandId getId();

	void setDetailNode(Node node);

}
