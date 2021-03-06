/*******************************************************************************
 * Copyright (c) 2003 - 2014 Ramin Assisi and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     Ramin Assisi - initial implementation
 *******************************************************************************/
package org.eclipse.rcpl.detailpages;

import java.math.BigDecimal;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.rcpl.AbstractRcplAddon;
import org.eclipse.rcpl.IRcplAddon;
import org.eclipse.rcpl.ITreePart;
import org.eclipse.rcpl.emf.util.EMFEditFXProperties;
import org.eclipse.rcpl.navigator.IModelDetailPageControler;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import jfxtras.labs.scene.control.BigDecimalField;

/**
 * @author Ramin
 * 
 */
abstract public class AbstractDetailPaneController implements IModelDetailPageControler {

	protected ScrollPane internalDetailsScrollPane;

	protected StackPane internalDetailsStackPane;

	protected Pane internalDetailsPane;

	protected TabPane diagramPane;

	protected ITreePart treePart;

	public AbstractDetailPaneController() {
		diagramPane = new TabPane();
		// diagramPane.setPrefSize(1000, 1000);
		diagramPane.setStyle("-fx-background-color: lightyellow");
		internalDetailsPane = new Pane();
		// internalDetailsPane.setPrefSize(1000, 1000);
	}

	public void showDiagram(Object selectedObject) {
		showDetailsInStackPanePane(diagramPane);
		refreshDiagram(uc, selectedObject);
	}

	public void showDetailsInScrollPane(Node node) {
		internalDetailsStackPane.getChildren().clear();
		internalDetailsStackPane.getChildren().add(internalDetailsScrollPane);
		internalDetailsScrollPane.setContent(node);
	}

	public void showDetailsInStackPanePane(Node node) {
		internalDetailsStackPane.getChildren().clear();
		internalDetailsStackPane.getChildren().add(node);
	}

	protected Property<String> bind(TextField textField, Property<String> oldProperty, EObject eObject,
			EStructuralFeature feature, EditingDomain editingDomain) {

		try {

			// if (eObject instanceof ETool) {
			//
			// String id = ((ETool) eObject).getToolId();
			// System. out.("id: " + id);
			// }

			if (oldProperty != null)
				textField.textProperty().unbindBidirectional(oldProperty);

			Property<String> property = null;
			if (eObject != null) {
				property = EMFEditFXProperties.value(editingDomain, eObject, feature);
				textField.textProperty().bindBidirectional(property);
			}

			textField.setDisable(eObject == null);

			// if (eObject == null)
			// textField.clear();

			return property;
		} catch (IllegalArgumentException ex) {
			// ignore
		}
		return new SimpleStringProperty("");
	}

	protected Property<String> rebindTextCombo(ComboBox<String> textField, Property<String> oldProperty,
			EObject eObject, EStructuralFeature feature, EditingDomain editingDomain) {

		try {

			// if (eObject instanceof ETool) {
			//
			// String id = ((ETool) eObject).getToolId();
			// System. out.("id: " + id);
			// }

			if (oldProperty != null)

				textField.valueProperty().unbindBidirectional(oldProperty);

			Property<String> property = null;
			if (eObject != null) {
				property = EMFEditFXProperties.value(editingDomain, eObject, feature);
				textField.valueProperty().bindBidirectional(property);
			}

			textField.setDisable(eObject == null);

			// if (eObject == null)
			// textField.clear();

			return property;
		} catch (IllegalArgumentException ex) {
			// ignore
		}
		return new SimpleStringProperty("");
	}

	private AbstractRcplAddon uc;

	public void init(AbstractRcplAddon uc) {
		this.uc = uc;
		fxmlToInternalFields();

		addCustomFields();
		doInit(uc);
	}

	public abstract void doInit(AbstractRcplAddon uc);

	protected void fxmlToInternalFields() {

	}

