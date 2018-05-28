/**
 * 
 */
package com.demo.password.validator.passwordvalidator.rules;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.MessageSource;

/**
 * Abstract Rule class for determining if a password matches an allowed regular
 * expression. Passwords must match the expression or validation will fail.
 *
 * @author dushyant sahu
 * @version 0.1
 * @since Dec, 2017
 */
public abstract class AllowedRegexRule implements Rule {

	/** Error code for RegEx validation failures. */
	private final String errorCode;

	/** RegEx pattern. */
	private final Pattern pattern;

	/**
	 * Creates a new allowed RegEx rule. This constructor will be called during
	 * AllowedRegex rule object creation with provided regEx and error code and
	 * provide pre-compiled RegEx pattern object based upon RegEx provided.
	 *
	 * @param regex
	 *            regular expression
	 * 
	 * @param errorCode
	 *            Error code for regex validation failures
	 */
	public AllowedRegexRule(final String regex, final String errorCode) {
		this.errorCode = errorCode;
		this.pattern = Pattern.compile(regex);
	}

	/**
	 * Returns the pattern for this rule.
	 *
	 * @return pattern
	 */
	public Pattern getPattern() {
		return pattern;
	}

	/**
	 * Returns the errorCode for this rule.
	 * 
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * Default implementation of isValid method based upon RegEx provided.
	 * Passwords must match the expression or validation will fail
	 * 
	 * @param password
	 *            supplied password
	 * 
	 * @return true if password matches regex otherwise false
	 */
	public boolean isValid(final String password) {
		boolean isValid = false;

		if (StringUtils.isNotBlank(password)) {
			final Matcher matcher = pattern.matcher(password);
			isValid = matcher.matches();
		}
		return isValid;
	}

	/**
	 * Returns error message from messages.properties file based upon error code
	 * and default locale
	 * 
	 * @param messageSource
	 *            spring message source
	 * @return error message
	 */
	@Override
	public String getMessage(final MessageSource messageSource) {
		return messageSource.getMessage(errorCode, null, Locale.getDefault());
	}

}
