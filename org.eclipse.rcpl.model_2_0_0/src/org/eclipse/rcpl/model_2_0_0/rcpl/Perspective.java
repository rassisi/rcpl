/**
 */
package org.eclipse.rcpl.model_2_0_0.rcpl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Perspective</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.Perspective#getSideToolBar <em>Side Tool Bar</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.Perspective#getTopToolBar <em>Top Tool Bar</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.Perspective#getQuickToolBar <em>Quick Tool Bar</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.Perspective#getRibbonToolBar <em>Ribbon Tool Bar</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getPerspective()
 * @model
 * @generated
 */
public interface Perspective extends Layoutable {
	/**
	 * Returns the value of the '<em><b>Side Tool Bar</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Side Tool Bar</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Side Tool Bar</em>' containment reference.
	 * @see #setSideToolBar(SideToolBar)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getPerspective_SideToolBar()
	 * @model containment="true" required="true"
	 * @generated
	 */
	SideToolBar getSideToolBar();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.Perspective#getSideToolBar <em>Side Tool Bar</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Side Tool Bar</em>' containment reference.
	 * @see #getSideToolBar()
	 * @generated
	 */
	void setSideToolBar(SideToolBar value);

	/**
	 * Returns the value of the '<em><b>Top Tool Bar</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Top Tool Bar</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Top Tool Bar</em>' containment reference.
	 * @see #setTopToolBar(TopToolBar)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getPerspective_TopToolBar()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TopToolBar getTopToolBar();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.Perspective#getTopToolBar <em>Top Tool Bar</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Top Tool Bar</em>' containment reference.
	 * @see #getTopToolBar()
	 * @generated
	 */
	void setTopToolBar(TopToolBar value);

	/**
	 * Returns the value of the '<em><b>Quick Tool Bar</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Quick Tool Bar</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quick Tool Bar</em>' reference.
	 * @see #setQuickToolBar(QuickToolBar)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getPerspective_QuickToolBar()
	 * @model required="true"
	 * @generated
	 */
	QuickToolBar getQuickToolBar();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.Perspective#getQuickToolBar <em>Quick Tool Bar</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quick Tool Bar</em>' reference.
	 * @see #getQuickToolBar()
	 * @generated
	 */
	void setQuickToolBar(QuickToolBar value);

	/**
	 * Returns the value of the '<em><b>Ribbon Tool Bar</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ribbon Tool Bar</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ribbon Tool Bar</em>' containment reference.
	 * @see #setRibbonToolBar(RibbonToolBar)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getPerspective_RibbonToolBar()
	 * @model containment="true" required="true"
	 * @generated
	 */
	RibbonToolBar getRibbonToolBar();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.Perspective#getRibbonToolBar <em>Ribbon Tool Bar</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ribbon Tool Bar</em>' containment reference.
	 * @see #getRibbonToolBar()
	 * @generated
	 */
	void setRibbonToolBar(RibbonToolBar value);

} // Perspective
