package org.galaxy.notes;

import java.util.HashMap;
import java.util.Map;

import org.galaxy.mapping.InterGalacticToRomanNumberMapping;
import org.galaxy.mapping.MetalToCreditsMapping;
import org.romanNumber.RomanNumbers;

/**
 * This is the main notes class which is initialized after parsing the input file.
 * Inter-galactic and metal-credit conversion notes are added to separate lists.
 * @author arvind
 */
public class GalaxyNotes {
	
	private Map<String, RomanNumbers> interGalacticMapping;
	private Map<String, Double> metalToCreditsMapping;
	
	public GalaxyNotes() {
		this.interGalacticMapping = new HashMap<String, RomanNumbers>();
		this.metalToCreditsMapping = new HashMap<String, Double>();
	}

	public Map<String, RomanNumbers> getInterGalacticMapping() {
		return this.interGalacticMapping;
	}
	
	public Map<String, Double> getMetalToCreditsMapping() {
		return this.metalToCreditsMapping;
	}
	
	public void addInterGalacticMapping(InterGalacticToRomanNumberMapping mappingEntry) {
		this.interGalacticMapping.put(mappingEntry.getInterGalacticCrypticStr(), mappingEntry.getRomanNumber());
	}
	
	public void addMetalToCreditsMapping(MetalToCreditsMapping mappingEntry) {
		this.metalToCreditsMapping.put(mappingEntry.getMetalName(), mappingEntry.getCrediValue());
	}
	
}
