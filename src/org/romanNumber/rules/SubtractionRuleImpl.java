package org.romanNumber.rules;


public class SubtractionRuleImpl extends AbstractRule {
	
	private static final String REG_EX = "I[LCDM]|X[DM]|V[XLCDM]|L[CDM]|D[M]";

	public SubtractionRuleImpl() {
		super(REG_EX);
	}
}
