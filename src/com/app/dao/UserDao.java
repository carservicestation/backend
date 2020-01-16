package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.User;

@Repository
public class UserDao implements IUserDao {
	
	@Autowired
	private SessionFactory sf;

	@Override
	public User validateUser(User u) {

		String jpql = "select u from User u where u.email=:em and u.password=:pass";
		
		return sf.getCurrentSession().createQuery(jpql, User.class).setParameter("em", u.getEmail()).setParameter("pass", u.getPassword()).getSingleResult();
	
	}
	
	

}
