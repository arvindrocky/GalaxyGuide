package org.galaxy.mapping;

import org.romanNumber.RomanNumbers;

public final class InterGalacticToRomanNumberMapping {
	private final String interGalacticCrypticStr; 
    private final RomanNumbers romanNumber;
    
	public InterGalacticToRomanNumberMapping(String interGalacticCrypticStr,
			RomanNumbers romanNumber) {
		this.interGalacticCrypticStr = interGalacticCrypticStr;
		this.romanNumber = romanNumber;
	}

	public String getInterGalacticCrypticStr() {
		return this.interGalacticCrypticStr;
	}

	public RomanNumbers getRomanNumber() {
		return this.romanNumber;
	}
}
