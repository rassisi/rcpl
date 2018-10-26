/**
 */
package org.eclipse.rcpl.model_2_0_0.rcpl.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.rcpl.model_2_0_0.rcpl.KeyValue;
import org.eclipse.rcpl.model_2_0_0.rcpl.KeyValues;
import org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Key
 * Values</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.KeyValuesImpl#getKeyvalues <em>Keyvalues</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.KeyValuesImpl#getKeyvaluesFolder <em>Keyvalues Folder</em>}</li>
 * </ul>
 *
 * @generated
 */
public class KeyValuesImpl extends LayoutableImpl implements KeyValues {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected KeyValuesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RcplPackage.Literals.KEY_VALUES;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<KeyValue> getKeyvalues() {
		return (EList<KeyValue>)eGet(RcplPackage.Literals.KEY_VALUES__KEYVALUES, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<KeyValues> getKeyvaluesFolder() {
		return (EList<KeyValues>)eGet(RcplPackage.Literals.KEY_VALUES__KEYVALUES_FOLDER, true);
	}

} // KeyValuesImpl
