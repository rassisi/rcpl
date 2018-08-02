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

	IModelManager getRcplManager();

	IModelManager getApplicationTreeManager();

	void init(Tool tool, boolean showRoot);

	@Override
	Node getNode();

	Object getSelectedObject();

	void refresh();

	void setRoot(EObject root);

	void setContainer(Pane pane);
}
