package org.eclipse.rcpl.laborytory;

import org.eclipse.rcpl.IParagraph;
import org.eclipse.rcpl.ui.controls.table.RcplTable;
import org.eclipse.rcpl.ui.controls.table.SimpleParagraph;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * @author Ramin
 *
 */
public class TableWidthHeaderDemo extends Application {

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
		vbox.setPadding(new Insets(10, 0, 0, 10));
		Scene scene = new Scene(vbox);

		RcplTable table = new RcplTable(true, true);

		final Button button = new Button("Test");
		button.setFont(new Font("Arial", 20));
		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
//				RcplTableData data = new RcplTableData(table);
//				IParagraph paragraph = new SimpleParagraph("test");
//				data.setParagraph(paragraph, 10, 20);
			}
		});
		vbox.getChildren().add(button);

		// ----------- table ---------------------

		IParagraph paragraph = new SimpleParagraph("test");

		table.addLayoutObject(paragraph, 10, 10);

		table.setColumnWidth(3, 200);
		table.setRowHeight(10, 50);
		table.setColumnSpan(20, 5, 3);

		table.setRowSpan(25, 10, 2);
//		table.getData().setParagraph(paragraph, 1, 2);
//		table.setColumnWidth(2, 100);
//		table.setRowHeight(5, 100);
		VBox.setVgrow(table.getNode(), Priority.ALWAYS);
		vbox.getChildren().add(table.getNode());
//		table.updateCss(scene);

		// ---------------------------------------

		stage.setScene(scene);
		stage.centerOnScreen();
		stage.show();
	}

}