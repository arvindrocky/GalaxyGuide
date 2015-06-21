package org.romanNumber.rules;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AbstractRule implements IRule {
	
	protected String regex;
	
	public AbstractRule (String regex) {
		this.regex = regex;
	}

	@Override
	public boolean validate(String input) {
		Pattern pat = Pattern.compile(regex);
		Matcher mat = pat.matcher(input);
		
		return !mat.matches();
	}

}
