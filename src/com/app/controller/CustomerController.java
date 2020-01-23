package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.*;
import com.app.service.ICustomerService;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private ICustomerService cs;
	
	@PostMapping("/addCustomer")
	ResponseEntity<?> addCustomer( @RequestBody Customer c)
	{
		return new ResponseEntity<Customer>(cs.addCustomer(c), HttpStatus.CREATED);
	}
}
