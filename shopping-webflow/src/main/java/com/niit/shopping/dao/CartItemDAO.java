package com.niit.shopping.dao;
import com.niit.shopping.model.Cart;
import com.niit.shopping.model.Cartitem;

public interface CartItemDAO {

    void addCartItem(Cartitem cartItem);

    void removeCartItem(Cartitem cartItem);

    void removeAllCartItems(Cart cart);

    Cartitem getCartItemByItemId (int itemId);

}