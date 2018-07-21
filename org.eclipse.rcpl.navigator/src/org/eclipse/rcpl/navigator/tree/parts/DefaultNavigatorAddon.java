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
import org.eclipse.rcpl.RcplAddon;
import org.eclipse.rcpl.migration.RcplAbstractMigration;
import org.eclipse.rcpl.model.cdo.client.RcplSession;
import org.eclipse.rcpl.model_2_0_0.rcpl.RCPL;
import org.eclipse.rcpl.model_2_0_0.rcpl.Tool;

import javafx.scene.layout.Pane;

/**
 * @author Ramin
 * 
 */
@RcplAddon
public class DefaultNavigatorAddon extends AbstractRcplAddon implements INavigatorAddon {

	@Override
	public void setTool(Tool tool) {
		super.setTool(tool);
		DefaultNavigatorTreePart part = createPart(tool);
		getNode().setCenter(part.getNode());
	}

	protected DefaultNavigatorTreePart createPart(Tool tool, EObject root) {
		return new DefaultNavigatorTreePart(null, tool, root, true);
	}

	protected DefaultNavigatorTreePart createPart(Tool tool) {
		return new DefaultNavigatorTreePart(null, tool, null, true);
	}

	@Override
	public void init() {
		super.init();
	}

	@Override
	public String getDisplayName() {
		return "Setup Tools";
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

	@Override
	public DefaultNavigatorTreePart create(Pane detailPane, Tool tool, EObject root, boolean showRoot) {

		if (root == null) {
			RCPL rcpl = RcplSession.getDefault().getRcpl();
			if (rcpl != null) {
				root = rcpl.getAllResources();
			}
		}
		return new DefaultNavigatorTreePart(detailPane, tool, root, showRoot);

	}
}
