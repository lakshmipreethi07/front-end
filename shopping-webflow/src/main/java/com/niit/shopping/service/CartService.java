package com.niit.shopping.service;

import com.niit.shopping.model.Cart;

public interface CartService {

    Cart getCartById (int cartId);

    void update(Cart cart);
}
