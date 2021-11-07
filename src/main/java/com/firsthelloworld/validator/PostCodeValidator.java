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

public class PostCodeValidator implements ConstraintValidator<PostCode,String > {

    @Override
    public void initialize(PostCode postCode) {

    }

    @Override
    public boolean isValid(String postCode, ConstraintValidatorContext context) {

        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(postCode);
        boolean isPostCodeValid = m.find();

        if(postCode.matches(".*[QWERTYUIOPASDFGHJKLZXCVBNM].*") || isPostCodeValid || postCode.isBlank()){
            return false;
        }


        return true;
    }
}
