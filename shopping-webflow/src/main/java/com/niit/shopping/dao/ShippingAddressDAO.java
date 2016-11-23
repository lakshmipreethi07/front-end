package com.niit.shopping.dao;

import com.niit.shopping.model.ShippingAddress;

public interface ShippingAddressDAO {

	void saveOrUpdate(ShippingAddress shippingAddress);
	
	void deleteShippingAddress(String shippingAddressId);
	
	ShippingAddress getShippingAddress(String shippingAddressId);
}
