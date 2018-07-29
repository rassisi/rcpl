package org.eclipse.rcpl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcpl.model_2_0_0.rcpl.Tool;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

/**
 * @author Ramin
 *
 */
public interface ITreePart extends ITool {

	INavigatorTreeManager getRcplManager();

	INavigatorTreeManager getApplicationTreeManager();

	void init(Tool tool, boolean showRoot);

	@Override
	Node getNode();

	Object getSelectedObject();

	void refresh();

	EObject getRoot();

	void setRoot(EObject root);

	void setContainer(Pane pane);
}
