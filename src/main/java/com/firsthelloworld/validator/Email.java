package com.firsthelloworld.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = EmailValidator.class)
public @interface Email {

    String message() default "{EmailErrorMessage}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
