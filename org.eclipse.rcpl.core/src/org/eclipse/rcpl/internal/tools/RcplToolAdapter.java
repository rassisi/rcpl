package org.eclipse.rcpl.internal.tools;

import org.eclipse.rcpl.AbstractRcplTool;
import org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool;

import javafx.beans.value.ChangeListener;

public abstract class RcplToolAdapter extends AbstractRcplTool {

	public RcplToolAdapter(AbstractTool model) {
		super(model);
	}

	@Override
	protected ChangeListener createChangeListener() {
		return null;
	}

	@Override
	protected void doRemoveListener(ChangeListener changeListener) {
	}

	@Override
	protected void doAddListener(ChangeListener changeListener) {
	}

}
