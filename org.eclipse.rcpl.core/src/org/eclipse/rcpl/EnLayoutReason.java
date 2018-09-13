package org.eclipse.rcpl;

/**
 * @author ramin
 *
 */
public enum EnLayoutReason {

	INITIAL_LAYOUT, EDITING_LAYOUT;

	private ILayoutObject dirtyLayoutObject;

	public EnLayoutReason setDirtyLayoutObject(ILayoutObject layoutObject) {
		this.dirtyLayoutObject = layoutObject;
		return this;
	}

	public ILayoutObject getDirtyLayoutObject() {
		return dirtyLayoutObject;
	}

}
