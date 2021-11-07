/**
 * Project: sportyshoes
 * Package: com.firsthelloworld.create
 * Created By: Mehmet Baran Ozkutuk
 */

package com.firsthelloworld.create;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Create {
    public static void main(String[] args) {
      SessionFactory sessionFactory = new Configuration()
              .configure()
              .buildSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.getTransaction().commit();
        session.close();

    }




}
