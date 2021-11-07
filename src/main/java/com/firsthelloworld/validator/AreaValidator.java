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

public class AreaValidator implements ConstraintValidator<Area,String > {

    @Override
    public void initialize(Area area) {

    }

    @Override
    public boolean isValid(String area, ConstraintValidatorContext context) {

        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(area);
        boolean isAreaValid = m.find();

        if(area.matches(".*\\d.*") || isAreaValid || area.isBlank()){
            return false;
        }

        return true;
    }
}
