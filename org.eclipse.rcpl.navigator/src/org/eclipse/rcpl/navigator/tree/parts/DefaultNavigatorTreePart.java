/*******************************************************************************
 * Copyright (c) 2003 - 2014 Ramin Assisi and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     Ramin Assisi - initial implementation
 *******************************************************************************/

package org.eclipse.rcpl.navigator.tree.parts;

import java.io.File;
import java.net.URL;
import java.util.HashMap;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.fx.emf.edit.ui.AdapterFactoryTreeCellFactory;
import org.eclipse.fx.emf.edit.ui.AdapterFactoryTreeItem;
import org.eclipse.fx.emf.edit.ui.EAttributeCellEditHandler;
import org.eclipse.fx.emf.edit.ui.dnd.CellDragAdapter;
import org.eclipse.net4j.util.event.IEvent;
import org.eclipse.net4j.util.event.IListener;
import org.eclipse.net4j.util.lifecycle.LifecycleException;
import org.eclipse.rcpl.IHomePage;
import org.eclipse.rcpl.INavigatorListener;
import org.eclipse.rcpl.INavigatorTreeManager;
import org.eclipse.rcpl.IOfficeUIC;
import org.eclipse.rcpl.IResourceEntry;
import org.eclipse.rcpl.IToolComponent;
import org.eclipse.rcpl.IToolGroup;
import org.eclipse.rcpl.IToolRegistry;
import org.eclipse.rcpl.ITreePart;
import org.eclipse.rcpl.Rcpl;
import org.eclipse.rcpl.RcplTool;
import org.eclipse.rcpl.emf.edit.ui.dnd.EditingDomainCellDropAdapter;
import org.eclipse.rcpl.model.RCPLModel;
import org.eclipse.rcpl.model.cdo.client.RcplSession;
import org.eclipse.rcpl.model_2_0_0.rcpl.Folder;
import org.eclipse.rcpl.model_2_0_0.rcpl.HomePageType;
import org.eclipse.rcpl.model_2_0_0.rcpl.Preference;
import org.eclipse.rcpl.model_2_0_0.rcpl.Preferences;
import org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage;
import org.eclipse.rcpl.model_2_0_0.rcpl.Resource;
import org.eclipse.rcpl.model_2_0_0.rcpl.Tool;
import org.eclipse.rcpl.navigator.tree.handlers.AbstractEmfHandler;
import org.eclipse.rcpl.navigator.tree.handlers.AddOfficeFolderHandler;
import org.eclipse.rcpl.navigator.tree.handlers.AddPreferenceHandler;
import org.eclipse.rcpl.navigator.tree.handlers.AddPreferencesHandler;
import org.eclipse.rcpl.navigator.tree.handlers.DeleteOfficeDocumentHandler;
import org.eclipse.rcpl.navigator.tree.handlers.DeleteOfficeFolderHandler;
import org.eclipse.rcpl.navigator.tree.handlers.DeletePreferenceHandler;
import org.eclipse.rcpl.navigator.tree.handlers.DeletePreferencesHandler;
import org.eclipse.rcpl.navigator.tree.model.manager.UCEmfTreeModelManagerImpl;
import org.eclipse.rcpl.upload.DownloadClient;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * @author ramin
 *
 */
public class DefaultNavigatorTreePart extends RcplTool implements ITreePart {

	private TreeView<Object> treeView;

	private AdapterFactoryTreeItem<Object> adapterFactoryTreeItem2;

	private EObject selectedObject;

	private INavigatorTreeManager manager;

	private HashMap<Class<? extends EObject>, AbstractEmfHandler<?>> addHandlerRegistry = new HashMap<Class<? extends EObject>, AbstractEmfHandler<?>>();
	private HashMap<Class<? extends EObject>, AbstractEmfHandler<?>> deleteHandlerRegistry = new HashMap<Class<? extends EObject>, AbstractEmfHandler<?>>();

	private HashMap<String, File> documentRegistry = new HashMap<String, File>();

	private Pane detailPane;

