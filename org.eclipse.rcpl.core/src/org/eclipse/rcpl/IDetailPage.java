package org.eclipse.rcpl;

import org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool;

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

	void setTool(AbstractTool tool);

	AbstractTool getTool();

}
