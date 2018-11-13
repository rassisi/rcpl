package org.eclipse.rcpl.laborytory;

import org.eclipse.rcpl.ICellable;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

/**
 * @author Ramin
 *
 */
public class RcplTableView extends TableView<RcplCellRow> {

	private final static double DEFAUL_COLUMN_WIDTH = 80.0;

	private final RcplTable table;

	public RcplTableView(RcplTable table) {
		this.table = table;
		if (table.isSpreadsheet()) {
			createColumns();
			getColumns().get(0).setPrefWidth(40);
		}
		setEditable(true);

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void createColumns() {
		getColumns().clear();
		for (int col = 0; col < table.getData().getColumnCount(); col++) {
			String name = "";
			if (table.isSpreadsheet() && col > 0) {
				name = RcplTableUtil.calculateColumnName(col - 1);
			}
			TableColumn<RcplCellRow, ICellable> column = new TableColumn<RcplCellRow, ICellable>(name);
			column.setSortable(false);
			if (col == 0) {
				if (table.isSpreadsheet()) {
					column.setPrefWidth(40);
					column.setMaxWidth(40);
					column.setMinWidth(40);
					Pane pane = new Pane();
					pane.setPrefWidth(40);
					pane.setStyle("-fx-background-color: gray;");
					column.setGraphic(pane);
				} else {
					column.setPrefWidth(DEFAUL_COLUMN_WIDTH);
				}
			} else {
				column.setPrefWidth(DEFAUL_COLUMN_WIDTH);
			}
			column.setSortable(false);
			getColumns().add(column);
		}

		for (int col = 0; col < table.getData().getColumnCount(); col++) {
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

			column.setOnEditStart(new EventHandler<Event>() {

				@Override
				public void handle(Event event) {

					CellEditEvent ce = (CellEditEvent) event;
					TablePosition pos = ce.getTablePosition();

					System.out.println("row = " + pos.getRow() + "  column = " + pos.getColumn());

				}
			});
		}
	}

	public RcplTable getTable() {
		return table;
	}

}