	protected Property<BigDecimal> rebind(BigDecimalField textField, Property<BigDecimal> oldProperty, EObject eObject,
			EStructuralFeature feature, EditingDomain editingDomain) {
		try {
			if (oldProperty != null)
				textField.numberProperty().unbindBidirectional(oldProperty);

			Property<BigDecimal> property = null;

			if (eObject != null) {
				property = EMFEditFXProperties.value(editingDomain, eObject, feature);
				textField.numberProperty().bindBidirectional(property);
			}

			textField.setDisable(eObject == null);

			// if (eObject == null)
			// textField.clear();

			return property;
		} catch (IllegalArgumentException ex) {
			// ignore
		}
		return null;
	}

//	protected Property<Number> rebind(IntegerField textField, Property<Number> oldProperty, EObject eObject,
//			EStructuralFeature feature, EditingDomain editingDomain) {
//		try {
//			if (oldProperty != null)
//				textField.valueProperty().unbindBidirectional(oldProperty);
//
//			Property<Number> property = null;
//			if (eObject != null) {
//				property = EMFEditFXProperties.value(editingDomain, eObject, feature);
//				textField.valueProperty().bindBidirectional(property);
//			}
//
//			textField.setDisable(eObject == null);
//
//			// if (eObject == null)
//			// textField.clear();
//
//			return property;
//		} catch (IllegalArgumentException ex) {
//			// ignore
//		}
//		return null;
//	}

	protected Property<BigDecimal> rebind(BigDecimalField field, Property<BigDecimal> oldProperty, EObject eObject,
			EStructuralFeature feature, EditingDomain editingDomain, boolean in) {
		try {
			if (oldProperty != null)
				field.numberProperty().unbindBidirectional(oldProperty);

			Property<BigDecimal> property = null;
			if (eObject != null) {
				property = EMFEditFXProperties.value(editingDomain, eObject, feature);
				field.numberProperty().bindBidirectional(property);
			}

			field.setDisable(eObject == null);

			// if (eObject == null)
			// textField.clear();

			return property;
		} catch (IllegalArgumentException ex) {
			// ignore
		}
		return null;
	}

	protected Property<Boolean> rebind(CheckBox checkBox, Property<Boolean> oldProperty, EObject eObject,
			EStructuralFeature feature, EditingDomain editingDomain) {

		try {

			if (oldProperty != null)
				checkBox.selectedProperty().unbindBidirectional(oldProperty);

			Property<Boolean> property = null;
			if (eObject != null) {
				property = EMFEditFXProperties.value(editingDomain, eObject, feature);
				checkBox.selectedProperty().bindBidirectional(property);
			}

			checkBox.setDisable(eObject == null);

			if (eObject == null)
				checkBox.selectedProperty().set(false);

			return property;
		} catch (IllegalArgumentException ex) {
			// Ignore
		}
		checkBox.setSelected(false);
		return new SimpleBooleanProperty(false);
	}

	protected Property<SingleSelectionModel<Enum>> rebind(ComboBox<Enum> comboBox,
			Property<SingleSelectionModel<Enum>> oldProperty, EObject eObject, EStructuralFeature feature,
			EditingDomain editingDomain) {

		try {

			if (oldProperty != null)
				comboBox.selectionModelProperty().unbindBidirectional(oldProperty);

			Property<SingleSelectionModel<Enum>> property = null;
			if (eObject != null) {
				property = EMFEditFXProperties.value(editingDomain, eObject, feature);
				comboBox.selectionModelProperty().bindBidirectional(property);
			}

			comboBox.setDisable(eObject == null);

			if (eObject == null) {
				comboBox.selectionModelProperty().set(null);
			}

			return property;
		} catch (IllegalArgumentException ex) {
			// Ignore
		}
		comboBox.selectionModelProperty().set(null);

		return null;
	}

	@Override
	public abstract void updateBindings(EObject contact, EditingDomain editingDomain);

	protected void addCustomFields() {

	}

	protected void refreshDiagram(AbstractRcplAddon uc, Object selectedObject) {

	}

	public void refresh() {

	}

	public boolean registerRcplPlugin(Class<? extends IRcplAddon> useCaseClass) {
		return false;
	}

}
