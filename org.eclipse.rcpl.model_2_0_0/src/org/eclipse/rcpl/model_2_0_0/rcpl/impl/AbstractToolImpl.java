/**
 */
package org.eclipse.rcpl.model_2_0_0.rcpl.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool;
import org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage;
import org.eclipse.rcpl.model_2_0_0.rcpl.ToolGroup;
import org.eclipse.rcpl.model_2_0_0.rcpl.ToolType;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Abstract Tool</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.AbstractToolImpl#getX
 * <em>X</em>}</li>
 * <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.AbstractToolImpl#getY
 * <em>Y</em>}</li>
 * <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.AbstractToolImpl#getWidth
 * <em>Width</em>}</li>
 * <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.AbstractToolImpl#getHeight
 * <em>Height</em>}</li>
 * <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.AbstractToolImpl#getGridX
 * <em>Grid X</em>}</li>
 * <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.AbstractToolImpl#getGridY
 * <em>Grid Y</em>}</li>
 * <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.AbstractToolImpl#getSpanX
 * <em>Span X</em>}</li>
 * <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.AbstractToolImpl#getSpanY
 * <em>Span Y</em>}</li>
 * <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.AbstractToolImpl#isLabeled
 * <em>Labeled</em>}</li>
 * <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.AbstractToolImpl#isNotImplemented
 * <em>Not Implemented</em>}</li>
 * <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.AbstractToolImpl#getService
 * <em>Service</em>}</li>
 * <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.AbstractToolImpl#getDetailPaneClassName
 * <em>Detail Pane Class Name</em>}</li>
 * <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.AbstractToolImpl#getType
 * <em>Type</em>}</li>
 * <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.AbstractToolImpl#isSystem
 * <em>System</em>}</li>
 * <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.AbstractToolImpl#getUrl
 * <em>Url</em>}</li>
 * <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.AbstractToolImpl#isToggleGroup
 * <em>Toggle Group</em>}</li>
 * <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.AbstractToolImpl#getExpandToolGroup
 * <em>Expand Tool Group</em>}</li>
 * <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.AbstractToolImpl#isHGrow
 * <em>HGrow</em>}</li>
 * <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.AbstractToolImpl#isVGrow
 * <em>VGrow</em>}</li>
 * <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.AbstractToolImpl#getWidthPercent
 * <em>Width Percent</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractToolImpl extends LayoutableImpl implements AbstractTool {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected AbstractToolImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RcplPackage.Literals.ABSTRACT_TOOL;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public double getX() {
		return (Double) eGet(RcplPackage.Literals.ABSTRACT_TOOL__X, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setX(double newX) {
		eSet(RcplPackage.Literals.ABSTRACT_TOOL__X, newX);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public double getY() {
		return (Double) eGet(RcplPackage.Literals.ABSTRACT_TOOL__Y, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setY(double newY) {
		eSet(RcplPackage.Literals.ABSTRACT_TOOL__Y, newY);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public double getWidth() {
		return (Double) eGet(RcplPackage.Literals.ABSTRACT_TOOL__WIDTH, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setWidth(double newWidth) {
		eSet(RcplPackage.Literals.ABSTRACT_TOOL__WIDTH, newWidth);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public double getHeight() {
		return (Double) eGet(RcplPackage.Literals.ABSTRACT_TOOL__HEIGHT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setHeight(double newHeight) {
		eSet(RcplPackage.Literals.ABSTRACT_TOOL__HEIGHT, newHeight);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int getGridX() {
		return (Integer) eGet(RcplPackage.Literals.ABSTRACT_TOOL__GRID_X, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setGridX(int newGridX) {
		eSet(RcplPackage.Literals.ABSTRACT_TOOL__GRID_X, newGridX);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int getGridY() {
		return (Integer) eGet(RcplPackage.Literals.ABSTRACT_TOOL__GRID_Y, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setGridY(int newGridY) {
		eSet(RcplPackage.Literals.ABSTRACT_TOOL__GRID_Y, newGridY);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int getSpanX() {
		return (Integer) eGet(RcplPackage.Literals.ABSTRACT_TOOL__SPAN_X, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setSpanX(int newSpanX) {
		eSet(RcplPackage.Literals.ABSTRACT_TOOL__SPAN_X, newSpanX);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int getSpanY() {
		return (Integer) eGet(RcplPackage.Literals.ABSTRACT_TOOL__SPAN_Y, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setSpanY(int newSpanY) {
		eSet(RcplPackage.Literals.ABSTRACT_TOOL__SPAN_Y, newSpanY);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isLabeled() {
		return (Boolean) eGet(RcplPackage.Literals.ABSTRACT_TOOL__LABELED, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setLabeled(boolean newLabeled) {
		eSet(RcplPackage.Literals.ABSTRACT_TOOL__LABELED, newLabeled);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isNotImplemented() {
		return (Boolean) eGet(RcplPackage.Literals.ABSTRACT_TOOL__NOT_IMPLEMENTED, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setNotImplemented(boolean newNotImplemented) {
		eSet(RcplPackage.Literals.ABSTRACT_TOOL__NOT_IMPLEMENTED, newNotImplemented);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getService() {
		return (String) eGet(RcplPackage.Literals.ABSTRACT_TOOL__SERVICE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setService(String newService) {
		eSet(RcplPackage.Literals.ABSTRACT_TOOL__SERVICE, newService);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getDetailPaneClassName() {
		return (String) eGet(RcplPackage.Literals.ABSTRACT_TOOL__DETAIL_PANE_CLASS_NAME, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setDetailPaneClassName(String newDetailPaneClassName) {
		eSet(RcplPackage.Literals.ABSTRACT_TOOL__DETAIL_PANE_CLASS_NAME, newDetailPaneClassName);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ToolType getType() {
		return (ToolType) eGet(RcplPackage.Literals.ABSTRACT_TOOL__TYPE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setType(ToolType newType) {
		eSet(RcplPackage.Literals.ABSTRACT_TOOL__TYPE, newType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isSystem() {
		return (Boolean) eGet(RcplPackage.Literals.ABSTRACT_TOOL__SYSTEM, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setSystem(boolean newSystem) {
		eSet(RcplPackage.Literals.ABSTRACT_TOOL__SYSTEM, newSystem);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getUrl() {
		return (String) eGet(RcplPackage.Literals.ABSTRACT_TOOL__URL, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setUrl(String newUrl) {
		eSet(RcplPackage.Literals.ABSTRACT_TOOL__URL, newUrl);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isToggleGroup() {
		return (Boolean) eGet(RcplPackage.Literals.ABSTRACT_TOOL__TOGGLE_GROUP, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setToggleGroup(boolean newToggleGroup) {
		eSet(RcplPackage.Literals.ABSTRACT_TOOL__TOGGLE_GROUP, newToggleGroup);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ToolGroup getExpandToolGroup() {
		return (ToolGroup) eGet(RcplPackage.Literals.ABSTRACT_TOOL__EXPAND_TOOL_GROUP, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setExpandToolGroup(ToolGroup newExpandToolGroup) {
		eSet(RcplPackage.Literals.ABSTRACT_TOOL__EXPAND_TOOL_GROUP, newExpandToolGroup);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isHGrow() {
		return (Boolean) eGet(RcplPackage.Literals.ABSTRACT_TOOL__HGROW, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setHGrow(boolean newHGrow) {
		eSet(RcplPackage.Literals.ABSTRACT_TOOL__HGROW, newHGrow);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isVGrow() {
		return (Boolean) eGet(RcplPackage.Literals.ABSTRACT_TOOL__VGROW, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setVGrow(boolean newVGrow) {
		eSet(RcplPackage.Literals.ABSTRACT_TOOL__VGROW, newVGrow);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public double getWidthPercent() {
		return (Double) eGet(RcplPackage.Literals.ABSTRACT_TOOL__WIDTH_PERCENT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setWidthPercent(double newWidthPercent) {
		eSet(RcplPackage.Literals.ABSTRACT_TOOL__WIDTH_PERCENT, newWidthPercent);
	}

	private Object data;

	/*
	 * @generated NOT (non-Javadoc)
	 * 
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool#getData()
	 */
	@Override
	public Object getData() {
		return data;
	}

	/*
	 * @generated NOT
	 * 
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool#setData(java.lang.Object)
	 */
	@Override
	public void setData(Object data) {
		this.data = data;
	}

} // AbstractToolImpl
