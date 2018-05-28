/**
 * 
 */
package com.demo.password.validator.passwordvalidator.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import com.demo.password.validator.passwordvalidator.rules.Rule;
import com.demo.password.validator.passwordvalidator.rules.ValidationResult;

/**
 * Implementation class for PasswordValidationService interface
 * 
 * @author dushyant sahu
 * @version 0.1
 * @since Dec, 2017
 *
 */
@Component
public class PasswordValidationServiceImpl implements PasswordValidationService {

	/** logger object for logging error/info messages */
	private static final Logger logger = LoggerFactory.getLogger(PasswordValidationServiceImpl.class);

	/** error message for password empty */
	private static final String ERROR_PASSWORD_NULL_OR_EMPTY = "Password must not be null or empty!";

	/** info message for password validation */
	private static final String PASSWORD_VALIDATION = "Entering into password validation..";

	/** success message for password validation */
	private static final String SUCCESS_MESSAGE = "password validation completed and supplied password string output is {} ";

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private CacheService cacheService;

	/**
	 * Runs the set of configured validation rules for the supplied password and
	 * returns a {@link ValidationResult} with set of messages object if the
	 * password is invalid
	 * 
	 * @param password
	 * @return {@link ValidationResult} The validation result
	 */
	@Override
	public ValidationResult validate(final String password) {
		logger.info(PASSWORD_VALIDATION);

		Set<String> messages = new HashSet<String>();
		boolean isValid = true;
		int numberOfRulesExecuted = 0;

		// checking if a password is whitespace, empty ("") or null.
		if (StringUtils.isBlank(password)) {
			logger.info(ERROR_PASSWORD_NULL_OR_EMPTY);
			isValid = false;
			messages.add(ERROR_PASSWORD_NULL_OR_EMPTY);
		} else {
			List<Rule> rules = cacheService.configurePasswordRules();
			for (Rule rule : rules) {
				numberOfRulesExecuted++;
				if (!rule.isValid(password)) {
					messages.add(rule.getMessage(messageSource));
				}
			}
			if (!messages.isEmpty()) {
				isValid = false;
			}
		}

		ValidationResult validationResult = new ValidationResult(isValid, messages, numberOfRulesExecuted);
		logger.info(SUCCESS_MESSAGE, validationResult);

		return validationResult;
	}

}
