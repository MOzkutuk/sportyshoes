/**
 * Project: sportyshoes
 * Package: com.firsthelloworld.DAO
 * Created By: Mehmet Baran Ozkutuk
 */

package com.firsthelloworld.DAO;

import com.firsthelloworld.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> showCustomers();
    void addCustomer(Customer customer);
    int updateCustomer(Customer customer,int id);
    Long deleteCustomer(Long id);
    Customer getCustomerById(int id);
    boolean checkCustomerLogin(String username,String password);
    public List<Customer> findCustomerByUserName(String username,String password);
    public List<Customer> findCustomerByUserName(String username);
    boolean findCustomerByName(String username);
}
