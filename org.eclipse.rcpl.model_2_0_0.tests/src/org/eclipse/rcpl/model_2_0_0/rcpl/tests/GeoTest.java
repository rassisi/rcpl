/**
 */
package org.eclipse.rcpl.model_2_0_0.rcpl.tests;

import junit.textui.TestRunner;

import org.eclipse.rcpl.model_2_0_0.rcpl.Geo;
import org.eclipse.rcpl.model_2_0_0.rcpl.RcplFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Geo</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class GeoTest extends LayoutableTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(GeoTest.class);
	}

	/**
	 * Constructs a new Geo test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeoTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Geo test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Geo getFixture() {
		return (Geo)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(RcplFactory.eINSTANCE.createGeo());
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

} //GeoTest
