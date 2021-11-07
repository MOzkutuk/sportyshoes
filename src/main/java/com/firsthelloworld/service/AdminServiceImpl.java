/**
 * Project: sportyshoes
 * Package: com.firsthelloworld.service
 * Created By: Mehmet Baran Ozkutuk
 */

package com.firsthelloworld.service;

import com.firsthelloworld.DAO.AdminDAO;
import com.firsthelloworld.entity.Admin;
import com.firsthelloworld.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDAO adminDAO;

    @Override
    public boolean checkAdminLogin(String username, String password) {

        boolean adminFound = adminDAO.checkAdminLogin(username, password);

        return adminFound;
    }

    @Override
    public Admin findAdminByUserName(String username, String password) {
        List<Admin> admin = adminDAO.findAdminByUserName(username, password);

        Admin theAdmin = null;

        if(!admin.isEmpty() ){
            theAdmin = new Admin();
            for(Admin tempAdmin : admin){

                theAdmin.setName(tempAdmin.getName());
                theAdmin.setLastName(tempAdmin.getLastName());
                theAdmin.setLogin(tempAdmin.getLogin());
                theAdmin.setContactDetails(tempAdmin.getContactDetails());
            }
        }

        return theAdmin;
    }

    @Override
    public boolean changeAdminPassword(String password) {

        boolean isPasswordChanged = false;

        int i = adminDAO.changeAdminPassword(password);

        if(i == 0){
            return isPasswordChanged;
        }else{
            isPasswordChanged = true;
        }

        return isPasswordChanged;
    }
}
