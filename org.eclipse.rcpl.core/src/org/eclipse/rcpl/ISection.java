package org.eclipse.rcpl;

public interface ISection extends ILayoutObject {

	IColor getBackgroundColor();

	@Override
	double getBottomMargin();

	double getBottomMarginPixel(int page);

	double getClientPageWidth();

	double getColumnSpace();

	@Override
	double getLeftMargin();

	int getNumberOfcolumns();

	double getPageHeight();

	EnPageSize getPageSize();

	double getPageWidth();

	@Override
	double getRightMargin();

	double getTopMarginPixel(int page);

	IProperty2 getvAlignment();

	boolean isEven();

	boolean isLandscape();

	boolean isNextPage();

	boolean isOdd();

	void setLandscape(boolean landscape);

	void setPageSize(double width, double height);

	void setPageSize(EnPageSize pageSize);

}
