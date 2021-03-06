/**
 */
package org.eclipse.rcpl.model_2_0_0.rcpl.tests;

import junit.textui.TestRunner;

import org.eclipse.rcpl.model_2_0_0.rcpl.RcplFactory;
import org.eclipse.rcpl.model_2_0_0.rcpl.Tool;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Tool</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ToolTest extends AbstractToolTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ToolTest.class);
	}

	/**
	 * Constructs a new Tool test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ToolTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Tool test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Tool getFixture() {
		return (Tool)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(RcplFactory.eINSTANCE.createTool());
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

} //ToolTest
