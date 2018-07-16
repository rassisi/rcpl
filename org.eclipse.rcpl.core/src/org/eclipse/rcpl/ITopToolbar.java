package org.eclipse.rcpl;

/**
 * @author ramin
 *
 */
public interface ITopToolbar {

	void processTopBarMainGroups(IRcplAddon useCase);

	void updateHeight();

	void show(IRcplAddon activeUseCase);

	void show(String type);

	void init();

	void collapse(boolean collapse);

	void expandAll();

	void hideAll();;

	void updateUseCaseHeight();

	void setEditor(IEditor editor);

}
