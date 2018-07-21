/**
 */
package org.eclipse.rcpl.model_2_0_0.rcpl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Home Page</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.HomePage#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.HomePage#getPerspective <em>Perspective</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getHomePage()
 * @model
 * @generated
 */
public interface HomePage extends Layoutable {

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.rcpl.model_2_0_0.rcpl.HomePageType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.HomePageType
	 * @see #setType(HomePageType)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getHomePage_Type()
	 * @model
	 * @generated
	 */
	HomePageType getType();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.HomePage#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.HomePageType
	 * @see #getType()
	 * @generated
	 */
	void setType(HomePageType value);

	/**
	 * Returns the value of the '<em><b>Perspective</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Perspective</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Perspective</em>' reference.
	 * @see #setPerspective(Perspective)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getHomePage_Perspective()
	 * @model
	 * @generated
	 */
	Perspective getPerspective();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.HomePage#getPerspective <em>Perspective</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Perspective</em>' reference.
	 * @see #getPerspective()
	 * @generated
	 */
	void setPerspective(Perspective value);
} // HomePage
