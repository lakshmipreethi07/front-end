package com.niit.shopping.service;

import com.niit.shopping.model.Cart;
import com.niit.shopping.model.Cartitem;

public interface CartItemService {

    void addCartItem(Cartitem cartItem);

    void removeCartItem(Cartitem cartItem);

    void removeAllCartItems(Cart cart);

    Cartitem getCartItemByItemId (int itemId);
}
