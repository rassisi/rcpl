/**
 */
package org.eclipse.rcpl.model_2_0_0.rcpl.impl;

import static org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage.RESOURCE;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool;
import org.eclipse.rcpl.model_2_0_0.rcpl.Addon;
import org.eclipse.rcpl.model_2_0_0.rcpl.Addons;
import org.eclipse.rcpl.model_2_0_0.rcpl.Address;
import org.eclipse.rcpl.model_2_0_0.rcpl.AddressType;
import org.eclipse.rcpl.model_2_0_0.rcpl.Building;
import org.eclipse.rcpl.model_2_0_0.rcpl.City;
import org.eclipse.rcpl.model_2_0_0.rcpl.Command;
import org.eclipse.rcpl.model_2_0_0.rcpl.Commands;
import org.eclipse.rcpl.model_2_0_0.rcpl.Contact;
import org.eclipse.rcpl.model_2_0_0.rcpl.Country;
import org.eclipse.rcpl.model_2_0_0.rcpl.Document;
import org.eclipse.rcpl.model_2_0_0.rcpl.DocumentType;
import org.eclipse.rcpl.model_2_0_0.rcpl.Documents;
import org.eclipse.rcpl.model_2_0_0.rcpl.Domain;
import org.eclipse.rcpl.model_2_0_0.rcpl.Domains;
import org.eclipse.rcpl.model_2_0_0.rcpl.Favorite;
import org.eclipse.rcpl.model_2_0_0.rcpl.Favorites;
import org.eclipse.rcpl.model_2_0_0.rcpl.FavoritesGroup;
import org.eclipse.rcpl.model_2_0_0.rcpl.Folder;
import org.eclipse.rcpl.model_2_0_0.rcpl.FontStyles;
import org.eclipse.rcpl.model_2_0_0.rcpl.Geo;
import org.eclipse.rcpl.model_2_0_0.rcpl.GroupType;
import org.eclipse.rcpl.model_2_0_0.rcpl.HomePage;
import org.eclipse.rcpl.model_2_0_0.rcpl.HomePageType;
import org.eclipse.rcpl.model_2_0_0.rcpl.HomePages;
import org.eclipse.rcpl.model_2_0_0.rcpl.HouseNumber;
import org.eclipse.rcpl.model_2_0_0.rcpl.JPerson;
import org.eclipse.rcpl.model_2_0_0.rcpl.KeyValue;
import org.eclipse.rcpl.model_2_0_0.rcpl.KeyValues;
import org.eclipse.rcpl.model_2_0_0.rcpl.Layoutable;
import org.eclipse.rcpl.model_2_0_0.rcpl.Login;
import org.eclipse.rcpl.model_2_0_0.rcpl.Logins;
import org.eclipse.rcpl.model_2_0_0.rcpl.NPerson;
import org.eclipse.rcpl.model_2_0_0.rcpl.Person;
import org.eclipse.rcpl.model_2_0_0.rcpl.PersonGroup;
import org.eclipse.rcpl.model_2_0_0.rcpl.Persons;
import org.eclipse.rcpl.model_2_0_0.rcpl.Perspective;
import org.eclipse.rcpl.model_2_0_0.rcpl.Perspectives;
import org.eclipse.rcpl.model_2_0_0.rcpl.Phone;
import org.eclipse.rcpl.model_2_0_0.rcpl.Preference;
import org.eclipse.rcpl.model_2_0_0.rcpl.PreferenceGroup;
import org.eclipse.rcpl.model_2_0_0.rcpl.Preferences;
import org.eclipse.rcpl.model_2_0_0.rcpl.QuickToolBar;
import org.eclipse.rcpl.model_2_0_0.rcpl.RCPLTemplates;
import org.eclipse.rcpl.model_2_0_0.rcpl.RcplFactory;
import org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage;
import org.eclipse.rcpl.model_2_0_0.rcpl.Resource;
import org.eclipse.rcpl.model_2_0_0.rcpl.Resources;
import org.eclipse.rcpl.model_2_0_0.rcpl.RibbonToolBar;
import org.eclipse.rcpl.model_2_0_0.rcpl.Service;
import org.eclipse.rcpl.model_2_0_0.rcpl.Services;
import org.eclipse.rcpl.model_2_0_0.rcpl.SideToolBar;
import org.eclipse.rcpl.model_2_0_0.rcpl.Street;
import org.eclipse.rcpl.model_2_0_0.rcpl.Tool;
import org.eclipse.rcpl.model_2_0_0.rcpl.ToolBarReplacementPolicy;
import org.eclipse.rcpl.model_2_0_0.rcpl.ToolGroup;
import org.eclipse.rcpl.model_2_0_0.rcpl.ToolType;
import org.eclipse.rcpl.model_2_0_0.rcpl.Tools;
import org.eclipse.rcpl.model_2_0_0.rcpl.TopToolBar;
import org.eclipse.rcpl.model_2_0_0.rcpl.WorldRegion;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!--
 * end-user-doc -->
 * @generated
 */
