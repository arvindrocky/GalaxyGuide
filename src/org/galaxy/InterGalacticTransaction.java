package org.galaxy;

import static org.romanNumber.RomanNumberToEnglishNumberConvertor.convertRomanNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.galaxy.mapping.InterGalacticToRomanNumberMapping;
import org.galaxy.mapping.MetalToCreditsMapping;
import org.galaxy.notes.GalaxyNotes;
import org.galaxy.parser.GalaxyNotesParser;
import org.romanNumber.RomanNumbers;
import org.romanNumber.exception.InvalidRegularExpressionException;
import org.utils.TextUtil;

/**
 * This file does the inter-galactic transaction based on the notes.
 * @author arvind
 */
public class InterGalacticTransaction {
	private List<String> notes;
	private GalaxyNotes galaxyNotes;
	private List<String> listOfQuestions;
	
	private static final String INVALID_QUESTION_REPLY = "I have no idea what you are talking about";
	
	/**
	 * @constructor
	 * @param notes is the list of lines contained in the input file
	 */
	public InterGalacticTransaction (List<String> notes) {
		this.notes = notes;
		this.galaxyNotes = new GalaxyNotes();
		this.listOfQuestions = new ArrayList<String>();
	}
	
	/**
	 * This method parses the notes and initializes GalaxyNotes.
	 * There can be 3 kind of notes in the input file.
	 * [1] Inter-galactic to roman number note
	 * [2] Metal to credit note
	 * [3] Question note
	 * All these 3 will be put into separate lists using the parser.
	 */
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

	/**
	 * This method takes the list of questions, does the transaction and answers in human readable format
	 */
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
	
	/**
	 * This method takes the roman number and metal name string and gives us the human readable value
	 * @param romanNumbersAndMetalString is the string having roman number along with metal name. Eg XX Silver
	 * @return a human readable string. Eg 20
	 */
	private String convertToHumanReadableFormat (String romanNumbersAndMetalString) {
		String[] individualWords = TextUtil.splitLineIntoWords(romanNumbersAndMetalString);
		if (individualWords.length == 1) { // this can be either a roman number or just the metal name
			if (this.galaxyNotes.getMetalToCreditsMapping()
					.containsKey(individualWords[0].toLowerCase().trim())) {
				return getMetalValue(individualWords[0], 1.0) + " Credits";
			} else {
				try {
					return Integer.toString(convertRomanNumber(individualWords[0].toUpperCase().trim()).intValue());
				} catch (InvalidRegularExpressionException e) {
					return "invalid. Regular expression is invalid";
				}
			}
		} else if (individualWords.length == 2) {
			try {
				return getMetalValue(individualWords[1],
						convertRomanNumber(individualWords[0].trim())) + " Credits";
			} catch (InvalidRegularExpressionException e) {
				return "invalid. Regular expression is invalid";
			}
		}
		return null;
	}
	
	private int getMetalValue (String metalName, Double quantity) {
		Double value = this.galaxyNotes.getMetalToCreditsMapping().get(metalName) * quantity;
		return value.intValue(); // to satisfy test output, I am converting to int
	}
}
