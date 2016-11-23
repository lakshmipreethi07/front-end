package com.niit.shopping.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.niit.shopping.model.Cart;
import com.niit.shopping.model.Cartitem;
import com.niit.shopping.model.Product;
import com.niit.shopping.model.Userdetails;
import com.niit.shopping.service.CartItemService;
import com.niit.shopping.service.CartService;
import com.niit.shopping.service.ProductService;
import com.niit.shopping.service.UsersDetailService;

import java.security.Principal;
import java.util.List;


/*
 *Only for User Role
 *This controller is used to handle rest service calls.
 *All functionality related to user cart is written in this controller.
*/
@Controller
@RequestMapping("/usercart/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private UsersDetailService usersDetailService;

    @Autowired
    private ProductService itemService;

    @RequestMapping("/refreshCart/{cartId}")
    public @ResponseBody
    Cart getCartById (@PathVariable(value = "cartId") int cartId) {
        return cartService.getCartById(cartId);
    }
    /*
     * addItem method is used to add a item in user cart.
     */

    @RequestMapping(value = "/addItem/{id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem (@PathVariable(value ="id") String id, Principal username) {

    	Userdetails usersDetail = usersDetailService.getUserByUsername(username.getName());
        Cart cart = usersDetail.getCart();
        Product item = itemService.getProductById(id);
        List<Cartitem> cartItems = cart.getCartItems();

        for (int i=0; i<cartItems.size(); i++) {
            if(item.getId()==cartItems.get(i).getProduct().getId()){
                Cartitem cartItem = cartItems.get(i);
                cartItem.setPrice(item.getPrice());
                cartItem.setName(item.getName());
                cartItem.setQuantity(cartItem.getQuantity()+1);
                cartItem.setTotalprice(item.getPrice()*cartItem.getQuantity());
                cartItemService.addCartItem(cartItem);

                return;
            }
        }

        Cartitem cartItem = new Cartitem();
        cartItem.setProduct(item);
        cartItem.setQuantity(1);
        cartItem.setPrice(item.getPrice());
        cartItem.setName(item.getName());
       
        cartItem.setTotalprice(item.getPrice()*cartItem.getQuantity());
        cartItem.setCart(cart);
        cartItemService.addCartItem(cartItem);
    }
    /*
     * removeItem method is used to remove a item from user cart.
     */
    @RequestMapping(value = "/removeItem/{id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem (@PathVariable(value = "itemId") int itemId) {
        Cartitem cartItem = cartItemService.getCartItemByItemId(itemId);
        cartItemService.removeCartItem(cartItem);

    }
    /*
     * clearCartItems method is used to remove all items from user cart.
     */
    @RequestMapping(value = "/clearCartItems/{cartId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void clearCartItems(@PathVariable(value = "cartId") int cartId) {
        Cart cart = cartService.getCartById(cartId);
        cartItemService.removeAllCartItems(cart);
    }
}
