package org.eclipse.rcpl.ui.listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.rcpl.EnCommandId;
import org.eclipse.rcpl.ILayoutObject;
import org.eclipse.rcpl.internal.tools.IStyle;
import org.eclipse.rcpl.model_2_0_0.rcpl.ToolType;

/**
 * @author ramin
 * 
 */
public class RcplEvent {

	public final static String KEY_STYLE = "KEY_STYLE";

	public final static String KEY_TEXT_ALIGNMENT = "textAlignment";

	public final static String KEY_SELECTED = "KEY_SELECTED";

	private ILayoutObject layoutObject;

	private HashMap<String, Object> dataMap = new HashMap<String, Object>();

	private List<ToolType> types = new ArrayList<ToolType>();

	private List<EnCommandId> cmds = new ArrayList<EnCommandId>();

	public RcplEvent() {
	}

	public RcplEvent(ILayoutObject layoutObject) {
		this.layoutObject = layoutObject;
	}

	public void put(String key, Object value) {
		dataMap.put(key, value);
	}

	public IStyle getStyle() {
		IStyle style = (IStyle) dataMap.get(KEY_STYLE);
		if (style != null) {
			return style;
		}
		if (layoutObject != null) {
			return layoutObject.getStyle();
		}
		return null;
	}

	public ILayoutObject getLayoutObject() {
		return layoutObject;
	}

	public Object get(String key) {
		return dataMap.get(key);
	}

	public boolean isSelected() {
		Boolean sel = (Boolean) dataMap.get(KEY_SELECTED);
		if (sel != null) {
			return sel.booleanValue();
		}
		return false;
	}

	public void addType(ToolType type) {
		types.add(type);
	}

	public void addCommand(EnCommandId cmd) {
		cmds.add(cmd);
	}

	public List<ToolType> getTypes() {
		return types;
	}

	public List<EnCommandId> getCmds() {
		return cmds;
	}

}
