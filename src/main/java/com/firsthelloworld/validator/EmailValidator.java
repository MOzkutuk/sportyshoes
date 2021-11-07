/**
 * Project: sportyshoes
 * Package: com.firsthelloworld.validator
 * Created By: Mehmet Baran Ozkutuk
 */

package com.firsthelloworld.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<Email,String> {

    @Override
    public void initialize(Email email) {
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {

        if(!email.contains("@") || email.isBlank() || !email.contains(".com")){
            return false;
        }

        return true;
    }
}
