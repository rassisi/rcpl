package org.eclipse.rcpl;

/**
 * @author ramin
 *
 */
public enum EnLayoutReason {

	INITIAL_LAYOUT,

	EDITING_LAYOUT,

	EDITING_SHRINGING,

	EDITING_EXPANDING,

	/**
	 * editing happpend in an overflow paragraph with expansion
	 */
	EDITING_EXPANDING_OVERFLOW,

	EDITING_EXPANDING_BEFOREBREAK,

	EDITING_EXPANDING_BREAK_AFTER,

	TEST_LAYOUT;

}
