package com.app.dao;

import com.app.pojos.*;

public interface ICustomerDao {
	
	Integer addCustomer(Customer c);
	void removeCustomer(int cid);
	
}
