package com.boot.custom;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class EnumValidator implements ConstraintValidator<ValidateEnum, Enum<?>> {

    private Class<? extends Enum<?>> enumClass;

    @Override
    public void initialize(ValidateEnum constraintAnnotation) {
        this.enumClass = constraintAnnotation.enumClass();
    }

    @Override
    public boolean isValid(Enum<?> value, ConstraintValidatorContext context) {
        if (value == null) {
            return false; // Return false when the enum value is null
        }

        // Check if the value exists in the enum constants
        boolean validEnum = Arrays.stream(enumClass.getEnumConstants())
                .anyMatch(e -> e.name().equals(value.name()));

        // If the value is invalid, we will set the custom error message
        if (!validEnum) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Invalid enum value")
                    .addConstraintViolation();
        }

        return validEnum;
    }
}

