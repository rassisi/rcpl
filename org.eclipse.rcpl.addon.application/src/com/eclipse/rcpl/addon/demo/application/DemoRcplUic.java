package com.eclipse.rcpl.addon.demo.application;

import java.io.File;
import java.net.URL;

import org.eclipse.rcpl.IEditor;
import org.eclipse.rcpl.application.RcplApplicationStarter;
import org.eclipse.rcpl.ui.controler.RcplUic;
import org.eclipse.rcpl.util.RcplUtil;

import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.Separator;

public class DemoRcplUic extends RcplUic {

	public DemoRcplUic(RcplApplicationStarter rcp) {
		super(rcp);
		// new JOPointToPixelCalculator().init();

	}

	public void actionAddWordTab() {
		openTemplate("blank_A4.docx", "   New Document");
	}

	@Override
	public void actionOpen() {

	}

	@Override
	public void actionOpenLast() {
	}

	@Override
	protected void doCreateContent() {
		super.doCreateContent();
		Separator sep1 = new Separator(Orientation.HORIZONTAL);
		sep1.setPrefWidth(10);
		sep1.setVisible(false);

		Separator sep12 = new Separator(Orientation.HORIZONTAL);
		sep12.setPrefWidth(10);
		sep12.setVisible(false);

		Separator sep13 = new Separator(Orientation.HORIZONTAL);
		sep13.setPrefWidth(10);
		sep13.setVisible(false);

		Separator sep2 = new Separator(Orientation.HORIZONTAL);
		sep2.setPrefWidth(10);
		sep2.setVisible(false);

	}

	@Override
	public IEditor getEditor() {

		IEditor result = super.getEditor();
		if (result != null) {
			return result;
		}

		if (internalBorderPane != null) {
			Node n = internalBorderPane.getCenter();
			if (n != null) {
				Object o = n.getUserData();
//				if (o instanceof DocumentHomePage) {
//					return ((DocumentHomePage) o).getDocument().getEditor();
//				}
			}
		}
		return result;
	}

	@Override
	public void openDocument(File file) {

	}

	public void openDocument(URL url) {
		File file = RcplUtil.copyFileFromUrlToCache(url, false);
		openDocument(file);

	}

	@Override
	public void openTemplate(String name, String tabName) {

	}

	@Override
	protected void registerServices() {
		super.registerServices();
//		JO.service().registerService(EnServiceId.COLOR_SERVICE, new JOColorService());
	}
}
