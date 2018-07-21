package com.eclipse.rcpl.addon.demo.application;

import java.io.File;
import java.net.URL;

import org.eclipse.rcpl.IDocument;
import org.eclipse.rcpl.IEditor;
import org.eclipse.rcpl.IHomePage;
import org.eclipse.rcpl.application.RcplApplicationStarter;
import org.eclipse.rcpl.ui.controler.RcplUic;
import org.eclipse.rcpl.util.RcplUtil;

import com.rcpl.rcpl.addon.demo.homepages.DocumentHomePage;
import com.rcpl.rcpl.addon.demo.homepages.NewHomePage;
import com.rcpl.rcpl.addon.demo.homepages.SamplesHomePage;

import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.Separator;
import javafx.scene.control.Tab;

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
	protected IHomePage createAboutHomePage() {
		return super.createAboutHomePage();
	}

	@Override
	protected IHomePage createNewHomePage() {
		return new NewHomePage(this, "64_48/office_new");
	}

	@Override
	protected IHomePage createSamplesHomePage() {
		return new SamplesHomePage(this, "64_48/office_samples");
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
				if (o instanceof DocumentHomePage) {
					return ((DocumentHomePage) o).getDocument().getEditor();
				}
			}
		}
		return result;
	}

	@Override
	public void openDocument(File file) {

		if (file.getName().endsWith(".docx")) {
			actionPerspectiveWord();
		} else if (file.getName().endsWith(".pptx")) {
			actionPerspectivePresentation();
		} else if (file.getName().endsWith(".xlsx")) {
			actionPerspectiveSpreadsheet();
		}

		final Tab newTab = createNewTab(file.getName());
		// final IEditor f = factory().createEditor(newTab, false);
		// IDocument doc = JOAbstractDocument.load(file, false, null, false);
		//
		// f.setDocument(doc);
		// centerEditor(f);
		newTab.setId("wordTab");
		newTab.setClosable(true);
		// newTab.setUserData(f);
		internalTabPane.getSelectionModel().select(newTab);
		// internalBorderPane.setCenter(f.getMainPane());
		updatePerspective(newTab);
		updateButtons(false);
//		getSideToolBarControl().show(true);
		internalTabPane.getSelectionModel().select(newTab);

//		status_button_2_pages.setSelected(getEditor().getPageColumns() >= 2);
	}

	public void openDocument(URL url) {
		File file = RcplUtil.copyFileFromUrlToCache(url, false);
		openDocument(file);

	}

	@Override
	public void openTemplate(String name, String tabName) {

		if (name.endsWith(".docx")) {
			actionPerspectiveWord();
		} else if (name.endsWith(".pptx")) {
			actionPerspectivePresentation();
		} else if (name.endsWith(".xlsx")) {
			actionPerspectiveSpreadsheet();
		}

		IDocument document = null;
		String title = tabName != null ? tabName : name;

		final Tab newTab = createNewTab(title);
		newTab.setId("wordTab");
//		IEditor f = factory().createEditor(newTab, false);
//		document = new JODocumentProvider().createTemplateDocument(name, (HashMap<String, String>) null, false);
//		f.setDocument(document);
//		internalBorderPane.setCenter(f.getMainPane());
//		newTab.setUserData(f);
		updatePerspective(newTab);
		updateButtons(false);
//		getSideToolBarControl().show();
		internalTabPane.getSelectionModel().select(newTab);

		if (getEditor() != null) {
//			status_button_2_pages.setSelected(getEditor().getPageColumns() >= 2);
		}
//		addGeneralQuickTools_1();

//		return newTab;
	}

	@Override
	protected void registerServices() {
		super.registerServices();
//		JO.service().registerService(EnServiceId.COLOR_SERVICE, new JOColorService());
	}
}
