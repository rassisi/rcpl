/**
 */
package org.eclipse.rcpl.model_2_0_0.rcpl.tests;

import junit.textui.TestRunner;

import org.eclipse.rcpl.model_2_0_0.rcpl.Documents;
import org.eclipse.rcpl.model_2_0_0.rcpl.RcplFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Documents</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class DocumentsTest extends LayoutableTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(DocumentsTest.class);
	}

	/**
	 * Constructs a new Documents test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocumentsTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Documents test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Documents getFixture() {
		return (Documents)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(RcplFactory.eINSTANCE.createDocuments());
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

} //DocumentsTest
