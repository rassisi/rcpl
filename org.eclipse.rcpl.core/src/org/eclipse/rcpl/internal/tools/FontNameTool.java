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

package org.eclipse.rcpl.internal.tools;

import java.util.List;

import org.eclipse.rcpl.AbstractRcplTool;
import org.eclipse.rcpl.IFont;
import org.eclipse.rcpl.ILayoutObject;
import org.eclipse.rcpl.IParagraph;
import org.eclipse.rcpl.Rcpl;
import org.eclipse.rcpl.model.RcplModel;
import org.eclipse.rcpl.model_2_0_0.rcpl.Tool;
import org.eclipse.rcpl.ui.font.RcplFont;
import org.eclipse.rcpl.ui.listener.RcplEvent;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.text.Font;
import javafx.util.Callback;

/**
 * @author ramin
 *
 */
public class FontNameTool extends AbstractRcplTool<String> {

	private static double LABEL_FONT_SIZE = 12;

	private class ToolCombo extends ComboBox<String> {
		@Override
		public ObservableList<Node> getChildren() {
			return super.getChildren();
		}
	}

	private ToolCombo node;

	public FontNameTool(final Tool tool) {
		super(tool);

		List<String> list = Font.getFamilies();

		getNode().getItems().addAll(list);

		node.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
			@Override
			public ListCell<String> call(ListView<String> p) {
				return new ListCell<String>() {
					private final Label label;

					{
						setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
						label = new Label();
					}

					@Override
					protected void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);
						if (item == null || empty) {
							setGraphic(null);
						} else {
							label.setText(item);
							label.setFont(Font.font(item, LABEL_FONT_SIZE));
							label.setId("fontNameComboLabel");
							setGraphic(label);
						}
					}
				};
			}
		});

		node.setMinHeight(26);
		node.setPrefWidth(150);
	}

	public void initSelection() {
		if (Rcpl.get().globalStyleTemplate() != null) {
			IFont font = Rcpl.defaultStyle().getFont();
			selectFont(font);
		}
	}

	public void selectFont(IFont font) {
		node.getSelectionModel().select(font.getName());
	}

	public void setStyle(IStyle style) {
		ObservableList<Node> chs = node.getChildren();
		for (Node node : chs) {
			if (node instanceof Labeled) {
				double height = Math.min(15, style.getFont().getHeight());
				height = Math.max(14, height);

				((Labeled) node)
						.setFont(new RcplFont(style.getFont().getName(), height, style.getFont().getStyle()).getFx());
				if (style.getForeGround() != null) {
					((Labeled) node).setTextFill(style.getForeGround().getFx());
				}
				break;
			}
		}
	}

	@Override
	public ComboBox<String> createNode() {
		return new ToolCombo();
	}

	@Override
	public ComboBox<String> getNode() {
		if (node == null) {
			node = (ToolCombo) super.getNode();
		}
		return node;
	}

	@Override
	public void doUpdate(RcplEvent event) {
		try {
			ILayoutObject lo = event.getLayoutObject();
			if (lo instanceof IParagraph) {
				IParagraph p = (IParagraph) lo;
				IStyle style = p.findCharacterStyleAtOffset();
				if (style == null) {
					style = p.getStyle();
				}
				removeListener();
				selectFont(style.getFont());
				addListener();
			}
		} catch (Exception ex) {
			RcplModel.logError(ex);
		}
	}

	@Override
	protected void doRemoveListener(ChangeListener<String> changeListener) {
		getNode().valueProperty().removeListener(changeListener);
	}

	@Override
	protected ChangeListener<String> createChangeListener() {
		ChangeListener<String> changeListener = new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (Rcpl.UIC().getEditor() != null) {
					execute(newValue);
				}
			}
		};
		return changeListener;
	}

	@Override
	protected void doAddListener(ChangeListener<String> changeListener) {
		getNode().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				execute(getNode().getSelectionModel().getSelectedItem());
			}
		});
		getNode().valueProperty().addListener(changeListener);
	}

}
