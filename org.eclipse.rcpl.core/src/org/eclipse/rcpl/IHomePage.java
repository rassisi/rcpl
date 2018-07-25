package org.eclipse.rcpl;

import org.eclipse.rcpl.model_2_0_0.rcpl.HomePage;
import org.eclipse.rcpl.model_2_0_0.rcpl.HomePageType;

import javafx.scene.Node;
import javafx.scene.layout.StackPane;

/**
 * @author Ramin
 *
 */
public interface IHomePage {

	void showHomeButtons();

	StackPane getContentPane();

	Node getNode();

	int getRow();

	void refresh();

	HomePageType getId();

	void setDetailNode(Node node);

	HomePage getModel();

}
