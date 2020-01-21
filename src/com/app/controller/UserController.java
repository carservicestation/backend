package com.app.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.dao.IUserDao;
import com.app.pojos.Role;
import com.app.pojos.User;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserDao dao;

	@PostConstruct
	public void init() {
		System.out.println("in init of UserController");
	}

	@PostMapping("/validate")
	public ResponseEntity<?> validateUser(@RequestBody User u) {

		User validUser = null;
		try 
		{
			validUser = dao.validateUser(u);
			System.out.println(u);
			return new ResponseEntity<User>(validUser, HttpStatus.OK);// return object
		}
		
		catch (RuntimeException e) 
		{
			//e.printStackTrace();
			return new ResponseEntity<User>(validUser, HttpStatus.NOT_FOUND);// return null
		}
	}
	
		

}
