/**
 */
package org.eclipse.rcpl.model_2_0_0.rcpl;

/**
 * <!-- begin-user-doc --> A representation of the model object
 * '<em><b>Command</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.Command#getService <em>Service</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.Command#getDialogClassName <em>Dialog Class Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getCommand()
 * @model
 * @generated
 */
public interface Command extends Layoutable {
	/**
	 * Returns the value of the '<em><b>Service</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service</em>' reference isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Service</em>' reference.
	 * @see #setService(Service)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getCommand_Service()
	 * @model
	 * @generated
	 */
	Service getService();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.Command#getService <em>Service</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service</em>' reference.
	 * @see #getService()
	 * @generated
	 */
	void setService(Service value);

	/**
	 * Returns the value of the '<em><b>Dialog Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dialog Class Name</em>' attribute.
	 * @see #setDialogClassName(String)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getCommand_DialogClassName()
	 * @model
	 * @generated
	 */
	String getDialogClassName();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.Command#getDialogClassName <em>Dialog Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dialog Class Name</em>' attribute.
	 * @see #getDialogClassName()
	 * @generated
	 */
	void setDialogClassName(String value);

	/**
	 * @generated NOT
	 */
	Object[] getNewData();

	/**
	 * @generated NOT
	 */
	void setNewData(Object[] newData);

	/**
	 * @generated NOT
	 */
	AbstractTool getTool();

	/**
	 * @generated NOT
	 */
	void setTool(AbstractTool tool);

} // Command
