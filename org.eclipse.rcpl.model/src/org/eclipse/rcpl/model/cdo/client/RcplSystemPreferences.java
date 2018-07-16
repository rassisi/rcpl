package org.eclipse.rcpl.model.cdo.client;

import org.eclipse.net4j.internal.util.om.pref.Preference;
import org.eclipse.rcpl.model_2_0_0.rcpl.PreferenceGroup;
import org.eclipse.rcpl.model_2_0_0.rcpl.Preferences;
import org.eclipse.rcpl.model_2_0_0.rcpl.RcplFactory;

public class RcplSystemPreferences extends RcplAbstractPreferences {

	public RcplSystemPreferences() {
		init();
	}

	public void init() {
		if (isEmpty()) {
			put(RcplKey.TOOL_SIDEBAR_WIDTH, 250);
			put(RcplKey.TOOL_SIDEBAR_HEIGHT, 550);
		}
	}

	public double getToolSideBarWidth() {
		return getDouble(RcplKey.TOOL_SIDEBAR_WIDTH);
	}

	public double getToolSideBarHeight() {
		return getDouble(RcplKey.TOOL_SIDEBAR_HEIGHT);
	}

	public void setLastDocument(String doc) {
		put(RcplKey.LAST_OPENED_DOCUMENT, doc);
	}

	public String getLastDocument() {
		return getString(RcplKey.LAST_OPENED_DOCUMENT);
	}

	@Override
	public PreferenceGroup getPreferenceGroup() {
		Preferences prefs = RcplSession.getDefault().getRcpl().getAllPreferences();
		PreferenceGroup userPreferences = null;
		for (PreferenceGroup g : prefs.getChildren()) {
			if (SYSTEM_PREFERENCES.equals(g.getId())) {
				return g;
			}
		}
		userPreferences = RcplFactory.eINSTANCE.createPreferenceGroup();
		userPreferences.setId(SYSTEM_PREFERENCES);
		prefs.getChildren().add(userPreferences);
		RcplSession.getDefault().commit();
		return userPreferences;

	}
}
