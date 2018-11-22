package org.eclipse.rcpl.util;

import java.util.ArrayList;
import java.util.Comparator;

import javafx.geometry.Point2D;

/**
 * @author Ramin
 *
 */
public class SortedPoint2DList extends ArrayList<Point2D> {

	private static final long serialVersionUID = -4792636984943206665L;

	private Comparator<Point2D> comparator;

	public SortedPoint2DList() {
		super();
		comparator = new Comparator<Point2D>() {

			@Override
			public int compare(Point2D o1, Point2D o2) {
				double x1 = o1.getX();
				double x2 = o2.getX();
				double y1 = o1.getY();
				double y2 = o2.getY();

				if (y1 < y2) {
					return -1;
				} else if (y1 > y2) {
					return 1;
				}

				if (x1 < x2) {
					return -1;
				} else if (x1 > x2) {
					return 1;
				}

				return 0;
			}
		};
	}

	public void sort() {
		sort(comparator);
	}

}
