/**
 */
package org.eclipse.rcpl.model_2_0_0.rcpl;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Abstract
 * Tool</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool#getX <em>X</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool#getY <em>Y</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool#getWidth <em>Width</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool#getHeight <em>Height</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool#getGridX <em>Grid X</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool#getGridY <em>Grid Y</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool#getSpanX <em>Span X</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool#getSpanY <em>Span Y</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool#isLabeled <em>Labeled</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool#isNotImplemented <em>Not Implemented</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool#getService <em>Service</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool#getDetailPaneClassName <em>Detail Pane Class Name</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool#isSystem <em>System</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool#getUrl <em>Url</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool#isToggleGroup <em>Toggle Group</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool#getExpandToolGroup <em>Expand Tool Group</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool#isHGrow <em>HGrow</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool#isVGrow <em>VGrow</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool#getWidthPercent <em>Width Percent</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool#getCommand <em>Command</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getAbstractTool()
 * @model abstract="true"
 * @generated
 */
public interface AbstractTool extends Layoutable {
	/**
	 * Returns the value of the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>X</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>X</em>' attribute.
	 * @see #setX(double)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getAbstractTool_X()
	 * @model
	 * @generated
	 */
	double getX();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool#getX <em>X</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>X</em>' attribute.
	 * @see #getX()
	 * @generated
	 */
	void setX(double value);

	/**
	 * Returns the value of the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Y</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Y</em>' attribute.
	 * @see #setY(double)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getAbstractTool_Y()
	 * @model
	 * @generated
	 */
	double getY();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool#getY <em>Y</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Y</em>' attribute.
	 * @see #getY()
	 * @generated
	 */
	void setY(double value);

	/**
	 * Returns the value of the '<em><b>Width</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Width</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Width</em>' attribute.
	 * @see #setWidth(double)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getAbstractTool_Width()
	 * @model
	 * @generated
	 */
	double getWidth();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool#getWidth <em>Width</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Width</em>' attribute.
	 * @see #getWidth()
	 * @generated
	 */
	void setWidth(double value);

	/**
	 * Returns the value of the '<em><b>Height</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Height</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Height</em>' attribute.
	 * @see #setHeight(double)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getAbstractTool_Height()
	 * @model
	 * @generated
	 */
	double getHeight();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool#getHeight <em>Height</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Height</em>' attribute.
	 * @see #getHeight()
	 * @generated
	 */
	void setHeight(double value);

	/**
	 * Returns the value of the '<em><b>Grid X</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Grid X</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Grid X</em>' attribute.
	 * @see #setGridX(int)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getAbstractTool_GridX()
	 * @model
	 * @generated
	 */
	int getGridX();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool#getGridX <em>Grid X</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Grid X</em>' attribute.
	 * @see #getGridX()
	 * @generated
	 */
	void setGridX(int value);

	/**
	 * Returns the value of the '<em><b>Grid Y</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Grid Y</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Grid Y</em>' attribute.
	 * @see #setGridY(int)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getAbstractTool_GridY()
	 * @model
	 * @generated
	 */
	int getGridY();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool#getGridY <em>Grid Y</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Grid Y</em>' attribute.
	 * @see #getGridY()
	 * @generated
	 */
	void setGridY(int value);

	/**
	 * Returns the value of the '<em><b>Span X</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Span X</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Span X</em>' attribute.
	 * @see #setSpanX(int)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getAbstractTool_SpanX()
	 * @model default="1"
	 * @generated
	 */
	int getSpanX();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool#getSpanX <em>Span X</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Span X</em>' attribute.
	 * @see #getSpanX()
	 * @generated
	 */
	void setSpanX(int value);

	/**
	 * Returns the value of the '<em><b>Span Y</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Span Y</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Span Y</em>' attribute.
	 * @see #setSpanY(int)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getAbstractTool_SpanY()
	 * @model default="1"
	 * @generated
	 */
	int getSpanY();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool#getSpanY <em>Span Y</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Span Y</em>' attribute.
	 * @see #getSpanY()
	 * @generated
	 */
	void setSpanY(int value);

	/**
	 * Returns the value of the '<em><b>Labeled</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Labeled</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Labeled</em>' attribute.
	 * @see #setLabeled(boolean)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getAbstractTool_Labeled()
	 * @model
	 * @generated
	 */
	boolean isLabeled();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool#isLabeled <em>Labeled</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Labeled</em>' attribute.
	 * @see #isLabeled()
	 * @generated
	 */
	void setLabeled(boolean value);

	/**
	 * Returns the value of the '<em><b>Not Implemented</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Not Implemented</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Not Implemented</em>' attribute.
	 * @see #setNotImplemented(boolean)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getAbstractTool_NotImplemented()
	 * @model
	 * @generated
	 */
	boolean isNotImplemented();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool#isNotImplemented <em>Not Implemented</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Not Implemented</em>' attribute.
	 * @see #isNotImplemented()
	 * @generated
	 */
	void setNotImplemented(boolean value);

