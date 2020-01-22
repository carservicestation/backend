package com.app.dao;

import com.app.pojos.*;

public interface ICustomerDao {
	
	Integer addCustomer(Customer c);

	void addCustomerAddress(int cid, Address ca);

	void removeCustomerAddress(int cid, int caid);

	void removeCustomer(int cid);
	
}
