/**
 */
package org.eclipse.rcpl.model_2_0_0.rcpl;

import org.eclipse.emf.common.util.EList;


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
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.HomePage#getDocuments <em>Documents</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.HomePage#getTextReplacements <em>Text Replacements</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.HomePage#isNavigator <em>Navigator</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.HomePage#isShowHomePageButtons <em>Show Home Page Buttons</em>}</li>
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

	/**
	 * Returns the value of the '<em><b>Documents</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.rcpl.model_2_0_0.rcpl.Document}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Documents</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Documents</em>' reference list.
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getHomePage_Documents()
	 * @model
	 * @generated
	 */
	EList<Document> getDocuments();

	/**
	 * Returns the value of the '<em><b>Text Replacements</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.rcpl.model_2_0_0.rcpl.KeyValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text Replacements</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text Replacements</em>' reference list.
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getHomePage_TextReplacements()
	 * @model
	 * @generated
	 */
	EList<KeyValue> getTextReplacements();

	/**
	 * Returns the value of the '<em><b>Navigator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Navigator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Navigator</em>' attribute.
	 * @see #setNavigator(boolean)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getHomePage_Navigator()
	 * @model
	 * @generated
	 */
	boolean isNavigator();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.HomePage#isNavigator <em>Navigator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Navigator</em>' attribute.
	 * @see #isNavigator()
	 * @generated
	 */
	void setNavigator(boolean value);

	/**
	 * Returns the value of the '<em><b>Show Home Page Buttons</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Show Home Page Buttons</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Show Home Page Buttons</em>' attribute.
	 * @see #setShowHomePageButtons(boolean)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getHomePage_ShowHomePageButtons()
	 * @model
	 * @generated
	 */
	boolean isShowHomePageButtons();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.HomePage#isShowHomePageButtons <em>Show Home Page Buttons</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Show Home Page Buttons</em>' attribute.
	 * @see #isShowHomePageButtons()
	 * @generated
	 */
	void setShowHomePageButtons(boolean value);
} // HomePage
