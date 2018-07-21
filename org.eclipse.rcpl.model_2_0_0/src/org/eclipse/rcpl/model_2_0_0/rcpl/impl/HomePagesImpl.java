/**
 */
package org.eclipse.rcpl.model_2_0_0.rcpl.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.rcpl.model_2_0_0.rcpl.HomePage;
import org.eclipse.rcpl.model_2_0_0.rcpl.HomePages;
import org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Home Pages</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.HomePagesImpl#getChildren <em>Children</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HomePagesImpl extends LayoutableImpl implements HomePages {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HomePagesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RcplPackage.Literals.HOME_PAGES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<HomePage> getChildren() {
		return (EList<HomePage>)eGet(RcplPackage.Literals.HOME_PAGES__CHILDREN, true);
	}

} //HomePagesImpl
