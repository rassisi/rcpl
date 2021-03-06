package org.eclipse.rcpl.laborytory;

import org.eclipse.rcpl.images.RcplImage;
import org.eclipse.rcpl.model.client.RcplSession;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FXTest extends Application {

	RcplImage img;
	Node imageView = null;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		final VBox st = new VBox();

		int test = 3;

		switch (test) {
		case 1:
			test_1();
			break;
		case 2:
			test_2();
			break;
		case 3:
			test_3();
			break;
		case 4:
			test_4();
			break;
		case 5:
			test_5();
			break;
		case 6:
			test_4();
			break;
		case 7:
			test_4();
			break;
		}

		if (imageView != null) {
			st.getChildren().add(imageView);
			Scene scene = new Scene(st, 600, 850);
			stage.setScene(scene);
			stage.centerOnScreen();
			stage.show();
		}
	}

	void test_1() {
		RcplSession.getDefault().addAdditionalImageCodebases("https://upload.wikimedia.org/wikipedia/commons/d/d3/");
		img = new RcplImage("Microsoft_Account", 300, 300);
		imageView = img.getNode();
	}

	void test_2() {
		RcplSession.getDefault();
		img = new RcplImage("https://upload.wikimedia.org/wikipedia/commons/d/d3/Microsoft_Account.svg", 200, 200);
		imageView = img.getNode();
	}

	void test_3() {
		RcplSession.getDefault();
		img = new RcplImage("nodes", 300, 300);
		imageView = img.getNode();
	}

	void test_4() {
		RcplSession.getDefault().addAdditionalImageCodebases(
				"https://raw.githubusercontent.com/rassisi/worldreservesystem/master/org.wrs.resources/svg/");
		img = new RcplImage("account", 200, 200);
		imageView = img.getNode();
	}

	void test_5() {
		RcplSession.getDefault().addAdditionalImageCodebases("https://de.m.wikipedia.org/wiki/Datei:");
		img = new RcplImage("Information_icon", 200, 200);
		imageView = img.getNode();
	}

}
