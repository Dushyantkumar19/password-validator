/**
 * 
 */
package com.demo.password.validator.passwordvalidator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Spring boot application class for password validation service
 * 
 * @author dushyant sahu
 * @version 0.1
 * @since Dec, 2017
 *
 */
@SpringBootApplication
@EnableCaching
public class PasswordValidatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PasswordValidatorApplication.class, args);
	}

}
