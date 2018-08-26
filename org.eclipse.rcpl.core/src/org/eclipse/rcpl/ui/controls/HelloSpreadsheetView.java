package org.eclipse.rcpl.ui.controls;

import org.controlsfx.control.spreadsheet.SpreadsheetView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * Build the UI and launch the Application
 */
public class HelloSpreadsheetView extends Application {

	@Override
	public void start(final Stage stage) {

		SpreadsheetConfiguration conf = new SpreadsheetConfiguration();
		conf.setRowStripes(3);
		spreadSheetView = new RcplSpreadsheetView(conf);

		StackPane st = new StackPane();

		st.getChildren().add(spreadSheetView);
		Scene scene = new Scene(st, 1000, 850);
		stage.setScene(scene);
		stage.centerOnScreen();
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

	private SpreadsheetView spreadSheetView;

	private final CheckBox rowHeader = new CheckBox();
	private final CheckBox columnHeader = new CheckBox();
	private final CheckBox selectionMode = new CheckBox();
	private final CheckBox displaySelection = new CheckBox();
	private final CheckBox editable = new CheckBox();

//	@Override
//	public String getControlStylesheetURL() {
//		return "/org/controlsfx/samples/spreadsheetSample.css";
//	}

//	/**
//	 * Build a common control Grid with some options on the left to control the
//	 * SpreadsheetViewInternal
//	 *
//	 * @param gridType
//	 *
//	 * @param spreadsheetView
//	 * @return
//	 */
//	private GridPane buildCommonControlGrid() {
//		final GridPane grid = new GridPane();
//		grid.setHgap(5);
//		grid.setVgap(5);
//		grid.setPadding(new Insets(5, 5, 5, 5));
//
//		int row = 0;
//
//		// row header
//		Label rowHeaderLabel = new Label("Row header: ");
//		rowHeaderLabel.getStyleClass().add("property");
//		grid.add(rowHeaderLabel, 0, row);
//		rowHeader.setSelected(true);
//		spreadSheetView.setShowRowHeader(true);
//
//		grid.add(rowHeader, 1, row++);
//		rowHeader.selectedProperty().addListener(new ChangeListener<Boolean>() {
//			@Override
//			public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
//				spreadSheetView.setShowRowHeader(arg2);
//			}
//		});
//
//		// column header
//		Label columnHeaderLabel = new Label("Column header: ");
//		columnHeaderLabel.getStyleClass().add("property");
//		grid.add(columnHeaderLabel, 0, row);
//		columnHeader.setSelected(true);
//		spreadSheetView.setShowColumnHeader(true);
//
//		grid.add(columnHeader, 1, row++);
//		columnHeader.selectedProperty().addListener(new ChangeListener<Boolean>() {
//			@Override
//			public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
//				spreadSheetView.setShowColumnHeader(arg2);
//			}
//		});
//
//		// editable
//		Label editableLabel = new Label("Editable: ");
//		editableLabel.getStyleClass().add("property");
//		grid.add(editableLabel, 0, row);
//		editable.setSelected(true);
//		spreadSheetView.setEditable(true);
//		grid.add(editable, 1, row++);
//		spreadSheetView.editableProperty().bind(editable.selectedProperty());
//
//		// Row Header width
//		Label rowHeaderWidth = new Label("Row header width: ");
//		rowHeaderWidth.getStyleClass().add("property");
//		grid.add(rowHeaderWidth, 0, row);
//		Slider slider = new Slider(15, 100, 30);
//		spreadSheetView.rowHeaderWidthProperty().bind(slider.valueProperty());
//
//		grid.add(slider, 1, row++);
//
//		// Zoom
//		Label zoom = new Label("Zoom: ");
//		zoom.getStyleClass().add("property");
//		grid.add(zoom, 0, row);
//		Slider sliderZoom = new Slider(0.25, 2, 1);
//		spreadSheetView.zoomFactorProperty().bindBidirectional(sliderZoom.valueProperty());
//
//		grid.add(sliderZoom, 1, row++);
//
//		// Multiple Selection
//		Label selectionModeLabel = new Label("Multiple selection: ");
//		selectionModeLabel.getStyleClass().add("property");
//		grid.add(selectionModeLabel, 0, row);
//		selectionMode.setSelected(true);
//		grid.add(selectionMode, 1, row++);
//		selectionMode.selectedProperty().addListener(new ChangeListener<Boolean>() {
//			@Override
//			public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean isSelected) {
//				spreadSheetView.getSelectionModel().clearSelection();
//				spreadSheetView.getSelectionModel()
//						.setSelectionMode(isSelected ? SelectionMode.MULTIPLE : SelectionMode.SINGLE);
//			}
//		});
//
//		// Display selection
//		Label displaySelectionLabel = new Label("Display selection: ");
//		displaySelectionLabel.getStyleClass().add("property");
//		grid.add(displaySelectionLabel, 0, row);
//		displaySelection.setSelected(true);
//		grid.add(displaySelection, 1, row++);
//		displaySelection.selectedProperty().addListener(new ChangeListener<Boolean>() {
//			@Override
//			public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean isSelected) {
//				spreadSheetView.getGrid().setDisplaySelection(isSelected);
//				spreadSheetView.getSelectionModel().clearSelection();
//			}
//		});
//
//		return grid;
//	}

}
