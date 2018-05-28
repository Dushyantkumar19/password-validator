/**
 * 
 */
package com.demo.password.validator.passwordvalidator.rules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Rule class for checking whether password contains both a letter and a digit
 * which extends AllowedRegexRule abstract class
 * 
 * @author Dushyant sahu
 * @version 0.1
 * @since Dec, 2017
 *
 */
@Component
@PropertySource(value = { "regex.properties" })
public class CharacterAllowedRegexRule extends AllowedRegexRule {

	/**
	 * Create a new CharacterAllowedRegexRule object. This constructor will be
	 * called during object creation with configured regEx and error code.
	 *
	 * @param regex
	 *            regular expression
	 * 
	 * @param errorCode
	 *            Error code for regex validation failures
	 */
	@Autowired
	public CharacterAllowedRegexRule(@Value("${ILLEGAL_CHARACTER_REGEX}") final String regex,
			@Value("${ILLEGAL_CHARACTER}") final String errorCode) {
		super(regex, errorCode);
	}

}
