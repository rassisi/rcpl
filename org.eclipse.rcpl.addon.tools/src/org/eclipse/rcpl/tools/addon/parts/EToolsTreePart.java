package org.eclipse.rcpl.tools.addon.parts;

import java.util.List;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.revision.CDORevisionKey;
import org.eclipse.emf.cdo.session.CDOSessionInvalidationEvent;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.fx.emf.edit.ui.AdapterFactoryTreeCellFactory;
import org.eclipse.fx.emf.edit.ui.AdapterFactoryTreeItem;
import org.eclipse.fx.emf.edit.ui.EAttributeCellEditHandler;
import org.eclipse.fx.emf.edit.ui.dnd.CellDragAdapter;
import org.eclipse.fx.emf.edit.ui.dnd.EditingDomainCellDropAdapter;
import org.eclipse.net4j.util.event.IEvent;
import org.eclipse.net4j.util.event.IListener;
import org.eclipse.rcpl.model.cdo.client.RcplSession;
import org.eclipse.rcpl.model_2_0_0.rcpl.AbstractTool;
import org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage;
import org.eclipse.rcpl.model_2_0_0.rcpl.Tools;
import org.eclipse.rcpl.tools.addon.EToolsAddon;
import org.eclipse.rcpl.tools.addon.UCToolsPlugin;
import org.eclipse.rcpl.tools.addon.handlers.CustomFeedbackHandler;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;

public class EToolsTreePart {

	private Node node;

	private Tools rootGroup;

	private TreeView<Object> treeView;

	private AdapterFactoryTreeItem adapterFactoryTreeItem;

	private CDOObject cdoobj;

	private EObject selectedObject;

	private EToolsAddon useCase;

	public EToolsTreePart(final EToolsAddon useCase) {

		// TreeView
		this.useCase = useCase;
		treeView = new TreeView<>();
		treeView.setPrefHeight(1000);
		rootGroup = RcplSession.getDefault().getRcpl().getAllTools();

		if (RcplSession.getDefault().getSession() != null) {
			RcplSession.getDefault().getSession().addListener(new IListener() {

				@Override
				public void notifyEvent(IEvent event) {

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
							refresh();

							if (cdoobj instanceof AbstractTool) {

								ObservableList<TreeItem<Object>> list2 = adapterFactoryTreeItem.getChildren();

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

		adapterFactoryTreeItem = new AdapterFactoryTreeItem(rootGroup,
				UCToolsPlugin.getDefault().getToolsManager().getAdapterFactory());

		refresh();

		SplitPane splitPane = new SplitPane();
		splitPane.setDividerPositions(0.3, 0.7);
		splitPane.getItems().add(treeView);

		node = splitPane;

		treeView.setShowRoot(false);
		treeView.requestFocus();

		treeView.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				getUseCase().getController().unbindAll();
			}
		});

		//

		treeView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		treeView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {

			@Override
			public void changed(ObservableValue<? extends Object> arg0, Object oldItem, Object newItem) {

				getUseCase().getController().unbindAll();

				if (newItem instanceof AdapterFactoryTreeItem) {

					Object value = ((AdapterFactoryTreeItem) newItem).getValue();

					selectedObject = value instanceof EObject ? (EObject) value : null;

				}
			}

		});

	}

	private void refresh() {
		treeView.setRoot(adapterFactoryTreeItem);
		EditingDomain editingDomain = UCToolsPlugin.getDefault().getToolsManager().getEditingDomain();

		AdapterFactoryTreeCellFactory treeCellFactory = new AdapterFactoryTreeCellFactory(
				UCToolsPlugin.getDefault().getToolsManager().getAdapterFactory());

		// add edit support
		treeCellFactory.addCellEditHandler(
				new EAttributeCellEditHandler(RcplPackage.eINSTANCE.getTools().getEIDAttribute(), editingDomain));

		// adds drag support
		treeCellFactory.addCellCreationListener(new CellDragAdapter());

		// adds drop support
		EditingDomainCellDropAdapter dropAdapter = new EditingDomainCellDropAdapter(editingDomain);
		dropAdapter.setFeedbackHandler(new CustomFeedbackHandler());
		treeCellFactory.addCellCreationListener(dropAdapter);

		treeView.setCellFactory(treeCellFactory);

		EToolsContextMenuProvider contextMenuProvider = new EToolsContextMenuProvider(this);
		treeCellFactory.addCellUpdateListener(contextMenuProvider);

		treeView.setEditable(true);

		treeView.getRoot().setExpanded(true);

		for (TreeItem<?> item : treeView.getRoot().getChildren()) {
			item.setExpanded(true);
		}
	}

	public Node getNode() {
		return node;
	}

	public EObject getSelectedObject() {
		return selectedObject;
	}

	public void setSelectedObject(EObject selectedObject) {
		this.selectedObject = selectedObject;
	}

	public EToolsAddon getUseCase() {
		return useCase;
	}

	public TreeView<Object> getTreeView() {
		return treeView;
	}

}
