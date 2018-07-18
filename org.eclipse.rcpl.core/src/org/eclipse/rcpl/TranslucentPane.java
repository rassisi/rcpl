package org.eclipse.rcpl;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TranslucentPane extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(final Stage stage) throws Exception {
		final ImageView imageView = new ImageView(
				new Image("https://upload.wikimedia.org/wikipedia/commons/b/b7/Idylls_of_the_King_3.jpg"));
		imageView.setFitHeight(300);
		imageView.setFitWidth(228);

		final Label label = new Label("The Once\nand\nFuture King");
		label.setStyle(
				"-fx-text-fill: goldenrod; -fx-font: italic 20 \"serif\"; -fx-padding: 0 0 20 0; -fx-text-alignment: center");

		StackPane glass = new StackPane();
		StackPane.setAlignment(label, Pos.BOTTOM_CENTER);
//		glass.getChildren().addAll(label);
		glass.setStyle("-fx-background-color: rgba(0, 100, 100, 0.5); -fx-background-radius: 10;");
		glass.setMaxWidth(imageView.getFitWidth() - 40);
		glass.setMaxHeight(imageView.getFitHeight() - 40);

		final StackPane layout = new StackPane();
		layout.getChildren().addAll(imageView, glass);
//		layout.getChildren().addAll(glass);
		layout.setStyle("-fx-background-color: silver; -fx-padding: 10;");
		stage.setScene(new Scene(layout));

		stage.getScene().setFill(Color.TRANSPARENT);
		try {
			stage.initStyle(StageStyle.TRANSPARENT);
		} catch (Throwable ex) {
			// ignore
		}

		stage.show();
	}
}
