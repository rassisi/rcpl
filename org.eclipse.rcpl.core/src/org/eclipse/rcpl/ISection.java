package org.eclipse.rcpl;

public interface ISection extends ILayoutObject {

	void setPageSize(EnPageSize pageSize);

	void setPageSize(double width, double height);

	@Override
	double getBottomMargin();

	double getTopMarginPixel(int page);

	double getBottomMarginPixel(int page);

	@Override
	double getLeftMargin();

	int getNumberOfcolumns();

	double getColumnSpace();

	double getClientPageWidth();

	boolean isEven();

	boolean isOdd();

	@Override
	double getRightMargin();

	EnPageSize getPageSize();

	boolean isNextPage();

	double getPageWidth();

	double getPageHeight();

	IColor getBackgroundColor();

	IProperty2 getvAlignment();

}
