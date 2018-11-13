package org.eclipse.rcpl.laborytory;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.rcpl.ICellable;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableColumn.SortType;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

/**
 * @author Ramin
 *
 */
public class RcplTableView extends TableView<RcplCellRow> {

	private boolean spreadsheet;

	private RcplTable table;

	private List<Pane> rowPanes;

	public RcplTableView(RcplTable table) {
		this(table, false);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public RcplTableView(RcplTable table, boolean spreadsheet) {
		this.spreadsheet = spreadsheet;
		this.rowPanes = new ArrayList<Pane>();
		for (int i = 0; i < RcplTable.MAX_COLUMNS; i++) {
			String name = "";
			if (this.spreadsheet && i > 0) {
				name = RcplTableUtil.calculateColumnName(i - 1);
			}
			TableColumn<RcplCellRow, ICellable> column = new TableColumn<RcplCellRow, ICellable>(name);
			if (i == 0) {
				column.setPrefWidth(40);
				column.setMaxWidth(40);
				column.setMinWidth(40);
				column.setSortable(false);
				column.setSortType(SortType.DESCENDING);
			}
			if (this.spreadsheet && i == 0) {
				Pane pane = new Pane();
				pane.setPrefWidth(40);
				pane.setStyle("-fx-background-color: gray;");
				column.setGraphic(pane);
			}
			column.setSortable(false);
			getColumns().add(column);
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
							return new RcplTableCell(RcplTableView.this);
						}
					});
		}

	}

	public void addRowPane(Pane pane) {
		rowPanes.add(pane);
	}

	public Pane getRowPane(int row) {
		return rowPanes.get(row);
	}
}
