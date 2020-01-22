package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.*;

@Repository
@Transactional
public class CustomerDao implements ICustomerDao {
	@Autowired
	private SessionFactory sf;

	@Override
	public Integer addCustomer(Customer c) {

		Integer gcid = (Integer) sf.getCurrentSession().save(c);
		System.out.println("gcid"+gcid);

		User u = new User();
		u.setEmail(c.getEmail());
		u.setPassword(c.getPassword());
		u.setRole(Role.CUSTOMER);
		u.setCustomer(c);

		Integer guid = (Integer) sf.getCurrentSession().save(u);

		System.out.println("guid"+guid);
		return gcid;
	}
	
	@Override
	public void removeCustomer(int cid) {

		Customer c = sf.getCurrentSession().get(Customer.class, cid);
		
		sf.getCurrentSession().remove(c);

	}
	
}
