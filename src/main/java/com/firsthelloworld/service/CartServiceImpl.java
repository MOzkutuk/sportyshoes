/**
 * Project: sportyshoes
 * Package: com.firsthelloworld.service
 * Created By: Mehmet Baran Ozkutuk
 */

package com.firsthelloworld.service;

import com.firsthelloworld.DAO.CartDAO;
import com.firsthelloworld.entity.Cart;
import com.firsthelloworld.entity.Customer;
import com.firsthelloworld.entity.Shoe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    private CartDAO cartDAO;

    @Override
    public List<Cart> getCarts() {
        return cartDAO.getCarts();
    }

    @Override
    public Cart getCartById(Long id) {

        Cart cart = cartDAO.getCartById(id);

        if(cart.getId() == null){
            //throw new exception
        }

        return cart;
    }
}
