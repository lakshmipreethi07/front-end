package com.niit.shopping.dao;

import com.niit.shopping.model.Userorder;

public interface OrderDAO {

    void addOrder(Userorder userOrder);
    
    double getOrderGrandTotal(int cartId);
}
