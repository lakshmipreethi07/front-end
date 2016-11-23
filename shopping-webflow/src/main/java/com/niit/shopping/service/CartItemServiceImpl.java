package com.niit.shopping.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.shopping.dao.CartItemDAO;
import com.niit.shopping.model.Cart;
import com.niit.shopping.model.Cartitem;



@Service
public class CartItemServiceImpl implements CartItemService{

    @Autowired
    private CartItemDAO cartItemDao;

    public void addCartItem(Cartitem cartItem) {
        cartItemDao.addCartItem(cartItem);
    }

    public void removeCartItem(Cartitem cartItem) {
        cartItemDao.removeCartItem(cartItem);
    }

    public void removeAllCartItems(Cart cart){
        cartItemDao.removeAllCartItems(cart);
    }

    public Cartitem getCartItemByItemId (int itemId) {
        return cartItemDao.getCartItemByItemId(itemId);
    }
}
