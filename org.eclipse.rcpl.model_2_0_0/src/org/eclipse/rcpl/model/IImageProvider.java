package org.eclipse.rcpl.model;

import javafx.scene.Node;

public interface IImageProvider {

	Node getImageNode(String id, double width, double height);

}
