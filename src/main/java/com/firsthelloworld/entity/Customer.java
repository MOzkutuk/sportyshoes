/**
 * Project: sportyshoes
 * Package: com.firsthelloworld.entity
 * Created By: Mehmet Baran Ozkutuk
 */

package com.firsthelloworld.entity;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @Column(name = "customer_name",unique = true)
    @NotBlank(message = "* First name can't be blank")
    @Size(max = 40,message = "* First name cannot exceed 40 character")
    private String name;

    @Column(name = "customer_surname",unique = true)
    @NotBlank(message = "* Last name can't be blank")
    @Size(max = 40,message = "Last name cannot exceed 40 character")
    private String surname;

    @Embedded
    @Valid
    private  Login login; //composite value type

    @Embedded
    @Valid
    private Phone phone; //composite value type

    @Embedded
    @Valid
    private ContactDetails contactDetails; //composite value type

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "cart_id",referencedColumnName = "cart_id",unique = true ,nullable = false)
    private Cart cart = new Cart();

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id",referencedColumnName = "order_id",unique = true)
    private Order order;

    @Override
    public String toString() {
        return " SUCCESSFUL !    Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
