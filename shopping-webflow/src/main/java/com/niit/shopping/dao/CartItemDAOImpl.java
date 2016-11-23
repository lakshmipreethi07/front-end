package com.niit.shopping.dao;


import com.niit.shopping.model.Cart;
import com.niit.shopping.model.Cartitem;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class CartItemDAOImpl implements CartItemDAO{

    @Autowired
    private SessionFactory sessionFactory;

    public void addCartItem(Cartitem cartItem) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cartItem);
        session.flush();
    }

    public void removeCartItem (Cartitem cartItem) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(cartItem);
        session.flush();
    }

    public void removeAllCartItems(Cart cart) {
        List<Cartitem> cartItems = cart.getCartItems();

        for (Cartitem item : cartItems) {
            removeCartItem(item);
        }
    }

    public Cartitem getCartItemByItemId (int itemId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CartItem where itemId = ?");
        query.setInteger(0, itemId);
        session.flush();

        return (Cartitem) query.uniqueResult();
    }
}
