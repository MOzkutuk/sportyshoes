/**
 * Project: sportyshoes
 * Package: com.firsthelloworld.DAO
 * Created By: Mehmet Baran Ozkutuk
 */

package com.firsthelloworld.DAO;

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
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> showCustomers() {

        Session currentSession = sessionFactory.getCurrentSession();

        Query<Customer> query = currentSession.createQuery("FROM Customer ", Customer.class);

        List<Customer> customerList = query.list();

        return customerList;
    }

    @Override
    public void addCustomer(Customer customer) {

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.save(customer);
    }

    @Override
    public int updateCustomer(Customer customer, int id) {

        Session currentSession = sessionFactory.getCurrentSession();

        Query query = currentSession.createQuery("update Customer c set c.name = :name , c.surname = :surname ," +
                " c.login.username = :username , c.login.password = :password , c.phone.countryCode = :countrycode ," +
                " c.phone.mobileNumber = :mobilenumber, c.contactDetails.addressLine1 = :line1 , c.contactDetails.addressLine2 = :line2," +
                " c.contactDetails.city = :city, c.contactDetails.country = :country , c.contactDetails.postalCode = :postcode ," +
                " c.contactDetails.emailAddress = :email where c.id = :id");

        query.setParameter("name", customer.getName());
        query.setParameter("surname", customer.getSurname());
        query.setParameter("username", customer.getLogin().getUsername());
        query.setParameter("password", customer.getLogin().getPassword());
        query.setParameter("countrycode", customer.getPhone().getCountryCode());
        query.setParameter("mobilenumber", customer.getPhone().getMobileNumber());
        query.setParameter("line1", customer.getContactDetails().getAddressLine1());
        query.setParameter("line2", customer.getContactDetails().getAddressLine2());
        query.setParameter("city", customer.getContactDetails().getCity());
        query.setParameter("country", customer.getContactDetails().getCountry());
        query.setParameter("postcode", customer.getContactDetails().getPostalCode());
        query.setParameter("email", customer.getContactDetails().getPostalCode());
        query.setParameter("id", id);

        int row = query.executeUpdate();

        return row;
    }

    @Override
    public Long deleteCustomer(Long id) {

        Session currentSession = sessionFactory.getCurrentSession();

        Query query = currentSession.createQuery("DELETE from Customer c WHERE c.id = :id");
        query.setParameter("id",id);

        int row = query.executeUpdate();

        long l = row;

        if (row <= 0) {
            // throw new custom exception
        }

        return l;
    }

    @Override
    public Customer getCustomerById(int id) {

        Session currentSession = sessionFactory.getCurrentSession();

        Customer customer = currentSession.get(Customer.class, id);

        if (customer.getId() == 0) {

            return new Customer();
        }

        return customer;
    }

    @Override
    public boolean checkCustomerLogin(String username, String password) {

        Session currentSession = sessionFactory.getCurrentSession();

        boolean userFound = false;

        Query<Customer> query = currentSession.createQuery("FROM Customer c where c.login.username = :username and c.login.password = :password");

        query.setParameter("username", username);
        query.setParameter("password", password);

        List<Customer> customerList = query.list();

        if ((customerList != null) && (customerList.size() > 0)) {
            userFound = true;
        }

        return userFound;
    }

    @Override
    public List<Customer> findCustomerByUserName(String username, String password) {


        Session session = sessionFactory.getCurrentSession();

        Query<Customer> query = session.createQuery("FROM Customer c where c.login.username = :username and c.login.password = :password");

        query.setParameter("username", username);
        query.setParameter("password", password);

        List<Customer> customers = query.list();

        return customers;
    }

    @Override
    public List<Customer> findCustomerByUserName(String username) {


        Session session = sessionFactory.getCurrentSession();

        Query<Customer> query = session.createQuery("FROM Customer c where c.login.username = :username");

        query.setParameter("username", username);

        List<Customer> customers = query.list();

        return customers;
    }

    @Override
    public boolean findCustomerByName(String username) {

        Session session = sessionFactory.getCurrentSession();

        boolean userFound = false;

        Query<Customer> query = session.createQuery("from Customer c where c.login.username = :username");

        query.setParameter("username", username);

        List<Customer> customerList = query.list();

        if ((customerList != null) && (customerList.size() > 0)) {
            userFound = true;
        }

        return userFound;
    }
}


