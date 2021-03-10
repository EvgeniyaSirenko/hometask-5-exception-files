package ua.mainacademy.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import ua.mainacademy.model.ConnectionInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;


class FileManagerTest {
	
	@Test
	void writeConnectionInfoToFile() {
		ConnectionInfo connectionTest = new ConnectionInfo(123456, 2L, "123.123.123.123");
		FileManager.writeConnectionInfoToFile(connectionTest, "connectionsTest.txt", true);
		assertEquals("[123456 2 123.123.123.123]", FileManager.readConnectionInfoFromFile("connectionsTest.txt").toString());
	}
	
	@Test
	void readConnectionInfoFromFile() {
	}
	
	@Test
	void writeBytesToFile() {
	}
	
	@Test
	void readBytesFromFile() {
	}
	
	@Test
	void copyFile() {
	}
	
	@Test
	void moveFile() {
	}
	
	@Test
	void rewriteFileOnDate() {
	}
}