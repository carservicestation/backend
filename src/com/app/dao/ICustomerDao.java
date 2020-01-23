package com.app.dao;

import com.app.pojos.*;

public interface ICustomerDao {
	
	Customer addCustomer(Customer c);
	void removeCustomer(int cid);
	
}
