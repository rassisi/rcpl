package org.eclipse.rcpl;

/**
 * @author ramin
 *
 */
public interface ILoginController {

	void init();

	void setErrorInUserId();

	void setHeaderText(String text);

	void handleGuest();

	void reset();

	void enableButtons();

}
