package org.eclipse.rcpl;

import org.eclipse.rcpl.model_2_0_0.rcpl.HomePage;

import javafx.scene.Node;
import javafx.scene.layout.StackPane;

/**
 * @author Ramin
 *
 */
public interface IHomePage {

	double HOMEPAGE_HEADER_HEIGHT = 80;

	void showHomeButtons();

	StackPane getContentPane();

	Node getNode();

	int getRow();

	void refresh();

	HomePage getModel();

}
