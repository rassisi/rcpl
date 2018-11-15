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
public class SpreadsheetDemo extends Application {

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
				IParagraph paragraph = new SimpleParagraph("test paragraph");
				table.addParagraph(paragraph, 1, 1);
			}
		});
		vbox.getChildren().add(button);

		// ----------- table ---------------------

		IParagraph paragraph = new SimpleParagraph("test");

		table.setColumnWidth(1, 100);
		table.setRowHeight(1, 50);
		table.setColumnSpan(1, 1, 3);
//		table.setRowSpan(1, 1, 2);

		table.addParagraph(paragraph, 1, 1);

		table.setStyle(1, 1, "-fx-border-color: red;-fx-border-width: 1;");

		VBox.setVgrow(table.getNode(), Priority.ALWAYS);
		vbox.getChildren().add(table.getNode());

		// ---------------------------------------

		stage.setScene(scene);
		stage.centerOnScreen();
		stage.show();
	}

}