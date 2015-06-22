package org.galaxy.parser;

import org.utils.TextUtil;

public class GalaxyNotesParser {
	
	private static final String CREDIT_STRING = "credits";
	
	public static Boolean isIntergalacticToRomanNumberMappingNote (String line) {
		String[] individualWords = TextUtil.splitLineIntoWords(line.toLowerCase());
		return individualWords.length == 3 && individualWords[1].equals("is");
	}
	
	public static Boolean isMetalToCreditMappingNote (String line) {
		return line.toLowerCase().endsWith(CREDIT_STRING);
	}
	
	// TODO : Return a bean object instead of array string
	public static String[] parseInterGalacticToRomanNumberNote (String line) {
		String[] individualWords = line.toLowerCase().split(" is ");
		// 0th index is inter-galactic name and 1st index is the roman number
		String[] result = {individualWords[0].trim(), individualWords[1].trim().toUpperCase()};
		return result;
	}
	
	public static String[] parseMetalToCrediNote (String line) {
		String[] creditMappingPhrase = line.toLowerCase().split(" is ");
		// 0th index is metal name along with roman numbers and 1st index is the credit value
		String[] result = {creditMappingPhrase[0].trim(), creditMappingPhrase[1].replaceAll(CREDIT_STRING, "").trim()};
		return result;
	}

}
