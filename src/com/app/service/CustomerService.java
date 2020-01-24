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
		System.out.println("css");
		System.out.println(c.toString());
		User u = new User(c.getEmail(), c.getPassword(), Role.CUSTOMER);
		User dbu = udao.addUser(u);
		c.setUser(dbu);
		return cdao.addCustomer(c);	
	}

	@Override
	public void removeCustomer(int cid) {
		cdao.removeCustomer(cid);
	}
}
