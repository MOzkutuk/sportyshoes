/**
 * Project: sportyshoes
 * Package: com.firsthelloworld.service
 * Created By: Mehmet Baran Ozkutuk
 */

package com.firsthelloworld.service;

import com.firsthelloworld.DAO.CustomerDAO;
import com.firsthelloworld.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    public List<Customer> showCustomers() {
        return customerDAO.showCustomers();
    }

    @Override
    public void addCustomer(Customer customer) {
        customerDAO.addCustomer(customer);
    }

    @Override
    public int updateCustomer(Customer customer,int id) {
      return customerDAO.updateCustomer(customer,id);
    }

    @Override
    public Long deleteCustomer(Long id) {

        return customerDAO.deleteCustomer(id);
    }

    @Override
    public Customer getCustomerById(int id) {
        return customerDAO.getCustomerById(id);
    }

    @Override
    public boolean checkCustomerLogin(String username,String password) throws IllegalAccessException {

        boolean customerFound = customerDAO.checkCustomerLogin(username,password);
/*
        if(customers.isEmpty() ){
            throw new IllegalAccessException();
        }
 */
        return customerFound;
    }

    @Override
    public Customer findCustomerByUserName(String username, String password) {

        List<Customer> customer = customerDAO.findCustomerByUserName(username, password);

        Customer theCustomer = null;

        if(!customer.isEmpty() ){
            theCustomer = new Customer();
            for(Customer tempCustomer : customer){

                theCustomer.setName(tempCustomer.getName());
                theCustomer.setSurname(tempCustomer.getSurname());
                theCustomer.setCart(tempCustomer.getCart());
                theCustomer.setLogin(tempCustomer.getLogin());
                theCustomer.setContactDetails(tempCustomer.getContactDetails());
                theCustomer.setPhone(tempCustomer.getPhone());
                theCustomer.setId(tempCustomer.getId());
            }
        }

        return theCustomer;
    }

    @Override
    public Customer findCustomerByUserName(String username) {

        List<Customer> customer = customerDAO.findCustomerByUserName(username);

        Customer theCustomer = null;

        if(!customer.isEmpty() ){
            theCustomer = new Customer();
            for(Customer tempCustomer : customer){

                theCustomer.setName(tempCustomer.getName());
                theCustomer.setSurname(tempCustomer.getSurname());
                theCustomer.setCart(tempCustomer.getCart());
                theCustomer.setLogin(tempCustomer.getLogin());
                theCustomer.setContactDetails(tempCustomer.getContactDetails());
                theCustomer.setPhone(tempCustomer.getPhone());
                theCustomer.setId(tempCustomer.getId());
            }
        }

        return theCustomer;
    }

    @Override
    public boolean findCustomerByName(String username) {

       boolean theCustomerFound = customerDAO.findCustomerByName(username);

        return theCustomerFound;
    }
}
