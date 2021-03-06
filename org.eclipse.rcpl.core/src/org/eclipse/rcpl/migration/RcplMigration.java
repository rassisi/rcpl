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
package org.eclipse.rcpl.migration;

import org.eclipse.rcpl.Rcpl;
import org.eclipse.rcpl.model.client.RcplSession;
import org.eclipse.rcpl.model_2_0_0.rcpl.Favorites;
import org.eclipse.rcpl.model_2_0_0.rcpl.RcplFactory;

public class RcplMigration extends RcplAbstractMigration {

	public RcplMigration() {
	}

	/**
	 *  
	 */
	@Override
	public void migrate() {
		Rcpl.get().progressMessage("Migrate Model");
		if (RcplSession.getDefault().getContents() == null) {
			Rcpl.get().progressMessage("Model migrated (Content == null)");
			return;
		}
		migrateOffice();
		Rcpl.get().progressMessage("Model migrated");
	}

	protected void migrateOffice() {
		if (RcplSession.getDefault().getRcpl() != null
				&& RcplSession.getDefault().getRcpl().getAllFavorites() == null) {
			Favorites favorites = RcplFactory.eINSTANCE.createFavorites();
			RcplSession.getDefault().getRcpl().setAllFavorites(favorites);

			// FavoritesGroup favoritesGroup = RcplFactory.eINSTANCE
			// .createFavoritesGroup();
			// favoritesGroup.setId("myArchive");
			// favoritesGroup.setName("MyArchive");
			// favoritesSet.setArchive(favoritesGroup);
			//
			// favoritesGroup = RcplFactory.eINSTANCE.createFavoritesGroup();
			// favoritesGroup.setId("myDownloads");
			// favoritesGroup.setName("MyDownloads");
			// favoritesSet.setDownloads(favoritesGroup);
			//
			// favoritesGroup = RcplFactory.eINSTANCE.createFavoritesGroup();
			// favoritesGroup.setId("myFavorites");
			// favoritesGroup.setName("MyFavorites");
			// favoritesSet.setFavorites(favoritesGroup);
			//
			// favoritesGroup = RcplFactory.eINSTANCE.createFavoritesGroup();
			// favoritesGroup.setId("myHistory");
			// favoritesGroup.setName("MyHistory");
			// favoritesSet.setHistory(favoritesGroup);

		}

	}

	// for (int i = 0; i < getSession().getContents().size(); i++) {
	// if (getSession().getContents().get(i) instanceof JOIT) {
	// found = true;
	// break;
	// }
	// }
	//
	// if (!found) {
	// JOIT joit = SdFactory.eINSTANCE.createJOIT();
	// getSession().getContents().add(joit);
	// }

	// removeGroupFromTopBar(EPerspectiveType.WORD,
	// "topBar/paragraphProperties");
	// addGroupToTopBar(EPerspectiveType.WORD, "topBar/paragraphProperties",
	// 2);
	// removeGroupFromSideBar(EPerspectiveType.WORD, "sideBar/clipboard");
	// removeGroupFromSideBar(EPerspectiveType.WORD, "sideBar/tools");
	// addGroupToSideBar(EPerspectiveType.WORD, "sideBar/open", 0);
	// addGroupToSideBar(EPerspectiveType.WORD, "sideBar/print", 1);
	// addGroupToSideBar(EPerspectiveType.WORD, "sideBar/equations", 14);
	// addGroupToSideBar(EPerspectiveType.WORD, "sideBar/clipboard", 15);
	// addGroupToSideBar(EPerspectiveType.WORD, "sideBar/tools", 16);
	// addGroupToSideBar(EPerspectiveType.WORD, "sideBar/mail", 17);
	// addGroupToSideBar(EPerspectiveType.WORD, "sideBar/view", 18);

	// JO.UIC.findUsecase(JOModel.USE_CASE_TOOLS).getEUseCase()
	// .setName("Configure Tools");
}
