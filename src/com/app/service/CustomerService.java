package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.*;
import com.app.pojos.*;

@Service
@Transactional
public class CustomerService implements ICustomerService {

	@Autowired
	private ICustomerDao cdao;
	@Autowired
	private IUserDao udao;
	
	@Override
	public Customer addCustomer(Customer c)
	{
		User u = new User(c.getEmail(), c.getPassword(), Role.CUSTOMER);
		User dbu = udao.addUser(u);
		c.setUser(u);
		return cdao.addCustomer(c);	
	}
	
	
}
