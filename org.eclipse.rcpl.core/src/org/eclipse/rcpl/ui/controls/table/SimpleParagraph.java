package org.eclipse.rcpl.ui.controls.table;

import org.eclipse.rcpl.DelayedExecution;
import org.eclipse.rcpl.IColorProperty;
import org.eclipse.rcpl.IParagraphFigure;

import javafx.geometry.Rectangle2D;

/**
 * @author Ramin
 *
 */
public class SimpleParagraph extends RcplAbstractParagraph {

	private String text;

	public SimpleParagraph(String text) {
		this.text = text;
	}

	@Override
	public boolean isStartNewSection() {

		return false;
	}

	@Override
	public IColorProperty getLineColorProperty() {

		return null;
	}

	@Override
	public void boundsChanged2(Rectangle2D newBounds) {

	}

	@Override
	public boolean commit() {

		return false;
	}

	@Override
	public IParagraphFigure createLayoutFigure() {
		return new SimpleParagraphFigure(this);
	}

	@Override
	public boolean dispose() {
		return false;
	}

	private IParagraphFigure layoutFigure;

	@Override
	public IParagraphFigure getLayoutFigure() {
		if (layoutFigure == null) {
			layoutFigure = createLayoutFigure();
		}
		return layoutFigure;
	}

	@Override
	public void activate() {
		new DelayedExecution(30) {

			@Override
			protected void execute() {
				getLayoutFigure().activate();
			}
		};
	}

	@Override
	public String getText() {
		return text;
	}

	@Override
	public double getHeight() {
		return getLayoutFigure().getHeight();
	}

	@Override
	public double getWidth() {
		return 60;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public double getHeightPixel() {
		double h = getLayoutFigure().getHeight();
		return h;
	}

	@Override
	public void setCellInfo(RcplCellInfo cellInfo) {
		// TODO Auto-generated method stub

	}

	@Override
	public RcplCellInfo getCellInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
