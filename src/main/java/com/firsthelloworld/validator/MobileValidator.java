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

public class MobileValidator implements ConstraintValidator<Mobile,String > {

    private int lower;
    private int upper;

    @Override
    public void initialize(Mobile mobile) {

        this.lower = mobile.lower();
        this.upper = mobile.upper();

    }

    @Override
    public boolean isValid(String mobile, ConstraintValidatorContext context) {

        Pattern pattern = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(mobile);
        boolean doesContain = matcher.find();

        if(mobile.isBlank() || doesContain || mobile.matches(".*[QWERTYUIOPASDFGHJKLZXCVBNM].*") || mobile.length() < lower || mobile.length() > upper){
            return false;
        }

        return true;
    }
}
