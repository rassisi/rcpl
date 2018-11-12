package org.eclipse.rcpl.laborytory;

import org.eclipse.rcpl.IParagraph;

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
public class RcplTableView extends TableView<RcplParagraphRow> {

	private boolean spreadsheet;

	private RcplTable table;

	public RcplTableView(RcplTable table) {
		this(table, false);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public RcplTableView(RcplTable table, boolean spreadsheet) {
		this.spreadsheet = spreadsheet;
		for (int i = 0; i < table.getNumberOfColumns(); i++) {
			String name = "";
			if (this.spreadsheet) {
				name = calculateColumnName(i);
			}
			TableColumn<RcplParagraphRow, IParagraph> column = new TableColumn<RcplParagraphRow, IParagraph>(name);

			getColumns().addAll(column);

		}

		for (int col = 0; col < table.getNumberOfColumns(); col++) {
			TableColumn column = getColumns().get(col);

//			column.setCellValueFactory(
//					new PropertyValueFactory<RcplParagraphRow, IParagraph>(calculateColumnName(col)));

			final int col0 = col;
			Callback callBack = new Callback<CellDataFeatures<RcplParagraphRow, IParagraph>, ObservableValue<IParagraph>>() {

				@Override
				public ObservableValue<IParagraph> call(CellDataFeatures<RcplParagraphRow, IParagraph> param) {
					RcplParagraphRow row = param.getValue();
					IParagraph p = row.get(col0);
					return new SimpleObjectProperty<IParagraph>(p);
				}
			};

			column.setCellValueFactory(callBack);

			column.setCellFactory(
					new Callback<TableColumn<RcplParagraphRow, IParagraph>, TableCell<RcplParagraphRow, IParagraph>>() {

						@Override
						public TableCell<RcplParagraphRow, IParagraph> call(
								TableColumn<RcplParagraphRow, IParagraph> param) {
							return new RcplTableCell();
						}
					});
		}

	}

	private String calculateColumnName(int x) {
		switch (x) {
		case 0:
			return "A"; //$NON-NLS-1$
		case 1:
			return "B"; //$NON-NLS-1$
		case 2:
			return "C"; //$NON-NLS-1$
		case 3:
			return "D"; //$NON-NLS-1$
		case 4:
			return "E"; //$NON-NLS-1$
		case 5:
			return "F"; //$NON-NLS-1$
		case 6:
			return "G"; //$NON-NLS-1$
		case 7:
			return "H"; //$NON-NLS-1$
		case 8:
			return "I"; //$NON-NLS-1$
		case 9:
			return "J"; //$NON-NLS-1$
		case 10:
			return "K"; //$NON-NLS-1$
		case 11:
			return "L"; //$NON-NLS-1$
		case 12:
			return "M"; //$NON-NLS-1$
		case 13:
			return "N"; //$NON-NLS-1$
		case 14:
			return "O"; //$NON-NLS-1$
		case 15:
			return "P"; //$NON-NLS-1$
		case 16:
			return "Q"; //$NON-NLS-1$
		case 17:
			return "R"; //$NON-NLS-1$
		case 18:
			return "S"; //$NON-NLS-1$
		case 19:
			return "T"; //$NON-NLS-1$
		case 20:
			return "U"; //$NON-NLS-1$
		case 21:
			return "V"; //$NON-NLS-1$
		case 22:
			return "W"; //$NON-NLS-1$
		case 23:
			return "X"; //$NON-NLS-1$
		case 24:
			return "Y"; //$NON-NLS-1$
		case 25:
			return "Z"; //$NON-NLS-1$

		default:
			return "X"; // cannot happen //$NON-NLS-1$
		}
	}

}
