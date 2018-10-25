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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool;
import org.eclipse.rcpl.model_2_0_0.rcpl.RcplFactory;
import org.eclipse.rcpl.model_2_0_0.rcpl.ToolGroup;
import org.eclipse.rcpl.model_2_0_0.rcpl.ToolType;
import org.eclipse.rcpl.ui.listener.RcplEvent;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Tooltip;

/**
 * @author ramin
 *
 */
public abstract class AbstractRcplTool<T> implements ITool {

	protected AbstractTool model;

	protected Node node;

	protected boolean selected;

	private Object[] data;

	/**
	 * This constructor is for conveniant reflection (e.g. creation of a Navigator)
	 */
	public AbstractRcplTool() {
	}

	public AbstractRcplTool(AbstractTool model) {
		if (model == null) {
			model = RcplFactory.eINSTANCE.createTool();
			model.setType(ToolType.BUTTON);
			model.setId("NULL_TOOL");
		}
		this.model = model;
		model.setData(this);
		Rcpl.getEditorListeners().add(this);
		Rcpl.getLocalables().add(this);
	}

	private ChangeListener<T> changeListener;

	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	protected void addListener() {
		changeListener = new ChangeListener<T>() {
			@Override
			public void changed(ObservableValue<? extends T> observable, T oldValue, T newValue) {
				if (Rcpl.UIC.getEditor() != null) {
					getModel().setData(AbstractRcplTool.this);
					IParagraph paragraph = Rcpl.UIC.getEditor().getActiveParagraph();
					ICommand command = Rcpl.getFactory().createCommand(AbstractRcplTool.this, paragraph,
							new Object[] { oldValue }, newValue);
					Rcpl.service().execute(command);
				}
			}
		};
		if (getNode() instanceof ComboBox) {
			((ComboBox<T>) getNode()).valueProperty().addListener(changeListener);
		}

	}

	@SuppressWarnings("unchecked")
	protected void removeListener() {
		if (changeListener != null) {
			if (getNode() instanceof ComboBox) {
				((ComboBox<T>) getNode()).valueProperty().removeListener(changeListener);
			}
			changeListener = null;
		}
	}

	@Override
	public abstract Node createNode();

	@Override
	public Node getNode() {
		if (node == null) {
			node = createNode();
			createToolTip();
		}
		return node;
	}

	@Override
	public AbstractTool getModel() {
		return model;
	}

	@Override
	public String getService() {
		String sn = model.getService();
		if (sn == null) {
			EObject ea = model;
			while (ea != null) {
				ea = ea.eContainer();
				if (ea instanceof ToolGroup) {
					if (((ToolGroup) ea).getService() != null) {
						sn = ((ToolGroup) ea).getService();
						break;
					}
				}
			}
		}
		return sn;

	}

	@Override
	public void setBounds(double x, double y, double Width, double height) {
	}

	@Override
	public void setActivePage(IPage page) {
	}

	@Override
	public void setTabs(Object tabs) {
	}

	@Override
	public void textChanged(String formattedText) {
	}

	@Override
	public void doSave() {
	}

	@Override
	public void doLoad() {
	}

	@Override
	public void handleSizeChanged(int width, int height) {
	}

	@Override
	public void selectAll() {
	}

	@Override
	public void handleDeletePressed() {
	}

	@Override
	public void deletePressed() {
	}

	@Override
	public void handlePaste(IPage page) {
	}

	@Override
	public void rendered(int pageNumber) {
	}

	@Override
	public void undoPossible(boolean enabled) {
	}

	@Override
	public void redoPossible(boolean enabled) {
	}

	@Override
	public void close() {
	}

	@Override
	public void maximize() {
	}

	@Override
	public void minimize() {
	}

	@Override
	public void fullScreen() {
	}

	@Override
	public IToolRegistry getToolRegistry() {
		return null;
	}

	@Override
	public IResourceEntry getEntry() {
		return null;
	}

	@Override
	public IToolComponent getToolComponent() {
		return null;
	}

	@Override
	public void setVisible(boolean visible) {
	}

	@Override
	public IToolGroup getGroup() {
		return null;
	}

	@Override
	public boolean isFullSize() {
		return false;
	}

	@Override
	public int getToolHierarchy() {
		return 0;
	}

	@Override
	public Object getImage() {
		return null;
	}

//	public String getServiceClassName() {
//		String srv = getTool().getService();
//		if (srv == null) {
//			EnCommandId ci = EnCommandId.findCommandId(getTool().getId());
//			if (ci != null) {
//				srv = null;
//			}
//		}
//		return srv;
//	}

	@Override
	public String getImageName() {
		String imageName = getModel().getImage();
		if (imageName == null) {
			EnCommandId ci = EnCommandId.findCommandId(getModel().getId());
			if (ci != null) {
				imageName = ci.getImage();
			}
			if (imageName == null) {
				imageName = getModel().getId();
			}
			return imageName;
		}
		return imageName;
	}

	private String getId() {
		if (model != null) {
			return model.getId();
		}
		return "";
	}

	@Override
	public boolean isWrap() {
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
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
		AbstractRcplTool other = (AbstractRcplTool) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

	@Override
	public boolean update(RcplEvent event) {
		return true;
	}

	@Override
	public Object[] getData() {
		return data;
	}

	@Override
	public ITool setData(Object... data) {
		this.data = data;
		return this;
	}

	@Override
	public boolean isSelected() {
		if (ToolType.TOGGLEBUTTON.equals(model.getType())) {
			return ((ToggleButton) getNode()).isSelected();
		}
		return false;
	}

	@Override
	public void setSelected(boolean selected) {

	}

	@Override
	public void fire() {

	}

	@Override
	public void setWidth(double width) {
	}

	protected boolean isImplemented() {
		EObject eo = getModel().eContainer();
		if (eo instanceof AbstractTool) {
			if (((AbstractTool) eo).isNotImplemented()) {
				return false;
			}
		}
		return !getModel().isNotImplemented();
	}

	protected void createToolTip() {
		if (getModel() != null) {
			createToolTip(getModel().getToolTip());
		}
	}

	private void createToolTip(String toolTip) {
		if (toolTip == null) {
			toolTip = getModel().getName();
		}
		if (toolTip == null) {
			toolTip = getModel().getId();
		}

		if (toolTip == null) {
			toolTip = IDictionary.INSTANCE.get("error: No Tooltip defined!");
		} else {
			toolTip = IDictionary.INSTANCE.get(toolTip);
		}
		if (getModel().isNotImplemented()) {
			toolTip = IDictionary.INSTANCE.get("Not Implemented yet") + " " + toolTip;
		}

		final String tt = toolTip;
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				Tooltip t = new Tooltip(tt);
				Tooltip.install(node, t);
				t.getStyleClass().add("ttip");
			}
		});
	}

	public void updateLocale() {
		createToolTip();
	}
}
