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
 * junit test class for LengthRule class.
 * 
 * @author dushyant sahu
 * @version 0.1
 * @since Dec, 2017
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class LengthRuleTest {

	/**
	 * Character Length RegEx Password Rule.
	 */
	@Autowired
	private LengthRule lengthRule;

	@Test
	public void testSize5orMore() {
		boolean result = lengthRule.isValid("12345");

		assertTrue(result);
	}

	@Test
	public void testSizeLessThan5() {
		boolean result = lengthRule.isValid("1234");

		assertFalse(result);
	}

	@Test
	public void testSize12orLess() {
		boolean result = lengthRule.isValid("123456789112");

		assertTrue(result);
	}

	@Test
	public void testSizeMoreThan12() {
		boolean result = lengthRule.isValid("1234567891123");
		assertFalse(result);
	}

	@Test
	public void testIfPasswordNull() {
		boolean result = lengthRule.isValid(null);
		assertFalse(result);
	}

	@Test
	public void testIfPasswordEmpty() {
		boolean result = lengthRule.isValid("");
		assertFalse(result);
	}

	@Test
	public void testIfPasswordWhiteSpace() {
		boolean result = lengthRule.isValid(" ");
		assertFalse(result);
	}

}
