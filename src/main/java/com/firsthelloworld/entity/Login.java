/**
 * Project: sportyshoes
 * Package: com.firsthelloworld.entity
 * Created By: Mehmet Baran Ozkutuk
 */

package com.firsthelloworld.entity;

import com.firsthelloworld.validator.Password;
import com.firsthelloworld.validator.Username;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
@NotNull
public class Login {

    @Column(name = "username",unique = true)
    @Username
    private String username;

    @Column(name = "password")
    @Password
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
