/**
 */
package org.eclipse.rcpl.model_2_0_0.rcpl;

import org.eclipse.emf.cdo.CDOObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Navigator Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.NavigatorItem#getAdaptFrom <em>Adapt From</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.NavigatorItem#getAdaptTo <em>Adapt To</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getNavigatorItem()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface NavigatorItem extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Adapt From</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Adapt From</em>' attribute.
	 * @see #setAdaptFrom(String)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getNavigatorItem_AdaptFrom()
	 * @model
	 * @generated
	 */
	String getAdaptFrom();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.NavigatorItem#getAdaptFrom <em>Adapt From</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Adapt From</em>' attribute.
	 * @see #getAdaptFrom()
	 * @generated
	 */
	void setAdaptFrom(String value);

	/**
	 * Returns the value of the '<em><b>Adapt To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Adapt To</em>' attribute.
	 * @see #setAdaptTo(String)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getNavigatorItem_AdaptTo()
	 * @model
	 * @generated
	 */
	String getAdaptTo();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.NavigatorItem#getAdaptTo <em>Adapt To</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Adapt To</em>' attribute.
	 * @see #getAdaptTo()
	 * @generated
	 */
	void setAdaptTo(String value);

} // NavigatorItem
