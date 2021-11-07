/**
 * Project: sportyshoes
 * Package: com.firsthelloworld.entity
 * Created By: Mehmet Baran Ozkutuk
 */

package com.firsthelloworld.entity;

import javax.persistence.*;

@Entity
@Table(name = "admins")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private int id;

    @Column(name = "first_name",unique = true)
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Embedded
    private Login login;

    @Embedded
    private Phone phone;

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Phone getContactDetails() {
        return phone;
    }

    public void setContactDetails(Phone phone) {
        this.phone = phone;
    }
}
