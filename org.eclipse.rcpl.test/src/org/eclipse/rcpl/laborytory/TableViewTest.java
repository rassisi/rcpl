package org.eclipse.rcpl.laborytory;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * @author Ramin
 *
 */
public class TableViewTest extends Application {

	private RcplTable table = new RcplTable(true);

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Table View Sample");
		stage.setWidth(800);
		stage.setHeight(500);
		final Label label = new Label("Address Book");
		label.setFont(new Font("Arial", 20));

		// ----------- table ---------------------

		table = new RcplTable(true);
		table.setEditable(true);
		table.setItems(getData());
		for (int col = 0; col < 3; col++) {
			table.setColumnWidth(col, 200);
		}

		// ---------------------------------------

		final VBox vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		vbox.getChildren().addAll(label, table.getNode());
		Scene scene = new Scene(vbox);
		stage.setScene(scene);
		stage.show();
	}

	private ObservableList<RcplParagraphRow> getData() {
		ObservableList<RcplParagraphRow> data = FXCollections.observableArrayList();
		for (int row = 0; row < 10; row++) {
			RcplParagraphRow rowData = getRowData(table, row);
			data.add(rowData);
		}
		return data;
	}

	private RcplParagraphRow getRowData(RcplTable table, int row) {
		RcplParagraphRow rowData = new RcplParagraphRow(table);
		for (int col = 0; col < 10; col++) {
			SimpleParagraph p = new SimpleParagraph(row + " " + col);
			rowData.add(p);
		}
		return rowData;
	}

}