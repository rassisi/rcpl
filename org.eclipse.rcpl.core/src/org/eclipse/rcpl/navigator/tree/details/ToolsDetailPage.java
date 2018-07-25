package org.eclipse.rcpl.navigator.tree.details;

import java.io.IOException;
import java.net.URL;

import org.eclipse.rcpl.Rcpl;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

/**
 * @author ramin
 *
 */
public class ToolsDetailPage {

	private VBox node;

	public ToolsDetailPage() {
		super();

		URL location = getClass().getResource("/org/eclipse/rcpl/navigator/tree/details/tools_editor_detailpage.fxml");
		FXMLLoader fxmlLoader = new FXMLLoader(location);
		fxmlLoader.setController(Rcpl.UIC);

		try {
			node = fxmlLoader.load();

		} catch (IOException e) {
			e.printStackTrace();
			// System.exit(1);
		}

	}

	public VBox getNode() {
		return node;
	}

}
