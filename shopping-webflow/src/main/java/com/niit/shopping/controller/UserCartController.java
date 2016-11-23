package com.niit.shopping.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shopping.model.Userdetails;
import com.niit.shopping.service.UsersDetailService;


/*
 * This controller is called when user clicks on cart menu or button
 */
@Controller
@RequestMapping("/user/cart")
public class UserCartController {

    @Autowired
    private UsersDetailService usersDetailService;
    
    /*
     * Initially getCart method is called to get user card items from database
     */
    @RequestMapping
    public String getCartItems( Principal username){
    	Userdetails usersDetail = usersDetailService.getUserByUsername(username.getName());
        int cartId = usersDetail.getCart().getCartId();

        return "redirect:/user/cart/"+cartId;
    }
    /*
     * getCartRedirect method is called from getCart method to set retrieved cart from the database.
     */
    @RequestMapping("/{cartId}")
    public String getNewUrl(@PathVariable (value = "cartId") int cartId, Model model) {
        model.addAttribute("cartId", cartId);
        return "cart";
    }

}

