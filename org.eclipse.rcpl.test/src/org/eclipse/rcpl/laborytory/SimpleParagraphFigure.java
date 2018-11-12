package org.eclipse.rcpl.laborytory;

import java.util.List;

import org.eclipse.rcpl.AlignType;
import org.eclipse.rcpl.ILayoutFigure;
import org.eclipse.rcpl.IPage;
import org.eclipse.rcpl.IParagraph;
import org.eclipse.rcpl.IParagraphFigure;
import org.eclipse.rcpl.IPict;
import org.eclipse.rcpl.IStyle;
import org.eclipse.rcpl.LayoutData;
import org.eclipse.rcpl.ui.action.RcplAction;

import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextFlow;

/**
 * @author Ramin
 *
 */
public class SimpleParagraphFigure implements IParagraphFigure {

	private SimpleParagraph paragraph;

	private StackPane node;

	public SimpleParagraphFigure(SimpleParagraph paragraph) {
		this.paragraph = paragraph;
		this.node = new StackPane();
		this.node.getChildren().add(new TextField(paragraph.getText()));
	}

	@Override
	public double getWidth() {
		return 100;
	}

	@Override
	public double getHeight() {
		return 20;
	}

	@Override
	public void setWidth(double width) {
	}

	@Override
	public void setHeight(double height) {
	}

	@Override
	public Point2D getCenter() {
		return null;
	}

	@Override
	public double updateVAnchor() {
		return 0;
	}

	@Override
	public void setStroke(Color color) {
	}

	@Override
	public void setStrokeWidth(double width) {
	}

	@Override
	public void changeBounds(double layoutX, double layoutY, double width, double height) {
	}

	@Override
	public void addKeyHandler(Pane pane) {
	}

	@Override
	public void handleMouseDragged(MouseEvent me) {
	}

	@Override
	public void handleMousePressed(MouseEvent me) {
	}

	@Override
	public void handleMouseReleased() {
	}

	@Override
	public boolean isActivated() {
		return false;
	}

	@Override
	public void activate() {
	}

	@Override
	public VBox getvAlignBox() {
		return null;
	}

	@Override
	public void setVAlignment(Pos alignment) {
	}

	@Override
	public void dispose() {
	}

	@Override
	public void updateRootLocation() {
	}

	@Override
	public void setFill(Color color) {
	}

	@Override
	public void deActivate() {
	}

	@Override
	public Canvas getCanvas() {
		return null;
	}

	@Override
	public void add(ILayoutFigure layoutFigure) {
	}

	@Override
	public void clipFigure() {

	}

	@Override
	public void detach() {

	}

	@Override
	public double getColumnX() {

		return 0;
	}

	@Override
	public List<ILayoutFigure> getFigureChildren() {

		return null;
	}

	@Override
	public List<ILayoutFigure> getLayoutFigures() {

		return null;
	}

	@Override
	public IParagraph getLayoutObject() {
		return paragraph;
	}

	@Override
	public Pane getNode() {
		return node;
	}

	@Override
	public double getOverflowExcess() {

		return 0;
	}

	@Override
	public double getOverflowHeight(LayoutData layoutData) {

		return 0;
	}

	@Override
	public Point2D getOverflowLocation() {

		return null;
	}

	@Override
	public Pane getPane() {

		return null;
	}

	@Override
	public ILayoutFigure getParentFigure() {

		return null;
	}

	@Override
	public double getRemaining() {

		return 0;
	}

	@Override
	public double getX2() {

		return 0;
	}

	@Override
	public double getY2() {

		return 0;
	}

	@Override
	public boolean isCloned() {

		return false;
	}

	@Override
	public boolean isInFooter() {

		return false;
	}

	@Override
	public boolean isInHeader() {

		return false;
	}

	@Override
	public boolean isOverflowFigure() {

		return false;
	}

	@Override
	public void refresh() {

	}

	@Override
	public void refreshOutline() {

	}

	@Override
	public void remove(ILayoutFigure layoutFigure) {

	}

	@Override
	public void setCloned(boolean cloned) {

	}

	@Override
	public void setColumnX(double x) {

	}

	@Override
	public void setInFooter(boolean inFooter) {

	}

	@Override
	public void setInHeader(boolean inHeader) {

	}

	@Override
	public boolean setLocation(double x, double y) {

		return false;
	}

	@Override
	public void setOverflowExcess(double excess, double remaining) {

	}

	@Override
	public void setOverflow(boolean overflow) {

	}

	@Override
	public void setParentFigure(ILayoutFigure figure) {

	}

	@Override
	public void setPict(IPict pict) {

	}

	@Override
	public void setStyle(String style) {

	}

	@Override
	public void setTextBox(boolean textBox) {

	}

	@Override
	public void setVisible(boolean visible) {

	}

	@Override
	public void setZOrder(RcplAction action) {

	}

	@Override
	public void showOutline(boolean show) {

	}

	@Override
	public void updateAnchorPosition() {

	}

	@Override
	public void updateFx() {

	}

	@Override
	public void updateLocation() {

	}

	@Override
	public void updateSelection(Rectangle selectionRectangle) {

	}

	@Override
	public void setRotation(double angle) {

	}

	@Override
	public void updateLineSpacing() {
	}

	@Override
	public void updateBorder() {
	}

	@Override
	public int getBulletNumber() {
		return 0;
	}

	@Override
	public void setBulletNumber(int number) {
	}

	@Override
	public void updateIndentAndBullets() {
	}

	@Override
	public void deactivateAll() {
	}

	@Override
	public void activate(MouseEvent event) {
	}

	@Override
	public void showColumnBreakLabel(boolean show) {
	}

	@Override
	public void process_LEFT(KeyEvent event) {
	}

	@Override
	public void process_BACKSPACE() {
	}

	@Override
	public void process_DELETE() {
	}

	@Override
	public void setAlignment(AlignType type) {
	}

	@Override
	public Pane getCaretPane() {
		return null;
	}

	@Override
	public TextFlow getTextFlow() {
		return null;
	}

	@Override
	public void updateHeightAndLayoutAndWait() {
	}

	@Override
	public void layoutChildrenSpecial(IPage page, double x) {
	}

	@Override
	public void processMouseEvent(MouseEvent event) {

	}

	@Override
	public void processKeyTyped(KeyEvent event) {

	}

	@Override
	public void processKeyPressed(KeyEvent event) {

	}

	@Override
	public double getFirstLineHeight() {

		return 0;
	}

	@Override
	public void activate(double x, double y) {

	}

	@Override
	public Rectangle2D calculateCaret() {

		return null;
	}

	@Override
	public Rectangle2D calculateCaret(int offset) {

		return null;
	}

	@Override
	public Node getActualText() {

		return null;
	}

	@Override
	public IParagraph getParagraph() {

		return null;
	}

	@Override
	public int getSelectionEnd() {

		return 0;
	}

	@Override
	public int getSelectionLength() {

		return 0;
	}

	@Override
	public int getSelectionStart() {

		return 0;
	}

	@Override
	public boolean hasSelection() {

		return false;
	}

	@Override
	public void insertText(IParagraph p, String c) {

	}

	@Override
	public void setText(String text, IStyle style, IStyle[] styles) {

	}

	@Override
	public void unselect() {

	}

	@Override
	public void updateCaret() {

	}

	@Override
	public void updateSelection() {

	}

	@Override
	public void updateTools() {

	}

}
