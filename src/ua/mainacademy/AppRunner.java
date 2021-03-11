package ua.mainacademy;

import ua.mainacademy.model.ConnectionInfo;
import ua.mainacademy.service.FileManager;
import ua.mainacademy.service.ImageReader;

import java.util.Date;
import java.util.logging.Logger;

public class AppRunner {
	private static final Logger LOG = Logger.getLogger(AppRunner.class.getName());
	
	public static void main(String[] args) {
		ConnectionInfo connectionInfo1 = new ConnectionInfo(123456, new Date().getTime(), "123.123.123.123");
		FileManager.writeConnectionInfoToFile(connectionInfo1, "connections.txt", true);
		ConnectionInfo connectionInfo2 = new ConnectionInfo(123457, new Date().getTime(), "123.123.123.123");
		FileManager.writeConnectionInfoToFile(connectionInfo2, "connections.txt", true);
		ConnectionInfo connectionInfo3 = new ConnectionInfo(123458, new Date().getTime(), "123.123.123.123");
		FileManager.writeConnectionInfoToFile(connectionInfo3, "connections.txt", true);
		ConnectionInfo connectionInfo4 = new ConnectionInfo(123459, new Date().getTime(), "123.123.123.123");
		FileManager.writeConnectionInfoToFile(connectionInfo4, "connections.txt", true);
		ConnectionInfo connectionInfo5 = new ConnectionInfo(123450, new Date().getTime(), "123.123.123.123");
		FileManager.writeConnectionInfoToFile(connectionInfo5, "connections.txt", true);
		LOG.info(String.format("List of connections: %s", FileManager.readConnectionInfoFromFile("connections.txt")));

		ImageReader imageReader = new ImageReader();
		imageReader.imageToByteArray("https://img.webmd.com/dtmcms/live/webmd/consumer_assets/site_images/article_thumbnails/other/cat_relaxing_on_patio_other/1800x1200_cat_relaxing_on_patio_other.jpg");

		byte[] myBytesImg = FileManager.readBytesFromFile("cat.jpg");
		FileManager.writeBytesToFile(myBytesImg, "myBytesImg.txt");
		FileManager.copyFile("myBytesImg.txt", "cat1.jpg");
		
		long timeFrom = connectionInfo3.getTime();
		FileManager.rewriteFileOnDate("connections.txt", timeFrom, new Date().getTime());
		LOG.info(String.format("List of connections after rewriting: %s", FileManager.readConnectionInfoFromFile("connections.txt")));
		
		
	}
}
