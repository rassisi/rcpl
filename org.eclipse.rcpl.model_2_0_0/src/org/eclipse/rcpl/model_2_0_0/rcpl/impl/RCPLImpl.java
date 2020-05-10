/**
 */
package org.eclipse.rcpl.model_2_0_0.rcpl.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.rcpl.model_2_0_0.rcpl.Addons;
import org.eclipse.rcpl.model_2_0_0.rcpl.Commands;
import org.eclipse.rcpl.model_2_0_0.rcpl.Documents;
import org.eclipse.rcpl.model_2_0_0.rcpl.Favorites;
import org.eclipse.rcpl.model_2_0_0.rcpl.HomePages;
import org.eclipse.rcpl.model_2_0_0.rcpl.KeyValues;
import org.eclipse.rcpl.model_2_0_0.rcpl.Navigators;
import org.eclipse.rcpl.model_2_0_0.rcpl.Persons;
import org.eclipse.rcpl.model_2_0_0.rcpl.Perspectives;
import org.eclipse.rcpl.model_2_0_0.rcpl.Preferences;
import org.eclipse.rcpl.model_2_0_0.rcpl.RCPL;
import org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage;
import org.eclipse.rcpl.model_2_0_0.rcpl.Resources;
import org.eclipse.rcpl.model_2_0_0.rcpl.Services;
import org.eclipse.rcpl.model_2_0_0.rcpl.Tools;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>RCPL</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.RCPLImpl#getAllAddons <em>All Addons</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.RCPLImpl#getAllPerspectives <em>All Perspectives</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.RCPLImpl#getPreferences <em>Preferences</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.RCPLImpl#getAllTools <em>All Tools</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.RCPLImpl#getAllFavorites <em>All Favorites</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.RCPLImpl#getVersionMajor <em>Version Major</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.RCPLImpl#getVersionMinor <em>Version Minor</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.RCPLImpl#getVersionMaintenance <em>Version Maintenance</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.RCPLImpl#getBuildNumber <em>Build Number</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.RCPLImpl#getVersionDescription <em>Version Description</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.RCPLImpl#getAllResources <em>All Resources</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.RCPLImpl#getAllPersons <em>All Persons</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.RCPLImpl#getLinkedRcpls <em>Linked Rcpls</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.RCPLImpl#getHomepages <em>Homepages</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.RCPLImpl#getDocuments <em>Documents</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.RCPLImpl#getKeyvalues <em>Keyvalues</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.RCPLImpl#getImageUrls <em>Image Urls</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.RCPLImpl#getServiceClasses <em>Service Classes</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.RCPLImpl#getHomeURL <em>Home URL</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.RCPLImpl#getCommands <em>Commands</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.RCPLImpl#getServices <em>Services</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.impl.RCPLImpl#getNavigators <em>Navigators</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RCPLImpl extends LayoutableImpl implements RCPL {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RCPLImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RcplPackage.Literals.RCPL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Addons getAllAddons() {
		return (Addons)eGet(RcplPackage.Literals.RCPL__ALL_ADDONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAllAddons(Addons newAllAddons) {
		eSet(RcplPackage.Literals.RCPL__ALL_ADDONS, newAllAddons);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Perspectives getAllPerspectives() {
		return (Perspectives)eGet(RcplPackage.Literals.RCPL__ALL_PERSPECTIVES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAllPerspectives(Perspectives newAllPerspectives) {
		eSet(RcplPackage.Literals.RCPL__ALL_PERSPECTIVES, newAllPerspectives);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Preferences getPreferences() {
		return (Preferences)eGet(RcplPackage.Literals.RCPL__PREFERENCES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPreferences(Preferences newPreferences) {
		eSet(RcplPackage.Literals.RCPL__PREFERENCES, newPreferences);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Tools getAllTools() {
		return (Tools)eGet(RcplPackage.Literals.RCPL__ALL_TOOLS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAllTools(Tools newAllTools) {
		eSet(RcplPackage.Literals.RCPL__ALL_TOOLS, newAllTools);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Favorites getAllFavorites() {
		return (Favorites)eGet(RcplPackage.Literals.RCPL__ALL_FAVORITES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAllFavorites(Favorites newAllFavorites) {
		eSet(RcplPackage.Literals.RCPL__ALL_FAVORITES, newAllFavorites);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getVersionMajor() {
		return (Integer)eGet(RcplPackage.Literals.RCPL__VERSION_MAJOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVersionMajor(int newVersionMajor) {
		eSet(RcplPackage.Literals.RCPL__VERSION_MAJOR, newVersionMajor);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getVersionMinor() {
		return (Integer)eGet(RcplPackage.Literals.RCPL__VERSION_MINOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVersionMinor(int newVersionMinor) {
		eSet(RcplPackage.Literals.RCPL__VERSION_MINOR, newVersionMinor);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getVersionMaintenance() {
		return (Integer)eGet(RcplPackage.Literals.RCPL__VERSION_MAINTENANCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVersionMaintenance(int newVersionMaintenance) {
		eSet(RcplPackage.Literals.RCPL__VERSION_MAINTENANCE, newVersionMaintenance);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getBuildNumber() {
		return (String)eGet(RcplPackage.Literals.RCPL__BUILD_NUMBER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBuildNumber(String newBuildNumber) {
		eSet(RcplPackage.Literals.RCPL__BUILD_NUMBER, newBuildNumber);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getVersionDescription() {
		return (String)eGet(RcplPackage.Literals.RCPL__VERSION_DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVersionDescription(String newVersionDescription) {
		eSet(RcplPackage.Literals.RCPL__VERSION_DESCRIPTION, newVersionDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Resources getAllResources() {
		return (Resources)eGet(RcplPackage.Literals.RCPL__ALL_RESOURCES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAllResources(Resources newAllResources) {
		eSet(RcplPackage.Literals.RCPL__ALL_RESOURCES, newAllResources);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Persons getAllPersons() {
		return (Persons)eGet(RcplPackage.Literals.RCPL__ALL_PERSONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAllPersons(Persons newAllPersons) {
		eSet(RcplPackage.Literals.RCPL__ALL_PERSONS, newAllPersons);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<RCPL> getLinkedRcpls() {
		return (EList<RCPL>)eGet(RcplPackage.Literals.RCPL__LINKED_RCPLS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public HomePages getHomepages() {
		return (HomePages)eGet(RcplPackage.Literals.RCPL__HOMEPAGES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHomepages(HomePages newHomepages) {
		eSet(RcplPackage.Literals.RCPL__HOMEPAGES, newHomepages);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Documents getDocuments() {
		return (Documents)eGet(RcplPackage.Literals.RCPL__DOCUMENTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDocuments(Documents newDocuments) {
		eSet(RcplPackage.Literals.RCPL__DOCUMENTS, newDocuments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public KeyValues getKeyvalues() {
		return (KeyValues)eGet(RcplPackage.Literals.RCPL__KEYVALUES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setKeyvalues(KeyValues newKeyvalues) {
		eSet(RcplPackage.Literals.RCPL__KEYVALUES, newKeyvalues);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<String> getImageUrls() {
		return (EList<String>)eGet(RcplPackage.Literals.RCPL__IMAGE_URLS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<String> getServiceClasses() {
		return (EList<String>)eGet(RcplPackage.Literals.RCPL__SERVICE_CLASSES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getHomeURL() {
		return (String)eGet(RcplPackage.Literals.RCPL__HOME_URL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHomeURL(String newHomeURL) {
		eSet(RcplPackage.Literals.RCPL__HOME_URL, newHomeURL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Commands getCommands() {
		return (Commands)eGet(RcplPackage.Literals.RCPL__COMMANDS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCommands(Commands newCommands) {
		eSet(RcplPackage.Literals.RCPL__COMMANDS, newCommands);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Services getServices() {
		return (Services)eGet(RcplPackage.Literals.RCPL__SERVICES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setServices(Services newServices) {
		eSet(RcplPackage.Literals.RCPL__SERVICES, newServices);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Navigators getNavigators() {
		return (Navigators)eGet(RcplPackage.Literals.RCPL__NAVIGATORS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNavigators(Navigators newNavigators) {
		eSet(RcplPackage.Literals.RCPL__NAVIGATORS, newNavigators);
	}

} //RCPLImpl
