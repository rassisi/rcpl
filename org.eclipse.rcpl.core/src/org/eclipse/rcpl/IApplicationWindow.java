package org.eclipse.rcpl;

import java.util.List;

/**
 * @author Ramin
 *
 */
public interface IApplicationWindow {

	void resetStyles();

	List<String> getStyleSheets();

	void setResizable(boolean resizable);

	void setMinimizable(boolean minimizable);

	void setMaximizable(boolean maximizable);

	void setFullscreenAble(boolean fullscreenAble);

}
