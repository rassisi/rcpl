package org.eclipse.rcpl.internal.tools;

import java.io.InputStream;

import org.eclipse.rcpl.images.RcplImage;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class SplitMenuButtonDemo extends Application {

	private int count = 1;

	// resourcePath: "/org/o7planning/javafx/icon/flag-vi.png"
	private ImageView getIcon(String resourcePath) {
		InputStream input //
				= this.getClass().getResourceAsStream(resourcePath);
		Image image = new Image(input);
		return new ImageView(image);
	}

	private SplitMenuButton splitMenuButton;

	@Override
	public void start(Stage primaryStage) throws Exception {

		Label label = new Label();

		ImageView imageViewVI = new RcplImage("v_lineal", 16, 16).getNode();
		ImageView imageViewEN = new RcplImage("h_lineal", 16, 16).getNode();
		ImageView imageViewIN = new RcplImage("word", 16, 16).getNode();

		// Create MenuItems
		MenuItem menuItemVI = new MenuItem("Vietnamese", imageViewVI);

		menuItemVI.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				splitMenuButton.setGraphic(imageViewVI);
			}
		});

		MenuItem menuItemEN = new MenuItem("English", imageViewEN);
		MenuItem menuItemIN = new MenuItem("India", imageViewIN);

		ImageView imageViewLang = new RcplImage("spreadsheet", 16, 16).getNode();

		// Create a MenuButton with 3 Items
		splitMenuButton = new SplitMenuButton(menuItemVI, menuItemEN, menuItemIN);

		splitMenuButton.setText("Language");
		splitMenuButton.setGraphic(imageViewLang);

		// Handling when the user clicks on the left side of SplitMenuButton.
		splitMenuButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				label.setText("Clicked " + count++);
			}
		});

//		splitMenuButton.getContextMenu().setOnAction(new EventHandler<ActionEvent>() {
//
//			@Override
//			public void handle(ActionEvent event) {
//
//				System.out.println();
//
//			}
//		});

		FlowPane root = new FlowPane();
		root.setPadding(new Insets(10));
		root.setVgap(5);
		root.setHgap(5);

		root.getChildren().addAll(splitMenuButton, label);

		Scene scene = new Scene(root, 320, 150);

		primaryStage.setTitle("JavaFX SplitMenuButton (o7planning.org)");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}