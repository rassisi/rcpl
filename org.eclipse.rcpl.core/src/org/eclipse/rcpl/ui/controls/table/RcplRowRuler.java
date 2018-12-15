package org.eclipse.rcpl.ui.controls.table;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

public class RcplRowRuler {

	private GridPane grid;

	private final ScrollPane node;

	private RcplTable table;

	private boolean mouseDown;

	public RcplRowRuler(RcplTable table) {
		this.table = table;

		node = new ScrollPane();
		node.setHbarPolicy(ScrollBarPolicy.NEVER);
		node.setVbarPolicy(ScrollBarPolicy.NEVER);
		node.setPadding(new Insets(0, 0, 16, 0));

		grid = new GridPane();
		grid.setGridLinesVisible(true);
		node.setContent(grid);
		node.setPrefWidth(IRcplTableConstants.DEFAULT_ROW_RULER_WIDTH);
		node.setMinWidth(IRcplTableConstants.DEFAULT_ROW_RULER_WIDTH);
		node.setMaxWidth(IRcplTableConstants.DEFAULT_ROW_RULER_WIDTH);

		for (int row = 0; row < this.table.getRowCount(); row++) {
			insertRow(row);
		}
	}

	void insertRow() {
		insertRow(table.getRowCount() - 1);
	}

	void insertRow(int row) {
		final StackPane sp = new StackPane();
		DragAnchor da = new DragAnchor();
		sp.setUserData(da);
		sp.setPrefSize(IRcplTableConstants.DEFAULT_ROW_RULER_WIDTH, table.DEFAULT_ROW_HEIGHT);
		VBox vbox = new VBox();
		sp.getChildren().add(vbox);
		StackPane.setAlignment(vbox, Pos.BOTTOM_CENTER);
		Label l = new Label();
		l.setPrefSize(IRcplTableConstants.DEFAULT_ROW_RULER_WIDTH, 10000);
		l.setTextAlignment(TextAlignment.CENTER);
		l.setAlignment(Pos.CENTER);
		if (table.isSpreadsheet()) {
			l.setText("" + (row + 1));
		}
		Pane sizer = new Pane();
		sizer.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				node.setCursor(Cursor.S_RESIZE);
			}
		});

		sizer.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if (!mouseDown) {
					node.setCursor(Cursor.DEFAULT);
				}
			}
		});

		sizer.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent me) {
				mouseDown = false;
				node.setCursor(Cursor.DEFAULT);
			}
		});

		sizer.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent me) {
				mouseDown = true;
				da.dragAnchor = new Point2D(me.getSceneX(), me.getSceneY());
				((DragAnchor) sp.getUserData()).index = row;
				da.startSize = getRowHeight(row);
				me.consume();
			}
		});

		sizer.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent me) {
				handleMouseDragged(me, sp);
			}
		});

		sizer.setPrefHeight(IRcplTableConstants.SIZER_WIDTH);
		sizer.setMinHeight(IRcplTableConstants.SIZER_WIDTH);
		sizer.setMaxHeight(IRcplTableConstants.SIZER_WIDTH);
		vbox.getChildren().addAll(l, sizer);
		grid.add(sp, 0, row);

		RowConstraints rc = new RowConstraints();
		rc.setPrefHeight(table.DEFAULT_ROW_HEIGHT);
		grid.getRowConstraints().add(rc);
		updateRowNumbers();
	}

	public void handleMouseDragged(MouseEvent me, Pane sp) {
		DragAnchor da = (DragAnchor) sp.getUserData();
		if (da != null) {
			double diffY = me.getSceneY() - da.dragAnchor.getY();
			double newHeight = Math.max(10, da.startSize + diffY);
			if (newHeight >= table.getMinimumRowHeight()) {

				System.out.println("### newRowHeight: " + newHeight);

				int row = da.index;
				table.setRowHeight(row, newHeight);
			}
		}
	}

	ScrollPane getNode() {
		return node;
	}

	GridPane getGrid() {
		return grid;
	}

	double getRowHeight(int row) {
		return grid.getRowConstraints().get(row).getPrefHeight();
	}

	void setRowheight(int row, double height) {
		grid.getRowConstraints().get(row).setPrefHeight(height);
	}

	private void updateRowNumbers() {
		for (int row = 0; row < table.getRowCount(); row++) {
			DragAnchor da = getDragAnchor(row);
			if (da != null) {
				da.index = row;
			}
		}
	}

	private DragAnchor getDragAnchor(int row) {
		Node n = RcplTableUtil.getNode(row, 0, grid);
		if (n != null) {
			return (DragAnchor) n.getUserData();
		}
		return null;
	}
}
