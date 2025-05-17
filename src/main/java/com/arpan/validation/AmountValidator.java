package com.arpan.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AmountValidator implements ConstraintValidator<ValidAmount, Double> {

	@Override
	public boolean isValid(Double value, ConstraintValidatorContext context) {
		if (value == null)
			return false;

		if (value < 0) {
			setMessage(context, "Amount must be positive");
			return false;
		} else if (value == 0) {
			setMessage(context, "Amount must be greater than 0");
			return false;
		}

		return true;
	}

	private void setMessage(ConstraintValidatorContext context, String message) {
		context.disableDefaultConstraintViolation();
		context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
	}

}
