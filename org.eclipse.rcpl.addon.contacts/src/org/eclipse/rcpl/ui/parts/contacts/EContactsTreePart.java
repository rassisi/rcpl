package org.eclipse.rcpl.ui.parts.contacts;

import java.util.List;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.revision.CDORevisionKey;
import org.eclipse.emf.cdo.session.CDOSessionInvalidationEvent;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.fx.emf.edit.ui.AdapterFactoryTreeCellFactory;
import org.eclipse.fx.emf.edit.ui.AdapterFactoryTreeItem;
import org.eclipse.fx.emf.edit.ui.EAttributeCellEditHandler;
import org.eclipse.fx.emf.edit.ui.dnd.CellDragAdapter;
import org.eclipse.net4j.util.event.IEvent;
import org.eclipse.net4j.util.event.IListener;
import org.eclipse.rcpl.contacts.addon.OsgiContactsAddon;
import org.eclipse.rcpl.contacts.addon.RcplContactsAddon;
import org.eclipse.rcpl.model.client.RcplSession;
import org.eclipse.rcpl.model_2_0_0.rcpl.Person;
import org.eclipse.rcpl.model_2_0_0.rcpl.Persons;
import org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class EContactsTreePart {

	// EContactsUseCaseController controller;

	private Node node;

	private RcplContactsAddon useCase;

	private Persons rootGroup;

	private TreeView<Object> treeView;

	private AdapterFactoryTreeItem adapterFactory;

	private CDOObject cdoobj;

	private AdapterFactoryTreeCellFactory treeCellFactory;

	public EContactsTreePart(final RcplContactsAddon useCase) {
		this.useCase = useCase;

		// TreeView
		treeView = new TreeView<>();
		rootGroup = RcplSession.getDefault().getRcpl().getAllPersons();

		if (RcplSession.getDefault().getSession() != null) {

			RcplSession.getDefault().getSession().addListener(new IListener() {

				@Override
				public void notifyEvent(IEvent event) {
					// TODO Auto-generated method stub

					if (event instanceof CDOSessionInvalidationEvent) {

						CDOSessionInvalidationEvent ev = (CDOSessionInvalidationEvent) event;

						List<CDORevisionKey> list = ev.getChangedObjects();
						CDOTransaction trans = ev.getLocalTransaction();
						if (trans != null) {
							for (CDORevisionKey cdoRevisionKey : list) {
								CDOID id = cdoRevisionKey.getID();
								cdoobj = ((CDOView) trans).getObject(id, true);
							}
						}
					}
					javafx.application.Platform.runLater(new Runnable() {

						@Override
						public void run() {
							adapterFactory = null;
							refresh();

							if (cdoobj instanceof Person) {

								ObservableList<TreeItem<Object>> list2 = adapterFactory.getChildren();

								for (TreeItem<Object> treeItem : list2) {

									if (cdoobj == treeItem.getValue()) {
										treeView.requestFocus();
										treeItem.setExpanded(true);
										treeView.getSelectionModel().select(treeItem);
										break;
									}

								}

							}

						}
					});

				}
			});
		}

		refresh();

		SplitPane splitPane = new SplitPane();
		splitPane.setDividerPositions(0.3, 0.7);
		splitPane.getItems().add(treeView);

		node = splitPane;

		treeView.setShowRoot(true);
		treeView.requestFocus();
		treeView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		treeView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {

			@Override
			public void changed(ObservableValue<? extends Object> arg0, Object oldItem, Object newItem) {

				if (newItem instanceof AdapterFactoryTreeItem) {

					Object value = ((AdapterFactoryTreeItem) newItem).getValue();
					if (value instanceof Person) {
						Person contact = value instanceof Person ? (Person) value : null;
						useCase.getController().updateBindings(contact, OsgiContactsAddon.getEditingDomain());
					}
				}

			}

		});

		// treeView.getSelectionModel().getSelectedItems()
		// .addListener(new ListChangeListener<Object>() {
		//
		// @Override
		// public void onChanged(Change<?> change) {
		// ArrayList<Object> selection = new ArrayList<Object>();
		// for (Object item : change.getList()) {
		// if (item instanceof AdapterFactoryTreeItem) {
		// Object value = ((AdapterFactoryTreeItem) item)
		// .getValue();
		// selection.add(value);
		// }
		// }
		// }
		//
		// });

	}

	private void refresh() {

		if (RcplSession.getDefault().isValid()) {
			try {
				if (adapterFactory == null) {
					adapterFactory = new AdapterFactoryTreeItem(rootGroup,
							OsgiContactsAddon.getDefault().getModelManager().getAdapterFactory());
					treeView.setRoot(adapterFactory);

					treeCellFactory = new AdapterFactoryTreeCellFactory(
							OsgiContactsAddon.getDefault().getModelManager().getAdapterFactory());

					// add edit support
					treeCellFactory.addCellEditHandler(new EAttributeCellEditHandler(
							RcplPackage.eINSTANCE.getLayoutable_Id(), OsgiContactsAddon.getEditingDomain()));

					// adds drag support
					treeCellFactory.addCellCreationListener(new CellDragAdapter());

					// adds drop support

					EditingDomainCellDropAdapter dropAdapter = new EditingDomainCellDropAdapter(
							OsgiContactsAddon.getEditingDomain());

					// dropAdapter.setFeedbackHandler(new
					// CustomFeedbackHandler());

					treeCellFactory.addCellCreationListener(dropAdapter);

					treeView.setCellFactory(treeCellFactory);

					EContactsContextMenuProvider contextMenuProvider = new EContactsContextMenuProvider();
					treeCellFactory.addCellUpdateListener(contextMenuProvider);

					treeView.setEditable(true);
				}
			} catch (Exception ex) {
				// Rcpl.println().println(ex.getMessage());
			}
		}
	}

	public Node getNode() {
		return node;
	}

}
