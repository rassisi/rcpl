package org.eclipse.rcpl.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.scene.Group;
import javafx.scene.Node;

public class RcplResizableAndDraggableStackPaneSelectionModel {

	Group selectionLayer;
	Map<Node, RcplResizableAndDraggableStackPaneSelectionOverlay> map = new HashMap<Node, RcplResizableAndDraggableStackPaneSelectionOverlay>();

	List<Node> selection = new ArrayList<>();

	public RcplResizableAndDraggableStackPaneSelectionModel(Group layoutBoundsOverlay) {
		this.selectionLayer = layoutBoundsOverlay;
	}

	public void add(Node node) {
		if (selection.contains(node))
			return;
		RcplResizableAndDraggableStackPaneSelectionOverlay selectionOverlay = new RcplResizableAndDraggableStackPaneSelectionOverlay(
				node);
		map.put(node, selectionOverlay);
		selectionLayer.getChildren().add(selectionOverlay);
		selection.add(node);
	}

	public void remove(Node cell) {
		removeOverlay(cell);
		selection.remove(cell);
	}

	private void removeOverlay(Node cell) {
		RcplResizableAndDraggableStackPaneSelectionOverlay boundsDisplay = map.get(cell);
		if (boundsDisplay != null) {
			selectionLayer.getChildren().remove(boundsDisplay);
		}
	}

	public void clear() {
		for (Node node : selection) {
			removeOverlay(node);
		}
		selection.clear();
	}

	public boolean isEmpty() {
		return selection.isEmpty();
	}

	public boolean contains(Node cell) {
		return selection.contains(cell);
	}

	public List<Node> getSelection() {
		return selection;
	}

}