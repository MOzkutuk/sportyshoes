package com.firsthelloworld.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = UsernameValidator.class)
public @interface Username {

    String message() default "{invalidUsernameMessage}";

    int lower() default 7;

    int upper() default 23;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
