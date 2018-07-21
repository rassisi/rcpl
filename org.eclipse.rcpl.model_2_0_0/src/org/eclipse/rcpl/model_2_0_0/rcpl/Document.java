/**
 */
package org.eclipse.rcpl.model_2_0_0.rcpl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Document</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.Document#getPath <em>Path</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.Document#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getDocument()
 * @model
 * @generated
 */
public interface Document extends Layoutable {
	/**
	 * Returns the value of the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' attribute.
	 * @see #setPath(String)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getDocument_Path()
	 * @model
	 * @generated
	 */
	String getPath();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.Document#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>"TEXT"</code>.
	 * The literals are from the enumeration {@link org.eclipse.rcpl.model_2_0_0.rcpl.DocumentType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.DocumentType
	 * @see #setType(DocumentType)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getDocument_Type()
	 * @model default="TEXT"
	 * @generated
	 */
	DocumentType getType();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.Document#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.DocumentType
	 * @see #getType()
	 * @generated
	 */
	void setType(DocumentType value);

} // Document
