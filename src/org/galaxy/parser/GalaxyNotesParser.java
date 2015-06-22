package org.galaxy.parser;

import java.util.Map;

import org.galaxy.mapping.InterGalacticToRomanNumberMapping;
import org.galaxy.mapping.MetalToCreditsMapping;
import org.romanNumber.RomanNumberToEnglishNumberConvertor;
import org.romanNumber.RomanNumbers;
import org.romanNumber.exception.InvalidRegularExpressionException;
import org.utils.TextUtil;

/**
 * This class parses the input file and gives us the proper values to initialize GalaxyNotes.
 * @author arvind
 */
public class GalaxyNotesParser {
	
	private static final String CREDIT_STRING = "credits";
	
	/**
	 * This method tells us if the note is a inter-galactic note.
	 * Eg : glob is I
	 * @param line is the note line
	 * @return true if it is a inter-galactic note
	 */
	public static Boolean isIntergalacticToRomanNumberMappingNote (String line) {
		String[] individualWords = TextUtil.splitLineIntoWords(line.toLowerCase());
		return individualWords.length == 3 && individualWords[1].equals("is");
	}
	
	/**
	 * This method tells us if the note is a metal-credit note.
	 * Eg : glob glob Silver is 34 Credits
	 * @param line is the note line
	 * @return true if it is a metal-credit note
	 */
	public static Boolean isMetalToCreditMappingNote (String line) {
		return line.toLowerCase().endsWith(CREDIT_STRING);
	}
	
	/**
	 * This method is used to parse inter-galactic note line.
	 * This gives us the inter-galactic cryptic string and the corresponding roman number.
	 * @param line is the input note line
	 * @return parsed value of the note
	 */
	public static InterGalacticToRomanNumberMapping parseInterGalacticToRomanNumberNote (String line) {
		String[] individualWords = line.toLowerCase().split(" is ");
		// 0th index is inter-galactic name and 1st index is the roman number
		return new InterGalacticToRomanNumberMapping(individualWords[0].trim(),
				RomanNumbers.fromString(individualWords[1].trim().toUpperCase()));
	}
	
	/**
	 * This method is used to parse metal to credit note line.
	 * This gives us the metal name and the corresponding value for 1 unit of the metal.
	 * @param line is the input note line
	 * @param interGalacticMapping list of inter-galactic cryptic to roman number mapping
	 * @return parsed value of the note
	 */
	public static MetalToCreditsMapping parseMetalToCrediNote (String line,
			Map<String, RomanNumbers> interGalacticMapping) {
		String romanNumbers = "", metalName = "";
		Double creditValue = 0.0;
		String[] creditMappingPhrase = line.toLowerCase().split(" is ");
		
		// 0th index is metal name along with roman numbers and 1st index is the credit value
		if (creditMappingPhrase.length == 2) {
			String[] metalPhrase = TextUtil.splitLineIntoWords(creditMappingPhrase[0]);
			creditValue = Double.parseDouble(creditMappingPhrase[1].replaceAll(CREDIT_STRING, "").trim());
			
			for (String word : metalPhrase) {
				if (interGalacticMapping.containsKey(word.trim())) {
					romanNumbers += interGalacticMapping.get(word);
				} else {
					metalName = word;
					break;
				}
			}
		}
		return new MetalToCreditsMapping(metalName,
				getValueOfOneUnitOfMetal(romanNumbers, creditValue));
	}
	
	private static Double getValueOfOneUnitOfMetal (String romanNumbers, Double creditValue) {
		Double value = 1.0;
		try {
			value = RomanNumberToEnglishNumberConvertor.convertRomanNumber(romanNumbers);
		} catch (InvalidRegularExpressionException e) {
			// if exception comes here, then the notes is wrong
		}
		return creditValue / value;
	}

}
