package org.eclipse.rcpl;

public enum EnContext {

	INFOTAB, WORD, SPREADSHEET, PRESENTATION;

	public enum TabContext {
		OPEN, HOMESITE, FORUM, CONTACT_US, HELP_CONTENT, ACTIVATE;

	}

	private TabContext tabContext;

	public TabContext getTabContext() {
		return tabContext;
	}

	public void setTabContext(TabContext tabContext) {
		this.tabContext = tabContext;
	}

}
