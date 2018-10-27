package org.eclipse.rcpl.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.IntBuffer;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.image.WritablePixelFormat;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class WritableImageDemo extends Application {

	private Image src;
	private int width;
	private int height;
	ImageView srcView;
	ImageView srcView2;
	ImageView srcView3;

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Image");

//		src = new Image("http://www.gnu.org/graphics/gnu-head.jpg");

		src = new Image("https://upload.wikimedia.org/wikipedia/commons/2/27/Pferd_mit_geschorenem_Herz.jpeg", 1000,
				1000, true, true);

		width = (int) src.getWidth();
		height = (int) src.getHeight();

		srcView = new ImageView(src);
		srcView2 = new ImageView();
		srcView3 = new ImageView();

		ScrollPane scrollPane = new ScrollPane();
		ScrollPane scrollPane2 = new ScrollPane();
		ScrollPane scrollPane3 = new ScrollPane();

		scrollPane.setContent(srcView);
		scrollPane2.setContent(srcView2);
		scrollPane3.setContent(srcView3);

		SplitPane root = new SplitPane(scrollPane, scrollPane2, scrollPane3);

		primaryStage.setScene(new Scene(root, 800, 600));
		primaryStage.show();

		srcView2.setImage(writeToFile());
	}

	private WritableImage writeToFile() {
		WritableImage insert = new WritableImage(width, height);
		WritableImage newimage = new WritableImage(width, height);

		SnapshotParameters parameters = new SnapshotParameters();
		parameters.setFill(Color.TRANSPARENT);
		// make a snapshot
		srcView.snapshot(parameters, insert);

		PixelReader reader = insert.getPixelReader();
		PixelWriter writer = newimage.getPixelWriter();
		WritablePixelFormat<IntBuffer> format = WritablePixelFormat.getIntArgbInstance();

		System.out.println("WritablePixelFormat.getType(): " + format.getType());
		// the following normally creates an exact copy of the original
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				int recWidth = 1;
				int recHeight = 1;

				int[] buffer = new int[recWidth * recHeight];
				reader.getPixels(x, y, recWidth, recHeight, format, buffer, 0, recWidth);

				int alpha = 0;
				int red = 0;
				int green = 0;
				int blue = 0;

				for (int color : buffer) {
					alpha += (color >>> 24);
					red += (color >>> 16 & 0xFF);
					green += (color >>> 8 & 0xFF);
					blue += (color & 0xFF);
				}
				alpha = alpha / recWidth / recHeight;
				red = red / recWidth / recHeight;
				green = green / recWidth / recHeight;
				blue = blue / recWidth / recHeight;

				int color = (alpha << 24) + (red << 16) + (green << 8) + blue;
				Arrays.fill(buffer, color);

				writer.setPixels(x, y, recWidth, recHeight, format, buffer, 0, recWidth);
			}

		}
		System.out.println("Reader Type: " + reader.getPixelFormat().getType());
		System.out.println("Writer Type: " + writer.getPixelFormat().getType());

		try {
			BufferedImage b = new BufferedImage(width + 1, height + 1, BufferedImage.OPAQUE);
			BufferedImage bf = SwingFXUtils.fromFXImage(newimage, b);

			ImageIO.write(bf, "png", new File("c:\\Users\\Ramin\\.rcpl\\cache\\images\\test1.jpg"));
		} catch (IOException ex) {
			Logger.getLogger(WritableImageDemo.class.getName()).log(Level.SEVERE, null, ex);
		}
		try {
			Image img = new Image(new FileInputStream(new File("c:\\Users\\Ramin\\.rcpl\\cache\\images\\test1.jpg")));
			srcView3.setImage(img);
		} catch (IOException ex) {
			Logger.getLogger(WritableImageDemo.class.getName()).log(Level.SEVERE, null, ex);
		}
		return newimage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}