package com.firsthelloworld.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = PasswordValidator.class)
public @interface Password {

    String message() default "{invalidPasswordMessage}";

    int lower() default 10;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