	public DefaultNavigatorTreePart() {
	}

	@Override
	public void init(Pane detailPane, Tool tool, boolean showRoot) {
		this.tool = tool;
		Rcpl.getEditorListeners().add(this);

		this.detailPane = detailPane;
		try {
			registerHandlers();
			getNode();
			treeView.setPrefHeight(10);
			manager = new UCEmfTreeModelManagerImpl();
			refresh();
			treeView.setShowRoot(showRoot);
			treeView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
			addSelectionListener();
			addCDOListener();
			addMouseListener();

		} catch (Throwable ex) {
			RCPLModel.logError(ex);
		}

	}

	protected void doSelection() {
	}

	protected void defineDetailNode(EObject eObject) {
	}

	private void addSelectionListener() {
		treeView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {

			@Override
			public void changed(ObservableValue<? extends Object> arg0, Object oldItem, Object newItem) {
				if (newItem instanceof AdapterFactoryTreeItem) {
					Object value = ((AdapterFactoryTreeItem) newItem).getValue();
					if (value instanceof EObject) {
						selectedObject = (EObject) value;
						for (INavigatorListener l : Rcpl.navigatorListeners) {
							l.selected(selectedObject);
						}
					}
				}
			}

		});
	}

	private void addMouseListener() {
		treeView.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {

				if (mouseEvent.isSecondaryButtonDown() || mouseEvent.isMiddleButtonDown()) {
					return;
				}
				EObject sel = getSelectedObject();
				if (sel instanceof Resource) {

					Resource doc = (Resource) sel;
					String uri = doc.getUri();
					String id = doc.getId();
					URL url = null;
					try {
						url = new URL(doc.getUri());
					} catch (Exception e) {
						//
					}

					if (mouseEvent.getClickCount() > 1) {

						if (id != null) {
							try {
								File file = documentRegistry.get(id);
								if (file == null) {
									file = new DownloadClient().download(RcplSession.getDefault().userId, id);
									documentRegistry.put(id, file);
								}
								((IOfficeUIC) Rcpl.UIC).openDocument(file);
							} catch (Exception e) {
								RCPLModel.logError(e);
							}

						} else if (uri != null && uri.length() > 0) {
							((IOfficeUIC) Rcpl.UIC).openDocument(new File(uri));
						} else {
							if (url != null) {
								((IOfficeUIC) Rcpl.UIC).openDocument(url);
							}
						}
						mouseEvent.consume();

					}
				} else if (sel instanceof Folder) {
					defineDetailNode(sel);
				} else {
					setDetailNode((Node) null);
				}
			}
		});
	}

	/**
	 * @param node
	 */
	protected void setDetailNode(Node node) {
		try {
			IHomePage homePage = Rcpl.UIC.findHomePage(HomePageType.OVERVIEW);
			homePage.setDetailNode(node);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	/**
	 * 
	 */
	private void registerHandlers() {
		addHandlerRegistry.put(Folder.class, new AddOfficeFolderHandler(this));
		addHandlerRegistry.put(Preferences.class, new AddPreferencesHandler(this));
		addHandlerRegistry.put(Preference.class, new AddPreferenceHandler(this));
		deleteHandlerRegistry.put(Folder.class, new DeleteOfficeFolderHandler(this));
		deleteHandlerRegistry.put(Resource.class, new DeleteOfficeDocumentHandler(this));
		deleteHandlerRegistry.put(Preferences.class, new DeletePreferencesHandler(this));
		deleteHandlerRegistry.put(Preference.class, new DeletePreferenceHandler(this));
	}

	/**
	 * @return
	 */
	public AbstractEmfHandler<?> getAddHandler() {
		EObject sel = getSelectedObject();
		for (Class<? extends EObject> cl : addHandlerRegistry.keySet()) {
			Class<?>[] interfaces = sel.getClass().getInterfaces();
			for (Class<?> ci : interfaces) {
				if (cl == ci) {
					return addHandlerRegistry.get(cl);
				}
			}
		}
		return null;
	}

	/**
	 * @return
	 */
	public AbstractEmfHandler<?> getDeleteHandler() {
		EObject sel = getSelectedObject();
		for (Class<? extends EObject> cl : deleteHandlerRegistry.keySet()) {
			Class<?>[] interfaces = sel.getClass().getInterfaces();
			for (Class<?> ci : interfaces) {
				if (cl == ci) {
					return deleteHandlerRegistry.get(cl);
				}
			}
		}
		return null;
	}

	/**
	 * 
	 */
	private void addCDOListener() {
		if (RcplSession.getDefault().getSession() != null) {
			RcplSession.getDefault().getSession().addListener(new IListener() {

				@Override
				public void notifyEvent(IEvent event) {
					// TODO Auto-generated method stub

					// if (event instanceof CDOSessionInvalidationEvent) {
					//
					// CDOSessionInvalidationEvent ev =
					// (CDOSessionInvalidationEvent) event;
					//
					// List<CDORevisionKey> list = ev.getChangedObjects();
					// CDOTransaction trans = ev.getLocalTransaction();
					// if (trans != null) {
					// for (CDORevisionKey cdoRevisionKey : list) {
					// CDOID id = cdoRevisionKey.getID();
					// // cdoobj = ((CDOView) trans).getObject(id,
					// // true);
					// }
					// }
					// }

					javafx.application.Platform.runLater(new Runnable() {

						@Override
						public void run() {
//							adapterFactoryTreeItem2 = null;
							refresh();
						}
					});

				}
			});
		}
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void refresh() {

		try {
			if (adapterFactoryTreeItem2 == null) {

				adapterFactoryTreeItem2 = new AdapterFactoryTreeItem(getRoot(), manager.getAdapterFactory());
				treeView.setRoot(adapterFactoryTreeItem2);
				AdapterFactoryTreeCellFactory treeCellFactory = new AdapterFactoryTreeCellFactory(
						manager.getAdapterFactory());

				// ---------- add edit support ----------------------

				treeCellFactory.addCellEditHandler(new EAttributeCellEditHandler(
						RcplPackage.eINSTANCE.getTools().getEIDAttribute(), getEditingDomain()));
				treeCellFactory.addCellEditHandler(
						new EAttributeCellEditHandler(RcplPackage.eINSTANCE.getLayoutable_Id(), getEditingDomain()));
				treeCellFactory.addCellEditHandler(
						new EAttributeCellEditHandler(RcplPackage.eINSTANCE.getLayoutable_Id(), getEditingDomain()));

				if (!Rcpl.isMobile()) {
					treeCellFactory.addCellCreationListener(new CellDragAdapter());
				}

				treeView.setCellFactory(treeCellFactory);

				if (RcplSession.getDefault().isDemo()) {
					treeView.setEditable(false);
				} else {
					treeView.setCellFactory(treeCellFactory);
					if (!Rcpl.isMobile()) {
						EditingDomainCellDropAdapter dropAdapter = new EditingDomainCellDropAdapter(getEditingDomain());
						dropAdapter.setFeedbackHandler(new EditingDomainCellDropAdapter.DefaultFeedbackHandler());
						treeCellFactory.addCellCreationListener(dropAdapter);
						DefaultTreeContextMenuProvider contextMenuProvider = createContextMenuProvider();
						treeCellFactory.addCellUpdateListener(contextMenuProvider);
					}
					treeView.setEditable(true);
				}
				treeView.getRoot().setExpanded(true);

				// for (TreeItem<?> item : treeView.getRoot().getChildren()) {
				// item.setExpanded(true);
				// }
			}
		} catch (LifecycleException ex) {
			//
		}

	}

//	private void refresh() {
//
//		try {
//
//			EditingDomain editingDomain = getEditingDomain();
//			// TreeView
//			TreeView<Object> treeView = new TreeView<>();
//			treeView.setRoot(new AdapterFactoryTreeItem(emfTreeManager.getRoot(), emfTreeManager.getAdapterFactory()));
//			AdapterFactoryTreeCellFactory treeCellFactory = new AdapterFactoryTreeCellFactory(
//					emfTreeManager.getAdapterFactory());
//
//			// ---------- add edit support
//
//			treeCellFactory.addCellEditHandler(
//					new EAttributeCellEditHandler(RcplPackage.eINSTANCE.getRCPL().getEIDAttribute(), editingDomain));
//
//			// ---------- adds drag support
//
//			treeCellFactory.addCellCreationListener(new CellDragAdapter());
//
//			// ---------- adds drop support
//			EditingDomainCellDropAdapter dropAdapter = new EditingDomainCellDropAdapter(editingDomain);
////			dropAdapter.setFeedbackHandler(new CustomFeedbackHandler());
////			treeCellFactory.addCellCreationListener(dropAdapter);
//
//			treeView.setCellFactory(treeCellFactory);
//
////			parent.setCenter(treeView);
//
//			treeView.setShowRoot(true);
//
//			treeView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//
////			treeView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {
////
////				public void changed(ObservableValue<? extends Object> arg0, Object arg1, Object arg2) {
////					if (arg2 instanceof AdapterFactoryTreeItem) {
////						Object value = ((AdapterFactoryTreeItem) arg2).getValue();
////						if (value instanceof Contact)
////							application.getContext().set(Object.class, value);
////					}
////				}
////
////			});
//
////			treeView.getSelectionModel().getSelectedItems().addListener(new ListChangeListener<Object>() {
////
////				@Override
////				public void onChanged(Change<?> change) {
////					ArrayList<Object> selection = new ArrayList<Object>();
////					for (Object item : change.getList()) {
////						if (item instanceof AdapterFactoryTreeItem) {
////							Object value = ((AdapterFactoryTreeItem) item).getValue();
////							selection.add(value);
////						}
////					}
////					application.getContext().set(List.class, selection);
////				}
////
////			});
//
//			// add the context menu
////			DefaultTreeContextMenuProvider contextMenuProvider = new DefaultTreeContextMenuProvider(
////					(UCEmfTreeModelManagerImpl) emfTreeManager);
////			treeCellFactory.addCellUpdateListener(contextMenuProvider);
//
////			treeView.setEditable(true);
////
////			EditingDomain editingDomain = getEditingDomain();
////
////			// TreeView
////			TreeView<Object> treeView = new TreeView<>();
////			treeView.setRoot(
////					new AdapterFactoryTreeItem(contactsManager.getRootGroup(), contactsManager.getAdapterFactory()));
////			AdapterFactoryTreeCellFactory treeCellFactory = new AdapterFactoryTreeCellFactory(
////					contactsManager.getAdapterFactory());
////
////			// add edit support
////			treeCellFactory.addCellEditHandler(
////					new EAttributeCellEditHandler(ContactsPackage.eINSTANCE.getGroup_Name(), editingDomain));
////
////			// adds drag support
////			treeCellFactory.addCellCreationListener(new CellDragAdapter());
////
////			// adds drop support
////			EditingDomainCellDropAdapter dropAdapter = new EditingDomainCellDropAdapter(editingDomain);
////			dropAdapter.setFeedbackHandler(new CustomFeedbackHandler());
////			treeCellFactory.addCellCreationListener(dropAdapter);
////
////			treeView.setCellFactory(treeCellFactory);
////
////			parent.setCenter(treeView);
////
////			treeView.setShowRoot(false);
////
////			treeView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
////
////			treeView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {
////
////				public void changed(ObservableValue<? extends Object> arg0, Object arg1, Object arg2) {
////					if (arg2 instanceof AdapterFactoryTreeItem) {
////						Object value = ((AdapterFactoryTreeItem) arg2).getValue();
////						if (value instanceof Contact)
////							application.getContext().set(Object.class, value);
////					}
////				}
////
////			});
////
////			treeView.getSelectionModel().getSelectedItems().addListener(new ListChangeListener<Object>() {
////
////				@Override
////				public void onChanged(Change<?> change) {
////					ArrayList<Object> selection = new ArrayList<Object>();
////					for (Object item : change.getList()) {
////						if (item instanceof AdapterFactoryTreeItem) {
////							Object value = ((AdapterFactoryTreeItem) item).getValue();
////							selection.add(value);
////						}
////					}
////					application.getContext().set(List.class, selection);
////				}
////
////			});
//
//			if (adapterFactoryTreeItem2 == null) {
//
//				adapterFactoryTreeItem2 = new AdapterFactoryTreeItem<Object>(emfTreeManager.getRoot(),
//						emfTreeManager.getAdapterFactory());
//				treeView.setRoot(adapterFactoryTreeItem2);
//
//				AdapterFactoryTreeCellFactory<Object> treeCellFactory2 = new AdapterFactoryTreeCellFactory<Object>(
//						emfTreeManager.getAdapterFactory());
//
//				// ---------- add edit support
//
//				treeCellFactory.addCellEditHandler(new EAttributeCellEditHandler(
//						RcplPackage.eINSTANCE.getTools().getEIDAttribute(), getEditingDomain()));
//				treeCellFactory.addCellEditHandler(
//						new EAttributeCellEditHandler(RcplPackage.eINSTANCE.getLayoutable_Id(), getEditingDomain()));
//
//				// ---------- DOD support
//
//				if (!Rcpl.isMobile()) {
////					treeCellFactory.addCellCreationListener(new CellDragAdapter());
//				}
//
//				treeView.setCellFactory(treeCellFactory2);
//
////				if (RcplSession.getDefault().isDemo()) {
////					treeView.setEditable(false);
////				} else {
////					if (!Rcpl.isMobile()) {
////						EditingDomainCellDropAdapter dropAdapter = new EditingDomainCellDropAdapter(getEditingDomain());
////						dropAdapter.setFeedbackHandler(new EditingDomainCellDropAdapter.DefaultFeedbackHandler());
//////						treeCellFactory.addCellCreationListener(dropAdapter);
////						DefaultTreeContextMenuProvider contextMenuProvider = createContextMenuProvider();
//////						treeCellFactory.addCellUpdateListener(contextMenuProvider);
////					}
////					treeView.setEditable(true);
////				}
//				treeView.getRoot().setExpanded(true);
//
////				expandAll();
//			}
//		} catch (LifecycleException ex) {
//			//
//		}
//
//	}

	@SuppressWarnings("unused")
	private void expandAll() {
		for (TreeItem<?> item : treeView.getRoot().getChildren()) {
			item.setExpanded(true);
		}

	}

	protected DefaultTreeContextMenuProvider createContextMenuProvider() {
		return new DefaultNavigatorContextMenuProvider(this);
	}

	public EditingDomain getEditingDomain() {
		return ((UCEmfTreeModelManagerImpl) manager).getEditingDomain();
	}

	@Override
	public Node createNode() {
		treeView = new TreeView<Object>();

		treeView.getStyleClass().add("emfTreeView");
		return treeView;
	}

	@Override
	public EObject getSelectedObject() {
		return selectedObject;
	}

	public TreeView<Object> getTreeView() {
		return treeView;
	}

	@Override
	public IToolRegistry getToolRegistry() {
		return null;
	}

	@Override
	public IResourceEntry getEntry() {
		return null;
	}

	@Override
	public IToolComponent getToolComponent() {
		return null;
	}

	@Override
	public void setVisible(boolean visible) {
	}

	@Override
	public IToolGroup getGroup() {
		return null;
	}

	@Override
	public boolean isFullSize() {
		return false;
	}

	@Override
	public int getToolHierarchy() {
		return 0;
	}

	@Override
	public Object getImage() {
		return null;
	}

	@Override
	public boolean isWrap() {
		return false;
	}

	public Pane getDetailPane() {
		return detailPane;
	}

	@Override
	public EObject getRoot() {
		return RcplSession.getDefault().getRcpl().getAllResources();
	}

}
