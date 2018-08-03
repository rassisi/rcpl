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

package org.eclipse.rcpl.navigator.details;

import java.util.Locale;

import org.eclipse.rcpl.detailpages.AbstractModelDetailPage;
import org.eclipse.rcpl.detailpages.InputFieldLocale;
import org.eclipse.rcpl.model.client.RcplSession;
import org.eclipse.rcpl.model_2_0_0.rcpl.Preference;
import org.eclipse.rcpl.model_2_0_0.rcpl.PreferenceGroup;
import org.eclipse.rcpl.model_2_0_0.rcpl.Preferences;
import org.eclipse.rcpl.navigator.IModelDetailPageControler;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/**
 * @author ramin
 *
 */
public class PreferencesDetailsPage extends AbstractModelDetailPage {

	/**
	 * @param preferences
	 */
	public PreferencesDetailsPage() {

	}

	/**
	 * @param pref
	 * @return
	 */
	private String getDisplayName(Preferences prefs) {
		if (prefs.getName() != null && prefs.getName().length() > 0) {
			return prefs.getName();
		}
		return prefs.getId();
	}

	/**
	 * @param pref
	 * @return
	 */
	private String getDisplayName(Preference pref) {
		if (pref.getName() != null && pref.getName().length() > 0) {
			return pref.getName();
		}
		return pref.getId();
	}

	private Node createEditor(Preference pref) {
		String type = "java.lang.String";
		if (pref.getType() != null) {
			type = pref.getType();
		}

		try {
			Class<?> cl = Class.forName(type);

			if (cl == Locale.class) {
				return new InputFieldLocale(pref.getValue());
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block

		}

		return new TextField(pref.getValue());

	}

	@Override
	public IModelDetailPageControler getControler() {
		return null;
	}

	@Override
	protected IModelDetailPageControler createControler() {
		return new PreferenceDetailsControler();
	}

	@Override
	public void create(StackPane stackPane) {
		GridPane node = new GridPane();

		Preferences preferences = RcplSession.getDefault().getRcpl().getAllPreferences();
		Label l = new Label(getDisplayName(preferences));
		l.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 20));
		node.add(l, 0, 0);
		GridPane.setColumnSpan(l, 2);
		l.setPadding(new Insets(10, 0, 30, 10));
		int rowIndex = 1;

		for (PreferenceGroup g : preferences.getChildren()) {
			for (Preference pref : g.getPreferences()) {
				l = new Label(getDisplayName(pref));
				l.setPadding(new Insets(10));
				l.setAlignment(Pos.TOP_LEFT);

				// getNode().setAlignment(Pos.TOP_LEFT);
				GridPane.setValignment(l, VPos.TOP);
				node.add(l, 0, rowIndex);
				Node editor = createEditor(pref);
				node.add(editor, 1, rowIndex);
				rowIndex++;
			}
		}
		stackPane.getChildren().add(node);
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		return "Preferences";
	}

}
