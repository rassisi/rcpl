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
package org.eclipse.rcpl;

import java.net.URL;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcpl.migration.RcplAbstractMigration;
import org.eclipse.rcpl.model.RCPLModel;
import org.eclipse.rcpl.model.cdo.client.RcplSession;
import org.eclipse.rcpl.model_2_0_0.rcpl.Addon;
import org.eclipse.rcpl.model_2_0_0.rcpl.RcplFactory;
import org.eclipse.rcpl.model_2_0_0.rcpl.Tool;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public abstract class AbstractRcplAddon implements IRcplAddon {

	private BorderPane node;

	protected Addon model;

	private Class<? extends EObject> cl;

	private Tool tool;

	private boolean asEditor;

	private IRcplPluginControler controler;

	public AbstractRcplAddon() {
		node = new BorderPane();
	}

	private Button closeButton;

	protected abstract RcplAbstractMigration getMigration();

	@Override
	public void setTool(Tool tool) {
		this.tool = tool;
		this.asEditor = true;
		node = new BorderPane();
	}

	// try {
	//
	// GridPane hBox = new GridPane();
	//
	// Pane p1 = new Pane();
	// hBox.setMinHeight(28);
	// hBox.setId("verticalGradientPane");
	//
	// hBox.add(p1, 0, 0);
	// GridPane.setHgrow(p1, Priority.ALWAYS);
	//
	// Text text = new Text(getDisplayName());
	// text.setId("useCaseHeader");
	// p1.getChildren().add(text);
	// text.setLayoutX(10);
	// text.setLayoutY(20);
	//
	// closeButton = new Button();
	// closeButton.setId("window_close");
	// closeButton.setOnAction(new EventHandler<ActionEvent>() {
	//
	// @Override
	// public void handle(ActionEvent event) {
	// close();
	//
	// }
	// });
	//
	// closeButton.setPrefWidth(48);
	// closeButton.setMaxWidth(48);
	// // HBox.set(closeButton, HPos.RIGHT);
	//
	// // GridPane.setMargin(text, new Insets(11, 0, 2, 22));
	// // HBox.setHgrow(st, Priority.ALWAYS);
	// // HBox.setHgrow(closeButton, Priority.NEVER);
	//
	// // hBox.getChildren().addAll(text, closeButton);
	//
	// GridPane.setHgrow(closeButton, Priority.NEVER);
	// GridPane.setMargin(closeButton, new Insets(8, 10, 0, -30));
	// hBox.add(closeButton, 1, 0);
	// node.setTop(hBox);
	// } catch (Exception ex) {
	// JOModel.logError(ex);
	// }

	@Override
	public void bindToModel() throws Exception {

		try {
			for (Addon plugin : RcplSession.getDefault().getRcpl().getAllAddons().getChildren()) {
				String pluginId = plugin.getId();
				if (pluginId != null && pluginId.equals(getId())) {
					model = plugin;
					break;
				}
			}

			if (model == null) {
				model = RcplFactory.eINSTANCE.createAddon();
				if (tool != null) {
					model.setId(tool.getId());
				}
				RcplSession.getDefault().getRcpl().getAllAddons().getChildren().add(model);
				RcplSession.getDefault().commit();
			}
			if (getMigration() != null) {
				getMigration().migrate();
			}
		} catch (Throwable ex) {
			RCPLModel.logError(ex);
		}

	}

	// private void close() {
	// JOSession.getDefault().commit();
	// Rcpl.UIC.showTabPane();
	// Rcpl.UIC.restorePerspective();
	// }

	@Override
	public void init() {
		try {
			URL location = getClass().getResource(getClass().getSimpleName() + ".fxml");
			if (location != null) {
				FXMLLoader fxmlLoader = new FXMLLoader(location);
				fxmlLoader.setController(getController());
				getNode().setCenter((Node) fxmlLoader.load());
				getController().init(this);

			}
		} catch (Throwable e) {
			RCPLModel.logError(e);
		}
	}

	protected abstract IRcplPluginControler createController();

	public IRcplPluginControler getController() {
		if (controler == null) {
			try {
				controler = createController();
			} catch (Throwable ex) {
				RCPLModel.logError(ex);
			}
		}
		return controler;
	}

	@Override
	public BorderPane getNode() {
		return this.node;
	}

	@Override
	public String getDisplayName() {
		return getModel().getName();
	}

	@Override
	public Addon getModel() {
		return model;
	}

	@Override
	public Class<? extends EObject> getRootClass() {
		return cl;
	}

	@Override
	public void setRootClass(Class<? extends EObject> cl) {
		this.cl = cl;
	}

	@Override
	public String getId() {
		if (tool != null) {
			return tool.getId();
		}
		return getClass().getName();
	}

	@Override
	public Tool getTool() {
		return tool;
	}

	@Override
	public void setAsEditor(boolean asEditor) {
		this.asEditor = asEditor;
		if (closeButton != null) {
			closeButton.setVisible(!asEditor);
		}

	}

	@Override
	public boolean isAsEditor() {
		return asEditor;
	}

	@Override
	public void executeCommand(ICommand command) {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + (getId().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractRcplAddon other = (AbstractRcplAddon) obj;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (!getId().equals(other.getId()))
			return false;
		return true;
	}

	@Override
	public void setModel(Addon model) {
		this.model = model;

	}
}
