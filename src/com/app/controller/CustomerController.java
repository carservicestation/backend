package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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
		System.out.println(c.toString());
		System.out.println("in cs");
		return new ResponseEntity<Customer>(cs.addCustomer(c), HttpStatus.CREATED);
	}
	
	@PostMapping("/getCustomerById/{cid}")
	ResponseEntity<?> getCustomerById( @PathVariable Integer cid )
	{
		cs.getCustomerById(cid);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/addCustomerAddress/{cid}")
	ResponseEntity<?> addCustomerAddress(@PathVariable Integer cid, @RequestBody Address ca) {
		cs.addCustomerAddress(cid, ca);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PostMapping(value="/updateCustomer", consumes = "application/json", produces = "application/json")
	ResponseEntity<?> updateCustomer( @RequestBody Customer c)
	{
		cs.updateCustomer(c);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
