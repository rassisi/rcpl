package org.eclipse.rcpl.ui.controls.table;

import java.util.List;

import org.eclipse.rcpl.AlignType;
import org.eclipse.rcpl.ILayoutFigure;
import org.eclipse.rcpl.IPage;
import org.eclipse.rcpl.IParagraph;
import org.eclipse.rcpl.IParagraphFigure;
import org.eclipse.rcpl.IPict;
import org.eclipse.rcpl.LayoutData;
import org.eclipse.rcpl.internal.tools.IStyle;
import org.eclipse.rcpl.ui.action.RcplAction;

import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextFlow;

/**
 * @author Ramin
 *
 */
public abstract class RcplAbstractParagraphFigure implements IParagraphFigure {

	@Override
	public double updateVAnchor() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setStroke(Color color) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setStrokeWidth(double width) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changeBounds(double layoutX, double layoutY, double width, double height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addKeyHandler(Pane pane) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isActivated() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void activate() {
		// TODO Auto-generated method stub

	}

	@Override
	public VBox getvAlignBox() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setVAlignment(Pos alignment) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateRootLocation() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFill(Color color) {
		// TODO Auto-generated method stub

	}

	@Override
	public Canvas getCanvas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(ILayoutFigure layoutFigure) {
		// TODO Auto-generated method stub

	}

	@Override
	public void clipFigure() {
		// TODO Auto-generated method stub

	}

	@Override
	public void detach() {
		// TODO Auto-generated method stub

	}

	@Override
	public double getColumnX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ILayoutFigure> getFigureChildren() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ILayoutFigure> getLayoutFigures() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pane getNode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getOverflowExcess() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getOverflowHeight(LayoutData layoutData) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Point2D getOverflowLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pane getPane() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ILayoutFigure getParentFigure() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getRemaining() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getX2() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getY2() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isCloned() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInFooter() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInHeader() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isOverflowFigure() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub

	}

	@Override
	public void refreshOutline() {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(ILayoutFigure layoutFigure) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCloned(boolean cloned) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setColumnX(double x) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setInFooter(boolean inFooter) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setInHeader(boolean inHeader) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean setLocation(double x, double y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setOverflowExcess(double excess, double remaining) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setOverflow(boolean overflow) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPict(IPict pict) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setStyle(String style) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTextBox(boolean textBox) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setZOrder(RcplAction action) {
		// TODO Auto-generated method stub

	}

	@Override
	public void showOutline(boolean show) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateAnchorPosition() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateFx() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateSelection(Rectangle selectionRectangle) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setRotation(double angle) {
		// TODO Auto-generated method stub

	}

	@Override
	public double getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setHeight(double height) {
		// TODO Auto-generated method stub

	}

	@Override
	public Point2D getCenter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateLineSpacing() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateBorder() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getBulletNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setBulletNumber(int number) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateIndentAndBullets() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deactivateAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public void activate(MouseEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void showColumnBreakLabel(boolean show) {
		// TODO Auto-generated method stub

	}

	@Override
	public void process_LEFT(KeyEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void process_BACKSPACE() {
		// TODO Auto-generated method stub

	}

	@Override
	public void process_DELETE() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAlignment(AlignType type) {
		// TODO Auto-generated method stub

	}

	@Override
	public Pane getCaretPane() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TextFlow getTextFlow() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateHeightAndLayoutAndWait() {
		// TODO Auto-generated method stub

	}

	@Override
	public void layoutChildrenSpecial(IPage page, double x) {
		// TODO Auto-generated method stub

	}

	@Override
	public void processMouseEvent(MouseEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void processKeyTyped(KeyEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void processKeyPressed(KeyEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public double getFirstLineHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void activate(double x, double y) {
		// TODO Auto-generated method stub

	}

	@Override
	public Rectangle2D calculateCaret() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangle2D calculateCaret(int offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deActivate() {
		// TODO Auto-generated method stub

	}

	@Override
	public Node getActualText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IParagraph getLayoutObject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IParagraph getParagraph() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSelectionEnd() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSelectionLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSelectionStart() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean hasSelection() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void insertText(IParagraph p, String c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setParentFigure(ILayoutFigure node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setVisible(boolean visible) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setWidth(double w) {
		// TODO Auto-generated method stub

	}

	@Override
	public void unselect() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCaret() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateLocation() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateSelection() {
		// TODO Auto-generated method stub

	}

	@Override
	public void replaceSelectedText(String replacment) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changeCase() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setText(String text, IStyle style, List<IStyle> styles) {
		// TODO Auto-generated method stub

	}

}
