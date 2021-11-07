package com.firsthelloworld.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = AreaValidator.class)
public @interface Area {

    String message() default "{areaErrorMessage}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
