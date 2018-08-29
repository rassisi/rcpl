/**
 * Copyright (c) 2013, 2014 ControlsFX
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 *     * Neither the name of ControlsFX, any associated website, nor the
 * names of its contributors may be used to endorse or promote products
 * derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL CONTROLSFX BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package impl.org.controlsfx.spreadsheet;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.controlsfx.control.spreadsheet.SpreadsheetView;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.IndexedCell;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.skin.VirtualFlow;
import javafx.scene.layout.Region;
import javafx.scene.shape.Rectangle;

final public class GridVirtualFlow<T extends IndexedCell<?>> extends VirtualFlow<T> {

	/**
	 * With that comparator we can lay out our rows in the reverse order. That is to
	 * say from the bottom to the very top. In that manner we are sure that our
	 * spanning cells will COVER the cell below so we don't have any problems with
	 * missing hovering, the editor jammed etc. <br/>
	 *
	 * The only problem is for the fixed column but the {@link #getTopRow(int) } now
	 * returns the very first row and allow us to put some priviledge TableCell in
	 * it if they feel the need to be on top in term of z-order.
	 *
	 * FIXME The best would be to put a TreeList of something like that in order not
	 * to sort the rows everytime, need investigation..
	 */
	private static final Comparator<GridRow> ROWCMP = new Comparator<GridRow>() {
		@Override
		public int compare(GridRow firstRow, GridRow secondRow) {
			// o1.getIndex() < o2.getIndex() ? -1 : +1;
			return secondRow.getIndex() - firstRow.getIndex();
		}
	};

	/***************************************************************************
	 * * Private Fields * *
	 **************************************************************************/
	private SpreadsheetView spreadSheetView;
	private final GridViewSkin gridViewSkin;
	/**
	 * Store the fixedRow in order to place them at the top when necessary. That is
	 * to say, when the VirtualFlow has not already placed one.
	 */
	private final ArrayList<T> myFixedCells = new ArrayList<>();
	public final List<Node> sheetChildren;

	/***************************************************************************
	 * * Constructor * *
	 **************************************************************************/
	public GridVirtualFlow(GridViewSkin gridViewSkin) {
		super();
		this.gridViewSkin = gridViewSkin;
		final ChangeListener<Number> listenerY = new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
				layoutTotal();
			}
		};

		// !!! assisi
//		getVbar().valueProperty().addListener(listenerY);
//		getHbar().valueProperty().addListener(hBarValueChangeListener);

		widthProperty().addListener(hBarValueChangeListener);

		// FIXME Until https://javafx-jira.kenai.com/browse/RT-31777 is resolved
		// !!! assisi
//		getHbar().setUnitIncrement(10);

		sheetChildren = findSheetChildren();
	}

	/***************************************************************************
	 * * Public Methods * *
	 **************************************************************************/
	public void init(SpreadsheetView spv) {
		this.spreadSheetView = spv;

		// We clip the rectangle selection with a rectangle, inception style.
		Rectangle rec = new Rectangle();
		// !!! assisi
//		rec.widthProperty().bind(widthProperty().subtract(getVbar().widthProperty()));
//		rec.heightProperty().bind(heightProperty().subtract(getHbar().heightProperty()));
		gridViewSkin.rectangleSelection.setClip(rec);

		getChildren().add(gridViewSkin.rectangleSelection);

		spv.getFixedRows().addListener(new ListChangeListener<Integer>() {
			@Override
			public void onChanged(javafx.collections.ListChangeListener.Change<? extends Integer> change) {
				while (change.next()) {
					if (change.wasRemoved()) {
						List<? extends Integer> list = change.getRemoved();
						for (Integer i : list) {
							for (T cell : myFixedCells) {
								if (cell.getIndex() == i) {
									cell.setManaged(false);
									cell.setVisible(false);
//                                                                        sheetChildren.remove(cell);
									myFixedCells.remove(cell);
									break;
								}
							}
						}
					}
				}
			}
		});
	}

	// !!! assisi
//	@Override
//	public void show(int index) {
//		super.show(index);
//		layoutTotal();
//		layoutFixedRows();
//	}

	// !!! assisi

