package org.eclipse.rcpl.images;

import java.io.InputStream;

/**
 * @author ramin
 *
 */
public class SVGImage extends RcplImage {

	public SVGImage(String path, double width, double height) {
		super(path, width, height);
		setSvg(true);
	}

	public SVGImage(InputStream is, String id, double width, double height) {
		super(is, id, width, height);
		setSvg(true);
	}

}
