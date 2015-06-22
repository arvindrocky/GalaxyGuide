package org.galaxy.notes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.galaxy.parser.InterGalacticQuestionParser;
import org.romanNumber.RomanNumberToEnglishNumberConvertor;
import org.romanNumber.RomanNumbers;
import org.utils.TextUtil;

public class GalaxyNotes {
	
	private List<String> notes;
	
	private Map<String, RomanNumbers> interGalacticMapping = new HashMap<String, RomanNumbers>();
	private Map<String, Double> metalToCreditsMapping = new HashMap<String, Double>();
	private List<String> listOfQuestions = new ArrayList<String>();
	
	private static final String INVALID_QUESTION_REPLY = "I have no idea what you are talking about";
	
	public GalaxyNotes(List<String> notes) {
		this.notes = notes;
	}

	/*public void parseNotes () {
		for (String line : this.notes) {
			if (GalaxyNotesParser.isIntergalacticToRomanNumberMappingNote(line)) {
				// do inter-galactic mapping
				String[] galacticNoteResult = GalaxyNotesParser.parseInterGalacticToRomanNumberNote(line);
				this.interGalacticMapping.put(galacticNoteResult[0], RomanNumbers.fromString(galacticNoteResult[1]));
			} else if (GalaxyNotesParser.isMetalToCreditMappingNote(line)) {
				// do metal to credit mapping
				String[] metalToCreditNoteResult = GalaxyNotesParser.parseMetalToCrediNote(line);
				String[] metalPhrase = TextUtil.splitLineIntoWords(metalToCreditNoteResult[0]);
				String romanNumbers = "", metalName = "";
				for (String word : metalPhrase) {
					if (this.interGalacticMapping.containsKey(word.trim())) {
						romanNumbers += this.interGalacticMapping.get(word).toString();
					} else {
						metalName = word;
						break;
					}
				}
				
				this.metalToCreditsMapping.put(metalName, getValueOfOneUnitOfMetal(romanNumbers, metalToCreditNoteResult[1]));
			} else {
				// is a question
				this.listOfQuestions.add(line);
			}
		}
	}*/
	
	public Map<String, String> getListOfAnswers () {
		Map<String, String> listOfRomanNumberQuestions = new LinkedHashMap<String, String>();
		for (String question : InterGalacticQuestionParser.parseInterGalacticQuestion(this.listOfQuestions)) {
			if (this.listOfQuestions.contains(question)) {
				listOfRomanNumberQuestions.put(INVALID_QUESTION_REPLY, "");
			} else {
				String[] individualWords = TextUtil.splitLineIntoWords(question.toLowerCase());
				String romanNumbers = "";
				for (String word : individualWords) {
					if (this.interGalacticMapping.containsKey(word)) {
						romanNumbers += this.interGalacticMapping.get(word);
					} else if (this.metalToCreditsMapping.containsKey(word)) {
						romanNumbers += " " + word;
						break;
					}
				}
				listOfRomanNumberQuestions.put(question, getValueOfRomanNumbersAndMetal(romanNumbers.trim()));
			}
		}
		return listOfRomanNumberQuestions;
	}
	
	private Double getValueOfOneUnitOfMetal (String romanNumbers, String creditValue) {
		Double value = RomanNumberToEnglishNumberConvertor.convertRomanNumber(romanNumbers);
		return Double.parseDouble(creditValue) / value;
	}
	
	private String getValueOfRomanNumbersAndMetal (String romanNumbersAndMetalString) {
		String[] individualWords = TextUtil.splitLineIntoWords(romanNumbersAndMetalString);
		if (individualWords.length == 1) {
			if (this.metalToCreditsMapping.containsKey(individualWords[0].toLowerCase().trim())) {
				return this.metalToCreditsMapping.get(individualWords[0]).intValue() + " Credits";
			} else {
				return Integer.toString(RomanNumberToEnglishNumberConvertor.convertRomanNumber(individualWords[0].trim()).intValue());
			}
		} else if (individualWords.length == 2) {
			Double value = this.metalToCreditsMapping.get(individualWords[1]) *
				RomanNumberToEnglishNumberConvertor.convertRomanNumber(individualWords[0].trim());
			return value.intValue() + " Credits";
		}
		return null;
	}
}
