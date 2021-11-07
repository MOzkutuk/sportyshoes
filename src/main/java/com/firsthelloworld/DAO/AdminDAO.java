/**
 * Project: sportyshoes
 * Package: com.firsthelloworld.DAO
 * Created By: Mehmet Baran Ozkutuk
 */

package com.firsthelloworld.DAO;

import com.firsthelloworld.entity.Admin;
import com.firsthelloworld.entity.Customer;

import java.util.List;

public interface AdminDAO {

    boolean checkAdminLogin(String username,String password);
    public List<Admin> findAdminByUserName(String username, String password);
    int changeAdminPassword(String password);

}
