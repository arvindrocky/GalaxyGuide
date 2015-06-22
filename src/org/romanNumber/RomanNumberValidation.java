package org.romanNumber;

import java.util.ArrayList;
import java.util.List;

import org.romanNumber.exception.InvalidRegularExpressionException;
import org.romanNumber.rules.IRule;
import org.romanNumber.rules.RepetitionRuleImpl;
import org.romanNumber.rules.SubtractionRuleImpl;

public class RomanNumberValidation {
	
	private List<IRule> listOfRules = new ArrayList<IRule>();
	
	public RomanNumberValidation () {
		this.listOfRules.add(new RepetitionRuleImpl());
		this.listOfRules.add(new SubtractionRuleImpl());
	}
	
	public void validateRomanNumber (String input) throws InvalidRegularExpressionException {
		for (IRule rule : this.listOfRules) {
			if (!rule.validate(input)) {
				throw new InvalidRegularExpressionException("Invalid regular expression found");
			}
		}
	}

}
