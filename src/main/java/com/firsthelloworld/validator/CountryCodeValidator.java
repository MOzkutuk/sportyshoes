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

public class CountryCodeValidator implements ConstraintValidator<CountryCode,String> {

    private int lower;
    private int upper;

    @Override
    public void initialize(CountryCode countryCode) {

        this.lower = countryCode.lower();
        this.upper = countryCode.upper();

    }

    @Override
    public boolean isValid(String mobile, ConstraintValidatorContext context) {

        Pattern pattern = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(mobile);
        boolean doesContain = matcher.find();


        if(doesContain || mobile.length() < lower || mobile.length() > upper || mobile.matches(".*[QWERTYUIOPASDFGHJKLZXCVBNM].*") || mobile.isBlank()){
            return  false;
        }

        return true;
    }
}
