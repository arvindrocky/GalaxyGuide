package org;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.galaxy.notes.GalaxyNotesParser;
import org.romanNumber.RomanNumberToEnglishNumberConvertor;
import org.romanNumber.RomanNumbers;

public class GalaxyNotes {
	
	private List<String> notes;
	private Map<String, RomanNumbers> interGalacticMapping = new HashMap<String, RomanNumbers>();
	private Map<String, Double> metalToCreditsMapping = new HashMap<String, Double>();
	private List<String> listOfQuestions = new ArrayList<String>();
	
	public GalaxyNotes(List<String> notes) {
		this.notes = notes;
	}

	public void parseNotes () {
		for (String line : this.notes) {
			if (GalaxyNotesParser.isIntergalacticToRomanNumberMappingNote(line)) {
				// do inter-galactic mapping
				String[] galacticNoteResult = GalaxyNotesParser.parseInterGalacticToRomanNumberNote(line);
				this.interGalacticMapping.put(galacticNoteResult[0], RomanNumbers.fromString(galacticNoteResult[1]));
			} else if (GalaxyNotesParser.isMetalToCreditMappingNote(line)) {
				// do metal to credit mapping
				String[] metalToCreditNoteResult = GalaxyNotesParser.parseMetalToCrediNote(line);
				String[] metalPhrase = metalToCreditNoteResult[0].split("\\s+");
				String romanNumbers = "", metalName = "";
				for (String word : metalPhrase) {
					if (this.interGalacticMapping.containsKey(word.trim())) {
						romanNumbers += this.interGalacticMapping.get(word).toString();
					} else {
						metalName = word;
						break;
					}
				}
				
				this.metalToCreditsMapping.put(metalName, getValueOfOneUnitOfMetal(romanNumbers, metalToCreditNoteResult[1]));
			} else {
				// is a question
				this.listOfQuestions.add(line);
			}
		}
	}
	
	public String toString () {
		String myNotes = "INTER-GALACTIC MAPPTINGS\n";
		
		for (Map.Entry<String, RomanNumbers> entry : this.interGalacticMapping.entrySet()) {
			myNotes += entry.getKey() + " ===> " + entry.getValue() + "\n";
		}
		
		myNotes += "\nMETAL TO CREDIT MAPPINGS\n";
		
		for (Map.Entry<String, Double> entry : this.metalToCreditsMapping.entrySet()) {
			myNotes += entry.getKey() + " ===> " + entry.getValue() + "\n";
		}
		
		myNotes += "\nQUESTIONS\n";
		
		for (String question : this.listOfQuestions) {
			myNotes += question + "\n";
		}
		
		return myNotes;
	}
	
	private Double getValueOfOneUnitOfMetal (String romanNumbers, String creditValue) {
		Integer value = RomanNumberToEnglishNumberConvertor.convertRomanNumber(romanNumbers);
		return Double.parseDouble(creditValue) / value;
	}
}
