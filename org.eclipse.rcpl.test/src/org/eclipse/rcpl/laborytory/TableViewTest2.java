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
public class TableViewTest2 extends Application {

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

		RcplTable2 table = new RcplTable2(true, true) {
			@Override
			protected IParagraph createParagraph() {
				return new SimpleParagraph("");
			}
		};

		table.updateCss(scene);

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