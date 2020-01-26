package com.app.dao;

import java.util.List;

import com.app.pojos.*;

public interface ICustomerDao {
	
	Customer addCustomer(Customer c);
	void removeCustomer(int cid);
	List<Customer> getAllCustomers();
	void updateCustomer(Customer o);
	Customer getCustomerById(int cid);
	void addCustomerAddress(Integer cid, Address ca);
	
}
