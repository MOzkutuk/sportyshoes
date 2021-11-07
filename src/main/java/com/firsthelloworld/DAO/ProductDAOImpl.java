/**
 * Project: sportyshoes
 * Package: com.firsthelloworld.DAO
 * Created By: Mehmet Baran Ozkutuk
 */

package com.firsthelloworld.DAO;

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
public class ProductDAOImpl implements ProductDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Shoe> showProducts() {

        Session session = sessionFactory.getCurrentSession();

        Query<Shoe> query = session.createQuery("from Shoe s");

        List<Shoe> shoeList = query.list();

        return shoeList;
    }

    @Override
    public void addProduct(Shoe shoe) {

        Session session = sessionFactory.getCurrentSession();

        session.save(shoe);

    }

    @Override
    public Long updateProduct(Shoe shoe) {

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("update Shoe s set s.name = :name , s.brand = :brand , s.price = :price , s.size = :size where s.id = :id ");
        query.setParameter("name",shoe.getName());
        query.setParameter("brand", shoe.getBrand());
        query.setParameter("price",shoe.getPrice());
        query.setParameter("size",shoe.getSize());
        query.setParameter("id",shoe.getId());

        int row = query.executeUpdate();

        Long l = (long) row;

        return l;
    }

    @Override
    public Long deleteProduct(Long id) {

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("delete from Shoe s where s.id = :id");
        query.setParameter("id",id);

        int i = query.executeUpdate();

        Long l = (long) i;

        return l;
    }

    @Override
    public Shoe getProductById(Long id) {

        Session session = sessionFactory.getCurrentSession();

        Shoe shoe = session.get(Shoe.class, id);

        return shoe;
    }
}
