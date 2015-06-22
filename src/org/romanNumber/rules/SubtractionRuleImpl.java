package org.romanNumber.rules;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SubtractionRuleImpl extends AbstractRule {
	
	private static final List<String> REG_EX_GROUP = new ArrayList<String>(
			Arrays.asList("I[LCDM]", "X[DM]", "V[XLCDM]", "L[CDM]", "D[M]"));

	public SubtractionRuleImpl() {
		super(REG_EX_GROUP);
	}
}
