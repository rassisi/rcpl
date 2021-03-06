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
package org.eclipse.rcpl.ui.action;

import java.util.Arrays;

import org.apache.xmlbeans.XmlObject;
import org.eclipse.rcpl.EnCommandId;
import org.eclipse.rcpl.ICommand;
import org.eclipse.rcpl.IEditor;
import org.eclipse.rcpl.ILayoutObject;
import org.eclipse.rcpl.IParagraph;
import org.eclipse.rcpl.IService;
import org.eclipse.rcpl.ITool;
import org.eclipse.rcpl.IWordDocument;
import org.eclipse.rcpl.Rcpl;
import org.eclipse.rcpl.model_2_0_0.rcpl.Command;
import org.eclipse.rcpl.ui.controler.RcplUic;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;

/**
 * @author ramin
 * 
 */
public class RcplCommand implements ICommand {

	private Object[] newData;

	private boolean undo;

	private boolean redo;

	private ILayoutObject layoutObject;

	protected int offset;

	private double caretX;

	private double caretY;

	private final ITool tool;

	private boolean menuButtonAction;

	private EnCommandId commandId;

	private XmlObject oldXmlObject;

	private IService service;

	private boolean valid;

	private Command model;

	/**
	 * 
	 */
	public RcplCommand(ITool tool, IService service, EnCommandId commandId, ILayoutObject layoutObject,
			Object... newData) {
		this.service = service;
		this.newData = newData;
		this.commandId = commandId;
		this.layoutObject = layoutObject;
		this.tool = tool;
		IEditor editor = Rcpl.UIC().getEditor();
		if (layoutObject == null && editor != null) {
			this.layoutObject = editor.getActiveLayoutObject();
		}

		if (commandId == null) {
			if (tool != null) {
				String id = tool.getId();
				if (id == null) {
					return;
				}
				commandId = EnCommandId.findCommandId(id);
				if (commandId == null) {
					return;
				}
			}
		}

//		else {
//			if(service==null) {
//				if(commandId.getServiceId()!=null) {
//					service = commandId.getServiceId();
//				}
//			}
//		}

		this.valid = true;

		if (getEditor() != null && getLayoutObject() != null) {
			if (!EnCommandId.COMMAND_UNDO.equals(commandId) // $NON-NLS-1$
					&& !EnCommandId.COMMAND_REDO.equals(commandId)) { // $NON-NLS-1$

				try {
					if (getLayoutObject().getDocument() instanceof IWordDocument) {
						ILayoutObject rootObject = getLayoutObject().getRootObject();
						XmlObject oldXmlObject = rootObject.getXmlObject();
						if (oldXmlObject instanceof CTP) {
							// XmlObject oldXmlObjectCopy = CTP.Factory
							// .newInstance(); // body.addNewP();
							// oldXmlObjectCopy.set(oldXmlObject);

							this.oldXmlObject = oldXmlObject.copy();

							// System. out.("rootObject: " + rootObject);
							// System. out
							// .("JOCommand.original.oldXmlObject: "
							// + oldXmlObject);
							//
							// System. out.("JOCommand.oldXmlObject: "
							// + oldXmlObject);

							offset = ((IParagraph) rootObject).getCaretOffset();
							caretX = RcplUic.getCaretX();
							caretY = RcplUic.getCaretY();
						} else if (oldXmlObject instanceof CTTbl) {
							XmlObject oldXmlObjectCopy = CTTbl.Factory.newInstance();
							oldXmlObjectCopy.set(oldXmlObject);
							this.oldXmlObject = oldXmlObjectCopy;
						} else {
							// LOGGER.error("Should not happen!"); //$NON-NLS-1$
						}
					}
				} catch (Exception ex) {
					// LOGGER.error("", ex);
				}

				if (getEditor() != null) {
					getEditor().push(this);
				}

				// TODO
				// if(JOUtil.IS_IDE){
				// if(!entry.isNoCommand()){
				// System. out.("CREATE UNDOABLE COMMAND: " +
				// entry.getKey()); //$NON-NLS-1$
				// }
				// }
			}
		}

	}

	@Override
	public Object[] getNewData() {
		return newData;
	}

	public void setUndo(boolean undo) {
		this.undo = undo;
	}

	public boolean isUndo() {
		return undo;
	}

	public void setNewData(Object[] newData) {
		this.newData = newData;
	}

