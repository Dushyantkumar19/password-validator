/**
 * 
 */
package com.demo.password.validator.passwordvalidator.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.demo.password.validator.passwordvalidator.rules.CharacterAllowedRegexRule;
import com.demo.password.validator.passwordvalidator.rules.LengthRule;
import com.demo.password.validator.passwordvalidator.rules.Rule;
import com.demo.password.validator.passwordvalidator.rules.SequenceIllegalRegexRule;

/**
 * Implementation class for CacheService.
 * 
 * @author dushyant sahu
 * @version 0.1
 * @since Dec, 2017
 *
 */
@Component
@PropertySource(value = { "regex.properties" })
public class CacheServiceImpl implements CacheService {

	/** logger for CacheService */
	private static final Logger logger = LoggerFactory.getLogger(CacheServiceImpl.class);

	/** info message */
	private static final String CONFIGURING_RULES = "Configuring password rules..";

	/** regEx for CharacterAllowedRegexRule */
	@Value("${ILLEGAL_CHARACTER_REGEX}")
	private String characterAllowedRegex;

	/** error code for CharacterAllowedRegexRule */
	@Value("${ILLEGAL_CHARACTER}")
	private String characterAllowedErrorCode;

	/** regEx for SequenceIllegalRegexRule */
	@Value("${ILLEGAL_SEQUENCE_REGEX}")
	private String sequenceIllegalRegex;

	/** error code for SequenceIllegalRegexRule */
	@Value("${ILLEGAL_SEQUENCE}")
	private String sequenceIllegalErrorCode;

	/** minimumLength for LegthRule */
	@Value("${MINIMUM_LENGTH}")
	private int minimumLength;

	/** maximumLength for LegthRule */
	@Value("${MAXIMUM_LENGTH}")
	private int maximumLength;

	/** error code for LengthRule */
	@Value("${ILLEGAL_LENGTH}")
	private String illegalLengthErrorCode;

	
	/**
	 * This method is used to configure the password validation rules.
	 * 
	 * Caches the list of password validation rules.
	 * 
	 * @return list of cached password validation rules.
	 */
	@Cacheable("passwordRules")
	public List<Rule> configurePasswordRules() {
		logger.info(CONFIGURING_RULES);
		return Arrays.asList(
				new SequenceIllegalRegexRule(sequenceIllegalRegex, sequenceIllegalErrorCode),
				new CharacterAllowedRegexRule(characterAllowedRegex, characterAllowedErrorCode),
				new LengthRule(minimumLength, maximumLength, illegalLengthErrorCode)
				);
	}
}
