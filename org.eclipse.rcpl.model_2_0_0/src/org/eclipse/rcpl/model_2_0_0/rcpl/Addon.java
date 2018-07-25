/**
 */
package org.eclipse.rcpl.model_2_0_0.rcpl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Addon</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.Addon#getBundleId <em>Bundle Id</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.Addon#getClassName <em>Class Name</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.Addon#getRoles <em>Roles</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.Addon#getUsers <em>Users</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.Addon#getGroups <em>Groups</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.Addon#isIsPerspective <em>Is Perspective</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.Addon#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.Addon#getDefaultPerspective <em>Default Perspective</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.Addon#getPerspectives <em>Perspectives</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.Addon#getRootClassName <em>Root Class Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getAddon()
 * @model
 * @generated
 */
public interface Addon extends Layoutable {
	/**
	 * Returns the value of the '<em><b>Bundle Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bundle Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bundle Id</em>' attribute.
	 * @see #setBundleId(String)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getAddon_BundleId()
	 * @model
	 * @generated
	 */
	String getBundleId();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.Addon#getBundleId <em>Bundle Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bundle Id</em>' attribute.
	 * @see #getBundleId()
	 * @generated
	 */
	void setBundleId(String value);

	/**
	 * Returns the value of the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Name</em>' attribute.
	 * @see #setClassName(String)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getAddon_ClassName()
	 * @model
	 * @generated
	 */
	String getClassName();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.Addon#getClassName <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class Name</em>' attribute.
	 * @see #getClassName()
	 * @generated
	 */
	void setClassName(String value);

	/**
	 * Returns the value of the '<em><b>Roles</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Roles</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Roles</em>' attribute list.
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getAddon_Roles()
	 * @model
	 * @generated
	 */
	EList<String> getRoles();

	/**
	 * Returns the value of the '<em><b>Users</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Users</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Users</em>' attribute list.
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getAddon_Users()
	 * @model
	 * @generated
	 */
	EList<String> getUsers();

	/**
	 * Returns the value of the '<em><b>Groups</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Groups</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Groups</em>' attribute list.
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getAddon_Groups()
	 * @model
	 * @generated
	 */
	EList<String> getGroups();

	/**
	 * Returns the value of the '<em><b>Is Perspective</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Perspective</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Perspective</em>' attribute.
	 * @see #setIsPerspective(boolean)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getAddon_IsPerspective()
	 * @model
	 * @generated
	 */
	boolean isIsPerspective();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.Addon#isIsPerspective <em>Is Perspective</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Perspective</em>' attribute.
	 * @see #isIsPerspective()
	 * @generated
	 */
	void setIsPerspective(boolean value);

	/**
	 * Returns the value of the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Read Only</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Read Only</em>' attribute.
	 * @see #setReadOnly(boolean)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getAddon_ReadOnly()
	 * @model
	 * @generated
	 */
	boolean isReadOnly();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.Addon#isReadOnly <em>Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Read Only</em>' attribute.
	 * @see #isReadOnly()
	 * @generated
	 */
	void setReadOnly(boolean value);

	/**
	 * Returns the value of the '<em><b>Default Perspective</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Perspective</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Perspective</em>' reference.
	 * @see #setDefaultPerspective(Perspective)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getAddon_DefaultPerspective()
	 * @model required="true"
	 * @generated
	 */
	Perspective getDefaultPerspective();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.Addon#getDefaultPerspective <em>Default Perspective</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Perspective</em>' reference.
	 * @see #getDefaultPerspective()
	 * @generated
	 */
	void setDefaultPerspective(Perspective value);

	/**
	 * Returns the value of the '<em><b>Perspectives</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.rcpl.model_2_0_0.rcpl.Perspective}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Perspectives</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Perspectives</em>' reference list.
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getAddon_Perspectives()
	 * @model
	 * @generated
	 */
	EList<Perspective> getPerspectives();

	/**
	 * Returns the value of the '<em><b>Root Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root Class Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root Class Name</em>' attribute.
	 * @see #setRootClassName(String)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getAddon_RootClassName()
	 * @model
	 * @generated
	 */
	String getRootClassName();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.Addon#getRootClassName <em>Root Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root Class Name</em>' attribute.
	 * @see #getRootClassName()
	 * @generated
	 */
	void setRootClassName(String value);

} // Addon
