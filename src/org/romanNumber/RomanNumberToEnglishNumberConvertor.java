package org.romanNumber;

import org.romanNumber.exception.InvalidRegularExpressionException;
import org.utils.TextUtil;

public class RomanNumberToEnglishNumberConvertor {
	
	public static Double convertRomanNumber (String romanNumber) throws InvalidRegularExpressionException {
		validate(romanNumber);
		
		String[] listOfRomanCharacters = TextUtil.splitWordIntoCharacters(romanNumber);
		Double totalValue = 0.0;
		int currentNumericValue = 0, nextNumericValue = 0;
		
		for (int i=0; i<listOfRomanCharacters.length && !listOfRomanCharacters[i].isEmpty(); i++) {
			currentNumericValue = RomanNumbers.fromString(listOfRomanCharacters[i]).getValue();
			if (i < listOfRomanCharacters.length-1) {
				nextNumericValue = RomanNumbers.fromString(listOfRomanCharacters[i+1]).getValue();
			}
			if (currentNumericValue < nextNumericValue) {
				totalValue += nextNumericValue - currentNumericValue;
				i++;
			}
			else {
				totalValue += currentNumericValue;
			}
		}
		
		return totalValue;
	}
	
	private static void validate (String romanNumber) throws InvalidRegularExpressionException {
		RomanNumberValidation validator = new RomanNumberValidation();
		validator.validateRomanNumber(romanNumber);
	}

}
