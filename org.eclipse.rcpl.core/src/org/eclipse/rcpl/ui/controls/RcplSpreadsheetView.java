package org.eclipse.rcpl.ui.controls;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.controlsfx.control.spreadsheet.GridBase;
import org.controlsfx.control.spreadsheet.Picker;
import org.controlsfx.control.spreadsheet.SpreadsheetCell;
import org.controlsfx.control.spreadsheet.SpreadsheetCellBase;
import org.controlsfx.control.spreadsheet.SpreadsheetCellType;
import org.controlsfx.control.spreadsheet.SpreadsheetColumn;
import org.controlsfx.control.spreadsheet.SpreadsheetView;
import org.eclipse.rcpl.util.RcplUtil;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TablePosition;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

/**
 * @author Ramin
 *
 */
public class RcplSpreadsheetView extends SpreadsheetView {

	final private SpreadsheetConfiguration configuration;

	private GridBase grid;

	public final static String EMTPTY_CELL_STYLE = "-fx-background-color: ghostwhite;";

	private final static int PREF_COLUMN_WIDTH = 100;

	public RcplSpreadsheetView(SpreadsheetConfiguration configuration) {

		this.configuration = configuration;

		buildGrid();
		createPickers();
//		getFixedRows().add(0);
		for (SpreadsheetColumn c : getColumns()) {
			c.setPrefWidth(PREF_COLUMN_WIDTH);
		}

//		getColumns().get(0).setFixed(true);

		getStylesheets().add(RcplSpreadsheetView.class.getResource("spreadsheet.css").toExternalForm());

//		getSkin().getNode().setOnMouseClicked(new EventHandler<MouseEvent>() {
//
//			@Override
//			public void handle(MouseEvent event) {
//				EventTarget target = event.getTarget();
//				if (target instanceof CellView) {
//					CellView v = (CellView) target;
//					SpreadsheetCell oldCell = v.getItem();
//					if (oldCell instanceof EmptyCell) {
//						int rowSpan = oldCell.getRowSpan();
//						int colSpan = oldCell.getColumnSpan();
//						SpreadsheetCell cell = createCell(CellType.STRING, oldCell.getRow(), oldCell.getColumn(),
//								rowSpan, colSpan, "", "", 0, true);
//						cell.setEditable(true);
//						cell.setStyle(oldCell.getStyle());
//					}
//				}
//				event.consume();
//			}
//		});

		getSkin().getNode().setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				KeyCode code = event.getCode();

				if (KeyCode.DOWN.equals(code)) {

					ObservableList<TablePosition> list = getSelectionModel().getSelectedCells();
					if (!list.isEmpty()) {
						int row = list.get(0).getRow();
						if (row == grid.getRowCount() - 1) {
							addRow(CellType.STRING, "");
						}
					}
				}
				if (KeyCode.RIGHT.equals(code)) {

					ObservableList<TablePosition> list = getSelectionModel().getSelectedCells();
					if (!list.isEmpty()) {
						int col = list.get(0).getColumn();
						System.out.println("Column: " + col + "    col count: " + grid.getColumnCount());

						int colCount = grid.getRows().get(0).size();
						if (col >= colCount - 1) {
							addColumn(CellType.STRING, "");
							addColumn(CellType.STRING, "");
							System.out.println("Column added, col count: " + grid.getColumnCount());
							setGrid(null);
							setGrid(grid);

							scrollToColumn(getColumns().get(getColumns().size() - 1));

						}
					}
				}

			}
		});

	}

	public SpreadsheetCell getCell(int row, int col) {
		try {
			return grid.getRows().get(row).get(col);
		} catch (Exception ex) {
			return null;
		}
	}

	public void setColumnWidth(int column, double width) {
		try {
			getColumns().get(column).setPrefWidth(width);
		} catch (Exception ex) {
			// ignore
		}
	}

	/**
	 * Add some pickers into the SpreadsheetView in order to give some information.
	 */
	private void createPickers() {
		getRowPickers().put(0, new Picker() {

			@Override
			public void onClick() {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setContentText("This row contains several fictive companies. " + "The cells are not editable.\n"
						+ "A custom tooltip is applied for the first cell.");
				alert.show();
			}
		});

		getRowPickers().put(1, new Picker() {

			@Override
			public void onClick() {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setContentText("This row contains cells that can only show a list.");
				alert.show();
			}
		});

		getRowPickers().put(2, new Picker() {

			@Override
			public void onClick() {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setContentText("This row contains cells that display some dates.");
				alert.show();
			}
		});

		getRowPickers().put(3, new Picker() {

			@Override
			public void onClick() {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setContentText("This row contains some Images displaying logos of the companies.");
				alert.show();
			}
		});

		getRowPickers().put(4, new Picker() {

			@Override
			public void onClick() {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setContentText("This row contains Double editable cells. "
						+ "Except for ControlsFX compagny where it's a String.");
				alert.show();
			}
		});
		getRowPickers().put(5, new Picker("picker-label", "picker-label-exclamation") {

			@Override
			public void onClick() {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setContentText("This row contains Double editable cells with "
						+ "a special format (%). Some cells also have " + "a little icon next to their value.");
				alert.show();
			}
		});

		getColumnPickers().put(0, new Picker("picker-label", "picker-label-security") {

			@Override
			public void onClick() {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setContentText("Each cell of this column (except for the "
						+ "separator in the middle) has a particular css " + "class for changing its color.\n");
				alert.show();
			}
		});
	}

