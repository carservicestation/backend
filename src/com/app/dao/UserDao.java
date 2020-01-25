package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.*;

@Repository
public class UserDao implements IUserDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public Object validateUser(User u) {
		String jpql = "select u from User u where u.email=:em and u.password=:pass";
		User dbu = sf.getCurrentSession().createQuery(jpql, User.class).setParameter("em", u.getEmail())
				.setParameter("pass", u.getPassword()).getSingleResult();

		if (dbu != null) {
			if (dbu.getRole().equals(Role.CUSTOMER)) 
			{
				String jpql1 = "select c from Customer c where c.email=:em";
				return sf.getCurrentSession().createQuery(jpql1, Customer.class).setParameter("em", u.getEmail()).getSingleResult();
			}
			else if(dbu.getRole().equals(Role.OWNER)) 
			{
				String jpql2 = "select o from Owner o where o.email=:em";
				return sf.getCurrentSession().createQuery(jpql2, Owner.class).setParameter("em", u.getEmail()).getSingleResult();
			}
			else {
				return dbu;
			}
		}
		return null;
	}

	@Override
	public User addUser(User u) {
		System.out.println(u);
		System.out.println("ud");
		sf.getCurrentSession().save(u);
		return u;
	}
}
