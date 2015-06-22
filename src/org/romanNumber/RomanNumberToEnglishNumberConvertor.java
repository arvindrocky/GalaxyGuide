package org.romanNumber;

public class RomanNumberToEnglishNumberConvertor {
	
	public static Integer convertRomanNumber (String romanNumber) {
		String[] listOfRomanCharacters = romanNumber.split("(?!^)");
		int totalValue = 0, currentNumericValue = 0, nextNumericValue = 0;
		
		for (int i=0; i<listOfRomanCharacters.length; i++) {
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

}
