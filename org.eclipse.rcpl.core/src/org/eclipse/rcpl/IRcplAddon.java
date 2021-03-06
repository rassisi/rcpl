package org.eclipse.rcpl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcpl.model_2_0_0.rcpl.Addon;
import org.eclipse.rcpl.model_2_0_0.rcpl.Tool;

import javafx.scene.Node;

public interface IRcplAddon {

	void init();

	String getId();

	Node getNode();

	Addon getModel();

	void setModel(Addon model);

	String getDisplayName();

	Class<? extends EObject> getRootClass();

	void setTool(Tool tool);

	Tool getTool();

	void setAsEditor(boolean asEditor);

	boolean isAsEditor();

	void executeCommand(ICommand command);

	void bindToModel() throws Exception;

	boolean isCustomApplication();
}
