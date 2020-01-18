package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Service;
import com.app.pojos.ServiceCenter;
import com.app.pojos.Vehicle;

@Repository
@Transactional
public class AdminDao implements IAdminDao {

	@Autowired
	private SessionFactory sf;



}
