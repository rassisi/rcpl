package org.eclipse.rcpl.navigator.details;

import java.io.IOException;
import java.net.URL;

import org.eclipse.rcpl.INavigatorDetailPage;
import org.eclipse.rcpl.navigator.INavigatorDetailPageControler;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * @author ramin
 *
 */
public class ToolsDetailPage extends AbstractNavigatorDetailPage implements INavigatorDetailPage {

	private VBox node;

	public ToolsDetailPage() {
		super();

	}

	@Override
	INavigatorDetailPageControler createControler() {
		return new ToolsDetailPaneController();
	}

	@Override
	public void create(StackPane stackPane) {
		URL location = getClass().getResource("/org/eclipse/rcpl/navigator/details/tools_editor_detailpage.fxml");
		FXMLLoader fxmlLoader = new FXMLLoader(location);
		fxmlLoader.setController(getControler());

		try {
			VBox node = fxmlLoader.load();
			stackPane.getChildren().add(node);
		} catch (IOException e) {
			e.printStackTrace();
			// System.exit(1);
		}

	}

}
