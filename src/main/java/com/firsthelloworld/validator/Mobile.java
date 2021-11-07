package com.firsthelloworld.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = MobileValidator.class)
public @interface Mobile {

    String message() default "{mobileErrorMessage}";

    int lower() default 5;

    int upper() default 15;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
