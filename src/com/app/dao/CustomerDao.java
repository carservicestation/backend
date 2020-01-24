package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.*;

@Repository
public class CustomerDao implements ICustomerDao {
	@Autowired
	private SessionFactory sf;

	@Override
	public Customer addCustomer(Customer c) {
		System.out.println("cd");
		c.setRole(Role.CUSTOMER);
		sf.getCurrentSession().save(c);
		return c;
	}
	
	@Override
	public void removeCustomer(int cid) {
		Customer c = sf.getCurrentSession().get(Customer.class, cid);		
		sf.getCurrentSession().remove(c);
	}
}
