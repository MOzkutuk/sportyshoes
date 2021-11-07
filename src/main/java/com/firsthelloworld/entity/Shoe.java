/**
 * Project: sportyshoes
 * Package: com.firsthelloworld.entity
 * Created By: Mehmet Baran Ozkutuk
 */

package com.firsthelloworld.entity;

import com.firsthelloworld.validator.Price;
import com.firsthelloworld.validator.ShoeSize;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shoes")
public class Shoe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shoe_id")
    private Long id;

    @Column(name = "shoe_name")
    @NotBlank(message = "Shoe name cannot be blank")
    private String name;

    @Column(name = "shoe_brand_name")
    @NotBlank(message = "Shoe brand cannot be blank")
    private String brand;

    @Column(name = "shoe_size")
    @ShoeSize
    private String size;

    @Column(name = "shoe_price")
    @Price
    private String price;

    @ManyToOne(fetch = FetchType.EAGER ,cascade = {
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.DETACH,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "cart_id",nullable = true)
    private Cart cart;

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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
