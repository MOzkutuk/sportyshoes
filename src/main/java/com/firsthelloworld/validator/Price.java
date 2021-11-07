package com.firsthelloworld.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = PriceValidator.class)
public @interface Price {

    String message() default "{PriceErrorMessage}";

    int upper() default 7;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
