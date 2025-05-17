package com.arpan.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MobileNumberValidator implements ConstraintValidator<ValidMobileNumber, String> {

    private static final String MOBILE_PATTERN = "^[6-9]\\d{9}$";

    @Override
    public boolean isValid(String mobile, ConstraintValidatorContext context) {
    	
        return mobile != null && mobile.matches(MOBILE_PATTERN);
    }
}

