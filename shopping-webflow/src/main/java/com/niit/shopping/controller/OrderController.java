package com.niit.shopping.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.shopping.dao.CartDAOImpl;
import com.niit.shopping.model.Cart;
import com.niit.shopping.model.Userdetails;
import com.niit.shopping.model.Userorder;
import com.niit.shopping.service.CartService;
import com.niit.shopping.service.OrderService;


/*
 * This controller is used to handle user order
 */
@Controller
public class OrderController {

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderService orderService;
    
    
    /*
     * 
     * createOrder method is used to insert user order into the database.
     */
    @RequestMapping("/order/{cartId}")
    public String createOrder(@PathVariable("cartId") int cartId) {
    	System.out.println("in order");
    	Userorder userOrder = new Userorder();
        Cart cart=cartService.getCartById(cartId);
        userOrder.setCart(cart);
        Userdetails usersDetail = cart.getUsersDetail();
        userOrder.setUserdetails(usersDetail);
       // userOrder.setBillingAddress(usersDetail.getBillingAddress());
        //userOrder.setShippingAddress(usersDetail.getShippingAddress());

        orderService.addOrder(userOrder);

        return "redirect:/checkout?cartId="+cartId;
    }
}
