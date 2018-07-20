/**
 */
package org.eclipse.rcpl.model_2_0_0.rcpl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Quick Tool Bar</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.QuickToolBar#getToolGroups <em>Tool Groups</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.QuickToolBar#getTools <em>Tools</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getQuickToolBar()
 * @model
 * @generated
 */
public interface QuickToolBar extends Layoutable {
	/**
	 * Returns the value of the '<em><b>Tool Groups</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.rcpl.model_2_0_0.rcpl.ToolGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tool Groups</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tool Groups</em>' reference list.
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getQuickToolBar_ToolGroups()
	 * @model
	 * @generated
	 */
	EList<ToolGroup> getToolGroups();

	/**
	 * Returns the value of the '<em><b>Tools</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.rcpl.model_2_0_0.rcpl.Tool}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tools</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tools</em>' reference list.
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getQuickToolBar_Tools()
	 * @model
	 * @generated
	 */
	EList<Tool> getTools();

} // QuickToolBar
