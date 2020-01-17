package com.app.dao;

import com.app.pojos.Customer;
import com.app.pojos.CustomerAddress;

public interface ICustomerDao {
	
	Integer addCustomer(Customer c);

	void addCustomerAddress(int cid, CustomerAddress ca);

	void removeCustomerAddress(int cid, int caid);

	void removeCustomer(int cid);
	
}