//	@Override
//	public void scrollTo(int index) {
//		// If we have some fixedRows, we check if the selected row is not below them
//		if (!getCells().isEmpty() && spreadSheetView.getFixedRows().size() > 0) {
//			double offset = gridViewSkin.getFixedRowHeight();
//
//			while (offset >= 0 && index > 0) {
//				index--;
//				offset -= spreadSheetView.getGrid().getRowHeight(index);
//			}
//		}
//		super.scrollTo(index);
//
//		layoutTotal();
//		layoutFixedRows();
//	}

	// !!! assisi
//	@Override
//	public double adjustPixels(final double delta) {
//		final double returnValue = super.adjustPixels(delta);
//
//		layoutTotal();
//		layoutFixedRows();
//
//		return returnValue;
//	}

	/***************************************************************************
	 * * Protected Methods * *
	 **************************************************************************/

	/**
	 * We need to return here the very top row in term of "z-order". Because we will
	 * add in this row the TableCell that are in fixedColumn and which needs to be
	 * drawn on top of all others.
	 *
	 * @return
	 */
	GridRow getTopRow() {
		if (!sheetChildren.isEmpty()) {
			return (GridRow) sheetChildren.get(sheetChildren.size() - 1);
		}
		return null;
	}

	@Override
	protected void layoutChildren() {
		// We don't want to layout everything in case we're editing
		// because it has no sense
		if (spreadSheetView != null
				&& (spreadSheetView.getEditingCell() == null || spreadSheetView.getEditingCell().getRow() == -1)) {
			sortRows();
			super.layoutChildren();
			layoutTotal();
			layoutFixedRows();
		}
	}

	/**
	 * Layout all the visible rows
	 */
	protected void layoutTotal() {
		sortRows();

		/**
		 * When we layout, we also remove the cell that have been deported into other
		 * rows in order not to have some TableCell hanging out.
		 */
		for (GridRow row : gridViewSkin.deportedCells.keySet()) {
			for (CellView cell : gridViewSkin.deportedCells.get(row)) {
				row.removeCell(cell);
			}
		}
		gridViewSkin.deportedCells.clear();
		// When scrolling fast with fixed Rows, cells is empty and not recreated..

		// !!! assisi
//		if (getCells().isEmpty()) {
//			reconfigureCells();
//		}
//
//		for (GridRow cell : (List<GridRow>) getCells()) {
//			if (cell != null && (!gridViewSkin.hBarValue.get(cell.getIndex())
//					|| gridViewSkin.rowToLayout.get(cell.getIndex()))) {
//				cell.requestLayout();
//			}
//		}
	}

	// !!! assisi
