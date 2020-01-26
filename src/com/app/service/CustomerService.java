package com.app.service;

import java.util.List;

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
		c.setUser(dbu);
		return cdao.addCustomer(c);	
	}

	@Override
	public Customer getCustomerById(int cid) {
		return cdao.getCustomerById(cid);
	}

	@Override
	public void updateCustomer(Customer c) {
		cdao.updateCustomer(c);
	}
	
	@Override
	public List<Customer> getAllCustomers() {
		return cdao.getAllCustomers();
	}	
	
	@Override
	public void removeCustomer(int cid) {
		cdao.removeCustomer(cid);
	}
	
	@Override
	public void addCustomerAddress(Integer cid, Address ca) {
		cdao.addCustomerAddress(cid, ca);
	}

}
