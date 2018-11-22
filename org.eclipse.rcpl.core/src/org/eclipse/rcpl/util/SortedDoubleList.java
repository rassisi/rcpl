package org.eclipse.rcpl.util;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author Ramin
 *
 */
public class SortedDoubleList extends ArrayList<Double> {

	private static final long serialVersionUID = 2214051199687083689L;

	private Comparator<Double> comparator;

	public SortedDoubleList() {
		super();
		comparator = new Comparator<Double>() {

			@Override
			public int compare(Double o1, Double o2) {
				return (int) (o1.doubleValue() - o2.doubleValue());
			}
		};
	}

	@Override
	public boolean add(Double e) {
		boolean result = super.add(e);
		sort(comparator);
		return result;
	}

}
