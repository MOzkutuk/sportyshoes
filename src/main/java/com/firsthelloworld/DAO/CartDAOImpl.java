/**
 * Project: sportyshoes
 * Package: com.firsthelloworld.DAO
 * Created By: Mehmet Baran Ozkutuk
 */

package com.firsthelloworld.DAO;

import com.firsthelloworld.entity.Cart;
import com.firsthelloworld.entity.Shoe;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CartDAOImpl implements CartDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Cart> getCarts() {

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("FROM Cart ");

        List<Cart> shoeList = query.list();

        return shoeList;
    }

    public Cart getCartById(Long id){

        Session session = sessionFactory.getCurrentSession();

        Cart cart = session.get(Cart.class, id);

        return cart;
    }
}
