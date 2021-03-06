package org.eclipse.rcpl;

/**
 * @author Ramin
 *
 */
public interface IProperty2 {

	Object get();

	boolean set(Object data);

	boolean isTemporary();

	/**
	 * set all XmlObjects to null (make it temporary)
	 */
	void clear();

}
