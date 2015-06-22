package org.galaxy;

import java.util.ArrayList;
import java.util.List;

public class InterGalacticQuestionParser {
	
	public static List<String> parseInterGalacticQuestion (List<String> listOfQuestions) {
		List<String> listOfParsedQuestions = new ArrayList<String>();
		// strip parts of words which are not required
		for (String question : listOfQuestions) {
			String[] listOfPhrases = question.toLowerCase().split(" is ");
			if (listOfPhrases.length == 2) {
				listOfParsedQuestions.add(listOfPhrases[1].replaceAll("\\?", "").trim());
			} else {
				listOfParsedQuestions.add(question);
			}
		}
		return listOfParsedQuestions;
	}
}
