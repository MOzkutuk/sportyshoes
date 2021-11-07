/**
 * Project: sportyshoes
 * Package: com.firsthelloworld.service
 * Created By: Mehmet Baran Ozkutuk
 */

package com.firsthelloworld.service;

import com.firsthelloworld.entity.Admin;

import java.util.List;

public interface AdminService {

    boolean checkAdminLogin(String username,String password);
    public Admin findAdminByUserName(String username, String password);
    boolean changeAdminPassword(String password);

}
