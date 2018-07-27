package org.eclipse.rcpl.navigator.details;

import java.io.IOException;
import java.net.URL;

import org.eclipse.rcpl.navigator.IDetailPaneControler;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

/**
 * @author ramin
 *
 */
public class ToolsDetailPage extends AbstractDetailPane {

	private VBox node;

	public ToolsDetailPage() {
		super();

		URL location = getClass().getResource("/org/eclipse/rcpl/navigator/details/tools_editor_detailpage.fxml");
		FXMLLoader fxmlLoader = new FXMLLoader(location);
		fxmlLoader.setController(getControler());

		try {
			node = fxmlLoader.load();

		} catch (IOException e) {
			e.printStackTrace();
			// System.exit(1);
		}
	}

	@Override
	public VBox getNode() {
		return node;
	}

	@Override
	IDetailPaneControler createControler() {
		return new ToolsDetailPaneController();
	}

}
