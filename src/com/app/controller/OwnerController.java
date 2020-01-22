package com.app.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.app.dao.*;

import com.app.pojos.*;

@RestController
@CrossOrigin
@RequestMapping("/owner")
public class OwnerController {

	@Autowired
	private IOwnerDao odao;

	@PostConstruct
	public void init() {
		System.out.println("in init " + odao);
	}

	@PostMapping("/addOwner")
	ResponseEntity<?> addOwner(@RequestBody Owner o) {
		return new ResponseEntity<Integer>(odao.addOwner(o), HttpStatus.CREATED);
	}

	@GetMapping("/getOwnerById")
	ResponseEntity<?> getOwnerById(@RequestParam int oid) {
		return new ResponseEntity<Owner>(odao.getOwnerById(oid), HttpStatus.OK);
	}

	@PostMapping("/updateOwner")
	ResponseEntity<?> updateOwner(@RequestBody Owner o) {
		odao.updateOwner(o);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/removeOwner")
	ResponseEntity<?> removeOwner(@RequestParam int oid) {
		odao.removeOwner(oid);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/getAllOwners")/*C*/
	ResponseEntity<?> getAllOwners() {
		return new ResponseEntity<List<Owner>>(odao.getAllOwners(), HttpStatus.OK);
	}
	
	@PostMapping("/addOrUpdateOwnerAddress")
	ResponseEntity<?> addOrUpdateOwnerAddress(@RequestParam int oid, @RequestBody Address oa)
	{
		odao.addOrUpdateOwnerAddress(oid,oa);
		return new ResponseEntity<>( HttpStatus.CREATED);
	}
	
	@GetMapping("/getOwnerAddressById")
	ResponseEntity<?> getOwnerAddressById( @RequestParam int oid)
	{
		return new ResponseEntity<Address>(odao.getOwnerAddressByOwnerId(oid), HttpStatus.OK);
	}
	
	@PostMapping("/removeOwnerAddress")
	ResponseEntity<?> removeOwnerAddress( @RequestParam int oid)
	{
		odao.removeOwnerAddress(oid);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/getServiceCentersByOwner")
	ResponseEntity<?> getServiceCentersByOwner( @RequestParam int oid)
	{
		return new ResponseEntity<List<ServiceCenter>>(odao.getServiceCentersByOwner(oid),HttpStatus.OK);
	}
	

}
