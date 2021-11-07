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

public class ShoeSizeValidator implements ConstraintValidator<ShoeSize, String> {

    @Override
    public void initialize(ShoeSize size) {
    }

    @Override
    public boolean isValid(String size, ConstraintValidatorContext context) {

        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(size);
        boolean isSizeValid = m.find();


        if (isSizeValid || size.matches(".*[QWERTYUIOPASDFGHJKLZXCVBNM].*") || size.isBlank()) {
            return false;
        }

        return true;
    }
}
