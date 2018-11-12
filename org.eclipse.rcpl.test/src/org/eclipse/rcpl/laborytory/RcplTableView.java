package org.eclipse.rcpl.laborytory;

import org.eclipse.rcpl.ICellable;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.util.Callback;

/**
 * @author Ramin
 *
 */
public class RcplTableView extends TableView<RcplCellRow> {

	private boolean spreadsheet;

	private RcplTable table;

	public RcplTableView(RcplTable table) {
		this(table, false);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public RcplTableView(RcplTable table, boolean spreadsheet) {
		this.spreadsheet = spreadsheet;
		for (int i = 0; i < RcplTable.MAX_COLUMNS; i++) {
			String name = "";
			if (this.spreadsheet && i > 0) {
				name = calculateColumnName(i - 1);
			}
			TableColumn<RcplCellRow, ICellable> column = new TableColumn<RcplCellRow, ICellable>(name);
			getColumns().addAll(column);
		}

		for (int col = 0; col < RcplTable.MAX_COLUMNS; col++) {
			TableColumn column = getColumns().get(col);

			final int col0 = col;
			Callback callBack = new Callback<CellDataFeatures<RcplCellRow, ICellable>, ObservableValue<ICellable>>() {

				@Override
				public ObservableValue<ICellable> call(CellDataFeatures<RcplCellRow, ICellable> param) {
					RcplCellRow row = param.getValue();
					ICellable p = row.get(col0);
					return new SimpleObjectProperty<ICellable>(p);
				}
			};

			column.setCellValueFactory(callBack);

			column.setCellFactory(
					new Callback<TableColumn<RcplCellRow, ICellable>, TableCell<RcplCellRow, ICellable>>() {

						@Override
						public TableCell<RcplCellRow, ICellable> call(TableColumn<RcplCellRow, ICellable> param) {
							return new RcplTableCell();
						}
					});
		}

	}

	private String calculateColumnName(int number) {
		String letter = ""; //$NON-NLS-1$
		// Repeatedly divide the number by 26 and convert the
		// remainder into the appropriate letter.
		while (number >= 0) {
			final int remainder = number % 26;
			letter = (char) (remainder + 'A') + letter;
			number = number / 26 - 1;
		}

		return letter;
	}

}
