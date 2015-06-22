package org.utils;

public class TextUtil {
	
	public static String[] splitLineIntoWords (String line) {
		return getSafeString(line).split("\\s+");
	}
	
	public static String[] splitWordIntoCharacters (String word) {
		return getSafeString(word).split("(?!^)");
	}
	
	public static String stripQuestionMark (String line) {
		return getSafeString(line).replaceAll("\\?", "");
		
	}
	private static String getSafeString (String str) {
		return str == null ? "" : str.trim();
	}

}
