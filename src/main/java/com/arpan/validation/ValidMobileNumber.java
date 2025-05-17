package com.arpan.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

//Spring Boot only validates parameters annotated with @RequestParam, @RequestBody, or method-level annotations.

@Documented
@Constraint(validatedBy = MobileNumberValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })

// ElementType.FIELD inside class
// ElementType.PARAMETER for single parameter 
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidMobileNumber {
	String message() default "Invalid mobile number";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
