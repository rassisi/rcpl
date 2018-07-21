/**
 */
package org.eclipse.rcpl.model_2_0_0.rcpl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Documents</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.Documents#getChildren <em>Children</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getDocuments()
 * @model
 * @generated
 */
public interface Documents extends Layoutable {
	/**
	 * Returns the value of the '<em><b>Children</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.rcpl.model_2_0_0.rcpl.Document}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' reference list.
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getDocuments_Children()
	 * @model
	 * @generated
	 */
	EList<Document> getChildren();

} // Documents
