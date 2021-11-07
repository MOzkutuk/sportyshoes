/**
 * Project: sportyshoes
 * Package: com.firsthelloworld.controller
 * Created By: Mehmet Baran Ozkutuk
 */

package com.firsthelloworld.controller;

import com.firsthelloworld.entity.Admin;
import com.firsthelloworld.entity.Customer;
import com.firsthelloworld.entity.Shoe;
import com.firsthelloworld.service.AdminService;
import com.firsthelloworld.service.CustomerService;
import com.firsthelloworld.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Comparator;
import java.util.List;

@Controller
public class AdminPanelController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AdminService adminService;

    @GetMapping("/showAdminPanel")
    public String showAdminPanel(Model model){

        List<Shoe> shoes = productService.showProducts();
        model.addAttribute("shoes",shoes);

        return "adminpanel";
    }

    @GetMapping("/showAddProductPage")
    public String showAddProductPage(@Valid Model model){

        Shoe shoe = new Shoe();
        model.addAttribute("shoe",shoe);

        return "addproduct-page";
    }

    @PostMapping("/addProduct")
    public String addProduct(@Valid @ModelAttribute("shoe") Shoe shoe,
                             BindingResult result){

        if(result.hasErrors()){
            return "addproduct-page";
        }else{
            if(shoe.getId() == null){
                productService.addProduct(shoe);
            }else{
                productService.updateProduct(shoe);
            }
        }

        return "redirect:/showAdminPanel";
    }

    @GetMapping("/deleteProduct")
    public String deleteProduct(@RequestParam("id") Long id,Shoe shoe){

        productService.deleteProduct(id);

        return "redirect:/showAdminPanel";
    }

    @GetMapping("/updateProduct")
    public String updateProduct(@RequestParam("id") Long id,Model model){

        Shoe productById = productService.getProductById(id);

        System.out.println(productById);

        model.addAttribute("shoe",productById);

        return "addproduct-page";
    }

    @GetMapping("/showUsers")
    public String getUsers(Model model){

        List<Customer> customers = customerService.showCustomers();

        model.addAttribute("customerList",customers);

        return "user-collection";
    }

    @GetMapping("/searchUser")
    public String searchUserPage(){

        return "search-user";
    }

    @PostMapping("/searchUser")
    public String searchUser(@RequestParam("username")String username,Model model){

        boolean userExist = customerService.findCustomerByName(username);
        if(userExist){

            Customer customer = customerService.findCustomerByUserName(username);
            model.addAttribute("customer",customer);

            return "redirect:/showUsers";

        }else{
            model.addAttribute("usernameError","No user is found");
            return "user-collection";
        }
    }

    @GetMapping("/deleteUser")
    public String deleteUserData(@RequestParam("id") Long id){

        Long deleteCustomer = customerService.deleteCustomer(id);

        return "user-collection";
    }

    @GetMapping("/categorizeProductByName")
    public String categorizeByName(Model model){

        List<Shoe> shoes = productService.showProducts();

        model.addAttribute("shoes",shoes);

        //sorting by name
        if (shoes.size() > 0) {
            shoes.sort(new Comparator<Shoe>() {
                @Override
                public int compare(final Shoe object1, final Shoe object2) {
                    return object1.getName().compareTo(object2.getName());
                }
            });
            model.addAttribute("products",shoes);
        }
        return "adminpanel";
    }

    @GetMapping("/categorizeProductById")
    public String categorizeById(Model model){

        List<Shoe> shoes = productService.showProducts();

        if(!shoes.isEmpty()){
            shoes.sort(Comparator.comparingLong(Shoe::getId));
        }

        model.addAttribute("shoes",shoes);

        return "adminpanel";
    }

    @GetMapping("/categorizeProductByPrice")
    public String categorizeByPrice(Model model){

        List<Shoe> shoes = productService.showProducts();

        if(!shoes.isEmpty()){
            shoes.sort(new Comparator<Shoe>() {
                public int compare(Shoe shoe1, Shoe shoe2) {
                    return Integer.parseInt(shoe1.getPrice()) - Integer.parseInt(shoe2.getPrice());
                }
            });
        }

        model.addAttribute("shoes",shoes);

        return "adminpanel";
    }

    @GetMapping("/changePassword")
    public String changeAdminPassword(){

        return "changePassword-page";
    }

    @PostMapping("/changePassword")
    public String changeAdminPassword(@RequestParam("password")String password, Model model, HttpSession session){

        boolean isPasswordChanged = adminService.changeAdminPassword(password);

        if(isPasswordChanged){

            Admin admin = (Admin) session.getAttribute("admin");

            return "adminpanel";
        }else {
            model.addAttribute("notSaved","We couldn't saved your password, please check again");
            return "changePassword-page";
        }

    }

    @GetMapping("/showPurchaseReport")
    public String getPurchaseHistory(){

        return null;
    }
}
