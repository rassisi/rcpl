package org.eclipse.rcpl.ui.parts.contacts;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.rcpl.AbstractRcplAddon;
import org.eclipse.rcpl.contacts.addon.RcplContactsAddon;
import org.eclipse.rcpl.detailpages.AbstractDetailPaneController;

import javafx.beans.property.Property;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * @author ramin
 *
 */
public class EContactsAddonController extends AbstractDetailPaneController {

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
	public void unbindAll() {
		// TODO Auto-generated method stub

	}

}
