/**
 */
package org.eclipse.rcpl.model_2_0_0.rcpl.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.rcpl.model_2_0_0.rcpl.Document;
import org.eclipse.rcpl.model_2_0_0.rcpl.DocumentType;
import org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Document</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.DocumentImpl#getPath <em>Path</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.DocumentImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DocumentImpl extends LayoutableImpl implements Document {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DocumentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RcplPackage.Literals.DOCUMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPath() {
		return (String)eGet(RcplPackage.Literals.DOCUMENT__PATH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPath(String newPath) {
		eSet(RcplPackage.Literals.DOCUMENT__PATH, newPath);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocumentType getType() {
		return (DocumentType)eGet(RcplPackage.Literals.DOCUMENT__TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(DocumentType newType) {
		eSet(RcplPackage.Literals.DOCUMENT__TYPE, newType);
	}

} //DocumentImpl
