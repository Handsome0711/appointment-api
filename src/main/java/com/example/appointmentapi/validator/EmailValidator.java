package com.example.appointmentapi.validator;

import com.example.appointmentapi.annotation.EmailConstraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements
        ConstraintValidator<EmailConstraint, String> {

    @Override
    public boolean isValid(String email,
                           ConstraintValidatorContext constraintValidatorContext) {
        String regexp = ".+@.+\\..+";
        return email != null && email.matches(regexp)
                && email.length() > 7 && email.length() < 50;
    }
}
