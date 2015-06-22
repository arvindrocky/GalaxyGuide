package org.galaxy.parser;

import java.util.ArrayList;
import java.util.List;

import org.utils.TextUtil;

public class InterGalacticQuestionParser {
	
	public static List<String> parseInterGalacticQuestion (List<String> listOfQuestions) {
		List<String> listOfParsedQuestions = new ArrayList<String>();
		// strip parts of words which are not required
		for (String question : listOfQuestions) {
			String[] listOfPhrases = question.toLowerCase().split(" is ");
			if (listOfPhrases.length == 2) {
				listOfParsedQuestions.add(TextUtil.stripQuestionMark(listOfPhrases[1]).trim());
			} else { // add question as it is if it is not a valid question
				listOfParsedQuestions.add(question);
			}
		}
		return listOfParsedQuestions;
	}
}
