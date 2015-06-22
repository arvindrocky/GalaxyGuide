package org.romanNumber.exception;

/**
 * A custom exception class used during validation of roman numbers.
 * @author arvind
 */
public class InvalidRegularExpressionException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public InvalidRegularExpressionException(String message) {
		super(message);
	}

}
