package org.romanNumber.rules;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class RepetitionRuleImpl extends AbstractRule {
	
	private static final List<String> REG_EX_GROUP = new ArrayList<String>(
			Arrays.asList("I{4,}", "X{4,}", "C{4,}", "M{4,}", "D{2,}", "L{2,}",
					"V{2,}", "I{2,}[VXLCDM]", "X{2,}[LCDM]", "C{2,}[DM]"));

	public RepetitionRuleImpl() {
		super(REG_EX_GROUP);
	}
}
