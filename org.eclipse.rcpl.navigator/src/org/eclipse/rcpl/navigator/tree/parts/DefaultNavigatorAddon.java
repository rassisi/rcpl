/*******************************************************************************
 * Copyright (c) 2003 - 2014 Ramin Assisi and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     Ramin Assisi - initial implementation
 *******************************************************************************/

package org.eclipse.rcpl.navigator.tree.parts;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcpl.AbstractRcplAddon;
import org.eclipse.rcpl.INavigatorAddon;
import org.eclipse.rcpl.IRcplPluginControler;
import org.eclipse.rcpl.ITreePart;
import org.eclipse.rcpl.RcplAddon;
import org.eclipse.rcpl.migration.RcplAbstractMigration;
import org.eclipse.rcpl.model.cdo.client.RcplSession;
import org.eclipse.rcpl.model_2_0_0.rcpl.RCPL;
import org.eclipse.rcpl.model_2_0_0.rcpl.Tool;
import org.eclipse.rcpl.navigator.tree.model.manager.UCEmfTreeModelManagerImpl;

import javafx.scene.layout.Pane;

/**
 * @author Ramin
 * 
 */
@RcplAddon
public class DefaultNavigatorAddon extends AbstractRcplAddon implements INavigatorAddon {

	UCEmfTreeModelManagerImpl manager;

	private static DefaultNavigatorAddon INSTANCE;

	public DefaultNavigatorAddon() {
		INSTANCE = this;
		manager = new UCEmfTreeModelManagerImpl();
	}

	@Override
	public void setTool(Tool tool) {
		super.setTool(tool);
		ITreePart part = createPart(tool);
		getNode().setCenter(part.getNode());
	}

	protected ITreePart createPart(Tool tool, EObject root) {
		ITreePart treePart = new DefaultNavigatorTreePart();
		treePart.init(null, tool, root, true);
		return treePart;
	}

	protected ITreePart createPart(Tool tool) {
		ITreePart treePart = new DefaultNavigatorTreePart();
		treePart.init(null, tool, null, true);
		return treePart;
	}

	@Override
	public ITreePart createPart(Pane detailPane, Tool tool, EObject root, boolean showRoot) {
		if (root == null) {
			RCPL rcpl = RcplSession.getDefault().getRcpl();
			if (rcpl != null) {
				root = rcpl.getAllResources();
			}
		}
		ITreePart treePart = new DefaultNavigatorTreePart();

		treePart.init(detailPane, tool, root, showRoot);
		return treePart;

	}

	@Override
	protected RcplAbstractMigration getMigration() {
		return new DefaultNavigatorMigration(this);
	}

	@Override
	public boolean isCustomApplication() {
		return false;
	}

	@Override
	protected IRcplPluginControler createController() {
		return null;
	}

	public static DefaultNavigatorAddon getDefault() {
		return INSTANCE;
	}

	public UCEmfTreeModelManagerImpl getManager() {
		return manager;
	}
}
