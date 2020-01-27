package com.app.dao;

import com.app.pojos.User;

public interface IUserDao {
	Object validateUser(User u);
	User addUser(User u);
	Object changePassword(User u) throws RuntimeException;
}
