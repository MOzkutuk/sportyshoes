/**
 * Project: sportyshoes
 * Package: com.firsthelloworld.controller
 * Created By: Mehmet Baran Ozkutuk
 */

package com.firsthelloworld.controller;

import com.firsthelloworld.entity.Customer;
import com.firsthelloworld.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class SignupController {

    @Autowired
    private CustomerService service;

    @GetMapping("/signup")
    public String showLoginPage(@Valid Model model){

        Customer customer = new Customer();
        model.addAttribute("customer",customer);

        return "signup-page";
    }


    @PostMapping("/signup")
    public String checkLoginInformation(@Valid @ModelAttribute("customer") Customer customer,
                                        BindingResult result,
                                        HttpServletRequest request){

        if(result.hasErrors()){
            return "signup-page";
        }else{
            service.addCustomer(customer);

            HttpSession session = request.getSession();
            session.setAttribute("customer",customer);
        }

        return "redirect:/showproducts";
    }

}
