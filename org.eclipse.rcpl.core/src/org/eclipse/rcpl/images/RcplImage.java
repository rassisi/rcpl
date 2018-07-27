/*******************************************************************************
 * Copyright (c) 2003 - 2014 Ramin Assisi and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     Ramin Assisi - initial implementation
 *******************************************************************************/
package org.eclipse.rcpl.images;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.eclipse.rcpl.Rcpl;
import org.eclipse.rcpl.application.DefaultMobileProvider;
import org.eclipse.rcpl.model.IImage;
import org.eclipse.rcpl.model.RCPLModel;
import org.eclipse.rcpl.model.cdo.client.RcplSession;
import org.eclipse.rcpl.util.RcplUtil;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @author ramin
 *
 */
public class RcplImage implements IImage {

	private Image image;

	private InputStream is;

	private URL SvgUrl;

	private URL pngUrl;

	private String id;

	private boolean gray;

	private ImageView node;

	private double contrast = 0.0;

	private double hue = 0.0;

	private double brightness = 0.0;

	private double saturation = 0.0;

	private double width = 16;

	private double height = 16;

	private boolean svg;

	private ImageView errorImageNode;

	private Image errorImage;

	private static HashMap<String, IImage> imageRepository = new HashMap<String, IImage>();

	private File pngFile;

	private File errorPngFile;

	/**
	 * @param is
	 * @param id
	 * @param width
	 * @param height
	 */
	public RcplImage(InputStream is, String id, double width, double height) {
		this.is = is;
		this.id = id;
		this.width = width;
		this.height = height;
	}

	/**
	 * @param id
	 * @param width
	 * @param height
	 */
	public RcplImage(String id, double width, double height) {
		this.width = width;
		this.height = height;

		if (id != null && id.startsWith("http")) {
			try {
				SvgUrl = new URL(id);
				String idTemp = SvgUrl.getFile();

				int pos = idTemp.lastIndexOf("/");
				if (pos != -1) {
					idTemp = idTemp.substring(pos + 1, idTemp.length());
				}

				pos = idTemp.lastIndexOf(".");
				if (pos != -1) {
					idTemp = idTemp.substring(0, pos);
				}

				this.id = idTemp;

			} catch (MalformedURLException e) {
				image = getErrorImage();
				node = getErrorNode();
			}
		} else {
			this.id = id;
		}

	}

	@Override
	public ImageView getNode() {

		// ---------- check if already loaded

		if (node == null) {

			// ---------- check if Images is already in the repository

			IImage img = get();
			if (img != null) {
				node = img.getNode();
				Rcpl.println("Image loaded from repository: " + id);
				return node;
			}

			try {

				// ---------- load from input stream

				if (is != null) {
					image = createSvgImage(is, width, height);
					Rcpl.println("SVG Image loaded from stream: " + id);
				}

				// error image (id==null)

				else if (id == null) {
					Rcpl.println("Image loaded from error: (id==null)");
					image = getErrorImage();
				}

				// ---------- image from resource

				else if (createImageFromResource() != null) {
					Rcpl.println("Image loaded from resouce: " + id);

				}

				// ---------- load image from remote

				else if (findPngRemoteImage()) {
					try {
						image = new Image(pngUrl.toString());
						Rcpl.println("Image loaded from Remote: " + id);
					} catch (Throwable ex) {
						writeErrorPngFile();
						image = getErrorImage();
						Rcpl.println("Image loaded from Resource -> ERROR!: " + id);
					}
					if (image.isError()) {
						writeErrorPngFile();
						image = getErrorImage();
						Rcpl.println("Image loaded from Resource -> ERROR (image is error)!: " + id);
					}
				}

				// ---------- check if can be loaded from remote as svg

				else if (findSvgRemoteImage()) {
					image = createSvgImage(SvgUrl.openStream(), width, height);
					svg = true;
				}

				put(id, width, height);

			} catch (Throwable ex) {
				image = getErrorImage();
				writeErrorPngFile();
				put(id, width, height);

			}
		}

		if (image != null) {
			ImageView iv = new ImageView(image);
			iv.setFitWidth(width);
			iv.setFitHeight(height);
			node = iv;
			Rcpl.println("Image could be loaded: " + id);
		} else {
			image = getErrorImage();
			node = getErrorNode();
			Rcpl.println("Image could not be loaded!: " + id);
		}

		return node;

	}

