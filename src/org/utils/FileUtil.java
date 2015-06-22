package org.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A class with static methods to do file utils.
 * @author arvind
 */
public class FileUtil {
	
	public static List<String> parseFile (String inputFilePath) throws IOException {
		List<String> listOfLines = new ArrayList<String>();
		String line;
		
		BufferedReader bufferReader = new BufferedReader(new FileReader(inputFilePath));
		while ((line = bufferReader.readLine()) != null) {
			listOfLines.add(line);
		}
		bufferReader.close();
		
		return listOfLines;
	}

}
