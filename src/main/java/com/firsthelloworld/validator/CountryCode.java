package com.firsthelloworld.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = CountryCodeValidator.class)
public @interface CountryCode {

    String message() default  "{mobileErrorMessageCountryCode}";

    int lower() default 1;

    int upper() default 6;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
