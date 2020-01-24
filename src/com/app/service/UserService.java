package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDao;
import com.app.pojos.User;

@Service
@Transactional
public class UserService implements IUserService {
	
	@Autowired
	private IUserDao udao;
	
	@Override
	public Object validateUser(User u) {
		return udao.validateUser(u);
	}
	
	@Override
	public User addUser(User u) {
		return udao.addUser(u);
	}
}
