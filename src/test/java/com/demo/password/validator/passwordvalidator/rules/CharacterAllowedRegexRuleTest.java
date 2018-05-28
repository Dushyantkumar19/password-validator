/**
 * 
 */
package com.demo.password.validator.passwordvalidator.rules;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.password.validator.passwordvalidator.AppConfig;

/**
 * junit test class for CharacterAllowedRegexRule class.
 * 
 * @author dushyant sahu
 * @version 0.1
 * @since Dec, 2017
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class CharacterAllowedRegexRuleTest {

	/**
	 * Letter and Digit RegEx Password Rule.
	 */
	@Autowired
	private CharacterAllowedRegexRule characterAllowedRegexRule;

	@Test
	public void testContainsOnlyLowercaseLetters() {
		boolean result = characterAllowedRegexRule.isValid("abcde");
		assertFalse((result));
	}

	@Test
	public void testContainsUppercaseLetters() {
		boolean result = characterAllowedRegexRule.isValid("Abcde");
		assertFalse(result);
	}

	@Test
	public void testContainsBothLetterAndDigit() {
		boolean result = characterAllowedRegexRule.isValid("a0");
		assertTrue(result);
	}

	@Test
	public void testContainsBothDigitAndLetter() {
		boolean result = characterAllowedRegexRule.isValid("0a");
		assertTrue(result);
	}

	@Test
	public void testContainsOnlyLetters() {
		boolean result = characterAllowedRegexRule.isValid("a");
		assertFalse(result);
	}

	@Test
	public void testContainsOnlyDigits() {
		boolean result = characterAllowedRegexRule.isValid("0");
		assertFalse(result);
	}

	@Test
	public void testIfPasswordNull() {
		boolean result = characterAllowedRegexRule.isValid(null);
		assertFalse(result);
	}

	@Test
	public void testIfPasswordEmpty() {
		boolean result = characterAllowedRegexRule.isValid("");
		assertFalse(result);
	}

	@Test
	public void testIfPasswordWhiteSpace() {
		boolean result = characterAllowedRegexRule.isValid(" ");
		assertFalse(result);
	}

}
