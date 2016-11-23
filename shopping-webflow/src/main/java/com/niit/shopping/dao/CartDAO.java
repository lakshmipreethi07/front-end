package com.niit.shopping.dao;


import java.io.IOException;

import com.niit.shopping.model.Cart;


public interface CartDAO {

    Cart getCartById (int cartId);

    Cart validate(int cartId) throws IOException;

    void update(Cart cart);
}
