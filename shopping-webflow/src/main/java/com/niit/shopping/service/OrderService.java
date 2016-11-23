package com.niit.shopping.service;

import com.niit.shopping.model.Userorder;

public interface OrderService {

    void addOrder(Userorder order);

    double getOrderGrandTotal(int cartId);
}
