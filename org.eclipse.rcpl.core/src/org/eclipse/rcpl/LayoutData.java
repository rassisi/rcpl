package org.eclipse.rcpl;

import java.util.List;

import javafx.geometry.Point2D;

/**
 * @author ramin
 * 
 */
public class LayoutData {

	public boolean pause;

	public long startTime;

	public List<IHeader> headers;

	public List<IFooter> footers;

	public int index = 0;

	public int layoutCount = -1;

	public int caretOffset = 0;

	public int layoutNotChangedCounter = 0;

	public IPage firstPageAfterPageBreakAfter = null;

	private double x;

	private double y;

	public IPage page;

	public ISection actualSection;

	public Point2D layoutResult;

	public List<ILayoutObject> rootObjects;

	public int pageBreakCounter;

	public int sameLocation = 0;

	public ILayoutObject firstDirtyObject;

	public int pageCount = 0;

	public boolean requestInterrupt;

	private ILayoutService layoutService;

	public int pageCountAtTheBeginning;

	public boolean breakBefore;

	public LayoutData(ILayoutService layoutService) {
		this.layoutService = layoutService;
	}

	public void clear() {
		pause = false;
		startTime = 0;
		headers = null;
		footers = null;
		index = 0;
		layoutCount = -1;
		caretOffset = 0;
		layoutNotChangedCounter = 0;
		firstPageAfterPageBreakAfter = null;
		x = 0;
		y = 0;
		page = null;
		actualSection = null;
		layoutResult = null;
		rootObjects = null;
		pageBreakCounter = 0;
		sameLocation = 0;
		breakBefore = false;
	}

	/**
	 * @return
	 */
	public ILayoutObject getLayoutObject() {
		if (index < 0) {
			index = 0;
		}
		if (index < rootObjects.size()) {
			return rootObjects.get(index);
		}
		return null;
	}

	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		if (getLayoutObject() != null) {
			buf.append(getLayoutObject().toString()); // $NON-NLS-1$
			// buf.append("\nlayoutBounds = " + x + "," + y + "," + width + ","
			// + height);
		}
		return buf.toString();
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public ILayoutObject getLastRootObject() {
		if (rootObjects.isEmpty()) {
			return null;
		}
		return rootObjects.get(rootObjects.size() - 1);
	}

	public boolean compleated() {
		if (rootObjects != null && page != null && layoutService.getEditor() != null) {
			return index >= rootObjects.size()
					|| page.getPageNumber() > 1 && layoutService.getEditor().getDocument().isOnePage();
		}
		return false;
	}

	public boolean pageCountHasChanged() {
		return layoutService.getEditor().getPageCount() != pageCountAtTheBeginning;
	}
}
