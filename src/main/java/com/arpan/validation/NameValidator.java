package com.arpan.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<ValidName, String> {

	private static final String UPPERCASE_NAME_REGEX = "^[A-Z]+$";

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return value != null && value.matches(UPPERCASE_NAME_REGEX);
	}

}
