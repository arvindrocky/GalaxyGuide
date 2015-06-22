package org.galaxy.mapping;

import org.romanNumber.RomanNumbers;

/**
 * This is the mapping class for inter-galactic note.
 * Eg : "glob is I" note will be mapped using this class
 * @author arvind
 */
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
