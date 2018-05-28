/**
 * 
 */
package com.demo.password.validator.passwordvalidator.rules;

import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Rule class for checking password length which implements core interface Rule.
 * 
 * @author Dushyant sahu
 * @version 0.1
 * @since Dec, 2017
 *
 */
@Component
@PropertySource(value = { "regex.properties" })
public class LengthRule implements Rule {

	/** Stores the minimum length of a password. */
	private int minimumLength;

	/** Stores the maximum length of a password. */
	private int maximumLength;

	/** error code for this rule. */
	private String errorCode;

	/**
	 * Create a new LengthRule with configured minimumLength and maximumLength.
	 *
	 * @param minLength
	 *            minimum length of a password
	 * @param maxLength
	 *            maximum length of a password
	 * @param errorCode
	 *            Error code for validation failures
	 */
	@Autowired
	public LengthRule(@Value("${MINIMUM_LENGTH}") final int minLength, @Value("${MAXIMUM_LENGTH}") final int maxLength,
			@Value("${ILLEGAL_LENGTH}") final String errorCode) {
		minimumLength = minLength;
		maximumLength = maxLength;
		this.errorCode = errorCode;
	}

	/**
	 * @return the minimumLength
	 */
	public int getMinimumLength() {
		return minimumLength;
	}

	/**
	 * @return the maximumLength
	 */
	public int getMaximumLength() {
		return maximumLength;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * method to validate password length
	 * 
	 * @return true if password length is between minimumLength and
	 *         maximumLength characters long otherwise false
	 */
	@Override
	public boolean isValid(String password) {
		boolean isValid = false;

		if (StringUtils.isNotBlank(password)) {
			final int length = password.length();
			if (length >= minimumLength && length <= maximumLength) {
				isValid = true;
			}
		}
		return isValid;
	}

	/**
	 * Returns error message from messages.properties file based upon error
	 * code, replacement arguments and default locale
	 * 
	 * @param messageSource
	 *            spring message source
	 * @return error message
	 */
	@Override
	public String getMessage(final MessageSource messageSource) {
		return messageSource.getMessage(errorCode, new Object[] { minimumLength, maximumLength }, Locale.getDefault());
	}

}
