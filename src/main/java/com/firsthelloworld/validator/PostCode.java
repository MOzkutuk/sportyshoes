package com.firsthelloworld.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = PostCodeValidator.class)
public @interface PostCode {

    String message() default "{PostalCodeErrorMessage}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
