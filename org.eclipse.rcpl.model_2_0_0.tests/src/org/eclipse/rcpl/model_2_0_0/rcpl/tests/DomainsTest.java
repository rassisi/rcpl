/**
 */
package org.eclipse.rcpl.model_2_0_0.rcpl.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.eclipse.rcpl.model_2_0_0.rcpl.Domains;
import org.eclipse.rcpl.model_2_0_0.rcpl.RcplFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Domains</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class DomainsTest extends TestCase {

	/**
	 * The fixture for this Domains test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Domains fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(DomainsTest.class);
	}

	/**
	 * Constructs a new Domains test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomainsTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Domains test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Domains fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Domains test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Domains getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(RcplFactory.eINSTANCE.createDomains());
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

} //DomainsTest
