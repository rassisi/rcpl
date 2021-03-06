package org.eclipse.rcpl.laborytory;

import org.eclipse.rcpl.IColor;
import org.eclipse.rcpl.IParagraph;
import org.eclipse.rcpl.ui.controls.table.RcplTable;
import org.eclipse.rcpl.ui.controls.table.SimpleParagraph;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author Ramin
 *
 */
public class TableDemo extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Table View Sample");
		stage.setWidth(1200);
		stage.setHeight(700);

		// ---------- vbox -----------------------

		final VBox vbox = new VBox();
		vbox.setSpacing(5);
		Scene scene = new Scene(vbox);

		// ---------- spreadsheet

//		RcplTable table = new RcplTable(100, 100);

		// ---------- normal table without header

		RcplTable table = new RcplTable(false, false);

		FlowPane buttonbox = new FlowPane();
		buttonbox.setHgap(10);
		buttonbox.setVgap(10);
		vbox.getChildren().add(buttonbox);

		// ---------------------------------------------------------

		final Button tb0 = new Button("Reset");
		tb0.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				table.clearAll();
			}
		});
		buttonbox.getChildren().add(tb0);

		// --------------------------------------------------------

		final Button tbi = new Button("Init");
		tbi.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				IParagraph paragraph = new SimpleParagraph("test asd a sd asd a sd a sd asd  asd a sd a sd asd a sd ");
				table.addLayoutObject(paragraph, 1, 1);
				table.update();
			}
		});
		buttonbox.getChildren().add(tbi);

		// ---------------------------------------------------------

		final Button button = new Button("Add Paragraph");
		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				IParagraph paragraph = new SimpleParagraph("test");
//				int row = 3; // (int) (Math.random() * 10);
//				int col = 0; // (int) (Math.random() * 10);
//
//				table.setWrap(row, col, true);
//				table.addLayoutObject(paragraph, row, col);

				int row = (int) (Math.random() * 10);
				int col = (int) (Math.random() * 10);

				VBox vbox = table.getCellContentPane(row, col);
				if (vbox.getChildren().isEmpty()) {
					table.setWrap(row, col, true);
					table.addLayoutObject(paragraph, row, col);
				}
			}
		});
		buttonbox.getChildren().add(button);

		// ---------------------------------------------------------

		final ToggleButton tb1 = new ToggleButton("Show Grid");
		tb1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				table.showGrid(tb1.isSelected());
			}
		});
		table.showGrid(true);
		buttonbox.getChildren().add(tb1);

		// ---------------------------------------------------------

		final ToggleButton tb11 = new ToggleButton("All Borders");
		tb11.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				table.setAllBorders(tb11.isSelected());
			}
		});
		table.showGrid(true);
		buttonbox.getChildren().add(tb11);

		// ---------------------------------------------------------

		final ToggleButton tb2 = new ToggleButton("Auto Column");
		tb2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				table.setAutoColumnSize(tb2.isSelected());
			}
		});
		buttonbox.getChildren().add(tb2);

		// ---------------------------------------------------------

		final ToggleButton tb22 = new ToggleButton("Auto Row");
		tb22.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				table.setAutoRowSize(tb22.isSelected());
			}
		});
		buttonbox.getChildren().add(tb22);

		// ---------------------------------------------------------

		final ToggleButton tb3 = new ToggleButton("Equal Columns");
		tb3.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				table.setEqualColumns(tb3.isSelected());
			}
		});
		tb3.setSelected(false);
		buttonbox.getChildren().add(tb3);

		// ---------------------------------------------------------

		final ToggleButton tb4 = new ToggleButton("Column span (1,1,3)");
		tb4.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				if (tb4.isSelected()) {
					table.setColumnSpan(1, 1, 3);
				} else {
					table.setColumnSpan(1, 1, 1);
				}
			}
		});
		buttonbox.getChildren().add(tb4);

		// ---------------------------------------------------------

		final ToggleButton tb5 = new ToggleButton("Row span (1,1,2)");
		tb5.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				if (tb5.isSelected()) {
					table.setRowSpan(1, 1, 2);
				} else {
					table.setRowSpan(1, 1, 1);
				}
			}
		});
		buttonbox.getChildren().add(tb5);

		// ---------------------------------------------------------

		final ToggleButton tb6 = new ToggleButton("wrap (1,1)");
		tb6.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				table.setWrap(1, 1, tb6.isSelected());
			}
		});
		buttonbox.getChildren().add(tb6);

		// ---------------------------------------------------------

		final ToggleButton tb7 = new ToggleButton("border 1,1");
		tb7.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (tb7.isSelected()) {
					table.setCellBorder(1, 1, IColor.BLUE, 1.0);
				} else {
					table.setCellBorder(1, 1, null, 0);
				}
			}
		});
		buttonbox.getChildren().add(tb7);

		// ---------------------------------------------------------

		final ToggleButton tb8 = new ToggleButton("bg 1,1");
		tb8.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (tb8.isSelected()) {
					table.setCellBg(1, 1, IColor.GREEN);
				} else {
					table.setCellBg(1, 1, null);
				}
			}
		});
		buttonbox.getChildren().add(tb8);

		// ----------- table ---------------------

		StackPane st = new StackPane();
		st.getChildren().add(table.getNode());

		VBox.setVgrow(st, Priority.ALWAYS);
		vbox.getChildren().add(st);

		// ---------------------------------------

		stage.setScene(scene);
		stage.centerOnScreen();
		stage.show();
	}

}