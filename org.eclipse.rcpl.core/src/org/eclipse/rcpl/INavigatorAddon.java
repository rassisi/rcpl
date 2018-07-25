package org.eclipse.rcpl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcpl.model_2_0_0.rcpl.Tool;

import javafx.scene.layout.Pane;

/**
 * @author ramin
 *
 */
public interface INavigatorAddon extends IRcplAddon {

	ITreePart createPart(Pane detailPane, Tool tool, boolean showRoot);

	INavigatorTreeManager createNavigatorTreemanager();

	ITreePart createTreePart();

	void setRoot(EObject root);

}
