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
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.TextAlignment;

/**
 * @author Ramin
 *
 */
public class RcplTableHeader {

	private GridPane grid;

	private Pane node;

	private RcplTable table;

	private ScrollPane scrollPane;

	private StackPane topLeftPane;

	private boolean mouseDown;

	/**
	 * @param table
	 */
	public RcplTableHeader(RcplTable table) {
		this.table = table;
		node = new HBox();
		node.setPrefHeight(IRcplTableConstants.DEFAULT_ROW_HEIGHT);
		node.setMinHeight(IRcplTableConstants.DEFAULT_ROW_HEIGHT);
		node.setMaxHeight(IRcplTableConstants.DEFAULT_ROW_HEIGHT);

		scrollPane = new ScrollPane();
		scrollPane.setPrefHeight(IRcplTableConstants.DEFAULT_ROW_HEIGHT);
		scrollPane.setMinHeight(IRcplTableConstants.DEFAULT_ROW_HEIGHT);
		scrollPane.setMaxHeight(IRcplTableConstants.DEFAULT_ROW_HEIGHT);
		if (table.isSpreadsheet()) {
			node.setPadding(new Insets(0, 16, 0, 0));
		}
		scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
		scrollPane.setVbarPolicy(ScrollBarPolicy.NEVER);
		grid = new GridPane();
		grid.setGridLinesVisible(true);
		scrollPane.setContent(grid);

		topLeftPane = new StackPane();
		topLeftPane.setMinWidth(IRcplTableConstants.DEFAULT_ROW_RULER_WIDTH);
		topLeftPane.setPrefWidth(IRcplTableConstants.DEFAULT_ROW_RULER_WIDTH);
		topLeftPane.setMaxWidth(IRcplTableConstants.DEFAULT_ROW_RULER_WIDTH);
		topLeftPane.setStyle("-fx-background-color: lightgray");
		node.getChildren().addAll(topLeftPane, scrollPane);

		createCells();
	}

	private void createCells() {
		for (int column = 0; column < table.getColumnCount(); column++) {
			insertColumn(column);
		}
	}

	void insertColumn() {
		insertColumn(table.getColumnCount() - 1);
	}

	void insertColumn(final int column) {
		final StackPane sp = new StackPane();
		DragAnchor da = new DragAnchor();
		sp.setUserData(da);
		sp.setPrefSize(IRcplTableConstants.DEFAULT_CELL_WIDTH, IRcplTableConstants.DEFAULT_ROW_HEIGHT);
		HBox hbox = new HBox();
//		hbox.setStyle("-fx-border-color: blue;");
		sp.getChildren().add(hbox);
		Label l = new Label();
		l.setTextAlignment(TextAlignment.CENTER);
		l.setAlignment(Pos.CENTER);
		l.setPrefWidth(10000);
		hbox.getChildren().add(l);

		Pane sizer = new Pane();

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
				((DragAnchor) sp.getUserData()).index = column;
				da.startSize = getColumnWidth(column);
				me.consume();
			}
		});

		sizer.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent me) {
				handleMouseDragged(me, sp);
			}
		});

		sizer.setPrefWidth(5);
		sizer.setMinWidth(5);
		sizer.setMaxWidth(5);
		hbox.getChildren().add(sizer);
		if (table.isSpreadsheet()) {
			l.setText(RcplTableUtil.calculateColumnName(column));
		}
		grid.add(sp, column, 0);

		ColumnConstraints cc = new ColumnConstraints();
		cc.setPrefWidth(IRcplTableConstants.DEFAULT_CELL_WIDTH);
		grid.getColumnConstraints().add(cc);
		updateColumnNumbers();
	}

	public void handleMouseDragged(MouseEvent me, StackPane sp) {
		DragAnchor da = (DragAnchor) sp.getUserData();
		if (da != null) {
			double diffX = me.getSceneX() - da.dragAnchor.getX();
			double newWidth = Math.max(10, da.startSize + diffX);
			setColumnWidth(da.index, newWidth);
			sp.setPrefHeight(newWidth);
			table.setColumnWidth(da.index, newWidth);
			me.consume();
		}
	}

	void setColumnWidth(int column, double width) {
		grid.getColumnConstraints().get(column).setPrefWidth(width);
	}

	private double getColumnWidth(int column) {
		return grid.getColumnConstraints().get(column).getPrefWidth();
	}

	Pane getNode() {
		return node;
	}

	ScrollPane getScrollPane() {
		return scrollPane;
	}

	GridPane getGrid() {
		return grid;
	}

	private void updateColumnNumbers() {
		for (int col = 0; col < table.getColumnCount(); col++) {
			DragAnchor da = getDragAnchor(col);
			if (da != null) {
				da.index = col;
			}
		}
	}

	private DragAnchor getDragAnchor(int column) {
		Node n = RcplTableUtil.getNode(0, column, grid);
		if (n != null) {
			return (DragAnchor) n.getUserData();
		}
		return null;
	}
}
