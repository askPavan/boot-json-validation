package com.boot.custom;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = EnumValidator.class)  // Ensure the correct validator is used
@Target({ ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateEnum {

    // Enum class to be validated against
    Class<? extends Enum<?>> enumClass();

    // Error message to be used when the validation fails
    String message() default "Invalid enum value";

    // Grouping for validation (optional)
    Class<?>[] groups() default {};

    // Additional metadata (optional)
    Class<? extends Payload>[] payload() default {};
}
