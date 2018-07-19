package org.eclipse.rcpl.login;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class ShowPdfTest extends Application {
	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		WebView webView = new WebView();
		WebEngine engine = webView.getEngine();
		Scene scene = new Scene(webView);
		primaryStage.setScene(scene);
		primaryStage.show();

//        engine.load("https://www.google.com");
		engine.load("unec.edu.az/application/uploads/2014/12/pdf-sample.pdf");
	}
}