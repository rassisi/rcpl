/**
 */
package org.eclipse.rcpl.model_2_0_0.rcpl.tests;

import junit.textui.TestRunner;

import org.eclipse.rcpl.model_2_0_0.rcpl.KeyValues;
import org.eclipse.rcpl.model_2_0_0.rcpl.RcplFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Key Values</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class KeyValuesTest extends LayoutableTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(KeyValuesTest.class);
	}

	/**
	 * Constructs a new Key Values test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KeyValuesTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Key Values test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected KeyValues getFixture() {
		return (KeyValues)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(RcplFactory.eINSTANCE.createKeyValues());
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

} //KeyValuesTest
