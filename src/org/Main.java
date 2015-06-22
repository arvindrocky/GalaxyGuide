package org;

import java.util.List;

import org.utils.FileUtil;

public class Main {

	public static void main(String[] args) {
		if (args.length == 0 || args[0].isEmpty()) {
			System.out.println("Please specify input file name path");
		} else {
			List<String> listOfLines = FileUtil.parseFile(args[0]);
			/*for(String line : listOfLines) {
				System.out.println(line);
			}*/
			
			GalaxyNotes notes = new GalaxyNotes(listOfLines);
			notes.parseNotes();
			System.out.println(notes.toString());
		}
		
		/*String line = "glob glob Silver is 34 Credits";
		String[] creditMapping = line.split(" is ");
		
		for (String a : creditMapping) {
			System.out.println(a.trim());
		}
		
		System.out.println("============");*/
		
		/*String mappingLine = "glob is I";
		String[] mappingWords = mappingLine.split("is");
		
		for (String b : mappingWords) {
			System.out.println(b.trim());
		}
		
		System.out.println("============");*/
		
		/*if (line.toLowerCase().contains("credits")) {
			System.out.println("TRUE");
		} else {
			System.out.println("FALSE");
		}*/

		/*for (RomanNumbers a : RomanNumbers.values()) {
			System.out.println(a.toString());
		}
		
		System.out.println("============");
		
		String credit = "34 Credits";
		String stringToBeReplaced = "credits";
		System.out.println(credit.toLowerCase().replaceAll(stringToBeReplaced, "").trim());*/
	}
}
