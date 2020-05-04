/**
 */
package org.eclipse.rcpl.model_2_0_0.rcpl.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.rcpl.model_2_0_0.rcpl.Document;
import org.eclipse.rcpl.model_2_0_0.rcpl.HomePage;
import org.eclipse.rcpl.model_2_0_0.rcpl.HomePageType;
import org.eclipse.rcpl.model_2_0_0.rcpl.KeyValue;
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
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.HomePageImpl#getDocuments <em>Documents</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.HomePageImpl#getTextReplacements <em>Text Replacements</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.HomePageImpl#isNavigator <em>Navigator</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.HomePageImpl#isShowHomePageButtons <em>Show Home Page Buttons</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.HomePageImpl#getRootClassName <em>Root Class Name</em>}</li>
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
	@Override
	public HomePageType getType() {
		return (HomePageType)eGet(RcplPackage.Literals.HOME_PAGE__TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(HomePageType newType) {
		eSet(RcplPackage.Literals.HOME_PAGE__TYPE, newType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Perspective getPerspective() {
		return (Perspective)eGet(RcplPackage.Literals.HOME_PAGE__PERSPECTIVE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPerspective(Perspective newPerspective) {
		eSet(RcplPackage.Literals.HOME_PAGE__PERSPECTIVE, newPerspective);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Document> getDocuments() {
		return (EList<Document>)eGet(RcplPackage.Literals.HOME_PAGE__DOCUMENTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<KeyValue> getTextReplacements() {
		return (EList<KeyValue>)eGet(RcplPackage.Literals.HOME_PAGE__TEXT_REPLACEMENTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isNavigator() {
		return (Boolean)eGet(RcplPackage.Literals.HOME_PAGE__NAVIGATOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNavigator(boolean newNavigator) {
		eSet(RcplPackage.Literals.HOME_PAGE__NAVIGATOR, newNavigator);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isShowHomePageButtons() {
		return (Boolean)eGet(RcplPackage.Literals.HOME_PAGE__SHOW_HOME_PAGE_BUTTONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setShowHomePageButtons(boolean newShowHomePageButtons) {
		eSet(RcplPackage.Literals.HOME_PAGE__SHOW_HOME_PAGE_BUTTONS, newShowHomePageButtons);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getRootClassName() {
		return (String)eGet(RcplPackage.Literals.HOME_PAGE__ROOT_CLASS_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRootClassName(String newRootClassName) {
		eSet(RcplPackage.Literals.HOME_PAGE__ROOT_CLASS_NAME, newRootClassName);
	}

} //HomePageImpl
