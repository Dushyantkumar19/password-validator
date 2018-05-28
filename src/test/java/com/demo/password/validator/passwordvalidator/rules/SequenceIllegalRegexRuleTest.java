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
 * junit test class for Password SequenceIllegalRegexRule class.
 * 
 * @author dushyant sahu
 * @version 0.1
 * @since Dec, 2017
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class SequenceIllegalRegexRuleTest {

	/**
	 * Sequence Repetition RegEx Password Rule.
	 */
	@Autowired
	private SequenceIllegalRegexRule sequenceIllegalRegexRule;

	@Test
	public void testSequenceNotViolated() {
		boolean result = sequenceIllegalRegexRule.isValid("abcde12345");
		assertTrue(result);
	}

	@Test
	public void testSequenceRepeatLetters() {
		boolean result = sequenceIllegalRegexRule.isValid("abab");
		assertFalse(result);
	}

	@Test
	public void testSequenceRepeatSingleLetter() {
		boolean result = sequenceIllegalRegexRule.isValid("aa");
		assertTrue(result);
	}

	@Test
	public void testSequenceRepeatDigits() {
		boolean result = sequenceIllegalRegexRule.isValid("1212");
		assertFalse(result);
	}

	@Test
	public void testSequenceRepeatSingleDigit() {
		boolean result = sequenceIllegalRegexRule.isValid("11");
		assertTrue(result);
	}

	@Test
	public void testSequenceRepeatLettersAndDigits() {
		boolean result = sequenceIllegalRegexRule.isValid("ab1ab1");
		assertFalse(result);
	}

	@Test
	public void testSequenceRepeatLettersNotAtFront() {
		boolean result = sequenceIllegalRegexRule.isValid("prefixabab");
		assertFalse(result);
	}

	@Test
	public void testSequenceRepeatLettersNotAtBack() {
		boolean result = sequenceIllegalRegexRule.isValid("ababpostfix");
		assertFalse(result);
	}

	@Test
	public void testSequenceRepeatLettersAtMiddle() {
		boolean result = sequenceIllegalRegexRule.isValid("preababpostfix");
		assertFalse(result);
	}

	@Test
	public void testSequenceRepeatDigitsNotAtFront() {
		boolean result = sequenceIllegalRegexRule.isValid("prefix1212");
		assertFalse(result);
	}

	@Test
	public void testSequenceRepeatDigitsNotAtBack() {
		boolean result = sequenceIllegalRegexRule.isValid("1212postfix");
		assertFalse(result);
	}

	@Test
	public void testSequenceRepeatDigitsAtMiddle() {
		boolean result = sequenceIllegalRegexRule.isValid("pre1212postfix");
		assertFalse(result);
	}

	@Test
	public void testIfPasswordNull() {
		boolean result = sequenceIllegalRegexRule.isValid(null);
		assertFalse(result);
	}

	@Test
	public void testIfPasswordEmpty() {
		boolean result = sequenceIllegalRegexRule.isValid("");
		assertFalse(result);
	}

	@Test
	public void testIfPasswordWhiteSpace() {
		boolean result = sequenceIllegalRegexRule.isValid(" ");
		assertFalse(result);
	}
}
