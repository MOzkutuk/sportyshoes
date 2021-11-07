/**
 * Project: sportyshoes
 * Package: com.firsthelloworld.service
 * Created By: Mehmet Baran Ozkutuk
 */

package com.firsthelloworld.service;

import com.firsthelloworld.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> showCustomers();
    void addCustomer(Customer customer);
    int updateCustomer(Customer customer,int id);
    Long deleteCustomer(Long id);
    Customer getCustomerById(int id);
    boolean checkCustomerLogin(String username,String password) throws IllegalAccessException;
    public Customer findCustomerByUserName(String username,String password);
    public Customer findCustomerByUserName(String username);
    boolean findCustomerByName(String username);


}
