/**
 * Project: sportyshoes
 * Package: com.firsthelloworld.DAO
 * Created By: Mehmet Baran Ozkutuk
 */

package com.firsthelloworld.DAO;

import com.firsthelloworld.entity.Admin;
import com.firsthelloworld.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AdminDAOImpl implements AdminDAO
{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean checkAdminLogin(String username, String password) {

        Session session = sessionFactory.getCurrentSession();

        boolean adminFound = false;

        Query query = session.createQuery("FROM Admin a where a.login.username = :username and a.login.password = :password");
        query.setParameter("username",username);
        query.setParameter("password",password);

        List<Admin> list = query.list();

        if(list != null && list.size() > 0){
            adminFound = true;
        }

        return adminFound;
    }

    @Override
    public List<Admin> findAdminByUserName(String username, String password) {

        Session session = sessionFactory.getCurrentSession();

        Query<Admin> query = session.createQuery("FROM Admin a where a.login.username = :username and a.login.password = :password");

        query.setParameter("username", username);
        query.setParameter("password", password);

        List<Admin> admins = query.list();

        return admins;
    }

    @Override
    public int changeAdminPassword(String password) {

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("update Admin a set a.login.password = :password");
        query.setParameter("password",password);

        int i = query.executeUpdate();

        return i;
    }
}