//	protected VirtualScrollBar getVerticalBar() {
//		return getVbar();
//	}
//
//	protected VirtualScrollBar getHorizontalBar() {
//		return getHbar();
//	}
//
//	@Override
//	protected List<T> getCells() {
//		return super.getCells();
//	}

	/***************************************************************************
	 * * Private Methods * *
	 **************************************************************************/

	/**
	 * WARNING : This is bad but no other options right now. This will find the
	 * sheetChildren of the VirtualFlow, aka where the cells are kept and clipped.
	 * See layoutFixedRows() or getTopRow() for use.
	 *
	 * @return
	 */
	private List<Node> findSheetChildren() {
		if (!getChildren().isEmpty()) {
			if (getChildren().get(0) instanceof Region) {
				Region region = (Region) getChildren().get(0);
				if (!region.getChildrenUnmodifiable().isEmpty()) {
					if (region.getChildrenUnmodifiable().get(0) instanceof Group) {
						return ((Group) region.getChildrenUnmodifiable().get(0)).getChildren();
					}
				}
			}
		}
		return new ArrayList<>();
	}

	/**
	 * Layout the fixed rows to position them correctly
	 */
	private void layoutFixedRows() {

		// !!! assisi

//		// We must have a cell in ViewPort because otherwise
//		// we short-circuit the VirtualFlow.
//		if (spreadSheetView.getFixedRows().size() > 0 && getFirstVisibleCellWithinViewPort() != null) {
//			sortRows();
//			/**
//			 * What I do is just going after the VirtualFlow in order to ADD (not replace
//			 * like before) new rows at the top.
//			 *
//			 * If the VirtualFlow has the row, then I will hide mine and let him handle. But
//			 * if the row is missing, then I must show mine in order to have the fixed row.
//			 */
//			T row = null;
//			Integer fixedRowIndex;
//
//			rows: for (int i = spreadSheetView.getFixedRows().size() - 1; i >= 0; i--) {
//				fixedRowIndex = spreadSheetView.getFixedRows().get(i);
//				T lastCell = getLastVisibleCellWithinViewPort();
//				// If the fixed row is out of bounds
//				if (lastCell != null && fixedRowIndex > lastCell.getIndex()) {
//					if (row != null) {
//						row.setVisible(false);
//						row.setManaged(false);
//						sheetChildren.remove(row);
//					}
//					continue;
//				}
//
//				// We see if the row is laid out by the VirtualFlow
//				for (T virtualFlowCells : getCells()) {
//					if (virtualFlowCells.getIndex() > fixedRowIndex) {
//						break;
//					} else if (virtualFlowCells.getIndex() == fixedRowIndex) {
//						row = containsRows(fixedRowIndex);
//						if (row != null) {
//							row.setVisible(false);
//							row.setManaged(false);
//							sheetChildren.remove(row);
//						}
//						/**
//						 * OLD COMMENT : We must push to Front only if the row is at the very top and
//						 * has a risk to be recovered. This is happening only if this row is translated.
//						 *
//						 * NEW COMMENT: I'm not sure about this.. Since the fixedColumn are not in the
//						 * special top row, we don't care if the row is pushed to front.. need
//						 * investigation
//						 */
//						virtualFlowCells.toFront();
//						continue rows;
//					}
//				}
//
//				row = containsRows(fixedRowIndex);
//				if (row == null) {
//					/**
//					 * getAvailableCell is not added our cell to the ViewPort in some cases. So we
//					 * need to instantiate it ourselves.
//					 */
//					row = getCreateCell().call(this);
//					row.getProperties().put("newcell", null); //$NON-NLS-1$
//
//					setCellIndex(row, fixedRowIndex);
//					resizeCellSize(row);
//					myFixedCells.add(row);
//				}
//
//				/**
//				 * Sometime, when we set a new Grid on a SpreadsheetView without recreating it,
//				 * we can end up with some rows not being added to the ViewPort. So we must be
//				 * sure it's in and add it ourself otherwise.
//				 */
//				if (!sheetChildren.contains(row)) {
//					sheetChildren.add(row);
//				}
//
//				row.setManaged(true);
//				row.setVisible(true);
//				row.toFront();
//				row.requestLayout();
//			}
//		}
	}

	/**
	 * Verify if the row has been added to myFixedCell
	 * 
	 * @param i
	 * @return
	 */
	private T containsRows(int i) {
		for (T cell : myFixedCells) {
			if (cell.getIndex() == i)
				return cell;
		}
		return null;
	}

	/**
	 * Sort the rows so that they stay in order for layout
	 */
	private void sortRows() {
		// !!! assisi
//		final List<GridRow> temp = (List<GridRow>) getCells();
//		final List<GridRow> tset = new ArrayList<>(temp);
//		Collections.sort(tset, ROWCMP);
//		for (final TableRow<ObservableList<SpreadsheetCell>> r : tset) {
//			r.toFront();
//		}
	}

	private final ChangeListener<Number> hBarValueChangeListener = new ChangeListener<Number>() {
		@Override
		public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
			gridViewSkin.hBarValue.clear();
		}
	};

	private static Field fCell;

	private static Method mGetVBar;
	private static Method mGetHBar;

//	private static Class<?> mEmbeddedSpan;

	static {
		try {

			final Method amethod = VirtualFlow.class.getDeclaredMethod("getVbar");
			AccessController.doPrivileged(new PrivilegedAction() {
				public Object run() {
					amethod.setAccessible(true);
					return null; // nothing to return
				}
			});

			mGetVBar = VirtualFlow.class.getDeclaredMethod("getVbar");
			mGetHBar = VirtualFlow.class.getDeclaredMethod("getHbar");
			fCell = VirtualFlow.class.getDeclaredField("cells");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		mGetVBar.setAccessible(true);

		mGetHBar.setAccessible(true);
		fCell.setAccessible(true);
	}

	// !!! assisi new method
	public List<T> getSuperCells() {
		try {
			return (List<T>) fCell.get(this);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ScrollBar getVerticalBar() {
		try {
			return (ScrollBar) mGetVBar.invoke(this);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ScrollBar getHorizontalBar() {
		try {
			return (ScrollBar) mGetHBar.invoke(this);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
