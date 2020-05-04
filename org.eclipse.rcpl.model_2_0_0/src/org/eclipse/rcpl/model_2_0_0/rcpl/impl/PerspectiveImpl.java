/**
 */
package org.eclipse.rcpl.model_2_0_0.rcpl.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.rcpl.model_2_0_0.rcpl.Perspective;
import org.eclipse.rcpl.model_2_0_0.rcpl.QuickToolBar;
import org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage;
import org.eclipse.rcpl.model_2_0_0.rcpl.RibbonToolBar;
import org.eclipse.rcpl.model_2_0_0.rcpl.SideToolBar;
import org.eclipse.rcpl.model_2_0_0.rcpl.TopToolBar;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Perspective</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.PerspectiveImpl#getSideToolBar <em>Side Tool Bar</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.PerspectiveImpl#getTopToolBar <em>Top Tool Bar</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.PerspectiveImpl#getQuickToolBar <em>Quick Tool Bar</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.PerspectiveImpl#getRibbonToolBar <em>Ribbon Tool Bar</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.PerspectiveImpl#isOverview <em>Overview</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PerspectiveImpl extends LayoutableImpl implements Perspective {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PerspectiveImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RcplPackage.Literals.PERSPECTIVE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SideToolBar getSideToolBar() {
		return (SideToolBar)eGet(RcplPackage.Literals.PERSPECTIVE__SIDE_TOOL_BAR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSideToolBar(SideToolBar newSideToolBar) {
		eSet(RcplPackage.Literals.PERSPECTIVE__SIDE_TOOL_BAR, newSideToolBar);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TopToolBar getTopToolBar() {
		return (TopToolBar)eGet(RcplPackage.Literals.PERSPECTIVE__TOP_TOOL_BAR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTopToolBar(TopToolBar newTopToolBar) {
		eSet(RcplPackage.Literals.PERSPECTIVE__TOP_TOOL_BAR, newTopToolBar);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public QuickToolBar getQuickToolBar() {
		return (QuickToolBar)eGet(RcplPackage.Literals.PERSPECTIVE__QUICK_TOOL_BAR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQuickToolBar(QuickToolBar newQuickToolBar) {
		eSet(RcplPackage.Literals.PERSPECTIVE__QUICK_TOOL_BAR, newQuickToolBar);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RibbonToolBar getRibbonToolBar() {
		return (RibbonToolBar)eGet(RcplPackage.Literals.PERSPECTIVE__RIBBON_TOOL_BAR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRibbonToolBar(RibbonToolBar newRibbonToolBar) {
		eSet(RcplPackage.Literals.PERSPECTIVE__RIBBON_TOOL_BAR, newRibbonToolBar);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isOverview() {
		return (Boolean)eGet(RcplPackage.Literals.PERSPECTIVE__OVERVIEW, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOverview(boolean newOverview) {
		eSet(RcplPackage.Literals.PERSPECTIVE__OVERVIEW, newOverview);
	}

} //PerspectiveImpl
