/**
 */
package org.eclipse.rcpl.model_2_0_0.rcpl.tests;

import junit.textui.TestRunner;

import org.eclipse.rcpl.model_2_0_0.rcpl.HomePages;
import org.eclipse.rcpl.model_2_0_0.rcpl.RcplFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Home Pages</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class HomePagesTest extends LayoutableTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(HomePagesTest.class);
	}

	/**
	 * Constructs a new Home Pages test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HomePagesTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Home Pages test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected HomePages getFixture() {
		return (HomePages)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(RcplFactory.eINSTANCE.createHomePages());
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

} //HomePagesTest
