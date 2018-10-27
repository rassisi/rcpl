package org.eclipse.rcpl;

import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.TextFlow;

/**
 * @author ramin
 *
 */
public interface IParagraphFigure extends ILayoutFigure {

	void updateIndent();

	void deactivateAll();

	void activate(MouseEvent event);

	void showColumnBreakLabel(boolean show);

	void process_LEFT(KeyEvent event);

	void process_BACKSPACE();

	void process_DELETE();

	void setAlignment(AlignType type);

	Pane getCaretPane();

	TextFlow getTextFlow();

	void updateHeightAndLayoutAndWait();

	void layoutChildrenSpecial(IPage page, double x);

	void processMouseEvent(MouseEvent event);

	void processKeyTyped(KeyEvent event);

	void processKeyPressed(KeyEvent event);

	double getFirstLineHeight();

	void activate(double x, double y);

	Rectangle2D calculateCaret();

	Rectangle2D calculateCaret(int offset);

	@Override
	void deActivate();

	Node getActualText();

	@Override
	IParagraph getLayoutObject();

	IParagraph getParagraph();

	int getSelectionEnd();

	int getSelectionLength();

	int getSelectionStart();

	boolean hasSelection();

	void insertText(IParagraph p, String c);

	@Override
	void setParentFigure(ILayoutFigure node);

	void setText(String text, IStyle style, IStyle[] styles);

	@Override
	void setVisible(boolean visible);

	@Override
	void setWidth(double w);

	void unselect();

	void updateCaret();

	@Override
	void updateLocation();

	void updateSelection();

	void updateTools();

}
