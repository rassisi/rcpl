package org.eclipse.rcpl;

import java.util.List;

import org.eclipse.rcpl.ui.action.RcplAction;

import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * @author ramin
 *
 */
public interface ILayoutFigure extends IPane {

	double updateVAnchor();

	void setStroke(Color color);

	void setStrokeWidth(double width);

	void changeBounds(double layoutX, double layoutY, double width, double height);

	void addKeyHandler(Pane pane);

	void handleMouseDragged(MouseEvent me);

	void handleMousePressed(MouseEvent me);

	void handleMouseReleased();

	boolean isActivated();

	void activate();

	VBox getvAlignBox();

	void setVAlignment(Pos alignment);

	void dispose();

	void updateRootLocation();

	void setFill(Color color);

	void deActivate();

	Canvas getCanvas();

	void add(ILayoutFigure layoutFigure);

	void clipFigure();

	void detach();

	double getColumnX();

	List<ILayoutFigure> getFigureChildren();

	List<ILayoutFigure> getLayoutFigures();

	ILayoutObject getLayoutObject();

	Pane getNode();

	double getOverflowExcess();

	double getOverflowHeight(LayoutData layoutData);

	Point2D getOverflowLocation();

	@Override
	Pane getPane();

	ILayoutFigure getParentFigure();

	double getRemaining();

	/**
	 * Coordinates of the editor
	 * 
	 */
	double getX2();

	/**
	 * Coordinates of the editor
	 *
	 */
	double getY2();

	boolean isCloned();

	boolean isInFooter();

	boolean isInHeader();

	boolean isOverflowFigure();

	void refresh();

	void refreshOutline();

	void remove(ILayoutFigure layoutFigure);

	void setCloned(boolean cloned);

	void setColumnX(double x);

	void setInFooter(boolean inFooter);

	void setInHeader(boolean inHeader);

	boolean setLocation(double x, double y);

	void setOverflowExcess(double excess, double remaining);

	void setOverflow(boolean overflow);

	void setParentFigure(ILayoutFigure figure);

	void setPict(IPict pict);

	void setStyle(String style);

	void setTextBox(boolean textBox);

	void setVisible(boolean visible);

	void setZOrder(RcplAction action);

	void showOutline(boolean show);

	void updateAnchorPosition();

	void updateFx();

	void updateLocation();

	void updateSelection(Rectangle selectionRectangle);

	public void setRotation(double angle);

}
