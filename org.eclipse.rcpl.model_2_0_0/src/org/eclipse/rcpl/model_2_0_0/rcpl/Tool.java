/**
 */
package org.eclipse.rcpl.model_2_0_0.rcpl;

import java.util.ArrayList;
import java.util.List;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Tool</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.Tool#getFormat <em>Format</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getTool()
 * @model
 * @generated
 */
public interface Tool extends AbstractTool {
	/**
	 * Returns the value of the '<em><b>Format</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Format</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Format</em>' attribute.
	 * @see #setFormat(String)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getTool_Format()
	 * @model
	 * @generated
	 */
	String getFormat();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.Tool#getFormat <em>Format</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Format</em>' attribute.
	 * @see #getFormat()
	 * @generated
	 */
	void setFormat(String value);

	/**
	 * @return
	 * @generated NOT
	 */
	static List<String> ids = new ArrayList<String>();

	String getFormatValue(String key);

	/**
	 * @param key
	 * @return
	 * @generated NOT
	 */
	int getIntFormatValue(String key);

	/**
	 * @param key
	 * @return
	 * @generated NOT
	 */
	double getDoubleFormatValue(String key);

	/**
	 * @param key
	 * @return
	 * @generated NOT
	 */
	public boolean getBooleanFormatValue(String key);

} // Tool
