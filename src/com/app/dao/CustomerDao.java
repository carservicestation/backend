package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Customer;

@Repository
@Transactional
public class CustomerDao implements ICustomerDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public Integer addCustomer(Customer c) {
		return (Integer)sf.getCurrentSession().save(c);
	}

}
