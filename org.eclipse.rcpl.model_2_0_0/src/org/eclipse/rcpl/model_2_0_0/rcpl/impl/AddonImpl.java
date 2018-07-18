/**
 */
package org.eclipse.rcpl.model_2_0_0.rcpl.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.rcpl.model_2_0_0.rcpl.Addon;
import org.eclipse.rcpl.model_2_0_0.rcpl.Perspective;
import org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Addon</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.AddonImpl#getBundleId <em>Bundle Id</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.AddonImpl#getClassName <em>Class Name</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.AddonImpl#getRoles <em>Roles</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.AddonImpl#getUsers <em>Users</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.AddonImpl#getGroups <em>Groups</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.AddonImpl#isIsPerspective <em>Is Perspective</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.AddonImpl#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.AddonImpl#getDefaultPerspective <em>Default Perspective</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.AddonImpl#getPerspectives <em>Perspectives</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AddonImpl extends LayoutableImpl implements Addon {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AddonImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RcplPackage.Literals.ADDON;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBundleId() {
		return (String)eGet(RcplPackage.Literals.ADDON__BUNDLE_ID, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBundleId(String newBundleId) {
		eSet(RcplPackage.Literals.ADDON__BUNDLE_ID, newBundleId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClassName() {
		return (String)eGet(RcplPackage.Literals.ADDON__CLASS_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassName(String newClassName) {
		eSet(RcplPackage.Literals.ADDON__CLASS_NAME, newClassName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getRoles() {
		return (EList<String>)eGet(RcplPackage.Literals.ADDON__ROLES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getUsers() {
		return (EList<String>)eGet(RcplPackage.Literals.ADDON__USERS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getGroups() {
		return (EList<String>)eGet(RcplPackage.Literals.ADDON__GROUPS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsPerspective() {
		return (Boolean)eGet(RcplPackage.Literals.ADDON__IS_PERSPECTIVE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsPerspective(boolean newIsPerspective) {
		eSet(RcplPackage.Literals.ADDON__IS_PERSPECTIVE, newIsPerspective);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReadOnly() {
		return (Boolean)eGet(RcplPackage.Literals.ADDON__READ_ONLY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReadOnly(boolean newReadOnly) {
		eSet(RcplPackage.Literals.ADDON__READ_ONLY, newReadOnly);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Perspective getDefaultPerspective() {
		return (Perspective)eGet(RcplPackage.Literals.ADDON__DEFAULT_PERSPECTIVE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultPerspective(Perspective newDefaultPerspective) {
		eSet(RcplPackage.Literals.ADDON__DEFAULT_PERSPECTIVE, newDefaultPerspective);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Perspective> getPerspectives() {
		return (EList<Perspective>)eGet(RcplPackage.Literals.ADDON__PERSPECTIVES, true);
	}

} //AddonImpl
