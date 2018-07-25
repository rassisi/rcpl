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

import org.eclipse.rcpl.INavigatorAddon;
import org.eclipse.rcpl.INavigatorTreeManager;
import org.eclipse.rcpl.ITreePart;
import org.eclipse.rcpl.RcplAddon;
import org.eclipse.rcpl.navigator.tree.model.manager.NavigatorTreeManagerImpl;
import org.eclipse.rcpl.navigator.tree.parts.DefaultNavigatorTreePart;

/**
 * @author Ramin
 * 
 */
@RcplAddon
public class DefaultNavigatorAddon extends AbstractNavigatorAddon implements INavigatorAddon {

	public ITreePart createTreePart() {
		return new DefaultNavigatorTreePart();
	}

	@Override
	public INavigatorTreeManager createNavigatorTreemanager() {
		return new NavigatorTreeManagerImpl();
	}
}
