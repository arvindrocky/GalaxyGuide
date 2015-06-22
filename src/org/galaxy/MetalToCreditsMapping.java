package org.galaxy;

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
