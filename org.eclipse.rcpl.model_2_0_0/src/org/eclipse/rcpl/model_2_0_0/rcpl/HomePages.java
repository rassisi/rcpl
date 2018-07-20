/**
 */
package org.eclipse.rcpl.model_2_0_0.rcpl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Home Pages</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.HomePages#getHomepage <em>Homepage</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getHomePages()
 * @model
 * @generated
 */
public interface HomePages extends Layoutable {
	/**
	 * Returns the value of the '<em><b>Homepage</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.rcpl.model_2_0_0.rcpl.HomePage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Homepage</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Homepage</em>' reference list.
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getHomePages_Homepage()
	 * @model
	 * @generated
	 */
	EList<HomePage> getHomepage();

} // HomePages
