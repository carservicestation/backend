package com.app.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.ICustomerDao;
import com.app.pojos.Customer;
import com.app.pojos.CustomerAddress;
import com.app.pojos.Owner;
import com.app.pojos.OwnerAddress;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private ICustomerDao cdao;
	
	@PostConstruct
	public void init() {
		System.out.println("in init " + cdao);
	}
	
	@PostMapping("/addcustomer")
	ResponseEntity<?> addCustomer( @RequestBody Customer c)
	{
		return new ResponseEntity<Integer>(cdao.addCustomer(c), HttpStatus.CREATED);
	}
	
	@PostMapping("/addcustomeraddress")
	ResponseEntity<?> addCustomerAddress(@RequestBody CustomerAddress ca)
	{
		return null; //new ResponseEntity<Integer>(dao.addCustomerAddress(ca), HttpStatus.CREATED);
	}
/*
	@GetMapping("/getcustomerbyid")
	ResponseEntity<?> getOwner(@RequestParam int cid) {
		return new ResponseEntity<Owner>(cdao.getOwnerById(cid), HttpStatus.OK);
	}

	@PostMapping("/updateowner")
	ResponseEntity<?> updateOwner(@RequestBody Owner o) {
		odao.updateOwner(o);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/removeowner")
	ResponseEntity<?> removeOwner(@RequestParam int oid) {
		odao.removeOwner(oid);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/addorupdateowneraddress")
	ResponseEntity<?> addOrUpdateOwnerAddress(@RequestParam int oid, @RequestBody OwnerAddress oa)
	{
		odao.addOrUpdateOwnerAddress(oid,oa);
		return new ResponseEntity<>( HttpStatus.CREATED);
	}
	
	@GetMapping("/getowneraddressbyoid")
	ResponseEntity<?> getOwnerAddress( @RequestParam int oid)
	{
		return new ResponseEntity<OwnerAddress>(odao.getOwnerAddress(oid), HttpStatus.OK);
	}
	
	@PostMapping("/removeowneraddress")
	ResponseEntity<?> removeOwnerAddress( @RequestParam int oid)
	{
		odao.removeOwnerAddress(oid);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/getowners")
	ResponseEntity<?> getAllOwners() {
		return new ResponseEntity<List<Owner>>(odao.getAllOwners(), HttpStatus.OK);
	}
	
	*/

}
