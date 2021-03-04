package ua.mainacademy;

import ua.mainacademy.model.ConnectionInfo;
import ua.mainacademy.service.FileManager;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

public class AppRunner {
	private static final Logger LOG = Logger.getLogger(AppRunner.class.getName());
	
	public static void main(String[] args) {
		ConnectionInfo connectionInfo = new ConnectionInfo(123456, new Date().getTime(), "123.123.123.123");
		FileManager.writeConnectionInfoToFile(connectionInfo, "test.txt");
		
		List<ConnectionInfo> connections = FileManager.readConnectionInfoFromFile("test.txt");
		LOG.info(String.format("The first element is %s", connections.get(0)));
	}
}
