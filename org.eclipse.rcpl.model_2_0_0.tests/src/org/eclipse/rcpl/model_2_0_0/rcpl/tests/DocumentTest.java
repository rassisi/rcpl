/**
 */
package org.eclipse.rcpl.model_2_0_0.rcpl.tests;

import junit.textui.TestRunner;

import org.eclipse.rcpl.model_2_0_0.rcpl.Document;
import org.eclipse.rcpl.model_2_0_0.rcpl.RcplFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Document</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class DocumentTest extends LayoutableTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(DocumentTest.class);
	}

	/**
	 * Constructs a new Document test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocumentTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Document test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Document getFixture() {
		return (Document)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(RcplFactory.eINSTANCE.createDocument());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //DocumentTest
