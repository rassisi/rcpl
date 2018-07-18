/**
 */
package org.eclipse.rcpl.model_2_0_0.rcpl.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.rcpl.model_2_0_0.rcpl.Addon;
import org.eclipse.rcpl.model_2_0_0.rcpl.Addons;
import org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Addons</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.AddonsImpl#getChildren <em>Children</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AddonsImpl extends LayoutableImpl implements Addons {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AddonsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RcplPackage.Literals.ADDONS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Addon> getChildren() {
		return (EList<Addon>)eGet(RcplPackage.Literals.ADDONS__CHILDREN, true);
	}

} //AddonsImpl
