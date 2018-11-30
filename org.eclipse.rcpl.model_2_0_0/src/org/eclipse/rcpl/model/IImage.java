package org.eclipse.rcpl.model;

import java.io.File;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @author ramin
 *
 */
public interface IImage {

	boolean isError();

	Image getImage();

	ImageView getNode();

	ImageView getCopyNode();

	Rectangle2D getBounds();

	boolean isSvg();

	boolean isGray();

	void setGray(boolean gray);

	double getWidth();

	double getHeight();

	void setWidth(double width);

	void setHeight(double height);

	void setSvg(boolean svg);

	File getPngFile();

}
