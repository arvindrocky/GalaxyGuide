package org.galaxy.mapping;

/**
 * This is the mapping class for metal-credit note.
 * Eg : "glob glob Silver is 34 Credits" note will be mapped using this class
 * @author arvind
 */
public final class MetalToCreditsMapping {
	private final String metalName; 
    private final Double crediValue;
    
    public MetalToCreditsMapping(String metalName, Double crediValue) {
		this.metalName = metalName;
		this.crediValue = crediValue;
	}

	public String getMetalName() {
		return this.metalName;
	}

	public Double getCrediValue() {
		return this.crediValue;
	}
    
}
