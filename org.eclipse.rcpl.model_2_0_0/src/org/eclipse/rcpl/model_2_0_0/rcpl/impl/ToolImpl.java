/**
 */
package org.eclipse.rcpl.model_2_0_0.rcpl.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage;
import org.eclipse.rcpl.model_2_0_0.rcpl.Tool;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Tool</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.ToolImpl#getFormat <em>Format</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ToolImpl extends AbstractToolImpl implements Tool {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ToolImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RcplPackage.Literals.TOOL;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getFormat() {
		return (String)eGet(RcplPackage.Literals.TOOL__FORMAT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setFormat(String newFormat) {
		eSet(RcplPackage.Literals.TOOL__FORMAT, newFormat);
	}

	private Object data;

	@Override
	public Object getData() {
		return data;
	}

	@Override
	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * @param key
	 * @return
	 * @generated NOT
	 */
	public String getFormatValue(String key) {
		String f = getFormat();
		if (f == null) {
			return null;
		}
		int pos = f.indexOf(key + "=");
		String value = null;
		if (pos != -1) {
			pos += key.length() + 1;
			int pos2 = f.indexOf(";", pos);
			if (pos2 != -1) {
				value = f.substring(pos, pos2);
			} else {
				value = f.substring(pos);
			}
		}
		return value;
	}

	/**
	 * @param key
	 * @return
	 * @generated NOT
	 */
	public int getIntFormatValue(String key) {
		try {
			return new Integer(getFormatValue(key)).intValue();
		} catch (Exception ex) {
			// ignore
		}
		return 0;
	}

	/**
	 * @param key
	 * @return
	 * @generated NOT
	 */
	public double getDoubleFormatValue(String key) {
		try {
			return new Double(getFormatValue(key)).doubleValue();
		} catch (Exception ex) {
			// ignore
		}
		return 0.0;
	}

	/**
	 * @param key
	 * @return
	 * @generated NOT
	 */
	public boolean getBooleanFormatValue(String key) {
		try {
			return new Boolean(getFormatValue(key)).booleanValue();
		} catch (Exception ex) {
			// ignore
		}
		return false;
	}

} // ToolImpl
