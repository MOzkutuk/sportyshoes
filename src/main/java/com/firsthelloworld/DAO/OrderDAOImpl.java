/**
 * Project: sportyshoes
 * Package: com.firsthelloworld.DAO
 * Created By: Mehmet Baran Ozkutuk
 */

package com.firsthelloworld.DAO;

import com.firsthelloworld.entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public class OrderDAOImpl implements OrderDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void makePurchase(Order order) {

        Session session = sessionFactory.getCurrentSession();

       session.save(order);

    }
}
