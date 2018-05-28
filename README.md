# password-validator
PASSWORD VALIDATION SERVICE
---------------------------
This is a basic password validation service works on set of configured rules.

How can I use the service?
--------------------------
Unzip file into local file system and run below steps to run the service.
This zip contains source distribution for password validation service and sample client app to access this service.
Client app is just to demonstrate how can we plugin password validation service directly in our application through Spring Ioc container.

How to build and deploy password validation service?
----------------------------------------------------
1) execute below commands from command prompt by navigating into passwordvalidator folder inside extracted folder
	i)  mvn clean
	ii) mvn install
	
This will create passwordvalidator jar to your local maven repository with below name 
.m2\com\epam\password\validator\passwordvalidator\0.1.0\passwordvalidator-0.1.0.jar

2) add the below dependency in your spring project pom.xml
		<dependency>
			<groupId>com.epam.password.validator</groupId>
			<artifactId>passwordvalidator</artifactId>
			<version>0.1.0</version>
		</dependency>

3) add below snippet to invoking class and method respectively.
	
	import com.epam.password.validator.passwordvalidator.rules.ValidationResult;
	import com.epam.password.validator.passwordvalidator.service.PasswordValidationService;
	
	@Autowired
	private PasswordValidationService passwordValidationService;
	
	ValidationResult validationResult = passwordValidationService.validate(password);
	
	
CONFIGURED RULES:
-----------------
       1) Must consist of a mixture of lowercase letters and numerical digits only.
       2) Must be between 5 and 12 characters in length.
       3) Must not contain any sequence of characters immediately followed by the same sequence.

	   
How to extend more rules / remove rules
----------------------------------------
You can manage rules by configurePasswordRules method available in CacheService service.

You can customize messages for each rule by updating messages.properties file available in src/main/resources folder. 

You can even modify the existing password rules by updating regex.properties file available in src/main/resources folder
i.e. ILLEGAL_SEQUENCE_REGEX, ILLEGAL_CHARACTER_REGEX, MINIMUM_LENGTH and/or MAXIMUM_LENGTH.

CACHING 
--------
Configured rules are loaded once and stored in the cache and for subsequent call rules will loaded from cache.

Assumption
-----------
1. Order of rule execution is NOT important, rules can be configured and/or executed in any order.
2. If no rules are being configured/set then password validation is successful.
