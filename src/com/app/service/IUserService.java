package com.app.service;

import com.app.pojos.User;

public interface IUserService {

	Object validateUser(User u);

	User addUser(User u);

}
