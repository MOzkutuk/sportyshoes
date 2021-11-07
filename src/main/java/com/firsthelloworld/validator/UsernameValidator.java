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

public class UsernameValidator implements ConstraintValidator<Username,String> {

    private int lower;
    private int upper;

    @Override
    public void initialize(Username username) {

        this.lower = username.lower();
        this.upper = username.upper();

    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {

        Pattern pattern = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(username);
        boolean doesContain = matcher.find();

        //checking whether the string has number or special character or is null

        if(username.isBlank() || !doesContain || !username.matches(".*\\d.*") || username.length() < lower || username.length() > upper){
            return false;
        }
        return true;


    }
}