	@Override
	public ImageView getCopyNode() {
		getNode();
		if (image != null) {
			ImageView iv = new ImageView(image);
			iv.setFitWidth(width);
			iv.setFitHeight(height);
			return iv;
		}
		ImageView iv = new ImageView(getErrorImage());
		iv.setFitWidth(width);
		iv.setFitHeight(height);
		return iv;
	}

	private boolean findSvgRemoteImage() {
		try {

			if (SvgUrl != null) {
				String s = SvgUrl.toExternalForm().substring(0, SvgUrl.toExternalForm().length() - 3) + "png";
				pngUrl = new URL(s);
				if (existsAtUrl(SvgUrl)) {
					return true;
				}
				return false;
			}
			for (String codeBase : RcplSession.getImageCodeBases()) {

				if ("Information_icon".equals(id)) {
					System.out.println();
				}

				if (codeBase != null) {
					URL url;
					if (RcplSession.BASE_IMAGE_URL.equals(codeBase)) {
						url = new URL(codeBase + "svg/" + id + ".svg");
					} else {
						url = new URL(codeBase + id + ".svg");
					}

					if (existsAtUrl(url)) {
						SvgUrl = url;
//						pngUrl = new URL(codeBase + "images/" + getWidth() + "_" + getHeight() + "/" + id + ".png");
						return true;
					}
				}

			}
		} catch (Exception ex) {
		}
		return false;
	}

	private boolean findPngRemoteImage() {
		try {

			if (pngUrl != null) {
				if (existsAtUrl(pngUrl)) {
					return true;
				}
				return false;
			}
			for (String codeBase : RcplSession.getImageCodeBases()) {
				if (codeBase != null) {
					URL url;
					if (RcplSession.BASE_IMAGE_URL.equals(codeBase)) {
						url = new URL(codeBase + "images/" + id + ".png");
					} else {
						url = new URL(codeBase + id + ".png");
					}

					if (existsAtUrl(url)) {
						pngUrl = url;
						return true;
					}
				}

			}
		} catch (Exception ex) {
		}
		return false;
	}

//	/**
//	 * @param svgUrl
//	 * @param pngFile
//	 * @param width
//	 * @param height
//	 * @return
//	 */
//	private ImageView createSvgNode(URL url, double width, double height) {
//
//		ImageView iv = null;
//
//		if (url.toString().endsWith(".svg")) {
//			svg = true;
//		}
//
//		if (getPngFile().exists()) {
//			iv = new ImageView(getPngFile().toURI().toString());
//		} else if (getErrorPngFile().exists()) {
//			iv = getErrorNode();
//		} else {
//			try {
//				InputStream is = url.openStream();
//				iv = createBatikNode(is, width, height);
//				if (iv == null) {
//					try {
//						image = new Image(pngUrl.toString());
//					} catch (Throwable ex) {
//						writeErrorPngFile();
//						return getErrorNode();
//					}
//					if (image.isError()) {
//						writeErrorPngFile();
//						return getErrorNode();
//					}
//					iv = new ImageView(image);
//
//				}
//				is.close();
//
//			} catch (Throwable ex) {
//				iv = getErrorNode();
//				writeErrorPngFile();
//			}
//		}
//		iv.setFitWidth(width);
//		iv.setFitHeight(height);
//		return iv;
//	}

//	/**
//	 * Diese Methode wird aus JOImage aufgerufen, um ein Image aus einem PackagePart
//	 * (OOXML) auszulesen.
//	 * 
//	 * @param is
//	 * @param fileName
//	 * @param width
//	 * @param height
//	 * @return
//	 */
//	private ImageView createSvgNodeFromInputStream(InputStream is, double width, double height) {
//
//		if (isSvg()) {
//			ImageView node;
//			try {
//				node = createBatikNode(is, width, height);
//				if (node != null) {
//					return node;
//				}
//			} catch (TranscoderException e) {
//			} catch (IOException e) {
//			}
//			return getErrorNode();
//		} else {
//			try {
//				image = new Image(is);
//				ImageView iv = new ImageView();
//				if (image != null) {
//					iv.setImage(image);
//					iv.setFitWidth(width);
//					iv.setFitHeight(height);
//				}
//				try {
//					is.close();
//				} catch (Exception ex) {
//					// ignore as all images wrong will be saved under the
//					// __ERROR__ folder
//				}
//				return iv;
//			} catch (Exception ex) {
//				return null;
//			}
//		}
//
//	}

