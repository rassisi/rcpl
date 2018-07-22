/**
 */
package org.eclipse.rcpl.model_2_0_0.rcpl;

import org.eclipse.emf.cdo.CDOObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Key Values</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.KeyValues#getKeyvalues <em>Keyvalues</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getKeyValues()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface KeyValues extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Keyvalues</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcpl.model_2_0_0.rcpl.KeyValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Keyvalues</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Keyvalues</em>' containment reference list.
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getKeyValues_Keyvalues()
	 * @model containment="true"
	 * @generated
	 */
	EList<KeyValue> getKeyvalues();

} // KeyValues
