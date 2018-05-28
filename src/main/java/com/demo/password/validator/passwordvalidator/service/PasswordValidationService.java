/**
 * 
 */
package com.demo.password.validator.passwordvalidator.service;

import com.demo.password.validator.passwordvalidator.rules.ValidationResult;

/**
 * Interface for Password Validation Service. Defines the contract for password
 * validation.
 * 
 * @author dushyant sahu
 * @version 0.1
 * @since Dec, 2017
 *
 */
public interface PasswordValidationService {

	/**
	 * Runs the set of configured validation rules against the password provided
	 * and returns a {@link ValidationResult} with set of messages object if the
	 * password is invalid
	 * 
	 * @param password
	 * @return {@link ValidationResult} The validation result
	 */
	ValidationResult validate(final String password);

}
