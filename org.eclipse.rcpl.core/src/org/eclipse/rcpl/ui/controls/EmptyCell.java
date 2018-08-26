package org.eclipse.rcpl.ui.controls;

import java.util.List;
import java.util.Optional;

import org.controlsfx.control.spreadsheet.SpreadsheetCell;
import org.controlsfx.control.spreadsheet.SpreadsheetCellType;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableSet;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Node;
import javafx.scene.control.MenuItem;

/**
 * @author Ramin
 *
 */
public class EmptyCell implements SpreadsheetCell {

	private int row;
	private int column;
	private int rowSpan = 1;
	private int colSpan = 1;

	public EmptyCell(int row, int column) {
		this.row = row;
		this.column = column;
	}

	@Override
	public boolean match(SpreadsheetCell cell) {
		return false;
	}

	@Override
	public void setItem(Object value) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getItem() {
		return null;
	}

	@Override
	public ObjectProperty<Object> itemProperty() {
		return null;
	}

	@Override
	public boolean isEditable() {
		return false;
	}

	@Override
	public void setEditable(boolean editable) {
	}

	@Override
	public boolean isWrapText() {
		return false;
	}

	@Override
	public void setWrapText(boolean wrapText) {
	}

	@Override
	public boolean hasPopup() {
		return false;
	}

	@Override
	public void setHasPopup(boolean value) {
	}

	@Override
	public List<MenuItem> getPopupItems() {
		return null;
	}

	@Override
	public void setStyle(String style) {
	}

	@Override
	public String getStyle() {
		return "";
	}

	@Override
	public StringProperty styleProperty() {
		return null;
	}

	@Override
	public void activateCorner(CornerPosition position) {
	}

	@Override
	public void deactivateCorner(CornerPosition position) {
	}

	@Override
	public boolean isCornerActivated(CornerPosition position) {
		return false;
	}

	@Override
	public StringProperty formatProperty() {
		return null;
	}

	@Override
	public String getFormat() {
		return null;
	}

	@Override
	public void setFormat(String format) {
	}

	@Override
	public ReadOnlyStringProperty textProperty() {
		return null;
	}

	@Override
	public String getText() {
		return "";
	}

	@Override
	public SpreadsheetCellType getCellType() {
		return SpreadsheetCellType.STRING;
	}

	@Override
	public int getRow() {
		return row;
	}

	@Override
	public int getColumn() {
		return column;
	}

	@Override
	public int getRowSpan() {
		return rowSpan;
	}

	@Override
	public void setRowSpan(int rowSpan) {
		this.rowSpan = rowSpan;
	}

	@Override
	public int getColumnSpan() {
		return colSpan;
	}

	@Override
	public void setColumnSpan(int columnSpan) {
		this.colSpan = columnSpan;
	}

	@Override
	public ObservableSet<String> getStyleClass() {
		return null;
	}

	@Override
	public ObjectProperty<Node> graphicProperty() {
		return null;
	}

	@Override
	public void setGraphic(Node graphic) {
	}

	@Override
	public Node getGraphic() {
		return null;
	}

	@Override
	public Optional<String> getTooltip() {
		return null;
	}

	@Override
	public void addEventHandler(EventType<Event> eventType, EventHandler<Event> eventHandler) {
	}

	@Override
	public void removeEventHandler(EventType<Event> eventType, EventHandler<Event> eventHandler) {
	}

}
