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

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ToggleButton;

/**
 * @author ramin
 *
 */
public abstract class RcplTool<T> implements ITool {

	protected AbstractTool tool;

	protected Node node;

	protected boolean selected;

	private Object[] data;

	/**
	 * This constructor is for conveniant reflection (e.g. creation of a Navigator)
	 */
	public RcplTool() {
	}

	public RcplTool(AbstractTool tool) {
		if (tool == null) {
			tool = RcplFactory.eINSTANCE.createTool();
			tool.setType(ToolType.BUTTON);
			tool.setId("NULL_TOOL");
		}
		this.tool = tool;
		tool.setData(this);
		Rcpl.getEditorListeners().add(this);
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
					getTool().setData(RcplTool.this);
					IParagraph paragraph = Rcpl.UIC.getEditor().getActiveParagraph();
					ICommand command = Rcpl.getFactory().createCommand(RcplTool.this, paragraph,
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
		}
		return node;
	}

	@Override
	public AbstractTool getTool() {
		return tool;
	}

	@Override
	public String getService() {
		String sn = tool.getService();
		if (sn == null) {
			EObject ea = tool;
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
		String imageName = getTool().getImage();
		if (imageName == null) {
			EnCommandId ci = EnCommandId.findCommandId(getTool().getId());
			if (ci != null) {
				imageName = ci.getImage();
			}
			if (imageName == null) {
				imageName = getTool().getId();
			}
			return imageName;
		}
		return imageName;
	}

	private String getId() {
		if (tool != null) {
			return tool.getId();
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
		RcplTool other = (RcplTool) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

	@Override
	public void update(RcplEvent event) {

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
		if (ToolType.TOGGLEBUTTON.equals(tool.getType())) {
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

	protected boolean isImplemented() {
		EObject eo = getTool().eContainer();
		if (eo instanceof AbstractTool) {
			if (((AbstractTool) eo).isNotImplemented()) {
				return false;
			}
		}
		return !getTool().isNotImplemented();
	}
}
