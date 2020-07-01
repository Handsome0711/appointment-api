package com.example.appointmentapi.validator;

import com.example.appointmentapi.annotation.PasswordValueMatch;
import com.example.appointmentapi.model.dto.UserRegistrationDto;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchValidator implements
        ConstraintValidator<PasswordValueMatch, UserRegistrationDto> {

    @Override
    public boolean isValid(UserRegistrationDto userRegistrationDto,
                           ConstraintValidatorContext constraintValidatorContext) {
        return userRegistrationDto.getPassword() != null
                && userRegistrationDto.getRepeatPassword() != null
                && userRegistrationDto.getPassword()
                .equals(userRegistrationDto.getRepeatPassword());
    }
}
