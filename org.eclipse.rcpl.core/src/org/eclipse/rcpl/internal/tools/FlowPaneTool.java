package org.eclipse.rcpl.internal.tools;

import org.eclipse.rcpl.AbstractRcplTool;
import org.eclipse.rcpl.model_2_0_0.rcpl.Tool;
import org.eclipse.rcpl.ui.listener.RcplEvent;

import javafx.beans.value.ChangeListener;
import javafx.scene.Node;
import javafx.scene.layout.FlowPane;

/**
 * @author ramin
 *
 */
public class FlowPaneTool extends AbstractRcplTool {

	public FlowPaneTool(Tool tool) {
		super(tool);
	}

	@Override
	public FlowPane createNode() {
		return new FlowPane();

	}

	@Override
	public Node getNode() {
		return super.getNode();
	}

	@Override
	protected ChangeListener createChangeListener() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void doRemoveListener(ChangeListener changeListener) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void doAddListener(ChangeListener changeListener) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void doUpdate(RcplEvent event) {
		// TODO Auto-generated method stub

	}
}
