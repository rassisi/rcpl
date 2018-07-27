package org.eclipse.rcpl;

import org.eclipse.rcpl.navigator.IDetailPaneControler;

import javafx.scene.Node;

/**
 * @author ramin
 *
 */
public interface IDetailPane {

	IDetailPaneControler getControler();

	Node getNode();
}
