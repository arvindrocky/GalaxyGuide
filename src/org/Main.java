package org;

public class Main {

	public static void main(String[] args) {
		for (RomanNumbers a : RomanNumbers.values()) {
			System.out.println(a.getValue());
		}
	}
}
