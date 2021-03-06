package com.example.appointmentapi.annotation;

import com.example.appointmentapi.validator.PasswordMatchValidator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = PasswordMatchValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordValueMatch {
    String message() default "Passwords does't matches";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
