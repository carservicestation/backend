package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.pojos.User;
import com.app.service.IUserService;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService us;

	@PostMapping(value = "/validate", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> validateUser(@RequestBody User u) {

		try {
			return new ResponseEntity<Object>(us.validateUser(u), HttpStatus.OK);// return object
		}
		catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(null, HttpStatus.NOT_FOUND);// return null }
		}
	}

	@PostMapping("/changePassword")
	public ResponseEntity<?> changePassword(@RequestBody User u) 
	{
		try {
			return new ResponseEntity<Object>(us.changePassword(u), HttpStatus.OK);
		} catch (RuntimeException e) {
			String msg = "Password is wrong";
			e.printStackTrace();
			return new ResponseEntity<String>(msg, HttpStatus.NOT_FOUND);
		}
	}
}
