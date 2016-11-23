package com.niit.shopping.dao;

import com.niit.shopping.model.BillingAddress;

public interface BillingAddressDAO {

	void saveOrUpdate(BillingAddress billingAddress);


	void deleteBillingAddress(String billingAddressId);

	
BillingAddress getBillingAddress(String billingAddressId);

}
