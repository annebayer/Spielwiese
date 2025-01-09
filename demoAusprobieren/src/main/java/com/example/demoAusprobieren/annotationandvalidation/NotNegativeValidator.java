package com.example.demoausprobieren.annotationandvalidation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NotNegativeValidator implements ConstraintValidator<NotNegative, Number> {

    @Override
    public void initialize(NotNegative constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Number number, ConstraintValidatorContext constraintValidatorContext) {
        if (number == null) {
            return false;
        }
        return number.doubleValue() > 0;
    }
}
