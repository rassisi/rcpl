package org.eclipse.rcpl.laborytory;

import org.eclipse.rcpl.IParagraph;

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
public class TableViewTest extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Table View Sample");
		stage.setWidth(800);
		stage.setHeight(500);

		// ---------- vbox -----------------------

		final VBox vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		Scene scene = new Scene(vbox);

		RcplTable table = new RcplTable(false);

		final Button button = new Button("Test");
		button.setFont(new Font("Arial", 20));
		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				RcplTableData data = new RcplTableData(table);
				IParagraph paragraph = new SimpleParagraph("test");
				data.setParagraph(paragraph, 10, 20);
				table.setData(data);
			}
		});
		vbox.getChildren().add(button);

		// ----------- table ---------------------

		table.setEditable(true);
		RcplTableData data = new RcplTableData(table);
		IParagraph paragraph = new SimpleParagraph("test");
		data.setParagraph(paragraph, 1, 2);
		table.setData(data);
		table.setColumnWidth(2, 100);
		table.setRowHeight(5, 100);
		VBox.setVgrow(table.getNode(), Priority.ALWAYS);
		vbox.getChildren().add(table.getNode());
		table.updateCss(scene);

		// ---------------------------------------

		stage.setScene(scene);

		stage.show();
	}

}