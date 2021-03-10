package ua.mainacademy.service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class ImageReader {
	private static final String MAIN_DIR = System.getProperty("user.dir");
	private static final String SEPARATOR = System.getProperty("file.separator");
	private static final String FILES_DIR = MAIN_DIR + SEPARATOR + "files";
	
	public void imageToByteArray(String imgUrl) {
		try {
			URL imageURL = new URL(imgUrl);
			BufferedImage origImg = ImageIO.read(imageURL);
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			ImageIO.write(origImg, "jpg", byteArrayOutputStream);
			String filePath = FILES_DIR + SEPARATOR + "cat.jpg";
			FileOutputStream fileOutputStream = new FileOutputStream(filePath);
			byteArrayOutputStream.writeTo(fileOutputStream);
			fileOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
