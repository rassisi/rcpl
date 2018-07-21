/**
 */
package org.eclipse.rcpl.model_2_0_0.rcpl.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.rcpl.model_2_0_0.rcpl.HomePage;
import org.eclipse.rcpl.model_2_0_0.rcpl.HomePageType;
import org.eclipse.rcpl.model_2_0_0.rcpl.Perspective;
import org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Home Page</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.HomePageImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.HomePageImpl#getPerspective <em>Perspective</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HomePageImpl extends LayoutableImpl implements HomePage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HomePageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RcplPackage.Literals.HOME_PAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HomePageType getType() {
		return (HomePageType)eGet(RcplPackage.Literals.HOME_PAGE__TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(HomePageType newType) {
		eSet(RcplPackage.Literals.HOME_PAGE__TYPE, newType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Perspective getPerspective() {
		return (Perspective)eGet(RcplPackage.Literals.HOME_PAGE__PERSPECTIVE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPerspective(Perspective newPerspective) {
		eSet(RcplPackage.Literals.HOME_PAGE__PERSPECTIVE, newPerspective);
	}

} //HomePageImpl
