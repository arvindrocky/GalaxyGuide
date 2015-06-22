package org.romanNumber.rules;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AbstractRule implements IRule {
	
	private String regex = "";
	
	public AbstractRule (List<String> regexpgroup) {
		String anyCharacterRegExp = "[a-zA-Z]*";
		for (int i=0; i<regexpgroup.size(); i++) {
			this.regex += anyCharacterRegExp + regexpgroup.get(i) + anyCharacterRegExp;
			if(i != regexpgroup.size()-1) {
				this.regex += "|";
			}
		}
	}

	@Override
	public boolean validate(String input) {
		Pattern pat = Pattern.compile(this.regex);
		Matcher mat = pat.matcher(input);
		
		return !mat.matches();
	}

}
