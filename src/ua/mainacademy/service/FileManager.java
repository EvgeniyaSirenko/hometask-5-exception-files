package ua.mainacademy.service;

import ua.mainacademy.exception.MyException;
import ua.mainacademy.model.ConnectionInfo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
	
	private static final String MAIN_DIR = System.getProperty("user.dir"); //idea-workspace/hometask-5-exception-files
	private static final String SEPARATOR = System.getProperty("file.separator");
	private static final String FILES_DIR = MAIN_DIR + SEPARATOR + "files";
	
	public static void writeConnectionInfoToFile(ConnectionInfo connectionInfo, String fileName) {
		checkFilesDir();
		String filePath = FILES_DIR + SEPARATOR + fileName;
		
		try (FileWriter fileWriter = new FileWriter(filePath);) {
			fileWriter.write(connectionInfo.toString() + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void checkFilesDir() {
		File file = new File(FILES_DIR);
		if (!file.exists()) {
			file.mkdir();
		}
	}
	
	public static List<ConnectionInfo> readConnectionInfoFromFile(String fileName) {
		List<ConnectionInfo> result = new ArrayList<>();
		String filePath = FILES_DIR + SEPARATOR + fileName;
		if (isNotExist(filePath)) {
			throw new MyException("Can not handle reading");
		}
		try (FileReader fileReader = new FileReader(filePath);
			 BufferedReader bufferedReader = new BufferedReader(fileReader);) {
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String[] elements = line.split(" ");
				ConnectionInfo connectionInfo = new ConnectionInfo(
				Integer.valueOf(elements[0]),
				Long.valueOf(elements[1]),
				elements[2]
				);
				result.add(connectionInfo);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private static boolean isNotExist(String filePath) {
		File file = new File(filePath);
		return !file.exists();
	}
}
