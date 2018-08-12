package org.eclipse.rcpl.internal.tools;

import org.eclipse.rcpl.RcplTool;
import org.eclipse.rcpl.model_2_0_0.rcpl.Tool;

import javafx.scene.Node;
import javafx.scene.layout.FlowPane;

/**
 * @author ramin
 *
 */
public class FlowPaneTool extends RcplTool {

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
}
