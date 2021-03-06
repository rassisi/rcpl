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

package org.eclipse.rcpl.navigator.treeparts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.fx.emf.edit.ui.AdapterFactoryCellFactory.ICellUpdateListener;
import org.eclipse.rcpl.navigator.handlers.AbstractEmfHandler;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Cell;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListCell;
import javafx.scene.control.MenuItem;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableRow;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.image.ImageView;
import javafx.stage.WindowEvent;

public class DefaultNavigatorContextMenuProvider extends DefaultTreeContextMenuProvider implements ICellUpdateListener {

	private MenuItem deleteMenuItem;

	private DefaultNavigatorTreePart treePart;

//	public NavigatorContextMenuProvider(EEmfTreeTreePart treePart) {
//		this.treePart = treePart;
//	}

	public DefaultNavigatorContextMenuProvider(DefaultNavigatorTreePart treePart) {
		super(treePart);
	}

	static List<?> getSelectionModel(Cell<?> cell) {
		if (cell instanceof ListCell<?>) {
			return ((ListCell<?>) cell).getListView().getSelectionModel().getSelectedItems();
		} else if (cell instanceof TreeCell<?>) {
			MultipleSelectionModel<?> selectionModel = ((TreeCell<?>) cell).getTreeView().getSelectionModel();
			ObservableList<?> selectedItems = selectionModel.getSelectedItems();
			ArrayList<Object> unwrappedItems = new ArrayList<>(selectedItems.size());
			for (Object object : selectedItems) {
				TreeItem<?> treeItem = (TreeItem<?>) object;
				unwrappedItems.add(treeItem.getValue());
			}
			return unwrappedItems;
		} else if (cell instanceof TableCell<?, ?>) {
			return ((TableCell<?, ?>) cell).getTableView().getSelectionModel().getSelectedItems();
		} else if (cell instanceof TableRow<?>) {
			return ((TableRow<?>) cell).getTableView().getSelectionModel().getSelectedItems();
		}
		return null;
	}

	@Override
	public void updateItem(final Cell<?> cell, final Object item, boolean empty) {

		final ContextMenu contextMenu = new ContextMenu();
		cell.setContextMenu(contextMenu);
		contextMenu.getItems().add(new MenuItem());
		contextMenu.setOnShowing(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent event) {
				List<?> selectedItems = getSelectionModel(cell);

				if (selectedItems.size() == 1) {
					if (selectedItems.get(0) instanceof EObject) {

						contextMenu.getItems().clear();

						AbstractEmfHandler<?> addHandler = treePart.getAddHandler();
						if (addHandler != null) {
							addMenuItem.setDisable(!addHandler.canExecute());
							contextMenu.getItems().add(addMenuItem);
							addMenuItem.setGraphic(new ImageView(addHandler.getImage()));
							addMenuItem.setText(addHandler.getText());
						}

						AbstractEmfHandler<?> deleteHandler = treePart.getDeleteHandler();
						if (deleteHandler != null) {
							deleteMenuItem.setDisable(!deleteHandler.canExecute());
							contextMenu.getItems().add(deleteMenuItem);
							deleteMenuItem.setGraphic(new ImageView(deleteHandler.getImage()));
							deleteMenuItem.setText(deleteHandler.getText());
						}
					}
				}
			}

		});

		// deleteMenuItem = new MenuItem("Delete",
		// getImage("icons/silk/cross.png"));
		// deleteHandler = new DeleteToolHandler();
		// deleteMenuItem.setOnAction(new EventHandler<ActionEvent>() {
		// @Override
		// public void handle(ActionEvent event) {
		// deleteHandler.execute();
		// }
		// });
		//
		// cutMenuItem = new MenuItem("Cut", getImage("icons/silk/cut.png"));
		// cutHandler = new CutHandler();
		// cutMenuItem.setOnAction(new EventHandler<ActionEvent>() {
		// @Override
		// public void handle(ActionEvent event) {
		// cutHandler.execute();
		// }
		// });
		//
		// copyMenuItem = new MenuItem("Copy",
		// getImage("icons/silk/page_copy.png"));
		// copyHandler = new CopyHandler();
		// copyMenuItem.setOnAction(new EventHandler<ActionEvent>() {
		//
		// @Override
		// public void handle(ActionEvent event) {
		// copyHandler.execute();
		// }
		//
		// });
		//
		// pasteMenuItem = new MenuItem("Paste",
		// getImage("icons/silk/page_paste.png"));
		// pasteHandler = new PasteHandler();
		// pasteMenuItem.setOnAction(new EventHandler<ActionEvent>() {
		//
		// @Override
		// public void handle(ActionEvent event) {
		// pasteHandler.execute();
		// }
		//
		// });

		addMenuItem = new MenuItem("", null);
		// JO.resources.getImageView("add_project_clipart"));

		addMenuItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				treePart.getAddHandler().execute();
			}
		});

		deleteMenuItem = new MenuItem("", null);

		deleteMenuItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				treePart.getDeleteHandler().execute();
			}
		});
	}

}
