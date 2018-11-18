package org.eclipse.rcpl.ui.listener;

import java.util.HashMap;

import org.eclipse.rcpl.ILayoutObject;
import org.eclipse.rcpl.IStyle;

/**
 * @author ramin
 * 
 */
public class RcplEvent {

	public final static String KEY_STYLE = "KEY_STYLE";

	public final static String KEY_TEXT_ALIGNMENT = "textAlignment";

	private final ILayoutObject layoutObject;

	private final HashMap<String, Object> dataMap;

	public RcplEvent(HashMap<String, Object> data) {
		this.dataMap = data;
		this.layoutObject = null;
	}

	public RcplEvent(ILayoutObject layoutObject, HashMap<String, Object> data) {
		this.layoutObject = layoutObject;
		this.dataMap = data;
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

	public HashMap<String, Object> getData() {
		return dataMap;
	}

}
