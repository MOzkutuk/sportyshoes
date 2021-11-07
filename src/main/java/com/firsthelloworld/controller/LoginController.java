/**
 * Project: sportyshoes
 * Package: com.firsthelloworld.controller
 * Created By: Mehmet Baran Ozkutuk
 */

package com.firsthelloworld.controller;

import com.firsthelloworld.entity.Admin;
import com.firsthelloworld.entity.Customer;
import com.firsthelloworld.service.AdminService;
import com.firsthelloworld.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private CustomerService service;

    @Autowired
    private AdminService adminService;

    @GetMapping("/login")
    public String login( Model model){

        return "login-page";
    }

    @PostMapping("/login")
    public String checkUser(@RequestParam("username") String username,
                            @RequestParam("password")String password,
                            Model model,
                            HttpServletRequest request) throws IllegalAccessException {

        boolean userExist = service.checkCustomerLogin(username,password);
        boolean adminExist = adminService.checkAdminLogin(username, password);

        if(userExist){

            Customer customer = service.findCustomerByUserName(username, password);

            HttpSession session = request.getSession();
            session.setAttribute("customer",customer);

            return "redirect:/showproducts";

        }else if(adminExist) {

            Admin admin = adminService.findAdminByUserName(username, password);

            HttpSession session = request.getSession();
            session.setAttribute("admin",admin);

            return "redirect:/showAdminPanel";

        }else {
            model.addAttribute("usernameError","Username is either not valid or not found");
            model.addAttribute("passwordError","Password is either not valid or not found");
            return "login-page";
        }
    }
}
