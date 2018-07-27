package org.eclipse.rcpl.navigator.details;

import java.io.IOException;
import java.net.URL;

import org.eclipse.rcpl.IDetailPane;
import org.eclipse.rcpl.Rcpl;
import org.eclipse.rcpl.navigator.IDetailPaneControler;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

/**
 * @author ramin
 *
 */
public class ToolsDetailPage implements IDetailPane {

	private VBox node;

	private IDetailPaneControler controler;

	public ToolsDetailPage() {
		super();

		URL location = getClass().getResource("/org/eclipse/rcpl/navigator/details/tools_editor_detailpage.fxml");
		FXMLLoader fxmlLoader = new FXMLLoader(location);
		fxmlLoader.setController(Rcpl.UIC);

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
	public IDetailPaneControler getControler() {
		if (controler == null) {
			controler = new ToolsDetailPaneController();
		}
		return controler;
	}

}