	private Image createSvgImage(InputStream is, double width, double height) throws TranscoderException, IOException {
		OutputStream png_ostream;

		TranscoderInput transIn = new TranscoderInput(is);
		png_ostream = new ByteArrayOutputStream();
		TranscoderOutput output_png_image = new TranscoderOutput(png_ostream);
		PNGTranscoder pngTranscoder = new PNGTranscoder();
		pngTranscoder.addTranscodingHint(PNGTranscoder.KEY_HEIGHT, (float) height);
		pngTranscoder.addTranscodingHint(PNGTranscoder.KEY_WIDTH, (float) width);
		pngTranscoder.addTranscodingHint(PNGTranscoder.KEY_XML_PARSER_VALIDATING, false);
		pngTranscoder.transcode(transIn, output_png_image);
		png_ostream.flush();
		png_ostream.close();
		ByteArrayInputStream isImage = new ByteArrayInputStream(((ByteArrayOutputStream) png_ostream).toByteArray());
		image = new Image(isImage);
		if (image != null) {
			svg = true;
		}
		isImage.close();
		isImage = new ByteArrayInputStream(((ByteArrayOutputStream) png_ostream).toByteArray());
		FileOutputStream fos = new FileOutputStream(getPngFile());
		byte[] data = new byte[10000];

		do {
			int length = isImage.read(data);
			if (length == -1) {
				break;
			}
			fos.write(data, 0, length);
		} while (true);

		fos.flush();
		fos.close();

		isImage.close();
		return image;

	}

	@Override
	public Rectangle2D getBounds() {
		return null;
	}

	public double getBrightness() {
		return brightness;
	}

	public double getContrast() {
		return contrast;
	}

	@Override
	public double getHeight() {
		return height;
	}

	public double getHue() {
		return hue;
	}

	public String getId() {
		return id;
	}

	@Override
	public File getPngFile() {
		if (pngFile == null) {
			pngFile = new File(RcplUtil.getUserLocalCacheDir(), "images/" + createPngPath());
			pngFile.getParentFile().mkdirs();
		}
		return pngFile;

	}

	private String createPngPath() {
		return width + "_" + height + "/" + id + ".png";
	}

	private String createSvgPath() {
		return "svg/" + id + ".svg";
	}

	public double getSaturation() {
		return saturation;
	}

	public URL getUrl() {
		return SvgUrl;
	}

	@Override
	public double getWidth() {
		return width;
	}

	protected void imageLoaded() {

	}

	@Override
	public boolean isGray() {
		return gray;
	}

	@Override
	public boolean isSvg() {
		return svg;
	}

	public void setBrightness(double brightness) {
		this.brightness = brightness;
	}

	public void setContrast(double contrast) {
		this.contrast = contrast;
	}

	@Override
	public void setGray(boolean gray) {
		this.gray = gray;
	}

	@Override
	public void setHeight(double height) {
//		try {
//			pngUrl = new URL(RcplSession.getDefault().getCodeBase() + "images/" + getWidth() + "_" + getHeight() + "/"
//					+ id + ".png");
//		} catch (MalformedURLException e) {
//			// ignore
//		}
		this.height = height;
	}

	public void setHue(double hue) {
		this.hue = hue;
	}

	public void setSaturation(double saturation) {
		this.saturation = saturation;
	}

	@Override
	public void setSvg(boolean svg) {
		this.svg = svg;
	}

	@Override
	public void setWidth(double width) {
//		try {
//			pngUrl = new URL(RcplSession.getDefault().getCodeBase() + "images/" + getWidth() + "_" + getHeight() + "/"
//					+ id + ".png");
//		} catch (MalformedURLException e) {
//			// ignore
//		}
		this.width = width;
	}

	/**
	 * This method is for debug purposes: It creates a dummy file to show that a
	 * normal image file was not found.
	 */
	private void writeErrorPngFile() {
		try {
			getErrorPngFile().getParentFile().mkdirs();
			getErrorPngFile().createNewFile();
			Rcpl.println("Image could not be created: " + getErrorPngFile().getName());
		} catch (IOException e) {
		}
	}

	@Override
	public Image getImage() {
		if (image == null) {
			image = getErrorImage();
		}
		return image;
	}

	public static void main(String[] args) {
		RCPLModel.mobileProvider = new DefaultMobileProvider();
		String path = "http://joffice.eu/svg/shape_parallelogram.svg";
		new RcplImage(path, 15, 15).getNode();

	}

	private File getErrorPngFile() {
		if (errorPngFile == null) {
			errorPngFile = new File(RcplUtil.getUserLocalCacheDir(),
					"images/___ERROR___/" + width + "_" + height + "/" + id + ".png");
		}
		return errorPngFile;

	}

