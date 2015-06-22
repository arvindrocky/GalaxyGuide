package org.galaxy;

import static org.romanNumber.RomanNumberToEnglishNumberConvertor.convertRomanNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.galaxy.notes.GalaxyNotes;
import org.galaxy.parser.GalaxyNotesParser;
import org.romanNumber.RomanNumbers;
import org.utils.TextUtil;

public class InterGalacticTransaction {
	private List<String> notes;
	private GalaxyNotes galaxyNotes;
	private List<String> listOfQuestions;
	
	private static final String INVALID_QUESTION_REPLY = "I have no idea what you are talking about";
	
	public InterGalacticTransaction (List<String> notes) {
		this.notes = notes;
		this.galaxyNotes = new GalaxyNotes();
		this.listOfQuestions = new ArrayList<String>();
	}
	
	public void parseNotes () {
		for (String line : this.notes) {
			if (GalaxyNotesParser.isIntergalacticToRomanNumberMappingNote(line)) {
				InterGalacticToRomanNumberMapping mappingEntry = GalaxyNotesParser.parseInterGalacticToRomanNumberNote(line);
				this.galaxyNotes.addInterGalacticMapping(mappingEntry);
			} else if (GalaxyNotesParser.isMetalToCreditMappingNote(line)) {
				MetalToCreditsMapping metalMappingEntry = GalaxyNotesParser.parseMetalToCrediNote(
						line, this.galaxyNotes.getInterGalacticMapping());
				this.galaxyNotes.addMetalToCreditsMapping(metalMappingEntry);
			} else {
				this.listOfQuestions.add(line);
			}
		}
	}

	public void transactInGalaxy () {
		Map<String, RomanNumbers> interGalacticMapping = this.galaxyNotes.getInterGalacticMapping();
		Map<String, Double> metalToCreditsMapping = this.galaxyNotes.getMetalToCreditsMapping();
		
		for (String question : this.listOfQuestions) {
			String[] questionParts = TextUtil.stripQuestionMark(question)
					.trim().toLowerCase().split(" (?i)is ");
			if (questionParts.length == 1) {
				System.out.println(INVALID_QUESTION_REPLY);
			} else {
				String romanNumbers = "";
				String[] individualWords = TextUtil.splitLineIntoWords(questionParts[1].toLowerCase());
				for (String word : individualWords) {
					if (interGalacticMapping.containsKey(word)) {
						romanNumbers += interGalacticMapping.get(word);
					} else if (metalToCreditsMapping.containsKey(word)) {
						romanNumbers += " " + word;
						break;
					}
				}
				System.out.println(questionParts[1] + " is " + convertToHumanReadableFormat(romanNumbers.trim()));
			}
		}
	}
	
	private String convertToHumanReadableFormat (String romanNumbersAndMetalString) {
		String[] individualWords = TextUtil.splitLineIntoWords(romanNumbersAndMetalString);
		if (individualWords.length == 1) { // this can be either a roman number or just the metal name
			if (this.galaxyNotes.getMetalToCreditsMapping()
					.containsKey(individualWords[0].toLowerCase().trim())) {
				return getMetalValue(individualWords[0], 1.0) + " Credits";
			} else {
				return Integer.toString(convertRomanNumber(individualWords[0].toUpperCase().trim()).intValue());
			}
		} else if (individualWords.length == 2) {
			return getMetalValue(individualWords[1],
					convertRomanNumber(individualWords[0].trim())) + " Credits";
		}
		return null;
	}
	
	private int getMetalValue (String metalName, Double quantity) {
		Double value = this.galaxyNotes.getMetalToCreditsMapping().get(metalName) * quantity;
		return value.intValue(); // to satisfy test output, I am converting to int
	}
}
