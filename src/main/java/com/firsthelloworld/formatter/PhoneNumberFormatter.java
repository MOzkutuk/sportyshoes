/**
 * Project: sportyshoes
 * Package: com.firsthelloworld.formatter
 * Created By: Mehmet Baran Ozkutuk
 */

package com.firsthelloworld.formatter;

import com.firsthelloworld.entity.Phone;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class PhoneNumberFormatter implements Formatter<Phone> {

    @Override
    public Phone parse(String text, Locale locale) throws ParseException {

        Phone details = new Phone();

        //split the string received from user
        String[] phoneNumberArray = text.split("-");

        //whether the number consist of "-"
        int index = text.indexOf("-");

        //if "-" not found we will receive -1
        if(index == -1){

            //if the "-" is not found then add 90 as the default country code

            details.setCountryCode("90");
            details.setMobileNumber(phoneNumberArray[0]);

        }else{

            if(phoneNumberArray[0].isBlank()){

                //if the field is empty set the country code to 90 as default
                details.setCountryCode("90");
            }else{

                //extract the country code and set it ti the phone class
                details.setCountryCode(phoneNumberArray[0]);
                details.setMobileNumber(phoneNumberArray[1]);

            }

        }

        return details;
    }

    @Override
    public String print(Phone object, Locale locale) {

        return object.getCountryCode() + "-" + object.getMobileNumber();
    }
}
