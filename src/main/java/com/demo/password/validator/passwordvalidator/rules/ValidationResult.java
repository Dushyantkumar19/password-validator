/**
 * 
 */
package com.demo.password.validator.passwordvalidator.rules;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Immutable container class for holding the password validation result
 * 
 * @author dushyant sahu
 * @version 0.1
 * @since Dec, 2017
 */
public final class ValidationResult {

	/** boolean flag for validation. */
	private final boolean valid;

	/** set of error messages. */
	private final Set<String> messages;

	/** integer value to hold number or rules being executed. */
	private final int numberOfRulesExecuted;

	/**
	 * Create a new ValidationResult object with supplied valid flag, error
	 * messages and number of rules being executed
	 * 
	 * @param valid
	 *            boolean flag
	 * @param messages
	 *            error messages
	 * @param numberOfRulesExecuted
	 *            number of rules being executed
	 */
	public ValidationResult(final boolean valid, final Set<String> messages, final int numberOfRulesExecuted) {
		this.valid = valid;
		this.messages = messages;
		this.numberOfRulesExecuted = numberOfRulesExecuted;
	}

	/**
	 * @return the valid
	 */
	public boolean isValid() {
		return valid;
	}

	/**
	 * @return the messages
	 */
	public List<String> getMessages() {
		return new ArrayList<String>(messages);
	}

	/**
	 * @return the numberOfRulesExecuted
	 */
	public int getNumberOfRulesExecuted() {
		return numberOfRulesExecuted;
	}

	/**
	 * toString method to print validation result
	 */
	@Override
	public String toString() {
		return "ValidationResult [valid=" + valid + ", messages=" + messages + ", numberOfRulesExecuted="
				+ numberOfRulesExecuted + "]";
	}

}