//	/**
//	 * Specify a custom row height.
//	 *
//	 * @return
//	 */
//	private Map<Integer, Double> createRowHeight() {
//		Map<Integer, Double> rowHeight = new HashMap<>();
//		rowHeight.put(1, 100.0);
//		return rowHeight;
//	}

	public SpreadsheetCell createCell(CellType type, int row, int column, int rowSpan, int colSpan, Object value,
			String format, int index) {
		return createCell(type, row, column, rowSpan, colSpan, value, format, index, false);
	}

	/**
	 * @param type
	 * @param row
	 * @param column
	 * @param rowSpan
	 * @param colSpan
	 * @param value
	 * @param format
	 * @param index
	 * @return
	 */
	public SpreadsheetCell createCell(CellType type, int row, int column, int rowSpan, int colSpan, Object value,
			String format, int index, boolean setCell) {

		SpreadsheetCell cell = null;
		if (CellType.EMPTY.equals(type)) {
			cell = createEmptyCell(row, column);
		} else if (CellType.DATE.equals(type)) {
			cell = createDateCell(row, column, rowSpan, colSpan);
		} else if (CellType.DOUBLE.equals(type)) {
			cell = createDoubleCell(row, column, rowSpan, colSpan, (double) value, format);
		} else if (CellType.INTEGER.equals(type)) {
			cell = createIntegerCell(row, column, rowSpan, colSpan, (int) value);
		} else if (CellType.OBJECT.equals(type)) {
			cell = createStringCell(row, column, rowSpan, colSpan, (String) value);
		} else if (CellType.STRING.equals(type)) {
			cell = createStringCell(row, column, rowSpan, colSpan, (String) value);
		} else if (CellType.LIST.equals(type)) {
			cell = createListCell(row, column, rowSpan, colSpan, (List<String>) value, index);
		} else if (CellType.DATE.equals(type)) {
			cell = createDateCell(row, column, rowSpan, colSpan);
		} else if (CellType.HYPERLINK.equals(type)) {
			cell = createHyperlinkCell(row, column, rowSpan, colSpan, (String) value);
		}

		if (setCell) {
			setCell(cell);
			spanCell(row, column, rowSpan, colSpan);
		}

		if (cell instanceof SpreadsheetCellBase) {
			final SpreadsheetCellBase cb = (SpreadsheetCellBase) cell;
			cb.textProperty().addListener(new ChangeListener<String>() {
				@Override
				public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
					valueChanged(cb, oldValue, newValue);
				}
			});

		}
		return cell;
	}

	public void valueChanged(SpreadsheetCell cell, String oldValue, String newValue) {

		System.out.println(cell + ": " + oldValue + " --->   " + newValue);

	}

	/**
	 * @param row
	 * @param column
	 * @param rowSpan
	 * @param colSpan
	 * @param value
	 * @param index
	 * @return
	 */
	public SpreadsheetCell createListCell(int row, int column, int rowSpan, int colSpan, List<String> value,
			int index) {
		return SpreadsheetCellType.LIST(value).createCell(row, column, rowSpan, colSpan, value.get(index));
	}

	/**
	 * @param row
	 * @param column
	 * @param rowSpan
	 * @param colSpan
	 * @param value
	 * @return
	 */
	private SpreadsheetCell createStringCell(int row, int column, int rowSpan, int colSpan, String value) {
		SpreadsheetCell cell = SpreadsheetCellType.STRING.createCell(row, column, rowSpan, colSpan, value);
		return cell;
	}

	private SpreadsheetCell createEmptyCell(int row, int column) {
		SpreadsheetCell cell = new EmptyCell(row, column);
		return cell;
	}

	/**
	 * Generate a Date Cell with a random format.
	 *
	 * @param row
	 * @param column
	 * @param rowSpan
	 * @param colSpan
	 * @return
	 */
	public SpreadsheetCell createDateCell(int row, int column, int rowSpan, int colSpan) {
		SpreadsheetCell cell = SpreadsheetCellType.DATE.createCell(row, column, rowSpan, colSpan,
				LocalDate.now().plusDays((int) (Math.random() * 10)));
		final double random = Math.random();
		if (random < 0.25) {
			cell.setFormat("EEEE d");
		} else if (random < 0.5) {
			cell.setFormat("dd/MM :YY");
		} else {
			cell.setFormat("dd/MM/YYYY");
		}
		return cell;
	}

	/**
	 * Generate a Number Cell with a random format.
	 *
	 * @param row
	 * @param column
	 * @param rowSpan
	 * @param colSpan
	 * @return
	 */
	public SpreadsheetCell createIntegerCell(int row, int column, int rowSpan, int colSpan, int value) {
		SpreadsheetCell cell = SpreadsheetCellType.INTEGER.createCell(row, column, rowSpan, colSpan, value);
		return cell;
	}

	/**
	 * Generate a Number Cell with a double format.
	 * 
	 * @param row
	 * @param column
	 * @param rowSpan
	 * @param colSpan
	 * @param value
	 * @param format  #,##0.00" + "\u20AC"); 0.###E0 km/h"); 0.###E0;
	 * @return
	 */
	private SpreadsheetCell createDoubleCell(int row, int column, int rowSpan, int colSpan, double value,
			String format) {

		SpreadsheetCell cell = SpreadsheetCellType.DOUBLE.createCell(row, column, rowSpan, colSpan, value);

		if (format == null || format.length() == 0) {
			cell.setFormat("#,##0.00");
		} else {
			cell.setFormat(format);
		}
		return cell;
	}

	private SpreadsheetCell createHyperlinkCell(int row, int column, int rowSpan, int colSpan, String url) {
		SpreadsheetCell cell = SpreadsheetCellType.STRING.createCell(row, column, 1, 1, null);
		Hyperlink link = new Hyperlink(url);
		Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
		URI uri;
		try {
			uri = new URI(link.getText());
			if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
				link.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent t) {
						try {
							desktop.browse(uri);
						} catch (IOException ex) {
						}
					}
				});
			}
		} catch (URISyntaxException ex) {
		}
		cell.setGraphic(link);
		cell.setEditable(false);
		return cell;
	}

	/**
	 * Build the grid.
	 *
	 * @param grid
	 */
	private void buildGrid() {
		grid = new GridBase(configuration.getInitialRows(), configuration.getInitialColumns());
		for (int row = 0; row < configuration.getInitialRows(); ++row) {
			addRow(CellType.STRING, "");
		}
		setGrid(grid);
	}

	public String getBorderStyle(SpreadsheetCell cell, double topBorderWidth, double rightBorderWidth,
			double bottomBorderWidth, double leftBorderWidth, Color topColor, Color rightColor, Color bottomColor,
			Color leftColor) {

		StringBuilder sb = new StringBuilder();
		sb.append("-fx-border-width: " + topBorderWidth + " " + rightBorderWidth + " " + bottomBorderWidth + " "
				+ leftBorderWidth + ";");

		sb.append(" -fx-border-color: " + RcplUtil.ColorToHexString(topColor) + " "
				+ RcplUtil.ColorToHexString(rightColor) + " " + RcplUtil.ColorToHexString(bottomColor) + " "
				+ RcplUtil.ColorToHexString(leftColor) + ";");
		return sb.toString();
	}

	private void addRow(CellType type, Object value) {
		addRow(grid.getRows().size(), type, value);
	}

	private void addRow(int row, CellType type, Object value) {
		int columnCount = Math.max(grid.getColumnCount(), configuration.getInitialColumns());
		final ObservableList<SpreadsheetCell> rowList = FXCollections.observableArrayList();
		for (int column = 0; column < columnCount; column++) {
			SpreadsheetCell cell = createCell(type, row, column, 1, 1, value, null, 0);
			if (configuration.getRowStripes() > 0) {
				if (row % configuration.getRowStripes() == 0) {
					cell.getStyleClass().add("five_rows");
				}
			}
			if (cell.getStyle() == null) {
				cell.setStyle(EMTPTY_CELL_STYLE);
			}
			rowList.add(cell);
		}
		grid.getRows().add(row, rowList);
	}

	private void addColumn(CellType type, Object value) {
		addColumn(-1, type, value);
	}

	private void addColumn(int column, CellType type, Object value) {

		final ObservableList<ObservableList<SpreadsheetCell>> rowsList = FXCollections.observableArrayList();

		rowsList.addAll(grid.getRows());

		int index = column;
		if (column == -1) {
			index = grid.getColumnCount();
		}
		for (int row = 0; row < grid.getRowCount(); ++row) {
			SpreadsheetCell cell = createCell(type, row, index, 1, 1, value, null, 0);
			if (configuration.getRowStripes() > 0) {
				if (row % configuration.getRowStripes() == 0) {
					cell.getStyleClass().add("five_rows");
				}
			}
			if (cell.getStyle() == null) {
				cell.setStyle(EMTPTY_CELL_STYLE);
			}
			if (column == -1) {
				rowsList.get(row).add(cell);
			} else {
				rowsList.get(row).add(column, cell);
			}
		}

		grid.setRows(rowsList);

		getColumns().get(getColumns().size() - 1).setPrefWidth(PREF_COLUMN_WIDTH);

	}

	public void spanCell(int row, int column, int spanRow, int spanCol) {
		if (spanRow > 0) {
			grid.spanRow(spanRow, row, column);
		}
		if (spanCol > 0) {
			grid.spanColumn(spanCol, row, column);
		}

	}

	public void setCell(SpreadsheetCell cell) {

		int row = cell.getRow();
		int col = cell.getColumn();

		while (grid.getRowCount() < row + 3) {
			addRow(CellType.STRING, "");
		}

		while (grid.getColumnCount() < col + 3) {
			addColumn(CellType.STRING, "");
		}

		grid.getRows().get(cell.getRow()).set(cell.getColumn(), cell);
		if (configuration.getRowStripes() > 0) {
			if (cell.getRow() % configuration.getRowStripes() == 0) {
				cell.getStyleClass().add("five_rows");
			}
		}

	}

	public SpreadsheetConfiguration getConfiguration() {
		return configuration;
	}

	private Map<Integer, Double> rowHeights = new HashMap<>();

	public void setRowHeight(int row, double height) {
		rowHeights.put(row, height);
		grid.setRowHeightCallback(new GridBase.MapBasedRowHeightFactory(rowHeights));
	}

}
