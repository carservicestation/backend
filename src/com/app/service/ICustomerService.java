package com.app.service;

import com.app.pojos.Customer;

public interface ICustomerService {

	Customer addCustomer(Customer c);
	void removeCustomer(int cid);	
}
