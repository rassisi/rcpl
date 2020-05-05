/**
 */
package org.eclipse.rcpl.model_2_0_0.rcpl.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool;
import org.eclipse.rcpl.model_2_0_0.rcpl.Command;
import org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage;
import org.eclipse.rcpl.model_2_0_0.rcpl.Service;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Command</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.CommandImpl#getService
 * <em>Service</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CommandImpl extends LayoutableImpl implements Command {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected CommandImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RcplPackage.Literals.COMMAND;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Service getService() {
		return (Service) eGet(RcplPackage.Literals.COMMAND__SERVICE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setService(Service newService) {
		eSet(RcplPackage.Literals.COMMAND__SERVICE, newService);
	}

	/**
	 * @generated NOT
	 */
	private Object[] data;

	/**
	 * @generated NOT
	 */
	@Override
	public Object[] getNewData() {
		return data;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public void setNewData(Object[] newData) {
		this.data = newData;
	}

	/**
	 * @generated NOT
	 */
	private AbstractTool tool;

	/**
	 * @generated NOT
	 */
	@Override
	public AbstractTool getTool() {
		return tool;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public void setTool(AbstractTool tool) {
		this.tool = tool;
	}

} // CommandImpl
