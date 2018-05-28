/**
 * 
 */
package com.demo.password.validator.passwordvalidator.rules;

import org.springframework.context.MessageSource;

/**
 * Core interface for password strength rules.
 *
 * @author dushyant sahu
 * @version 0.1
 * @since Dec, 2017
 */
public interface Rule {

	/**
	 * Checks if the supplied password is valid as per the requirements of this
	 * rule or not.
	 *
	 * @param password
	 *            supplied password
	 * 
	 * @return true if password pass validation otherwise false
	 */
	boolean isValid(String password);

	/**
	 * Returns error message from messages.properties
	 * 
	 * @param messageSource
	 *            spring message source
	 * @return error message
	 */
	public String getMessage(final MessageSource messageSource);

}
