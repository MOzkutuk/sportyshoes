/**
 * Project: sportyshoes
 * Package: com.firsthelloworld.DAO
 * Created By: Mehmet Baran Ozkutuk
 */

package com.firsthelloworld.DAO;

import com.firsthelloworld.entity.Cart;
import com.firsthelloworld.entity.Customer;
import com.firsthelloworld.entity.Shoe;

import java.util.List;

public interface CartDAO {

    List<Cart> getCarts();
    public Cart getCartById(Long id);
}
