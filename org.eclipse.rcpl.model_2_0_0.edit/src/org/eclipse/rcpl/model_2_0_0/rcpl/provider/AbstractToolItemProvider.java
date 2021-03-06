/**
 */
package org.eclipse.rcpl.model_2_0_0.rcpl.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool;
import org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage;

/**
 * This is the item provider adapter for a
 * {@link org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class AbstractToolItemProvider extends LayoutableItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AbstractToolItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addXPropertyDescriptor(object);
			addYPropertyDescriptor(object);
			addWidthPropertyDescriptor(object);
			addHeightPropertyDescriptor(object);
			addGridXPropertyDescriptor(object);
			addGridYPropertyDescriptor(object);
			addSpanXPropertyDescriptor(object);
			addSpanYPropertyDescriptor(object);
			addLabeledPropertyDescriptor(object);
			addNotImplementedPropertyDescriptor(object);
			addServicePropertyDescriptor(object);
			addDetailPaneClassNamePropertyDescriptor(object);
			addTypePropertyDescriptor(object);
			addSystemPropertyDescriptor(object);
			addUrlPropertyDescriptor(object);
			addToggleGroupPropertyDescriptor(object);
			addExpandToolGroupPropertyDescriptor(object);
			addHGrowPropertyDescriptor(object);
			addVGrowPropertyDescriptor(object);
			addWidthPercentPropertyDescriptor(object);
			addCommandPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the X feature.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addXPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractTool_x_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractTool_x_feature", "_UI_AbstractTool_type"),
				 RcplPackage.Literals.ABSTRACT_TOOL__X,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Y feature.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addYPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractTool_y_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractTool_y_feature", "_UI_AbstractTool_type"),
				 RcplPackage.Literals.ABSTRACT_TOOL__Y,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Width feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addWidthPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractTool_width_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractTool_width_feature", "_UI_AbstractTool_type"),
				 RcplPackage.Literals.ABSTRACT_TOOL__WIDTH,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Height feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addHeightPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractTool_height_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractTool_height_feature", "_UI_AbstractTool_type"),
				 RcplPackage.Literals.ABSTRACT_TOOL__HEIGHT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Grid X feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addGridXPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractTool_gridX_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractTool_gridX_feature", "_UI_AbstractTool_type"),
				 RcplPackage.Literals.ABSTRACT_TOOL__GRID_X,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Grid Y feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addGridYPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractTool_gridY_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractTool_gridY_feature", "_UI_AbstractTool_type"),
				 RcplPackage.Literals.ABSTRACT_TOOL__GRID_Y,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Span X feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addSpanXPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractTool_spanX_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractTool_spanX_feature", "_UI_AbstractTool_type"),
				 RcplPackage.Literals.ABSTRACT_TOOL__SPAN_X,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Span Y feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addSpanYPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractTool_spanY_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractTool_spanY_feature", "_UI_AbstractTool_type"),
				 RcplPackage.Literals.ABSTRACT_TOOL__SPAN_Y,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Labeled feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addLabeledPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractTool_labeled_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractTool_labeled_feature", "_UI_AbstractTool_type"),
				 RcplPackage.Literals.ABSTRACT_TOOL__LABELED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Not Implemented feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addNotImplementedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractTool_notImplemented_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractTool_notImplemented_feature", "_UI_AbstractTool_type"),
				 RcplPackage.Literals.ABSTRACT_TOOL__NOT_IMPLEMENTED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Service feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addServicePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractTool_service_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractTool_service_feature", "_UI_AbstractTool_type"),
				 RcplPackage.Literals.ABSTRACT_TOOL__SERVICE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Detail Pane Class Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDetailPaneClassNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractTool_detailPaneClassName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractTool_detailPaneClassName_feature", "_UI_AbstractTool_type"),
				 RcplPackage.Literals.ABSTRACT_TOOL__DETAIL_PANE_CLASS_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractTool_type_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractTool_type_feature", "_UI_AbstractTool_type"),
				 RcplPackage.Literals.ABSTRACT_TOOL__TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the System feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSystemPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractTool_system_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractTool_system_feature", "_UI_AbstractTool_type"),
				 RcplPackage.Literals.ABSTRACT_TOOL__SYSTEM,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Url feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUrlPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractTool_url_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractTool_url_feature", "_UI_AbstractTool_type"),
				 RcplPackage.Literals.ABSTRACT_TOOL__URL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Toggle Group feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addToggleGroupPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractTool_toggleGroup_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractTool_toggleGroup_feature", "_UI_AbstractTool_type"),
				 RcplPackage.Literals.ABSTRACT_TOOL__TOGGLE_GROUP,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Expand Tool Group feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addExpandToolGroupPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractTool_expandToolGroup_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractTool_expandToolGroup_feature", "_UI_AbstractTool_type"),
				 RcplPackage.Literals.ABSTRACT_TOOL__EXPAND_TOOL_GROUP,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the HGrow feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addHGrowPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractTool_hGrow_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractTool_hGrow_feature", "_UI_AbstractTool_type"),
				 RcplPackage.Literals.ABSTRACT_TOOL__HGROW,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the VGrow feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVGrowPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractTool_vGrow_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractTool_vGrow_feature", "_UI_AbstractTool_type"),
				 RcplPackage.Literals.ABSTRACT_TOOL__VGROW,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Width Percent feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addWidthPercentPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractTool_widthPercent_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractTool_widthPercent_feature", "_UI_AbstractTool_type"),
				 RcplPackage.Literals.ABSTRACT_TOOL__WIDTH_PERCENT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Command feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCommandPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractTool_command_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractTool_command_feature", "_UI_AbstractTool_type"),
				 RcplPackage.Literals.ABSTRACT_TOOL__COMMAND,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		return super.getText(object);
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(AbstractTool.class)) {
			case RcplPackage.ABSTRACT_TOOL__X:
			case RcplPackage.ABSTRACT_TOOL__Y:
			case RcplPackage.ABSTRACT_TOOL__WIDTH:
			case RcplPackage.ABSTRACT_TOOL__HEIGHT:
			case RcplPackage.ABSTRACT_TOOL__GRID_X:
			case RcplPackage.ABSTRACT_TOOL__GRID_Y:
			case RcplPackage.ABSTRACT_TOOL__SPAN_X:
			case RcplPackage.ABSTRACT_TOOL__SPAN_Y:
			case RcplPackage.ABSTRACT_TOOL__LABELED:
			case RcplPackage.ABSTRACT_TOOL__NOT_IMPLEMENTED:
			case RcplPackage.ABSTRACT_TOOL__SERVICE:
			case RcplPackage.ABSTRACT_TOOL__DETAIL_PANE_CLASS_NAME:
			case RcplPackage.ABSTRACT_TOOL__TYPE:
			case RcplPackage.ABSTRACT_TOOL__SYSTEM:
			case RcplPackage.ABSTRACT_TOOL__URL:
			case RcplPackage.ABSTRACT_TOOL__TOGGLE_GROUP:
			case RcplPackage.ABSTRACT_TOOL__HGROW:
			case RcplPackage.ABSTRACT_TOOL__VGROW:
			case RcplPackage.ABSTRACT_TOOL__WIDTH_PERCENT:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s
	 * describing the children that can be created under this object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

}
