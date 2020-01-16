package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Service;


@Repository
@Transactional
public class ServiceDao implements IServiceDao {
	
	@Autowired
	private SessionFactory sf;

	@Override
	public Integer addService(Service s) {
		
		return (Integer) sf.getCurrentSession().save(s);
	}

}
