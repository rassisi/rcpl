package org.eclipse.rcpl;

import javafx.scene.control.ButtonBase;

/**
 * @author ramin
 *
 */
public interface IButton extends ITool {

	String DEFAUL_TOOLBUTTON_CSS_ID = "toolButton";

	@Override
	ButtonBase getNode();

	void reset();

	void setSelected(boolean selected);

	@Override
	void setVisible(boolean visible);

	void setDisable(boolean disable);

	void setWidth(double width);

	void setHeight(double height);

	void doAction();

	void disableService();

}
