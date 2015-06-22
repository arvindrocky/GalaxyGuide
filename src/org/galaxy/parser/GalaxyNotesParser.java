package org.galaxy.parser;

import java.util.Map;

import org.galaxy.mapping.InterGalacticToRomanNumberMapping;
import org.galaxy.mapping.MetalToCreditsMapping;
import org.romanNumber.RomanNumberToEnglishNumberConvertor;
import org.romanNumber.RomanNumbers;
import org.romanNumber.exception.InvalidRegularExpressionException;
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
	
	public static InterGalacticToRomanNumberMapping parseInterGalacticToRomanNumberNote (String line) {
		String[] individualWords = line.toLowerCase().split(" is ");
		// 0th index is inter-galactic name and 1st index is the roman number
		return new InterGalacticToRomanNumberMapping(individualWords[0].trim(),
				RomanNumbers.fromString(individualWords[1].trim().toUpperCase()));
	}
	
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
