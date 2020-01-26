package com.app.dao;

import java.util.List;

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
	public Customer getCustomerById(int cid) {
		return sf.getCurrentSession().get(Customer.class, cid);
	}

	@Override
	public void updateCustomer(Customer c) {
		sf.getCurrentSession().update(c);
	}

	@Override
	public void removeCustomer(int cid) {
		Customer c = sf.getCurrentSession().get(Customer.class, cid);
		sf.getCurrentSession().remove(c);
	}

	@Override
	public List<Customer> getAllCustomers() {
		String jpql = "select c from Customer c";
		return (List<Customer>) sf.getCurrentSession().createQuery(jpql, Customer.class).getResultList();
	}

	@Override
	public void addCustomerAddress(Integer cid, Address ca) {
		Customer c = sf.getCurrentSession().get(Customer.class, cid);
		c.setAddress(ca);
		sf.getCurrentSession().update(c);
	}


}
