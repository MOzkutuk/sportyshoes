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

public class PriceValidator implements ConstraintValidator<Price,String > {

    private int upper;

    @Override
    public void initialize(Price price) {

        this.upper = price.upper();

    }

    @Override
    public boolean isValid(String price, ConstraintValidatorContext context) {

        Pattern pattern = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(price);
        boolean doesContain = matcher.find();

        if(doesContain || price.isBlank() || price.matches(".*[QWERTYUIOPASDFGHJKLZXCVBNM].*") || price.length() > upper){
            return false;
        }

        return true;
    }
}
