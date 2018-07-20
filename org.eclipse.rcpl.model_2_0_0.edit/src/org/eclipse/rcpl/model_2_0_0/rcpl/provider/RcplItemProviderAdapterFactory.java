/**
 */
package org.eclipse.rcpl.model_2_0_0.rcpl.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import org.eclipse.rcpl.model_2_0_0.rcpl.util.RcplAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class RcplItemProviderAdapterFactory extends RcplAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RcplItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.rcpl.model_2_0_0.rcpl.RCPL} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RCPLItemProvider rcplItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.rcpl.model_2_0_0.rcpl.RCPL}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRCPLAdapter() {
		if (rcplItemProvider == null) {
			rcplItemProvider = new RCPLItemProvider(this);
		}

		return rcplItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.rcpl.model_2_0_0.rcpl.Perspectives} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PerspectivesItemProvider perspectivesItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.rcpl.model_2_0_0.rcpl.Perspectives}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPerspectivesAdapter() {
		if (perspectivesItemProvider == null) {
			perspectivesItemProvider = new PerspectivesItemProvider(this);
		}

		return perspectivesItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.rcpl.model_2_0_0.rcpl.Perspective} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PerspectiveItemProvider perspectiveItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.rcpl.model_2_0_0.rcpl.Perspective}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPerspectiveAdapter() {
		if (perspectiveItemProvider == null) {
			perspectiveItemProvider = new PerspectiveItemProvider(this);
		}

		return perspectiveItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.rcpl.model_2_0_0.rcpl.Preference} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PreferenceItemProvider preferenceItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.rcpl.model_2_0_0.rcpl.Preference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPreferenceAdapter() {
		if (preferenceItemProvider == null) {
			preferenceItemProvider = new PreferenceItemProvider(this);
		}

		return preferenceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.rcpl.model_2_0_0.rcpl.Logins} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LoginsItemProvider loginsItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.rcpl.model_2_0_0.rcpl.Logins}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLoginsAdapter() {
		if (loginsItemProvider == null) {
			loginsItemProvider = new LoginsItemProvider(this);
		}

		return loginsItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.rcpl.model_2_0_0.rcpl.Login} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LoginItemProvider loginItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.rcpl.model_2_0_0.rcpl.Login}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLoginAdapter() {
		if (loginItemProvider == null) {
			loginItemProvider = new LoginItemProvider(this);
		}

		return loginItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.rcpl.model_2_0_0.rcpl.Favorites} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FavoritesItemProvider favoritesItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.rcpl.model_2_0_0.rcpl.Favorites}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFavoritesAdapter() {
		if (favoritesItemProvider == null) {
			favoritesItemProvider = new FavoritesItemProvider(this);
		}

		return favoritesItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.rcpl.model_2_0_0.rcpl.Favorite} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FavoriteItemProvider favoriteItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.rcpl.model_2_0_0.rcpl.Favorite}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFavoriteAdapter() {
		if (favoriteItemProvider == null) {
			favoriteItemProvider = new FavoriteItemProvider(this);
		}

		return favoriteItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.rcpl.model_2_0_0.rcpl.FavoritesGroup} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FavoritesGroupItemProvider favoritesGroupItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.rcpl.model_2_0_0.rcpl.FavoritesGroup}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFavoritesGroupAdapter() {
		if (favoritesGroupItemProvider == null) {
			favoritesGroupItemProvider = new FavoritesGroupItemProvider(this);
		}

		return favoritesGroupItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.rcpl.model_2_0_0.rcpl.Preferences} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PreferencesItemProvider preferencesItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.rcpl.model_2_0_0.rcpl.Preferences}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPreferencesAdapter() {
		if (preferencesItemProvider == null) {
			preferencesItemProvider = new PreferencesItemProvider(this);
		}

		return preferencesItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.rcpl.model_2_0_0.rcpl.Addons} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AddonsItemProvider addonsItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.rcpl.model_2_0_0.rcpl.Addons}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAddonsAdapter() {
		if (addonsItemProvider == null) {
			addonsItemProvider = new AddonsItemProvider(this);
		}

		return addonsItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.rcpl.model_2_0_0.rcpl.Addon} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AddonItemProvider addonItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.rcpl.model_2_0_0.rcpl.Addon}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAddonAdapter() {
		if (addonItemProvider == null) {
			addonItemProvider = new AddonItemProvider(this);
		}

		return addonItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.rcpl.model_2_0_0.rcpl.Tool} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ToolItemProvider toolItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.rcpl.model_2_0_0.rcpl.Tool}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createToolAdapter() {
		if (toolItemProvider == null) {
			toolItemProvider = new ToolItemProvider(this);
		}

		return toolItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.rcpl.model_2_0_0.rcpl.ToolGroup} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ToolGroupItemProvider toolGroupItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.rcpl.model_2_0_0.rcpl.ToolGroup}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createToolGroupAdapter() {
		if (toolGroupItemProvider == null) {
			toolGroupItemProvider = new ToolGroupItemProvider(this);
		}

		return toolGroupItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.rcpl.model_2_0_0.rcpl.Tools} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ToolsItemProvider toolsItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.rcpl.model_2_0_0.rcpl.Tools}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createToolsAdapter() {
		if (toolsItemProvider == null) {
			toolsItemProvider = new ToolsItemProvider(this);
		}

		return toolsItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.rcpl.model_2_0_0.rcpl.RibbonToolBar} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RibbonToolBarItemProvider ribbonToolBarItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.rcpl.model_2_0_0.rcpl.RibbonToolBar}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRibbonToolBarAdapter() {
		if (ribbonToolBarItemProvider == null) {
			ribbonToolBarItemProvider = new RibbonToolBarItemProvider(this);
		}

		return ribbonToolBarItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.rcpl.model_2_0_0.rcpl.TopToolBar} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TopToolBarItemProvider topToolBarItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.rcpl.model_2_0_0.rcpl.TopToolBar}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTopToolBarAdapter() {
		if (topToolBarItemProvider == null) {
			topToolBarItemProvider = new TopToolBarItemProvider(this);
		}

		return topToolBarItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.rcpl.model_2_0_0.rcpl.SideToolBar} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SideToolBarItemProvider sideToolBarItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.rcpl.model_2_0_0.rcpl.SideToolBar}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSideToolBarAdapter() {
		if (sideToolBarItemProvider == null) {
			sideToolBarItemProvider = new SideToolBarItemProvider(this);
		}

		return sideToolBarItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.rcpl.model_2_0_0.rcpl.QuickToolBar} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QuickToolBarItemProvider quickToolBarItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.rcpl.model_2_0_0.rcpl.QuickToolBar}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createQuickToolBarAdapter() {
		if (quickToolBarItemProvider == null) {
			quickToolBarItemProvider = new QuickToolBarItemProvider(this);
		}

		return quickToolBarItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.rcpl.model_2_0_0.rcpl.Folder} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FolderItemProvider folderItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.rcpl.model_2_0_0.rcpl.Folder}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFolderAdapter() {
		if (folderItemProvider == null) {
			folderItemProvider = new FolderItemProvider(this);
		}

		return folderItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.rcpl.model_2_0_0.rcpl.Resource} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceItemProvider resourceItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.rcpl.model_2_0_0.rcpl.Resource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createResourceAdapter() {
		if (resourceItemProvider == null) {
			resourceItemProvider = new ResourceItemProvider(this);
		}

		return resourceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.rcpl.model_2_0_0.rcpl.Person} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PersonItemProvider personItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.rcpl.model_2_0_0.rcpl.Person}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPersonAdapter() {
		if (personItemProvider == null) {
			personItemProvider = new PersonItemProvider(this);
		}

		return personItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.rcpl.model_2_0_0.rcpl.PersonGroup} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PersonGroupItemProvider personGroupItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.rcpl.model_2_0_0.rcpl.PersonGroup}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPersonGroupAdapter() {
		if (personGroupItemProvider == null) {
			personGroupItemProvider = new PersonGroupItemProvider(this);
		}

		return personGroupItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.rcpl.model_2_0_0.rcpl.Resources} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourcesItemProvider resourcesItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.rcpl.model_2_0_0.rcpl.Resources}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createResourcesAdapter() {
		if (resourcesItemProvider == null) {
			resourcesItemProvider = new ResourcesItemProvider(this);
		}

		return resourcesItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.rcpl.model_2_0_0.rcpl.PreferenceGroup} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PreferenceGroupItemProvider preferenceGroupItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.rcpl.model_2_0_0.rcpl.PreferenceGroup}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPreferenceGroupAdapter() {
		if (preferenceGroupItemProvider == null) {
			preferenceGroupItemProvider = new PreferenceGroupItemProvider(this);
		}

		return preferenceGroupItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.rcpl.model_2_0_0.rcpl.Persons} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PersonsItemProvider personsItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.rcpl.model_2_0_0.rcpl.Persons}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPersonsAdapter() {
		if (personsItemProvider == null) {
			personsItemProvider = new PersonsItemProvider(this);
		}

		return personsItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.rcpl.model_2_0_0.rcpl.RCPLTemplates} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RCPLTemplatesItemProvider rcplTemplatesItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.rcpl.model_2_0_0.rcpl.RCPLTemplates}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRCPLTemplatesAdapter() {
		if (rcplTemplatesItemProvider == null) {
			rcplTemplatesItemProvider = new RCPLTemplatesItemProvider(this);
		}

		return rcplTemplatesItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.rcpl.model_2_0_0.rcpl.JPerson} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JPersonItemProvider jPersonItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.rcpl.model_2_0_0.rcpl.JPerson}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createJPersonAdapter() {
		if (jPersonItemProvider == null) {
			jPersonItemProvider = new JPersonItemProvider(this);
		}

		return jPersonItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.rcpl.model_2_0_0.rcpl.NPerson} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NPersonItemProvider nPersonItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.rcpl.model_2_0_0.rcpl.NPerson}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createNPersonAdapter() {
		if (nPersonItemProvider == null) {
			nPersonItemProvider = new NPersonItemProvider(this);
		}

		return nPersonItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.rcpl.model_2_0_0.rcpl.Address} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AddressItemProvider addressItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.rcpl.model_2_0_0.rcpl.Address}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAddressAdapter() {
		if (addressItemProvider == null) {
			addressItemProvider = new AddressItemProvider(this);
		}

		return addressItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.rcpl.model_2_0_0.rcpl.Country} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CountryItemProvider countryItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.rcpl.model_2_0_0.rcpl.Country}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCountryAdapter() {
		if (countryItemProvider == null) {
			countryItemProvider = new CountryItemProvider(this);
		}

		return countryItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.rcpl.model_2_0_0.rcpl.City} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CityItemProvider cityItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.rcpl.model_2_0_0.rcpl.City}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCityAdapter() {
		if (cityItemProvider == null) {
			cityItemProvider = new CityItemProvider(this);
		}

		return cityItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.rcpl.model_2_0_0.rcpl.Geo} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GeoItemProvider geoItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.rcpl.model_2_0_0.rcpl.Geo}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createGeoAdapter() {
		if (geoItemProvider == null) {
			geoItemProvider = new GeoItemProvider(this);
		}

		return geoItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.rcpl.model_2_0_0.rcpl.WorldRegion} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WorldRegionItemProvider worldRegionItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.rcpl.model_2_0_0.rcpl.WorldRegion}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createWorldRegionAdapter() {
		if (worldRegionItemProvider == null) {
			worldRegionItemProvider = new WorldRegionItemProvider(this);
		}

		return worldRegionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.rcpl.model_2_0_0.rcpl.Street} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StreetItemProvider streetItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.rcpl.model_2_0_0.rcpl.Street}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createStreetAdapter() {
		if (streetItemProvider == null) {
			streetItemProvider = new StreetItemProvider(this);
		}

		return streetItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.rcpl.model_2_0_0.rcpl.HouseNumber} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HouseNumberItemProvider houseNumberItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.rcpl.model_2_0_0.rcpl.HouseNumber}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createHouseNumberAdapter() {
		if (houseNumberItemProvider == null) {
			houseNumberItemProvider = new HouseNumberItemProvider(this);
		}

		return houseNumberItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.rcpl.model_2_0_0.rcpl.Building} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BuildingItemProvider buildingItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.rcpl.model_2_0_0.rcpl.Building}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBuildingAdapter() {
		if (buildingItemProvider == null) {
			buildingItemProvider = new BuildingItemProvider(this);
		}

		return buildingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.rcpl.model_2_0_0.rcpl.Contact} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContactItemProvider contactItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.rcpl.model_2_0_0.rcpl.Contact}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createContactAdapter() {
		if (contactItemProvider == null) {
			contactItemProvider = new ContactItemProvider(this);
		}

		return contactItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.rcpl.model_2_0_0.rcpl.Phone} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PhoneItemProvider phoneItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.rcpl.model_2_0_0.rcpl.Phone}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPhoneAdapter() {
		if (phoneItemProvider == null) {
			phoneItemProvider = new PhoneItemProvider(this);
		}

		return phoneItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.rcpl.model_2_0_0.rcpl.Domains} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DomainsItemProvider domainsItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.rcpl.model_2_0_0.rcpl.Domains}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDomainsAdapter() {
		if (domainsItemProvider == null) {
			domainsItemProvider = new DomainsItemProvider(this);
		}

		return domainsItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.rcpl.model_2_0_0.rcpl.Domain} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DomainItemProvider domainItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.rcpl.model_2_0_0.rcpl.Domain}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDomainAdapter() {
		if (domainItemProvider == null) {
			domainItemProvider = new DomainItemProvider(this);
		}

		return domainItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.rcpl.model_2_0_0.rcpl.HomePages} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HomePagesItemProvider homePagesItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.rcpl.model_2_0_0.rcpl.HomePages}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createHomePagesAdapter() {
		if (homePagesItemProvider == null) {
			homePagesItemProvider = new HomePagesItemProvider(this);
		}

		return homePagesItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.rcpl.model_2_0_0.rcpl.HomePage} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HomePageItemProvider homePageItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.rcpl.model_2_0_0.rcpl.HomePage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createHomePageAdapter() {
		if (homePageItemProvider == null) {
			homePageItemProvider = new HomePageItemProvider(this);
		}

		return homePageItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (rcplItemProvider != null) rcplItemProvider.dispose();
		if (perspectivesItemProvider != null) perspectivesItemProvider.dispose();
		if (perspectiveItemProvider != null) perspectiveItemProvider.dispose();
		if (preferenceItemProvider != null) preferenceItemProvider.dispose();
		if (loginsItemProvider != null) loginsItemProvider.dispose();
		if (loginItemProvider != null) loginItemProvider.dispose();
		if (favoritesItemProvider != null) favoritesItemProvider.dispose();
		if (favoriteItemProvider != null) favoriteItemProvider.dispose();
		if (favoritesGroupItemProvider != null) favoritesGroupItemProvider.dispose();
		if (preferencesItemProvider != null) preferencesItemProvider.dispose();
		if (addonsItemProvider != null) addonsItemProvider.dispose();
		if (addonItemProvider != null) addonItemProvider.dispose();
		if (toolItemProvider != null) toolItemProvider.dispose();
		if (toolGroupItemProvider != null) toolGroupItemProvider.dispose();
		if (toolsItemProvider != null) toolsItemProvider.dispose();
		if (ribbonToolBarItemProvider != null) ribbonToolBarItemProvider.dispose();
		if (topToolBarItemProvider != null) topToolBarItemProvider.dispose();
		if (sideToolBarItemProvider != null) sideToolBarItemProvider.dispose();
		if (quickToolBarItemProvider != null) quickToolBarItemProvider.dispose();
		if (folderItemProvider != null) folderItemProvider.dispose();
		if (resourceItemProvider != null) resourceItemProvider.dispose();
		if (personItemProvider != null) personItemProvider.dispose();
		if (personGroupItemProvider != null) personGroupItemProvider.dispose();
		if (resourcesItemProvider != null) resourcesItemProvider.dispose();
		if (preferenceGroupItemProvider != null) preferenceGroupItemProvider.dispose();
		if (personsItemProvider != null) personsItemProvider.dispose();
		if (rcplTemplatesItemProvider != null) rcplTemplatesItemProvider.dispose();
		if (jPersonItemProvider != null) jPersonItemProvider.dispose();
		if (nPersonItemProvider != null) nPersonItemProvider.dispose();
		if (addressItemProvider != null) addressItemProvider.dispose();
		if (countryItemProvider != null) countryItemProvider.dispose();
		if (cityItemProvider != null) cityItemProvider.dispose();
		if (geoItemProvider != null) geoItemProvider.dispose();
		if (worldRegionItemProvider != null) worldRegionItemProvider.dispose();
		if (streetItemProvider != null) streetItemProvider.dispose();
		if (houseNumberItemProvider != null) houseNumberItemProvider.dispose();
		if (buildingItemProvider != null) buildingItemProvider.dispose();
		if (contactItemProvider != null) contactItemProvider.dispose();
		if (phoneItemProvider != null) phoneItemProvider.dispose();
		if (domainsItemProvider != null) domainsItemProvider.dispose();
		if (domainItemProvider != null) domainItemProvider.dispose();
		if (homePagesItemProvider != null) homePagesItemProvider.dispose();
		if (homePageItemProvider != null) homePageItemProvider.dispose();
	}

}
