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

package org.eclipse.rcpl.navigator.handlers;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.rcpl.model_2_0_0.rcpl.Favorite;
import org.eclipse.rcpl.model_2_0_0.rcpl.FavoritesGroup;
import org.eclipse.rcpl.model_2_0_0.rcpl.RcplFactory;
import org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage;
import org.eclipse.rcpl.model_2_0_0.rcpl.Tool;
import org.eclipse.rcpl.model_2_0_0.rcpl.ToolGroup;
import org.eclipse.rcpl.navigator.treeparts.DefaultNavigatorTreePart;

public class AddEmfTreeHandler {

	private DefaultNavigatorTreePart treePart;

	public AddEmfTreeHandler(DefaultNavigatorTreePart treePart) {
		this.treePart = treePart;
	}

	public void execute() {
		if (treePart.getSelectedObject() instanceof ToolGroup) {
			Tool tool = RcplFactory.eINSTANCE.createTool();
			ToolGroup rootGroup = ((ToolGroup) treePart.getSelectedObject());
			Command command = AddCommand.create(treePart.getManager().getEditingDomain(), rootGroup,
					RcplPackage.Literals.TOOL_GROUP, tool);
			if (command != null && command.canExecute())
				treePart.getManager().getEditingDomain().getCommandStack().execute(command);
		} else if (treePart.getSelectedObject() instanceof FavoritesGroup) {
			Favorite item = RcplFactory.eINSTANCE.createFavorite();
			FavoritesGroup rootGroup = ((FavoritesGroup) treePart.getSelectedObject());
			Command command = AddCommand.create(treePart.getManager().getEditingDomain(), rootGroup,
					RcplPackage.Literals.FAVORITE, item);
			if (command != null && command.canExecute())
				treePart.getManager().getEditingDomain().getCommandStack().execute(command);
		}

	}
}
