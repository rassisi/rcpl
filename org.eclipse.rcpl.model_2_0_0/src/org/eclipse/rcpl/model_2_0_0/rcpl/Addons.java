/**
 */
package org.eclipse.rcpl.model_2_0_0.rcpl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Addons</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.Addons#getChildren <em>Children</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getAddons()
 * @model
 * @generated
 */
public interface Addons extends Layoutable {
	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcpl.model_2_0_0.rcpl.Addon}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getAddons_Children()
	 * @model containment="true"
	 * @generated
	 */
	EList<Addon> getChildren();

} // Addons
