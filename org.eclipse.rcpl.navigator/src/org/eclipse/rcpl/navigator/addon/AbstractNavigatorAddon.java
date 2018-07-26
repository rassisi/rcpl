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

package org.eclipse.rcpl.navigator.addon;

import org.eclipse.rcpl.AbstractRcplAddon;
import org.eclipse.rcpl.INavigatorAddon;
import org.eclipse.rcpl.INavigatorTreeManager;
import org.eclipse.rcpl.IRcplPluginControler;
import org.eclipse.rcpl.ITreePart;
import org.eclipse.rcpl.RcplAddon;
import org.eclipse.rcpl.migration.RcplAbstractMigration;
import org.eclipse.rcpl.model_2_0_0.rcpl.Tool;
import org.eclipse.rcpl.navigator.tree.parts.DefaultNavigatorMigration;

import javafx.scene.layout.Pane;

/**
 * @author Ramin
 * 
 */
@RcplAddon
public abstract class AbstractNavigatorAddon extends AbstractRcplAddon implements INavigatorAddon {

	private INavigatorTreeManager manager;

	private static AbstractNavigatorAddon INSTANCE;

	public AbstractNavigatorAddon() {
		INSTANCE = this;
	}

	@Override
	public ITreePart createPart(Pane detailPane, Tool tool, boolean showRoot) {
		ITreePart treePart = createTreePart();
		treePart.init(detailPane, tool, showRoot);
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

	public static AbstractNavigatorAddon getDefault() {
		return INSTANCE;
	}

	public INavigatorTreeManager getManager() {
		if (manager == null) {
			manager = createNavigatorTreemanager();
		}
		return manager;
	}

	public abstract ITreePart createTreePart();

	@Override
	public abstract INavigatorTreeManager createNavigatorTreemanager();

}
