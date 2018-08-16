/**
 */
package org.eclipse.rcpl.model_2_0_0.rcpl.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.eclipse.rcpl.model_2_0_0.rcpl.Commands;
import org.eclipse.rcpl.model_2_0_0.rcpl.RcplFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Commands</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class CommandsTest extends TestCase {

	/**
	 * The fixture for this Commands test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Commands fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(CommandsTest.class);
	}

	/**
	 * Constructs a new Commands test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommandsTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Commands test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Commands fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Commands test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Commands getFixture() {
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
		setFixture(RcplFactory.eINSTANCE.createCommands());
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

} //CommandsTest
