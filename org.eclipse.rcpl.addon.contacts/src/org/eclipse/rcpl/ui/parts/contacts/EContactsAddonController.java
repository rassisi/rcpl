package org.eclipse.rcpl.ui.parts.contacts;

import java.io.File;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.rcpl.AbstractRcplAddon;
import org.eclipse.rcpl.IApplicationStarter;
import org.eclipse.rcpl.IEditor;
import org.eclipse.rcpl.IHomePage;
import org.eclipse.rcpl.INavigatorAddon;
import org.eclipse.rcpl.IRcplAddon;
import org.eclipse.rcpl.contacts.addon.RcplContactsAddon;
import org.eclipse.rcpl.login.RcplLogin;
import org.eclipse.rcpl.model_2_0_0.rcpl.HomePageType;
import org.eclipse.rcpl.model_2_0_0.rcpl.Perspective;
import org.eclipse.rcpl.model_2_0_0.rcpl.Tool;
import org.eclipse.rcpl.navigator.EViewController;

import javafx.beans.property.Property;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * @author ramin
 *
 */
public class EContactsAddonController extends EViewController {

	@FXML
	private ImageView imageView;

	@FXML
	private TextField title;
	private Property<String> titleProperty;

	@FXML
	private TextField firstName;
	private Property<String> firstNameProperty;

	@FXML
	private TextField lastName;
	private Property<String> lastNameProperty;

	@FXML
	private TextField jobTitle;
	private Property<String> jobTitleProperty;

	@FXML
	private TextField note;
	private Property<String> noteProperty;

	@FXML
	private TextField street;
	private Property<String> streetProperty;

	@FXML
	private TextField city;
	private Property<String> cityProperty;

	@FXML
	private TextField zip;
	private Property<String> zipProperty;

	@FXML
	private TextField state;
	private Property<String> stateProperty;

	@FXML
	private TextField country;
	private Property<String> countryProperty;

	@FXML
	private TextField phone;
	private Property<String> phoneProperty;

	@FXML
	private TextField mobile;
	private Property<String> mobileProperty;

	@FXML
	private TextField email;
	private Property<String> emailProperty;

	@FXML
	private TextField webPage;
	private Property<String> webPageProperty;

	@FXML
	private SplitPane contactsPane;

	@FXML
	private VBox viewerBox;

	@Override
	public void updateBindings(EObject contact, EditingDomain editingDomain) {
//		titleProperty = bind(title, titleProperty, contact,
//				RcplPackage.eINSTANCE.getEContact_Title(), editingDomain);
//		firstNameProperty = bind(firstName, firstNameProperty, contact,
//				RcplPackage.eINSTANCE.getEContact_FirstName(), editingDomain);
//		lastNameProperty = bind(lastName, lastNameProperty, contact,
//				RcplPackage.eINSTANCE.getPerson_LastName(), editingDomain);
//		jobTitleProperty = bind(jobTitle, jobTitleProperty, contact,
//				RcplPackage.eINSTANCE.getEContact_JobTitle(), editingDomain);
//		noteProperty = bind(note, noteProperty, contact,
//				RcplPackage.eINSTANCE.getEContact_Note(), editingDomain);

		// Business Address
//		streetProperty = bind(street, streetProperty, contact,
//				RcplPackage.eINSTANCE.getEContact_Street(), editingDomain);
//		cityProperty = bind(city, cityProperty, contact,
//				RcplPackage.eINSTANCE.getEContact_City(), editingDomain);
//		zipProperty = bind(zip, zipProperty, contact,
//				RcplPackage.eINSTANCE.getEContact_Zip(), editingDomain);
//		stateProperty = bind(state, stateProperty, contact,
//				RcplPackage.eINSTANCE.getEContact_State(), editingDomain);
//		countryProperty = bind(country, countryProperty, contact,
//				RcplPackage.eINSTANCE.getEContact_Country(), editingDomain);

		// Business Phones
//		phoneProperty = bind(phone, phoneProperty, contact,
//				RcplPackage.eINSTANCE.getEContact_PhoneBusiness(), editingDomain);
//		mobileProperty = bind(mobile, mobileProperty, contact,
//				RcplPackage.eINSTANCE.getEContact_Mobile(), editingDomain);

		// Business Internet
//		emailProperty = bind(email, emailProperty, contact,
//				RcplPackage.eINSTANCE.getEContact_Email(), editingDomain);
//		webPageProperty = bind(webPage, webPageProperty, contact,
//				RcplPackage.eINSTANCE.getEContact_WebPage(), editingDomain);

		// image
//		Image image = null;
//		if (contact != null) {
//			String jpegString = ((Person) contact).getJpegString();
//			if (jpegString != null) {
//				byte[] imageBytes = Base64.decode(jpegString.getBytes());
//				ByteArrayInputStream is = new ByteArrayInputStream(imageBytes);
//				image = new Image(is);
//			}
//		}
//		imageView.setImage(image);
	}

	public SplitPane getContactDetailPane() {
		return contactsPane;
	}

	public VBox getViewerBox() {
		return viewerBox;
	}

	@Override
	public void doInit(AbstractRcplAddon uc) {
		Node node1 = new EContactsTreePart((RcplContactsAddon) uc).getNode();
		getViewerBox().getChildren().add(node1);

	}

	@Override
	public void actionAddPresentationTab() {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionLogout() {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionOpen() {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionOpenLast() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addtoApplicationStack(StackPane contentGroup) {
		// TODO Auto-generated method stub

	}

	@Override
	public void collapseAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public void createContent() {
		// TODO Auto-generated method stub

	}

	@Override
	public void expandAllToolBars() {
		// TODO Auto-generated method stub

	}

	@Override
	public void expandBottomAra(boolean expand) {
		// TODO Auto-generated method stub

	}

	@Override
	public void expandLeftAra(boolean expand) {
		// TODO Auto-generated method stub

	}

	@Override
	public void expandTopAra(boolean epand) {
		// TODO Auto-generated method stub

	}

	@Override
	public IRcplAddon findRcplAddons(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WebView getBrowser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IEditor getEditor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node getFocusOwner() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Perspective getPerspective() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stage getStage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void handleThemeDefault(ActionEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(BorderPane parent) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean initSession(RcplLogin login) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void initStyles() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isViewer() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void openDocument(File file) {
		// TODO Auto-generated method stub

	}

	@Override
	public void openTemplate(String name, String tabName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void recreateSideBar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void recreateTopBar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void restorePerspective() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPerspective(Perspective perspective, IRcplAddon useCase) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setContent(IEditor editor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setContent(Node node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDebugText(String text) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setInhibitUI(boolean inhibitUI) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLeftTrimBar(StackPane perspectiveToolSideBarStackPane) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPerspective(Perspective perspective) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setStatusText(String text) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTopAreaHeight(double height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTopContent(Node content) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setViewer(boolean viewer) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean showBrowser() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void showErrorPage() {
		// TODO Auto-generated method stub

	}

	@Override
	public void showStartMenuButton(boolean show) {
		// TODO Auto-generated method stub

	}

	@Override
	public void showWebView(String url) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateStartMenuButton() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(IRcplAddon rcplAddon) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createHomePages() {
		// TODO Auto-generated method stub

	}

	@Override
	public IHomePage findHomePage(HomePageType id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public INavigatorAddon getNavigator(Tool tool) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IRcplAddon getActiveAddon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setActiveAddon(IRcplAddon useCase) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean showPerspective(Perspective perspective) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IApplicationStarter getApplicationStarter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void showHomePage(HomePageType id) {
		// TODO Auto-generated method stub

	}

}
