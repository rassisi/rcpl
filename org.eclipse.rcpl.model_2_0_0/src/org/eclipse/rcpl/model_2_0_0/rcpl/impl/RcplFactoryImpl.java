/**
 */
package org.eclipse.rcpl.model_2_0_0.rcpl.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.rcpl.model_2_0_0.rcpl.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RcplFactoryImpl extends EFactoryImpl implements RcplFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RcplFactory init() {
		try {
			RcplFactory theRcplFactory = (RcplFactory)EPackage.Registry.INSTANCE.getEFactory(RcplPackage.eNS_URI);
			if (theRcplFactory != null) {
				return theRcplFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new RcplFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RcplFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case RcplPackage.RCPL: return (EObject)createRCPL();
			case RcplPackage.PERSPECTIVES: return (EObject)createPerspectives();
			case RcplPackage.PERSPECTIVE: return (EObject)createPerspective();
			case RcplPackage.PREFERENCE: return (EObject)createPreference();
			case RcplPackage.LOGINS: return (EObject)createLogins();
			case RcplPackage.LOGIN: return (EObject)createLogin();
			case RcplPackage.FAVORITES: return (EObject)createFavorites();
			case RcplPackage.FAVORITE: return (EObject)createFavorite();
			case RcplPackage.FAVORITES_GROUP: return (EObject)createFavoritesGroup();
			case RcplPackage.PREFERENCES: return (EObject)createPreferences();
			case RcplPackage.ADDONS: return (EObject)createAddons();
			case RcplPackage.ADDON: return (EObject)createAddon();
			case RcplPackage.TOOL: return (EObject)createTool();
			case RcplPackage.TOOL_GROUP: return (EObject)createToolGroup();
			case RcplPackage.TOOLS: return (EObject)createTools();
			case RcplPackage.RIBBON_TOOL_BAR: return (EObject)createRibbonToolBar();
			case RcplPackage.TOP_TOOL_BAR: return (EObject)createTopToolBar();
			case RcplPackage.SIDE_TOOL_BAR: return (EObject)createSideToolBar();
			case RcplPackage.QUICK_TOOL_BAR: return (EObject)createQuickToolBar();
			case RcplPackage.FOLDER: return (EObject)createFolder();
			case RcplPackage.RESOURCE: return (EObject)createResource();
			case RcplPackage.PERSON: return (EObject)createPerson();
			case RcplPackage.PERSON_GROUP: return (EObject)createPersonGroup();
			case RcplPackage.RESOURCES: return (EObject)createResources();
			case RcplPackage.PREFERENCE_GROUP: return (EObject)createPreferenceGroup();
			case RcplPackage.PERSONS: return (EObject)createPersons();
			case RcplPackage.RCPL_TEMPLATES: return (EObject)createRCPLTemplates();
			case RcplPackage.JPERSON: return (EObject)createJPerson();
			case RcplPackage.NPERSON: return (EObject)createNPerson();
			case RcplPackage.ADDRESS: return (EObject)createAddress();
			case RcplPackage.COUNTRY: return (EObject)createCountry();
			case RcplPackage.CITY: return (EObject)createCity();
			case RcplPackage.GEO: return (EObject)createGeo();
			case RcplPackage.WORLD_REGION: return (EObject)createWorldRegion();
			case RcplPackage.STREET: return (EObject)createStreet();
			case RcplPackage.HOUSE_NUMBER: return (EObject)createHouseNumber();
			case RcplPackage.BUILDING: return (EObject)createBuilding();
			case RcplPackage.CONTACT: return (EObject)createContact();
			case RcplPackage.PHONE: return (EObject)createPhone();
			case RcplPackage.DOMAINS: return (EObject)createDomains();
			case RcplPackage.DOMAIN: return (EObject)createDomain();
			case RcplPackage.HOME_PAGES: return (EObject)createHomePages();
			case RcplPackage.HOME_PAGE: return (EObject)createHomePage();
			case RcplPackage.DOCUMENTS: return (EObject)createDocuments();
			case RcplPackage.DOCUMENT: return (EObject)createDocument();
			case RcplPackage.KEY_VALUE: return (EObject)createKeyValue();
			case RcplPackage.KEY_VALUES: return (EObject)createKeyValues();
			case RcplPackage.COMMAND: return (EObject)createCommand();
			case RcplPackage.COMMANDS: return (EObject)createCommands();
			case RcplPackage.SERVICES: return (EObject)createServices();
			case RcplPackage.SERVICE: return (EObject)createService();
			case RcplPackage.NAVIGATOR: return (EObject)createNavigator();
			case RcplPackage.NAVIGATOR_ITEM: return (EObject)createNavigatorItem();
			case RcplPackage.NAVIGATORS: return (EObject)createNavigators();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case RcplPackage.TOOL_TYPE:
				return createToolTypeFromString(eDataType, initialValue);
			case RcplPackage.FONT_STYLES:
				return createFontStylesFromString(eDataType, initialValue);
			case RcplPackage.TOOL_BAR_REPLACEMENT_POLICY:
				return createToolBarReplacementPolicyFromString(eDataType, initialValue);
			case RcplPackage.GROUP_TYPE:
				return createGroupTypeFromString(eDataType, initialValue);
			case RcplPackage.ADDRESS_TYPE:
				return createAddressTypeFromString(eDataType, initialValue);
			case RcplPackage.HOME_PAGE_TYPE:
				return createHomePageTypeFromString(eDataType, initialValue);
			case RcplPackage.DOCUMENT_TYPE:
				return createDocumentTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case RcplPackage.TOOL_TYPE:
				return convertToolTypeToString(eDataType, instanceValue);
			case RcplPackage.FONT_STYLES:
				return convertFontStylesToString(eDataType, instanceValue);
			case RcplPackage.TOOL_BAR_REPLACEMENT_POLICY:
				return convertToolBarReplacementPolicyToString(eDataType, instanceValue);
			case RcplPackage.GROUP_TYPE:
				return convertGroupTypeToString(eDataType, instanceValue);
			case RcplPackage.ADDRESS_TYPE:
				return convertAddressTypeToString(eDataType, instanceValue);
			case RcplPackage.HOME_PAGE_TYPE:
				return convertHomePageTypeToString(eDataType, instanceValue);
			case RcplPackage.DOCUMENT_TYPE:
				return convertDocumentTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RCPL createRCPL() {
		RCPLImpl rcpl = new RCPLImpl();
		return rcpl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Perspectives createPerspectives() {
		PerspectivesImpl perspectives = new PerspectivesImpl();
		return perspectives;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Perspective createPerspective() {
		PerspectiveImpl perspective = new PerspectiveImpl();
		return perspective;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Preference createPreference() {
		PreferenceImpl preference = new PreferenceImpl();
		return preference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Logins createLogins() {
		LoginsImpl logins = new LoginsImpl();
		return logins;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Login createLogin() {
		LoginImpl login = new LoginImpl();
		return login;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Favorites createFavorites() {
		FavoritesImpl favorites = new FavoritesImpl();
		return favorites;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Favorite createFavorite() {
		FavoriteImpl favorite = new FavoriteImpl();
		return favorite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FavoritesGroup createFavoritesGroup() {
		FavoritesGroupImpl favoritesGroup = new FavoritesGroupImpl();
		return favoritesGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Preferences createPreferences() {
		PreferencesImpl preferences = new PreferencesImpl();
		return preferences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Addons createAddons() {
		AddonsImpl addons = new AddonsImpl();
		return addons;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Addon createAddon() {
		AddonImpl addon = new AddonImpl();
		return addon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Tool createTool() {
		ToolImpl tool = new ToolImpl();
		return tool;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ToolGroup createToolGroup() {
		ToolGroupImpl toolGroup = new ToolGroupImpl();
		return toolGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Tools createTools() {
		ToolsImpl tools = new ToolsImpl();
		return tools;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RibbonToolBar createRibbonToolBar() {
		RibbonToolBarImpl ribbonToolBar = new RibbonToolBarImpl();
		return ribbonToolBar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TopToolBar createTopToolBar() {
		TopToolBarImpl topToolBar = new TopToolBarImpl();
		return topToolBar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SideToolBar createSideToolBar() {
		SideToolBarImpl sideToolBar = new SideToolBarImpl();
		return sideToolBar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public QuickToolBar createQuickToolBar() {
		QuickToolBarImpl quickToolBar = new QuickToolBarImpl();
		return quickToolBar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Folder createFolder() {
		FolderImpl folder = new FolderImpl();
		return folder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Resource createResource() {
		ResourceImpl resource = new ResourceImpl();
		return resource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Person createPerson() {
		PersonImpl person = new PersonImpl();
		return person;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PersonGroup createPersonGroup() {
		PersonGroupImpl personGroup = new PersonGroupImpl();
		return personGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Resources createResources() {
		ResourcesImpl resources = new ResourcesImpl();
		return resources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PreferenceGroup createPreferenceGroup() {
		PreferenceGroupImpl preferenceGroup = new PreferenceGroupImpl();
		return preferenceGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Persons createPersons() {
		PersonsImpl persons = new PersonsImpl();
		return persons;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RCPLTemplates createRCPLTemplates() {
		RCPLTemplatesImpl rcplTemplates = new RCPLTemplatesImpl();
		return rcplTemplates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JPerson createJPerson() {
		JPersonImpl jPerson = new JPersonImpl();
		return jPerson;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NPerson createNPerson() {
		NPersonImpl nPerson = new NPersonImpl();
		return nPerson;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Address createAddress() {
		AddressImpl address = new AddressImpl();
		return address;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Country createCountry() {
		CountryImpl country = new CountryImpl();
		return country;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public City createCity() {
		CityImpl city = new CityImpl();
		return city;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Geo createGeo() {
		GeoImpl geo = new GeoImpl();
		return geo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public WorldRegion createWorldRegion() {
		WorldRegionImpl worldRegion = new WorldRegionImpl();
		return worldRegion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Street createStreet() {
		StreetImpl street = new StreetImpl();
		return street;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public HouseNumber createHouseNumber() {
		HouseNumberImpl houseNumber = new HouseNumberImpl();
		return houseNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Building createBuilding() {
		BuildingImpl building = new BuildingImpl();
		return building;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Contact createContact() {
		ContactImpl contact = new ContactImpl();
		return contact;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Phone createPhone() {
		PhoneImpl phone = new PhoneImpl();
		return phone;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Domains createDomains() {
		DomainsImpl domains = new DomainsImpl();
		return domains;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Domain createDomain() {
		DomainImpl domain = new DomainImpl();
		return domain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public HomePages createHomePages() {
		HomePagesImpl homePages = new HomePagesImpl();
		return homePages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public HomePage createHomePage() {
		HomePageImpl homePage = new HomePageImpl();
		return homePage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Documents createDocuments() {
		DocumentsImpl documents = new DocumentsImpl();
		return documents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Document createDocument() {
		DocumentImpl document = new DocumentImpl();
		return document;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public KeyValue createKeyValue() {
		KeyValueImpl keyValue = new KeyValueImpl();
		return keyValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public KeyValues createKeyValues() {
		KeyValuesImpl keyValues = new KeyValuesImpl();
		return keyValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Command createCommand() {
		CommandImpl command = new CommandImpl();
		return command;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Commands createCommands() {
		CommandsImpl commands = new CommandsImpl();
		return commands;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Services createServices() {
		ServicesImpl services = new ServicesImpl();
		return services;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Service createService() {
		ServiceImpl service = new ServiceImpl();
		return service;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Navigator createNavigator() {
		NavigatorImpl navigator = new NavigatorImpl();
		return navigator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NavigatorItem createNavigatorItem() {
		NavigatorItemImpl navigatorItem = new NavigatorItemImpl();
		return navigatorItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Navigators createNavigators() {
		NavigatorsImpl navigators = new NavigatorsImpl();
		return navigators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ToolType createToolTypeFromString(EDataType eDataType, String initialValue) {
		ToolType result = ToolType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertToolTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FontStyles createFontStylesFromString(EDataType eDataType, String initialValue) {
		FontStyles result = FontStyles.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFontStylesToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ToolBarReplacementPolicy createToolBarReplacementPolicyFromString(EDataType eDataType, String initialValue) {
		ToolBarReplacementPolicy result = ToolBarReplacementPolicy.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertToolBarReplacementPolicyToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GroupType createGroupTypeFromString(EDataType eDataType, String initialValue) {
		GroupType result = GroupType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertGroupTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddressType createAddressTypeFromString(EDataType eDataType, String initialValue) {
		AddressType result = AddressType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAddressTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HomePageType createHomePageTypeFromString(EDataType eDataType, String initialValue) {
		HomePageType result = HomePageType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertHomePageTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocumentType createDocumentTypeFromString(EDataType eDataType, String initialValue) {
		DocumentType result = DocumentType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDocumentTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RcplPackage getRcplPackage() {
		return (RcplPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static RcplPackage getPackage() {
		return RcplPackage.eINSTANCE;
	}

} //RcplFactoryImpl
