package org.romanNumber;

import java.util.ArrayList;
import java.util.List;

import org.romanNumber.exception.InvalidRegularExpressionException;
import org.romanNumber.rules.IRule;
import org.romanNumber.rules.RepetitionRuleImpl;
import org.romanNumber.rules.SubtractionRuleImpl;

/**
 * This class is used to validate roman numbers.
 * Any new rule to validate roman number should be added in this class
 * @author arvind
 */
public class RomanNumberValidation {
	
	private List<IRule> listOfRules = new ArrayList<IRule>();
	
	/**
	 * @Constructor
	 * Add all the rules to the list.
	 */
	public RomanNumberValidation () {
		this.listOfRules.add(new RepetitionRuleImpl());
		this.listOfRules.add(new SubtractionRuleImpl());
	}
	
	/**
	 * This method iterates through each rule in the list and does the validation.
	 * @param input is the roman number that needs to be validated
	 * @throws InvalidRegularExpressionException
	 */
	public void validateRomanNumber (String input) throws InvalidRegularExpressionException {
		for (IRule rule : this.listOfRules) {
			if (!rule.validate(input)) {
				throw new InvalidRegularExpressionException("Invalid regular expression found");
			}
		}
	}

}
