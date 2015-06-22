package org.romanNumber;

import org.romanNumber.exception.InvalidRegularExpressionException;
import org.utils.TextUtil;

/**
 * This class is used to conver roman number to english number value
 * @author arvind
 */
public class RomanNumberToEnglishNumberConvertor {
	
	/**
	 * This method gives us the english number value by parsing the roman number
	 * @param romanNumber is the roman number to be parsed
	 * @return converted english number
	 * @throws InvalidRegularExpressionException
	 */
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
