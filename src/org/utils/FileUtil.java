package org.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// TODO : ADD EXCEPTION CLASSES
public class FileUtil {
	
	public static List<String> parseFile (String inputFilePath) {
		List<String> listOfLines = new ArrayList<String>();
		
		BufferedReader bufferReader = null;
		String line;
		try {
			bufferReader = new BufferedReader(new FileReader(inputFilePath));
			
			while ((line = bufferReader.readLine()) != null) {
				listOfLines.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return listOfLines;
	}

}
