package org.romanNumber;

import java.util.HashMap;
import java.util.Map;

public enum RomanNumbers {
	I(1),
	V(5),
	X(10),
	L(50),
	C(100),
	D(500),
	M(1000);
	
	private int value;
	
	private RomanNumbers (int val) {
		this.value = val;
	}

	public int getValue() {
		return value;
	}
	
	private static final Map<String, RomanNumbers> stringToEnum = new HashMap<String, RomanNumbers>();
	static {
		for (RomanNumbers num : values()) {
			stringToEnum.put(num.toString(), num);
		}
	}
	
	public static RomanNumbers fromString(String symbol) {
		return stringToEnum.get(symbol);
	}

}