	private Image createImageFromResource() {
		String resourcePath = createPngPath();
		Image img = getImageFromResource(resourcePath);
		if (img == null) {
			resourcePath = createSvgPath();
			InputStream is = RcplImage.class.getResourceAsStream(resourcePath);
			if (is != null) {
				try {
					img = createSvgImage(is, width, height);
					Rcpl.println("SVG Image loaded from Resource: " + id);
				} catch (TranscoderException | IOException e) {
				}
			}
			try {
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				// ignore as all images wrong will be saved under the __ERROR__
				// folder
			}
		} else {
			Rcpl.println("Image loaded from Resource: " + id);
		}
		return img;
	}

	private Image getImageFromResource(String resourcePath) {

		InputStream is = RcplImage.class.getResourceAsStream(resourcePath);
		if (is != null) {
			image = new Image(is);
		}
		try {
			if (is != null) {
				is.close();
			}
		} catch (IOException e) {
			// ignore as all images wrong will be saved under the __ERROR__
			// folder
		}
		return image;

	}

	private Image getErrorImage() {
		if (errorImage == null) {
			errorImage = getImageFromResource("16.0_16.0/error.png");
		}
		return errorImage;
	}

	private ImageView getErrorNode() {
		if (errorImageNode == null) {
			errorImageNode = new ImageView(getErrorImage());
			errorImageNode.setFitHeight(height);
			errorImageNode.setFitWidth(width);
		} else {
			errorImageNode = new ImageView(getErrorImage());
		}
		try {
			if (is != null) {
				is.close();
			}
		} catch (IOException e) {
		}
		return errorImageNode;

	}

	private boolean existsAtUrl(URL url) {
		try {
			HttpURLConnection.setFollowRedirects(false);
			// HttpURLConnection.setInstanceFollowRedirects(false)
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("HEAD");
			return (con.getResponseCode() == HttpURLConnection.HTTP_OK);
		} catch (Exception e) {
			return false;
		}
	}

	private void put(String id, double width, double height) {
		imageRepository.put(id + width + height, this);
	}

	private IImage get() {
		return imageRepository.get(id + width + height);
	}

	// @Override
	// public ImageView getImageView() {
	// if (imageView == null) {
	// imageView = new ImageView(getFx());
	// ColorAdjust colorAdjust = new ColorAdjust();
	// colorAdjust.setContrast(contrast);
	// colorAdjust.setHue(hue);
	// colorAdjust.setBrightness(brightness);
	// colorAdjust.setSaturation(saturation);
	// imageView.setEffect(colorAdjust);
	// }
	// return imageView;
	// }

	// WebView wv = new WebView();
	// wv.setMinWidth(width);
	// wv.setPrefWidth(width);
	// wv.setMaxWidth(width);
	// wv.setMinHeight(height);
	// wv.setPrefHeight(height);
	// wv.setMaxHeight(height);
	//
	// URL url = new URL(svgUrl);
	// boolean localFile = "file".equals(url.getProtocol());
	// if (!localFile) {
	// if (!JOSession.getDefault().isReachable() ||
	// !existsAtUrl(svgUrl)) {
	// ImageView iv = getErrorImageNode();
	// iv.setFitWidth(width);
	// iv.setFitHeight(height);
	// return iv;
	// }
	// }

	// StringBuffer sb = new StringBuffer();
	//
	// sb.append(
	//
	// "<head>" + "<title></title>"
	//
	// + "<style type=\"text/css\">"
	//
	// + "#myDiv"
	//
	// + "{"
	//
	// + "height:100%;"
	//
	// + "width:100%;"
	//
	// + "}"
	//
	// + "#myDiv img"
	//
	// + "{"
	//
	// + "width:100%; "
	//
	// + "height:100%;"
	//
	// + "margin:auto;"
	//
	// + "display:block;"
	//
	// + "}" + "</style>" + "</head>"
	//
	// + "<div id=\"myDiv\">"
	//
	// + "<img alt=\"Client Logo\" title=\"Client Logo\""
	//
	// + "src=\"" + svgUrl + "\" />"
	//
	// + "</div>"
	//
	// );
	// wv.getEngine().loadContent(sb.toString());
	//
	// try {
	// final com.sun.webkit.WebPage webPage =
	// com.sun.javafx.webkit.Accessor.getPageFor(wv.getEngine());
	// webPage.setBackgroundColor(0);
	// } catch (Throwable ex) {
	// }
	// return wv;

}
