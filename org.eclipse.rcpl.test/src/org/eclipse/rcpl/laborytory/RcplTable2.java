package org.eclipse.rcpl.laborytory;

import org.eclipse.rcpl.IParagraph;
import org.eclipse.rcpl.ui.controls.table.RcplTableUtil;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

/**
 * @author Ramin
 *
 */
public class RcplTable2 {

	private int rowCount = 100;

	private int columnCount = 100;

	private final boolean spreadsheet;

	private RcplTableView2 tableView;

	private Pane node;

	private boolean header = false;

	private Scene scene;

	public RcplTable2(boolean spreadsheet, boolean header) {
		this.spreadsheet = spreadsheet;
		this.header = header;
		if (spreadsheet) {
			header = true;
		}
		tableView = new RcplTableView2(this);
		node = tableView;

		createCells();
	}

	private void createCells() {

		if (header) {
			for (int column = 0; column < columnCount; column++) {
				if (column == 0) {
					StackPane sp = new StackPane();
					sp.setPrefSize(40, 20);
					sp.setMinSize(40, 20);
					sp.setMaxSize(40, 20);
					tableView.getHeaderPane().add(sp, 0, 0);
				} else {
					StackPane sp = new StackPane();
					sp.setPrefSize(80, 20);
					sp.setMinSize(80, 20);

					HBox hbox = new HBox();
					sp.getChildren().add(hbox);
					Label l = new Label();
					l.setTextAlignment(TextAlignment.CENTER);
					l.setAlignment(Pos.CENTER);
					l.setPrefWidth(100);
					hbox.getChildren().add(l);
					Pane sizer = new Pane();
					sizer.setOnMouseEntered(new EventHandler<MouseEvent>() {

						@Override
						public void handle(MouseEvent event) {
							scene.setCursor(Cursor.E_RESIZE);
						}
					});

					sizer.setOnMouseExited(new EventHandler<MouseEvent>() {

						@Override
						public void handle(MouseEvent event) {
							scene.setCursor(Cursor.DEFAULT);
						}
					});

					sizer.setStyle("-fx-border-width: 1;-fx-border-color: gray");
					sizer.setPrefWidth(2);
					sizer.setMinWidth(2);
					sizer.setMaxWidth(2);
					hbox.getChildren().add(sizer);
					if (spreadsheet) {
						l.setText(RcplTableUtil.calculateColumnName(column - 1));
					}

					ColumnConstraints constraint = new ColumnConstraints();
					constraint.setMinWidth(80);
					constraint.setPrefWidth(80);
					constraint.setMaxWidth(80);
					tableView.getCellPane().getColumnConstraints().addAll(constraint);
					tableView.getHeaderPane().add(sp, column, 0);

				}
			}
		}

		for (int row = 0; row < rowCount; row++) {
			for (int column = 0; column < columnCount; column++) {

				if (spreadsheet && column == 0) {
					StackPane sp = new StackPane();
					sp.setStyle("-fx-border-width: 0.5;-fx-border-color: red");

					sp.setPrefSize(40, 20);
					sp.setMinSize(40, 20);
					sp.setMaxSize(40, 20);

					VBox vbox = new VBox();
					vbox.setMinWidth(40);
					vbox.setPrefWidth(40);
					vbox.setMaxWidth(40);
					sp.getChildren().add(vbox);
					Label l = new Label();
					l.setTextAlignment(TextAlignment.CENTER);
					l.setAlignment(Pos.CENTER);
					l.setMinWidth(40);
					l.setPrefWidth(40);
					l.setMaxWidth(40);
					l.setPrefHeight(30);
					vbox.getChildren().add(l);
					Pane sizer = new Pane();
					sizer.setOnMouseEntered(new EventHandler<MouseEvent>() {

						@Override
						public void handle(MouseEvent event) {
							scene.setCursor(Cursor.S_RESIZE);
						}
					});

					sizer.setOnMouseExited(new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent event) {
							scene.setCursor(Cursor.DEFAULT);
						}
					});

					sizer.setStyle("-fx-border-width: 1;-fx-border-color: gray");
					sizer.setPrefHeight(2);
					sizer.setMinHeight(2);
					sizer.setMaxHeight(2);
					vbox.getChildren().add(sizer);
					if (spreadsheet) {
						l.setText("" + (row + 1));
					}

					ColumnConstraints columnConstraint = new ColumnConstraints();
					columnConstraint.setMinWidth(40);
					columnConstraint.setPrefWidth(40);
					columnConstraint.setMaxWidth(40);
					tableView.getCellPane().getColumnConstraints().add(columnConstraint);
					tableView.getCellPane().add(sp, column, row);

				} else {
					StackPane sp = new StackPane();
					sp.setPrefSize(80, 20);
					sp.setMinSize(80, 20);
					ColumnConstraints constraint = new ColumnConstraints();
					constraint.setMinWidth(80);
					constraint.setPrefWidth(80);
					constraint.setMaxWidth(80);
					tableView.getCellPane().getColumnConstraints().add(constraint);
					tableView.getCellPane().add(sp, column, row);
				}
			}
		}

	}

	protected IParagraph createParagraph() {
		return null;
	}

	public boolean isSpreadsheet() {
		return spreadsheet;
	}

	public void updateCss(Scene scene) {
		this.scene = scene;
		if (spreadsheet) {
			scene.getStylesheets().add(RcplTable2.class.getResource("rcpltableview_spreadsheet.css").toExternalForm());
		} else {
			scene.getStylesheets().add(RcplTable2.class.getResource("rcpltableview.css").toExternalForm());
		}

		tableView.getStyleClass().add("gridStyle_normal");
	}

	public Pane getNode() {
		return node;
	}

	public boolean hasHeader() {
		return header;
	}
}
