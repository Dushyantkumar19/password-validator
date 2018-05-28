/**
 * 
 */
package com.demo.password.validator.passwordvalidator.service;

import java.util.List;

import com.demo.password.validator.passwordvalidator.rules.Rule;

/**
 * Interface for providing cache service for password validation.
 * 
 * @author dushyant sahu
 * @version 0.1
 * @since Dec, 2017
 *
 */
public interface CacheService {

	/**
	 * This method is used to cache the list password validation rules.
	 * 
	 * @return list of cached password validation rules
	 */
	List<Rule> configurePasswordRules();
}
