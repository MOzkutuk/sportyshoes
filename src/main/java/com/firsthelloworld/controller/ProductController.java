/**
 * Project: sportyshoes
 * Package: com.firsthelloworld.controller
 * Created By: Mehmet Baran Ozkutuk
 */

package com.firsthelloworld.controller;

import com.firsthelloworld.entity.Cart;
import com.firsthelloworld.entity.Customer;
import com.firsthelloworld.entity.Order;
import com.firsthelloworld.entity.Shoe;
import com.firsthelloworld.service.CartService;
import com.firsthelloworld.service.OrderService;
import com.firsthelloworld.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/showproducts")
    public String showProducts(Model model) {

        List<Shoe> shoeList = productService.showProducts();

        model.addAttribute("shoeList", shoeList);

        return "products-page";
    }

    @GetMapping("/showOnlyProducts")
    public String showOnlyProducts(Model model){

        List<Shoe> shoeList = productService.showProducts();

        model.addAttribute("shoeList", shoeList);

        return "products-page-fake";
    }

    @GetMapping("/addProductToBasket")
    public String addProductToCart(@RequestParam("id") Long id, Model model, HttpSession session) {

        List<Shoe> customerShoes = new ArrayList<>();

        Customer customer = (Customer) session.getAttribute("customer");

        //getting customer's cart
        Cart cart = cartService.getCartById(customer.getCart().getId());

        //getting shoe from products-page.jsp
        Shoe productById = productService.getProductById(id);

        //adding shoe to arraylist and setting it as cart's list
       customerShoes.add(productById);
       cart.setShoes(customerShoes);

        return "products-page";
    }

    @GetMapping("/showCart")
    public String showCartItems(Model model,HttpSession session){

        Customer customer = (Customer) session.getAttribute("customer");

        try{
            List<Shoe> customerShoes = customer.getCart().getShoes();

            if(!customerShoes.isEmpty()){
                customerShoes.sort(Comparator.comparingLong(Shoe::getId));
            }

            model.addAttribute("customerShoes",customerShoes);

        }catch (NullPointerException exception){
            model.addAttribute("cartError","Looks like your carts is empty, try buying things first");
            return "customer-items";
        }

        return "customer-items";
    }

    @PostMapping("/showCart")
    public String makePurchase(Order order, Model model, HttpSession session){

        Customer customer = (Customer) session.getAttribute("customer");
        List<Shoe> customerShoes = customer.getCart().getShoes();
        model.addAttribute("items",customerShoes);
        orderService.makePurchase(order);

        customerShoes.removeAll(customerShoes);

        return "customer-items";
    }


    @GetMapping("/removeItem")
    public String removeProductFromCart(@RequestParam("id") Long id,Model model, HttpSession session){

        Customer customer = (Customer) session.getAttribute("customer");

        boolean remove = customer.getCart().getShoes().remove(id);

        if(remove){
            model.addAttribute("successfulRemoval","Item is removed successfully");
        }

        return "customer-items";
    }
}
