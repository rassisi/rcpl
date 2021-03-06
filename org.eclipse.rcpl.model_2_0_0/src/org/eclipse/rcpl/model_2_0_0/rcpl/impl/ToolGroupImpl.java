/**
 */
package org.eclipse.rcpl.model_2_0_0.rcpl.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.rcpl.model_2_0_0.rcpl.GroupType;
import org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage;
import org.eclipse.rcpl.model_2_0_0.rcpl.Tool;
import org.eclipse.rcpl.model_2_0_0.rcpl.ToolGroup;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Tool
 * Group</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.ToolGroupImpl#getToolGroups <em>Tool Groups</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.ToolGroupImpl#isGrid <em>Grid</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.ToolGroupImpl#getFormat <em>Format</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.ToolGroupImpl#getTools <em>Tools</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.ToolGroupImpl#getGroupType <em>Group Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ToolGroupImpl extends AbstractToolImpl implements ToolGroup {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ToolGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RcplPackage.Literals.TOOL_GROUP;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public EList<ToolGroup> getToolGroups() {
		return (EList<ToolGroup>)eGet(RcplPackage.Literals.TOOL_GROUP__TOOL_GROUPS, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public EList<Tool> getTools() {
		return (EList<Tool>)eGet(RcplPackage.Literals.TOOL_GROUP__TOOLS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GroupType getGroupType() {
		return (GroupType)eGet(RcplPackage.Literals.TOOL_GROUP__GROUP_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGroupType(GroupType newGroupType) {
		eSet(RcplPackage.Literals.TOOL_GROUP__GROUP_TYPE, newGroupType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isGrid() {
		return (Boolean)eGet(RcplPackage.Literals.TOOL_GROUP__GRID, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGrid(boolean newGrid) {
		eSet(RcplPackage.Literals.TOOL_GROUP__GRID, newGrid);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFormat() {
		return (String)eGet(RcplPackage.Literals.TOOL_GROUP__FORMAT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFormat(String newFormat) {
		eSet(RcplPackage.Literals.TOOL_GROUP__FORMAT, newFormat);
	}

	private boolean ready;

	@Override
	public void setReady(boolean ready) {
		this.ready = ready;

	}

} // ToolGroupImpl
