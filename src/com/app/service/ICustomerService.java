package com.app.service;

import java.util.List;

import com.app.pojos.Address;
import com.app.pojos.Customer;

public interface ICustomerService {

	Customer addCustomer(Customer c);
	void removeCustomer(int cid);
	List<Customer> getAllCustomers();
	void updateCustomer(Customer o);
	Customer getCustomerById(int cid);
	void addCustomerAddress(Integer cid, Address ca);
}
