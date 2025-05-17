package com.arpan.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<ValidEmail, String> {

	private static final String EMAIL_REGEX = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		return email != null && email.matches(EMAIL_REGEX);
	}

}
