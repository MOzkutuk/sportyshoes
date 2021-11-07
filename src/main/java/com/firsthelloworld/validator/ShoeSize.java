package com.firsthelloworld.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = ShoeSizeValidator.class)
public @interface ShoeSize {

    String message() default "{ShoeSizeErrorMessage}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
