/**
 */
package org.eclipse.rcpl.model_2_0_0.rcpl.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import org.eclipse.rcpl.model_2_0_0.rcpl.NavigatorItem;
import org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Navigator Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.NavigatorItemImpl#getAdaptFrom <em>Adapt From</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.NavigatorItemImpl#getAdaptTo <em>Adapt To</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NavigatorItemImpl extends CDOObjectImpl implements NavigatorItem {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NavigatorItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RcplPackage.Literals.NAVIGATOR_ITEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getAdaptFrom() {
		return (String)eGet(RcplPackage.Literals.NAVIGATOR_ITEM__ADAPT_FROM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAdaptFrom(String newAdaptFrom) {
		eSet(RcplPackage.Literals.NAVIGATOR_ITEM__ADAPT_FROM, newAdaptFrom);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getAdaptTo() {
		return (String)eGet(RcplPackage.Literals.NAVIGATOR_ITEM__ADAPT_TO, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAdaptTo(String newAdaptTo) {
		eSet(RcplPackage.Literals.NAVIGATOR_ITEM__ADAPT_TO, newAdaptTo);
	}

} //NavigatorItemImpl