public class RcplPackageImpl extends EPackageImpl implements RcplPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass layoutableEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rcplEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass perspectivesEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass perspectiveEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass preferenceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loginsEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loginEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass favoritesEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass favoriteEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass favoritesGroupEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass preferencesEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addonsEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addonEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractToolEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass toolEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass toolGroupEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass toolsEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ribbonToolBarEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass topToolBarEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sideToolBarEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass quickToolBarEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass folderEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass personEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass personGroupEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourcesEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass preferenceGroupEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass personsEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rcplTemplatesEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jPersonEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nPersonEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addressEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass countryEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cityEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass geoEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass worldRegionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass streetEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass houseNumberEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass buildingEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contactEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass phoneEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass domainsEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass domainEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass homePagesEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass homePageEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentsEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass keyValueEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass keyValuesEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass commandEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass commandsEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass servicesEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum toolTypeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum fontStylesEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum toolBarReplacementPolicyEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum groupTypeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum addressTypeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum homePageTypeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum documentTypeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RcplPackageImpl() {
		super(eNS_URI, RcplFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link RcplPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RcplPackage init() {
		if (isInited) return (RcplPackage)EPackage.Registry.INSTANCE.getEPackage(RcplPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredRcplPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		RcplPackageImpl theRcplPackage = registeredRcplPackage instanceof RcplPackageImpl ? (RcplPackageImpl)registeredRcplPackage : new RcplPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theRcplPackage.createPackageContents();

		// Initialize created meta-data
		theRcplPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRcplPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RcplPackage.eNS_URI, theRcplPackage);
		return theRcplPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLayoutable() {
		return layoutableEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayoutable_LayoutX() {
		return (EAttribute)layoutableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayoutable_LayoutY() {
		return (EAttribute)layoutableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayoutable_LayoutWidth() {
		return (EAttribute)layoutableEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayoutable_LayoutHeight() {
		return (EAttribute)layoutableEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayoutable_Name() {
		return (EAttribute)layoutableEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayoutable_Description() {
		return (EAttribute)layoutableEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayoutable_Id() {
		return (EAttribute)layoutableEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayoutable_Image() {
		return (EAttribute)layoutableEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayoutable_ToolTip() {
		return (EAttribute)layoutableEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayoutable_CreateDate() {
		return (EAttribute)layoutableEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayoutable_BeginDate() {
		return (EAttribute)layoutableEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayoutable_EndDate() {
		return (EAttribute)layoutableEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayoutable_Leaf() {
		return (EAttribute)layoutableEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRCPL() {
		return rcplEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRCPL_AllAddons() {
		return (EReference)rcplEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRCPL_AllPerspectives() {
		return (EReference)rcplEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRCPL_Preferences() {
		return (EReference)rcplEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRCPL_AllTools() {
		return (EReference)rcplEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRCPL_AllFavorites() {
		return (EReference)rcplEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRCPL_VersionMajor() {
		return (EAttribute)rcplEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRCPL_VersionMinor() {
		return (EAttribute)rcplEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRCPL_VersionMaintenance() {
		return (EAttribute)rcplEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRCPL_BuildNumber() {
		return (EAttribute)rcplEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRCPL_VersionDescription() {
		return (EAttribute)rcplEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRCPL_AllResources() {
		return (EReference)rcplEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRCPL_AllPersons() {
		return (EReference)rcplEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRCPL_LinkedRcpls() {
		return (EReference)rcplEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRCPL_Homepages() {
		return (EReference)rcplEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRCPL_Documents() {
		return (EReference)rcplEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRCPL_Keyvalues() {
		return (EReference)rcplEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRCPL_ImageUrls() {
		return (EAttribute)rcplEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRCPL_ServiceClasses() {
		return (EAttribute)rcplEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRCPL_HomeURL() {
		return (EAttribute)rcplEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRCPL_Commands() {
		return (EReference)rcplEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRCPL_Services() {
		return (EReference)rcplEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPerspectives() {
		return perspectivesEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPerspectives_Children() {
		return (EReference)perspectivesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPerspective() {
		return perspectiveEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPerspective_SideToolBar() {
		return (EReference)perspectiveEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPerspective_TopToolBar() {
		return (EReference)perspectiveEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPerspective_QuickToolBar() {
		return (EReference)perspectiveEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPerspective_RibbonToolBar() {
		return (EReference)perspectiveEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerspective_Overview() {
		return (EAttribute)perspectiveEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPreference() {
		return preferenceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreference_Key() {
		return (EAttribute)preferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreference_Value() {
		return (EAttribute)preferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreference_Type() {
		return (EAttribute)preferenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLogins() {
		return loginsEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLogins_Children() {
		return (EReference)loginsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLogin() {
		return loginEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLogin_Country() {
		return (EAttribute)loginEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLogin_Password() {
		return (EAttribute)loginEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLogin_Rcpl() {
		return (EReference)loginEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLogin_UserId() {
		return (EAttribute)loginEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLogin_Person() {
		return (EReference)loginEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLogin_Domains() {
		return (EReference)loginEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFavorites() {
		return favoritesEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFavorites_Children() {
		return (EReference)favoritesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFavorites_DefaultSetId() {
		return (EAttribute)favoritesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFavorite() {
		return favoriteEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFavorite_Link() {
		return (EAttribute)favoriteEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFavorite_URI() {
		return (EAttribute)favoriteEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFavorite_URL() {
		return (EAttribute)favoriteEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFavorite_CreationDate() {
		return (EAttribute)favoriteEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFavorite_DocumentCreationDate() {
		return (EAttribute)favoriteEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFavorite_Rating() {
		return (EAttribute)favoriteEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFavorite_LastUsedDate() {
		return (EAttribute)favoriteEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFavorite_Frequency() {
		return (EAttribute)favoriteEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFavorite_Password() {
		return (EAttribute)favoriteEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFavorite_Format() {
		return (EAttribute)favoriteEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFavorite_ShowOnToolBar() {
		return (EAttribute)favoriteEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFavoritesGroup() {
		return favoritesGroupEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFavoritesGroup_Groups() {
		return (EReference)favoritesGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFavoritesGroup_Favorites() {
		return (EReference)favoritesGroupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFavoritesGroup_LinkedFavorites() {
		return (EReference)favoritesGroupEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPreferences() {
		return preferencesEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPreferences_Children() {
		return (EReference)preferencesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_System() {
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddons() {
		return addonsEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAddons_Children() {
		return (EReference)addonsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddon() {
		return addonEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddon_BundleId() {
		return (EAttribute)addonEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddon_ClassName() {
		return (EAttribute)addonEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddon_Roles() {
		return (EAttribute)addonEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddon_Users() {
		return (EAttribute)addonEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddon_Groups() {
		return (EAttribute)addonEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddon_IsPerspective() {
		return (EAttribute)addonEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddon_ReadOnly() {
		return (EAttribute)addonEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAddon_DefaultPerspective() {
		return (EReference)addonEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAddon_Perspectives() {
		return (EReference)addonEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddon_RootClassName() {
		return (EAttribute)addonEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractTool() {
		return abstractToolEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractTool_X() {
		return (EAttribute)abstractToolEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractTool_Y() {
		return (EAttribute)abstractToolEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractTool_Width() {
		return (EAttribute)abstractToolEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractTool_Height() {
		return (EAttribute)abstractToolEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractTool_GridX() {
		return (EAttribute)abstractToolEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractTool_GridY() {
		return (EAttribute)abstractToolEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractTool_SpanX() {
		return (EAttribute)abstractToolEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractTool_SpanY() {
		return (EAttribute)abstractToolEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractTool_Labeled() {
		return (EAttribute)abstractToolEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractTool_NotImplemented() {
		return (EAttribute)abstractToolEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractTool_Service() {
		return (EAttribute)abstractToolEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractTool_DetailPaneClassName() {
		return (EAttribute)abstractToolEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractTool_Type() {
		return (EAttribute)abstractToolEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractTool_System() {
		return (EAttribute)abstractToolEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractTool_Url() {
		return (EAttribute)abstractToolEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractTool_ToggleGroup() {
		return (EAttribute)abstractToolEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractTool_ExpandToolGroup() {
		return (EReference)abstractToolEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractTool_HGrow() {
		return (EAttribute)abstractToolEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractTool_VGrow() {
		return (EAttribute)abstractToolEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractTool_WidthPercent() {
		return (EAttribute)abstractToolEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTool() {
		return toolEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTool_Format() {
		return (EAttribute)toolEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getToolGroup() {
		return toolGroupEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getToolGroup_ToolGroups() {
		return (EReference)toolGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getToolGroup_Grid() {
		return (EAttribute)toolGroupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getToolGroup_Format() {
		return (EAttribute)toolGroupEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getToolGroup_Tools() {
		return (EReference)toolGroupEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getToolGroup_GroupType() {
		return (EAttribute)toolGroupEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTools() {
		return toolsEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTools_ToolgroupChildren() {
		return (EReference)toolsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTools_ToolChildren() {
		return (EReference)toolsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRibbonToolBar() {
		return ribbonToolBarEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRibbonToolBar_ToolGroups() {
		return (EReference)ribbonToolBarEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRibbonToolBar_Tools() {
		return (EReference)ribbonToolBarEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTopToolBar() {
		return topToolBarEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTopToolBar_ToolGroups() {
		return (EReference)topToolBarEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTopToolBar_Tools() {
		return (EReference)topToolBarEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSideToolBar() {
		return sideToolBarEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSideToolBar_ToolGroups() {
		return (EReference)sideToolBarEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSideToolBar_Tools() {
		return (EReference)sideToolBarEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQuickToolBar() {
		return quickToolBarEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQuickToolBar_ToolGroups() {
		return (EReference)quickToolBarEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQuickToolBar_Tools() {
		return (EReference)quickToolBarEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFolder() {
		return folderEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFolder_Folders() {
		return (EReference)folderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFolder_Resources() {
		return (EReference)folderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFolder_LinkedResources() {
		return (EReference)folderEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResource() {
		return resourceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResource_Uri() {
		return (EAttribute)resourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResource_Template() {
		return (EAttribute)resourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResource_LinkedResources() {
		return (EReference)resourceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResource_MainPerspective() {
		return (EReference)resourceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPerson() {
		return personEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_LastName() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_MiddleName() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_FirstName() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPerson_Addresses() {
		return (EReference)personEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPersonGroup() {
		return personGroupEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPersonGroup_Persongroups() {
		return (EReference)personGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPersonGroup_Persons() {
		return (EReference)personGroupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPersonGroup_LinkedPersons() {
		return (EReference)personGroupEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPersonGroup_LinkedPersongroups() {
		return (EReference)personGroupEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResources() {
		return resourcesEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResources_Children() {
		return (EReference)resourcesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPreferenceGroup() {
		return preferenceGroupEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPreferenceGroup_Preferences() {
		return (EReference)preferenceGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPreferenceGroup_LinkedPreferences() {
		return (EReference)preferenceGroupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPreferenceGroup_Preferencegroups() {
		return (EReference)preferenceGroupEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPersons() {
		return personsEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPersons_Children() {
		return (EReference)personsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRCPLTemplates() {
		return rcplTemplatesEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRCPLTemplates_Children() {
		return (EReference)rcplTemplatesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJPerson() {
		return jPersonEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNPerson() {
		return nPersonEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddress() {
		return addressEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAddress_Country() {
		return (EReference)addressEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAddress_City() {
		return (EReference)addressEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAddress_Street() {
		return (EReference)addressEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAddress_Housenumber() {
		return (EReference)addressEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAddress_Buildings() {
		return (EReference)addressEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddress_AddressType() {
		return (EAttribute)addressEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCountry() {
		return countryEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCountry_Cities() {
		return (EReference)countryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCountry_Worldregions() {
		return (EReference)countryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCity() {
		return cityEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCity_Streets() {
		return (EReference)cityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGeo() {
		return geoEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGeo_Countries() {
		return (EReference)geoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGeo_Worldregions() {
		return (EReference)geoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWorldRegion() {
		return worldRegionEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStreet() {
		return streetEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStreet_Housenumbers() {
		return (EReference)streetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStreet_Buildings() {
		return (EReference)streetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHouseNumber() {
		return houseNumberEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBuilding() {
		return buildingEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContact() {
		return contactEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContact_Phones() {
		return (EReference)contactEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPhone() {
		return phoneEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPhone_Number() {
		return (EAttribute)phoneEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDomains() {
		return domainsEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDomains_Children() {
		return (EReference)domainsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDomain() {
		return domainEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDomain_Host() {
		return (EAttribute)domainEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDomain_Port() {
		return (EAttribute)domainEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDomain_Resource() {
		return (EAttribute)domainEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHomePages() {
		return homePagesEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHomePages_Children() {
		return (EReference)homePagesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHomePage() {
		return homePageEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHomePage_Type() {
		return (EAttribute)homePageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHomePage_Perspective() {
		return (EReference)homePageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHomePage_Documents() {
		return (EReference)homePageEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHomePage_TextReplacements() {
		return (EReference)homePageEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHomePage_Navigator() {
		return (EAttribute)homePageEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHomePage_ShowHomePageButtons() {
		return (EAttribute)homePageEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHomePage_RootClassName() {
		return (EAttribute)homePageEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDocuments() {
		return documentsEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocuments_Children() {
		return (EReference)documentsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDocument() {
		return documentEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocument_Path() {
		return (EAttribute)documentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocument_Type() {
		return (EAttribute)documentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getKeyValue() {
		return keyValueEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKeyValue_Key() {
		return (EAttribute)keyValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKeyValue_Value() {
		return (EAttribute)keyValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getKeyValues() {
		return keyValuesEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKeyValues_Keyvalues() {
		return (EReference)keyValuesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKeyValues_KeyvaluesFolder() {
		return (EReference)keyValuesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommand() {
		return commandEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCommand_Service() {
		return (EReference)commandEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommands() {
		return commandsEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCommands_Children() {
		return (EReference)commandsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServices() {
		return servicesEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServices_Children() {
		return (EReference)servicesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getService() {
		return serviceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getService_ClassName() {
		return (EAttribute)serviceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getToolType() {
		return toolTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFontStyles() {
		return fontStylesEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getToolBarReplacementPolicy() {
		return toolBarReplacementPolicyEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getGroupType() {
		return groupTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAddressType() {
		return addressTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getHomePageType() {
		return homePageTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDocumentType() {
		return documentTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RcplFactory getRcplFactory() {
		return (RcplFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		layoutableEClass = createEClass(LAYOUTABLE);
		createEAttribute(layoutableEClass, LAYOUTABLE__LAYOUT_X);
		createEAttribute(layoutableEClass, LAYOUTABLE__LAYOUT_Y);
		createEAttribute(layoutableEClass, LAYOUTABLE__LAYOUT_WIDTH);
		createEAttribute(layoutableEClass, LAYOUTABLE__LAYOUT_HEIGHT);
		createEAttribute(layoutableEClass, LAYOUTABLE__NAME);
		createEAttribute(layoutableEClass, LAYOUTABLE__DESCRIPTION);
		createEAttribute(layoutableEClass, LAYOUTABLE__ID);
		createEAttribute(layoutableEClass, LAYOUTABLE__IMAGE);
		createEAttribute(layoutableEClass, LAYOUTABLE__TOOL_TIP);
		createEAttribute(layoutableEClass, LAYOUTABLE__CREATE_DATE);
		createEAttribute(layoutableEClass, LAYOUTABLE__BEGIN_DATE);
		createEAttribute(layoutableEClass, LAYOUTABLE__END_DATE);
		createEAttribute(layoutableEClass, LAYOUTABLE__LEAF);

		rcplEClass = createEClass(RCPL);
		createEReference(rcplEClass, RCPL__ALL_ADDONS);
		createEReference(rcplEClass, RCPL__ALL_PERSPECTIVES);
		createEReference(rcplEClass, RCPL__PREFERENCES);
		createEReference(rcplEClass, RCPL__ALL_TOOLS);
		createEReference(rcplEClass, RCPL__ALL_FAVORITES);
		createEAttribute(rcplEClass, RCPL__VERSION_MAJOR);
		createEAttribute(rcplEClass, RCPL__VERSION_MINOR);
		createEAttribute(rcplEClass, RCPL__VERSION_MAINTENANCE);
		createEAttribute(rcplEClass, RCPL__BUILD_NUMBER);
		createEAttribute(rcplEClass, RCPL__VERSION_DESCRIPTION);
		createEReference(rcplEClass, RCPL__ALL_RESOURCES);
		createEReference(rcplEClass, RCPL__ALL_PERSONS);
		createEReference(rcplEClass, RCPL__LINKED_RCPLS);
		createEReference(rcplEClass, RCPL__HOMEPAGES);
		createEReference(rcplEClass, RCPL__DOCUMENTS);
		createEReference(rcplEClass, RCPL__KEYVALUES);
		createEAttribute(rcplEClass, RCPL__IMAGE_URLS);
		createEAttribute(rcplEClass, RCPL__SERVICE_CLASSES);
		createEAttribute(rcplEClass, RCPL__HOME_URL);
		createEReference(rcplEClass, RCPL__COMMANDS);
		createEReference(rcplEClass, RCPL__SERVICES);

		perspectivesEClass = createEClass(PERSPECTIVES);
		createEReference(perspectivesEClass, PERSPECTIVES__CHILDREN);

		perspectiveEClass = createEClass(PERSPECTIVE);
		createEReference(perspectiveEClass, PERSPECTIVE__SIDE_TOOL_BAR);
		createEReference(perspectiveEClass, PERSPECTIVE__TOP_TOOL_BAR);
		createEReference(perspectiveEClass, PERSPECTIVE__QUICK_TOOL_BAR);
		createEReference(perspectiveEClass, PERSPECTIVE__RIBBON_TOOL_BAR);
		createEAttribute(perspectiveEClass, PERSPECTIVE__OVERVIEW);

		preferenceEClass = createEClass(PREFERENCE);
		createEAttribute(preferenceEClass, PREFERENCE__KEY);
		createEAttribute(preferenceEClass, PREFERENCE__VALUE);
		createEAttribute(preferenceEClass, PREFERENCE__TYPE);

		loginsEClass = createEClass(LOGINS);
		createEReference(loginsEClass, LOGINS__CHILDREN);

		loginEClass = createEClass(LOGIN);
		createEAttribute(loginEClass, LOGIN__COUNTRY);
		createEAttribute(loginEClass, LOGIN__PASSWORD);
		createEReference(loginEClass, LOGIN__RCPL);
		createEAttribute(loginEClass, LOGIN__USER_ID);
		createEReference(loginEClass, LOGIN__PERSON);
		createEReference(loginEClass, LOGIN__DOMAINS);

		favoritesEClass = createEClass(FAVORITES);
		createEReference(favoritesEClass, FAVORITES__CHILDREN);
		createEAttribute(favoritesEClass, FAVORITES__DEFAULT_SET_ID);

		favoriteEClass = createEClass(FAVORITE);
		createEAttribute(favoriteEClass, FAVORITE__LINK);
		createEAttribute(favoriteEClass, FAVORITE__URI);
		createEAttribute(favoriteEClass, FAVORITE__URL);
		createEAttribute(favoriteEClass, FAVORITE__CREATION_DATE);
		createEAttribute(favoriteEClass, FAVORITE__DOCUMENT_CREATION_DATE);
		createEAttribute(favoriteEClass, FAVORITE__RATING);
		createEAttribute(favoriteEClass, FAVORITE__LAST_USED_DATE);
		createEAttribute(favoriteEClass, FAVORITE__FREQUENCY);
		createEAttribute(favoriteEClass, FAVORITE__PASSWORD);
		createEAttribute(favoriteEClass, FAVORITE__FORMAT);
		createEAttribute(favoriteEClass, FAVORITE__SHOW_ON_TOOL_BAR);

		favoritesGroupEClass = createEClass(FAVORITES_GROUP);
		createEReference(favoritesGroupEClass, FAVORITES_GROUP__GROUPS);
		createEReference(favoritesGroupEClass, FAVORITES_GROUP__FAVORITES);
		createEReference(favoritesGroupEClass, FAVORITES_GROUP__LINKED_FAVORITES);

		preferencesEClass = createEClass(PREFERENCES);
		createEReference(preferencesEClass, PREFERENCES__CHILDREN);
		createEAttribute(preferencesEClass, PREFERENCES__SYSTEM);

		addonsEClass = createEClass(ADDONS);
		createEReference(addonsEClass, ADDONS__CHILDREN);

		addonEClass = createEClass(ADDON);
		createEAttribute(addonEClass, ADDON__BUNDLE_ID);
		createEAttribute(addonEClass, ADDON__CLASS_NAME);
		createEAttribute(addonEClass, ADDON__ROLES);
		createEAttribute(addonEClass, ADDON__USERS);
		createEAttribute(addonEClass, ADDON__GROUPS);
		createEAttribute(addonEClass, ADDON__IS_PERSPECTIVE);
		createEAttribute(addonEClass, ADDON__READ_ONLY);
		createEReference(addonEClass, ADDON__DEFAULT_PERSPECTIVE);
		createEReference(addonEClass, ADDON__PERSPECTIVES);
		createEAttribute(addonEClass, ADDON__ROOT_CLASS_NAME);

		abstractToolEClass = createEClass(ABSTRACT_TOOL);
		createEAttribute(abstractToolEClass, ABSTRACT_TOOL__X);
		createEAttribute(abstractToolEClass, ABSTRACT_TOOL__Y);
		createEAttribute(abstractToolEClass, ABSTRACT_TOOL__WIDTH);
		createEAttribute(abstractToolEClass, ABSTRACT_TOOL__HEIGHT);
		createEAttribute(abstractToolEClass, ABSTRACT_TOOL__GRID_X);
		createEAttribute(abstractToolEClass, ABSTRACT_TOOL__GRID_Y);
		createEAttribute(abstractToolEClass, ABSTRACT_TOOL__SPAN_X);
		createEAttribute(abstractToolEClass, ABSTRACT_TOOL__SPAN_Y);
		createEAttribute(abstractToolEClass, ABSTRACT_TOOL__LABELED);
		createEAttribute(abstractToolEClass, ABSTRACT_TOOL__NOT_IMPLEMENTED);
		createEAttribute(abstractToolEClass, ABSTRACT_TOOL__SERVICE);
		createEAttribute(abstractToolEClass, ABSTRACT_TOOL__DETAIL_PANE_CLASS_NAME);
		createEAttribute(abstractToolEClass, ABSTRACT_TOOL__TYPE);
		createEAttribute(abstractToolEClass, ABSTRACT_TOOL__SYSTEM);
		createEAttribute(abstractToolEClass, ABSTRACT_TOOL__URL);
		createEAttribute(abstractToolEClass, ABSTRACT_TOOL__TOGGLE_GROUP);
		createEReference(abstractToolEClass, ABSTRACT_TOOL__EXPAND_TOOL_GROUP);
		createEAttribute(abstractToolEClass, ABSTRACT_TOOL__HGROW);
		createEAttribute(abstractToolEClass, ABSTRACT_TOOL__VGROW);
		createEAttribute(abstractToolEClass, ABSTRACT_TOOL__WIDTH_PERCENT);

		toolEClass = createEClass(TOOL);
		createEAttribute(toolEClass, TOOL__FORMAT);

		toolGroupEClass = createEClass(TOOL_GROUP);
		createEReference(toolGroupEClass, TOOL_GROUP__TOOL_GROUPS);
		createEAttribute(toolGroupEClass, TOOL_GROUP__GRID);
		createEAttribute(toolGroupEClass, TOOL_GROUP__FORMAT);
		createEReference(toolGroupEClass, TOOL_GROUP__TOOLS);
		createEAttribute(toolGroupEClass, TOOL_GROUP__GROUP_TYPE);

		toolsEClass = createEClass(TOOLS);
		createEReference(toolsEClass, TOOLS__TOOLGROUP_CHILDREN);
		createEReference(toolsEClass, TOOLS__TOOL_CHILDREN);

		ribbonToolBarEClass = createEClass(RIBBON_TOOL_BAR);
		createEReference(ribbonToolBarEClass, RIBBON_TOOL_BAR__TOOL_GROUPS);
		createEReference(ribbonToolBarEClass, RIBBON_TOOL_BAR__TOOLS);

		topToolBarEClass = createEClass(TOP_TOOL_BAR);
		createEReference(topToolBarEClass, TOP_TOOL_BAR__TOOL_GROUPS);
		createEReference(topToolBarEClass, TOP_TOOL_BAR__TOOLS);

		sideToolBarEClass = createEClass(SIDE_TOOL_BAR);
		createEReference(sideToolBarEClass, SIDE_TOOL_BAR__TOOL_GROUPS);
		createEReference(sideToolBarEClass, SIDE_TOOL_BAR__TOOLS);

		quickToolBarEClass = createEClass(QUICK_TOOL_BAR);
		createEReference(quickToolBarEClass, QUICK_TOOL_BAR__TOOL_GROUPS);
		createEReference(quickToolBarEClass, QUICK_TOOL_BAR__TOOLS);

		folderEClass = createEClass(FOLDER);
		createEReference(folderEClass, FOLDER__FOLDERS);
		createEReference(folderEClass, FOLDER__RESOURCES);
		createEReference(folderEClass, FOLDER__LINKED_RESOURCES);

		resourceEClass = createEClass(RESOURCE);
		createEAttribute(resourceEClass, RESOURCE__URI);
		createEAttribute(resourceEClass, RESOURCE__TEMPLATE);
		createEReference(resourceEClass, RESOURCE__LINKED_RESOURCES);
		createEReference(resourceEClass, RESOURCE__MAIN_PERSPECTIVE);

		personEClass = createEClass(PERSON);
		createEAttribute(personEClass, PERSON__LAST_NAME);
		createEAttribute(personEClass, PERSON__MIDDLE_NAME);
		createEAttribute(personEClass, PERSON__FIRST_NAME);
		createEReference(personEClass, PERSON__ADDRESSES);

		personGroupEClass = createEClass(PERSON_GROUP);
		createEReference(personGroupEClass, PERSON_GROUP__PERSONGROUPS);
		createEReference(personGroupEClass, PERSON_GROUP__PERSONS);
		createEReference(personGroupEClass, PERSON_GROUP__LINKED_PERSONS);
		createEReference(personGroupEClass, PERSON_GROUP__LINKED_PERSONGROUPS);

		resourcesEClass = createEClass(RESOURCES);
		createEReference(resourcesEClass, RESOURCES__CHILDREN);

		preferenceGroupEClass = createEClass(PREFERENCE_GROUP);
		createEReference(preferenceGroupEClass, PREFERENCE_GROUP__PREFERENCES);
		createEReference(preferenceGroupEClass, PREFERENCE_GROUP__LINKED_PREFERENCES);
		createEReference(preferenceGroupEClass, PREFERENCE_GROUP__PREFERENCEGROUPS);

		personsEClass = createEClass(PERSONS);
		createEReference(personsEClass, PERSONS__CHILDREN);

		rcplTemplatesEClass = createEClass(RCPL_TEMPLATES);
		createEReference(rcplTemplatesEClass, RCPL_TEMPLATES__CHILDREN);

		jPersonEClass = createEClass(JPERSON);

		nPersonEClass = createEClass(NPERSON);

		addressEClass = createEClass(ADDRESS);
		createEReference(addressEClass, ADDRESS__COUNTRY);
		createEReference(addressEClass, ADDRESS__CITY);
		createEReference(addressEClass, ADDRESS__STREET);
		createEReference(addressEClass, ADDRESS__HOUSENUMBER);
		createEReference(addressEClass, ADDRESS__BUILDINGS);
		createEAttribute(addressEClass, ADDRESS__ADDRESS_TYPE);

		countryEClass = createEClass(COUNTRY);
		createEReference(countryEClass, COUNTRY__CITIES);
		createEReference(countryEClass, COUNTRY__WORLDREGIONS);

		cityEClass = createEClass(CITY);
		createEReference(cityEClass, CITY__STREETS);

		geoEClass = createEClass(GEO);
		createEReference(geoEClass, GEO__COUNTRIES);
		createEReference(geoEClass, GEO__WORLDREGIONS);

		worldRegionEClass = createEClass(WORLD_REGION);

		streetEClass = createEClass(STREET);
		createEReference(streetEClass, STREET__HOUSENUMBERS);
		createEReference(streetEClass, STREET__BUILDINGS);

		houseNumberEClass = createEClass(HOUSE_NUMBER);

		buildingEClass = createEClass(BUILDING);

		contactEClass = createEClass(CONTACT);
		createEReference(contactEClass, CONTACT__PHONES);

		phoneEClass = createEClass(PHONE);
		createEAttribute(phoneEClass, PHONE__NUMBER);

		domainsEClass = createEClass(DOMAINS);
		createEReference(domainsEClass, DOMAINS__CHILDREN);

		domainEClass = createEClass(DOMAIN);
		createEAttribute(domainEClass, DOMAIN__HOST);
		createEAttribute(domainEClass, DOMAIN__PORT);
		createEAttribute(domainEClass, DOMAIN__RESOURCE);

		homePagesEClass = createEClass(HOME_PAGES);
		createEReference(homePagesEClass, HOME_PAGES__CHILDREN);

		homePageEClass = createEClass(HOME_PAGE);
		createEAttribute(homePageEClass, HOME_PAGE__TYPE);
		createEReference(homePageEClass, HOME_PAGE__PERSPECTIVE);
		createEReference(homePageEClass, HOME_PAGE__DOCUMENTS);
		createEReference(homePageEClass, HOME_PAGE__TEXT_REPLACEMENTS);
		createEAttribute(homePageEClass, HOME_PAGE__NAVIGATOR);
		createEAttribute(homePageEClass, HOME_PAGE__SHOW_HOME_PAGE_BUTTONS);
		createEAttribute(homePageEClass, HOME_PAGE__ROOT_CLASS_NAME);

		documentsEClass = createEClass(DOCUMENTS);
		createEReference(documentsEClass, DOCUMENTS__CHILDREN);

		documentEClass = createEClass(DOCUMENT);
		createEAttribute(documentEClass, DOCUMENT__PATH);
		createEAttribute(documentEClass, DOCUMENT__TYPE);

		keyValueEClass = createEClass(KEY_VALUE);
		createEAttribute(keyValueEClass, KEY_VALUE__KEY);
		createEAttribute(keyValueEClass, KEY_VALUE__VALUE);

		keyValuesEClass = createEClass(KEY_VALUES);
		createEReference(keyValuesEClass, KEY_VALUES__KEYVALUES);
		createEReference(keyValuesEClass, KEY_VALUES__KEYVALUES_FOLDER);

		commandEClass = createEClass(COMMAND);
		createEReference(commandEClass, COMMAND__SERVICE);

		commandsEClass = createEClass(COMMANDS);
		createEReference(commandsEClass, COMMANDS__CHILDREN);

		servicesEClass = createEClass(SERVICES);
		createEReference(servicesEClass, SERVICES__CHILDREN);

		serviceEClass = createEClass(SERVICE);
		createEAttribute(serviceEClass, SERVICE__CLASS_NAME);

		// Create enums
		toolTypeEEnum = createEEnum(TOOL_TYPE);
		fontStylesEEnum = createEEnum(FONT_STYLES);
		toolBarReplacementPolicyEEnum = createEEnum(TOOL_BAR_REPLACEMENT_POLICY);
		groupTypeEEnum = createEEnum(GROUP_TYPE);
		addressTypeEEnum = createEEnum(ADDRESS_TYPE);
		homePageTypeEEnum = createEEnum(HOME_PAGE_TYPE);
		documentTypeEEnum = createEEnum(DOCUMENT_TYPE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This method is
	 * guarded to have no affect on any invocation but its first. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		rcplEClass.getESuperTypes().add(this.getLayoutable());
		perspectivesEClass.getESuperTypes().add(this.getLayoutable());
		perspectiveEClass.getESuperTypes().add(this.getLayoutable());
		preferenceEClass.getESuperTypes().add(this.getLayoutable());
		loginsEClass.getESuperTypes().add(this.getLayoutable());
		loginEClass.getESuperTypes().add(this.getLayoutable());
		favoritesEClass.getESuperTypes().add(this.getLayoutable());
		favoriteEClass.getESuperTypes().add(this.getLayoutable());
		favoritesGroupEClass.getESuperTypes().add(this.getLayoutable());
		preferencesEClass.getESuperTypes().add(this.getLayoutable());
		addonsEClass.getESuperTypes().add(this.getLayoutable());
		addonEClass.getESuperTypes().add(this.getLayoutable());
		abstractToolEClass.getESuperTypes().add(this.getLayoutable());
		toolEClass.getESuperTypes().add(this.getAbstractTool());
		toolGroupEClass.getESuperTypes().add(this.getAbstractTool());
		toolsEClass.getESuperTypes().add(this.getLayoutable());
		ribbonToolBarEClass.getESuperTypes().add(this.getLayoutable());
		topToolBarEClass.getESuperTypes().add(this.getLayoutable());
		sideToolBarEClass.getESuperTypes().add(this.getLayoutable());
		quickToolBarEClass.getESuperTypes().add(this.getLayoutable());
		folderEClass.getESuperTypes().add(this.getLayoutable());
		resourceEClass.getESuperTypes().add(this.getLayoutable());
		personEClass.getESuperTypes().add(this.getLayoutable());
		personGroupEClass.getESuperTypes().add(this.getLayoutable());
		resourcesEClass.getESuperTypes().add(this.getLayoutable());
		preferenceGroupEClass.getESuperTypes().add(this.getLayoutable());
		personsEClass.getESuperTypes().add(this.getLayoutable());
		rcplTemplatesEClass.getESuperTypes().add(this.getLayoutable());
		jPersonEClass.getESuperTypes().add(this.getPerson());
		nPersonEClass.getESuperTypes().add(this.getPerson());
		addressEClass.getESuperTypes().add(this.getLayoutable());
		countryEClass.getESuperTypes().add(this.getLayoutable());
		cityEClass.getESuperTypes().add(this.getLayoutable());
		geoEClass.getESuperTypes().add(this.getLayoutable());
		worldRegionEClass.getESuperTypes().add(this.getLayoutable());
		streetEClass.getESuperTypes().add(this.getLayoutable());
		houseNumberEClass.getESuperTypes().add(this.getLayoutable());
		buildingEClass.getESuperTypes().add(this.getLayoutable());
		contactEClass.getESuperTypes().add(this.getLayoutable());
		phoneEClass.getESuperTypes().add(this.getLayoutable());
		homePagesEClass.getESuperTypes().add(this.getLayoutable());
		homePageEClass.getESuperTypes().add(this.getLayoutable());
		documentsEClass.getESuperTypes().add(this.getLayoutable());
		documentEClass.getESuperTypes().add(this.getLayoutable());
		keyValueEClass.getESuperTypes().add(this.getLayoutable());
		keyValuesEClass.getESuperTypes().add(this.getLayoutable());
		commandEClass.getESuperTypes().add(this.getLayoutable());
		serviceEClass.getESuperTypes().add(this.getLayoutable());

		// Initialize classes, features, and operations; add parameters
		initEClass(layoutableEClass, Layoutable.class, "Layoutable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLayoutable_LayoutX(), ecorePackage.getEDouble(), "layoutX", null, 0, 1, Layoutable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLayoutable_LayoutY(), ecorePackage.getEDouble(), "layoutY", null, 0, 1, Layoutable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLayoutable_LayoutWidth(), ecorePackage.getEDouble(), "layoutWidth", null, 0, 1, Layoutable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLayoutable_LayoutHeight(), ecorePackage.getEDouble(), "layoutHeight", null, 0, 1, Layoutable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLayoutable_Name(), ecorePackage.getEString(), "name", null, 0, 1, Layoutable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLayoutable_Description(), ecorePackage.getEString(), "description", null, 0, 1, Layoutable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLayoutable_Id(), ecorePackage.getEString(), "id", null, 0, 1, Layoutable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLayoutable_Image(), ecorePackage.getEString(), "image", null, 0, 1, Layoutable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLayoutable_ToolTip(), ecorePackage.getEString(), "toolTip", null, 0, 1, Layoutable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLayoutable_CreateDate(), ecorePackage.getEDate(), "createDate", null, 0, 1, Layoutable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLayoutable_BeginDate(), ecorePackage.getEDate(), "beginDate", null, 0, 1, Layoutable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLayoutable_EndDate(), ecorePackage.getEDate(), "endDate", null, 0, 1, Layoutable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLayoutable_Leaf(), ecorePackage.getEBoolean(), "leaf", null, 0, 1, Layoutable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rcplEClass, org.eclipse.rcpl.model_2_0_0.rcpl.RCPL.class, "RCPL", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRCPL_AllAddons(), this.getAddons(), null, "allAddons", null, 1, 1, org.eclipse.rcpl.model_2_0_0.rcpl.RCPL.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRCPL_AllPerspectives(), this.getPerspectives(), null, "allPerspectives", null, 1, 1, org.eclipse.rcpl.model_2_0_0.rcpl.RCPL.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRCPL_Preferences(), this.getPreferences(), null, "preferences", null, 1, 1, org.eclipse.rcpl.model_2_0_0.rcpl.RCPL.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRCPL_AllTools(), this.getTools(), null, "allTools", null, 1, 1, org.eclipse.rcpl.model_2_0_0.rcpl.RCPL.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRCPL_AllFavorites(), this.getFavorites(), null, "allFavorites", null, 0, 1, org.eclipse.rcpl.model_2_0_0.rcpl.RCPL.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRCPL_VersionMajor(), ecorePackage.getEInt(), "versionMajor", null, 0, 1, org.eclipse.rcpl.model_2_0_0.rcpl.RCPL.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRCPL_VersionMinor(), ecorePackage.getEInt(), "versionMinor", null, 0, 1, org.eclipse.rcpl.model_2_0_0.rcpl.RCPL.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRCPL_VersionMaintenance(), ecorePackage.getEInt(), "versionMaintenance", null, 0, 1, org.eclipse.rcpl.model_2_0_0.rcpl.RCPL.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRCPL_BuildNumber(), ecorePackage.getEString(), "buildNumber", null, 0, 1, org.eclipse.rcpl.model_2_0_0.rcpl.RCPL.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRCPL_VersionDescription(), ecorePackage.getEString(), "versionDescription", null, 0, 1, org.eclipse.rcpl.model_2_0_0.rcpl.RCPL.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRCPL_AllResources(), this.getResources(), null, "allResources", null, 0, 1, org.eclipse.rcpl.model_2_0_0.rcpl.RCPL.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRCPL_AllPersons(), this.getPersons(), null, "allPersons", null, 0, 1, org.eclipse.rcpl.model_2_0_0.rcpl.RCPL.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRCPL_LinkedRcpls(), this.getRCPL(), null, "linkedRcpls", null, 0, -1, org.eclipse.rcpl.model_2_0_0.rcpl.RCPL.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRCPL_Homepages(), this.getHomePages(), null, "homepages", null, 1, 1, org.eclipse.rcpl.model_2_0_0.rcpl.RCPL.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRCPL_Documents(), this.getDocuments(), null, "documents", null, 1, 1, org.eclipse.rcpl.model_2_0_0.rcpl.RCPL.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRCPL_Keyvalues(), this.getKeyValues(), null, "keyvalues", null, 0, 1, org.eclipse.rcpl.model_2_0_0.rcpl.RCPL.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRCPL_ImageUrls(), ecorePackage.getEString(), "imageUrls", null, 0, -1, org.eclipse.rcpl.model_2_0_0.rcpl.RCPL.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRCPL_ServiceClasses(), ecorePackage.getEString(), "ServiceClasses", null, 0, -1, org.eclipse.rcpl.model_2_0_0.rcpl.RCPL.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRCPL_HomeURL(), ecorePackage.getEString(), "homeURL", null, 0, 1, org.eclipse.rcpl.model_2_0_0.rcpl.RCPL.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRCPL_Commands(), this.getCommands(), null, "commands", null, 0, 1, org.eclipse.rcpl.model_2_0_0.rcpl.RCPL.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRCPL_Services(), this.getServices(), null, "services", null, 0, 1, org.eclipse.rcpl.model_2_0_0.rcpl.RCPL.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(perspectivesEClass, Perspectives.class, "Perspectives", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPerspectives_Children(), this.getPerspective(), null, "children", null, 0, -1, Perspectives.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(perspectiveEClass, Perspective.class, "Perspective", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPerspective_SideToolBar(), this.getSideToolBar(), null, "sideToolBar", null, 1, 1, Perspective.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPerspective_TopToolBar(), this.getTopToolBar(), null, "topToolBar", null, 1, 1, Perspective.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPerspective_QuickToolBar(), this.getQuickToolBar(), null, "quickToolBar", null, 1, 1, Perspective.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPerspective_RibbonToolBar(), this.getRibbonToolBar(), null, "ribbonToolBar", null, 1, 1, Perspective.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerspective_Overview(), ecorePackage.getEBoolean(), "overview", null, 0, 1, Perspective.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(preferenceEClass, Preference.class, "Preference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPreference_Key(), ecorePackage.getEString(), "key", null, 0, 1, Preference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreference_Value(), ecorePackage.getEString(), "value", null, 0, 1, Preference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreference_Type(), ecorePackage.getEString(), "type", null, 0, 1, Preference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(loginsEClass, Logins.class, "Logins", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLogins_Children(), this.getLogin(), null, "children", null, 0, -1, Logins.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(loginEClass, Login.class, "Login", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLogin_Country(), ecorePackage.getEString(), "country", null, 0, 1, Login.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLogin_Password(), ecorePackage.getEString(), "password", null, 0, 1, Login.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLogin_Rcpl(), this.getRCPL(), null, "rcpl", null, 0, 1, Login.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLogin_UserId(), ecorePackage.getEString(), "userId", null, 0, 1, Login.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLogin_Person(), this.getPerson(), null, "person", null, 0, 1, Login.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLogin_Domains(), this.getDomain(), null, "domains", null, 0, -1, Login.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(favoritesEClass, Favorites.class, "Favorites", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFavorites_Children(), this.getFavoritesGroup(), null, "children", null, 1, -1, Favorites.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFavorites_DefaultSetId(), ecorePackage.getEString(), "defaultSetId", null, 0, 1, Favorites.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(favoriteEClass, Favorite.class, "Favorite", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFavorite_Link(), ecorePackage.getEString(), "link", null, 0, 1, Favorite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFavorite_URI(), ecorePackage.getEString(), "URI", null, 0, 1, Favorite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFavorite_URL(), ecorePackage.getEString(), "URL", null, 0, 1, Favorite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFavorite_CreationDate(), ecorePackage.getEDate(), "creationDate", null, 0, 1, Favorite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFavorite_DocumentCreationDate(), ecorePackage.getEDate(), "documentCreationDate", null, 0, 1, Favorite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFavorite_Rating(), ecorePackage.getEDouble(), "rating", null, 0, 1, Favorite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFavorite_LastUsedDate(), ecorePackage.getEDate(), "lastUsedDate", null, 0, 1, Favorite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFavorite_Frequency(), ecorePackage.getEDouble(), "frequency", null, 0, 1, Favorite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFavorite_Password(), ecorePackage.getEString(), "password", null, 0, 1, Favorite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFavorite_Format(), ecorePackage.getEString(), "format", null, 0, 1, Favorite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFavorite_ShowOnToolBar(), ecorePackage.getEBoolean(), "showOnToolBar", null, 0, 1, Favorite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(favoritesGroupEClass, FavoritesGroup.class, "FavoritesGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFavoritesGroup_Groups(), this.getFavoritesGroup(), null, "groups", null, 0, -1, FavoritesGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFavoritesGroup_Favorites(), this.getFavorite(), null, "favorites", null, 0, -1, FavoritesGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFavoritesGroup_LinkedFavorites(), this.getFavorite(), null, "linkedFavorites", null, 0, -1, FavoritesGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(preferencesEClass, Preferences.class, "Preferences", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPreferences_Children(), this.getPreferenceGroup(), null, "children", null, 0, -1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_System(), ecorePackage.getEBoolean(), "system", null, 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(addonsEClass, Addons.class, "Addons", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAddons_Children(), this.getAddon(), null, "children", null, 0, -1, Addons.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(addonEClass, Addon.class, "Addon", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAddon_BundleId(), ecorePackage.getEString(), "bundleId", null, 0, 1, Addon.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAddon_ClassName(), ecorePackage.getEString(), "className", null, 0, 1, Addon.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAddon_Roles(), ecorePackage.getEString(), "roles", null, 0, -1, Addon.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAddon_Users(), ecorePackage.getEString(), "users", null, 0, -1, Addon.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAddon_Groups(), ecorePackage.getEString(), "groups", null, 0, -1, Addon.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAddon_IsPerspective(), ecorePackage.getEBoolean(), "isPerspective", null, 0, 1, Addon.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAddon_ReadOnly(), ecorePackage.getEBoolean(), "readOnly", null, 0, 1, Addon.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAddon_DefaultPerspective(), this.getPerspective(), null, "defaultPerspective", null, 1, 1, Addon.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAddon_Perspectives(), this.getPerspective(), null, "perspectives", null, 0, -1, Addon.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAddon_RootClassName(), ecorePackage.getEString(), "rootClassName", null, 0, 1, Addon.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractToolEClass, AbstractTool.class, "AbstractTool", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractTool_X(), ecorePackage.getEDouble(), "x", null, 0, 1, AbstractTool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractTool_Y(), ecorePackage.getEDouble(), "y", null, 0, 1, AbstractTool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractTool_Width(), ecorePackage.getEDouble(), "width", null, 0, 1, AbstractTool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractTool_Height(), ecorePackage.getEDouble(), "height", null, 0, 1, AbstractTool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractTool_GridX(), ecorePackage.getEInt(), "gridX", null, 0, 1, AbstractTool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractTool_GridY(), ecorePackage.getEInt(), "gridY", null, 0, 1, AbstractTool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractTool_SpanX(), ecorePackage.getEInt(), "spanX", "1", 0, 1, AbstractTool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractTool_SpanY(), ecorePackage.getEInt(), "spanY", "1", 0, 1, AbstractTool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractTool_Labeled(), ecorePackage.getEBoolean(), "labeled", null, 0, 1, AbstractTool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractTool_NotImplemented(), ecorePackage.getEBoolean(), "notImplemented", null, 0, 1, AbstractTool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractTool_Service(), ecorePackage.getEString(), "service", null, 0, 1, AbstractTool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractTool_DetailPaneClassName(), ecorePackage.getEString(), "detailPaneClassName", null, 0, 1, AbstractTool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractTool_Type(), this.getToolType(), "type", null, 0, 1, AbstractTool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractTool_System(), ecorePackage.getEBoolean(), "system", null, 0, 1, AbstractTool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractTool_Url(), ecorePackage.getEString(), "url", null, 0, 1, AbstractTool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractTool_ToggleGroup(), ecorePackage.getEBoolean(), "toggleGroup", null, 0, 1, AbstractTool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractTool_ExpandToolGroup(), this.getToolGroup(), null, "expandToolGroup", null, 0, 1, AbstractTool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractTool_HGrow(), ecorePackage.getEBoolean(), "hGrow", null, 0, 1, AbstractTool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractTool_VGrow(), ecorePackage.getEBoolean(), "vGrow", null, 0, 1, AbstractTool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractTool_WidthPercent(), ecorePackage.getEDouble(), "widthPercent", null, 0, 1, AbstractTool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(toolEClass, Tool.class, "Tool", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTool_Format(), ecorePackage.getEString(), "format", null, 0, 1, Tool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(toolGroupEClass, ToolGroup.class, "ToolGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getToolGroup_ToolGroups(), this.getToolGroup(), null, "toolGroups", null, 0, -1, ToolGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getToolGroup_Grid(), ecorePackage.getEBoolean(), "grid", null, 0, 1, ToolGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getToolGroup_Format(), ecorePackage.getEString(), "format", null, 0, 1, ToolGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getToolGroup_Tools(), this.getTool(), null, "tools", null, 0, -1, ToolGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getToolGroup_GroupType(), this.getGroupType(), "groupType", null, 0, 1, ToolGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(toolsEClass, Tools.class, "Tools", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTools_ToolgroupChildren(), this.getToolGroup(), null, "toolgroupChildren", null, 0, -1, Tools.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTools_ToolChildren(), this.getTool(), null, "toolChildren", null, 0, -1, Tools.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ribbonToolBarEClass, RibbonToolBar.class, "RibbonToolBar", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRibbonToolBar_ToolGroups(), this.getToolGroup(), null, "toolGroups", null, 0, -1, RibbonToolBar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRibbonToolBar_Tools(), this.getTool(), null, "tools", null, 0, -1, RibbonToolBar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(topToolBarEClass, TopToolBar.class, "TopToolBar", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTopToolBar_ToolGroups(), this.getToolGroup(), null, "toolGroups", null, 0, -1, TopToolBar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTopToolBar_Tools(), this.getTool(), null, "tools", null, 0, -1, TopToolBar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sideToolBarEClass, SideToolBar.class, "SideToolBar", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSideToolBar_ToolGroups(), this.getToolGroup(), null, "toolGroups", null, 0, -1, SideToolBar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSideToolBar_Tools(), this.getTool(), null, "tools", null, 0, -1, SideToolBar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(quickToolBarEClass, QuickToolBar.class, "QuickToolBar", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getQuickToolBar_ToolGroups(), this.getToolGroup(), null, "toolGroups", null, 0, -1, QuickToolBar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQuickToolBar_Tools(), this.getTool(), null, "tools", null, 0, -1, QuickToolBar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(folderEClass, Folder.class, "Folder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFolder_Folders(), this.getFolder(), null, "folders", null, 0, -1, Folder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFolder_Resources(), this.getResource(), null, "resources", null, 0, -1, Folder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFolder_LinkedResources(), this.getResource(), null, "linkedResources", null, 0, -1, Folder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resourceEClass, Resource.class, "Resource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResource_Uri(), ecorePackage.getEString(), "uri", null, 0, 1, Resource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResource_Template(), ecorePackage.getEBoolean(), "template", null, 0, 1, Resource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResource_LinkedResources(), this.getResource(), null, "linkedResources", null, 0, -1, Resource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResource_MainPerspective(), this.getPerspective(), null, "mainPerspective", null, 0, 1, Resource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(personEClass, Person.class, "Person", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPerson_LastName(), ecorePackage.getEString(), "lastName", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_MiddleName(), ecorePackage.getEString(), "middleName", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_FirstName(), ecorePackage.getEString(), "firstName", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPerson_Addresses(), this.getAddress(), null, "addresses", null, 0, -1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(personGroupEClass, PersonGroup.class, "PersonGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPersonGroup_Persongroups(), this.getPersonGroup(), null, "persongroups", null, 0, -1, PersonGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPersonGroup_Persons(), this.getPerson(), null, "persons", null, 0, -1, PersonGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPersonGroup_LinkedPersons(), this.getPerson(), null, "linkedPersons", null, 0, -1, PersonGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPersonGroup_LinkedPersongroups(), this.getPersonGroup(), null, "linkedPersongroups", null, 0, -1, PersonGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resourcesEClass, Resources.class, "Resources", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResources_Children(), this.getFolder(), null, "children", null, 0, -1, Resources.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(preferenceGroupEClass, PreferenceGroup.class, "PreferenceGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPreferenceGroup_Preferences(), this.getPreference(), null, "preferences", null, 0, -1, PreferenceGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPreferenceGroup_LinkedPreferences(), this.getPreference(), null, "linkedPreferences", null, 0, -1, PreferenceGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPreferenceGroup_Preferencegroups(), this.getPreferenceGroup(), null, "preferencegroups", null, 0, -1, PreferenceGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(personsEClass, Persons.class, "Persons", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPersons_Children(), this.getPersonGroup(), null, "children", null, 0, -1, Persons.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rcplTemplatesEClass, RCPLTemplates.class, "RCPLTemplates", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRCPLTemplates_Children(), this.getRCPL(), null, "children", null, 0, -1, RCPLTemplates.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jPersonEClass, JPerson.class, "JPerson", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(nPersonEClass, NPerson.class, "NPerson", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(addressEClass, Address.class, "Address", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAddress_Country(), this.getCountry(), null, "country", null, 0, 1, Address.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAddress_City(), this.getCity(), null, "city", null, 0, 1, Address.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAddress_Street(), this.getStreet(), null, "street", null, 0, 1, Address.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAddress_Housenumber(), this.getHouseNumber(), null, "housenumber", null, 0, -1, Address.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAddress_Buildings(), this.getBuilding(), null, "buildings", null, 0, -1, Address.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAddress_AddressType(), this.getAddressType(), "addressType", null, 0, 1, Address.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(countryEClass, Country.class, "Country", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCountry_Cities(), this.getCity(), null, "cities", null, 0, -1, Country.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCountry_Worldregions(), this.getWorldRegion(), null, "worldregions", null, 0, -1, Country.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cityEClass, City.class, "City", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCity_Streets(), this.getStreet(), null, "streets", null, 0, -1, City.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(geoEClass, Geo.class, "Geo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGeo_Countries(), this.getCountry(), null, "countries", null, 0, -1, Geo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGeo_Worldregions(), this.getWorldRegion(), null, "worldregions", null, 0, -1, Geo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(worldRegionEClass, WorldRegion.class, "WorldRegion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(streetEClass, Street.class, "Street", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStreet_Housenumbers(), this.getHouseNumber(), null, "housenumbers", null, 0, -1, Street.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStreet_Buildings(), this.getBuilding(), null, "buildings", null, 0, -1, Street.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(houseNumberEClass, HouseNumber.class, "HouseNumber", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(buildingEClass, Building.class, "Building", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(contactEClass, Contact.class, "Contact", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getContact_Phones(), this.getPhone(), null, "phones", null, 0, -1, Contact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(phoneEClass, Phone.class, "Phone", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPhone_Number(), ecorePackage.getEString(), "number", null, 0, 1, Phone.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(domainsEClass, Domains.class, "Domains", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDomains_Children(), this.getDomain(), null, "children", null, 0, -1, Domains.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(domainEClass, Domain.class, "Domain", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDomain_Host(), ecorePackage.getEString(), "host", null, 0, 1, Domain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDomain_Port(), ecorePackage.getEInt(), "port", null, 0, 1, Domain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDomain_Resource(), ecorePackage.getEString(), "resource", null, 0, 1, Domain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(homePagesEClass, HomePages.class, "HomePages", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getHomePages_Children(), this.getHomePage(), null, "children", null, 0, -1, HomePages.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(homePageEClass, HomePage.class, "HomePage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHomePage_Type(), this.getHomePageType(), "type", null, 0, 1, HomePage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHomePage_Perspective(), this.getPerspective(), null, "perspective", null, 0, 1, HomePage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHomePage_Documents(), this.getDocument(), null, "documents", null, 0, -1, HomePage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHomePage_TextReplacements(), this.getKeyValue(), null, "textReplacements", null, 0, -1, HomePage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHomePage_Navigator(), ecorePackage.getEBoolean(), "navigator", null, 0, 1, HomePage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHomePage_ShowHomePageButtons(), ecorePackage.getEBoolean(), "showHomePageButtons", null, 0, 1, HomePage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHomePage_RootClassName(), ecorePackage.getEString(), "rootClassName", null, 0, 1, HomePage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(documentsEClass, Documents.class, "Documents", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDocuments_Children(), this.getDocument(), null, "children", null, 0, -1, Documents.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(documentEClass, Document.class, "Document", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDocument_Path(), ecorePackage.getEString(), "path", null, 0, 1, Document.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocument_Type(), this.getDocumentType(), "type", "TEXT", 0, 1, Document.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(keyValueEClass, KeyValue.class, "KeyValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getKeyValue_Key(), ecorePackage.getEString(), "key", null, 0, 1, KeyValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getKeyValue_Value(), ecorePackage.getEString(), "value", null, 0, 1, KeyValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(keyValuesEClass, KeyValues.class, "KeyValues", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getKeyValues_Keyvalues(), this.getKeyValue(), null, "keyvalues", null, 0, -1, KeyValues.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKeyValues_KeyvaluesFolder(), this.getKeyValues(), null, "keyvaluesFolder", null, 0, -1, KeyValues.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(commandEClass, Command.class, "Command", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCommand_Service(), this.getService(), null, "service", null, 0, 1, Command.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(commandsEClass, Commands.class, "Commands", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCommands_Children(), this.getCommand(), null, "children", null, 0, -1, Commands.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(servicesEClass, Services.class, "Services", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getServices_Children(), this.getService(), null, "children", null, 0, -1, Services.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serviceEClass, Service.class, "Service", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getService_ClassName(), ecorePackage.getEString(), "className", null, 0, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(toolTypeEEnum, ToolType.class, "ToolType");
		addEEnumLiteral(toolTypeEEnum, ToolType.BUTTON);
		addEEnumLiteral(toolTypeEEnum, ToolType.TOGGLEBUTTON);
		addEEnumLiteral(toolTypeEEnum, ToolType.TEXTFIELD);
		addEEnumLiteral(toolTypeEEnum, ToolType.PASSWORDFIELD);
		addEEnumLiteral(toolTypeEEnum, ToolType.DATEFIELD);
		addEEnumLiteral(toolTypeEEnum, ToolType.DATEANDTIMEFIELD);
		addEEnumLiteral(toolTypeEEnum, ToolType.SPLITMENUBUTTON);
		addEEnumLiteral(toolTypeEEnum, ToolType.RADIOBUTTON);
		addEEnumLiteral(toolTypeEEnum, ToolType.CHECKBOX);
		addEEnumLiteral(toolTypeEEnum, ToolType.COMBO);
		addEEnumLiteral(toolTypeEEnum, ToolType.NAVIGATOR);
		addEEnumLiteral(toolTypeEEnum, ToolType.COLOR_CHOOSER);
		addEEnumLiteral(toolTypeEEnum, ToolType.OTHER);
		addEEnumLiteral(toolTypeEEnum, ToolType.CHOICEBOX);
		addEEnumLiteral(toolTypeEEnum, ToolType.HTMLEDITOR);
		addEEnumLiteral(toolTypeEEnum, ToolType.HYPERLINK);
		addEEnumLiteral(toolTypeEEnum, ToolType.IMAGEVIEW);
		addEEnumLiteral(toolTypeEEnum, ToolType.LABEL);
		addEEnumLiteral(toolTypeEEnum, ToolType.LISTVIEW);
		addEEnumLiteral(toolTypeEEnum, ToolType.SEPARATOR_VERTICAL);
		addEEnumLiteral(toolTypeEEnum, ToolType.MENUBAR);
		addEEnumLiteral(toolTypeEEnum, ToolType.SEPARATOR_HORIZONTAL);
		addEEnumLiteral(toolTypeEEnum, ToolType.PROGRESSINDICATOR);
		addEEnumLiteral(toolTypeEEnum, ToolType.PROGRESSBAR);
		addEEnumLiteral(toolTypeEEnum, ToolType.MENUBUTTON);
		addEEnumLiteral(toolTypeEEnum, ToolType.WEBVIEW);
		addEEnumLiteral(toolTypeEEnum, ToolType.TEXTAREA);
		addEEnumLiteral(toolTypeEEnum, ToolType.SLIDER_VERTICAL);
		addEEnumLiteral(toolTypeEEnum, ToolType.SLIDER_HORIZONTAL);
		addEEnumLiteral(toolTypeEEnum, ToolType.GRIDPANE);
		addEEnumLiteral(toolTypeEEnum, ToolType.FLOWPANE);
		addEEnumLiteral(toolTypeEEnum, ToolType.MATH_EDITOR);
		addEEnumLiteral(toolTypeEEnum, ToolType.SVG_EDITOR);
		addEEnumLiteral(toolTypeEEnum, ToolType.IMAGE_EDITOR);
		addEEnumLiteral(toolTypeEEnum, ToolType.LINE_WIDTH);
		addEEnumLiteral(toolTypeEEnum, ToolType.LINE_DASHES);
		addEEnumLiteral(toolTypeEEnum, ToolType.LINE_ARROWS);
		addEEnumLiteral(toolTypeEEnum, ToolType.PATTERN);
		addEEnumLiteral(toolTypeEEnum, ToolType.HIGHLIGHTCOLOR);

		initEEnum(fontStylesEEnum, FontStyles.class, "FontStyles");
		addEEnumLiteral(fontStylesEEnum, FontStyles.NORMAL);
		addEEnumLiteral(fontStylesEEnum, FontStyles.BOLD);
		addEEnumLiteral(fontStylesEEnum, FontStyles.ITALIC);
		addEEnumLiteral(fontStylesEEnum, FontStyles.UNDERLINE);
		addEEnumLiteral(fontStylesEEnum, FontStyles.UNDERLINE_2);

		initEEnum(toolBarReplacementPolicyEEnum, ToolBarReplacementPolicy.class, "ToolBarReplacementPolicy");
		addEEnumLiteral(toolBarReplacementPolicyEEnum, ToolBarReplacementPolicy.REPLACE_ALL);
		addEEnumLiteral(toolBarReplacementPolicyEEnum, ToolBarReplacementPolicy.ADD);
		addEEnumLiteral(toolBarReplacementPolicyEEnum, ToolBarReplacementPolicy.REPLACE_ALL_MATCHES);

		initEEnum(groupTypeEEnum, GroupType.class, "GroupType");
		addEEnumLiteral(groupTypeEEnum, GroupType.ACCORDIONITEM);
		addEEnumLiteral(groupTypeEEnum, GroupType.GRIDPANE);
		addEEnumLiteral(groupTypeEEnum, GroupType.FLOWPANE);
		addEEnumLiteral(groupTypeEEnum, GroupType.ANCHORPANE);
		addEEnumLiteral(groupTypeEEnum, GroupType.ACCORDION);
		addEEnumLiteral(groupTypeEEnum, GroupType.BORDERPANE);
		addEEnumLiteral(groupTypeEEnum, GroupType.HBOX);
		addEEnumLiteral(groupTypeEEnum, GroupType.VBOX);
		addEEnumLiteral(groupTypeEEnum, GroupType.PANE);
		addEEnumLiteral(groupTypeEEnum, GroupType.SCROLLPANE);
		addEEnumLiteral(groupTypeEEnum, GroupType.HORIZONTALSPLITPANE);
		addEEnumLiteral(groupTypeEEnum, GroupType.VERTICALSPLITPANE);
		addEEnumLiteral(groupTypeEEnum, GroupType.STACKPANE);
		addEEnumLiteral(groupTypeEEnum, GroupType.TAB);
		addEEnumLiteral(groupTypeEEnum, GroupType.TABPANE);
		addEEnumLiteral(groupTypeEEnum, GroupType.TILEPANE);
		addEEnumLiteral(groupTypeEEnum, GroupType.TITLEDPANE);
		addEEnumLiteral(groupTypeEEnum, GroupType.TOOLBAR);
		addEEnumLiteral(groupTypeEEnum, GroupType.EMPTY_GROUP_BUTTON);

		initEEnum(addressTypeEEnum, AddressType.class, "AddressType");
		addEEnumLiteral(addressTypeEEnum, AddressType.RESIDENCE);

		initEEnum(homePageTypeEEnum, HomePageType.class, "HomePageType");
		addEEnumLiteral(homePageTypeEEnum, HomePageType.WEBSITE);
		addEEnumLiteral(homePageTypeEEnum, HomePageType.PDF);
		addEEnumLiteral(homePageTypeEEnum, HomePageType.WORD);
		addEEnumLiteral(homePageTypeEEnum, HomePageType.EXCEL);
		addEEnumLiteral(homePageTypeEEnum, HomePageType.POWERPOINT);
		addEEnumLiteral(homePageTypeEEnum, HomePageType.WELCOME);
		addEEnumLiteral(homePageTypeEEnum, HomePageType.SAMPLES);
		addEEnumLiteral(homePageTypeEEnum, HomePageType.CONTACT_US);
		addEEnumLiteral(homePageTypeEEnum, HomePageType.NEWS);
		addEEnumLiteral(homePageTypeEEnum, HomePageType.OVERVIEW);
		addEEnumLiteral(homePageTypeEEnum, HomePageType.PERSPECTIVES);
		addEEnumLiteral(homePageTypeEEnum, HomePageType.PREFERENCES);
		addEEnumLiteral(homePageTypeEEnum, HomePageType.ABOUT);
		addEEnumLiteral(homePageTypeEEnum, HomePageType.CUSTOM);
		addEEnumLiteral(homePageTypeEEnum, HomePageType.NEW);
		addEEnumLiteral(homePageTypeEEnum, HomePageType.WHATS_NEW);
		addEEnumLiteral(homePageTypeEEnum, HomePageType.DOCUMENT);
		addEEnumLiteral(homePageTypeEEnum, HomePageType.HTML_EDITOR);
		addEEnumLiteral(homePageTypeEEnum, HomePageType.HOME);
		addEEnumLiteral(homePageTypeEEnum, HomePageType.TEMPLATES);
		addEEnumLiteral(homePageTypeEEnum, HomePageType.TUTORIALS);
		addEEnumLiteral(homePageTypeEEnum, HomePageType.HELP);
		addEEnumLiteral(homePageTypeEEnum, HomePageType.DONATIONS);
		addEEnumLiteral(homePageTypeEEnum, HomePageType.TOOLS_EDITOR);

		initEEnum(documentTypeEEnum, DocumentType.class, "DocumentType");
		addEEnumLiteral(documentTypeEEnum, DocumentType.WORD);
		addEEnumLiteral(documentTypeEEnum, DocumentType.EXCEL);
		addEEnumLiteral(documentTypeEEnum, DocumentType.POWERPOINT);
		addEEnumLiteral(documentTypeEEnum, DocumentType.HTML);
		addEEnumLiteral(documentTypeEEnum, DocumentType.PDF);
		addEEnumLiteral(documentTypeEEnum, DocumentType.IMAGE);
		addEEnumLiteral(documentTypeEEnum, DocumentType.TEXT);

		// Create resource
		createResource(eNS_URI);
	}

} // RcplPackageImpl
