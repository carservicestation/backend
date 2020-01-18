package com.app.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.app.dao.IOwnerDao;

import com.app.pojos.Owner;
import com.app.pojos.Service;

@RestController
@CrossOrigin
@RequestMapping("/owner")
public class OwnerController {
	
	@Autowired
	private IOwnerDao dao;
	
	@PostConstruct
	public void init() {
		System.out.println("in init " + dao);
	}
	
	@PostMapping("/addowner")
	ResponseEntity<?> addOwner( @RequestBody Owner o)
	{
		return new ResponseEntity<Integer>(dao.addOwner(o), HttpStatus.CREATED);
	}
	
	@GetMapping("/getowner")
	ResponseEntity<?> getOwner( @RequestParam int oid)
	{
		return new ResponseEntity<Owner>(dao.getOwner(oid), HttpStatus.OK);
	}
	
	@GetMapping("/getowners")
	ResponseEntity<?> getAllOwners()
	{
		return new ResponseEntity<List<Owner>>(dao.getAllOwners(), HttpStatus.OK);
	}	

}
