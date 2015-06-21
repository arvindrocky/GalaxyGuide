package org.romanNumber;

import java.util.ArrayList;
import java.util.List;

import org.romanNumber.rules.IRule;
import org.romanNumber.rules.RepetitionRuleImpl;
import org.romanNumber.rules.SubtractionRuleImpl;

public class RomanNumberValidation {
	
	private List<IRule> listOfRules = new ArrayList<IRule>();
	
	RomanNumberValidation () {
		this.listOfRules.add(new RepetitionRuleImpl());
		this.listOfRules.add(new SubtractionRuleImpl());
	}
	
	public void validateRomanNumber (String input) {
		for (IRule rule : this.listOfRules) {
			rule.validate(input);
		}
	}

}
