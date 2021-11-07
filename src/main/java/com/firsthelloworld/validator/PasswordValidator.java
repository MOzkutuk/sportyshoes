/**
 * Project: sportyshoes
 * Package: com.firsthelloworld.validator
 * Created By: Mehmet Baran Ozkutuk
 */

package com.firsthelloworld.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator implements ConstraintValidator<Password,String> {

    private int lower;

    @Override
    public void initialize(Password password) {

        this.lower = password.lower();

    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {

        Pattern pattern = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(password);
        boolean doesContain = matcher.find();

        if(password.isBlank() || !doesContain || !password.matches(".*\\d.*") || password.length() < lower ){
            return false;
        }

        return true;
    }
}
