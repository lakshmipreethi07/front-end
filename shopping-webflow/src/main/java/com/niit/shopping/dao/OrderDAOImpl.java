package com.niit.shopping.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shopping.model.Cart;
import com.niit.shopping.model.Cartitem;
import com.niit.shopping.model.Userorder;



@Repository
@Transactional
public class OrderDAOImpl implements OrderDAO{

        @Autowired
        private SessionFactory sessionFactory;
        
        @Autowired
        CartDAO cartDAO;

        public void addOrder(Userorder userOrder) {
            Session session = sessionFactory.getCurrentSession();
            session.saveOrUpdate(userOrder);
            session.flush();
        }
        
        public double getOrderGrandTotal(int cartId) {
            double grandTotal=0;
            Cart cart = cartDAO.getCartById(cartId);
            List<Cartitem> cartItems = cart.getCartItems();

            for (Cartitem item : cartItems) {
                grandTotal+=item.getTotalprice();
            }

            return grandTotal;
        }
}
