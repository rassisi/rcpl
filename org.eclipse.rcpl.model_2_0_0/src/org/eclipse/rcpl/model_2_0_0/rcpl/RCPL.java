/**
 */
package org.eclipse.rcpl.model_2_0_0.rcpl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object
 * '<em><b>RCPL</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.RCPL#getAllAddons <em>All Addons</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.RCPL#getAllPerspectives <em>All Perspectives</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.RCPL#getPreferences <em>Preferences</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.RCPL#getAllTools <em>All Tools</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.RCPL#getAllFavorites <em>All Favorites</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.RCPL#getVersionMajor <em>Version Major</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.RCPL#getVersionMinor <em>Version Minor</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.RCPL#getVersionMaintenance <em>Version Maintenance</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.RCPL#getBuildNumber <em>Build Number</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.RCPL#getVersionDescription <em>Version Description</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.RCPL#getAllResources <em>All Resources</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.RCPL#getAllPersons <em>All Persons</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.RCPL#getLinkedRcpls <em>Linked Rcpls</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.RCPL#getHomepages <em>Homepages</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.RCPL#getDocuments <em>Documents</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.RCPL#getKeyvalues <em>Keyvalues</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.RCPL#getImageUrls <em>Image Urls</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.RCPL#getServiceClasses <em>Service Classes</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.RCPL#getHomeURL <em>Home URL</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.RCPL#getCommands <em>Commands</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.RCPL#getServices <em>Services</em>}</li>
 *   <li>{@link org.eclipse.rcpl.model_2_0_0.rcpl.RCPL#getNavigators <em>Navigators</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getRCPL()
 * @model
 * @generated
 */
public interface RCPL extends Layoutable {

	/**
	 * Returns the value of the '<em><b>All Addons</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Addons</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Addons</em>' containment reference.
	 * @see #setAllAddons(Addons)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getRCPL_AllAddons()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Addons getAllAddons();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.RCPL#getAllAddons <em>All Addons</em>}' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>All Addons</em>' containment reference.
	 * @see #getAllAddons()
	 * @generated
	 */
	void setAllAddons(Addons value);

	/**
	 * Returns the value of the '<em><b>All Perspectives</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Perspectives</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Perspectives</em>' containment reference.
	 * @see #setAllPerspectives(Perspectives)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getRCPL_AllPerspectives()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Perspectives getAllPerspectives();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.RCPL#getAllPerspectives <em>All Perspectives</em>}' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>All Perspectives</em>' containment reference.
	 * @see #getAllPerspectives()
	 * @generated
	 */
	void setAllPerspectives(Perspectives value);

	/**
	 * Returns the value of the '<em><b>Preferences</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Preferences</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Preferences</em>' containment reference.
	 * @see #setPreferences(Preferences)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getRCPL_Preferences()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Preferences getPreferences();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.RCPL#getPreferences <em>Preferences</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Preferences</em>' containment reference.
	 * @see #getPreferences()
	 * @generated
	 */
	void setPreferences(Preferences value);

	/**
	 * Returns the value of the '<em><b>All Tools</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Tools</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Tools</em>' containment reference.
	 * @see #setAllTools(Tools)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getRCPL_AllTools()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Tools getAllTools();

	/**
	 * Sets the value of the
	 * '{@link org.eclipse.rcpl.model_2_0_0.rcpl.RCPL#getAllTools <em>All
	 * Tools</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value the new value of the '<em>All Tools</em>' containment reference.
	 * @see #getAllTools()
	 * @generated
	 */
	void setAllTools(Tools value);

	/**
	 * Returns the value of the '<em><b>All Favorites</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Favorites</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Favorites</em>' containment reference.
	 * @see #setAllFavorites(Favorites)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getRCPL_AllFavorites()
	 * @model containment="true"
	 * @generated
	 */
	Favorites getAllFavorites();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.RCPL#getAllFavorites <em>All Favorites</em>}' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>All Favorites</em>' containment reference.
	 * @see #getAllFavorites()
	 * @generated
	 */
	void setAllFavorites(Favorites value);

	/**
	 * Returns the value of the '<em><b>Version Major</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version Major</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Version Major</em>' attribute.
	 * @see #setVersionMajor(int)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getRCPL_VersionMajor()
	 * @model
	 * @generated
	 */
	int getVersionMajor();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.RCPL#getVersionMajor <em>Version Major</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version Major</em>' attribute.
	 * @see #getVersionMajor()
	 * @generated
	 */
	void setVersionMajor(int value);

	/**
	 * Returns the value of the '<em><b>Version Minor</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version Minor</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Version Minor</em>' attribute.
	 * @see #setVersionMinor(int)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getRCPL_VersionMinor()
	 * @model
	 * @generated
	 */
	int getVersionMinor();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.RCPL#getVersionMinor <em>Version Minor</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version Minor</em>' attribute.
	 * @see #getVersionMinor()
	 * @generated
	 */
	void setVersionMinor(int value);

	/**
	 * Returns the value of the '<em><b>Version Maintenance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version Maintenance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version Maintenance</em>' attribute.
	 * @see #setVersionMaintenance(int)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getRCPL_VersionMaintenance()
	 * @model
	 * @generated
	 */
	int getVersionMaintenance();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.RCPL#getVersionMaintenance <em>Version Maintenance</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Version Maintenance</em>' attribute.
	 * @see #getVersionMaintenance()
	 * @generated
	 */
	void setVersionMaintenance(int value);

	/**
	 * Returns the value of the '<em><b>Build Number</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Build Number</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Build Number</em>' attribute.
	 * @see #setBuildNumber(String)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getRCPL_BuildNumber()
	 * @model
	 * @generated
	 */
	String getBuildNumber();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.RCPL#getBuildNumber <em>Build Number</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Build Number</em>' attribute.
	 * @see #getBuildNumber()
	 * @generated
	 */
	void setBuildNumber(String value);

	/**
	 * Returns the value of the '<em><b>Version Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version Description</em>' attribute.
	 * @see #setVersionDescription(String)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getRCPL_VersionDescription()
	 * @model
	 * @generated
	 */
	String getVersionDescription();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.RCPL#getVersionDescription <em>Version Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Version Description</em>' attribute.
	 * @see #getVersionDescription()
	 * @generated
	 */
	void setVersionDescription(String value);

	/**
	 * Returns the value of the '<em><b>All Resources</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Resources</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Resources</em>' containment reference.
	 * @see #setAllResources(Resources)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getRCPL_AllResources()
	 * @model containment="true"
	 * @generated
	 */
	Resources getAllResources();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.RCPL#getAllResources <em>All Resources</em>}' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>All Resources</em>' containment reference.
	 * @see #getAllResources()
	 * @generated
	 */
	void setAllResources(Resources value);

	/**
	 * Returns the value of the '<em><b>All Persons</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Persons</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Persons</em>' containment reference.
	 * @see #setAllPersons(Persons)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getRCPL_AllPersons()
	 * @model containment="true"
	 * @generated
	 */
	Persons getAllPersons();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.RCPL#getAllPersons <em>All Persons</em>}' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>All Persons</em>' containment reference.
	 * @see #getAllPersons()
	 * @generated
	 */
	void setAllPersons(Persons value);

	/**
	 * Returns the value of the '<em><b>Linked Rcpls</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.rcpl.model_2_0_0.rcpl.RCPL}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linked Rcpls</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linked Rcpls</em>' reference list.
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getRCPL_LinkedRcpls()
	 * @model
	 * @generated
	 */
	EList<RCPL> getLinkedRcpls();

	/**
	 * Returns the value of the '<em><b>Homepages</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Homepages</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Homepages</em>' containment reference.
	 * @see #setHomepages(HomePages)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getRCPL_Homepages()
	 * @model containment="true" required="true"
	 * @generated
	 */
	HomePages getHomepages();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.RCPL#getHomepages <em>Homepages</em>}' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Homepages</em>' containment reference.
	 * @see #getHomepages()
	 * @generated
	 */
	void setHomepages(HomePages value);

	/**
	 * Returns the value of the '<em><b>Documents</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Documents</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Documents</em>' containment reference.
	 * @see #setDocuments(Documents)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getRCPL_Documents()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Documents getDocuments();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.RCPL#getDocuments <em>Documents</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Documents</em>' containment reference.
	 * @see #getDocuments()
	 * @generated
	 */
	void setDocuments(Documents value);

	/**
	 * Returns the value of the '<em><b>Keyvalues</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Keyvalues</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Keyvalues</em>' containment reference.
	 * @see #setKeyvalues(KeyValues)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getRCPL_Keyvalues()
	 * @model containment="true"
	 * @generated
	 */
	KeyValues getKeyvalues();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.RCPL#getKeyvalues <em>Keyvalues</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Keyvalues</em>' containment reference.
	 * @see #getKeyvalues()
	 * @generated
	 */
	void setKeyvalues(KeyValues value);

	/**
	 * Returns the value of the '<em><b>Image Urls</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Image Urls</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image Urls</em>' attribute list.
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getRCPL_ImageUrls()
	 * @model
	 * @generated
	 */
	EList<String> getImageUrls();

	/**
	 * Returns the value of the '<em><b>Service Classes</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Classes</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Classes</em>' attribute list.
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getRCPL_ServiceClasses()
	 * @model
	 * @generated
	 */
	EList<String> getServiceClasses();

	/**
	 * Returns the value of the '<em><b>Home URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Home URL</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Home URL</em>' attribute.
	 * @see #setHomeURL(String)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getRCPL_HomeURL()
	 * @model
	 * @generated
	 */
	String getHomeURL();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.RCPL#getHomeURL <em>Home URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Home URL</em>' attribute.
	 * @see #getHomeURL()
	 * @generated
	 */
	void setHomeURL(String value);

	/**
	 * Returns the value of the '<em><b>Commands</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Commands</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Commands</em>' containment reference.
	 * @see #setCommands(Commands)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getRCPL_Commands()
	 * @model containment="true"
	 * @generated
	 */
	Commands getCommands();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.RCPL#getCommands <em>Commands</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Commands</em>' containment reference.
	 * @see #getCommands()
	 * @generated
	 */
	void setCommands(Commands value);

	/**
	 * Returns the value of the '<em><b>Services</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Services</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Services</em>' containment reference.
	 * @see #setServices(Services)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getRCPL_Services()
	 * @model containment="true"
	 * @generated
	 */
	Services getServices();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.RCPL#getServices <em>Services</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Services</em>' containment reference.
	 * @see #getServices()
	 * @generated
	 */
	void setServices(Services value);

	/**
	 * Returns the value of the '<em><b>Navigators</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Navigators</em>' containment reference.
	 * @see #setNavigators(Navigators)
	 * @see org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage#getRCPL_Navigators()
	 * @model containment="true"
	 * @generated
	 */
	Navigators getNavigators();

	/**
	 * Sets the value of the '{@link org.eclipse.rcpl.model_2_0_0.rcpl.RCPL#getNavigators <em>Navigators</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Navigators</em>' containment reference.
	 * @see #getNavigators()
	 * @generated
	 */
	void setNavigators(Navigators value);

} // RCPL
