package ua.mainacademy.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ua.mainacademy.model.ConnectionInfo;

import java.io.File;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


class FileManagerTest {
	private static final String MAIN_DIR = System.getProperty("user.dir");
	private static final String SEPARATOR = System.getProperty("file.separator");
	private static final String FILES_DIR = MAIN_DIR + SEPARATOR + "files";
	
	@BeforeAll
	public static void addData() {
		ConnectionInfo connectionTest = new ConnectionInfo(123456, 2L, "123.123.123.123");
		FileManager.writeConnectionInfoToFile(connectionTest, "connectionsTest.txt", true);
	}
	
	@AfterAll
	public static void deleteData() {
		String filePath = FILES_DIR + SEPARATOR + "connectionsTest.txt";
		File file = new File(filePath);
		file.delete();
	}
	@Test
	void readConnectionInfoFromFile() {
		List<ConnectionInfo> result = FileManager.readConnectionInfoFromFile("connectionsTest.txt");
		assertEquals("[123456 2 123.123.123.123]", result.toString());
	}
	
	@Test
	void rewriteFileOnDate() {
		ConnectionInfo connectionInfo1 = new ConnectionInfo(123457, new Date().getTime(), "123.123.123.123");
		FileManager.writeConnectionInfoToFile(connectionInfo1, "connectionsTest.txt", true);
		ConnectionInfo connectionInfo2 = new ConnectionInfo(123458, new Date().getTime(), "123.123.123.123");
		FileManager.writeConnectionInfoToFile(connectionInfo2, "connectionsTest.txt", true);
		ConnectionInfo connectionInfo3 = new ConnectionInfo(123459, new Date().getTime(), "123.123.123.123");
		FileManager.writeConnectionInfoToFile(connectionInfo3, "connectionsTest.txt", true);
		ConnectionInfo connectionInfo4 = new ConnectionInfo(123450, new Date().getTime(), "123.123.123.123");
		FileManager.writeConnectionInfoToFile(connectionInfo4, "connectionsTest.txt", true);
		List<ConnectionInfo> inputElements = FileManager.readConnectionInfoFromFile("connectionsTest.txt");
		int elements = inputElements.size();
		long timeFrom = connectionInfo3.getTime();
		FileManager.rewriteFileOnDate("connectionsTest.txt", timeFrom, new Date().getTime());
		List<ConnectionInfo> rewrittenElements = FileManager.readConnectionInfoFromFile("connectionsTest.txt");
		int elementsR = rewrittenElements.size();
		assertNotEquals(elements, elementsR);
	}
}