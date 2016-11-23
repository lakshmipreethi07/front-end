package com.niit.shopping.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.shopping.dao.OrderDAO;
import com.niit.shopping.model.Cart;
import com.niit.shopping.model.Cartitem;
import com.niit.shopping.model.Userorder;

import java.util.List;



@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDAO orderDao;

    @Autowired
    private CartService cartService;

    public void addOrder(Userorder userOrder) {
    	orderDao.addOrder(userOrder);
    }

    public double getOrderGrandTotal(int cartId) {
        double grandTotal=0;
        Cart cart = cartService.getCartById(cartId);
        List<Cartitem> cartItems = cart.getCartItems();

        for (Cartitem item : cartItems) {
            grandTotal+=item.getTotalprice();
        }

        return grandTotal;
    }
}