	@Override
	public ILayoutObject getLayoutObject() {
		if (layoutObject == null) {
			layoutObject = getEditor().getActiveParagraph();
		}
		return layoutObject;
	}

	public int getOffset() {
		return offset;
	}

	public boolean isRedo() {
		return redo;
	}

	public void setRedo(boolean redo) {
		this.redo = redo;
	}

	public boolean isMenuButtonAction() {
		return menuButtonAction;
	}

	public void setMenuButtonAction(boolean menuButtonAction) {
		this.menuButtonAction = menuButtonAction;
	}

	@Override
	public ITool getTool() {
		return tool;
	}

	/**
	 * @param newObject
	 */
	public void update() {
		// if (layoutObject.getDocument() instanceof JOWordDocument) {
		// XmlObject newXmlObject = getLayoutObject().getRootObject()
		// .getXmlObject();
		// if (newXmlObject instanceof CTP) {
		// XmlObject newXmlObjectCopy = CTP.Factory.newInstance();
		// newXmlObjectCopy.set(newXmlObject);
		// newData = new Object[] { newXmlObjectCopy };
		// } else if (newXmlObject instanceof CTTbl) {
		// XmlObject newXmlObjectCopy = CTTbl.Factory.newInstance();
		// newXmlObjectCopy.set(newXmlObject);
		// newData = new Object[] { newXmlObjectCopy };
		// } else {
		// LOGGER.error("Should not happen!"); //$NON-NLS-1$
		// }
		// }
	}

	@Override
	public EnCommandId getCommandId() {
		return commandId;
	}

	public XmlObject getOldXmlObject() {
		return oldXmlObject;
	}

	public double getCaretX() {
		return caretX;
	}

	public void setCaretX(double caretX) {
		this.caretX = caretX;
	}

	public double getCaretY() {
		return caretY;
	}

	public void setCaretY(double caretY) {
		this.caretY = caretY;
	}

	@Override
	public String toString() {
		return getOldXmlObject().toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(caretX);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(caretY);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((commandId == null) ? 0 : commandId.hashCode());
		result = prime * result + ((layoutObject == null) ? 0 : layoutObject.hashCode());
		result = prime * result + (menuButtonAction ? 1231 : 1237);
		result = prime * result + Arrays.hashCode(newData);
		result = prime * result + offset;
		result = prime * result + ((oldXmlObject == null) ? 0 : oldXmlObject.hashCode());
		result = prime * result + (redo ? 1231 : 1237);
		result = prime * result + ((tool == null) ? 0 : tool.hashCode());
		result = prime * result + (undo ? 1231 : 1237);
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
		RcplCommand other = (RcplCommand) obj;
		if (Double.doubleToLongBits(caretX) != Double.doubleToLongBits(other.caretX))
			return false;
		if (Double.doubleToLongBits(caretY) != Double.doubleToLongBits(other.caretY))
			return false;
		if (commandId != other.commandId)
			return false;
		if (layoutObject == null) {
			if (other.layoutObject != null)
				return false;
		} else if (!layoutObject.equals(other.layoutObject))
			return false;
		if (menuButtonAction != other.menuButtonAction)
			return false;
		if (!Arrays.equals(newData, other.newData))
			return false;
		if (offset != other.offset)
			return false;
		if (oldXmlObject == null) {
			if (other.oldXmlObject != null)
				return false;
		} else if (!oldXmlObject.equals(other.oldXmlObject))
			return false;
		if (redo != other.redo)
			return false;
		if (tool == null) {
			if (other.tool != null)
				return false;
		} else if (!tool.equals(other.tool))
			return false;
		if (undo != other.undo)
			return false;
		return true;
	}

	@Override
	public void setCommandId(EnCommandId id) {
		commandId = id;
	}

	@Override
	public String getNewStringValue() {
		if (getNewData() != null && getNewData().length > 0) {
			return (String) getNewData()[0];
		}
		return null;
	}

	@Override
	public IService getService() {
		return service;
	}

	@Override
	public void execute() {
		Rcpl.get().service().execute(this);
	}

	@Override
	public IEditor getEditor() {
		return Rcpl.UIC().getEditor();
	}

	public boolean isValid() {
		return valid;
	}

	@Override
	public Command getModel() {
		return model;
	}

	@Override
	public void setModel(Command model) {
		this.model = model;
	}

}
