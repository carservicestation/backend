package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.*;
import com.app.service.ICustomerService;

@CrossOrigin
@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private ICustomerService cs;
	
	@PostMapping("/addCustomer")
	ResponseEntity<?> addCustomer( @RequestBody Customer c)
	{
	    //cust using
		return new ResponseEntity<Customer>(cs.addCustomer(c), HttpStatus.CREATED);
	}
	
	@GetMapping("/getCustomerById/{cid}")
	ResponseEntity<?> getCustomerById( @PathVariable Integer cid )
	{
	    //cust using
		return new ResponseEntity<Customer>(cs.getCustomerById(cid),HttpStatus.OK);
	}
	
	@PostMapping("/addCustomerAddress/{cid}")
	ResponseEntity<?> addCustomerAddress(@PathVariable Integer cid, @RequestBody Address ca) {
	    //cust using
		cs.addCustomerAddress(cid, ca);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PostMapping(value="/updateCustomer", consumes = "application/json", produces = "application/json")
	ResponseEntity<?> updateCustomer( @RequestBody Customer c)
	{
	    //cust using
		cs.updateCustomer(c);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/removeCustomer/{cid}")
	ResponseEntity<?> removeCustomer( @PathVariable Integer cid)
	{
	    //admin using
		cs.removeCustomer(cid);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/getAllCustomers")
	ResponseEntity<?> getAllCustomers()
	{
	    //admin using
		return new ResponseEntity<List<Customer>>(cs.getAllCustomers(), HttpStatus.OK);
	}
}
