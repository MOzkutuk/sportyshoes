/**
 * Project: sportyshoes
 * Package: com.firsthelloworld.entity
 * Created By: Mehmet Baran Ozkutuk
 */

package com.firsthelloworld.entity;

import com.firsthelloworld.validator.CountryCode;
import com.firsthelloworld.validator.Mobile;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
@NotNull
public class Phone {

    @Column(name = "country_code")
    @CountryCode
    private String countryCode;

    @Column(name = "mobile_number",unique = true)
    @Mobile
    private String mobileNumber;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

}
