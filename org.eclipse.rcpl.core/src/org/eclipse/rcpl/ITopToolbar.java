package org.eclipse.rcpl;

/**
 * @author ramin
 *
 */
public interface ITopToolbar extends IToolbar {

	void updateHeight();

	void init();

	void collapse(boolean collapse);

	void expandAll();

	void hideAll();

}
