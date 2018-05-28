/**
 * 
 */
package com.demo.password.validator.passwordvalidator.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.password.validator.passwordvalidator.AppConfig;
import com.demo.password.validator.passwordvalidator.rules.ValidationResult;

/**
 * junit test class for PasswordValidationService service.
 * 
 * @author dushyant sahu
 * @version 0.1
 * @since Dec, 2017
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class PasswordValidationServiceTest {

	public static final String ERROR_PASSWORD_SEQUENCE_REPEATED = "Must not contain any sequence of characters immediately followed by the same sequence.";
	public static final String ERROR_PASSWORD_LENGTH = "Password must be between 5 and 12 characters long.";
	public static final String ERROR_LETTER_AND_DIGIT = "Must consist of a mixture of lowercase letters and numerical digits only, with at least one of each.";

	/**
	 * Password Validation Service class
	 */
	@Autowired
	private PasswordValidationService passwordValidationService;

	@Before
	public void getPasswordValidationServiceFromIOC() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		passwordValidationService = ctx.getBean(PasswordValidationService.class);
		((AnnotationConfigApplicationContext) ctx).close();
	}

	@Test
	public void testNumberOfRulesExecuted() {
		ValidationResult result = passwordValidationService.validate("abcde12345");
		assertEquals(3, result.getNumberOfRulesExecuted());
	}

	@Test
	public void testValidateSuccess() {
		ValidationResult result = passwordValidationService.validate("abcde12345");
		assertEquals(true, result.getMessages().isEmpty());
	}

	@Test
	public void testValidateFailureForNoDigit() {
		ValidationResult result = passwordValidationService.validate("abcde");
		assertFalse(result.getMessages().isEmpty());
		assertTrue(result.getMessages().contains((ERROR_LETTER_AND_DIGIT)));
		assertFalse(result.getMessages().contains(ERROR_PASSWORD_LENGTH));
		assertFalse(result.getMessages().contains(ERROR_PASSWORD_SEQUENCE_REPEATED));
	}

	@Test
	public void testValidateFailureForNoLetter() {
		ValidationResult result = passwordValidationService.validate("12345");
		assertFalse(result.getMessages().isEmpty());
		assertTrue(result.getMessages().contains((ERROR_LETTER_AND_DIGIT)));
		assertFalse(result.getMessages().contains(ERROR_PASSWORD_LENGTH));
		assertFalse(result.getMessages().contains(ERROR_PASSWORD_SEQUENCE_REPEATED));
	}

	@Test
	public void testValidateFailureForShortLength() {
		ValidationResult result = passwordValidationService.validate("ab12");
		assertFalse(result.getMessages().isEmpty());
		assertFalse(result.getMessages().contains((ERROR_LETTER_AND_DIGIT)));
		assertTrue(result.getMessages().contains(ERROR_PASSWORD_LENGTH));
		assertFalse(result.getMessages().contains(ERROR_PASSWORD_SEQUENCE_REPEATED));
	}

	@Test
	public void testValidateFailureForSeqRepeat() {
		ValidationResult result = passwordValidationService.validate("abab1");
		assertFalse(result.getMessages().isEmpty());
		assertFalse(result.getMessages().contains((ERROR_LETTER_AND_DIGIT)));
		assertFalse(result.getMessages().contains(ERROR_PASSWORD_LENGTH));
		assertTrue(result.getMessages().contains(ERROR_PASSWORD_SEQUENCE_REPEATED));
	}

}
