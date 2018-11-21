package org.eclipse.rcpl;

import org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool;

import javafx.scene.Node;

public interface ITool extends IEditorListener, ILocalable {

	String getId();

	void fire();

	void setSelected(boolean selected);

	boolean isSelected();

	String getImageName();

	Node createNode();

	Node getNode();

	AbstractTool getModel();

	IToolRegistry getToolRegistry();

	IResourceEntry getEntry();

	IToolComponent getToolComponent();

	void setVisible(boolean visible);

	IToolGroup getGroup();

	void setBounds(double x, double y, double Width, double height);

	boolean isFullSize();

	int getToolHierarchy();

	Object getImage();

	boolean isWrap();

	String getService();

	ITool setData(Object... data);

	Object[] getData();

	void setWidth(double width);

}