	/**
	 * Returns the value of the '<em><b>Service</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Service</em>' attribute.
	 * @see #setService(String)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getAbstractTool_Service()
	 * @model
	 * @generated
	 */
	String getService();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool#getService <em>Service</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service</em>' attribute.
	 * @see #getService()
	 * @generated
	 */
	void setService(String value);

	/**
	 * Returns the value of the '<em><b>Detail Pane Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Detail Pane Class Name</em>' attribute isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Detail Pane Class Name</em>' attribute.
	 * @see #setDetailPaneClassName(String)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getAbstractTool_DetailPaneClassName()
	 * @model
	 * @generated
	 */
	String getDetailPaneClassName();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool#getDetailPaneClassName <em>Detail Pane Class Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Detail Pane Class Name</em>' attribute.
	 * @see #getDetailPaneClassName()
	 * @generated
	 */
	void setDetailPaneClassName(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute. The literals are
	 * from the enumeration {@link org.eclipse.rcpl.model_2_0_0.rcpl.ToolType}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.ToolType
	 * @see #setType(ToolType)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getAbstractTool_Type()
	 * @model
	 * @generated
	 */
	ToolType getType();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.ToolType
	 * @see #getType()
	 * @generated
	 */
	void setType(ToolType value);

	/**
	 * Returns the value of the '<em><b>System</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>System</em>' attribute.
	 * @see #setSystem(boolean)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getAbstractTool_System()
	 * @model
	 * @generated
	 */
	boolean isSystem();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool#isSystem <em>System</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>System</em>' attribute.
	 * @see #isSystem()
	 * @generated
	 */
	void setSystem(boolean value);

	/**
	 * Returns the value of the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Url</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Url</em>' attribute.
	 * @see #setUrl(String)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getAbstractTool_Url()
	 * @model
	 * @generated
	 */
	String getUrl();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool#getUrl <em>Url</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Url</em>' attribute.
	 * @see #getUrl()
	 * @generated
	 */
	void setUrl(String value);

	/**
	 * Returns the value of the '<em><b>Toggle Group</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Toggle Group</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Toggle Group</em>' attribute.
	 * @see #setToggleGroup(boolean)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getAbstractTool_ToggleGroup()
	 * @model
	 * @generated
	 */
	boolean isToggleGroup();

	/**
	 * Sets the value of the
	 * '{@link org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool#isToggleGroup
	 * <em>Toggle Group</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value the new value of the '<em>Toggle Group</em>' attribute.
	 * @see #isToggleGroup()
	 * @generated
	 */
	void setToggleGroup(boolean value);

	/**
	 * Returns the value of the '<em><b>Expand Tool Group</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expand Tool Group</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Expand Tool Group</em>' reference.
	 * @see #setExpandToolGroup(ToolGroup)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getAbstractTool_ExpandToolGroup()
	 * @model
	 * @generated
	 */
	ToolGroup getExpandToolGroup();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool#getExpandToolGroup <em>Expand Tool Group</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Expand Tool Group</em>' reference.
	 * @see #getExpandToolGroup()
	 * @generated
	 */
	void setExpandToolGroup(ToolGroup value);

	/**
	 * Returns the value of the '<em><b>HGrow</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>HGrow</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>HGrow</em>' attribute.
	 * @see #setHGrow(boolean)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getAbstractTool_HGrow()
	 * @model
	 * @generated
	 */
	boolean isHGrow();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool#isHGrow <em>HGrow</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>HGrow</em>' attribute.
	 * @see #isHGrow()
	 * @generated
	 */
	void setHGrow(boolean value);

	/**
	 * Returns the value of the '<em><b>VGrow</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>VGrow</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>VGrow</em>' attribute.
	 * @see #setVGrow(boolean)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getAbstractTool_VGrow()
	 * @model
	 * @generated
	 */
	boolean isVGrow();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool#isVGrow <em>VGrow</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>VGrow</em>' attribute.
	 * @see #isVGrow()
	 * @generated
	 */
	void setVGrow(boolean value);

	/**
	 * Returns the value of the '<em><b>Width Percent</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Width Percent</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Width Percent</em>' attribute.
	 * @see #setWidthPercent(double)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getAbstractTool_WidthPercent()
	 * @model
	 * @generated
	 */
	double getWidthPercent();

	/**
	 * Sets the value of the
	 * '{@link org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool#getWidthPercent
	 * <em>Width Percent</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value the new value of the '<em>Width Percent</em>' attribute.
	 * @see #getWidthPercent()
	 * @generated
	 */
	void setWidthPercent(double value);

	/**
	 * Returns the value of the '<em><b>Command</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Command</em>' reference.
	 * @see #setCommand(Command)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getAbstractTool_Command()
	 * @model
	 * @generated
	 */
	Command getCommand();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool#getCommand <em>Command</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Command</em>' reference.
	 * @see #getCommand()
	 * @generated
	 */
	void setCommand(Command value);

	/**
	 * @return
	 * @generated NOT
	 */
	Object getData();

	/**
	 * @return
	 * @generated NOT
	 */
	void setData(Object data);

} // AbstractTool
