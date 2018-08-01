package org.eclipse.rcpl.navigator.details;

import org.eclipse.rcpl.IDetailPage;

import javafx.scene.Node;
import javafx.scene.layout.StackPane;

/**
 * @author ramin
 *
 */
public abstract class AbstractDetailPane implements IDetailPage {

	private StackPane stackPane;

	@Override
	public Node getNode() {
		if (stackPane == null) {
			stackPane = new StackPane();
			create(stackPane);
		}
		return stackPane;
	}

	public AbstractDetailPane() {
		super();

	}

	@Override
	abstract public void create(StackPane stackPane);

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}
}
