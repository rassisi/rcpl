package org.eclipse.rcpl.ui.controls.table;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

/**
 * @author Ramin
 *
 */
public class RcplCellTable {

	private RcplTable table;

	private GridPane grid;

	private Node node;

	private ScrollPane scrollPane;

	private boolean mouseDown;

	/**
	 * @param table
	 */
	public RcplCellTable(RcplTable table) {

		this.table = table;
		this.grid = new GridPane();

		grid.setHgap(0);
		grid.setVgap(0);

		grid.setGridLinesVisible(table.isDEBUG());

		if (table.isSpreadsheet()) {
			scrollPane = new ScrollPane();
			scrollPane.setContent(grid);
			node = scrollPane;
		} else {
			node = grid;
		}

//		for (int row = 0; row < this.table.getRowCount(); row++) {
//			insertRow();
//		}
//
//		for (int column = 0; column < table.getColumnCount(); column++) {
//			insertColumn();
//		}

	}

	void insertRow() {
		insertRow(-1);
	}

	void insertRow(int row) {
		RowConstraints rc = new RowConstraints();
		rc.setPrefHeight(IRcplTableConstants.DEFAULT_ROW_HEIGHT);
		rc.setMinHeight(IRcplTableConstants.DEFAULT_ROW_HEIGHT);
		rc.setMaxHeight(IRcplTableConstants.DEFAULT_ROW_HEIGHT);
		if (row == -1) {
			grid.getRowConstraints().add(rc);
		} else {
			grid.getRowConstraints().add(row, rc);
		}

		if (row == -1) {
			row = table.getRowCount() - 1;
		}
		if (!table.isSpreadsheet()) { // && row > 0) {
			createVerticalRuler(row);
		}

	}

	void insertColumn() {
		insertColumn(-1);
	}

	void insertColumn(int column) {

		ColumnConstraints rc = new ColumnConstraints();
		rc.setPrefWidth(IRcplTableConstants.DEFAULT_CELL_WIDTH);
		rc.setMinWidth(IRcplTableConstants.DEFAULT_CELL_WIDTH);
		rc.setMaxWidth(IRcplTableConstants.DEFAULT_CELL_WIDTH);
		if (column == -1) {
			grid.getColumnConstraints().add(rc);
		} else {
			grid.getColumnConstraints().add(column, rc);
		}

		if (column == -1) {
			column = table.getColumnCount() - 1;
		}
		if (!table.isSpreadsheet()) {
			createColumnRuler(column);
		}

	}

	private void createColumnRuler(int col) {

		final int column;

		if (col == -1) {
			column = table.getColumnCount() - 1;
		} else {
			column = col;
		}
		VBox vbox = table.createBackgroundPane(grid, 0, column, true);
		HBox hbox = (HBox) vbox.getParent();
		Pane sizer = new Pane();
		DragAnchor da = new DragAnchor();
		sizer.setUserData(da);

		sizer.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				node.setCursor(Cursor.E_RESIZE);
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
				((DragAnchor) sizer.getUserData()).index = column;
				da.startSize = getColumnWidth(column);
				me.consume();
			}
		});

		sizer.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent me) {
				handleMouseDragged(me, sizer);
			}
		});

		sizer.setPrefWidth(5);
		sizer.setMinWidth(5);
		sizer.setMaxWidth(5);

		hbox.getChildren().add(sizer);
	}

	public void handleMouseDragged(MouseEvent me, Pane sp) {
		DragAnchor da = (DragAnchor) sp.getUserData();
		if (da != null) {
			double diffX = me.getSceneX() - da.dragAnchor.getX();
			double newWidth = Math.max(10, da.startSize + diffX);
			setColumnWidth(da.index, newWidth);
			sp.setPrefHeight(newWidth);
			table.setColumnWidth(da.index, newWidth);
		}
	}

	private void createVerticalRuler(int row0) {

		final int row;

		if (row0 == -1) {
			row = table.getRowCount() - 1;
		} else {
			row = row0;
		}

		if (row == 0) {
			BorderPane bp = table.getTopLeftCellPane();
			bp.setBottom(createverticalSizer(row));
		} else {
			VBox vbox = table.createBackgroundPane(grid, row, 0);
			vbox.setStyle("-fx-border-color: blue");
			vbox.getChildren().add(createverticalSizer(row));
		}
	}

	private Pane createverticalSizer(int row) {
		Pane sizer = new Pane();
		DragAnchor da = new DragAnchor();
		sizer.setUserData(da);
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
				((DragAnchor) sizer.getUserData()).index = row;
				da.startSize = getRowHeight(row);
				me.consume();
			}
		});

		sizer.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent me) {
				handleVerticalMouseDragged(me, sizer);
			}
		});

		sizer.setPrefHeight(5);
		sizer.setMinHeight(5);
		sizer.setMaxHeight(5);
		return sizer;
	}

	public void handleVerticalMouseDragged(MouseEvent me, Pane sp) {
		DragAnchor da = (DragAnchor) sp.getUserData();
		if (da != null) {
			double diffY = me.getSceneY() - da.dragAnchor.getY();
			double newHeight = Math.max(10, da.startSize + diffY);
			sp.setPrefHeight(newHeight);
			table.setRowHeight(da.index, newHeight);
		}
	}

	private double getColumnWidth(int column) {
		return grid.getColumnConstraints().get(column).getPrefWidth();
	}

	private double getRowHeight(int row) {
		return grid.getRowConstraints().get(row).getPrefHeight();
	}

	Node getNode() {
		return node;
	}

	ScrollPane getScrollPane() {
		if (table.isSpreadsheet()) {
			return (ScrollPane) node;
		}
		return null;
	}

	public GridPane getGrid() {
		return grid;
	}

	void setColumnWidth(int column, double width) {
		grid.getColumnConstraints().get(column).setPrefWidth(width);
		grid.getColumnConstraints().get(column).setMinWidth(width);
		grid.getColumnConstraints().get(column).setMaxWidth(width);
	}

	void setRowheight(int row, double height) {
		grid.getRowConstraints().get(row).setPrefHeight(height);
		grid.getRowConstraints().get(row).setMinHeight(height);
		grid.getRowConstraints().get(row).setMaxHeight(height);
	}

	void showGridLines(boolean show) {
		grid.setGridLinesVisible(show);
	}

}
