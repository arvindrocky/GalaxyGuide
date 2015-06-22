package org.galaxy.notes;

import java.util.HashMap;
import java.util.Map;

import org.galaxy.InterGalacticToRomanNumberMapping;
import org.galaxy.MetalToCreditsMapping;
import org.romanNumber.RomanNumbers;

public class GalaxyNotesNew {
	
	private Map<String, RomanNumbers> interGalacticMapping;
	private Map<String, Double> metalToCreditsMapping;
	
	public GalaxyNotesNew() {
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
