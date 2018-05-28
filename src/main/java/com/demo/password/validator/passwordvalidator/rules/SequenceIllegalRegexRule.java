/**
 * 
 */
package com.demo.password.validator.passwordvalidator.rules;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Rule class for checking repeated character sequence in password which extends
 * the IllegalRegexRule abstract class
 * 
 * @author Dushyant sahu
 * @version 0.1
 * @since Dec, 2017
 *
 */
@Component
@PropertySource(value = { "regex.properties" })
public class SequenceIllegalRegexRule extends IllegalRegexRule {

	/**
	 * Create a new SequenceIllegalRegexRule object. This constructor will be
	 * called during object creation with configured regEx and error code.
	 *
	 * @param regex
	 *            regular expression
	 * 
	 * @param errorCode
	 *            Error code for regex validation failures
	 */
	public SequenceIllegalRegexRule(@Value("${ILLEGAL_SEQUENCE_REGEX}") final String regex,
			@Value("${ILLEGAL_SEQUENCE}") final String errorCode) {
		super(regex, errorCode);
	}

}
