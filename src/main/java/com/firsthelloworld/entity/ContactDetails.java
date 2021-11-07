/**
 * Project: sportyshoes
 * Package: com.firsthelloworld.entity
 * Created By: Mehmet Baran Ozkutuk
 */

package com.firsthelloworld.entity;

import com.firsthelloworld.validator.Area;
import com.firsthelloworld.validator.Email;
import com.firsthelloworld.validator.PostCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Embeddable
@NotNull
public class ContactDetails {

    @Column(name = "address_line_1",nullable = false)
    @NotBlank(message = "Address line can't be empty")
    private String addressLine1;

    @Column(name = "address_line_2",nullable = true)
    private String addressLine2;

    @Column(name = "city")
    @Area
    private String city;

    @Column(name = "country")
    @Area
    private String country;

    @Column(name = "postal_code")
    @PostCode
    private String postalCode;

    @Column(name = "email_address",unique = true)
    @Email
    private String emailAddress;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
