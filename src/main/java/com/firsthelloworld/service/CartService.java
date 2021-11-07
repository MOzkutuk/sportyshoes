/**
 * Project: sportyshoes
 * Package: com.firsthelloworld.service
 * Created By: Mehmet Baran Ozkutuk
 */

package com.firsthelloworld.service;

import com.firsthelloworld.entity.Cart;
import com.firsthelloworld.entity.Customer;
import com.firsthelloworld.entity.Shoe;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {
    List<Cart> getCarts();
    public Cart getCartById(Long id);
}
